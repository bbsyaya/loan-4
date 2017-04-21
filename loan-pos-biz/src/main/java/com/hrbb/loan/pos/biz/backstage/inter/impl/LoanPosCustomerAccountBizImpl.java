package com.hrbb.loan.pos.biz.backstage.inter.impl;

import java.util.List;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import com.hrbb.loan.pos.biz.backstage.inter.LoanPosCustomerAccountBiz;
import com.hrbb.loan.pos.service.LoanPosCustomerAccountService;
@Component("loanPosCustomerAccountBiz")
public class LoanPosCustomerAccountBizImpl implements LoanPosCustomerAccountBiz {
	@Autowired
	private LoanPosCustomerAccountService loanPosCustomerAccountService;
	@Override
	public Map<String,Object> getCustomerAccountInfoByCustId(String custId) {
		return loanPosCustomerAccountService.getCustomerAccountInfoByCustId(custId);
	}
	@Override
	public int insertCustomerAccount(Map<String, Object> bankAccNoMap) {
		return loanPosCustomerAccountService.insertCustomerAccount(bankAccNoMap);
		
	}
	@Override
	public int updateCustomerAccount(Map<String, Object> bankAccNoMap) {
		return loanPosCustomerAccountService.updateCustomerAccount(bankAccNoMap);
		
	}
	@Override
	public List<Map<String, Object>> getAllInnerAccountList(Map<String, Object> accno) {
		return loanPosCustomerAccountService.getAllInnerAccountList(accno);
	}
	@Override
	public long countAccountNumber(Map<String, Object> accno) {
		return loanPosCustomerAccountService.countAccountNumber(accno);
	}

}
