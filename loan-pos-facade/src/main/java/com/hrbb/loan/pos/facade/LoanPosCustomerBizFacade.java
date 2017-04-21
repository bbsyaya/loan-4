/**
 * 
 *	哈尔滨银行
 * Copyright (c) 2013-2015 HRBB,Inc.All Rights Reserved.
 */
package com.hrbb.loan.pos.facade;

import javax.jws.WebService;

import com.hrbb.loan.pos.facade.bean.customer.CustomerInfoBaseInsertRes;
import com.hrbb.loan.pos.facade.bean.customer.CustomerInfoBaseReq;
import com.hrbb.loan.pos.facade.bean.customer.CustomerInfoBaseUpdateRes;
import com.hrbb.loan.pos.facade.bean.customer.CustomerInfoInsertRes;
import com.hrbb.loan.pos.facade.bean.customer.CustomerInfoReq;
import com.hrbb.loan.pos.facade.bean.customer.CustomerInfoUpdateRes;
import com.hrbb.loan.pos.facade.bean.customer.QueryCustomerBaseInfoReq;
import com.hrbb.loan.pos.facade.bean.customer.QueryCustomerBaseInfoRes;
import com.hrbb.loan.pos.facade.bean.customer.QueryCustomerInfoReq;
import com.hrbb.loan.pos.facade.bean.customer.QueryCustomerInfoRes;

/**
 * 
 * @author XLY
 * @version $Id: LoanPosCustomerBizFacade.java, v 0.1 2015-2-13 上午10:12:40 XLY Exp $
 * @param <TCustomer>
 */
@WebService
public interface LoanPosCustomerBizFacade<TCustomer> {

    void test();
    
    /**
     * 跟新用户信息
     * 
     * @param req
     * @return
     */
    CustomerInfoUpdateRes updateCustomerInfo(CustomerInfoReq req);

    
    /**
     * 增加用户记录
     * 
     * @param res
     * @return
     */
    CustomerInfoInsertRes addCustomerInfo(CustomerInfoReq req);
    
    /**
     * 增加用户记录
     * 
     * @param res
     * @return
     */
    CustomerInfoBaseInsertRes addCustomerBaseInfo(CustomerInfoBaseReq req);
    
    /**
     * 
     *更新customerInfoBase的信息
     * @param req
     * @return
     */
    CustomerInfoBaseUpdateRes updateCustomerInfoBase(CustomerInfoBaseReq req);
    
    /**
     * 查询用户信息
     * 
     * @param req
     * @return
     */
    QueryCustomerInfoRes queryCustomerInfoByCustId(QueryCustomerInfoReq req);
    
    /**
     * 查询用户基本信息
     * 
     * @param req
     * @return
     */
    QueryCustomerBaseInfoRes queryCustomerBaseInfoByCustId(QueryCustomerBaseInfoReq req);
    


	TCustomer selectByPrimaryKey(String custId);

}
