/**
 * 
 *	哈尔滨银行
 * Copyright (c) 2007-2015 HRBB,Inc.All Rights Reserved.
 */
package com.hrbb.loan.pos.service;

import com.hrbb.loan.pos.dao.entity.TCreditReportIdentity;

/**
 * 
 * @author marco
 * @version $Id: ReviewNoteService.java, v 0.1 2015-3-2 下午1:53:36 marco Exp $
 */
public interface CreditReportIdentityService {

	public TCreditReportIdentity selectInfor(String paperId);

}
