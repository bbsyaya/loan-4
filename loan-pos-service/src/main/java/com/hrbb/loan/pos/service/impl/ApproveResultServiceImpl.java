/**
 * 
 *	哈尔滨银行
 * Copyright (c) 2007-2015 HRBB,Inc.All Rights Reserved.
 */
package com.hrbb.loan.pos.service.impl;

import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.hrbb.loan.pos.dao.TApproveResultDao;
import com.hrbb.loan.pos.dao.entity.TApproveResult;
import com.hrbb.loan.pos.service.ApproveResultService;

/**
 * 
 * @author marco
 * @version $Id: ApproveResultServiceImpl.java, v 0.1 2015-6-23 下午7:45:25 marco Exp $
 */
@Service("approveResultService")
public class ApproveResultServiceImpl implements ApproveResultService {

	@Autowired
	private TApproveResultDao dao;

	/** 
	 * @see com.hrbb.loan.pos.service.ApproveResultService#selectByPrimaryKey(java.lang.String)
	 */
	@Override
	public TApproveResult selectByPrimaryKey(String approveId) {
		return dao.selectByPrimaryKey(approveId);
	}
	
	/** 
	 * @see com.hrbb.loan.pos.service.ApproveResultService#selectByPrimaryKey(java.lang.String)
	 */
	@Override
	public Map<String, Object> getApproveMap(String approveId) {
		return dao.getApproveMap(approveId);
	}
	
	/** 
	 * @see com.hrbb.loan.pos.service.ApproveResultService#selectByPrimaryKey(java.lang.String)
	 */
	@Override
	public TApproveResult selectByLoanId(String loanId) {
		return dao.selectByLoanId(loanId);
	}

	@Override
	public int updateApproveResultInfo(Map<String, Object> approveBankMap) {
		 return dao.updateApproveResultInfo(approveBankMap);
		
	}
}
