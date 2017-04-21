package com.hrbb.loan.pos.service.impl;

import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Service;

import com.google.common.collect.Maps;
import com.hrbb.loan.pos.dao.TModelResultDao;
import com.hrbb.loan.pos.dao.entity.TModelResult;
import com.hrbb.loan.pos.service.CreditApplyRiskCheckService;

@Service("creditApplyRiskCheckService")
public class CreditApplyRiskCheckServiceImpl implements
		CreditApplyRiskCheckService {

	@Autowired
	@Qualifier("tModelResultDao")
	private TModelResultDao modelResultDao;
	
	@Override
	public String computeCreditScoreResult(String loanId) {
		Map<String, Object> reqMap = Maps.newHashMap();
		reqMap.put("no1", loanId);
		modelResultDao.deleteByLoanId(loanId);
		return modelResultDao.computeCreditScoreResult(reqMap);
	}

	@Override
	public TModelResult getModelResultByLoanId(String loanId) {
		return modelResultDao.getModelResultByLoanId(loanId);
	}

}
