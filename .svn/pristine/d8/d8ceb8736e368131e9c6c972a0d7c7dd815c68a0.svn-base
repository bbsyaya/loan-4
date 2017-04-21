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
 * @version $Id: BlacklistEffectFlagEnum.java, v 0.1 2015-3-4 下午6:50:06 XLY Exp $
 */
public enum BlacklistEffectFlagEnum {
    EFFECT_FLAG_Y("0", "有效"),    
    EFFECT_FLAG_N("1", "无效"),    
;
    private String value = "";

    private String description = null;
    
    BlacklistEffectFlagEnum(String value,String desc){
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
        for(BlacklistEffectFlagEnum be:BlacklistEffectFlagEnum.values()){
            map.put(be.getValue(), be.getDescription());
        }
    }
}
