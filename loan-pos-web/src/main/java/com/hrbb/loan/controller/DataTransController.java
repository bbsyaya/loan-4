/**
 * 
 *	哈尔滨银行
 * Copyright (c) 2007-2015 HRBB,Inc.All Rights Reserved.
 */
package com.hrbb.loan.controller;

import java.io.File;
import java.io.FileInputStream;
import java.io.InputStreamReader;
import java.io.Reader;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.multipart.MultipartFile;
import org.springframework.web.servlet.ModelAndView;

import com.hrbb.loan.pos.biz.backstage.inter.DataTransBiz;
import com.hrbb.loan.pos.util.StringUtil;

/**
 * 
 * @author marco
 * @version $Id: DataTransController.java, v 0.1 2015-8-7 下午6:22:05 marco Exp $
 */
@Controller
@RequestMapping("/dataTrans")
public class DataTransController {

	private Logger logger = LoggerFactory.getLogger(DataTransController.class);

	@Autowired
	@Qualifier("dataTransBiz")
	private DataTransBiz biz;

	/**
	 * 上传模型结果文件
	 */
	@RequestMapping("/uploadDataTrans")
	public ModelAndView uploadModelResult(
			@RequestParam(value = "uploadFile", required = false) MultipartFile multipartFile)
			throws Exception {

		logger.debug("uploadModelResult begin");
		ModelAndView mav = new ModelAndView();
		mav.setViewName("dataTrans/dataTrans");
		if (multipartFile.isEmpty()) {
			mav.addObject("result", "文件不能为空");
			return mav;
		}
		String fileName = multipartFile.getOriginalFilename();
		File file = new File(fileName);
		logger.debug("fileName=" + fileName);
		Reader reader = null;
		StringBuilder sb = new StringBuilder();
		try {
			multipartFile.transferTo(file);
			logger.debug("取得文件成功，开始读取...");
			// 一次读一个字符
			reader = new InputStreamReader(new FileInputStream(file), "utf-8");
			int tempchar;
			while ((tempchar = reader.read()) != -1) {
				sb.append((char) tempchar);
			}
			logger.debug("读取结束");
			reader.close();
			// 删除临时文件
			if (file.exists()) {
				file.delete();
			}
		} catch (Exception e) {
			logger.error("上传文件出错", e);
			mav.addObject("result", "上传文件出错。");
		}
		if (StringUtil.isNotEmpty(sb.toString())) {
			String msg = biz.DataTrans(sb.toString());
			mav.addObject("result", msg);
		} else {
			mav.addObject("result", "文件内没有数据。");
		}
		logger.debug("uploadModelResult end");
		return mav;
	}
}
