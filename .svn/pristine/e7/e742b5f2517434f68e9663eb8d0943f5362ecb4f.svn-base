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
 * @version $Id: BlacklistInfoTypeEnum.java, v 0.1 2015-3-4 下午6:51:58 XLY Exp $
 */
public enum BlacklistInfoTypeEnum {
    /**0-证件黑名单;1-手机黑名单；2商户黑名单；3；地址黑名单*/
//    public static final String INFO_TYPE="infoType";
    INFO_TYPE_0("0", "证件"),    
    INFO_TYPE_1("1", "手机"),    
    INFO_TYPE_2("2", "商户"),    
    INFO_TYPE_3("3", "地址"),    
;
    private String value = "";

    private String description = null;
    
    BlacklistInfoTypeEnum(String value,String desc){
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
        for(BlacklistInfoTypeEnum be:BlacklistInfoTypeEnum.values()){
            map.put(be.getValue(), be.getDescription());
        }
    }
}
