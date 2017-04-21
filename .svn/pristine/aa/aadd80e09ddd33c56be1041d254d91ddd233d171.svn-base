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
 * @version $Id: BlacklistCertTypeEnum.java, v 0.1 2015-3-4 下午6:46:26 XLY Exp $
 */
public enum BlacklistCertTypeEnum {
    CERTTYPE_CERTIFCATE("00", "身份证"),    
    CERTTYPE_PASSPORT("01", "护照"),    
    CERTTYPE_HK_MC_PASS("02", "港澳通行证"),    
    ;

    private String value = "";

    private String description = null;
    
    BlacklistCertTypeEnum(String value,String desc){
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
        for(BlacklistCertTypeEnum be:BlacklistCertTypeEnum.values()){
            map.put(be.getValue(), be.getDescription());
        }
    }
}
