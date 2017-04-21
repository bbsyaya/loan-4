package com.hrbb.loan.pos.service;

import java.util.Map;

import com.hrbb.loan.pos.dao.entity.TApproveResult;

public interface ApproveResultService {

    TApproveResult selectByPrimaryKey(String approveId);
    public Map<String, Object> getApproveMap(String approveId);
	public TApproveResult selectByLoanId(String loanId);
	int updateApproveResultInfo(Map<String, Object> approveBankMap);
}