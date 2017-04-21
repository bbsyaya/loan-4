/**
 * 
 *	哈尔滨银行
 * Copyright (c) 2007-2015 HRBB,Inc.All Rights Reserved.
 */
package com.hrbb.loan.pos.biz.backstage.inter;

import java.util.Map;

import com.hrbb.loan.pos.dao.entity.TApproveResult;

/**
 * 
 * @author marco
 * @version $Id: ApproveResultBiz.java, v 0.1 2015-6-23 下午7:51:24 marco Exp $
 */
public interface ApproveResultBiz {

	TApproveResult selectByPrimaryKey(String approveId);
	public Map<String, Object> getApproveMap(String approveId);
	public TApproveResult selectByLoanId(String loanId);
	int updateApproveResultInfo(Map<String, Object> approveBankMap);
}
