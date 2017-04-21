package com.hrbb.loan.pos.service.converts;

import com.hrbb.loan.pos.dao.entity.TCustomer;
import com.hrbb.loan.pos.dao.entity.TRelativeInfo;
import com.hrbb.loan.pos.service.bean.CustomerInfoVo;

/**
 * 
 * 
 * @author XLY
 * @version $Id: CustomerConverter.java, v 0.1 2015-3-5 上午9:12:26 XLY Exp $
 */
public class CustomerConverter {

    /**
     * 
     * 
     * @param v
     * @return
     */
    public static TCustomer CustomerInfoVo2TCustomer(CustomerInfoVo v){
        TCustomer tcustomer = new TCustomer();
        return tcustomer;
    }
    /**
     * 
     * 
     * @param v
     * @return
     */
    public static CustomerInfoVo TCustomer2CustomerInfoVo(TCustomer v){
        CustomerInfoVo customerInfoVo = new CustomerInfoVo();
        return customerInfoVo;
    }
    /**
     * 
     * 
     * @param v
     * @return
     */
    public static TRelativeInfo CustomerInfoVo2TRelativeInfo(CustomerInfoVo v){
        TRelativeInfo tRelativeInfo = new TRelativeInfo();
        return tRelativeInfo;
    }
    /**
     * 
     * 
     * @param v
     * @return
     */
    public static CustomerInfoVo TRelativeInfo2CustomerInfoVo(TRelativeInfo v){
        CustomerInfoVo customerInfoVo = new CustomerInfoVo();
        return customerInfoVo;
    }
    
}
