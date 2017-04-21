/**
 * 
 *	哈尔滨银行
 * Copyright (c) 2007-2015 HRBB,Inc.All Rights Reserved.
 */
package com.hrbb.loan.pos.biz.expressions.index;

import java.math.BigDecimal;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import com.hrbb.loan.pos.dao.entity.TCreditReportIndicator;

/**
 * 
 * @author marco
 * @version $Id: RiskCheckResultStockCustFormula.java, v 0.1 2015-2-17 下午9:31:45
 *          marco Exp $
 */
public class RiskCheckResultStockCustFormula {

	private final static Logger logger = LoggerFactory
			.getLogger(RiskCheckResultStockCustFormula.class);

	/**
	 * 非存量客户
	 * 
	 * @param result
	 * @return
	 */
	public static boolean checkNotStockCustomer(int risk_tier,
			BigDecimal final_model_score, BigDecimal final_model_cl,
			String paperId, TCreditReportIndicator cri, String posCustName,
			String mobile) {
		logger.debug("checkNotStockCustomer begin");
		// 1) 风险等级为0；
		logger.debug("risk_tier=" + risk_tier);
		if (risk_tier != 0) {
			return false;
		}
		// 2) 模型评分大于等于95分；
		logger.debug("final_model_score=" + final_model_score);
		if (final_model_score.compareTo(new BigDecimal(95)) >= 0) {
			return false;
		}
		// 3) 额度小于等于5万；
		logger.debug("final_model_cl=" + final_model_cl);
		if (final_model_cl.compareTo(new BigDecimal(50000)) <= 0) {
			return false;
		}
		// 4) 地区：排除北京地区以外；
		// 5) 仅开放银联渠道；
		logger.debug("paperId=" + paperId);
		// 6) 注册年限大于等于8年，并且近三年法人未做过变更，并且工商查询结果为正常（若出现停业、吊销、注销等，需人工干预）；
		// a) 法人变更判断条件：通过工商接口信息中“历史变更信息”中的变更事项为“法人代表变更”且“变更日期”距当前三年以上；
		// 7) 公安网身份证查询结果正常（公安网身份证与申请人身份证结果查询一致）；
		// 8) 人行历史单位近3年与申请单位一致；
		logger.debug("posCustName=" + posCustName);
		logger.debug("cri.getCR021=" + cri.getCR021());
		logger.debug("cri.getCR022=" + cri.getCR022());
		logger.debug("cri.getCR023=" + cri.getCR023());
		if (!posCustName.equals(cri.getCR021())
				|| !posCustName.equals(cri.getCR022())
				|| !posCustName.equals(cri.getCR023())) {
			return false;
		}
		// 9) 人行手机与申请人表填写手机一致；
		logger.debug("mobile=" + mobile);
		logger.debug("cri.getCR009=" + cri.getCR009());
		if (!mobile.equals(cri.getCR009())) {
			return false;
		}
		// 10) 法院信息：法院已结案，执行金额小于5千，立案时间大于等于3年。
		logger.debug("checkNotStockCustomer end");
		return true;
	}

	/**
	 * 存量客户
	 * 
	 * @param result
	 * @return
	 */
	public static boolean checkStockCustomer(String loanId, String paperId,
			String mobile, String mobileCR) {
		logger.debug("checkStockCustomer end");
		// 1) 我行还款正常；
		// 2) 人行信用正常，规则如下：
		// a) 人行贷款无当前逾期，关注，可疑，次级，损失，呆账，展期
		// b) 人行信用卡无当前逾期，冻结，呆账
		// c) 人行贷款历史近6个月逾期次数小于等于2
		// d) 人行信用卡历史近6个月逾期次数小于等于2
		// e) 人行贷款历史近12个月逾期次数小于等于3
		// f) 人行信用卡历史近12个月逾期次数小于等于3
		// g) 人行准贷记卡历史近12个月逾期期数小于等于3
		// h) 人行近2个月信用卡，贷款审批次数小于等于20
		// i) 人行信用卡或贷款最大逾期金额小于5K
		// 3) 人行负债正常，规则如下：
		// a) 人行当前负债低于历史最高值的150%
		// b) 人行近三期人行报告负债均呈上升趋势，并累计上升超过50%
		// c) 当前人行较最近一期人行负债上升40%
		// 4) 手机与原手机未发生过变动；
		logger.debug("mobile=" + mobile);
		logger.debug("mobileCR=" + mobileCR);
		if (!mobile.equals(mobileCR)) {
			return false;
		}
		// 5) POS流水未发生重大异常，规则如下：
		// a) 当前POS流水近三个月月均交易金额呈下降趋势，且累计降幅达50%
		// b) 当前POS流水较上月月均交易金额下降50%
		// c) 当前POS流水月均交易金额环比上升300%
		// 6) 工商网结果查询为正常（若出现停业、吊销、注销等，需人工干预）；
		// 7) 法院信息：法院已结案，执行金额小于5千，立案时间大于等于3年；
		// 8) 其他。
		logger.debug("checkStockCustomer end");
		return true;
	}
}
