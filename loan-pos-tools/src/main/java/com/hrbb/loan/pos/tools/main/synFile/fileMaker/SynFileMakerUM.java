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

import com.hrbb.loan.pos.dao.entity.TPaybackRunningRecord;
import com.hrbb.loan.pos.dao.entity.TReceiptInfo;
import com.hrbb.loan.pos.util.DateUtil;
import com.hrbb.loan.pos.util.FileUtil;
import com.hrbb.loan.pos.util.MathUtils;
import com.hrbb.loan.pos.util.constants.ReviewNoteConstants;
import com.hrbb.loan.pos.tools.main.synFile.SynFileConstants;
import com.hrbb.loan.pos.tools.main.util.SignUtil;
import com.hrbb.loan.pos.tools.main.util.SynFileUtil;

/**
 * 数据同步接口
 * 
 * @author marco
 * @version $Id: SynFileMakerUM.java, v 0.1 2015-4-24 下午4:20:22 marco Exp $
 */
public class SynFileMakerUM {

	private final static Logger LOG = LoggerFactory
			.getLogger(SynFileMakerUM.class);

	public String getChannel() {
		return ReviewNoteConstants.CHANNEL_CODE_UM;
	}

	/**
	 * @see com.hrbb.loan.pos.biz.backstage.inter.LedgerBiz#makeSynFile()
	 */
	public static boolean makeSynFile(String path, String today,
			String channel, SqlSession sqlSession) {

		LOG.debug("SynFileMakerUM.makeSynFile begin");

		try {
			// 创建文件
			makeFileHB16(path, today, channel, ReviewNoteConstants.LOANTYPE_01,
					sqlSession);
		} catch (Exception e) {
			LOG.debug("HB16处理失败！", e);
		}
		try {
			// 创建文件
			makeFileHB17(path, today, channel, ReviewNoteConstants.LOANTYPE_01,
					sqlSession);
		} catch (Exception e) {
			LOG.debug("HB17处理失败！", e);
		}
		try {
			// 创建文件
			makeFileHB18(path, today, channel, ReviewNoteConstants.LOANTYPE_01,
					sqlSession);
		} catch (Exception e) {
			LOG.debug("HB18处理失败！", e);
		}
		try {
			// 创建文件
			makeFileHB19(path, today, channel, ReviewNoteConstants.LOANTYPE_01,
					sqlSession);
		} catch (Exception e) {
			LOG.debug("HB19处理失败！", e);
		}

		LOG.debug("SynFileMakerUM.makeSynFile end");
		return true;
	}

	/**
	 * 台账数据同步接口 取得数据，生成文件
	 * 
	 * @return boolean
	 */
	private static boolean makeFileHB16(String pathAll, String today,
			String channel, String loanType, SqlSession sqlSession) {
		LOG.debug("生成台账数据文件makeFileHB16 begin");

		// 文件名
		String fileName = SynFileUtil.getSynFileName(channel, 1, today, null);
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
				// 授信额度编号
				sb.append(i.getPayApplyId()
						+ FileUtil.SYNFILE_COLUMN_APPEND_PREFIX);
				// 合同号
				sb.append(i.getContNo() + FileUtil.SYNFILE_COLUMN_APPEND_PREFIX);
				// 借据号
				sb.append(i.getReceiptId()
						+ FileUtil.SYNFILE_COLUMN_APPEND_PREFIX);
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
				// 罚息
				sb.append(0.00 + FileUtil.SYNFILE_COLUMN_APPEND_PREFIX);
				// 贷款状态
				// 已结清
				// if
				// (SynFileConstants.CLEARSTATUS_01.equals(i.getClearStatus()))
				// {
				if (i.getLoanStatus() != null
						&& i.getLoanStatus().matches("(90|91|92|93)")) { // 90提前结清
																			// 91正常结清
																			// 92逾期结清
																			// 93核销
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
				sb.append(FileUtil.SYNFILE_COLUMN_APPEND_PREFIX);
				// 商户ＩＤ
				sb.append(i.getChannelPosCustId());
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
		LOG.debug("生成台账数据文件makeFileHB16 end");
		return true;
	}

	/**
	 * 当日还款明细同步接口取得数据，生成文件
	 * 
	 * @return boolean
	 */
	private static boolean makeFileHB17(String pathAll, String today,
			String channel, String loanType, SqlSession sqlSession) {
		LOG.debug("生成当日还款明细文件makeFileHB17 begin");

		// 文件名
		String fileName = SynFileUtil.getSynFileName(channel, 2, today, null);
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
				// 借据号
				sb.append(i.getReceiptId()
						+ FileUtil.SYNFILE_COLUMN_APPEND_PREFIX);
				// 还款业务流水号
				sb.append(i.getStdshno()
						+ FileUtil.SYNFILE_COLUMN_APPEND_PREFIX);
				// 还款流水号
				sb.append(i.getPaybackRunningRecordId()
						+ FileUtil.SYNFILE_COLUMN_APPEND_PREFIX);
				// 还款类型
				sb.append(i.getPaybackWay()
						+ FileUtil.SYNFILE_COLUMN_APPEND_PREFIX);
				// 归还本金
				sb.append(i.getActualCapital()
						+ FileUtil.SYNFILE_COLUMN_APPEND_PREFIX);
				// 归还利息
				sb.append(i.getActualInterest()
						+ FileUtil.SYNFILE_COLUMN_APPEND_PREFIX);
				// 归还罚息
				sb.append(0 + FileUtil.SYNFILE_COLUMN_APPEND_PREFIX);
				// 还款日期
				sb.append(DateUtil.getDatePattern1(i.getActualPaybackDate())
						+ FileUtil.SYNFILE_COLUMN_APPEND_PREFIX);
				// 商户ＩＤ
				sb.append(i.getChannelPosCustId());
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
		LOG.debug("生成当日还款明细文件makeFileHB17 end");
		return true;
	}

	/**
	 * 当日放款明细同步接口取得数据，生成文件
	 * 
	 * @return boolean
	 */
	private static boolean makeFileHB18(String pathAll, String today,
			String channel, String loanType, SqlSession sqlSession) {
		LOG.debug("生成当日放款明细文件makeFileHB18 begin");

		// 文件名
		String fileName = SynFileUtil.getSynFileName(channel, 3, today, null);
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
				// 提款流水号
				sb.append(i.getPayApplyId()
						+ FileUtil.SYNFILE_COLUMN_APPEND_PREFIX);
				// 借据号
				sb.append(i.getReceiptId()
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
				// 数据日期
				sb.append(Integer.parseInt(today)
						+ FileUtil.SYNFILE_COLUMN_APPEND_PREFIX);
				// 商户ＩＤ
				sb.append(i.getChannelPosCustId());
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
		LOG.debug("生成当日放款明细文件makeFileHB18 end");
		return true;
	}

	/**
	 * 佣金代收明细文件取得数据，生成文件
	 * 
	 * @return boolean
	 */
	private static boolean makeFileHB19(String pathAll, String today,
			String channel, String loanType, SqlSession sqlSession) {
		LOG.debug("生成佣金代收明细文件makeFileHB19 begin");

		// 文件名
		String fileName = SynFileUtil.getSynFileName(channel, 4, today, null);
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
				"TReceiptInfoMapper.selectRecordInfoHB19", p);
		// 查询台账数据
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
				// 交易日期
				sb.append(Integer.parseInt(today)
						+ FileUtil.SYNFILE_COLUMN_APPEND_PREFIX);
				// 商户ID
				sb.append(i.getPosCustId()
						+ FileUtil.SYNFILE_COLUMN_APPEND_PREFIX);
				// 姓名
				sb.append(i.getCustName()
						+ FileUtil.SYNFILE_COLUMN_APPEND_PREFIX);
				// 账号
				sb.append(i.getPayAccount()
						+ FileUtil.SYNFILE_COLUMN_APPEND_PREFIX);
				// 身份证号
				sb.append(i.getPaperId()
						+ FileUtil.SYNFILE_COLUMN_APPEND_PREFIX);
				// 贷款金额
				sb.append(i.getPayApplyAmt()
						+ FileUtil.SYNFILE_COLUMN_APPEND_PREFIX);
				// 申请流水号
				sb.append(i.getStdshno()
						+ FileUtil.SYNFILE_COLUMN_APPEND_PREFIX);
				// 协议编号
				sb.append(i.getContNo() + FileUtil.SYNFILE_COLUMN_APPEND_PREFIX);
				// 合同编号
				sb.append(i.getContNo() + FileUtil.SYNFILE_COLUMN_APPEND_PREFIX);
				// 转账金额
				sb.append(MathUtils.format1(i.getAmt())
						+ FileUtil.SYNFILE_COLUMN_APPEND_PREFIX);
				// 数据文件日期
				sb.append(Integer.parseInt(today)
						+ FileUtil.SYNFILE_COLUMN_APPEND_PREFIX);
				// 还款账号
				sb.append(i.getPayAccount()
						+ FileUtil.SYNFILE_COLUMN_APPEND_PREFIX);
				// 商户ＩＤ
				sb.append(i.getChannelPosCustId());
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
			LOG.debug("生成佣金代收明细文件makeFileHB19 end");
			return false;
		} else {
			LOG.info("写文件成功");
		}
		LOG.debug("生成佣金代收明细文件makeFileHB19 end");
		return true;
	}
}