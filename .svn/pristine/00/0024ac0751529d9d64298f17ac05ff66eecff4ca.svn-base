/**
 * 
 *  哈尔滨银行
 * Copyright (c) 2007-2015 HRBB,Inc.All Rights Reserved.
 */
package com.hrbb.loan.sale.service;


import java.util.List;
import java.util.Map;

import com.hrbb.loan.pos.dao.entity.TBankProperties;
import com.hrbb.loan.pos.dao.entity.TCustomer;
import com.hrbb.loan.pos.dao.entity.TCustomerBase;
import com.hrbb.loan.pos.service.bean.CustomerInfoVo;

/**
 * 消费贷客户信息查询服务
 * @author litengfeng
 * @version $Id: LoanSaleCustomerService.java, v 0.1 2015年5月13日 上午11:06:40 litengfeng Exp $
 */
public interface LoanSaleCustomerService {
	public Map<String, Object> selectOneCustomer(String custId);
	public Map<String, Object> selectOneCustomerByNameAndPaper(String custName, String paperId);
	/**
	 * 通过身份证查询客户信息
	 * @author cjq
	 * @param paperId
	 * @return
	 */
	public List<TCustomer> selectOneCustomerByPaper(String paperId);
    

    /**
     * 增加tCustomer
     * 
     * @param tCustomer
     * @return
     */
    TCustomer addTCustomer(TCustomer tCustomer);

    public TCustomer getCustumerInfoById(String custId);
    /**
     * 增加tCustomer
     * 
     * @param tCustomer
     * @return
     */
    CustomerInfoVo addCustomerInfoVo(CustomerInfoVo customerInfoVo);
    /**
     * 
     * 更新customer by custId
     * @param tCustomer
     * @return
     */
    int updateTCustomer(TCustomer tCustomer);
    /**
     * 根据custId查询customerInfo表
     * 
     * @param tCustomer
     * @return
     */
    TCustomer queryCustomerInfoByCustId(TCustomer tCustomer);
    CustomerInfoVo getCustumerInfoByIdNew(String custId) ;
    /**
     * 
     * 更新customer by custId
     * @param tCustomer
     * @return
     */
    int updateTCustomer(CustomerInfoVo tCustomer);


    /**
     * 查询亲属信息
     */
    public List<Map<String, Object>> getRelativeInfo(Map<String, Object> reqMap);
    
    public Map<String, Object> getOneRelativeInfo(String relaName, String custId);
    
    public Map<String, Object> getOneRelativeInfoById(String relativeId);

    public Map<String, Object> getOneRelativeInfo(Map<String, Object> reqMap);
    
    /**
     * 更新亲属信息
     */
    public int updateRelativeInfo(Map<String, Object> reqMap);

    /**
     * 插入亲属信息
     */
    public int insertRelativeInfo(Map<String, Object> reqMap);
    /**
     * 插商户信息
     */
    public int insertPosCustInfo(Map<String, Object> reqMap);

    /**
     * 查询商户信息
     */
    public List<Map<String, Object>> getPosCustInfo(Map<String, Object> reqMap);

    /**
     * 更新银行账户信息
     */
    public int updateBankAccno(Map<String, Object> reqMap);
    /*
     * 插银行账户信息
     */
    public int insertBankAccno(Map<String, Object> reqMap);

    /**
     * 查询商户信息
     */
    public List<Map<String, Object>> getBankAccno(Map<String, Object> reqMap);

    /**
     * 更新银行账户信息
     */
    public int updatePosCustInfo(Map<String, Object> reqMap);

    public List<TCustomer> getCustomerInfoSelective(Map<String, Object> map);

    public int insertTCustermerInfo(TCustomer tCustomer);

    public int updateTCustomerInfo(TCustomer tCustomer);

    public int deleteTCustomerInfo(String custId);

    public int insertCustomerInfoMap(Map<String, Object> reqMap);

    public int updateCustomerInfoMap(Map<String, Object> reqMap);

    public List<Map<String, Object>> selectCustomerInfoSelectiveMap(Map<String, Object> map);

    /**
     * 增加tCustomerBase
     * 
     * @param tCustomer
     * @return
     */
    @Deprecated
    TCustomerBase addTCustomerBase(TCustomerBase tCustomerBase);

    /**
     * 根据custId查询customerBaseInfo表
     * 
     * @param tCustomerBase
     * @return
     */
    @Deprecated
    TCustomerBase queryCustomerBaseInfoByCustId(TCustomerBase tCustomerBase);

    /**
     * 
     * 
     * @param tCustomerbase
     * @return
     */
    @Deprecated
    int updateTCustomerBase(TCustomerBase tCustomerbase);

    public int deleteTCustomerBaseInfo(String custId);
    public TCustomerBase getCustomerBaseInfoById(String custId);
    public List<TCustomerBase> getCustomerBaseSelective(Map<String, Object> map);
    public int insertTCustomerBaseInfo(TCustomerBase tCustomerBase);
    public int updateTCustomerBaseInfo(TCustomerBase tCustomerBase);
    
    /**
     * 根据银行名称查询银行信息
     * 
     * @param bankName
     * @return
     */
    public TBankProperties queryBankPropertiesByBankName(String bankName);
    
    /**
     * 根据银行id获取限额配置信息
     * @author Lin,Zhaolin
     * @param bankId
     * @return
     */
    public TBankProperties queryBankLimitById(String bankId);
    

}
