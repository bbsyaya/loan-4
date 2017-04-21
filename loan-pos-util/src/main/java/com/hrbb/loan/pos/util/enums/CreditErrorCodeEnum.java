/**
 * 
 *  哈尔滨银行
 * Copyright (c) 2007-2015 HRBB,Inc.All Rights Reserved.
 */
package com.hrbb.loan.pos.util.enums;
/**
 * 
 * 申请业务准则错误状态
 * @author jianQing
 * @version $Id: CreditErrorCodeEnum.java, v 0.1 2015年4月11日 下午1:02:18 jianQing Exp $
 */
public enum CreditErrorCodeEnum {
    blackErrorCode("000","申请人/配偶/企业属于黑名单客户");
    private String errorCode="";
    private String errorMessage=null;
    
    CreditErrorCodeEnum(String errorCode,String errorMessage){
        this.errorCode=errorCode;
        this.errorMessage=errorMessage;
    }
    
    public String getErrorCode() {
        return errorCode;
    }
    public void setErrorCode(String errorCode) {
        this.errorCode = errorCode;
    }
    public String getErrorMessage() {
        return errorMessage;
    }
    public void setErrorMessage(String errorMessage) {
        this.errorMessage = errorMessage;
    }
    
}
