package com.hrbb.loan.pos.service;

import java.util.List;
import java.util.Map;

import com.hrbb.loan.pos.dao.entity.TRiskCheckCalcIndex;
import com.hrbb.loan.pos.dao.entity.TRiskCheckModelIndex;
import com.hrbb.loan.pos.dao.entity.TRiskCheckResult;

/**
 * 风险审核持久化相关
 * 
 * @author XLY
 * @version $Id: LoanRiskCheckService.java, v 0.1 2015-3-11 上午9:53:50 XLY Exp $
 */
public interface LoanRiskCheckService {

	public TRiskCheckResult selectRiskCheckResult(String loanId);

	public int insertRiskCheckResult(TRiskCheckResult record);

	public int deleteRiskCheckResult(String loanId);

	public TRiskCheckCalcIndex selectRiskCalcIndex(String loanId);

	public int deleteRiskCalcIndex(String loanId);

	public int insertRiskCalcIndex(TRiskCheckCalcIndex record);

	public TRiskCheckModelIndex selectRiskModelIndex(String loanId);

	public int deleteRiskModelIndex(String loanId);

	public int insertRiskModelIndex(TRiskCheckModelIndex record);

	public List<Map<String, Object>> selectForRiskDetection(String loanid);
}
