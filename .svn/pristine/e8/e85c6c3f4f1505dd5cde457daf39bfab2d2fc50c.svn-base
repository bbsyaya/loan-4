package com.hrbb.loan.pos.tools.main.util;

import java.security.MessageDigest;

import com.hrbb.loan.pos.util.ByteUtil;

/**
 * DS: 签名验签工具类.
 * 
 * @author guoyu
 * @version $Id: SignUtil.java, v 0.1 2015年4月23日 下午2:11:34 xiongshaogang Exp $
 */
public class SignUtil {

	public static final String CHAR_SET = "UTF-8";
	/** MD5算法 */
	public final static String MD5_ALG = "MD5";
	/** SHA1算法 */
	public final static String SHA1_ALG = "SHA1";
	/** SHA256算法 */
	public final static String SHA256_ALG = "SHA256";
	/** 3DES算法 */
	public final static String DESede_ALG = "DESede";
	/** DES算法 */
	public final static String DES_ALG = "DES";
	/** RSA算法 */
	public final static String RSA_ALG = "RSA";
	/** AES算法 */
	public final static String AES_ALG = "AES";

	/**
	 * 产生 MD5
	 * 
	 * @param str
	 *            摘要字符串
	 * @param charset
	 *            字符串编码
	 * @return MD5（32位）
	 * @throws SecurityException
	 *             生成MD5失败抛出异常
	 */
	public static String genMD5(String str, String charset) {
		try {
			return genMD5(str.getBytes(charset));
		} catch (Exception e) {
		}
		return null;
	}

	/**
	 * 产生 MD5
	 * 
	 * @param str
	 *            摘要字符串
	 * @param charset
	 *            字符串编码
	 * @return MD5（32位）
	 * @throws SecurityException
	 *             生成MD5失败抛出异常
	 */
	public static byte[] genMD5Bytes(String str, String charset) {
		try {
			return genMD5Bytes(str.getBytes(charset));
		} catch (Exception e) {
		}
		return null;
	}

	/**
	 * 产生 MD5
	 * 
	 * @param byteArray
	 *            摘要Byte数组
	 * @return MD5（32位）
	 */
	public static String genMD5(byte[] byteArray) {
		return genHash(byteArray, MD5_ALG);
	}

	/**
	 * 哈希算法
	 * 
	 * @param byteArray
	 *            摘要Byte数组
	 * @param alg
	 *            算法名
	 * @return MD5（32位）
	 */
	private static String genHash(byte[] byteArray, String alg) {
		try {
			MessageDigest digit = MessageDigest.getInstance(alg);
			digit.update(byteArray);
			return ByteUtil.byte2hex(digit.digest());
		} catch (Exception e) {
		}
		return null;
	}

	/**
	 * 产生 MD5
	 * 
	 * @param byteArray
	 *            摘要Byte数组
	 * @return MD5（32位）
	 */
	public static byte[] genMD5Bytes(byte[] byteArray) {
		return genHashBytes(byteArray, MD5_ALG);
	}


	/**
	 * 哈希算法
	 * 
	 * @param byteArray
	 *            摘要Byte数组
	 * @param alg
	 *            算法名
	 * @return MD5（32位）
	 */
	private static byte[] genHashBytes(byte[] byteArray, String alg) {
		try {
			MessageDigest digit = MessageDigest.getInstance(alg);
			digit.update(byteArray);
			return digit.digest();
		} catch (Exception e) {
		}
		return null;
	}

}
