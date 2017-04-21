package com.hrbb.loan.pos.service.impl;

import java.util.List;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import com.hrbb.loan.pos.dao.TcustomerAccountDao;
import com.hrbb.loan.pos.service.LoanPosCustomerAccountService;
@Service("loanPosCustomerAccountService")
public class LoanPosCustomerAccountServiceImpl implements LoanPosCustomerAccountService {
	@Autowired
	private TcustomerAccountDao tcustomerAccountDao;
	@Override
	public Map<String,Object> getCustomerAccountInfoByCustId(String custId) {
		return tcustomerAccountDao.getCustomerAccountInfoByCustId(custId);
	}
	@Override
	public int insertCustomerAccount(Map<String, Object> bankAccNoMap) {
		return tcustomerAccountDao.insertCustomerAccount(bankAccNoMap);
	}
	@Override
	public int updateCustomerAccount(Map<String, Object> bankAccNoMap) {
		return tcustomerAccountDao.updateCustomerAccount(bankAccNoMap);
	}
	@Override
	public List<Map<String, Object>> getAllInnerAccountList(Map<String, Object> accno) {
		return tcustomerAccountDao.getAllInnerAccountList(accno);
	}
	@Override
	public long countAccountNumber(Map<String, Object> accno) {
		return tcustomerAccountDao.countAccountNumber(accno);
	}

}
