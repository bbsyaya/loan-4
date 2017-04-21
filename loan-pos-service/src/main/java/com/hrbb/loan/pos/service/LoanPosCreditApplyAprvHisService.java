package com.hrbb.loan.pos.service;

import java.util.List;
import java.util.Map;

import com.hrbb.loan.pos.dao.entity.TCreditApplyAprvHis;

/**
 *<h1>业务申请确认历史接口</h1>
 *@author Johnson Song
 *@version Id: CreditApplyAprvHisService.java, v 1.0 2015-2-16 下午4:40:49 Johnson Song Exp
 */
public interface LoanPosCreditApplyAprvHisService {

	public TCreditApplyAprvHis getTCreditApplyAprvHisById(String loanId, String appNum);
	
	public List<TCreditApplyAprvHis> getSelective(Map<String, Object> map);
	
	public int insertCreditApplyAprvHis(TCreditApplyAprvHis req);
	
	public int updateCreditApplyAprvHis(TCreditApplyAprvHis req);
	
	public int deleteCreditApplyAprvHis(String loanId, String appNum);
	
}
