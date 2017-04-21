/**
 * 
 *	哈尔滨银行
 * Copyright (c) 2007-2015 HRBB,Inc.All Rights Reserved.
 */
package com.hrbb.loan.web.domain;

/**
 * 
 * @author byp
 * @version $Id: LoginTypeEnum.java, v 0.1 2015年2月16日 上午11:10:46 byp Exp $
 */
public enum LoginTypeEnum implements BaseEnum{
    
    LT_0("我司"), LT_1("PC端"), LT_2("APP端");
    
    private String label;
    private LoginTypeEnum(String label){
        this.label = label;
    }
    @Override
    public String getLabel() {
        return label;
    }
}
