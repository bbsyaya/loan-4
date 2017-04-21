/**
 * 
 *  哈尔滨银行
 * Copyright (c) 2007-2015 HRBB,Inc.All Rights Reserved.
 */
package com.hrbb.loan.pos.biz.facade;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import com.hrbb.loan.pos.biz.convert.CustomerAddConvert;
import com.hrbb.loan.pos.biz.convert.CustomerQueryConvert;
import com.hrbb.loan.pos.dao.entity.TCustomer;
import com.hrbb.loan.pos.dao.entity.TCustomerBase;
import com.hrbb.loan.pos.facade.LoanPosCustomerBizFacade;
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
import com.hrbb.loan.pos.facade.constants.SysRetCodeConstants;
import com.hrbb.loan.pos.integration.common.demo.WsDemo;
import com.hrbb.loan.pos.service.LoanPosCustomerService;
/**
 * 客户功能接口
 * 
 * @author XLY
 * @version $Id: LoanPosCustomerBizFacadeImpl.java, v 0.1 2015-2-13 上午10:13:08 XLY Exp $
 */
@Component("loanPosCustomerBizFacade")
public class LoanPosCustomerBizFacadeImpl implements LoanPosCustomerBizFacade{

    private Logger LOG = LoggerFactory.getLogger(LoanPosCustomerBizFacadeImpl.class);

    @Autowired
    private LoanPosCustomerService loanPosCustomerService;
    
    @Autowired
    private WsDemo wsDemoClient;
    
    @Override
    public CustomerInfoInsertRes addCustomerInfo(CustomerInfoReq req){
       // LOG.info(wsDemoClient.getHello("ws hello"));
        LOG.info("INSERT CustomerInfo:"+req.toString());
        CustomerInfoInsertRes res = new CustomerInfoInsertRes();
        try {
            TCustomer tCustomer = CustomerAddConvert.CustomerInfoInsertReq2TCustomer(req);
            TCustomer result = loanPosCustomerService.addTCustomer(tCustomer);
            res = CustomerAddConvert.TCustomer2TCustomerInfoInsertRes(result);
        } catch (Exception e) {
            LOG.info("INSERT ERROR:"+req.toString());
            res.setRespCode(SysRetCodeConstants.SYSTEM_ERROR.getCode());
        }
        return res;
    }
    
    @Override
    public  CustomerInfoBaseInsertRes addCustomerBaseInfo(CustomerInfoBaseReq req){
        LOG.info("INSERT CustomerBaseInfo:"+req.toString());
        CustomerInfoBaseInsertRes res= new CustomerInfoBaseInsertRes();
        try {
            TCustomerBase tCustomerBase = CustomerAddConvert.CustomerInfoBaseInsertReq2TCustomerBase(req);
            TCustomerBase tCustomerBaseRes =  loanPosCustomerService.addTCustomerBase(tCustomerBase);
            res = CustomerAddConvert.tCustomerBase2CustomerInfoBaseInsertRes(tCustomerBaseRes);
        } catch (Exception e) {
            LOG.info("INSERT ERROR:"+req.toString());
            res.setRespCode(SysRetCodeConstants.SYSTEM_ERROR.getCode());
        }
        return res;
    }
    
    @Override
    public CustomerInfoUpdateRes updateCustomerInfo(CustomerInfoReq req){
        CustomerInfoUpdateRes res = new CustomerInfoUpdateRes();
        try {
            int i= loanPosCustomerService.updateTCustomer(CustomerAddConvert.CustomerInfoInsertReq2TCustomer(req));
            if(i==0){
                res.setRespCode(SysRetCodeConstants.DATA_NOT_EXIST.getCode());
            }else{
                res.setRespCode(SysRetCodeConstants.SUCCESS.getCode());
            }
        } catch (Exception e) {
            LOG.info("update tcustomer error");
            res.setRespCode(SysRetCodeConstants.SYSTEM_ERROR.getCode());
            res.setMemo("");
        }
        return res;
    }

    @Override
    public CustomerInfoBaseUpdateRes updateCustomerInfoBase(CustomerInfoBaseReq req){
        CustomerInfoBaseUpdateRes res = new CustomerInfoBaseUpdateRes();
        try {
            int i= loanPosCustomerService.updateTCustomerBase(CustomerAddConvert.CustomerInfoBaseInsertReq2TCustomerBase(req));
            if(i==0){
                res.setRespCode(SysRetCodeConstants.DATA_NOT_EXIST.getCode());
            }else{
                res.setRespCode(SysRetCodeConstants.SUCCESS.getCode());
            }
        } catch (Exception e) {
            LOG.info("update tcustomerbase error");
            res.setRespCode(SysRetCodeConstants.SYSTEM_ERROR.getCode());
            res.setMemo("");
        }
        return res;
    }

    
    @Override
    public QueryCustomerInfoRes queryCustomerInfoByCustId(QueryCustomerInfoReq req){
        QueryCustomerInfoRes res  = new QueryCustomerInfoRes();
        TCustomer tCustomer = CustomerQueryConvert.queryCustomerInfoReq2TCustomer(req);
        try {
            if(null!=tCustomer){
            TCustomer tCustomerRes = loanPosCustomerService.queryCustomerInfoByCustId(tCustomer);
            res =  CustomerQueryConvert.tCustomer2QueryCustomerInfoRes(tCustomerRes);
            }else{
                res.setRespCode(SysRetCodeConstants.DATA_NOT_EXIST.getCode());
            }
        } catch (Exception e) {
            res.setRespCode(SysRetCodeConstants.DATA_NOT_EXIST.getCode());
        }
        return res;
    }

    
    @Override
    public QueryCustomerBaseInfoRes queryCustomerBaseInfoByCustId(QueryCustomerBaseInfoReq req){
        QueryCustomerBaseInfoRes res  = new QueryCustomerBaseInfoRes();
        TCustomerBase tCustomerbase = CustomerQueryConvert.queryCustomerBaseInfoReq2TCustomerBase(req);
        try {
            if(null!=tCustomerbase){
            TCustomerBase tCustomerBaseRes = loanPosCustomerService.queryCustomerBaseInfoByCustId(tCustomerbase);
            res =  CustomerQueryConvert.tCustomerBase2QueryCustomerBaseInfoRes(tCustomerBaseRes);
            }else{
                res.setRespCode(SysRetCodeConstants.DATA_NOT_EXIST.getCode());
            }
        } catch (Exception e) {
            res.setRespCode(SysRetCodeConstants.DATA_NOT_EXIST.getCode());
        }
        return res;
    
    }

    public void test(){
        System.out.print("test");
    }
    
    public TCustomer selectByPrimaryKey(String custId) {
		
    	return loanPosCustomerService.getCustumerInfoById(custId);
	}

    /*public WsDemo getWsDemoClient() {
        return wsDemoClient;
    }

    public void setWsDemoClient(WsDemo wsDemoClient) {
        this.wsDemoClient = wsDemoClient;
    }*/

    
}
