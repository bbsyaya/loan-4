package com.hrbb.loan.pos.service.impl;

import java.util.List;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.hrbb.loan.pos.dao.TPaybackRunningRecordDao;
import com.hrbb.loan.pos.service.LoanPosPaybackRunningRecordService;
@Service("loanPosPaybackRunningRecordService")
public class LoanPosPaybackRunningRecordServiceImpl implements LoanPosPaybackRunningRecordService {
	@Autowired
	private TPaybackRunningRecordDao tPaybackRunningRecordDao;
	@Override
	public List<Map<String, Object>> getPaybackRunningRecordList(
			Map<String, Object> reqMap) {
		
		return tPaybackRunningRecordDao.getPaybackRunningRecordList(reqMap);
	}
	@Override
	public int insertPaybackRunningInfo(Map<String, Object> runnningMap) {
		return tPaybackRunningRecordDao.insertPaybackRunningInfo(runnningMap);
	}
	@Override
	public List<Map<String, Object>> queryPaybackRunningInfo(Map<String, Object> reqMap) {
		return tPaybackRunningRecordDao.queryPaybackRunningInfo(reqMap);
	}
	@Override
	public List<Map<String, Object>> queryPaybackRunnigRecordByReceiptId(
			Map<String, Object> reqMap) {
		// TODO Auto-generated method stub
		return tPaybackRunningRecordDao.queryPaybackRunnigRecordByReceiptId(reqMap);
	}
	@Override
	public long countNumber(Map<String, Object> reqMap) {
		return tPaybackRunningRecordDao.countNumber(reqMap);
	}
    public Map<String, Object> getPdfInfo(String paybackRunningRecordId) {
        return tPaybackRunningRecordDao.queryPdfInfo(paybackRunningRecordId);
    }

}
