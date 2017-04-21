/**
 * 
 *	哈尔滨银行
 * Copyright (c) 2007-2015 HRBB,Inc.All Rights Reserved.
 */
package com.hrbb.loan.pos.facade.constants;

/**
 * 系统应答状态
 * @author XLY
 * @version $Id: SysRetCodeConstants.java, v 0.1 2015-2-16 下午3:49:19 XLY Exp $
 */
public enum SysRetCodeConstants {

    SUCCESS                             ("000000", "成功"), 
    DATA_NOT_EXIST                      ("001001", "数据不存在"),
    CONNECTION_TIMEOUT                  ("001011", "连接超时失效"),
    REMOTE_INVOCATION_EXCEPTION         ("001012", "远程调用异常"),
    REQUEST_FORMAT_ILLEGAL              ("001060", "请求数据格式非法"),
    REQUEST_IP_ILLEGAL                  ("001061", "请求IP非法"),
    SYSTEM_ERROR                        ("001099", "系统错误"),
    ;
    
    private String code;
    private String message;
    
    /**
     * @param code
     * @param message
     */
    private SysRetCodeConstants(String code, String message) {
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
