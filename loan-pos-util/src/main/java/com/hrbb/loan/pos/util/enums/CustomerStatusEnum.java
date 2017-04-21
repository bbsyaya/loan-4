/**
 * 
 *	哈尔滨银行
 * Copyright (c) 2007-2015 HRBB,Inc.All Rights Reserved.
 */
package com.hrbb.loan.pos.util.enums;

/**
 * 客户状态
 * @author XLY
 * @version $Id: CustomerStatusEnum.java, v 0.1 2015-2-15 下午6:18:44 XLY Exp $
 */
public enum CustomerStatusEnum {

    NORMAL("00", "普通客户"),    
    BLACK("99", "黑名单客户"),    
    ;

    private String value = "";

    private String description = null;
    
    CustomerStatusEnum(String value,String desc){
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
    
}
