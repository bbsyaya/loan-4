package com.hrbb.loan.pos.service.impl;

import java.util.List;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.hrbb.loan.pos.dao.TPaybackImportInfoDao;
import com.hrbb.loan.pos.dao.entity.TPaybackImportInfo;
import com.hrbb.loan.pos.service.LoanPosPaybackImportService;
@Service("loanPosPaybackImportService")
public class LoanPosPaybackImportServiceImpl implements
		LoanPosPaybackImportService {
	@Autowired
	private TPaybackImportInfoDao tPaybackImportInfoDao;
	@Override
	public List<TPaybackImportInfo> queryPaybackImportInfo(Map<String, Object> reqMap) {
		List<TPaybackImportInfo> l =tPaybackImportInfoDao.queryPaybackImportInfo(reqMap);
		return l;
	}
	@Override
	public List<TPaybackImportInfo> queryMatchedPaybackImportInfo(Map<String, Object> reqMap) {
		List<TPaybackImportInfo> l =tPaybackImportInfoDao.queryMatchedPaybackImportInfo(reqMap);
		return l;
	}
	@Override
	public TPaybackImportInfo getPaybackImportInfo(String importRunningId) {
		TPaybackImportInfo t =tPaybackImportInfoDao.getPaybackImportInfo(importRunningId);
		return t;
	}
	@Override
	public int updateImportInfo(Map<String, Object> updateImportMap) {
		return tPaybackImportInfoDao.updateImportInfo(updateImportMap);
		
	}
	@Override
	public List<TPaybackImportInfo> queryTransferInRecord(
			Map<String, Object> reqMap) {
		return tPaybackImportInfoDao.queryTransferInRecord(reqMap);
	}
	@Override
	public long countImportNumber(Map<String, Object> reqMap) {
		return tPaybackImportInfoDao.countImportNumber(reqMap);
	}
	@Override
	public Map<String, Object> getImportInfobyId(String importRunningId) {
		return tPaybackImportInfoDao.getImportInfobyId(importRunningId);
	}

}
