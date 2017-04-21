/**
 * 
 *	哈尔滨银行
 * Copyright (c) 2007-2015 HRBB,Inc.All Rights Reserved.
 */
package com.hrbb.loan.pos.service;

import com.hrbb.loan.pos.service.bean.PosSerialHandledInfoBean;

/**
 * POS流水信息
 * @author XLY
 * @version $Id: LoanRiskPosSerialService.java, v 0.1 2015-3-12 上午10:05:38 XLY Exp $
 */
public interface LoanRiskPosSerialService {
    
    PosSerialHandledInfoBean computerPosSerial(String merchantId);
    
//    List<Map<String, Object>> selectPosSerialMap(Map<String, Object> reqMap);
//    
//    int updatePosSerialByPrimaryKeySelectiveMap(Map<String, Object> reqMap);
//    
//    int insertPosSerialSelectiveMap(Map<String, Object> map);
}
