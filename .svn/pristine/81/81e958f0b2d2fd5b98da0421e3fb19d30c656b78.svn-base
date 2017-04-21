package com.hrbb.loan.pos.util;

import java.util.Iterator;
import java.util.Map;

/**
 * MapUtils.
 * 
 * @author xiongshaogang
 * @version $Id: MapUtils.java, v 0.1 2015年4月15日 上午9:41:42 xiongshaogang Exp $
 */
public class MapUtils {
    /**
     * map转换成字符串
     * 
     * @param map
     * @return
     */
    public static String toString(Map<String, ? extends Object> map) {
        StringBuffer param = new StringBuffer();
        for (Map.Entry<String, ? extends Object> en : map.entrySet()) {
            String key = en.getKey();
            Object value = en.getValue();
            param.append(key + "=[" + value + "];");
        }
        return param.toString();
    }
}
