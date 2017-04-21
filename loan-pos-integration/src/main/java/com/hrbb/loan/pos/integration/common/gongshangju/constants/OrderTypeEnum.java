/**
 * 
 *	哈尔滨银行
 * Copyright (c) 2007-2015 HRBB,Inc.All Rights Reserved.
 */
package com.hrbb.loan.pos.integration.common.gongshangju.constants;

/**
 * 数据类型
 * @author XLY
 * @version $Id: OrderTypeEnum.java, v 0.1 2015-2-17 下午1:11:59 XLY Exp $
 */
public enum OrderTypeEnum {

    BY_ENTERPRICE                  ("11010001110000110000000000010000100", "按企业查询"), 
    BY_CERT                  ("00000000001110000000000000010000010", "按人员证件号查询"), 
    ;
    private String code;
    private String message;
    
    /**
     * @param code
     * @param message
     */
    private OrderTypeEnum(String code, String message) {
        this.code = code;
        this.message = message;
    }
    

    /**
     * Getter method for property <tt>code</tt>.
     * 
     * @return property value of code
     */
    public String getCode() {
        return code;
    }

    /**
     * Setter method for property <tt>code</tt>.
     * 
     * @param code value to be assigned to property code
     */
    public void setCode(String code) {
        this.code = code;
    }

    /**
     * Getter method for property <tt>message</tt>.
     * 
     * @return property value of message
     */
    public String getMessage() {
        return message;
    }
}
