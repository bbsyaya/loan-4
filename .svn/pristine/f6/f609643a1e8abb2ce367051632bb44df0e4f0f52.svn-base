/**
 * 
 *	哈尔滨银行
 * Copyright (c) 2007-2015 HRBB,Inc.All Rights Reserved.
 */
package com.hrbb.loan.constants.black;

import java.util.HashMap;
import java.util.Map;

/**
 * 
 * @author XLY
 * @version $Id: BlacklistIntervalTypeEnum.java, v 0.1 2015-3-4 下午6:47:47 XLY Exp $
 */
public enum BlacklistIntervalTypeEnum {
    
    INTERVAL_TYPE_1("01", "一个月"),    
    INTERVAL_TYPE_3("03", "三个月"),    
    INTERVAL_TYPE_6("06", "六个月"),    
    INTERVAL_TYPE_12("12", "一年"),    
    INTERVAL_TYPE_EVER("EV", "永远"),    
    
    ;

    private String value = "";

    private String description = null;
    
    BlacklistIntervalTypeEnum(String value,String desc){
        this.value = value;
        this.description = desc;
    }

    public String getValue() {
        return value;
    }

    public void setValue(String value) {
        this.value = value;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }
    
    private static Map<String,String> map = new HashMap<String,String>();

    public static String getDescByValue(String value){
       return map.get(value);
    }
    static{
        for(BlacklistIntervalTypeEnum be:BlacklistIntervalTypeEnum.values()){
            map.put(be.getValue(), be.getDescription());
        }
    }
}
