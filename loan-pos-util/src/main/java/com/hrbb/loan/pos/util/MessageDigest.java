/**
 * 
 */
package com.hrbb.loan.pos.util;

import java.security.NoSuchAlgorithmException;

/**
 * <p>Title: MessageDigest.java </p>
 * <p>Description:  </p>
 * <p>Copyright: Copyright (C) 2015 Hrbb Ltd. Co.</p> 
 *     
 * @author linzhaolin@hrbb.com.cn
 * @version 
 * @date 2015年4月28日
 *
 * logs: 1. 
 */
public class MessageDigest {
	
	public static byte[] getDigest(String algorithm, byte srcData[])
			throws NoSuchAlgorithmException
		{
			byte dgt[] = null;
			if (srcData == null)
				return dgt;
			if (algorithm == null)
				algorithm = "MD5";
			java.security.MessageDigest md = java.security.MessageDigest.getInstance(algorithm.toUpperCase());
			md.reset();
			md.update(srcData);
			dgt = md.digest();
			return dgt;
		}

		public static byte[] getDigest(String algorithm, String srcData)
			throws NoSuchAlgorithmException
		{
			if (srcData == null)
				return null;
			else
				return getDigest(algorithm, srcData.getBytes());
		}

		public static String getDigestAsLowerHexString(String algorithm, String srcData)
			throws NoSuchAlgorithmException
		{
			if (srcData == null)
				return null;
			else
				return ByteUtil.byte2hex(getDigest(algorithm, srcData.getBytes())).toLowerCase();
		}

		public static String getDigestAsUpperHexString(String algorithm, String srcData)
			throws NoSuchAlgorithmException
		{
			if (srcData == null)
				return null;
			else
				return ByteUtil.byte2hex(getDigest(algorithm, srcData.getBytes())).toUpperCase();
		}

		public static String getDigestAsLowerHexString(String algorithm, byte srcData[])
			throws NoSuchAlgorithmException
		{
			return ByteUtil.byte2hex(getDigest(algorithm, srcData)).toLowerCase();
		}

		public static String getDigestAsUpperHexString(String algorithm, byte srcData[])
			throws NoSuchAlgorithmException
		{
			return ByteUtil.byte2hex(getDigest(algorithm, srcData)).toUpperCase();
		}
}
