package com.hrbb.loan.pos.util;

import java.io.File;
import java.io.FileInputStream;
import java.io.InputStream;
import java.math.BigDecimal;
import java.security.MessageDigest;
import java.util.ArrayList;
import java.util.Collections;
import java.util.Date;
import java.util.HashMap;
import java.util.HashSet;
import java.util.Iterator;
import java.util.List;
import java.util.Map;
import java.util.ResourceBundle;
import java.util.Set;

/**
 * DS: 签名验签工具类.
 * 
 * @author xiongshaogang
 * @version $Id: SignUtil.java, v 0.1 2015年4月23日 下午2:11:34 xiongshaogang Exp $
 */
public class SignUtil {

	public static final String CHAR_SET = "UTF-8";
	
	public static ResourceBundle config = ResourceBundle.getBundle("accessKey");
    
    /**
     * 获取key对应的属性值
     * @param key
     * @return
     */
    public static String getProperty(String key){
        return config.getString(key);
    }

	public static String getURLParam(Map<String, Object> map, boolean isSort, Set<String> removeKey) {
		StringBuffer param = new StringBuffer();
		List<String> msgList = new ArrayList<String>();
		for (Map.Entry<String, Object> en : map.entrySet()) {
			String key = en.getKey();
			Object value = en.getValue();
			if (removeKey != null && removeKey.contains(key)) {
				continue;
			}
			
			if ("details".equals(key)) {
                List<Object> tmpList = (List<Object>) value;
                if (tmpList != null && tmpList.size() > 0) {
                    int tmpRet = 1;
                    for (Object obj : tmpList) {
                        Map<String, Object> tmpMap = (Map<String, Object>) obj;
                        if (tmpMap != null && tmpMap.size() > 0) {
                            for (Map.Entry<String, Object> en1 : tmpMap.entrySet()) {
                                String tmpKey = en1.getKey();
                                Object tmpValue = en1.getValue();
                                
                                if (removeKey != null && removeKey.contains(tmpKey)) {
                                    continue;
                                }
                                
                                msgList.add(tmpKey + tmpRet + "=" + (tmpValue == null ? "" : String.valueOf(tmpValue)));
                            }
                        }
                        ++tmpRet;
                    }
                }
            } else {
                msgList.add(key + "=" + (value == null ? "" : String.valueOf(value)));
            }
		}

		if (isSort) {
			Collections.sort(msgList);
		}

		for (int i = 0; i < msgList.size(); i++) {
			String msg = (String) msgList.get(i);
			if (i > 0) {
				param.append("&");
			}
			param.append(msg);
		}

		return param.toString();
	}
	
	public static void main(String[] args) {
	    Set<String> set = new HashSet<String>();
//	    set.add("amt");
        Map<String, Object> rootMap = new HashMap<String, Object>();
        List<Object> list = new ArrayList<Object>();
        Map<String, Object> tmpMap = new HashMap<String, Object>();
        tmpMap.put("id", "LO23223509259295293329");
        tmpMap.put("date", new Date());
        tmpMap.put("amt", new BigDecimal(2.333).doubleValue());
        list.add(tmpMap);
        rootMap.put("details", list);
        rootMap.put("respcode", "000");
        rootMap.put("respmsg", "测试");
        System.out.println(getSignMsg(rootMap, set));
        
    }

	public static String getSignMsg(Map<String, Object> map, Set<String> removeKey) {
		return getURLParam(map, true, removeKey);
	}
	
	public static String sign(String signMethod, String signedMsg, String key) {
		if (MD5_ALG.equals(signMethod)) {
			return genMD5(signedMsg + key, CHAR_SET);
		}
		return null;
	}

	public static boolean verifySign(String signMethod, String signedMsg, String mac, String key) {
		if (StringUtil.isEmpty(mac) || StringUtil.isEmpty(signedMsg)) {
			return false;
		}
		return mac.equalsIgnoreCase(sign(signMethod, signedMsg, key));
	}
	
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
     * 生成文件的md5校验值
     * 
     * @param file
     * @return
     */
    public static String genFileMD5(File file) {
        return genFileHash(file, MD5_ALG);
    }

    /**
     * 生成文件的md5校验值
     * 
     * @param file
     * @return
     */
    public static byte[] genFileMD5Bytes(File file) {
        return genFileHashBytes(file, MD5_ALG);
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

    /**
     * 哈希算法
     * 
     * @param file
     *            文件
     * @param alg
     *            算法名
     * @return 哈希结果
     */
    private static String genFileHash(File file, String alg) {
        try {
            MessageDigest digit = MessageDigest.getInstance(alg);
            InputStream fis = new FileInputStream(file);
            byte[] buffer = new byte[1024];
            int numRead = 0;
            while ((numRead = fis.read(buffer)) > 0) {
                digit.update(buffer, 0, numRead);
            }
            fis.close();
            return ByteUtil.byte2hex(digit.digest());
        } catch (Exception e) {
        }
        return null;
    }

    /**
     * 哈希算法
     * 
     * @param file
     *            文件
     * @param alg
     *            算法名
     * @return 哈希结果
     */
    private static byte[] genFileHashBytes(File file, String alg) {
        try {
            MessageDigest digit = MessageDigest.getInstance(alg);
            InputStream fis = new FileInputStream(file);
            byte[] buffer = new byte[1024];
            int numRead = 0;
            while ((numRead = fis.read(buffer)) > 0) {
                digit.update(buffer, 0, numRead);
            }
            fis.close();
            return digit.digest();
        } catch (Exception e) {
        }
        return null;
    }
}
