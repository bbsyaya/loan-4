package com.hrbb.loan.pos.service.impl;

import java.util.List;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.hrbb.loan.pos.dao.TPaybackApplyInfoDao;
import com.hrbb.loan.pos.dao.entity.TPaybackApplyInfo;
import com.hrbb.loan.pos.service.LoanPosPaybacApplykService;

@Service("loanPosPaybackApplyService")
public class LoanPosPaybacApplykServiceImpl implements LoanPosPaybacApplykService {
	@Autowired
	private TPaybackApplyInfoDao tPaybackApplyInfoDao;
	@Override
	public List<TPaybackApplyInfo> getPaybackApplyMap(Map<String, Object> reqMap) {
		List<TPaybackApplyInfo> l =tPaybackApplyInfoDao.getPaybackApplyInfo(reqMap);
		return l;
	}
	@Override
	public int updatePaybackApply(Map<String, Object> updateMap) {
		return tPaybackApplyInfoDao.updatePaybackApply(updateMap);
	}
    @Override
    public List<Map<String, Object>> queryPaybackDetailsByMaps(Map<String, Object> map) {
        return tPaybackApplyInfoDao.selectPaybackDetailsByMaps(map);
    }
    @Override
    public List<Map<String, Object>> queryPaybackDetailsBySlApp(Map<String, Object> map) {
        return tPaybackApplyInfoDao.selectPaybackDetailsBySlApp(map);
    }

	@Override
	public long countNumber(Map<String, Object> reqMap) {
		 return tPaybackApplyInfoDao.countNumber(reqMap);
	}

	@Override
	public TPaybackApplyInfo selectByPrimaryKey(String paybackApplyId) {
		return tPaybackApplyInfoDao.selectByPrimaryKey(paybackApplyId);
	}
    @Override
    public List<String> queryPaybackApplyIdList02() {
        return tPaybackApplyInfoDao.queryPaybackApplyIdList02();
    }
    @Override
    public int updatePaybackApplyInfo(String paybackApplyId) {
        return tPaybackApplyInfoDao.updatePaybackApplyInfo(paybackApplyId);
    }
    @Override
    public List<TPaybackApplyInfo> queryPaybackApplyInfo01() {
        return tPaybackApplyInfoDao.queryPaybackApplyInfo01();
    }
    @Override
    public TPaybackApplyInfo queryPaybackApplyInfo(Map<String, Object> reqMap) {
        return tPaybackApplyInfoDao.queryPaybackApplyInfo(reqMap);
    }

}
