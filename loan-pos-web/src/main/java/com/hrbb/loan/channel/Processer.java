package com.hrbb.loan.channel;

import java.util.HashMap;
import java.util.Map;

/**
 * 第三方渠道对接接口.
 * 
 * @author xiongshaogang
 * @version $Id: Processer.java, v 0.1 2015年4月27日 下午6:05:25 xiongshaogang Exp $
 */
public abstract class Processer {
    
    private Map<String, String> retMap = new HashMap<String, String>();
    
    public Processer() {
    }
    
    public void setRespCode(String code) {
        retMap.put("RespCode", code);
    }
    
    public String getRespCode() {
        return retMap.get("RespCode");
    }
    
    public void setRespMsg(String msg) {
        retMap.put("RespMsg", msg);
    }

    public String getRespMsg() {
        return retMap.get("RespMsg");
    }

    public void setKeyValue(String key, String value) {
        retMap.put(key, value);
    }

    public String getValueByKey(String key) {
        return retMap.get(key);
    }
    
    public Map<String, String> getRetMap() {
        return retMap;
    }
}
