/**
 * 
 *	哈尔滨银行
 * Copyright (c) 2007-2015 HRBB,Inc.All Rights Reserved.
 */
package com.hrbb.loan.pos.biz.backstage.inter;

import com.hrbb.loan.pos.dao.entity.TCreditReportIdentity;

/**
 * 
 * @author marco
 * @version $Id: CreditReportIdentityBiz.java, v 0.1 2015-3-2 下午3:26:50 marco
 *          Exp $
 */
public interface CreditReportIdentityBiz {

	public TCreditReportIdentity selectInfor(String paperId);
}
