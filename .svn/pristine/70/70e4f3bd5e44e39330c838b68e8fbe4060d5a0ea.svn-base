/**
 * 
 *	哈尔滨银行
 * Copyright (c) 2007-2015 HRBB,Inc.All Rights Reserved.
 */
package com.hrbb.loan.pos.biz.expressions.index;

import java.math.BigDecimal;
import java.util.Calendar;
import java.util.HashSet;
import java.util.Set;

import org.springframework.util.StringUtils;

import com.hrbb.loan.pos.dao.entity.TCreditReportIndicator;
import com.hrbb.loan.pos.dao.entity.TPosCustInfo;
import com.hrbb.loan.pos.dao.entity.TRiskCheckCalcIndex;
import com.hrbb.loan.pos.dao.entity.TRiskCheckModelIndex;
import com.hrbb.loan.pos.biz.constants.ChannelConstants;
import com.hrbb.loan.pos.biz.constants.RiskCheckConstants;

/**
 * 1.2.1.2 指标计算
 * 
 * @author XLY
 * @version $Id: IndexFormula21_30.java, v 0.1 2015-3-10 上午11:27:15 XLY Exp $
 */
public class IndexFormula21_30 {

	private static Set<String> orgSet = new HashSet<String>();
	static {
		orgSet.add("投资");
		orgSet.add("担保");
		orgSet.add("财富");
		orgSet.add("财务");
		orgSet.add("抵押");
		orgSet.add("贷");
		orgSet.add("资产");
		orgSet.add("典当");
	}
	private final static String orgStr = "咨询";

	/**
	 * 银联：Model_Index-29 最近交易月份数 1) 银联：Model_Index-29 最近交易月份数 < 4
	 * 
	 * @param modelIndex49
	 * @return
	 */
	public static void calcIndex21(Integer modelIndex29, String channel,
			TRiskCheckCalcIndex b) {
		if (ChannelConstants.CH_UP.equals(channel)) {
			b.setCalcIndex21(modelIndex29 < 4 ? RiskCheckConstants.Y
					: RiskCheckConstants.N);
			b.setCalcIndex21_index(1);
		} else {
			b.setCalcIndex21(RiskCheckConstants.N);
		}
	}

	/**
	 * If(业务申请时间-Model_Index-30最近的POS年月 > 1, Y, N)
	 * 
	 * @param modelIndex30
	 * @return
	 */
	public static String calcIndex22(Integer modelIndex30) {
		if (modelIndex30 == 0) {
			return RiskCheckConstants.Y;
		} else {
			Calendar today = Calendar.getInstance();
			int year = today.get(Calendar.YEAR);
			int month = today.get(Calendar.MONTH) + 1;
			if (year * 100 + month - modelIndex30 > 1) {
				return RiskCheckConstants.Y;
			} else {
				return RiskCheckConstants.N;
			}
		}
	}

	/**
	 * 不同渠道POS流水判断条件如下： 1) 银联：Model_Index-29最近交易月份数 * Model_Index-26平均月交易金额 <
	 * 120000； 2) 易宝：Model_Index-26平均月交易金额 < 50000； 3) 快钱：Model_Index-26平均月交易金额
	 * < 50000； 4) 四川烟草：Model_Index-26平均月交易金额 < 50000；
	 * 
	 * @param modelIndex20
	 * @return
	 */
	public static void calcIndex23(BigDecimal modelIndex26,
			Integer modelIndex29, String channel, TRiskCheckCalcIndex b) {
		if (ChannelConstants.CH_UP.equals(channel)) {
			b.setCalcIndex23(modelIndex26
					.multiply(new BigDecimal(modelIndex29)).compareTo(
							new BigDecimal(120000)) < 0 ? RiskCheckConstants.Y
					: RiskCheckConstants.N);
			b.setCalcIndex23_index(1);
		} else if (ChannelConstants.CH_YB.equals(channel)) {
			b.setCalcIndex23(modelIndex26.compareTo(new BigDecimal(50000)) < 0 ? RiskCheckConstants.Y
					: RiskCheckConstants.N);
			b.setCalcIndex23_index(2);
		} else if (ChannelConstants.CH_KQ.equals(channel)) {
			b.setCalcIndex23(modelIndex26.compareTo(new BigDecimal(50000)) < 0 ? RiskCheckConstants.Y
					: RiskCheckConstants.N);
			b.setCalcIndex23_index(3);
		} else if (ChannelConstants.CH_CY.equals(channel)) {
			b.setCalcIndex23(modelIndex26.compareTo(new BigDecimal(50000)) < 0 ? RiskCheckConstants.Y
					: RiskCheckConstants.N);
			b.setCalcIndex23_index(4);
		} else {
			b.setCalcIndex23(RiskCheckConstants.N);
		}
	}

	/**
	 * “CR.工作单位(最近）”、“CR. 工作单位（次近）”、“CR.
	 * 工作单位（次次近）”任一维度包含以下字样视为满足：投资、担保、财富、财务、抵押、贷、资产、典当； * @param modelIndex37
	 * 
	 * @return
	 */
	public static String calcIndex24(String crWorkOrg1, String crWorkOrg2,
			String crWorkOrg3) {
		if (!StringUtils.isEmpty(crWorkOrg1)) {
			for (String org : orgSet) {
				if (crWorkOrg1.contains(org))
					return RiskCheckConstants.Y;
			}
		}
		if (!StringUtils.isEmpty(crWorkOrg2)) {
			for (String org : orgSet) {
				if (crWorkOrg2.contains(org))
					return RiskCheckConstants.Y;
			}
		}
		if (!StringUtils.isEmpty(crWorkOrg3)) {
			for (String org : orgSet) {
				if (crWorkOrg3.contains(org))
					return RiskCheckConstants.Y;
			}
		}
		return RiskCheckConstants.N;
	}

	/**
	 * “申请表.商户名称”、“CR.工作单位(最近）”、“CR.工作单位（次近）”、“CR.工作单位（次次近）”任一维度包含以下字样视为满足：咨询；
	 * 
	 * @param modelIndex53
	 * @return
	 */
	public static String calcIndex25(String crWorkOrg1, String crWorkOrg2,
			String crWorkOrg3) {
		if (!StringUtils.isEmpty(crWorkOrg1) && crWorkOrg1.indexOf(orgStr) > -0)
			return RiskCheckConstants.Y;
		if (!StringUtils.isEmpty(crWorkOrg2) && crWorkOrg1.indexOf(orgStr) > -0)
			return RiskCheckConstants.Y;
		if (!StringUtils.isEmpty(crWorkOrg3) && crWorkOrg1.indexOf(orgStr) > -0)
			return RiskCheckConstants.Y;
		return RiskCheckConstants.N;
	}

	/**
	 * If(Model_Index-33 最近4个月交易月份数 < 1, Y, N)
	 * 
	 * @param modelIndex37
	 * @return
	 */
	public static String calcIndex26(Integer modelIndex33) {
		return modelIndex33 < 1 ? RiskCheckConstants.Y : RiskCheckConstants.N;
	}

	/**
	 * If(Model_Index-35 最近4个月平均月交易金额 < 5000, Y, N)
	 * 
	 * @param modelIndex35
	 * @return
	 */
	public static String calcIndex27(BigDecimal modelIndex35, String channel) {
		if (ChannelConstants.CH_CY.equals(channel)
				&& modelIndex35.compareTo(new BigDecimal(5000)) < 0) {
			return RiskCheckConstants.Y;
		} else {
			return RiskCheckConstants.N;
		}
	}

	/**
	 * 同时满足以下条件视为满足： 1) 经营所在城市=四川省成都市（5101**）； 2) 经营地址包含以下任一字样：赛格广场、A世界；
	 * 
	 * @param modelIndex39
	 * @return
	 */
	public static String calcIndex28(String operAddrCode, String posCustAddress) {
		if (operAddrCode.indexOf(RiskCheckConstants.operAddrCode_5101) == 0) {
			if (posCustAddress
					.indexOf(RiskCheckConstants.posCustAddress_5101_1) >= 0
					|| posCustAddress
							.indexOf(RiskCheckConstants.posCustAddress_5101_2) >= 0) {
				return RiskCheckConstants.Y;
			}
		}
		return RiskCheckConstants.N;
	}

	/**
	 * 同时满足以下条件视为满足： 1) 经营所在城市=北京市（11****）； 2) 经营地址包含以下任一字样：新东郊商城；
	 * 
	 * @param modelIndex40
	 * @return
	 */
	public static String calcIndex29(String operAddrCode, String posCustAddress) {
		if (operAddrCode.indexOf(RiskCheckConstants.operAddrCode_11) == 0) {
			if (posCustAddress.indexOf(RiskCheckConstants.posCustAddress_11) >= 0) {
				return RiskCheckConstants.Y;
			}
		}
		return RiskCheckConstants.N;
	}

	/**
	 * If(Model_Index-40 申请人贷款逾期月份数 > 10, Y, N)
	 * 
	 * @param modelIndex41
	 * @return
	 */
	public static String calcIndex30(Integer modelIndex40) {
		if (modelIndex40 == null)
			return RiskCheckConstants.N;
		return modelIndex40 > 0 ? RiskCheckConstants.Y : RiskCheckConstants.N;
	}

	public static void computer(TRiskCheckModelIndex m, TRiskCheckCalcIndex b,
			String channel, TCreditReportIndicator crBean,
			TPosCustInfo tPosCustInfo) {
		// b.setCalcIndex21(calcIndex21(m.getModelIndex29(), channel,b));
		calcIndex21(m.getModelIndex29(), channel, b);
		b.setCalcIndex22(calcIndex22(m.getModelIndex30()));
		// b.setCalcIndex23(calcIndex23(m.getModelIndex26(),
		// m.getModelIndex29(),
		// channel));
		calcIndex23(m.getModelIndex26(), m.getModelIndex29(), channel, b);
		b.setCalcIndex24(calcIndex24(crBean.getCR021(), crBean.getCR022(),
				crBean.getCR023()));
		b.setCalcIndex25(calcIndex25(crBean.getCR021(), crBean.getCR022(),
				crBean.getCR023()));
		// b.setCalcIndex26(calcIndex26(m.getModelIndex33()));
		b.setCalcIndex27(calcIndex27(m.getModelIndex35(), channel));
		b.setCalcIndex28(calcIndex28(tPosCustInfo.getOperAddrCode(),
				tPosCustInfo.getPosCustAddress()));
		b.setCalcIndex29(calcIndex29(tPosCustInfo.getOperAddrCode(),
				tPosCustInfo.getPosCustAddress()));
		b.setCalcIndex30(calcIndex30(m.getModelIndex40()));
	}
}
