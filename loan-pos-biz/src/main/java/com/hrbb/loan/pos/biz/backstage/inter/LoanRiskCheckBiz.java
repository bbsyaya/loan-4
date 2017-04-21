package com.hrbb.loan.pos.biz.backstage.inter;

import java.io.File;
import java.util.List;
import java.util.Map;

import com.hrbb.loan.pos.dao.entity.TCreditReportIndicator;
import com.hrbb.loan.pos.dao.entity.TRiskCheckResult;

/**
 * 
 * 
 * @author XLY
 * @version $Id: LoanRiskCheckBiz.java, v 0.1 2015-3-9 下午4:26:40 XLY Exp $
 */
public interface LoanRiskCheckBiz {

	/**
	 * 发起风险初审
	 * 
	 * @param loanId
	 * @return
	 */
	public TRiskCheckResult execRiskCheck(String loanId);

	/**
	 * 查询风险初审的结果
	 * 
	 * @param loanId
	 * @return
	 */
	public TRiskCheckResult queryRiskCheckResult(String loanId);

	/**
	 * 插入征信报告指标表；计算Model_Index，并插入表；计算Calc_Index，并插入表
	 * 
	 * @param cri
	 * @param loanId
	 * @return 1：正常；0：异常
	 */
	public int insertCreditReport(TCreditReportIndicator cri, String loanId);

	/**
	 * 上传模型结果excel
	 * 
	 * @param cri
	 * @param loanId
	 */
	public boolean uploadModelResult(File file);

	public List<Map<String, Object>> selectForRiskDetection(String loanid);
}
