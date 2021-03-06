/**
 * 
 *	哈尔滨银行
 * Copyright (c) 2007-2015 HRBB,Inc.All Rights Reserved.
 */
package com.hrbb.loan.pos.service;

import com.hrbb.loan.pos.dao.entity.TBankAccnoInfo;

/**
 * 
 * @author marco
 * @version $Id: BankAccnoInfoService.java, v 0.1 2015-8-7 下午5:29:59 marco Exp $
 */
public interface BankAccnoInfoService {
	public int insertSelective(TBankAccnoInfo record);

	public TBankAccnoInfo selectByPrimaryKey(String bankAccno);

	public String getLoanBankNameByBankAccno(String bankAccno);
}
