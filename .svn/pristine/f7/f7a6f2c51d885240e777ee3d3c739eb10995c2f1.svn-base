/**
 * 
 *	哈尔滨银行
 * Copyright (c) 2007-2015 HRBB,Inc.All Rights Reserved.
 */
package com.hrbb.loan.pos.service.impl;

import java.math.BigDecimal;
import java.math.MathContext;
import java.math.RoundingMode;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.HashSet;
import java.util.List;
import java.util.Map;
import java.util.Set;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.util.CollectionUtils;

import com.hrbb.loan.pos.dao.TPosSerialnoInfoDao;
import com.hrbb.loan.pos.service.LoanRiskPosSerialService;
import com.hrbb.loan.pos.service.bean.PosSerialHandleMidInfoBean;
import com.hrbb.loan.pos.service.bean.PosSerialHandledInfoBean;
import com.hrbb.loan.pos.util.DateUtil;
import com.hrbb.loan.pos.util.MathUtils;

/**
 * 
 * @author XLY
 * @version $Id: LoanRiskPosSerialServiceImpl.java, v 0.1 2015-3-12 上午10:06:40
 *          XLY Exp $
 */
@Service("loanRiskPosSerialService")
public class LoanRiskPosSerialServiceImpl implements LoanRiskPosSerialService {

	private final Integer LAST_MONTH_6 = 6;
	private final Integer LAST_MONTH_4 = 4;
	// posKind
	private final String POSKIND_1 = "1";
	private final String POSKIND_4 = "4";
	// 交易类型=消费
	private final String tradeType_consumption = "消费";

	static MathContext mc = new MathContext(6, RoundingMode.HALF_UP);

	private Logger LOG = LoggerFactory
			.getLogger(LoanRiskCheckServiceImpl.class);

	public static Set<String> channel = new HashSet<String>();

	static {
		channel.add("UP");// 银联
		channel.add("KQ");// 块钱
		channel.add("UM");// 银商
		channel.add("YB");// 易宝
	}

	@Autowired
	private TPosSerialnoInfoDao tPosSerialnoInfoDao;

	public PosSerialHandledInfoBean computerPosSerial(String loanId) {
		// 2015.04.29 不分渠道，全部求和
		// PosSerialHandleMidInfoBean qmMid = sumFromDetail(loanId, "KQ", "1");
		// PosSerialHandleMidInfoBean ybMid = sumFromDetail(loanId, "YB", "1");
		// PosSerialHandleMidInfoBean ylMid = sumFromDetail(loanId, "UP", "1");
		PosSerialHandleMidInfoBean ylMid = sumFromDetail(loanId, null,
				POSKIND_1);
		//
		// PosSerialHandleMidInfoBean ysMid = sumFromDetail1(loanId, "UM", "4");
		// PosSerialHandleMidInfoBean upMid3 = sumFromDetail1(loanId, "UP",
		PosSerialHandleMidInfoBean ysMid = sumFromDetail1(loanId, null,
				POSKIND_4);
		// "4");
		List<PosSerialHandleMidInfoBean> midInfos = new ArrayList<PosSerialHandleMidInfoBean>();
		// midInfos.add(qmMid);
		// midInfos.add(ybMid);
		midInfos.add(ylMid);
		midInfos.add(ysMid);
		// midInfos.add(upMid3);
		return computerAllPosSerial(midInfos, loanId);
	}

	/**
	 * 合并各渠道信息
	 * 
	 * @param midInfos
	 * @return
	 */
	private PosSerialHandledInfoBean computerAllPosSerial(
			List<PosSerialHandleMidInfoBean> midInfos, String loanId) {
		PosSerialHandledInfoBean result = new PosSerialHandledInfoBean();
		BigDecimal bankCardNums = BigDecimal.ZERO;
		BigDecimal tradeNums = BigDecimal.ZERO;
		BigDecimal tradeAmts = BigDecimal.ZERO;
		BigDecimal creditCardNums = BigDecimal.ZERO;
		BigDecimal countMonths = BigDecimal.ZERO;
		Integer latestMonth = 0;
		BigDecimal regTimeNums = BigDecimal.ZERO;
		BigDecimal regTimeAmts = BigDecimal.ZERO;
		BigDecimal tradeAmtsumMax = BigDecimal.ZERO;
		BigDecimal tradeAmtsumMin = BigDecimal.ZERO;
		for (PosSerialHandleMidInfoBean bean : midInfos) {
			bankCardNums = bankCardNums.add(bean.getBankcardNum());
			tradeNums = tradeNums.add(bean.getTradeNum());
			tradeAmts = tradeAmts.add(bean.getTradeAmt());
			creditCardNums = creditCardNums.add(bean.getCreditCardNum());
			countMonths = MathUtils.getMax(bean.getCountMonth(), countMonths);

			if (bean.getLatestMonth() != null) {
				if (latestMonth == 0) {
					latestMonth = bean.getLatestMonth();
				} else {
					// 取得最近的POS年月
					if (latestMonth < bean.getLatestMonth()) {
						latestMonth = bean.getLatestMonth();
					}
				}
			}
			regTimeAmts = regTimeAmts.add(bean.getRegTimeAmt());
			regTimeNums = regTimeNums.add(bean.getRegTimeNum());
			tradeAmtsumMax = MathUtils.getMax(bean.getTradeAmtsumMax(),
					tradeAmtsumMax);
			tradeAmtsumMin = MathUtils.getMin(bean.getTradeAmtsumMin(),
					tradeAmtsumMin);
		}
		// 6个月内交易流水金额汇总
		result.setTradeAmt6(tradeAmts);
		// 6个月内交易流水次数汇总
		result.setTradeNum6(tradeNums);
		result.setRepeativeCardPct(tradeNums.equals(BigDecimal.ZERO) ? BigDecimal.ZERO
				: bankCardNums.divide(tradeNums, mc));
		result.setMthlyCreditCardPct(tradeNums.equals(BigDecimal.ZERO) ? BigDecimal.ZERO
				: creditCardNums.divide(tradeNums, mc));
		result.setTotalNumPosMth6(countMonths);
		// result.setTotalNumPosMth(countMonths);
		result.setAvgMthAmt(countMonths.equals(BigDecimal.ZERO) ? BigDecimal.ZERO
				: tradeAmts.divide(countMonths, mc));
		result.setAvgMthTrxn(countMonths.equals(BigDecimal.ZERO) ? BigDecimal.ZERO
				: tradeNums.divide(countMonths, mc));
		// 计算6个月交易波动率
		result.setStDev(computerVolability(loanId));
		result.setRecentNumPosMth(countMonths);
		// result.setLatestYrmth(latestMonth);
		// 统计总明细
		sumFromDetailTotal(loanId, result);
		result.setBizHrSalesRatio(regTimeNums.equals(BigDecimal.ZERO) ? BigDecimal.ZERO
				: regTimeAmts.divide(regTimeNums, mc));
		result.setMeanAmt(tradeNums.equals(BigDecimal.ZERO) ? BigDecimal.ZERO
				: tradeAmts.divide(tradeNums, mc));
		result.setTradeAmtsumMax(tradeAmtsumMax);
		result.setTradeAmtsumMin(tradeAmtsumMin);

		// 最近4个月交易处理
		PosSerialHandledInfoBean result4 = computerPosSerialFor4Month(loanId);
		result.setCountMonth4(result4.getCountMonth4());
		result.setTradeNum4(result4.getTradeNum4());
		result.setTradeAmt4(result4.getTradeAmt4());

		LOG.info("loanId:" + loanId + " risk=" + result.toString());
		return result;
	}

	/**
	 * 统计明细
	 * 
	 * @param loanId
	 * @param posChannel
	 * @param posKind
	 * @return
	 */
	private PosSerialHandleMidInfoBean sumFromDetail1(String loanId,
			String posChannel, String posKind) {
		PosSerialHandleMidInfoBean bean = new PosSerialHandleMidInfoBean();
		Map<String, Object> reqMap = new HashMap<String, Object>();
		String lastDay = DateUtil.getLastMthNumStr(LAST_MONTH_6);
		reqMap.put("tradeDate", lastDay.substring(0, 7));
		reqMap.put("loanId", loanId);
		reqMap.put("posKind", posKind);
		// 2015.04.29 不分渠道，全部求和
		// reqMap.put("posChannel", posChannel);
		reqMap.put("tradeType", tradeType_consumption);
		List<Map<String, Object>> result = tPosSerialnoInfoDao
				.selectSumMap(reqMap);
		if (CollectionUtils.isEmpty(result) || null == result.get(0)) {
			LOG.info("loanId:" + loanId + " posKind:" + posKind);
			return bean;
		}
		List<Map<String, Object>> countMonth = tPosSerialnoInfoDao
				.selectCountMonth(reqMap);
		Map<String, Object> res = result.get(0);
		res.put("countMonth", countMonth.get(0).get("countMonth"));
		res.put("maxMonth", countMonth.get(0).get("maxMonth"));

		BigDecimal differentCardNoNumSum = BigDecimal.ZERO;
		if (null != res.get("differentCardNoNumSum")) {
			differentCardNoNumSum = new BigDecimal(res.get(
					"differentCardNoNumSum").toString());
		}
		BigDecimal tradeNumSum = BigDecimal.ZERO;
		if (null != res.get("tradeNumSum")) {
			tradeNumSum = new BigDecimal(res.get("tradeNumSum").toString());
		}
		BigDecimal tradeAmtsum = BigDecimal.ZERO;
		if (null != res.get("tradeAmtsum")) {
			tradeAmtsum = new BigDecimal(res.get("tradeAmtsum").toString());
		}
		BigDecimal regTimeTradeAmt = BigDecimal.ZERO;
		if (null != res.get("regTimeTradeAmt")) {
			regTimeTradeAmt = new BigDecimal(res.get("regTimeTradeAmt")
					.toString());
		}
		BigDecimal regTimeTradeNum = BigDecimal.ZERO;
		if (null != res.get("regTimeTradeNum")) {
			regTimeTradeNum = new BigDecimal(res.get("regTimeTradeNum")
					.toString());
		}
		bean.setBankcardNum(differentCardNoNumSum.compareTo(BigDecimal.ZERO) == 0 ? tradeNumSum
				: differentCardNoNumSum);
		bean.setCountMonth(new BigDecimal((null == res.get("countMonth") ? "0"
				: res.get("countMonth")).toString()));
		bean.setLatestMonth(null == res.get("maxMonth") ? 0 : Integer
				.parseInt(res.get("maxMonth").toString()));
		bean.setCreditCardNum(tradeNumSum);
		bean.setRegTimeAmt(regTimeTradeAmt.compareTo(BigDecimal.ZERO) == 0 ? tradeNumSum
				: regTimeTradeAmt);
		bean.setRegTimeNum(regTimeTradeNum.compareTo(BigDecimal.ZERO) == 0 ? tradeNumSum
				: regTimeTradeNum);
		bean.setTradeAmt(tradeAmtsum);
		bean.setTradeNum(tradeNumSum);
		LOG.info("loanId:" + loanId + " posKind:" + posKind + " bean="
				+ bean.toString());
		return bean;
	}

	/**
	 * 统计明细
	 * 
	 * @param loanId
	 * @param posChannel
	 * @param posKind
	 * @return
	 */
	private PosSerialHandleMidInfoBean sumFromDetail(String loanId,
			String posChannel, String posKind) {
		PosSerialHandleMidInfoBean bean = new PosSerialHandleMidInfoBean();
		Map<String, Object> reqMap = new HashMap<String, Object>();
		String lastDay = DateUtil.getLastMthNumStr(LAST_MONTH_6);
		reqMap.put("tradeDate", lastDay);
		reqMap.put("loanId", loanId);
		reqMap.put("posKind", posKind);
		// 2015.04.29 不分渠道，全部求和
		// reqMap.put("posChannel", posChannel);
		reqMap.put("tradeType", tradeType_consumption);
		List<Map<String, Object>> result = tPosSerialnoInfoDao
				.selectSumMap(reqMap);
		if (CollectionUtils.isEmpty(result) || null == result.get(0)) {
			LOG.info("loanId:" + loanId + " posKind:" + posKind);
			return bean;
		}

		List<Map<String, Object>> bankCardsum = tPosSerialnoInfoDao
				.selectSumBankCard(reqMap);
		List<Map<String, Object>> countMonth = tPosSerialnoInfoDao
				.selectCountMonth(reqMap);
		Map<String, Object> res = result.get(0);
		res.put("bankcardsum", bankCardsum.get(0).get("bankcardsum"));
		res.put("creditcardsum",
				bankCardsum.get(0).get("creditcardsum") == null ? bankCardsum
						.get(0).get("bankcardsum") : bankCardsum.get(0).get(
						"creditcardsum"));
		res.put("countMonth", countMonth.get(0).get("countMonth"));

		bean.setBankcardNum(new BigDecimal((null == res
				.get("differentCardNoNumSum") ? "0" : res.get(
				"differentCardNoNumSum").toString())));
		bean.setCountMonth(new BigDecimal((null == res.get("countMonth") ? "0"
				: res.get("countMonth")).toString()));
		bean.setLatestMonth(Integer.parseInt(countMonth.get(0).get("maxMonth")
				.toString()));
		bean.setCreditCardNum(new BigDecimal(
				(null == res.get("creditcardsum") ? "0" : res
						.get("creditcardsum")).toString()));
		bean.setRegTimeAmt(new BigDecimal(
				(null == res.get("regTimeTradeAmt") ? "0" : res
						.get("regTimeTradeAmt")).toString()));
		bean.setRegTimeNum(new BigDecimal(
				(null == res.get("regTimeTradeNum") ? "0" : res
						.get("regTimeTradeNum")).toString()));
		bean.setTradeAmt(new BigDecimal((null == res.get("tradeAmtsum") ? "0"
				: res.get("tradeAmtsum")).toString()));
		bean.setTradeNum(new BigDecimal((null == res.get("tradeNumSum") ? "0"
				: res.get("tradeNumSum")).toString()));
		bean.setTradeAmtsumMax(new BigDecimal((null == res
				.get("tradeAmtsumMax") ? "0" : res.get("tradeAmtsumMax"))
				.toString()));
		bean.setTradeAmtsumMin(new BigDecimal((null == res
				.get("tradeAmtsumMin") ? "0" : res.get("tradeAmtsumMin"))
				.toString()));
		LOG.info("loanId:" + loanId + " posKind:" + posKind + "="
				+ bean.toString());
		return bean;
	}

	/**
	 * 统计明细
	 * 
	 * @param loanId
	 * @param posChannel
	 * @param posKind
	 * @return
	 */
	private PosSerialHandleMidInfoBean sumFromDetailFor4Month(String loanId,
			String posChannel, String posKind) {
		PosSerialHandleMidInfoBean bean = new PosSerialHandleMidInfoBean();
		Map<String, Object> reqMap = new HashMap<String, Object>();
		String lastDay = DateUtil.getLastMthNumStr(LAST_MONTH_4);
		// 日明细
		if (POSKIND_1.equals(posKind)) {
			reqMap.put("tradeDate", lastDay);
			// 月明细
		} else {
			reqMap.put("tradeDate", lastDay.substring(0, 7));
		}
		reqMap.put("loanId", loanId);
		reqMap.put("posKind", posKind);
		// 2015.04.29 不分渠道，全部求和
		// reqMap.put("posChannel", posChannel);
		reqMap.put("tradeType", tradeType_consumption);
		List<Map<String, Object>> result = tPosSerialnoInfoDao
				.selectSumMap(reqMap);
		if (CollectionUtils.isEmpty(result) || null == result.get(0)) {
			LOG.info("loanId:" + loanId + " posKind:" + posKind + "=null");
			return bean;
		}
		List<Map<String, Object>> countMonth = tPosSerialnoInfoDao
				.selectCountMonth(reqMap);
		Map<String, Object> res = result.get(0);
		res.put("countMonth", countMonth.get(0).get("countMonth"));

		bean.setCountMonth(new BigDecimal((null == res.get("countMonth") ? "0"
				: res.get("countMonth")).toString()));
		bean.setTradeAmt(new BigDecimal((null == res.get("tradeAmtsum") ? "0"
				: res.get("tradeAmtsum")).toString()));
		LOG.info("loanId:" + loanId + " posKind:" + posKind + "="
				+ bean.toString());
		return bean;
	}

	public PosSerialHandledInfoBean computerPosSerialFor4Month(String loanId) {
		// 2015.04.29 不分渠道，全部求和
		// PosSerialHandleMidInfoBean qmMid = sumFromDetailFor4Month(loanId,
		// "KQ", "1");
		// PosSerialHandleMidInfoBean ybMid = sumFromDetailFor4Month(loanId,
		// "YB", "1");
		// PosSerialHandleMidInfoBean ylMid = sumFromDetailFor4Month(loanId,
		// "UP", "1");
		PosSerialHandleMidInfoBean ylMid = sumFromDetailFor4Month(loanId, null,
				POSKIND_1);
		//
		// PosSerialHandleMidInfoBean ysMid = sumFromDetailFor4Month(loanId,
		// "UM", "1");
		// PosSerialHandleMidInfoBean upMid3 =
		// sumFromDetailFor4Month(loanId,"UP", "3");
		PosSerialHandleMidInfoBean upMid3 = sumFromDetailFor4Month(loanId,
				null, POSKIND_4);
		List<PosSerialHandleMidInfoBean> midInfos = new ArrayList<PosSerialHandleMidInfoBean>();
		// midInfos.add(qmMid);
		// midInfos.add(ybMid);
		midInfos.add(ylMid);
		// midInfos.add(ysMid);
		midInfos.add(upMid3);
		return computerAllPosSerialFor4Month(midInfos, loanId);
	}

	/**
	 * 合并各渠道信息
	 * 
	 * @param midInfos
	 * @return
	 */
	private PosSerialHandledInfoBean computerAllPosSerialFor4Month(
			List<PosSerialHandleMidInfoBean> midInfos, String loanId) {
		PosSerialHandledInfoBean result = new PosSerialHandledInfoBean();
		BigDecimal tradeNums = BigDecimal.ZERO;
		BigDecimal tradeAmts = BigDecimal.ZERO;
		BigDecimal countMonths = BigDecimal.ZERO;
		for (PosSerialHandleMidInfoBean bean : midInfos) {
			tradeNums = tradeNums.add(bean.getTradeNum());
			tradeAmts = tradeAmts.add(bean.getTradeAmt());
			countMonths = MathUtils.getMax(bean.getCountMonth(), countMonths);
		}

		result.setTradeNum4(tradeNums);
		result.setTradeAmt4(tradeAmts);
		result.setCountMonth4(countMonths);
		LOG.info("For4Month loanId:" + loanId + " risk=" + result.toString());
		return result;
	}

	/**
	 * 6个月交易波动率 统计明细
	 * 
	 * @param loanId
	 * @param posChannel
	 * @param posKind
	 * @return
	 */
	private PosSerialHandleMidInfoBean sumFromDetailForStdev(String loanId,
			String posChannel, String posKind) {
		PosSerialHandleMidInfoBean bean = new PosSerialHandleMidInfoBean();
		Map<String, Object> reqMap = new HashMap<String, Object>();
		List<Map<String, String>> months = DateUtil
				.getOverNumMonths3(LAST_MONTH_6);
		months.get(0).get("month").toString();
		reqMap.put("tradeDate0", months.get(0).get("month").toString());
		reqMap.put("tradeDate1", months.get(1).get("month").toString());
		reqMap.put("tradeDate2", months.get(2).get("month").toString());
		reqMap.put("tradeDate3", months.get(3).get("month").toString());
		reqMap.put("tradeDate4", months.get(4).get("month").toString());
		reqMap.put("tradeDate5", months.get(5).get("month").toString());
		reqMap.put("loanId", loanId);
		reqMap.put("posKind", posKind);
		// 2015.04.29 不分渠道，全部求和
		// reqMap.put("posChannel", posChannel);
		reqMap.put("tradeType", tradeType_consumption);
		List<Map<String, Object>> result = tPosSerialnoInfoDao
				.selectSumMapStdev(reqMap);

		Map<String, Object> m = result.get(0);
		bean.setTradeAmt0(new BigDecimal(m.get("tradeAmtsum").toString()));
		m = result.get(1);
		bean.setTradeAmt1(new BigDecimal(m.get("tradeAmtsum").toString()));
		m = result.get(2);
		bean.setTradeAmt2(new BigDecimal(m.get("tradeAmtsum").toString()));
		m = result.get(3);
		bean.setTradeAmt3(new BigDecimal(m.get("tradeAmtsum").toString()));
		m = result.get(4);
		bean.setTradeAmt4(new BigDecimal(m.get("tradeAmtsum").toString()));
		m = result.get(5);
		bean.setTradeAmt5(new BigDecimal(m.get("tradeAmtsum").toString()));

		LOG.info("loanId:" + loanId + " posKind:" + posKind + "="
				+ bean.toString());
		return bean;
	}

	/**
	 * 6个月交易波动率 统计明细1
	 * 
	 * @param loanId
	 * @param posChannel
	 * @param posKind
	 * @return
	 */
	private PosSerialHandleMidInfoBean sumFromDetail1ForStdev(String loanId,
			String posChannel, String posKind) {
		PosSerialHandleMidInfoBean bean = new PosSerialHandleMidInfoBean();
		Map<String, Object> reqMap = new HashMap<String, Object>();
		List<Map<String, String>> months = DateUtil
				.getOverNumMonths3(LAST_MONTH_6);
		months.get(0).get("month").toString();
		reqMap.put("tradeDate0", months.get(0).get("month").toString());
		reqMap.put("tradeDate1", months.get(1).get("month").toString());
		reqMap.put("tradeDate2", months.get(2).get("month").toString());
		reqMap.put("tradeDate3", months.get(3).get("month").toString());
		reqMap.put("tradeDate4", months.get(4).get("month").toString());
		reqMap.put("tradeDate5", months.get(5).get("month").toString());
		reqMap.put("loanId", loanId);
		reqMap.put("posKind", posKind);
		// 2015.04.29 不分渠道，全部求和
		// reqMap.put("posChannel", posChannel);
		reqMap.put("tradeType", tradeType_consumption);
		List<Map<String, Object>> result = tPosSerialnoInfoDao
				.selectSumMapStdev(reqMap);

		Map<String, Object> m = result.get(0);
		bean.setTradeAmt0(new BigDecimal(m.get("tradeAmtsum").toString()));
		m = result.get(1);
		bean.setTradeAmt1(new BigDecimal(m.get("tradeAmtsum").toString()));
		m = result.get(2);
		bean.setTradeAmt2(new BigDecimal(m.get("tradeAmtsum").toString()));
		m = result.get(3);
		bean.setTradeAmt3(new BigDecimal(m.get("tradeAmtsum").toString()));
		m = result.get(4);
		bean.setTradeAmt4(new BigDecimal(m.get("tradeAmtsum").toString()));
		m = result.get(5);
		bean.setTradeAmt5(new BigDecimal(m.get("tradeAmtsum").toString()));

		LOG.info("loanId:" + loanId + " posKind:" + posKind + "="
				+ bean.toString());
		return bean;
	}

	/**
	 * 计算6个月交易波动率
	 * 
	 * @param loanId
	 * @return
	 */
	public BigDecimal computerVolability(String loanId) {
		// 2015.04.29 不分渠道，全部求和
		PosSerialHandleMidInfoBean mid1 = sumFromDetailForStdev(loanId, null,
				POSKIND_1);
		PosSerialHandleMidInfoBean mid2 = sumFromDetail1ForStdev(loanId, null,
				POSKIND_4);

		// 近6个月，各个月的金额汇总
		BigDecimal tradeAmt0 = mid1.getTradeAmt0().add(mid2.getTradeAmt0());
		BigDecimal tradeAmt1 = mid1.getTradeAmt1().add(mid2.getTradeAmt1());
		BigDecimal tradeAmt2 = mid1.getTradeAmt2().add(mid2.getTradeAmt2());
		BigDecimal tradeAmt3 = mid1.getTradeAmt3().add(mid2.getTradeAmt3());
		BigDecimal tradeAmt4 = mid1.getTradeAmt4().add(mid2.getTradeAmt4());
		BigDecimal tradeAmt5 = mid1.getTradeAmt5().add(mid2.getTradeAmt5());

		double[] ds = new double[6];
		ds[0] = tradeAmt0.doubleValue();
		ds[1] = tradeAmt1.doubleValue();
		ds[2] = tradeAmt2.doubleValue();
		ds[3] = tradeAmt3.doubleValue();
		ds[4] = tradeAmt4.doubleValue();
		ds[5] = tradeAmt5.doubleValue();

		double stDev = MathUtils.getVolability(ds);
		return BigDecimal.valueOf(stDev);
	}

	/**
	 * 统计明细(总)
	 * 
	 * @param loanId
	 * @param result
	 * @return
	 */
	private void sumFromDetailTotal(String loanId,
			PosSerialHandledInfoBean result) {
		Map<String, Object> reqMap = new HashMap<String, Object>();
		reqMap.put("loanId", loanId);
		reqMap.put("tradeType", tradeType_consumption);
		List<Map<String, Object>> countMonth = tPosSerialnoInfoDao
				.selectCountMonth(reqMap);
		if (CollectionUtils.isEmpty(countMonth) || null == countMonth.get(0)) {
			LOG.info("loanId:" + loanId + " countMonth is null");
			return;
		}
		result.setTotalNumPosMth(new BigDecimal(countMonth.get(0)
				.get("countMonth").toString()));
		result.setLatestYrmth(Integer.parseInt(countMonth.get(0)
				.get("maxMonth").toString()));
	}
}
