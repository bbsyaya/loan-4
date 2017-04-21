/**
 * 
 *	哈尔滨银行
 * Copyright (c) 2007-2015 HRBB,Inc.All Rights Reserved.
 */
package com.hrbb.loan.pos.service.impl;

import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.google.common.collect.Maps;
import com.hrbb.loan.pos.dao.TCreditReportIdentityDao;
import com.hrbb.loan.pos.dao.entity.TCreditReportIdentity;
import com.hrbb.loan.pos.service.CreditReportIdentityService;
import com.hrbb.loan.pos.util.constants.ReviewNoteConstants;

/**
 * 
 * @author marco
 * @version $Id: CreditReportIdentityServiceImpl.java, v 0.1 2015-3-2 下午1:59:24 marco Exp
 *          $
 */
@Service("creditReportIdentityService")
public class CreditReportIdentityServiceImpl implements
		CreditReportIdentityService {

	@Autowired
	private TCreditReportIdentityDao tCreditReportIdentityDao;

	/**
	 * @see com.hrbb.loan.pos.service.ReviewNoteService#deleteTReviewNoteInfo(java.lang.String)
	 */
	@Override
	public TCreditReportIdentity selectInfor(String paperId) {
		Map<String, Object> reqMap = Maps.newHashMap();
		reqMap.put(ReviewNoteConstants.CREDIT_REPORT_MAP_KEY_CERTNO, paperId);
		reqMap.put(ReviewNoteConstants.CREDIT_REPORT_MAP_KEY_CERTTYPE,
				ReviewNoteConstants.CREDIT_REPORT_MAP_VALUE_CERTTYPE_0);
		return tCreditReportIdentityDao.selectInfor(reqMap);
	}
}
