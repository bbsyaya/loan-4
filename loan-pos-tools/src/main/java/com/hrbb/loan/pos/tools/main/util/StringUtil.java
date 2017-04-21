package com.hrbb.loan.pos.tools.main.util;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import java.util.Map;

/**
 * <h1></h1>
 * 
 * @author Johnson Song
 * @version Id: StringUtil.java, v 1.0 2015-3-3 上午10:20:36 Johnson Song Exp
 */
public class StringUtil {
	
	/**
     * 检查字符串是否不为空
     * 
     * @param str
     *            被检查的字符串
     * @return true 字符串不为空,false 字符串为空
     */
    public static boolean isNotEmpty(String str) {
        return (str != null && str.trim().length() > 0);
    }

    /**
     * 检查字符串是否为空
     * 
     * @param aStr
     *            被检查的字符串
     * @return true 字符串为空,false 字符串不为空
     */
    public static boolean isEmpty(String aStr) {
        return (aStr == null || aStr.trim().length() == 0);
    }

    /**
     * NULL转成空字符串并去空格
     * 
     * @param aStr
     *            字符串
     * @return String
     */
    public static String trimToEmpty(String aStr) {
        return aStr == null ? "" : aStr.trim();
    }

    /**
     * NULL转成空字符串
     * 
     * @param aStr
     *            字符串
     * @return String
     */
    public static String toEmpty(String aStr) {
        return aStr == null ? "" : aStr;
    }

    /**
     * 重复字符串
     * 
     * @param val
     *            字符串
     * @param repeat
     *            重复次数
     * @return
     */
    public static String repeat(char val, int repeat) {
        StringBuffer tBuffer = new StringBuffer(repeat);
        for (int i = 0; i < repeat; i++) {
            tBuffer.append(val);
        }
        return tBuffer.toString();
    }

    /**
     * 重复字符串
     * 
     * @param type
     *            r右补位l左补位
     * @param val
     *            字符串
     * @param len
     *            长度
     * @return
     */
    public static String repeat(char type, String val, int len) {
        StringBuffer tBuffer = new StringBuffer();
        while (tBuffer.length() < len) {
            tBuffer.append(val);
        }

        if ('r' == type) {
            // 右截断
            return tBuffer.substring(0, len);
        } else {
            // 左截断
            return tBuffer.substring(tBuffer.length() - len);
        }

    }

    /**
     * 字符串补位
     * 
     * @param val
     *            字符串
     * @param type
     *            r右补位l左补位
     * @param size
     *            补足长度
     * @param delim
     *            补位用字符串
     */
    public static String pad(String val, char type, int size, char delim) {
        if ('r' == type) {
            if (val.length() >= size) {
                return val.substring(0, size);
            } else {
                return val + repeat(delim, size - val.length());
            }
        } else {
            if (val.length() >= size) {
                return val.substring(val.length() - size);
            } else {
                return repeat(delim, size - val.length()) + val;
            }
        }
    }

    /**
     * 字符串补位
     * 
     * @param val
     *            字符串
     * @param type
     *            r右补位l左补位
     * @param size
     *            补足长度
     * @param delim
     *            补位用字符串
     */
    public static String pad(String val, String type, int size, String delim) {
        if ("r".equals(type)) {
            if (val.length() >= size) {
                return val.substring(0, size);
            } else {
                return val + repeat('r', delim, size - val.length());
            }
        } else {
            if (val.length() >= size) {
                return val.substring(val.length() - size);
            } else {
                return repeat('l', delim, size - val.length()) + val;
            }
        }
    }

    /**
     * 字符串截位
     * 
     * @param val
     *            字符串
     * @param type
     *            r右截位l左截位
     * @param start
     *            起始位置
     * @param size
     *            截取长度
     */
    public static String truncate(String val, String type, int start, int size) {
        // 左截
        if ("l".equals(type)) {
            return val.substring(start, start + size);
        } else {
            // 右截
            return val.substring(val.length() - start - size, val.length() - start);
        }
    }

    /**
     * map转换成字符串
     * 
     * @param map
     * @return
     */
    public static String toString(Map map) {
        StringBuffer param = new StringBuffer();
        List msgList = new ArrayList();
        for (Iterator it = map.keySet().iterator(); it.hasNext();) {
            String key = (String) it.next();
            String value = (String) map.get(key);
            msgList.add(key + "=[" + value + "];");
        }
        return param.toString();
    }
}
