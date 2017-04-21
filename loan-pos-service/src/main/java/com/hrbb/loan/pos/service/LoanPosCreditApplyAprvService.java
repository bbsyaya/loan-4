package com.hrbb.loan.pos.service;

import java.util.List;
import java.util.Map;

import com.hrbb.loan.pos.dao.entity.TCreditApplyAprv;

/**
 *<h1>申请确认接口</h1>
 *@author Johnson Song
 *@version Id: CreditApplyAprvService.java, v 1.0 2015-2-16 上午11:52:57 Johnson Song Exp
 */
public interface LoanPosCreditApplyAprvService {

	public TCreditApplyAprv getTCreditApplyAprvById(String loanId, String appNum);
	
	public List<TCreditApplyAprv> getTCreditApplyAprvSelective(Map<String, Object> map);
	
	public int insertCreditApplyAprv(TCreditApplyAprv tCreditApplyAprv);
	
	public int updateCreditApplyAprv(TCreditApplyAprv tCreditApplyAprv);
	
	public int deleteCreditApplyAprv(String loanId, String appNum);
	
	public List<Map<String, Object>> getExpiredRecord(Map<String, Object> reqMap);
	
	public void updateExpiredRecord(Map<String, Object> reqMap);
	
	public void insertExpiredMessageBatch(List<Map<String, Object>> list);
	
	public void updateBatch(List<Map<String, Object>> list);
	
	public List<Map<String, Object>> selectCallTask(Map<String, Object> reqMap);
}
