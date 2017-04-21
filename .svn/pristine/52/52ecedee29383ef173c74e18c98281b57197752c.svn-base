/**
 * 
 *	哈尔滨银行
 * Copyright (c) 2007-2015 HRBB,Inc.All Rights Reserved.
 */
package com.hrbb.loan.pos.biz.backstage.inter.impl;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Component;

import com.hrbb.loan.pos.biz.backstage.inter.CreditReportIdentityBiz;
import com.hrbb.loan.pos.dao.entity.TCreditReportIdentity;
import com.hrbb.loan.pos.service.CreditReportIdentityService;

/**
 * 
 * @author marco
 * @version $Id: creditReportIdentityBiz.java, v 0.1 2015-3-2 下午3:26:50 marco
 *          Exp $
 */
@Component("creditReportIdentityBiz")
public class CreditReportIdentityBizImpl implements CreditReportIdentityBiz {

	private Logger LOG = LoggerFactory
			.getLogger(CreditReportIdentityBizImpl.class);

	@Autowired
	@Qualifier("creditReportIdentityService")
	private CreditReportIdentityService creditReportIdentityService;

	@Override
	public TCreditReportIdentity selectInfor(String paperId) {
		return creditReportIdentityService.selectInfor(paperId);
	}
}
