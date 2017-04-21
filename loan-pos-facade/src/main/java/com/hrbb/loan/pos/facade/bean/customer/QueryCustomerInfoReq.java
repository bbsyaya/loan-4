package com.hrbb.loan.pos.facade.bean.customer;

import java.io.Serializable;

import com.hrbb.loan.pos.facade.abs.AbstractRequest;

/**
 * 
 * 
 * @author XLY
 * @version $Id: QueryCustomerInfoReq.java, v 0.1 2015-2-16 下午1:41:59 XLY Exp $
 */
public class QueryCustomerInfoReq extends AbstractRequest implements Serializable{

    /**  */
    private static final long serialVersionUID = -7885208682466287936L;

    private String custId;

    public String getCustId() {
        return custId;
    }

    public void setCustId(String custId) {
        this.custId = custId;
    }

    @Override
    public String toString() {
        return "QueryCustomerInfoReq [custId=" + custId + "]"+super.toString();
    }
    
    
}
