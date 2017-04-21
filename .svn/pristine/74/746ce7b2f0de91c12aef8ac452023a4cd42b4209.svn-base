package com.hrbb.loan.pos.biz.backstage.inter.impl;

import java.util.List;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import com.hrbb.loan.pos.biz.backstage.inter.ILoanPosBlacklistBackStageBiz;
import com.hrbb.loan.pos.dao.entity.TBlacklist;
import com.hrbb.loan.pos.service.LoanPosBlacklistService;

@Component("iLoanPosBlacklistBackStageBiz")
public class ILoanPosBlacklistBackStageBizImpl implements ILoanPosBlacklistBackStageBiz{

    @Autowired
    private LoanPosBlacklistService loanPosBlacklistService;
    
	/** 
	 * @see com.hrbb.loan.pos.biz.backstage.inter.ILoanPosBlacklistBackStageBiz#queryBlacklist(java.util.Map)
	 */
	@Override
	public List<Map<String, Object>> queryBlacklist(Map<String, Object> reqMap) {
		return null;
	}

	/** 
	 * @see com.hrbb.loan.pos.biz.backstage.inter.ILoanPosBlacklistBackStageBiz#insertBlacklist(java.util.Map)
	 */
	@Override
	public void insertBlacklist(Map<String, Object> reqMap) {
	}

	/** 
	 * @see com.hrbb.loan.pos.biz.backstage.inter.ILoanPosBlacklistBackStageBiz#insertBlacklists(java.util.List)
	 */
	@Override
	public int insertBlacklists(TBlacklist bl) {
		return loanPosBlacklistService.insertTBlacklists(bl);
	}

	/** 
	 * @see com.hrbb.loan.pos.biz.backstage.inter.ILoanPosBlacklistBackStageBiz#updateBlacklist(java.util.Map)
	 */
	@Override
	public void updateBlacklist(Map<String, Object> reqMap) {
	}

	
}
