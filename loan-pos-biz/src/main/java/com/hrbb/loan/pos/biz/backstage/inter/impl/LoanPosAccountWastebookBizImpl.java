package com.hrbb.loan.pos.biz.backstage.inter.impl;

import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import com.hrbb.loan.pos.biz.backstage.inter.LoanPosAccountWastebookBiz;
import com.hrbb.loan.pos.service.LoanPosAccountWastebookService;
import com.hrbb.loan.pos.service.RepaymentApplyService;
@Component("loanPosAccountWastebookBiz")
public class LoanPosAccountWastebookBizImpl implements LoanPosAccountWastebookBiz {
	@Autowired
	private LoanPosAccountWastebookService loanPosAccountWastebookService;
	@Override
	public int insertAccountWastebook(Map<String, Object> wasteMap) {
		return loanPosAccountWastebookService.insertAccountWastebook(wasteMap);
	}

}
