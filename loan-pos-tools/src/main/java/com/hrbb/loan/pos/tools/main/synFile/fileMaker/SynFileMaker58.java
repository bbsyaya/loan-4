/**
 * 
 *	哈尔滨银行
 * Copyright (c) 2007-2015 HRBB,Inc.All Rights Reserved.
 */
package com.hrbb.loan.pos.tools.main.synFile.fileMaker;

import java.math.BigDecimal;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.apache.ibatis.session.SqlSession;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import com.google.common.collect.Maps;
import com.hrbb.loan.pos.dao.entity.TPaybackRunningRecord;
import com.hrbb.loan.pos.dao.entity.TReceiptInfo;
import com.hrbb.loan.pos.util.DateUtil;
import com.hrbb.loan.pos.util.FileUtil;
import com.hrbb.loan.pos.util.constants.ReviewNoteConstants;
import com.hrbb.loan.pos.tools.main.synFile.SynFileConstants;
import com.hrbb.loan.pos.tools.main.util.SignUtil;
import com.hrbb.loan.pos.tools.main.util.SynFileUtil;

/**
 * 数据同步接口
 * 
 * @author marco
 * @version $Id: SynFileMaker58r58.java, v 0.1 2015-4-24 下午4:20:22 marco Exp $
 */
public class SynFileMaker58 {

	private final static Logger LOG = LoggerFactory
			.getLogger(SynFileMaker58.class);

	public String getChannel() {
		return ReviewNoteConstants.CHANNEL_CODE_58;
	}

	/**
	 * @see com.hrbb.loan.pos.biz.backstage.inter.LedgerBiz#makeSynFile()
	 */
	public static boolean makeSynFile(String path, String today,
			String channel, SqlSession sqlSession) {

		LOG.debug("SynFileMaker" + channel + ".makeSynFile begin");

		try {
			// 创建文件
			makeFile01(path, today, channel, ReviewNoteConstants.LOANTYPE_01,
					sqlSession);
		} catch (Exception e) {
			LOG.debug("makeFile01处理失败！", e);
		}
		try {
			// 创建文件
			makeFile02(path, today, channel, ReviewNoteConstants.LOANTYPE_01,
					sqlSession);
		} catch (Exception e) {
			LOG.debug("makeFile02处理失败！", e);
		}
		try {
			// 创建文件
			makeFile03(path, today, channel, ReviewNoteConstants.LOANTYPE_01,
					sqlSession);
		} catch (Exception e) {
			LOG.debug("makeFile03处理失败！", e);
		}

		if (ReviewNoteConstants.fundPoolSet.contains(channel)) {
			// 创建资金池数据文件
			try {
				// 创建文件
				makeFile01(path, today, channel,
						ReviewNoteConstants.LOANTYPE_02, sqlSession);
			} catch (Exception e) {
				LOG.debug("makeFile01处理失败！", e);
			}
			try {
				// 创建文件
				makeFile02(path, today, channel,
						ReviewNoteConstants.LOANTYPE_02, sqlSession);
			} catch (Exception e) {
				LOG.debug("makeFile02处理失败！", e);
			}
			try {
				// 创建文件
				makeFile03(path, today, channel,
						ReviewNoteConstants.LOANTYPE_02, sqlSession);
			} catch (Exception e) {
				LOG.debug("makeFile03处理失败！", e);
			}
		}
		LOG.debug("SynFileMaker" + channel + ".makeSynFile end");
		return true;
	}

	/**
	 * 台账数据同步接口 取得数据，生成文件
	 * 
	 * @return boolean
	 */
	private static boolean makeFile01(String pathAll, String today,
			String channel, String loanType, SqlSession sqlSession) {
		LOG.debug("生成台账数据文件makeFile01 begin");

		// 文件名
		String fileName = SynFileUtil.getSynFileName(channel, 1, today,
				loanType);
		LOG.debug("创建文件fileName=" + fileName);
		// 取得路径
		pathAll = pathAll.concat(fileName);
		LOG.debug("创建文件pathAll=" + pathAll);
		// 创建文件
		if (!FileUtil.createFile(pathAll)) {
			LOG.error("创建文件失败！");
			return false;
		} else {
			LOG.info("创建文件成功pathAll=" + pathAll);
		}

		Map<String, String> p = new HashMap<>();
		p.put(ReviewNoteConstants.CHANNEL, channel);
		p.put(ReviewNoteConstants.LOANTYPE, loanType);
		// 查询台账数据
		List<TReceiptInfo> l = sqlSession.selectList(
				"TReceiptInfoMapper.selectRecordInfoHB16", p);
		int count = l.size();
		LOG.debug("数据条数count=" + count);
		StringBuffer sb = new StringBuffer();
		// 信息头
		sb.append(today).append(FileUtil.SYNFILE_COLUMN_APPEND_PREFIX)
				.append(count);
		// 没有数据时
		if (count == 0) {
			// 有数据时
		} else {
			BigDecimal innerOwnedInterest = null;
			BigDecimal outterOwnedInterest = null;
			String finishDate = null;

			for (TReceiptInfo i : l) {
				// 换行
				sb.append(FileUtil.SYNFILE_NEWLINE_PREFIX);
				// 借据号
				sb.append(i.getReceiptId()
						+ FileUtil.SYNFILE_COLUMN_APPEND_PREFIX);
				// 合同号
				sb.append(i.getContNo() + FileUtil.SYNFILE_COLUMN_APPEND_PREFIX);
				// 贷款金额
				sb.append(i.getPayApplyAmt()
						+ FileUtil.SYNFILE_COLUMN_APPEND_PREFIX);
				// 贷款开始日期
				sb.append(DateUtil.getDatePattern1(i.getBeginDate())
						+ FileUtil.SYNFILE_COLUMN_APPEND_PREFIX);
				// 贷款结束日期
				sb.append(DateUtil.getDatePattern1(i.getEndDate())
						+ FileUtil.SYNFILE_COLUMN_APPEND_PREFIX);
				// 贷款实际结清日期
				finishDate = i.getFinishDate() == null ? "" : DateUtil
						.getDatePattern1(i.getFinishDate());
				sb.append(finishDate + FileUtil.SYNFILE_COLUMN_APPEND_PREFIX);
				// 贷款利率
				sb.append(i.getLoanInterest()
						+ FileUtil.SYNFILE_COLUMN_APPEND_PREFIX);
				// 还款方式
				sb.append(("01".equals(i.getPaybackWay()) ? "90" : i
						.getPaybackWay())
						+ FileUtil.SYNFILE_COLUMN_APPEND_PREFIX);
				// 贷款余额
				sb.append(i.getLoanTotalBalance()
						+ FileUtil.SYNFILE_COLUMN_APPEND_PREFIX);
				// 逾期本金
				sb.append(i.getOverdueBalance()
						+ FileUtil.SYNFILE_COLUMN_APPEND_PREFIX);
				// 逾期利息
				innerOwnedInterest = i.getInnerOwnedInterest() == null ? BigDecimal.ZERO
						: i.getInnerOwnedInterest();
				outterOwnedInterest = i.getOutterOwnedInterest() == null ? BigDecimal.ZERO
						: i.getOutterOwnedInterest();
				sb.append(innerOwnedInterest.add(outterOwnedInterest)
						+ FileUtil.SYNFILE_COLUMN_APPEND_PREFIX);
				// 贷款状态
				// 已结清
				if (i.getLoanStatus() != null
						&& i.getLoanStatus().matches("(90|91|92|93)")) { // 90提前结清;91正常结清;92逾期结清;93核销
					sb.append(SynFileConstants.CLEARSTATUS_01);
				} else {
					// 逾期
					if (i.getOverdueBalance() != null
							&& i.getOverdueBalance().compareTo(BigDecimal.ZERO) > 0) {
						sb.append(SynFileConstants.CLEARSTATUS_03);
						// 正常
					} else {
						sb.append(SynFileConstants.CLEARSTATUS_02);
					}
				}
			}
			// MD5摘要
			String signMD5 = SignUtil.genMD5(sb.toString(), SignUtil.CHAR_SET);
			LOG.debug("signMD5=" + signMD5);
			// 换行
			sb.append(FileUtil.SYNFILE_NEWLINE_PREFIX).append(signMD5);
		}
		LOG.debug("file=" + sb.toString());

		// 写文件
		LOG.debug("写文件pathAll=" + pathAll);
		// 设置文件的编码格式
		if (!FileUtil.writeFile(pathAll, sb.toString(), FileUtil.CHARSET_UTF_8)) {
			LOG.error("写文件失败！");
			LOG.debug("生成台账数据文件makeFileHB16 end");
			return false;
		} else {
			LOG.info("写文件成功");
		}
		LOG.debug("生成台账数据文件makeFile01 end");
		return true;
	}

	/**
	 * 当日还款明细同步接口取得数据，生成文件
	 * 
	 * @return boolean
	 */
	private static boolean makeFile02(String pathAll, String today,
			String channel, String loanType, SqlSession sqlSession) {
		LOG.debug("生成当日还款明细文件makeFile02 begin");

		// 文件名
		String fileName = SynFileUtil.getSynFileName(channel, 2, today,
				loanType);
		LOG.debug("创建文件fileName=" + fileName);
		// 取得路径
		pathAll = pathAll.concat(fileName);
		// 创建文件
		if (!FileUtil.createFile(pathAll)) {
			LOG.error("创建文件失败！");
			return false;
		} else {
			LOG.info("创建文件成功pathAll=" + pathAll);
		}

		Map<String, String> p = new HashMap<>();
		p.put(ReviewNoteConstants.CHANNEL, channel);
		p.put(ReviewNoteConstants.LOANTYPE, loanType);
		// 查询当日还款明细数据
		List<TPaybackRunningRecord> l = sqlSession.selectList(
				"TPaybackRunningRecordMapper.selectRecordInfoHB17", p);
		int count = l.size();
		LOG.debug("数据条数count=" + count);
		StringBuffer sb = new StringBuffer();
		// 信息头
		sb.append(today).append(FileUtil.SYNFILE_COLUMN_APPEND_PREFIX)
				.append(count);
		// 没有数据时
		if (count == 0) {
			// 有数据时
		} else {
			for (TPaybackRunningRecord i : l) {
				// 换行
				sb.append(FileUtil.SYNFILE_NEWLINE_PREFIX);
				// 还款业务流水号
				sb.append(i.getStdrpno()
						+ FileUtil.SYNFILE_COLUMN_APPEND_PREFIX);
				// 还款流水号
				sb.append(i.getPaybackRunningRecordId()
						+ FileUtil.SYNFILE_COLUMN_APPEND_PREFIX);
				// 还款类型
				sb.append(i.getPaybackWay()
						+ FileUtil.SYNFILE_COLUMN_APPEND_PREFIX);
				// 归还总金额
				sb.append(i.getActualTotalAmount()
						+ FileUtil.SYNFILE_COLUMN_APPEND_PREFIX);
				// 归还本金
				sb.append(i.getActualCapital()
						+ FileUtil.SYNFILE_COLUMN_APPEND_PREFIX);
				// 归还利息
				sb.append(i.getActualInterest()
						+ FileUtil.SYNFILE_COLUMN_APPEND_PREFIX);
				// 还款日期
				sb.append(DateUtil.getDatePattern1(i.getActualPaybackDate()));
			}
			// MD5摘要
			String signMD5 = SignUtil.genMD5(sb.toString(), SignUtil.CHAR_SET);
			LOG.debug("signMD5=" + signMD5);
			// 换行
			sb.append(FileUtil.SYNFILE_NEWLINE_PREFIX).append(signMD5);
		}
		LOG.debug("file=" + sb.toString());

		// 写文件
		LOG.debug("写文件pathAll=" + pathAll);
		// 设置文件的编码格式
		if (!FileUtil.writeFile(pathAll, sb.toString(), FileUtil.CHARSET_UTF_8)) {
			LOG.error("写文件失败！");
			LOG.debug("生成当日还款明细文件makeFileHB17 end");
			return false;
		} else {
			LOG.info("写文件成功");
		}
		LOG.debug("生成当日还款明细文件makeFile02 end");
		return true;
	}

	/**
	 * 当日放款明细同步接口取得数据，生成文件
	 * 
	 * @return boolean
	 */
	private static boolean makeFile03(String pathAll, String today,
			String channel, String loanType, SqlSession sqlSession) {
		LOG.debug("生成当日放款明细文件makeFile03 begin");

		// 文件名
		String fileName = SynFileUtil.getSynFileName(channel, 3, today,
				loanType);
		LOG.debug("创建文件fileName=" + fileName);
		// 取得路径
		pathAll = pathAll.concat(fileName);
		// 创建文件
		if (!FileUtil.createFile(pathAll)) {
			LOG.error("创建文件失败！");
			return false;
		} else {
			LOG.info("创建文件成功pathAll=" + pathAll);
		}

		Map<String, String> p = new HashMap<>();
		p.put(ReviewNoteConstants.CHANNEL, channel);
		p.put(ReviewNoteConstants.LOANTYPE, loanType);
		// 查询当日还款明细数据
		List<TReceiptInfo> l = sqlSession.selectList(
				"TReceiptInfoMapper.selectRecordInfoHB18", p);
		// 查询数据
		int count = l.size();
		LOG.debug("数据条数count=" + count);
		StringBuffer sb = new StringBuffer();
		// 信息头
		sb.append(today).append(FileUtil.SYNFILE_COLUMN_APPEND_PREFIX)
				.append(count);
		// 没有数据时
		if (count == 0) {
			// 有数据时
		} else {
			for (TReceiptInfo i : l) {
				// 换行
				sb.append(FileUtil.SYNFILE_NEWLINE_PREFIX);
				// 用款流水号（合作机构）
				sb.append(i.getStdisno()
						+ FileUtil.SYNFILE_COLUMN_APPEND_PREFIX);
				// 用款申请编号
				sb.append(i.getPayApplyId()
						+ FileUtil.SYNFILE_COLUMN_APPEND_PREFIX);
				// 放款金额
				sb.append(i.getPayApplyAmt()
						+ FileUtil.SYNFILE_COLUMN_APPEND_PREFIX);
				// 起息日
				sb.append(DateUtil.getDatePattern1(i.getBeginDate())
						+ FileUtil.SYNFILE_COLUMN_APPEND_PREFIX);
				// 到期日
				sb.append(DateUtil.getDatePattern1(i.getEndDate())
						+ FileUtil.SYNFILE_COLUMN_APPEND_PREFIX);
				if(ReviewNoteConstants.hasTermColumnSet.contains(channel)){
					//从还款计划表中查询出总还款期次
					Map<String, Object> reqMap = Maps.newHashMap();
					reqMap.put("payApplyId", i.getPayApplyId());
					sb.append(sqlSession.selectOne("TRepaymentPlanMapper.countRepaymentPlans", reqMap) + FileUtil.SYNFILE_COLUMN_APPEND_PREFIX);
				}
				// 数据日期
				sb.append(Integer.parseInt(today));
			}
			// MD5摘要
			String signMD5 = SignUtil.genMD5(sb.toString(), SignUtil.CHAR_SET);
			LOG.debug("signMD5=" + signMD5);
			// 换行
			sb.append(FileUtil.SYNFILE_NEWLINE_PREFIX).append(signMD5);
		}
		LOG.debug("file=" + sb.toString());

		// 写文件
		LOG.debug("写文件pathAll=" + pathAll);
		// 设置文件的编码格式
		if (!FileUtil.writeFile(pathAll, sb.toString(), FileUtil.CHARSET_UTF_8)) {
			LOG.error("写文件失败！");
			LOG.debug("生成当日放款明细文件makeFileHB18 end");
			return false;
		} else {
			LOG.info("写文件成功");
		}
		LOG.debug("生成当日放款明细文件makeFile03 end");
		return true;
	}
}
