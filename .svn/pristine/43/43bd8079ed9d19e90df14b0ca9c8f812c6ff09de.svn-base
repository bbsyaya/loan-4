/**
 * 
 *	哈尔滨银行
 * Copyright (c) 2007-2015 HRBB,Inc.All Rights Reserved.
 */
package com.hrbb.loan.pos.biz.expressions.mult;

import java.math.BigDecimal;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.util.StringUtils;

import com.hrbb.loan.pos.biz.expressions.bean.MultResultBean;
import com.hrbb.loan.pos.dao.entity.TRiskCheckCalcIndex;
import com.hrbb.loan.pos.dao.entity.TRiskCheckModelIndex;
import com.hrbb.loan.pos.biz.constants.RiskCheckConstants;
import com.hrbb.loan.pos.util.MathUtils;

/**
 * 1.3.2.4 贷款定价建议
 * 
 * @author XLY
 * @version $Id: LoanPricingComputer.java, v 0.1 2015-3-10 下午3:09:21 XLY Exp $
 */
public class LoanPricingComputer {

	private final static Logger logger = LoggerFactory
			.getLogger(LoanPricingComputer.class);
	
	private final static double 贷款利率_上限 = 0.174;
	
	private final static double 贷款利率_下限 = 0.11;

	public static BigDecimal computer(MultResultBean multResultBean,
			TRiskCheckModelIndex mb, TRiskCheckCalcIndex cib, String certNo,
			String mateCertNo) {
		return computer(multResultBean, new BigDecimal(mb.getModelIndex20()),
				cib.getCalcIndex36(), cib.getCalcIndex06(),
				cib.getCalcIndex07(), cib.getCalcIndex04(), certNo, mateCertNo);
	}

	/**
	 * 
	 * 1.2.2.4 贷款定价建议
	 * 
	 * @param multResultBean
	 * @param modelIndex20
	 * @param calcIndex05
	 * @param calcIndex10k
	 * @param calcIndex06
	 * @param calcIndex07
	 * @param certNo
	 * @param channel
	 * @return
	 */
	public static BigDecimal computer(MultResultBean multResultBean,
			BigDecimal modelIndex20, String calcIndex36, String calcIndex06,
			String calcIndex07, String calcIndex04, String certNo,
			String mateCertNo) {
		BigDecimal n1 = new BigDecimal(0.0073).multiply(
				multResultBean.getFinalModelScore()).subtract(
				new BigDecimal(0.8209));

		double pb1 = Math.exp(new BigDecimal(1).divide(n1, 6,
				BigDecimal.ROUND_HALF_UP).doubleValue());
		logger.debug("pb1=" + pb1);

		BigDecimal n2 = new BigDecimal(-0.0097).multiply(modelIndex20).add(
				new BigDecimal(-0.1189));
		double n3 = new BigDecimal(1).divide(n2, 6, BigDecimal.ROUND_HALF_UP)
				.doubleValue();
		double pb2 = Math.exp(n3);
		logger.debug("pb2=" + pb2);

		BigDecimal pb3 = BigDecimal.ZERO;
		if (RiskCheckConstants.Y.equals(calcIndex07)) {
			pb3 = pb3.add(BigDecimal.ONE);
		}
		if (RiskCheckConstants.Y.equals(calcIndex04)
				&& RiskCheckConstants.Y.equals(calcIndex36)) {
			pb3 = pb3.add(BigDecimal.ONE);
		}
		// if (RiskCheckConstants.Y.equals(calcIndex36)) {
		// pb3 = pb3.add(BigDecimal.ONE);
		// }
		if (RiskCheckConstants.Y.equals(calcIndex06)) {
			pb3 = pb3.add(BigDecimal.ONE);
		}
		pb3 = MathUtils.div(pb3, new BigDecimal(100));
		logger.debug("pb3=" + pb3);

		// BigDecimal pb3 =
		// calcIndex07.add(calcIndex06).add(calcIndex10).add(calcIndex05);
		BigDecimal pb4 = BigDecimal.ZERO;
		if (RiskCheckConstants.paperId_3303.equals(certNo.substring(0, 4))) {
			pb4 = pb4.add(new BigDecimal(0.02));
		} else {
			if (!StringUtils.isEmpty(mateCertNo)
					&& RiskCheckConstants.paperId_3303.equals(mateCertNo
							.substring(0, 4))) {
				pb4 = pb4.add(new BigDecimal(0.02));
			}
		}
		logger.debug("pb4=" + pb4);

		// BigDecimal pb4 = "3303".equals(certNo.substring(0, 4)) ? new
		// BigDecimal(
		// 0.02) : BigDecimal.ZERO;

		BigDecimal base1 = new BigDecimal(0.0985).add(new BigDecimal(pb1))
				.add(new BigDecimal(pb2)).add(pb3).add(pb4);
		Integer base2 = base1.divide(new BigDecimal(0.005), 0,
				BigDecimal.ROUND_HALF_UP).intValue();
		// if (ChannelConstants.CH_QM.equals(channel)) {
		// BigDecimal base3 = MathUtils.getMax(MathUtils.getMin(
		// new BigDecimal(base2 * 0.005), new BigDecimal(0.24)),
		// new BigDecimal(0.11));
		// return base3;
		// } else {
		BigDecimal base3 = MathUtils.getMax(MathUtils.getMin(new BigDecimal(
				base2 * 0.005), new BigDecimal(贷款利率_上限)), new BigDecimal(贷款利率_下限));
		return base3.setScale(4, BigDecimal.ROUND_HALF_UP);
		// }
	}

	/**
	 * （六）、利率调整
	 * 
	 * @param finalModelCl
	 * @param finalModelP
	 * @return
	 */
	public static BigDecimal computerForAdjust(BigDecimal finalModelCl,
			BigDecimal finalModelP) {
		// 1．基于额度调整利率
		// 将授信额度不大于40万并且利率小于12.5% 的客户授信利率统一提高到12.5%。其他情况的利率不做调整
		if (finalModelCl.compareTo(new BigDecimal(400000)) < 1) {
			logger.debug("授信额度finalModelCl不大于40万");
			finalModelP = MathUtils.getMax(new BigDecimal(0.125), finalModelP);
		}
		logger.debug("finalModelP=" + finalModelP);
		return finalModelP;
	}
}
