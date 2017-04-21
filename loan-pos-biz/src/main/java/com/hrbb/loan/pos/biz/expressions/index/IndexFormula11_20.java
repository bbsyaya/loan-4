/**
 * 
 *	哈尔滨银行
 * Copyright (c) 2007-2015 HRBB,Inc.All Rights Reserved.
 */
package com.hrbb.loan.pos.biz.expressions.index;

import java.math.BigDecimal;

import com.hrbb.loan.pos.dao.entity.TRiskCheckCalcIndex;
import com.hrbb.loan.pos.dao.entity.TRiskCheckModelIndex;
import com.hrbb.loan.pos.biz.constants.ChannelConstants;
import com.hrbb.loan.pos.biz.constants.RiskCheckConstants;

/**
 * 1.2.1.2 指标计算
 * 
 * @author XLY
 * @version $Id: IndexFormula11_20.java, v 0.1 2015-3-10 上午11:21:54 XLY Exp $
 */
public class IndexFormula11_20 {

	/**
	 * If(Model_Index-35 申请人贷款逾期月份数 > 10, Y, N)
	 * 
	 * @param modelIndex35
	 * @return
	 */
	public static String calcIndex11(Integer modelIndex40) {
		if (modelIndex40 == null)
			return RiskCheckConstants.N;
		return modelIndex40 > 10 ? RiskCheckConstants.Y : RiskCheckConstants.N;
	}

	/**
	 * If(Model_Index-36 申请人贷记卡逾期月份数 > 20, Y, N) *
	 * 
	 * @param modelIndex36
	 * @return
	 */
	public static String calcIndex12(Integer modelIndex41) {
		if (modelIndex41 == null)
			return RiskCheckConstants.N;
		return modelIndex41 > 20 ? RiskCheckConstants.Y : RiskCheckConstants.N;
	}

	/**
	 * If(Model_Index-20 申请人征信报告查询次数 > 25, Y, N)
	 * 
	 * @param modelIndex20
	 * @return
	 */
	public static String calcIndex13(Integer modelIndex20) {
		if (modelIndex20 == null)
			return RiskCheckConstants.N;
		return modelIndex20 > 25 ? RiskCheckConstants.Y : RiskCheckConstants.N;
	}

	/**
	 * If(Model_Index-42 申请人贷款当前逾期总金额> 1000, Y, N)
	 * 
	 * @param modelIndex20
	 * @return
	 */
	public static String calcIndex14(BigDecimal modelIndex42) {
		return modelIndex42.compareTo(new BigDecimal(1000)) > 0 ? RiskCheckConstants.Y
				: RiskCheckConstants.N;
	}

	/**
	 * If(Model_Index-43申请人贷记卡当前逾期总金额 > 1000, Y, N)
	 * 
	 * @param modelIndex43
	 * @return
	 */
	public static String calcIndex15(BigDecimal modelIndex43) {
		return modelIndex43.compareTo(new BigDecimal(1000)) > 0 ? RiskCheckConstants.Y
				: RiskCheckConstants.N;
	}

	/**
	 * If(Model_Index-44 配偶贷记卡逾期月份数 > 20, Y, N)
	 * 
	 * @param modelIndex44
	 * @return
	 */
	// public static BigDecimal calcIndex16(BigDecimal modelIndex44) {
	// return modelIndex45.compareTo(new BigDecimal(20)) > 0 ? BigDecimal.ONE
	// : BigDecimal.ZERO;
	// }

	/**
	 * If(Model_Index-46 配偶近6月征信查询数 > 20, Y, N)
	 * 
	 * @param modelIndex46
	 * @return
	 */
	// public static BigDecimal calcIndex17(BigDecimal modelIndex46) {
	// return modelIndex46.compareTo(new BigDecimal(20)) > 0 ? BigDecimal.ONE
	// : BigDecimal.ZERO;
	// }

	/**
	 * If(Model_Index-46 申请人贷款逾期月份数 > 10, Y, N)
	 * 
	 * @param modelIndex35
	 * @return
	 */
	public static String calcIndex18(Integer modelIndex46) {
		if (modelIndex46 == null)
			return RiskCheckConstants.N;
		return modelIndex46 > 3 ? RiskCheckConstants.Y : RiskCheckConstants.N;
	}

	/**
	 * If(Model_Index-47 申请人贷记卡逾期最长逾期月数> 1, Y, N)
	 * 
	 * @param modelIndex47
	 * @return
	 */
	public static String calcIndex19(Integer modelIndex47) {
		if (modelIndex47 == null)
			return RiskCheckConstants.N;
		return modelIndex47 > 1 ? RiskCheckConstants.Y : RiskCheckConstants.N;
	}

	/**
	 * Model_Index-48不同渠道POS流水判断
	 * 
	 * @param modelIndex48
	 * @return
	 */
	public static void calcIndex20(Integer modelIndex25, String posChannel,
			TRiskCheckCalcIndex b) {
		if (ChannelConstants.CH_UP.equals(posChannel)) {
			b.setCalcIndex20(modelIndex25 < 6 ? RiskCheckConstants.Y
					: RiskCheckConstants.N);
			b.setCalcIndex20_index(1);
		} else if (ChannelConstants.CH_YB.equals(posChannel)) {
			b.setCalcIndex20(modelIndex25 < 3 ? RiskCheckConstants.Y
					: RiskCheckConstants.N);
			b.setCalcIndex20_index(2);
		} else if (ChannelConstants.CH_YB.equals(posChannel)) {
			b.setCalcIndex20(modelIndex25 < 6 ? RiskCheckConstants.Y
					: RiskCheckConstants.N);
			b.setCalcIndex20_index(3);
		} else if (ChannelConstants.CH_KQ.equals(posChannel)) {
			b.setCalcIndex20(modelIndex25 < 3 ? RiskCheckConstants.Y
					: RiskCheckConstants.N);
			b.setCalcIndex20_index(4);
		} else if (ChannelConstants.CH_CY.equals(posChannel)) {
			b.setCalcIndex20(modelIndex25 < 6 ? RiskCheckConstants.Y
					: RiskCheckConstants.N);
			b.setCalcIndex20_index(5);
		} else if (ChannelConstants.CH_CY.equals(posChannel)) {
			b.setCalcIndex20(modelIndex25 < 3 ? RiskCheckConstants.Y
					: RiskCheckConstants.N);
			b.setCalcIndex20_index(6);
		}
	}

	public static void computer(TRiskCheckModelIndex m, TRiskCheckCalcIndex b,
			String channel) {
		b.setCalcIndex11(calcIndex11(m.getModelIndex40()));
		b.setCalcIndex12(calcIndex12(m.getModelIndex41()));
		b.setCalcIndex13(calcIndex13(m.getModelIndex20()));
		b.setCalcIndex14(calcIndex14(m.getModelIndex42()));
		b.setCalcIndex15(calcIndex15(m.getModelIndex43()));
		b.setCalcIndex16(m.getModelIndex44());
		b.setCalcIndex17(m.getModelIndex45());
		b.setCalcIndex18(calcIndex18(m.getModelIndex46()));
		b.setCalcIndex19(calcIndex19(m.getModelIndex47()));
		// b.setCalcIndex20(calcIndex20(m.getModelIndex25(), channel));
		calcIndex20(m.getModelIndex25(), channel, b);
	}
}
