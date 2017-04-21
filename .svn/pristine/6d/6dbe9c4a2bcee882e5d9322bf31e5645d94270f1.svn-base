/**
 * 
 *	哈尔滨银行
 * Copyright (c) 2007-2015 HRBB,Inc.All Rights Reserved.
 */
package com.hrbb.loan.pos.biz.expressions.mult;

import java.math.BigDecimal;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import com.hrbb.loan.pos.biz.expressions.bean.MultResultBean;
import com.hrbb.loan.pos.util.MathUtils;

/**
 * 1.2.2.3 模型综合评
 * 
 * @author XLY
 * @version $Id: MultComputer.java, v 0.1 2015-3-10 下午2:41:43 XLY Exp $
 */
public class MultComputer {

	private final static Logger logger = LoggerFactory
			.getLogger(MultComputer.class);

	public static final BigDecimal CUT_SCORE;
	public static final BigDecimal MAX_SCORE;
	public static final int RISK_MODEL_NUM;

	static {
		CUT_SCORE = new BigDecimal(30);
		MAX_SCORE = new BigDecimal(51);
		RISK_MODEL_NUM = 10;
	}

	public static MultResultBean computer(BigDecimal scoreProfile,
			BigDecimal scoreBureau) {
		MultResultBean bean = new MultResultBean();
		BigDecimal rawModelScore = scoreProfile.add(scoreBureau);
		logger.debug("rawModelScore=" + rawModelScore);
		// BigDecimal num0 = MAX_SCORE.subtract(CUT_SCORE);
		// BigDecimal num1 = rawModelScore.subtract(CUT_SCORE);
		// BigDecimal num2 = MathUtils.div((new BigDecimal(100)).multiply(num1),
		// num0);
		// BigDecimal num3 = MathUtils.getMax(BigDecimal.ZERO, num2);
		// BigDecimal finalModelScore = MathUtils
		// .getMin(new BigDecimal(100), num3);
		BigDecimal finalModelScore = MathUtils.div(new BigDecimal(100),
				MAX_SCORE).multiply(rawModelScore);
		logger.debug("finalModelScore=" + finalModelScore);
		// Integer no1 = MathUtils.div(finalModelScore, new BigDecimal(10))
		// .intValue();
		// BigDecimal no2 = RISK_MODEL_NUM.subtract(new BigDecimal(no1));
		// BigDecimal riskTier = MathUtils.getMax(BigDecimal.ZERO, no2);
		BigDecimal no1 = MathUtils.div(
				MathUtils.getMax(finalModelScore, new BigDecimal(10)),
				new BigDecimal(10));
		logger.debug("no1=" + no1);
		Integer no2 = MathUtils.round(no1, BigDecimal.ONE).intValue();
		logger.debug("no2=" + no2);
		int riskTier = RISK_MODEL_NUM - no2;
		logger.debug("riskTier=" + riskTier);
		bean.setRawModelScore(rawModelScore);
		bean.setFinalModelScore(finalModelScore);
		bean.setRiskTier(riskTier);
		bean.setCutScore(CUT_SCORE);
		logger.debug("CUT_SCORE=" + CUT_SCORE);
		bean.setMaxScore(MAX_SCORE);
		logger.debug("MAX_SCORE=" + MAX_SCORE);
		return bean;
	}
}
