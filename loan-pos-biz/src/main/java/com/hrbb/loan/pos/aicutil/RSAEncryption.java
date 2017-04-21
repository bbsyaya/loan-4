package com.hrbb.loan.pos.aicutil;

import java.io.FileInputStream;
import java.io.IOException;
import java.io.InputStream;
import java.io.ObjectInputStream;
import java.net.URLDecoder;
import java.security.Key;
import java.util.Properties;

import javax.annotation.PostConstruct;
import javax.crypto.Cipher;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import sun.misc.BASE64Decoder;
import sun.misc.BASE64Encoder;


/**
 * RSA加密算法
 * 
 * @author liguoxiang
 * 
 */
public class RSAEncryption {
	/**
	 * RSA加密算法
	 * */
	private static RSAEncryption rsaEncrypt = null;
	
	private  Logger logger = LoggerFactory.getLogger(RSAEncryption.class);

	/**
	 * 指定加密算法为RSA
	 */
	private static final String ALGORITHM = "RSA";
	/**
	 * 指定公钥存放文件
	 * */
	private static String PUBLIC_KEY_FILE;
 
	/**
	 * 公钥
	 * */
	private static Key PublicKey;
	/**
	 * 私钥
	 * */
	private static Key PrivateKey;
	
	private Properties p = new Properties();
	
	@PostConstruct
	public void init(){
		ClassLoader clazz = this.getClass().getClassLoader();
		
		InputStream inputStream = clazz.getResourceAsStream("loan-pos-biz.properties");   
		  try {   
		   p.load(inputStream);   
		  } catch (IOException e1) {   
			  logger.error("读取 connectPoliceAndAIC.properties异常");
		  }
	}
	/**
	 * RSA加密算法
	 * */
	private RSAEncryption() throws Exception{
		// 将文件中的公钥对象读出

		{
			 
				ClassLoader clazz = this.getClass().getClassLoader();
				
				InputStream inputStream = clazz.getResourceAsStream("loan-pos-biz.properties");   
				  try {   
				   p.load(inputStream);   
				  } catch (IOException e1) {   
					  logger.error("读取 connectPoliceAndAIC.properties异常");
				  }
				PUBLIC_KEY_FILE = p.getProperty("aicPublicKeyPath");
				ObjectInputStream ois = new ObjectInputStream(
						new FileInputStream(PUBLIC_KEY_FILE));
				PublicKey = (Key) ois.readObject();
				ois.close();

			
		}
	}
	/**
	 * 私钥加密
	 * 
	 * @param source
	 *            源数据
	 * @return 加密后数据
	 */
	public static String PrivateEncrypt(String source) throws Exception{
		return initialize().doEncrypt(source, PrivateKey);
	}
	/**
	 * 初始化RSA加密算法
	 * */
	public static RSAEncryption initialize() throws Exception{
//		if (rsaEncrypt == null) {
//			synchronized (RSAEncryption.class) {
//				if (rsaEncrypt == null) {
					rsaEncrypt = new RSAEncryption();
//				}
//			}
//		}
		return rsaEncrypt;
	}

	/**
	 * 公钥加密
	 * 
	 * @param source
	 *            源数据
	 * @return 加密后数据
	 */
	public static String PublicEncrypt(String source) throws Exception{
		return initialize().doEncrypt(source, PublicKey);
	}

	/**
	 * 公钥解密
	 * 
	 * @param cryptograph
	 *            密文
	 * @return 解密后数据
	 */
	public static String PublicDecrypt(String cryptograph) throws Exception{
		return initialize().doDecrypt(cryptograph, PublicKey);
	}

	/**
	 * 加密
	 * 
	 * @param source
	 *            源数据
	 * @param key
	 *            加密KEY
	 * @return 加密后数据
	 */
	private String doEncrypt(String source, Key key) {
		try {
			// 得到Cipher对象来实现对源数据的RSA加密
			Cipher cipher = Cipher.getInstance(ALGORITHM);
			cipher.init(Cipher.ENCRYPT_MODE, key);
			// 执行加密操作
			byte[] b1 = cipher.doFinal(source.getBytes("UTF-8"));
			BASE64Encoder encoder = new BASE64Encoder();
			return encoder.encode(b1);
		} catch (Exception e) {
			logger.debug("加密异常:" +e.getMessage());
		}
		return null;
	}

	
	/**
	 * 解密
	 * 
	 * @param cryptograph
	 *            密文
	 * @param key
	 *            解密KEY
	 * @return 解密后数据
	 */
	private String doDecrypt(String cryptograph, Key key) {
		try {
			Cipher cipher = Cipher.getInstance(ALGORITHM);
			cipher.init(Cipher.DECRYPT_MODE, key);
			BASE64Decoder decoder = new BASE64Decoder();
			byte[] b1 = decoder.decodeBuffer(cryptograph);
			// 执行解密操作
			byte[] b = cipher.doFinal(b1);
			return new String(b, "UTF-8");
		} catch (Exception e) {
			logger.error("解密异常:" + e.getMessage());
		}
		return null;
	}
	/**
	 * 私钥解密
	 * 
	 * @param cryptograph
	 *            密文
	 * @return 解密后数据
	 */
	public static String PrivateDecrypt(String cryptograph) throws Exception{
		return initialize().doDecrypt(cryptograph, PrivateKey);
	}
	
	
}
