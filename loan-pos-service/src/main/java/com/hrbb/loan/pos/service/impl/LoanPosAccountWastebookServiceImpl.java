package com.hrbb.loan.pos.service.impl;

import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.hrbb.loan.pos.dao.TAccountWastebookDao;
import com.hrbb.loan.pos.dao.TContractInfoDao;
import com.hrbb.loan.pos.service.LoanPosAccountWastebookService;
@Service("LoanPosAccountWastebookService")
public class LoanPosAccountWastebookServiceImpl implements LoanPosAccountWastebookService {
	@Autowired
	private TAccountWastebookDao tAccountWastebookDao;
	@Override
	public int insertAccountWastebook(Map<String, Object> wasteMap) {
		return tAccountWastebookDao.insertAccountWastebook(wasteMap);
	}

}
