package com.hrbb.loan.pos.util;

import java.io.DataInputStream;
import java.io.DataOutputStream;
import java.io.FileOutputStream;
import java.net.HttpURLConnection;
import java.net.URL;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

public class HttpUtil {
	
	private static Logger logger = LoggerFactory.getLogger(HttpUtil.class);
	
	public static boolean getHttpFile(String strUrl, String destFile){
		HttpURLConnection conn = null;
		DataInputStream input = null;
		DataOutputStream output = null;
		try{
			URL url = new URL(strUrl); 
			conn = (HttpURLConnection) url.openConnection(); 
			input = new DataInputStream(conn.getInputStream()); 
			output = new DataOutputStream(new FileOutputStream(destFile)); 
			byte[] buffer = new byte[1024 * 8]; 
			int count = 0; 
			while ((count = input.read(buffer)) > 0) { 
				output.write(buffer, 0, count); 
			} 
			return true;
		}catch(Exception e){
			logger.error("拉取征信报告发生异常", e);
			return false;
		}finally{
			try{
				if(output != null){
					output.close();
				}
				
			}catch(Exception e){
				logger.error("关闭输出流异常", e);
			}
			try{
				if(input != null){
					input.close();
				}
				
			}catch(Exception e){
				logger.error("关闭输入流异常", e);
			}
			if(conn != null){
				conn.disconnect();				
			}
		}

	}
	
}
