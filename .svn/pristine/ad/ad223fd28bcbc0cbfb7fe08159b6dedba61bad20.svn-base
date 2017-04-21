package com.hrbb.loan.pos.biz.backstage.inter;

import java.util.List;
import java.util.Map;

import com.hrbb.loan.pos.dao.entity.TBankProperties;
import com.hrbb.loan.pos.dao.entity.TCustomer;
import com.hrbb.loan.pos.facade.bean.customer.CustomerInfoInsertRes;
import com.hrbb.loan.pos.facade.bean.customer.CustomerInfoReq;

/**
 * 
 * 
 * @author XLY
 * @version $Id: ILoanPosCustomerBackStageBiz.java, v 0.1 2015-3-3 下午6:11:28 XLY Exp $
 */
//@WebService
public interface ILoanPosCustomerBackStageBiz {
    
    List<Map<String, Object>> queryCustomerInfo(Map<String, Object> reqMap) ;
    
    List<Map<String, Object>> queryCustRelaInfo(Map<String, Object> reqMap) ;

    List<Map<String, Object>> queryCustMerchantInfo(Map<String, Object> reqMap) ;
    
    List<Map<String, Object>> queryCustBankInfo(Map<String, Object> reqMap) ;

    void modifyCustomerInfo(Map<String, Object> reqMap);
    
    void modifyCustRelaInfo(Map<String, Object> reqMap);
    
    void modifyCustMerchantInfo(Map<String, Object> reqMap);
    
    void modifyCustBankInfo(Map<String, Object> reqMap);
    /**
     * 为业务申请单提供插入接口u
     * 
     * @param reqMap
     * @return
     */
    Map<String,Object> insertCustomerFromApplyByMap(Map<String,Object> reqMap);

    CustomerInfoInsertRes  insertCustomerFromApply(CustomerInfoReq req);
    
    /** 
     * 通过身份证号查询客户信息
     * @author cjq
     * @param paperId
     * @return
     */
    List<TCustomer> queryCustomerByPaperId(String paperId);
    
    /**
     * 通过银行名称查询银行信息
     * @author cjq
     * @param bankName
     * @return
     */
    TBankProperties queryBankPropertiesByBankName(String bankName);
    
    /**
     * 通过银行id查询限额配置信息
     * @author Lin, Zhaolin
     * @param bankId
     * @return
     */
    TBankProperties queryBankLimitById(String bankId);

}
