package com.hrbb.loan.pos.biz.backstage.inter.impl;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import org.springframework.stereotype.Service;

import com.hrbb.loan.pos.biz.backstage.inter.ICreditInvestigateDataReturnBiz;
import com.hrbb.loan.pos.service.LoanPosCreditApplyService;
import com.hrbb.loan.pos.service.LoanPosCustomerService;
import com.hrbb.loan.pos.service.ReceiptInfoService;

@Service("creditInvestigateDataReturnBiz")
public class CreditInvestigateDataReturnBizImpl implements
		ICreditInvestigateDataReturnBiz {
	
	@Autowired
	private LoanPosCustomerService loanPosCustomerService;
	
	@Autowired
	private ReceiptInfoService receiptInfoService;
	
	@Autowired
	private LoanPosCreditApplyService loanPosCreditApplyService;
	
	@Override
	public LoanPosCustomerService getCustomerService() {
		return loanPosCustomerService;
	}

	@Override
	public ReceiptInfoService getReceiptInfoService() {
		return receiptInfoService;
	}

	@Override
	public LoanPosCreditApplyService getLoanPosCreditApplyService() {
		return loanPosCreditApplyService;
	}

}
