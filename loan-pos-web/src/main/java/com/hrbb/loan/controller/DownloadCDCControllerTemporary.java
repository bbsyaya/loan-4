package com.hrbb.loan.controller;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.io.InputStream;
import java.io.OutputStream;
import java.io.PrintWriter;
import java.io.UnsupportedEncodingException;
import java.util.ArrayList;
import java.util.Calendar;
import java.util.Date;
import java.util.List;

import javax.annotation.PostConstruct;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

import com.alibaba.fastjson.JSON;
import com.hrbb.loan.pos.factory.SysConfigFactory;
import com.hrbb.loan.pos.util.DateUtil;

@Controller
@RequestMapping("/downloadCDC")
public class DownloadCDCControllerTemporary {
	private Logger logger = LoggerFactory.getLogger(DownloadCDCControllerTemporary.class);

//	@Value("#{systemInfo[cdc_realtimeUrl]}")
	private String cdc_realtimeUrl;
	
	@PostConstruct
	public void loadDictionary() {
		cdc_realtimeUrl = SysConfigFactory.getInstance().getService("cdcService").getPropertyValue("filePath");
	}
	
	@RequestMapping("/download")
	public String download(@RequestParam(value="fileName",required=false)String fileName, 
			HttpServletRequest request,
			HttpServletResponse response) throws UnsupportedEncodingException  {
		  
		request.setCharacterEncoding("UTF-8");  
		String fileNameString = new String(fileName.getBytes("gbk"),"ISO8859-1");
		String pathString = cdc_realtimeUrl;
		try {
			File file = new File(pathString+File.separator+fileName);
			if (file.exists()) {
				response.reset();
				response.setContentType("application/octet-stream;charset=UTF-8");
				response.setHeader("Content-Disposition", "attachment;fileName="+fileNameString);
				InputStream inputStream = new FileInputStream(file);
				OutputStream os = response.getOutputStream();
	            byte[] b = new byte[2048];
	            int length;
	            while ((length = inputStream.read(b)) > 0) {
	                os.write(b, 0, length);
	            }
	             // 这里主要关闭。
	            os.close();
	            inputStream.close();
			} else {
				if (!file.getParentFile().exists()) {
					// 如果目标文件所在的目录不存在，则创建父目录
					logger.info("目标文件所在目录不存在，准备创建它！");
					if (!file.getParentFile().mkdirs()) {
						logger.info("创建目标文件所在目录失败！");
					}
				}
			}
		} catch (FileNotFoundException e) {
//            e.printStackTrace();
			logger.error("CDC文件不存在",e);
        } catch (IOException e) {
//			e.printStackTrace();
        	logger.error("CDC文件读取失败 ",e);
		}
	
		return null;

	}
	
	@RequestMapping("/downloadBatch")
	public String getFileName(PrintWriter out){
		List<String> fileNameList = new ArrayList<String>();
		fileNameList.add(getBatchFileNameList("repay_"));
		fileNameList.add(getBatchFileNameList("payin_"));
		out.print(JSON.toJSONString(fileNameList));
		return null;
	}
	public String getBatchFileNameList(String fileName){
		Calendar calendar = Calendar.getInstance();
	   	String batchFileName = null;
	   	String fileNameString = null;
		for (int i = 0; i < 5; i++) {
			calendar.add(Calendar.DAY_OF_MONTH, -1);
			Date date = calendar.getTime();
			fileNameString = fileName + DateUtil.getDateToString1(date) + ".csv";
			File file = new File(cdc_realtimeUrl + File.separator + fileNameString);
			if (file.exists()) {
				batchFileName = fileNameString;
				break;
			}else {
				if (!file.getParentFile().exists()) {
					// 如果目标文件所在的目录不存在，则创建父目录
					logger.info("目标文件所在目录不存在，准备创建它！");
					if (!file.getParentFile().mkdirs()) {
						logger.info("创建目标文件所在目录失败！");
					}
				}
			}
		}
		return batchFileName;
	}
}
