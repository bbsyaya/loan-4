/**
 * 
 *	哈尔滨银行
 * Copyright (c) 2007-2015 HRBB,Inc.All Rights Reserved.
 */
package com.hrbb.loan.pos.biz.expressions.index;

import java.math.BigDecimal;

import com.hrbb.loan.pos.biz.constants.RiskCheckConstants;
import com.hrbb.loan.pos.dao.entity.TCreditReportIndicator;
import com.hrbb.loan.pos.dao.entity.TRiskCheckCalcIndex;
import com.hrbb.loan.pos.dao.entity.TRiskCheckModelIndex;
import com.hrbb.loan.pos.factory.CityFactory;

/**
 * 1.2.1.2 指标计算
 * 
 * @author XLY
 * @version $Id: IndexFormula31_36.java, v 0.1 2015-3-10 上午11:27:15 XLY Exp $
 */
public class IndexFormula31_36 {

	/**
	 * If(Model_Index-04 申请人首笔贷款发放距今月份数<12 && Model_Index-05 申请人首张信用卡发卡距今月份数<
	 * 24, Y, N)
	 * 
	 * @param modelIndex04
	 *            ,modelIndex05
	 * @return
	 */
	public static String calcIndex31(BigDecimal modelIndex04,
			BigDecimal modelIndex05, Integer cr126) {
		if (modelIndex04 == null) {
			modelIndex04 = BigDecimal.ZERO;
		}
		if (modelIndex05 == null) {
			modelIndex05 = BigDecimal.ZERO;
		}
		if (modelIndex04.compareTo(new BigDecimal(12)) < 0
				&& modelIndex05.compareTo(new BigDecimal(24)) < 0
				&& cr126.intValue() < 2) {
			return RiskCheckConstants.Y;
		}
		return RiskCheckConstants.N;
	}

	/**
	 * If(Model_Index-52 贷记卡前6个月逾期次数 >1, Y, N)
	 * 
	 * @param modelIndex52
	 * @return
	 */
	public static String calcIndex32(Integer modelIndex52) {
		if (modelIndex52 > 1) {
			return RiskCheckConstants.Y;
		}
		return RiskCheckConstants.N;
	}

	/**
	 * If((Model_Index-53 一年内到期的贷款余额 < 800 && Model_Index-50 半年内到期贷款余额 < 500 &&
	 * Model_Index-51 2个月内到期贷款余额 < 300), Y, N)
	 * 
	 * @param modelIndex50
	 *            ,modelIndex51,modelIndex53
	 * @return
	 */
	public static String calcIndex33(String region, BigDecimal modelIndex50,
			BigDecimal modelIndex51, BigDecimal modelIndex53) {

		BigDecimal debt2 = null;
		BigDecimal debt6 = null;
		BigDecimal debt12 = null;
		// 一线城市
		if (CityFactory.isFirsttierCity4(region)) {
			debt2 = new BigDecimal(550);
			debt6 = new BigDecimal(800);
			debt12 = new BigDecimal(1500);
			// 其他省会城市
		} else if (CityFactory.isCapitalCity(region)) {
			debt2 = new BigDecimal(550);
			debt6 = new BigDecimal(800);
			debt12 = new BigDecimal(1200);
			// 其他城市
		} else {
			debt2 = new BigDecimal(330);
			debt6 = new BigDecimal(500);
			debt12 = new BigDecimal(800);
		}
		if (modelIndex50.compareTo(debt6) >= 0
				|| modelIndex51.compareTo(debt2) >= 0
				|| modelIndex53.compareTo(debt12) >= 0) {
			return RiskCheckConstants.Y;
		}
		return RiskCheckConstants.N;
	}

	/**
	 * If((CR115 近1个月贷款查询机构数 <=3 && CR116 近1个月贷记卡查询机构数<=5 && CR117 近1个月本人查询次数 <=
	 * 5 && CR119 近1个月查询总次数 <= 8 && CR113 近3个月贷款查询机构数 <= 5 && CR114 近3个月贷记卡查询机构数
	 * <=7 && CR118 近3个月查询总次数 <= 12 && CR111 近6个月贷款查询机构数 <= 8 && CR112
	 * 近6个月贷记卡查询机构数 <= 10 && CR068 近6个月查询机构数 <= 18 ), Y, N)
	 * 
	 * 
	 * @param crBean
	 * @return
	 */
	public static String calcIndex34(TCreditReportIndicator crBean) {
		if (crBean.getCR115() > 3 || crBean.getCR116() > 5
				|| crBean.getCR117() > 5 || crBean.getCR119() > 8
				|| crBean.getCR113() > 5 || crBean.getCR114() > 7
				|| crBean.getCR118() > 12 || crBean.getCR111() > 8
				|| crBean.getCR112() > 10 || crBean.getCR068() > 18) {
			return RiskCheckConstants.Y;
		}
		return RiskCheckConstants.N;
	}

	/**
	 * If(贷款或 贷记卡申请人行征信查询次数超下限, Y, N)
	 * 
	 * 
	 * @param crBean
	 * @return
	 */
	public static String calcIndex35(TCreditReportIndicator crBean) {
		int count1 = crBean.getCR115() + crBean.getCR116();
		int count3 = crBean.getCR113() + crBean.getCR114();
		if (count1 > 5 || count3 > 8) {
			return RiskCheckConstants.Y;
		}
		return RiskCheckConstants.N;
	}

	/**
	 * If(近6个月查询次数占近12个月查询次数75%以上, Y, N)
	 * 
	 * 
	 * @param crBean
	 * @return
	 */
	public static String calcIndex36(BigDecimal modelIndex15) {
		if (modelIndex15.compareTo(new BigDecimal(0.75)) > 0) {
			return RiskCheckConstants.Y;
		}
		return RiskCheckConstants.N;
	}

	public static void computer(TRiskCheckModelIndex m, TRiskCheckCalcIndex b,
			TCreditReportIndicator crBean, String region) {
		b.setCalcIndex31(calcIndex31(m.getModelIndex04(), m.getModelIndex05(),
				crBean.getCR126()));
		b.setCalcIndex32(calcIndex32(m.getModelIndex52()));
		b.setCalcIndex33(calcIndex33(region, m.getModelIndex50(),
				m.getModelIndex51(), m.getModelIndex53()));
		b.setCalcIndex34(calcIndex34(crBean));
		b.setCalcIndex35(calcIndex35(crBean));
		b.setCalcIndex36(calcIndex36(m.getModelIndex15()));
	}
}
