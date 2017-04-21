/**
 * 
 */
package com.hrbb.test;

import java.io.IOException;
import java.security.KeyManagementException;
import java.security.KeyStoreException;
import java.security.NoSuchAlgorithmException;
import java.security.cert.CertificateException;
import java.security.cert.X509Certificate;
import java.util.HashMap;
import java.util.Map;
import java.util.TreeMap;

import javax.net.ssl.SSLContext;


import org.apache.http.client.ClientProtocolException;
import org.apache.http.client.methods.CloseableHttpResponse;
import org.apache.http.client.methods.HttpGet;
import org.apache.http.conn.ssl.SSLConnectionSocketFactory;
import org.apache.http.conn.ssl.SSLContextBuilder;
import org.apache.http.conn.ssl.TrustStrategy;
import org.apache.http.impl.client.CloseableHttpClient;
import org.apache.http.impl.client.HttpClients;
import org.apache.http.util.EntityUtils;
import org.apache.log4j.Logger;
import org.junit.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;

import com.google.gson.Gson;
import com.google.gson.reflect.TypeToken;
import com.hrbb.loan.pos.dao.TBankAccnoInfoDao;
import com.hrbb.loan.pos.dao.entity.TBankAccnoInfo;
import com.hrbb.loan.pos.util.StringUtil;
import com.hrbb.sh.framework.util.BankUtil;


/**
 * @author maosheng
 * 
 */
public class BankCardCheckTest extends UnitTest{
	
	private static final Logger logger = Logger.getLogger(BankCardCheckTest.class);
	
	private static final String TESTBANKCHECKURL = "https://openapi.yijifu.net/gateway.html";
	
	private static final String SERVICENAME = "bankCardElementsCheck";
	
	private static final String TESTPARTNERID = "20140411020055684571";
	
	private static final String TESTCARDNO = "6217233100000855685";
	
	private static final String TESTSAFECODE = "c9cef22553af973d4b04a012f9cb8ea8"; 
	
	private  Gson gson = new Gson();
	
	@Autowired
	@Qualifier("tBankAccnoInfoDao")
	private TBankAccnoInfoDao tBankAccnoInfoDao;
	
	@Test
	public void bankCardCheck() throws Exception{
		Boolean success = false;
		CloseableHttpResponse response = null;
		CloseableHttpClient httpClient = createSSLClientDefault();
		String plain = getPlainStr();
		String status = "";
		
		String sign =  BankUtil.getMD5(plain+TESTSAFECODE, "UTF-8").toLowerCase(); // 参数+安全码 做MD5然后转成小写	
		
		HttpGet httpGet  =  new HttpGet(TESTBANKCHECKURL+"?sign="+sign+"&"+plain);
		logger.debug("httpGet=="+TESTBANKCHECKURL+"?sign="+sign+"&"+plain);
		String responseStr = "";
		try {
			response = httpClient.execute(httpGet);
			responseStr = EntityUtils.toString(response.getEntity());
			
			System.out.println(responseStr);
			
			Map<String,Object> respMap = gson.fromJson(responseStr,new TypeToken<Map<String, Object>>() {}.getType());
			success = (Boolean) respMap.get("success");
			if(success){
				status="01";  //卡状态正常
			}else{
				status="02";  
			}
			TBankAccnoInfo record = tBankAccnoInfoDao.selectByPrimaryKey(TESTCARDNO);
			if(record!=null){
				record.setStatus(status);	
				tBankAccnoInfoDao.updateByPrimaryKeySelective(record);
			}				
		}catch (ClientProtocolException e) {
			logger.error("", e);
		}catch (IOException e) {
            logger.error("", e);
        } finally {
            try {
                response.close();
                httpClient.close();
            } catch (IOException e) {
                logger.error("Closing http meets exception.", e);
            }
        }			
	}
	
/*	public static void main(String[] args) throws Exception{
		String plain = "cardName=毛盛&cardNo=6217233100000855685&certNo=500103197904017791&certType=Identity_Card&orderNo=2015050415040045&partnerId=20140411020055684571&service=bankCardElementsCheck&signType=MD5";
		String sign =  BankUtil.getMD5(plain+TESTSAFECODE, "UTF-8").toLowerCase(); // 参数+安全码 做MD5然后转成小写
		System.out.println(sign);
	}*/
	public String getPlainStr(){
		String cardNo         	=TESTCARDNO;
		String cardName 		="毛盛";
		String orderNo          ="2015050415040045";
		String certType			="Identity_Card";
		String signType			="MD5";
		String certNo			="500103197904017791";
		String service			=SERVICENAME;
		String partnerId		=TESTPARTNERID;
		
		Map<String,String> map = new HashMap<String,String>();
		map.put("cardName", cardName);
		map.put("cardNo", cardNo);
		map.put("orderNo", orderNo);
		map.put("certType", certType);
		map.put("signType", signType);
		map.put("certNo", certNo);
		map.put("service", service);
		map.put("partnerId", partnerId);	
		TreeMap<String, String> treeMap = new TreeMap<String, String>(map); //对Map里的每一个成员按字符ASC 码的顺序排序，若遇到相同首字符，则看第二个字符，
		
		StringBuffer sb = new StringBuffer();
		for(Map.Entry<String, String> entry : treeMap.entrySet()){
			System.out.println(entry.getKey());
			sb.append(entry.getKey()+"="+entry.getValue()+"&");
		}
		
		String plain = sb.toString().substring(0, sb.toString().length()-1); 
		
		return plain;
				
	}
	
	public CloseableHttpClient createSSLClientDefault(){
		try {
		       SSLContext sslContext = new SSLContextBuilder().loadTrustMaterial(null, new TrustStrategy() {
		         //信任所有
		         public boolean isTrusted(X509Certificate[] chain,
		                 String authType) throws CertificateException {
		           return true;
		         }
		       }).build();
		       SSLConnectionSocketFactory sslsf = new SSLConnectionSocketFactory(sslContext);
		       return HttpClients.custom().setSSLSocketFactory(sslsf).build();
		     } catch (KeyManagementException e) {
		       e.printStackTrace();
		     } catch (NoSuchAlgorithmException e) {
		       e.printStackTrace();
		     } catch (KeyStoreException e) {
		       e.printStackTrace();
		     }
		     return  HttpClients.createDefault();
		}

}
