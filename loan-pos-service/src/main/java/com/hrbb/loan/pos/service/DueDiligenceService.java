/**
 * 
 *	哈尔滨银行
 * Copyright (c) 2007-2015 HRBB,Inc.All Rights Reserved.
 */
package com.hrbb.loan.pos.service;

import com.hrbb.loan.pos.dao.entity.TDueDiligence;

/**
 * 
 * @author marco
 * @version $Id: DueDiligenceService.java, v 0.1 2015-3-2 下午7:37:13 marco Exp $
 */
public interface DueDiligenceService {
	
    TDueDiligence selectByPrimaryKey(String loanid);
    
    int insertSelective(TDueDiligence record);
}
