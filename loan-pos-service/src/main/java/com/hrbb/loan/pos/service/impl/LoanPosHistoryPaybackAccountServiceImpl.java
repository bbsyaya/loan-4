package com.hrbb.loan.pos.service.impl;

import java.util.Map;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import com.hrbb.loan.pos.dao.THistoryPaybackAccountDao;
import com.hrbb.loan.pos.service.LoanPosHistoryPaybackAccountService;
@Service("loanPosHistoryPaybackAccountService")
public class LoanPosHistoryPaybackAccountServiceImpl implements
		LoanPosHistoryPaybackAccountService {
	@Autowired
	private THistoryPaybackAccountDao tHistoryPaybackAccountDao;
	@Override
	public int getHistroyAccountNumber(Map<String, Object> reqMap) {
		return tHistoryPaybackAccountDao.getHistroyAccountNumber(reqMap);
	}

}
