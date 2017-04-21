package com.hrbb.test;

import static org.junit.Assert.*;

import java.io.BufferedInputStream;
import java.io.BufferedReader;
import java.io.DataOutputStream;
import java.io.File;
import java.io.FileInputStream;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.io.OutputStream;
import java.net.HttpURLConnection;
import java.net.URL;
import java.util.UUID;

import org.junit.Test;

public class UploadImgTest {
	String end = "\r\n";  
    String twoHyphens = "--";  
    String boundary = "******";
    
	@Test
	public void test() {
		OutputStream httpOS = null;
        InputStream httpIS = null;
        DataOutputStream dos = null;
        BufferedInputStream bis = null;
        String filePath = "D:\\gengyu.zip";
        String str="http://221.212.155.77:11097//frontier/AppUploadService.do";
//        String str="http://localhost:8080/loan-ftp-web/FtpTransUpload.do";

        FileInputStream fis = null;
        try {
            UUID uuid = UUID.randomUUID();
            String res = "" + uuid.getMostSignificantBits();
            if (res.startsWith("-")) {
                res = res.substring(1);
            }
        //  String boundary = LINE_TAG + res;
            String fileName = new File(filePath).getName();

            URL url = new URL(str);
            HttpURLConnection httpURLConnection = (HttpURLConnection) url
                    .openConnection();
            httpURLConnection.setDoInput(true);
            httpURLConnection.setDoOutput(true);
            httpURLConnection.setUseCaches(false);
            httpURLConnection.setRequestMethod("POST");
            httpURLConnection.setRequestProperty("Connection", "Keep-Alive");
            httpURLConnection.setRequestProperty("Charset", "UTF-8");
            httpURLConnection.setRequestProperty("Content-Type",
                    "multipart/form-data;boundary=*****");
//          httpURLConnection.setRequestProperty("fileName", fileName);
            httpURLConnection.setRequestProperty("instno","XF");
            httpURLConnection.setRequestProperty("userId", "001");
            httpURLConnection.setRequestProperty("prefix", "APP");
            
            httpOS = httpURLConnection.getOutputStream();
            dos = new DataOutputStream(httpOS);
            dos.writeBytes(twoHyphens + boundary + end);
            dos.writeBytes("Content-Disposition: form-data; name=\"file\"; filename=\""
                    + fileName + "\"" + end);
            dos.writeBytes(end);
            // 读取文件写入到服务器
            fis = new FileInputStream(filePath);
            bis = new BufferedInputStream(fis);
            byte[] buffer = new byte[1024];
            int count = 0;
            while ((count = bis.read(buffer)) != -1) {
                dos.write(buffer, 0, count);
            }
            dos.writeBytes(end);
            dos.writeBytes(twoHyphens + boundary + twoHyphens + end);
            dos.flush();

            // 读取服务器返回结果
            httpIS = httpURLConnection.getInputStream();
            String resp = readContent(httpIS);
        } catch (IOException e) {
            e.printStackTrace();
        } finally {
            try {
                
                if (dos != null) {
                    dos.close();
                }
                if (bis != null) {
                    bis.close();
                }
                if (fis != null) {
                    fis.close();
                }
                
                if (httpOS != null) {
                    httpOS.close();
                }
         
            } catch (IOException e) {
                e.printStackTrace();
            }

        }
	}
	
	
	
	private String readContent(InputStream is) {
        String content = null;
        StringBuffer sb = new StringBuffer();
        BufferedReader br = null;
        try {
            br = new BufferedReader(new InputStreamReader(is));
            while ((content = br.readLine()) != null) {
                sb.append(content);
            }
            content = sb.toString();
        } catch (IOException e) {
            e.printStackTrace();
        } finally {
            try {
                br.close();
                is.close();
            } catch (IOException e) {
               e.printStackTrace();
            }
        }

        return content;
    }

}
