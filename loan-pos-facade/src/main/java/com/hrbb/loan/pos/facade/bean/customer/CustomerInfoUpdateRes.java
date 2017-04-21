/**
 * 
 *	哈尔滨银行
 * Copyright (c) 2007-2015 HRBB,Inc.All Rights Reserved.
 */
package com.hrbb.loan.pos.facade.bean.customer;

import java.io.Serializable;

import com.hrbb.loan.pos.facade.abs.AbstractResponse;

/**
 * 
 * @author XLY
 * @version $Id: CustomerInfoUpdateRes.java, v 0.1 2015-2-28 上午9:35:12 XLY Exp $
 */
public class CustomerInfoUpdateRes extends AbstractResponse implements Serializable{


    /**  */
    private static final long serialVersionUID = -3045791289985365696L;
    private String custId;

    public String getCustId() {
        return custId;
    }

    public void setCustId(String custId) {
        this.custId = custId;
    }

    @Override
    public String toString() {
        return "CustomerInfoUpdateRes [custId=" + custId +super.toString()+ "]";
    }

}
