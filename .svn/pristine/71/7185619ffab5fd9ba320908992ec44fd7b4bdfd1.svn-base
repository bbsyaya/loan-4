/**
 * 
 *	哈尔滨银行
 * Copyright (c) 2007-2015 HRBB,Inc.All Rights Reserved.
 */
package com.hrbb.loan.pos.biz.backstage.inter.impl;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Component;

import com.hrbb.loan.pos.biz.backstage.inter.CreditReportBiz;
import com.hrbb.loan.pos.service.CreditReportService;

/**
 * 
 * @author marco
 * @version $Id: CreditReportBizImpl.java, v 0.1 2015-4-3 下午2:07:25 marco Exp $
 */
@Component("creditReportBiz")
public class CreditReportBizImpl implements CreditReportBiz {

	@Autowired
	@Qualifier("creditReportService")
	private CreditReportService creditReportService;
	
	/** 
	 * @see com.hrbb.loan.pos.biz.backstage.inter.CreditReportBiz#checkCreditReport(java.lang.String)
	 */
	@Override
	public int checkCreditReport(String paperId) {
		return creditReportService.checkCreditReport(paperId);
	}
}
