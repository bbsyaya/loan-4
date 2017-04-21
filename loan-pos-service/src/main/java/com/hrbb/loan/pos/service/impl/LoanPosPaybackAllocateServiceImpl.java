package com.hrbb.loan.pos.service.impl;

import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.hrbb.loan.pos.dao.TPaybackAllocateDao;
import com.hrbb.loan.pos.dao.TPaybackImportInfoDao;
import com.hrbb.loan.pos.service.LoanPosPaybackAllocateService;
@Service("loanPosPaybackAllocateService")
public class LoanPosPaybackAllocateServiceImpl implements
		LoanPosPaybackAllocateService {
	@Autowired
	private TPaybackAllocateDao tPaybackAllocateDao;
	@Override
	public int insertPaybackAllocate(Map<String, Object> map) {
		return tPaybackAllocateDao.insertPaybackAllocate(map);
	}

}
