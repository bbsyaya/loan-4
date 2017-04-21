/**
 * 
 *	哈尔滨银行
 * Copyright (c) 2007-2015 HRBB,Inc.All Rights Reserved.
 */
package com.hrbb.loan.pos.service;

import java.util.List;

import com.hrbb.loan.pos.dao.entity.TPaybackRunningRecord;

/**
 * 
 * @author marco
 * @version $Id: TPaybackRunningRecordInfoService.java, v 0.1 2015-4-26 下午2:42:16 marco Exp $
 */
public interface PaybackRunningRecordService {
    int deleteByPrimaryKey(String paybackRunningRecordId);

    int insert(TPaybackRunningRecord record);

    int insertSelective(TPaybackRunningRecord record);

    TPaybackRunningRecord selectByPrimaryKey(String paybackRunningRecordId);
    
    List<TPaybackRunningRecord> selectRecordInfoHB17();

    int updateByPrimaryKeySelective(TPaybackRunningRecord record);

    int updateByPrimaryKey(TPaybackRunningRecord record);
}
