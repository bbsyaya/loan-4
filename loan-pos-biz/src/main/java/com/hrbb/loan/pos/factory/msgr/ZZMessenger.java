package com.hrbb.loan.pos.factory.msgr;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.List;

import org.apache.http.NameValuePair;
import org.apache.http.client.entity.UrlEncodedFormEntity;
import org.apache.http.client.methods.CloseableHttpResponse;
import org.apache.http.client.methods.HttpGet;
import org.apache.http.client.methods.HttpPost;
import org.apache.http.impl.client.CloseableHttpClient;
import org.apache.http.impl.client.HttpClients;
import org.apache.http.message.BasicNameValuePair;

import com.alibaba.fastjson.JSONObject;
import com.hrbb.loan.pos.dao.TCreditApplyDao;
import com.hrbb.loan.pos.dao.entity.TCreditApply;
import com.hrbb.loan.pos.entity.SpringBeans;
import com.hrbb.loan.pos.factory.SysConfigFactory;

public class ZZMessenger extends AbsMessenger {
	

	@Override
	public String getChannel() {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public String getEncryptedRander() {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public String getTransCode() {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public String getUrl() {
		// TODO Auto-generated method stub
		return null;
	}

	@SuppressWarnings("deprecation")
	@Override
	boolean executeSend(){
		HttpPost httpPost = null;
		CloseableHttpClient httpclient = null;
		InputStream instream = null;
		BufferedReader reader = null;
		boolean flag = false;
		try{
			
			String sendApprStatusUrl = SysConfigFactory.getInstance().getService("padService").getPropertyValue("sendApprStatusUrl");
			//目前只推送pad端消息
			if("1".equals(getMessage().getMessageType()) || "2".equals(getMessage().getMessageType()) || "3".equals(getMessage().getMessageType())){
				TCreditApplyDao applyDao = (TCreditApplyDao)SpringBeans.getBean("tCreditApplyDao");
				TCreditApply apply = applyDao.queryCreditApplyInfo(getMessage().getLoanId());
				if(apply != null){
					httpPost = new HttpPost(sendApprStatusUrl);
					List<NameValuePair> formparams = new ArrayList<NameValuePair>();  
					formparams.add(new BasicNameValuePair("loanid", "LO2015100820275463134824812300"));  
					formparams.add(new BasicNameValuePair("applystatus", "90"));  
					httpclient = HttpClients.createDefault();
					UrlEncodedFormEntity urlEntity =  new UrlEncodedFormEntity(formparams, "UTF-8");  
					httpPost.setEntity(urlEntity);
					
					CloseableHttpResponse response = httpclient.execute(httpPost);
					instream = response.getEntity().getContent();  
					
					reader = new BufferedReader(new InputStreamReader(instream, "UTF-8")); 
					String result = reader.readLine();
					logger.debug("pad后端返回结果为" + result);
		            JSONObject obj = JSONObject.parseObject(result);
		            if("OK".equals((String)obj.get("code"))){
		            	flag = true;
		            }

				}
			}
		}catch(Exception e){
			logger.error("发生异常", e);
			flag = false;
		}finally{
			if(reader != null){
				try {
					reader.close();
				} catch (IOException e1) {
					logger.error("关闭reader异常", e1);
				}
			}
			if(instream != null){
				try {
					instream.close();
				} catch (IOException e1) {
					logger.error("关闭stream异常", e1);
				}
			}
			if(httpPost != null){
				httpPost.releaseConnection();
			}
			if(httpclient != null){
				httpclient.getConnectionManager().shutdown();
			}
		
		}
		return flag;
	}

	@Override
	boolean initProcess() throws Exception {
		return true;
	}
	
	
}
