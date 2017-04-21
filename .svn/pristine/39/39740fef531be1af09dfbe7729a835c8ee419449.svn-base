/**
 * 
 *	哈尔滨银行
 * Copyright (c) 2007-2015 HRBB,Inc.All Rights Reserved.
 */
package com.hrbb.loan.pos.service.impl;

import java.math.BigDecimal;
import java.util.Arrays;
import java.util.Calendar;
import java.util.Date;
import java.util.List;
import java.util.Map;

import org.apache.commons.lang3.StringUtils;
import org.apache.commons.lang3.time.DateFormatUtils;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Service;

import com.google.common.collect.Maps;
import com.hrbb.loan.pos.dao.TApproveResultDao;
import com.hrbb.loan.pos.dao.TBankAccnoInfoDao;
import com.hrbb.loan.pos.dao.TBankSerialnoInfoDao;
import com.hrbb.loan.pos.dao.TBusinessDictionaryDao;
import com.hrbb.loan.pos.dao.TCallingTaskDao;
import com.hrbb.loan.pos.dao.TCreditApplyAprvInfoDao;
import com.hrbb.loan.pos.dao.TCreditApplyForReviewDao;
import com.hrbb.loan.pos.dao.TCreditGroupDao;
import com.hrbb.loan.pos.dao.TCustomerDao;
import com.hrbb.loan.pos.dao.TMessageDao;
import com.hrbb.loan.pos.dao.TPosCustInfoDao;
import com.hrbb.loan.pos.dao.TPosSerialnoInfoDao;
import com.hrbb.loan.pos.dao.TRelativeInfoDao;
import com.hrbb.loan.pos.dao.TReviewAssignTaskDao;
import com.hrbb.loan.pos.dao.TSmsMessageDao;
import com.hrbb.loan.pos.dao.TSmsTemplateDao;
import com.hrbb.loan.pos.dao.TUserApprInfoDao;
import com.hrbb.loan.pos.dao.TUserGroupDao;
import com.hrbb.loan.pos.dao.entity.TApproveResult;
import com.hrbb.loan.pos.dao.entity.TBankAccnoInfo;
import com.hrbb.loan.pos.dao.entity.TCallingTask;
import com.hrbb.loan.pos.dao.entity.TCreditApply;
import com.hrbb.loan.pos.dao.entity.TCreditApplyAprvInfo;
import com.hrbb.loan.pos.dao.entity.TCreditApplyAprvInfoKey;
import com.hrbb.loan.pos.dao.entity.TCustomer;
import com.hrbb.loan.pos.dao.entity.TMessage;
import com.hrbb.loan.pos.dao.entity.TPosCustInfo;
import com.hrbb.loan.pos.dao.entity.TRelativeInfo;
import com.hrbb.loan.pos.dao.entity.TSmsMessage;
import com.hrbb.loan.pos.dao.entity.TSmsTemplate;
import com.hrbb.loan.pos.service.CreditApplyAprvInfoService;
import com.hrbb.loan.pos.service.LoanPosBusinessCodeService;
import com.hrbb.loan.pos.service.LoanPosChannelPosCust;
import com.hrbb.loan.pos.service.SendSmsMessageService;
import com.hrbb.loan.pos.service.bean.ApproveDueDiligenceMessage;
import com.hrbb.loan.pos.service.bean.ApprovePassMessage;
import com.hrbb.loan.pos.service.bean.ApproveRejectMessage;
import com.hrbb.loan.pos.service.bean.CreditReportDownloadMessage;
import com.hrbb.loan.pos.service.bean.NeedMoreEvidMessage;
import com.hrbb.loan.pos.service.constants.SmsTypeContants;
import com.hrbb.loan.pos.util.DateUtil;
import com.hrbb.loan.pos.util.IdUtil;
import com.hrbb.loan.pos.util.SmsTemplateFactory;
import com.hrbb.loan.pos.util.StringUtil;
import com.hrbb.loan.pos.util.constants.ReviewNoteConstants;

/**
 * 
 * @author marco
 * @version $Id: CreditApplyAprvInfoServiceImpl.java, v 0.1 2015-3-10 下午5:53:23
 *          marco Exp $
 */
@Service("creditApplyAprvInfoService")
public class CreditApplyAprvInfoServiceImpl implements
		CreditApplyAprvInfoService {

	private static final String 辜小亮 = "00037";
	private Logger LOG = LoggerFactory
			.getLogger(CreditApplyAprvInfoServiceImpl.class);

	// 授信拒绝
	public final String APPROVE_REFLUED_TEMPID = "POS0010";

	@Autowired
	@Qualifier("tCreditApplyForReviewDao")
	private TCreditApplyForReviewDao daoCA;
	@Autowired
	@Qualifier("tCreditApplyAprvInfoDao")
	private TCreditApplyAprvInfoDao dao;

	@Autowired
	@Qualifier("tApproveResultDao")
	private TApproveResultDao daoAR;

	@Autowired
	private TUserGroupDao tUserGroupDao;

	@Autowired
	@Qualifier("tBankAccnoInfoDao")
	private TBankAccnoInfoDao daoBA;

	@Autowired
	private TBankSerialnoInfoDao bankSerialnoInfoDao;

	@Autowired
	private TReviewAssignTaskDao tReviewAssignTaskDao;

	@Autowired
	private TMessageDao tMessageDao;

	@Autowired
	private TPosCustInfoDao tPosCustInfoDao;

	@Autowired
	private TCallingTaskDao tCallingTaskDao;

	@Autowired
	private TUserApprInfoDao tUserApprInfoDao;

	@Autowired
	private LoanPosBusinessCodeService loanPosBusinessCodeService;

	@Autowired
	private TCustomerDao tCustomerDao;

	@Autowired
	private TBankSerialnoInfoDao tBankSerialnoInfoDao;

	@Autowired
	private LoanPosChannelPosCust loanPosChannelPosCust;

	@Autowired
	private TRelativeInfoDao tRelativeInfoDao;

	@Autowired
	@Qualifier("tSmsTemplateDao")
	private TSmsTemplateDao tSmsTemplateDao;

	@Autowired
	private TSmsMessageDao tSmsMessageDao;

	@Autowired
	private TPosSerialnoInfoDao tPosSerialnoInfoDao;

	@Autowired
	private TBusinessDictionaryDao tBusinessDictionaryDao;

	@Autowired
	private SendSmsMessageService sendSmsMessageService;

	@Autowired
	private TCreditGroupDao tCreditGroupDao;

	/**
	 * @see com.hrbb.loan.pos.service.CreditApplyAprvInfoService#deleteByPrimaryKey(com.hrbb.loan.pos.dao.entity.TCreditApplyAprvInfoKey)
	 */
	@Override
	public int deleteByPrimaryKey(TCreditApplyAprvInfoKey key) {
		return 0;
	}

	/**
	 * @see com.hrbb.loan.pos.service.CreditApplyAprvInfoService#insert(com.hrbb.loan.pos.dao.entity.TCreditApplyAprvInfo)
	 */
	@Override
	public int insert(TCreditApplyAprvInfo record) {
		return 0;
	}

	/**
	 * @see com.hrbb.loan.pos.service.CreditApplyAprvInfoService#insertSelective(com.hrbb.loan.pos.dao.entity.TCreditApplyAprvInfo)
	 */
	@Override
	public int insertSelective(TCreditApplyAprvInfo record) {
		return dao.insertSelective(record);
	}

	/**
	 * @see com.hrbb.loan.pos.service.CreditApplyAprvInfoService#selectByPrimaryKey(com.hrbb.loan.pos.dao.entity.TCreditApplyAprvInfoKey)
	 */
	@Override
	public TCreditApplyAprvInfo selectByPrimaryKey(TCreditApplyAprvInfoKey key) {
		return null;
	}

	/**
	 * @see com.hrbb.loan.pos.service.CreditApplyAprvInfoService#updateByPrimaryKeySelective(com.hrbb.loan.pos.dao.entity.TCreditApplyAprvInfo)
	 */
	@Override
	public int updateByPrimaryKeySelective(TCreditApplyAprvInfo record) {
		return dao.updateByPrimaryKeySelective(record);
	}

	/**
	 * @see com.hrbb.loan.pos.service.CreditApplyAprvInfoService#updateByPrimaryKey(com.hrbb.loan.pos.dao.entity.TCreditApplyAprvInfo)
	 */
	@Override
	public int updateByPrimaryKey(TCreditApplyAprvInfo record) {
		return 0;
	}

	/**
	 * @see com.hrbb.loan.pos.service.CreditApplyAprvInfoService#selectNotSubbmit(com.hrbb.loan.pos.dao.entity.TCreditApplyAprvInfoKey)
	 */
	@Override
	public TCreditApplyAprvInfo selectNotSubmit(TCreditApplyAprvInfoKey key) {
		TCreditApplyAprvInfo record = dao.selectNotSubmit(key);
		return record == null ? new TCreditApplyAprvInfo() : record;
	}

	/**
	 * @see com.hrbb.loan.pos.service.CreditApplyAprvInfoService#selectLastSubbmitted(com.hrbb.loan.pos.dao.entity.TCreditApplyAprvInfoKey)
	 */
	@Override
	public TCreditApplyAprvInfo selectLastSubbmitted(TCreditApplyAprvInfoKey key) {
		TCreditApplyAprvInfo record = dao.selectLastSubbmitted(key);
		return record == null ? new TCreditApplyAprvInfo() : record;
	}

	/**
	 * 回退前手列表
	 * 
	 * @see com.hrbb.loan.pos.service.CreditApplyAprvInfoService#selectNotSubbmit(com.hrbb.loan.pos.dao.entity.TCreditApplyAprvInfoKey)
	 */
	@Override
	public List<TCreditApplyAprvInfo> selectBackToInfo(
			TCreditApplyAprvInfo record) {
		return dao.selectBackToInfo(record);
	}

	/**
	 * @see com.hrbb.loan.pos.service.CreditApplyAprvInfoService#selectNotSubbmit(com.hrbb.loan.pos.dao.entity.TCreditApplyAprvInfoKey)
	 */
	@Override
	public List<TCreditApplyAprvInfo> selectInforAuditList(
			TCreditApplyAprvInfo record) {
		List<TCreditApplyAprvInfo> l = dao.selectInforAuditList(record);
		for (TCreditApplyAprvInfo r : l) {
			r.setAppBeginTimeStr(DateUtil.formatDate(r.getAppBeginTime(),
					DateUtil.HRRB_LONG_DATETIME_FORMAT));
			r.setAppEndTimeStr(DateUtil.formatDate(r.getAppEndTime(),
					DateUtil.HRRB_LONG_DATETIME_FORMAT));
			// 待处理 ,受理
			if (ReviewNoteConstants.APPLYSTATUS_CODE_00
					.equals(r.getApprState())
					|| ReviewNoteConstants.APPLYSTATUS_CODE_10.equals(r
							.getApprState())) {
				r.setApprStateTitle(ReviewNoteConstants.APPLYSTATUS_TITLE_CODE_10);
				// 资料审核
			} else if (ReviewNoteConstants.APPLYSTATUS_CODE_20.equals(r
					.getApprState())
					|| ReviewNoteConstants.APPLYSTATUS_CODE_21.equals(r
							.getApprState())) {
				r.setApprStateTitle(ReviewNoteConstants.APPLYSTATUS_TITLE_CODE_20);
				// 风险初审
			} else if (ReviewNoteConstants.APPLYSTATUS_CODE_30.equals(r
					.getApprState())
					|| ReviewNoteConstants.APPLYSTATUS_CODE_91.equals(r
							.getApprState())) {
				r.setApprStateTitle(ReviewNoteConstants.APPLYSTATUS_TITLE_CODE_30);
				// 风险复审
			} else if (ReviewNoteConstants.APPLYSTATUS_CODE_31.equals(r
					.getApprState())
					|| ReviewNoteConstants.APPLYSTATUS_CODE_32.equals(r
							.getApprState())
					|| ReviewNoteConstants.APPLYSTATUS_CODE_33.equals(r
							.getApprState())
					|| ReviewNoteConstants.APPLYSTATUS_CODE_34.equals(r
							.getApprState())
					|| ReviewNoteConstants.APPLYSTATUS_CODE_35.equals(r
							.getApprState())
					|| ReviewNoteConstants.APPLYSTATUS_CODE_90.equals(r
							.getApprState())
					|| ReviewNoteConstants.APPLYSTATUS_CODE_92.equals(r
							.getApprState())) {
				r.setApprStateTitle(ReviewNoteConstants.APPLYSTATUS_TITLE_CODE_31);
				// 尽调
			} else if (ReviewNoteConstants.APPLYSTATUS_CODE_40.equals(r
					.getApprState())
					|| ReviewNoteConstants.APPLYSTATUS_CODE_41.equals(r
							.getApprState())) {
				r.setApprStateTitle(ReviewNoteConstants.APPLYSTATUS_TITLE_CODE_40);
			} else {
				// 用户主动撤销，不处理
			}

			String apprResult = r.getApprResult();
			if (apprResult != null && apprResult.trim().length() > 0) {
				String apprResultName = loanPosBusinessCodeService
						.getItemNameByNo("ReviewOpinion", apprResult);
				if (apprResultName != null
						&& apprResultName.trim().length() > 0) {
					r.setApprResult(apprResultName);
				}
			}
			String apprState = r.getApprState();
			if (apprState != null && apprState.trim().length() > 0) {
				String apprStateName = loanPosBusinessCodeService
						.getItemNameByNo("ApplyStatus", apprState);
				if (apprStateName != null && apprStateName.trim().length() > 0) {
					r.setApprStateName(apprStateName);
				}
			}
		}
		return l;
	}

	/**
	 * @see com.hrbb.loan.pos.service.CreditApplyAprvInfoService#update(com.hrbb.loan.pos.dao.entity.TCreditApplyAprvInfo)
	 */
	@Override
	public Map<String, Object> update(TCreditApplyAprvInfo record) {
		LOG.debug("update begin");
		LOG.debug("申请批复信息为" + record);
		TCreditApply ca = new TCreditApply();
		String LoanId = record.getLoanId();
		ca.setLoanId(LoanId);
		// 处理结果
		String apprResult = record.getApprResult();
		// 申请状态
		String apprState = record.getApprState();
		// 权限
		String privileges = record.getPrivileges();

		LOG.debug("LoanId=" + LoanId);
		LOG.debug("apprResult=" + apprResult);
		LOG.debug("apprState=" + apprState);
		LOG.debug("privileges=" + privileges);
		// 通过
		if (ReviewNoteConstants.APPRRESULT_CODE_10.equals(apprResult)) {
			// 资料审核或资料审核补件
			if (ReviewNoteConstants.APPLYSTATUS_CODE_20.equals(apprState)
					|| ReviewNoteConstants.APPLYSTATUS_CODE_21
							.equals(apprState)) {
				// 风险初审
				ca.setApplyStatus(ReviewNoteConstants.APPLYSTATUS_CODE_30);

				// 复审补件,尽调审核
			} else {
				// 审批通过
				ca.setApplyStatus(ReviewNoteConstants.APPLYSTATUS_CODE_90);
			}
			// 拒绝
		} else if (ReviewNoteConstants.APPRRESULT_CODE_20.equals(apprResult)) {
			// 申请状态
			ca.setApplyStatus(ReviewNoteConstants.APPLYSTATUS_CODE_92);
			// 回退前手
		} else if (ReviewNoteConstants.APPRRESULT_CODE_30.equals(apprResult)) {
			// 回退前手信息
			String[] backToInfo = record.getBackToId().split(
					ReviewNoteConstants.STRING_SEPARATOR_KEY);
			// 回退前手人
			record.setBackToId(backToInfo[0]);
			// 回退状态
			record.setApprStateToBack(backToInfo[1]);
			// 回退资料审核状态时
			if (ReviewNoteConstants.APPLYSTATUS_CODE_20.equals(record
					.getApprStateToBack())) {
				// 资料审核人员
				ca.setInfoCheckPerson(record.getBackToId());
				// 回退复审状态时
			} else {
				// 信贷复审人员
				ca.setCreditRecheckPerson(record.getBackToId());
			}
			// 申请状态
			ca.setApplyStatus(record.getApprStateToBack());
			// 尽职调查
		} else if (ReviewNoteConstants.APPRRESULT_CODE_40.equals(apprResult)) {
			// 申请状态
			ca.setApplyStatus(ReviewNoteConstants.APPLYSTATUS_CODE_40);
			// 退回补件
		} else if (ReviewNoteConstants.APPRRESULT_CODE_31.equals(apprResult)) {
			// 资料审核或资料审核补件
			if (ReviewNoteConstants.APPLYSTATUS_CODE_20.equals(apprState)
					|| ReviewNoteConstants.APPLYSTATUS_CODE_21
							.equals(apprState)) {
				// 资料审核补件
				ca.setApplyStatus(ReviewNoteConstants.APPLYSTATUS_CODE_21);
				// 风险复审1,2,3风险复审补件
			} else if (ReviewNoteConstants.APPLYSTATUS_CODE_31
					.equals(apprState)
					|| ReviewNoteConstants.APPLYSTATUS_CODE_32
							.equals(apprState)
					|| ReviewNoteConstants.APPLYSTATUS_CODE_33
							.equals(apprState)
					|| ReviewNoteConstants.APPLYSTATUS_CODE_34
							.equals(apprState)) {
				// 复审补件
				ca.setApplyStatus(ReviewNoteConstants.APPLYSTATUS_CODE_32);

			} else {
				// 风险复审4,尽调审核状态不能补件
			}
			// 下一阶段
		} else {
			// 风险复审1
			if (ReviewNoteConstants.APPLYSTATUS_CODE_31.equals(apprState)) {
				// 风险复审2
				ca.setApplyStatus(ReviewNoteConstants.APPLYSTATUS_CODE_33);
				// 风险复审2
			} else if (ReviewNoteConstants.APPLYSTATUS_CODE_33
					.equals(apprState)) {
				// 风险复审3
				ca.setApplyStatus(ReviewNoteConstants.APPLYSTATUS_CODE_34);
				// 风险复审3
			} else if (ReviewNoteConstants.APPLYSTATUS_CODE_34
					.equals(apprState)) {
				// 风险复审4
				ca.setApplyStatus(ReviewNoteConstants.APPLYSTATUS_CODE_35);
				// 复审补件
			} else if (ReviewNoteConstants.APPLYSTATUS_CODE_32
					.equals(apprState)) {
				// 风险复审1
				if (privileges.indexOf(ReviewNoteConstants.ROLE_APPR_LV1) >= 0) {
					// 风险复审3
					ca.setApplyStatus(ReviewNoteConstants.APPLYSTATUS_CODE_33);
				}
				// 风险复审2
				if (privileges.indexOf(ReviewNoteConstants.ROLE_APPR_LV2) >= 0) {
					// 风险复审3
					ca.setApplyStatus(ReviewNoteConstants.APPLYSTATUS_CODE_34);
				}
				// 风险复审3
				if (privileges.indexOf(ReviewNoteConstants.ROLE_APPR_LV3) >= 0) {
					// 风险复审4
					ca.setApplyStatus(ReviewNoteConstants.APPLYSTATUS_CODE_35);
				}
			} else {
				// 其他状态，下一阶段按钮不可见，所以这里不做处理
			}
		}
		// 最后操作人
		ca.setLastOperId(record.getApprvId());
		// 最后操作时间
		ca.setLastOperTime(record.getAppEndTime());

		// 资料审核状态，且通过或拒绝时
		if (ReviewNoteConstants.APPLYSTATUS_CODE_20.equals(apprState)
				&& (ReviewNoteConstants.APPRRESULT_CODE_10.equals(apprResult) || ReviewNoteConstants.APPRRESULT_CODE_20
						.equals(apprResult))) {
			// 非银商渠道,不存在有效的POS流水记录
			Map<String, Object> reqMap = Maps.newHashMap();
			reqMap.put(ReviewNoteConstants.LOAN_ID, LoanId);
			// 有银行流水，则为流量贷；没有的话，POS贷
			long countBank = tBankSerialnoInfoDao.countMap(reqMap);
			// 查询是否有pos流水
			long countPosSerial = tPosSerialnoInfoDao.countMap(reqMap);
			// 只有pos流水没有银行流水时为pos贷
			if (countPosSerial > 0 && countBank == 0) {
				// 默认为POS贷，所以这里不用更新
				// 以上以外为流量贷
			} else {
				ca.setProdId(ReviewNoteConstants.FLOW_LOAN_ID);
				ca.setProdName(ReviewNoteConstants.FLOW_LOAN_NAME);
			}
		}

		// 更新申请状态
		int flag = 0;
		// 回退前手
		if (ReviewNoteConstants.APPRRESULT_CODE_30.equals(apprResult)) {
			flag = daoCA.updateForReviewBackTo(ca);
			// 退回补件
			// } else if
			// (ReviewNoteConstants.APPRRESULT_CODE_31.equals(apprResult)) {
			// flag = daoCA.updateForReviewAddInfo(ca);
			// 同意，不同意，尽调
		} else {
			flag = daoCA.updateForReview(ca);
		}
		// 更新失败
		if (flag != 1) {
			Map<String, Object> respMap = Maps.newHashMap();
			respMap.put("flag", flag);
			respMap.put("record", record);
			return respMap;
		}
		// 申请状态保存成功
		// 更新申请审批记录表
		flag = dao.updateByPrimaryKeySelective(record);
		// 更新失败
		if (flag != 1) {
			Map<String, Object> respMap = Maps.newHashMap();
			respMap.put("flag", flag);
			respMap.put("record", record);
			return respMap;
		}
		// 申请审批记录表更新成功
		// 回退前手
		if (ReviewNoteConstants.APPRRESULT_CODE_30.equals(apprResult)) {

			TCreditApplyAprvInfo recordInsert = new TCreditApplyAprvInfo();
			// 业务编号
			recordInsert.setLoanId(record.getLoanId());
			// 信贷复审人员
			recordInsert.setApprvId(record.getBackToId());
			// 申请状态
			recordInsert.setApprState(record.getApprStateToBack());
			// 审批发起时间
			recordInsert.setAppBeginTime(record.getAppEndTime());
			// 审批结束时间（审批人的待处理任务）
			recordInsert.setAppEndTime(null);
			// 批准金额
			recordInsert.setApprAmount(record.getApprAmount());
			// 批准利率
			recordInsert.setApprInte(record.getApprInte());
			// 还款方式
			recordInsert.setRetuKind(record.getRetuKind());
			// 意见详情内部
			recordInsert.setApprInfo(record.getApprInfo());
			// 意见详情外部
			recordInsert.setApprInfoExt(record.getApprInfoExt());
			// 备注
			recordInsert.setRemark(record.getRemark());
			// 登录前手人的任务记录
			flag = dao.insertSelective(recordInsert);

			// 退回补件
		} else if (ReviewNoteConstants.APPRRESULT_CODE_31.equals(apprResult)) {

			// 生成任务记录
			TCreditApplyAprvInfo recordInsert = new TCreditApplyAprvInfo();
			// 业务编号
			recordInsert.setLoanId(record.getLoanId());
			// 信贷复审人员
			recordInsert.setApprvId(record.getApprvId());
			// 申请状态
			recordInsert.setApprState(apprState);
			// 批准金额
			recordInsert.setApprAmount(record.getApprAmount());
			// 批准利率
			recordInsert.setApprInte(record.getApprInte());
			// 还款方式
			recordInsert.setRetuKind(record.getRetuKind());
			// 意见详情内部
			recordInsert.setApprInfo(record.getApprInfo());
			// 意见详情外部
			recordInsert.setApprInfoExt(record.getApprInfoExt());
			// 备注
			recordInsert.setRemark(record.getRemark());
			// 审批发起时间
			recordInsert.setAppBeginTime(record.getAppEndTime());
			// 审批结束时间（审批人的待处理任务）
			recordInsert.setAppEndTime(null);
			// 登录前手人的任务记录
			flag = dao.insertSelective(recordInsert);

			// 更新失败
			if (flag != 1) {
				Map<String, Object> respMap = Maps.newHashMap();
				respMap.put("flag", flag);
				respMap.put("record", record);
				return respMap;
			}
			// 查询最新申请状态
			TCreditApply caForNeed = daoCA.selectOne(ca.getLoanId());

			NeedMoreEvidMessage nmem = new NeedMoreEvidMessage();
			nmem.setAddiSpec(record.getNeedReason()).setAdditPhase(
					ReviewNoteConstants.MESSAGETYPE_NEEDMOREEVID_PREFIX);

			// 登录消息表，发送补件通知
			flag = insertTMessage(ReviewNoteConstants.MESSAGETYPE_NEEDMOREEVID,
					nmem.toString(), record.getNeedInforCodes(), caForNeed);

			// 尽调
		} else if (ReviewNoteConstants.APPRRESULT_CODE_40.equals(apprResult)) {
			// 查询申请信息查询
			LOG.debug("选择了尽调...loanId:" + record.getLoanId());
			TCreditApply caForAppr = daoCA.selectOne(record.getLoanId());
			LOG.debug("选择尽调2...loanId:" + caForAppr.getLoanId());
			// 发送尽调信息
			sendMessageToNoticePad(caForAppr);
		}
		// 更新失败
		if (flag != 1) {
			Map<String, Object> respMap = Maps.newHashMap();
			respMap.put("flag", flag);
			respMap.put("record", record);
			return respMap;
		}
		// 更新成功
		// 授信批复信息
		TApproveResult ar = null;
		// 审批通过时
		if (ReviewNoteConstants.APPLYSTATUS_CODE_90.equals(ca.getApplyStatus())) {
			// 查询申请信息查询
			TCreditApply caForAppr = daoCA.selectOne(record.getLoanId());
			// 授信批复信息
			ar = new TApproveResult();
			// 登录授信批复表
			flag = insertApproveResult(caForAppr, record, ar);
			// 更新失败
			if (flag != 1) {
				Map<String, Object> respMap = Maps.newHashMap();
				respMap.put("flag", flag);
				respMap.put("record", record);
				return respMap;
			}
			// 登录成功
			ApprovePassMessage apm = new ApprovePassMessage();
			apm.setAppMaxCred(record.getApprAmount().toString())
					.setInterRate(
							record.getApprInte()
									.divide(new BigDecimal("100"), 4,
											BigDecimal.ROUND_HALF_UP)
									.toString())
					.setApptTerm(caForAppr.getApplyTerm())
					.setApptTermUnit(caForAppr.getTermUnit());
			// 登录消息表，发送通知
			flag = insertTMessage(ReviewNoteConstants.MESSAGETYPE_APPROVE,
					apm.toString(), null, caForAppr);

			// 审批拒绝
		} else if (ReviewNoteConstants.APPLYSTATUS_CODE_92.equals(ca
				.getApplyStatus())) {
			// 查询申请信息查询
			LOG.debug(record.getLoanId() + "查询申请信息");
			TCreditApply caForAppr = daoCA.selectOne(record.getLoanId());

			ApproveRejectMessage arm = new ApproveRejectMessage();
			String nextLoanDate = DateUtil.getRelativeDate(new Date(), 0, 3, 0,
					"yyyyMMdd");
			arm.setNextLoanDate(nextLoanDate);
			// 审批意见（外部）没有输入的时候，设置为审批意见（内部）
			if (StringUtil.isEmpty(record.getApprInfoExt())) {
				arm.setRefuseReason(record.getApprInfo());
			} else {
				// 20150728 guoyu 审批意见外部的内容从编号转变为内容
				// arm.setRefuseReason(record.getApprInfoExt());
				arm.setRefuseReason(tBusinessDictionaryDao
						.getApprInfoExtMsg(record.getApprInfoExt()));
			}
			// 登录消息表，发送审批拒绝通知
			if (caForAppr.getChannel() != null
					&& ReviewNoteConstants.hasNextLoanDateSet
							.contains(caForAppr.getChannel())) {
				flag = insertTMessage(ReviewNoteConstants.MESSAGETYPE_REJECT,
						arm.toString(), null, caForAppr);
			} else {
				flag = insertTMessage(ReviewNoteConstants.MESSAGETYPE_REJECT,
						arm.toString(), null, caForAppr);
			}

			// 申请信息
			TCustomer c = tCustomerDao
					.selectByPrimaryKey(caForAppr.getCustId());
			if (c != null && StringUtil.isNotEmpty(c.getMobilePhone())) {
				// 拒绝短信入库
				flag = insertSmsMessage(c.getMobilePhone(),
						caForAppr.getChannel());
				LOG.debug("发送拒绝短信flag=" + flag);
			} else {
				LOG.error("没有客户信息或没有手机号！");
			}
		}
		// 申请的最终状态保存，以便后面查询状态名
		record.setApprState(ca.getApplyStatus());
		// 更新失败
		if (flag != 1) {
			Map<String, Object> respMap = Maps.newHashMap();
			respMap.put("flag", flag);
			respMap.put("record", record);
			return respMap;
		}
		// 生成外呼任务
		flag = insertCallingTask(apprState, apprResult, LoanId, ar,
				record.getApprInfoExt(), record.getRemark());
		LOG.debug("flag=" + flag);
		LOG.debug("update end");
		Map<String, Object> respMap = Maps.newHashMap();
		respMap.put("flag", flag);
		respMap.put("record", record);
		return respMap;
	}

	/**
	 * 生成外呼任务
	 * 
	 */
	private int insertCallingTask(String apprState, String apprResult,
			String relaBizNo, TApproveResult ar, String apprInfoExt,
			String remark) {
		// 20150728 guoyu 审批意见外部的内容从编号转变为内容
		String apprInfoExtMsg = tBusinessDictionaryDao
				.getApprInfoExtMsg(apprInfoExt);
		if (StringUtil.isNotEmpty(remark)) {
			apprInfoExtMsg = apprInfoExtMsg.concat("\r\n备注：").concat(remark);
		}
		// 查询申请信息查询
		TCreditApply caForAppr = daoCA.selectOne(relaBizNo);

		int flag = 1;
		// 58渠道的申请不生成外呼任务
		if (ReviewNoteConstants.CHANNEL_CODE_58.equals(caForAppr.getChannel())) {
			return flag;
		}
		// 资料审核
		if (ReviewNoteConstants.APPLYSTATUS_CODE_20.equals(apprState)
				|| ReviewNoteConstants.APPLYSTATUS_CODE_21.equals(apprState)) {
			// 补件
			if (ReviewNoteConstants.APPRRESULT_CODE_31.equals(apprResult)) {
				// 补件暂不生成外呼
				// flag = insertCallingTask(
				// ReviewNoteConstants.CALLING_TASK_CALLINGTYPE_01,
				// relaBizNo,
				// ReviewNoteConstants.CALLING_TASK_RELABIZPHASE_APP);
				// 拒绝
			} else if (ReviewNoteConstants.APPRRESULT_CODE_20
					.equals(apprResult)) {
				// 资料审核拒绝暂不生成外呼
				// flag = insertCallingTask(
				// ReviewNoteConstants.CALLING_TASK_CALLINGTYPE_11,
				// relaBizNo,
				// ReviewNoteConstants.CALLING_TASK_RELABIZPHASE_APP,
				// caForAppr);
			}
			// 其他结果不生成任务
			// 风险审核
		} else if (ReviewNoteConstants.APPLYSTATUS_CODE_31.equals(apprState)
				|| ReviewNoteConstants.APPLYSTATUS_CODE_32.equals(apprState)
				|| ReviewNoteConstants.APPLYSTATUS_CODE_33.equals(apprState)
				|| ReviewNoteConstants.APPLYSTATUS_CODE_34.equals(apprState)
				|| ReviewNoteConstants.APPLYSTATUS_CODE_35.equals(apprState)) {
			// 同意
			if (ReviewNoteConstants.APPRRESULT_CODE_10.equals(apprResult)) {
				flag = insertCallingTask(
						ReviewNoteConstants.CALLING_TASK_CALLINGTYPE_12,
						ar.getApproveId(),
						ReviewNoteConstants.CALLING_TASK_RELABIZPHASE_APR,
						caForAppr, null);
				// 不同意
			} else if (ReviewNoteConstants.APPRRESULT_CODE_20
					.equals(apprResult)) {
				flag = insertCallingTask(
						ReviewNoteConstants.CALLING_TASK_CALLINGTYPE_11,
						relaBizNo,
						ReviewNoteConstants.CALLING_TASK_RELABIZPHASE_APP,
						caForAppr, apprInfoExtMsg);
				// 补件
			} else if (ReviewNoteConstants.APPRRESULT_CODE_31
					.equals(apprResult)) {
				// 补件暂不生成外呼
				// flag = insertCallingTask(
				// ReviewNoteConstants.CALLING_TASK_CALLINGTYPE_01,
				// relaBizNo,
				// ReviewNoteConstants.CALLING_TASK_RELABIZPHASE_APP);
			} else {
				// 其他结果不生成任务
			}
			// 尽调审核
		} else if (ReviewNoteConstants.APPLYSTATUS_CODE_41.equals(apprState)) {
			// 同意
			if (ReviewNoteConstants.APPRRESULT_CODE_10.equals(apprResult)) {
				flag = insertCallingTask(
						ReviewNoteConstants.CALLING_TASK_CALLINGTYPE_12,
						ar.getApproveId(),
						ReviewNoteConstants.CALLING_TASK_RELABIZPHASE_APR,
						caForAppr, null);
				// 不同意
			} else if (ReviewNoteConstants.APPRRESULT_CODE_20
					.equals(apprResult)) {
				flag = insertCallingTask(
						ReviewNoteConstants.CALLING_TASK_CALLINGTYPE_11,
						relaBizNo,
						ReviewNoteConstants.CALLING_TASK_RELABIZPHASE_APP,
						caForAppr, apprInfoExtMsg);
			} else {
				// 其他结果不生成任务
			}
		}
		return flag;
	}

	/**
	 * 生成外呼任务
	 * 
	 */
	private int insertCallingTask(String callingType, String relaBizNo,
			String relaBizPhase, TCreditApply caForAppr, String info) {
		TCallingTask ct = new TCallingTask();
		ct.setTaskNo(IdUtil.getId(ReviewNoteConstants.CALLING_TASK_KEY_PREFIX));
		ct.setGenerateTime(new Date());
		ct.setCallingType(callingType);
		ct.setRelaBizNo(relaBizNo);
		ct.setRelaBizPhase(relaBizPhase);
		ct.setCustId(caForAppr.getCustId());
		ct.setCustName(caForAppr.getCustName());
		ct.setPosCustId(caForAppr.getPosCustId());
		ct.setPosCustName(caForAppr.getPosCustName());
		if (StringUtil.isNotEmpty(info)) {
			ct.setInfo(info);
		}
		return tCallingTaskDao.insertSelective(ct);
	}

	/**
	 * 登录消息表
	 * 
	 */
	private int insertTMessage(String type, String info, String addi,
			TCreditApply ca) {
		TMessage m = new TMessage();
		m.setMessageType(type);
		m.setMessageInfo(info);
		m.setMessageAddi(addi);
		// 查询最新申请状态
		m.setLoanId(ca.getLoanId());
		m.setCustId(ca.getCustId());
		m.setChannel(ca.getChannel());
		m.setInChannelKind(ca.getInChannelKind());
		m.setStdshNo(ca.getStdshno());
		m.setStdMerNo(ca.getStdmerno());
		// 发送补件通知
		return tMessageDao.insert(m);
	}

	/**
	 * 发送尽调信息
	 * 
	 * @param caForAppr
	 */
	private void sendMessageToNoticePad(TCreditApply caForAppr) {
		ApproveDueDiligenceMessage approveDueDiligenceMessage = new ApproveDueDiligenceMessage();
		approveDueDiligenceMessage.setLoanid(caForAppr.getLoanId());
		approveDueDiligenceMessage.setPosorg(caForAppr.getPosOrg());
		approveDueDiligenceMessage.setPoscustname(caForAppr.getPosCustName());
		TPosCustInfo tPosCustInfo = tPosCustInfoDao
				.selectByPrimaryKey(caForAppr.getPosCustId());
		if (tPosCustInfo != null) {
			approveDueDiligenceMessage.setRegicode(tPosCustInfo.getRegiCode());
			approveDueDiligenceMessage.setDealscope(tPosCustInfo
					.getPosCustBusiScope());
			approveDueDiligenceMessage.setOperaddrRegion(tPosCustInfo
					.getOperAddrCode());
			approveDueDiligenceMessage.setOperaddrdetail(tPosCustInfo
					.getPosCustAddress());
			approveDueDiligenceMessage.setIndustrytypeid(tPosCustInfo
					.getIndustryTypeId());
		}
		TCustomer tCustomer = tCustomerDao.selectByPrimaryKey(caForAppr
				.getCustId());
		if (tCustomer != null) {
			approveDueDiligenceMessage.setCustname(tCustomer.getCustName());
			approveDueDiligenceMessage.setPaperkind(tCustomer.getPaperKind());
			approveDueDiligenceMessage.setPaperid(tCustomer.getPaperId());
			approveDueDiligenceMessage.setSexsign(tCustomer.getSexSign());
			approveDueDiligenceMessage.setBusiyear(tCustomer.getBusiYear());
			approveDueDiligenceMessage.setMarrsign(tCustomer.getMarrSign());
			approveDueDiligenceMessage.setEducsign(tCustomer.getEducSign());
			approveDueDiligenceMessage.setChildnum(tCustomer.getChildNum());
			approveDueDiligenceMessage.setLocalhousenum(tCustomer
					.getLocalHouseNum());
			approveDueDiligenceMessage.setOtherhousenum(tCustomer
					.getOtherHouseNum());
			approveDueDiligenceMessage.setMobilephone(tCustomer
					.getMobilePhone());
			approveDueDiligenceMessage.setTel(tCustomer.getTel());
			approveDueDiligenceMessage.setContactaddrflag(tCustomer
					.getContactAddrFlag());
			approveDueDiligenceMessage.setWeixinno(tCustomer.getWeixinNo());
			approveDueDiligenceMessage.setQqno(tCustomer.getQqNo());
			approveDueDiligenceMessage.setEmail(tCustomer.getEmail());
			approveDueDiligenceMessage.setFamilycustname(tCustomer
					.getFamilyCustName());
			approveDueDiligenceMessage.setFamilypaperkind(tCustomer
					.getMatePaperKind());
			approveDueDiligenceMessage.setFamilypaperid(tCustomer
					.getMatePaperId());
			approveDueDiligenceMessage.setMatemobilephone(tCustomer
					.getMateMobilephone());
			approveDueDiligenceMessage.setResidentRegion(tCustomer
					.getResidentDivision());
			approveDueDiligenceMessage.setResidentdetail(tCustomer
					.getResidentDetail());
		}

		// 亲属信息
		if (StringUtil.isNotEmpty(caForAppr.getRelativeId())) {
			TRelativeInfo tRelativeInfo = tRelativeInfoDao
					.selectByPrimaryKey(caForAppr.getRelativeId());
			if (tRelativeInfo != null) {
				approveDueDiligenceMessage.setRelacustname(tRelativeInfo
						.getRelaCustName());
				approveDueDiligenceMessage.setRelakind(tRelativeInfo
						.getRelaKind());
				approveDueDiligenceMessage.setRelamobilephone(tRelativeInfo
						.getRelaMobilePhone());
				approveDueDiligenceMessage.setRelatel(tRelativeInfo
						.getRelaTel());
			}
		}
		approveDueDiligenceMessage.setImagefilepackagename("");
		approveDueDiligenceMessage.setApptcapi(String.valueOf(caForAppr
				.getApplyAmt()));
		approveDueDiligenceMessage.setRetukind(caForAppr.getReturnKind());
		approveDueDiligenceMessage.setBankaccno(caForAppr.getBankAccno());
		approveDueDiligenceMessage.setBankid(caForAppr.getBankId());
		approveDueDiligenceMessage.setOperid(caForAppr.getOperId());
		approveDueDiligenceMessage.setBegindate(DateFormatUtils.format(
				caForAppr.getBeginDate(), "yyyyMMddHHmmss"));
		approveDueDiligenceMessage.setDuedilino("");
		approveDueDiligenceMessage.setDuedilistaffid("");
		approveDueDiligenceMessage.setDuedilitaskno("");
		approveDueDiligenceMessage.setDuedilifinishdate("");
		approveDueDiligenceMessage.setPreappmaxcred(String.valueOf(caForAppr
				.getApplyAmt())); // 预授信额度
		approveDueDiligenceMessage.setPreapptterm(caForAppr.getApplyTerm()); // 预授信期限
		TCreditApplyAprvInfo tCreditApplyAprvInfo = new TCreditApplyAprvInfo();
		LOG.debug("推送尽调消息loanid为:" + caForAppr.getLoanId());
		tCreditApplyAprvInfo.setLoanId(caForAppr.getLoanId());
		tCreditApplyAprvInfo
				.setApprResult(ReviewNoteConstants.APPRRESULT_CODE_40);
		TCreditApplyAprvInfo tmpApplyAprvInfo = dao
				.selectLastOne(tCreditApplyAprvInfo);
		LOG.debug("推送尽调消息 aprvInfo结果为:" + tmpApplyAprvInfo);
		if (tmpApplyAprvInfo != null) {
			LOG.debug("推送尽调消息利率为:" + tmpApplyAprvInfo.getApprInte());
			approveDueDiligenceMessage.setInterate(String
					.valueOf(tmpApplyAprvInfo.getApprInte())); // 贷款利率
		}

		insertTMessageToNoticePad(ReviewNoteConstants.MESSAGETYPE_APPROVE,
				approveDueDiligenceMessage.toURLParam(), null, caForAppr);
	}

	private int insertTMessageToNoticePad(String type, String info,
			String addi, TCreditApply ca) {
		TMessage m = new TMessage();
		m.setMessageType(type);
		m.setMessageInfo(info);
		m.setMessageAddi(addi);
		// 查询最新申请状态
		m.setLoanId(ca.getLoanId());
		m.setCustId(ca.getCustId());
		m.setChannel(ca.getChannel());
		m.setInChannelKind(ca.getInChannelKind());

		// 发送尽职调查通知
		return tMessageDao.insert(m);
	}

	/**
	 * 登录授信批复表
	 * 
	 */
	private int insertApproveResult(TCreditApply ca,
			TCreditApplyAprvInfo record, TApproveResult ar) {
		LOG.debug("批复结果为" + ar);
		// 批复编号
		ar.setApproveId(IdUtil.getId(ReviewNoteConstants.APPROVE_ID_INDEX));
		// 业务来源
		ar.setBusinessSource(ca.getChannel());
		// 申请编号
		ar.setLoanId(ca.getLoanId());
		// 客户编号
		ar.setCustId(ca.getCustId());
		// 客户名称
		ar.setCustName(ca.getCustName());
		// 商户id
		ar.setPosCustId(ca.getPosCustId());
		// 商户名称
		ar.setPosCustName(ca.getPosCustName());
		// 申请提交日期
		ar.setApplyCommitDate(ca.getBeginDate());
		// 申请金额
		ar.setApplyAmt(ca.getApplyAmt());
		// 申请币种
		ar.setApplyMoneyKind(ca.getCurrSign());
		// 申请期限单位
		ar.setTermUnit(ca.getTermUnit());
		// 申请期限
		ar.setApplyTerm(ca.getApplyTerm());
		// 批复日期
		ar.setApproveDate(record.getAppEndTime());
		// 批复失效日期
		// Calendar cal = Calendar.getInstance();
		// cal.setTime(ar.getApproveDate());
		// cal.add(Calendar.DATE, 7);
		// ar.setExpiryDate(cal.getTime());
		// 批复金额
		ar.setApproveAmount(record.getApprAmount());
		// 批复币种
		ar.setApproveMoneyKind(ca.getCurrSign());
		// 批复利率
		ar.setApproveInterest(record.getApprInte());
		// 批复期限单位
		ar.setApproveTermUnit(ca.getTermUnit());
		// 批复期限
		ar.setApproveTerm(ca.getApplyTerm());
		// 还款方式
		// ar.setPaybackMethod(record.getRetuKind());
		// 收款账号
		ar.setAcceptAccount(ca.getBankAccno());
		// 账户信息查询
		TBankAccnoInfo ba = daoBA.selectByPrimaryKey(ca.getBankAccno());
		if (ba != null) {
			// 账户开户行
			ar.setAccountOpenBank(ba.getBankName());
			// 账户分行
			ar.setAccountBranchBank(ba.getBankBranName());
			// 账户支行
			ar.setAccountSubBranchBank(ba.getBankSubbName());
			// 产品编号
			ar.setProductId(ca.getProdId());
		}
		// 批复状态
		// 资金池模式为02已确认
		if (ReviewNoteConstants.LOANTYPE_02.equals(ca.getLoanType())) {
			ar.setApproveStatus(ReviewNoteConstants.APPROVE_STATUS_CODE_02);
			// 还款方式
			ar.setPaybackMethod("90");
			// 批复失效日期
			// 在调用的地方应该已经设置好了
		} else {
			// 还款方式
			ar.setPaybackMethod(record.getRetuKind());
			// 批复失效日期
			Calendar cal = Calendar.getInstance();
			cal.setTime(ar.getApproveDate());
			cal.add(Calendar.DATE, 7);
			ar.setExpiryDate(cal.getTime());
			// 批复状态
			ar.setApproveStatus(ReviewNoteConstants.APPROVE_STATUS_CODE_01);
		}
		// 申请流水号（银联商务）
		ar.setStdshno(ca.getStdshno());
		// 偿还方式
		ar.setLoanPaybackWay(ca.getRepayMethod());
		if (daoAR.selectByLoanId(ar.getLoanId()) == null) {
			LOG.debug(ar.getLoanId() + "批复为空, 要加入新批复");
			int flag = daoAR.insertSelective(ar);
			LOG.debug("加入批复flag=" + flag);
			return flag;
		} else {
			LOG.debug(ar.getLoanId() + "批复不为空, 更新批复");
			int flag = daoAR.updateByPrimaryKeySelective(ar);
			LOG.debug("更新批复flag=" + flag);
			return 1;
		}
	}

	/**
	 * @see com.hrbb.loan.pos.service.CreditApplyAprvInfoService#update(com.hrbb.loan.pos.dao.entity.TCreditApplyAprvInfo)
	 */
	@Override
	public int updateByBankSerialInfo(TCreditApplyAprvInfo record,
			List<Map<String, Object>> bankSerialList) {
		TCreditApply ca = new TCreditApply();
		ca.setLoanId(record.getLoanId());
		// 申请状态
		ca.setApplyStatus(ReviewNoteConstants.APPLYSTATUS_CODE_20);
		// 最后操作人
		ca.setLastOperId(record.getApprvId());
		// 最后操作时间
		ca.setLastOperTime(record.getAppEndTime());
		// 更新申请状态
		int flag = daoCA.updateByPrimaryKeySelective(ca);
		// 保存成功
		if (flag == 1) {
			// 更新申请审批记录表
			flag = dao.updateByPrimaryKeySelective(record);
			// 申请审批记录表更新成功
			if (flag == 1) {
				for (Map<String, Object> insertMap : bankSerialList) {
					insertMap.put(ReviewNoteConstants.LOAN_ID,
							record.getLoanId());
					insertMap.put(ReviewNoteConstants.CUST_ID,
							record.getCustId());
					insertMap.put(ReviewNoteConstants.CUST_NAME,
							record.getCustName());
					flag = bankSerialnoInfoDao.insertSelectiveMap(insertMap);
					if (flag != 1) {
						// 保存失败，返回标志位
						return flag;
					}
				}
				// 保存失败，返回标志位
			} else {
				return flag;
			}
			// 保存失败，返回标志位
		} else {
			return flag;
		}
		return flag;
	}

	/**
	 * 资料补件完成后，创建补件发起人的工作
	 * 
	 * @see com.hrbb.loan.pos.service.CreditApplyForReviewService#updateBackToReview(com.hrbb.loan.pos.dao.entity.TCreditApply)
	 */
	@Override
	public int updateBackToReview(TCreditApplyAprvInfo record) {
		// 取得补件发起的信息
		record = dao.selectLastOne(record);
		// 创建补件发起人的工作
		TCreditApply ca = new TCreditApply();
		ca.setLoanId(record.getLoanId());
		ca.setApplyStatus(record.getApprState());
		// 复审人员
		ca.setOperName(record.getApprvId());
		// 复审人员
		ca.setLastOperId(record.getApprvId());
		// 审批发起时间
		ca.setLastOperTime(new Date());
		// 根据申请状态设置权限，并更新相应操作人
		setPrivilege(ca);
		// 更新申请表的信贷复审人员
		int flag = daoCA.claim(ca);
		// 更新失败时返回
		if (flag != 1) {
			return flag;
		}
		TCreditApplyAprvInfo recordInsert = new TCreditApplyAprvInfo();
		// 业务编号
		recordInsert.setLoanId(record.getLoanId());
		// 复审人员
		recordInsert.setApprvId(record.getApprvId());
		// 申请状态
		recordInsert.setApprState(record.getApprState());
		// 批准金额
		recordInsert.setApprAmount(record.getApprAmount());
		// 批准利率
		recordInsert.setApprInte(record.getApprInte());
		// 审批发起时间
		recordInsert.setAppBeginTime(record.getAppBeginTime());
		// 登录前手人的任务池记录
		return dao.insertSelective(recordInsert);
	}

	/**
	 * 根据申请状态设置权限，并更新相应操作人
	 */
	private void setPrivilege(TCreditApply ca) {
		if (ReviewNoteConstants.APPLYSTATUS_CODE_10.equals(ca.getApplyStatus())) {
			ca.setPrivilege0(ReviewNoteConstants.ROLE_CODE_0);
		} else if (ReviewNoteConstants.APPLYSTATUS_CODE_20.equals(ca
				.getApplyStatus())
				|| ReviewNoteConstants.APPLYSTATUS_CODE_21.equals(ca
						.getApplyStatus())) {
			ca.setPrivilege1(ReviewNoteConstants.ROLE_CODE_1);
		} else if (ReviewNoteConstants.APPLYSTATUS_CODE_31.equals(ca
				.getApplyStatus())
				|| ReviewNoteConstants.APPLYSTATUS_CODE_33.equals(ca
						.getApplyStatus())
				|| ReviewNoteConstants.APPLYSTATUS_CODE_34.equals(ca
						.getApplyStatus())
				|| ReviewNoteConstants.APPLYSTATUS_CODE_35.equals(ca
						.getApplyStatus())
				|| ReviewNoteConstants.APPLYSTATUS_CODE_32.equals(ca
						.getApplyStatus())) {
			ca.setPrivilege2(ReviewNoteConstants.ROLE_CODE_2);
		} else if (ReviewNoteConstants.APPLYSTATUS_CODE_41.equals(ca
				.getApplyStatus())) {
			ca.setPrivilege3(ReviewNoteConstants.ROLE_CODE_3);
		}
	}

	/**
	 * ftp下载文件处理失败，重新发送消息
	 */
	@Override
	public int sendMsg(String loanId) {
		TCreditApplyAprvInfo record = new TCreditApplyAprvInfo();
		record.setLoanId(loanId);
		// 取得补件发起的信息
		record = dao.selectLastOne(record);
		// 查询最新申请状态
		TCreditApply caForNeed = daoCA.selectOne(loanId);

		NeedMoreEvidMessage nmem = new NeedMoreEvidMessage();
		nmem.setAddiSpec(ReviewNoteConstants.FTP_RESP_MSG_999).setAdditPhase(
				ReviewNoteConstants.MESSAGETYPE_NEEDMOREEVID_PREFIX);
		// 登录消息表，发送补件通知
		int flag = insertTMessage(ReviewNoteConstants.MESSAGETYPE_NEEDMOREEVID,
				nmem.toString(), record.getNeedInforCodes(), caForNeed);
		return flag;
	}

	/**
	 * 初审拒绝
	 * 
	 * @see com.hrbb.loan.pos.service.CreditApplyAprvInfoService#updateCreditApplyRefuse(com.hrbb.loan.pos.dao.entity.TCreditApplyAprvInfo)
	 */
	@Override
	public int updateCreditApplyRefuse(TCreditApplyAprvInfo record) {
		LOG.debug("updateCreditApplyRefuse begin");

		String loanId = record.getLoanId();
		String apprvId = record.getApprvId();
		String apprInfo = record.getApprInfo();
		String apprInfoExt = record.getApprInfoExt();
		String apprState = record.getApprState();
		LOG.debug("loanId=" + loanId);
		LOG.debug("apprvId=" + apprvId);
		LOG.debug("审批意见内部apprInfo=" + apprInfo);
		LOG.debug("审批意见外部apprInfoExt=" + apprInfoExt);

		// 20150728 guoyu 审批意见外部的内容从编号转变为内容
		String apprInfoExtMsg = tBusinessDictionaryDao
				.getApprInfoExtMsg(apprInfoExt);
		LOG.debug("审批意见外部内容apprInfoExtMsg=" + apprInfoExtMsg);

		LOG.debug("apprState=" + apprState);

		Date now = new Date();

		TCreditApply ca = new TCreditApply();
		ca.setLoanId(loanId);
		// 申请状态
		// 审核拒绝时
		if (ReviewNoteConstants.APPLYSTATUS_CODE_10.equals(apprState)) {
			// 直接拒绝
			ca.setApplyStatus(ReviewNoteConstants.APPLYSTATUS_CODE_91);
			// 模型拒绝时
		} else {
			ca.setApplyStatus(ReviewNoteConstants.APPLYSTATUS_CODE_92);
		}
		// 最后操作人
		ca.setLastOperId(apprvId);
		// 最后操作时间
		ca.setLastOperTime(now);

		// 更新申请状态
		int flag = daoCA.updateForReview(ca);
		LOG.debug("更新申请状态flag=" + flag);
		// 更新失败
		if (flag != 1) {
			return flag;
		}
		// 申请状态保存成功
		// 登录申请审批记录
		// 申请状态
		// record.setApprState(ReviewNoteConstants.APPLYSTATUS_CODE_92);
		record.setApprResult(ReviewNoteConstants.APPRRESULT_CODE_20);
		record.setAppBeginTime(now);
		record.setAppEndTime(now);
		// 拒绝代码
		record.setRefuseCode(ReviewNoteConstants.REFUSE_CODE_901);

		flag = dao.insertSelective(record);
		LOG.debug("登录申请审批flag=" + flag);
		// 更新失败
		if (flag != 1) {
			return flag;
		}
		// 更新成功
		// 查询申请信息查询
		TCreditApply caForAppr = daoCA.selectOne(record.getLoanId());

		ApproveRejectMessage arm = new ApproveRejectMessage();
		arm.setRefuseReason(apprInfoExtMsg);
		String nextLoanDate = DateUtil.getRelativeDate(new Date(), 0, 3, 0,
				"yyyyMMdd");
		arm.setNextLoanDate(nextLoanDate);
		LOG.debug("审批拒绝消息的messageinfo为" + arm);
		flag = insertTMessage(ReviewNoteConstants.MESSAGETYPE_REJECT,
				arm.toString(), null, caForAppr);

		LOG.debug("登录消息表flag=" + flag);
		// 更新失败
		if (flag != 1) {
			return flag;
		}
		// 申请状态
		// 模型拒绝时，生成外呼任务；受理审核拒绝时不生成外呼任务
		if (!ReviewNoteConstants.APPLYSTATUS_CODE_10.equals(apprState)) {
			// 生成外呼任务
			flag = insertCallingTask(
					ReviewNoteConstants.CALLING_TASK_CALLINGTYPE_11, loanId,
					ReviewNoteConstants.CALLING_TASK_RELABIZPHASE_APP,
					caForAppr, apprInfoExtMsg);
			LOG.debug("生成外呼任务flag=" + flag);
		}

		// 申请信息
		TCustomer c = tCustomerDao.selectByPrimaryKey(caForAppr.getCustId());
		if (c != null && StringUtil.isNotEmpty(c.getMobilePhone())) {
			// 拒绝短信入库
			flag = insertSmsMessage(c.getMobilePhone(), caForAppr.getChannel());
			LOG.debug("发送拒绝短信flag=" + flag);
		} else {
			LOG.error("没有客户信息或没有手机号！");
		}
		LOG.debug("updateCreditApplyRefuse end");
		return flag;
	}

	/**
	 * 风险初审-通过，插入审批记录
	 * 
	 * @param record
	 * @return
	 */
	@Override
	public int insertCreditApplyAprvInfo30(TCreditApplyAprvInfo record) {

		Date now = new Date();

		TCreditApply ca = new TCreditApply();
		ca.setLoanId(record.getLoanId());
		// 申请状态:风险复审
		ca.setApplyStatus(ReviewNoteConstants.APPLYSTATUS_CODE_31);
		// 最后操作人
		ca.setLastOperId(record.getApprvId());
		// 最后操作时间
		ca.setLastOperTime(now);
		// 更新申请状态
		int rezult = daoCA.updateByPrimaryKeySelective(ca);
		// 更新失败
		if (rezult != 1) {
			return rezult;
		}

		record.setApprState(ReviewNoteConstants.APPLYSTATUS_CODE_30);
		record.setApprResult(ReviewNoteConstants.APPRRESULT_CODE_10);
		record.setAppBeginTime(now);
		record.setAppEndTime(now);
		// 查询上次审批结果
		TCreditApplyAprvInfo aprvInfoLastOne = new TCreditApplyAprvInfo();
		aprvInfoLastOne.setLoanId(record.getLoanId());
		aprvInfoLastOne = dao.selectLastOne(aprvInfoLastOne);
		// 备注
		record.setRemark(aprvInfoLastOne.getRemark());
		// 插入申请批复表
		int flag = dao.insertSelective(record);
		if (flag == 1) {
			// 模型通过后，自动分配任务给风险复审1人员
			// 设置最新的申请状态
			record.setApprState(ca.getApplyStatus());
			try {
				flag = automaticAssignmentTask(record);
			} catch (Exception ex) {
				LOG.error("风险复审1 自动分配 失败!", ex);
			}
		}
		return flag;
	}

	/**
	 * 初审直接通过
	 * 
	 * @see com.hrbb.loan.pos.service.CreditApplyAprvInfoService#updateCreditApplyPass(com.hrbb.loan.pos.dao.entity.TCreditApplyAprvInfo)
	 */
	@Override
	public int updateCreditApplyPass(TCreditApplyAprvInfo record) {
		LOG.debug("updateCreditApplyPass begin");

		String loanId = record.getLoanId();
		String apprvId = record.getApprvId();
		BigDecimal amount = record.getApprAmount();
		BigDecimal apprInte = record.getApprInte();
		LOG.debug("loanId=" + loanId);
		LOG.debug("apprvId=" + apprvId);
		LOG.debug("amount=" + amount);
		LOG.debug("apprInte=" + apprInte);

		Date now = new Date();

		TCreditApply ca = new TCreditApply();
		ca.setLoanId(loanId);
		// 申请状态
		ca.setApplyStatus(ReviewNoteConstants.APPLYSTATUS_CODE_90);
		// 最后操作人
		ca.setLastOperId(apprvId);
		// 最后操作时间
		ca.setLastOperTime(now);

		// 更新申请状态
		int flag = daoCA.updateForReview(ca);
		LOG.debug("更新申请状态flag=" + flag);
		// 更新失败
		if (flag != 1) {
			return flag;
		}
		// 申请状态保存成功
		// 登录申请审批记录
		// 申请状态
		record.setApprState(ReviewNoteConstants.APPLYSTATUS_CODE_30);
		record.setApprResult(ReviewNoteConstants.APPRRESULT_CODE_10);
		record.setAppBeginTime(now);
		record.setAppEndTime(now);

		flag = dao.insertSelective(record);
		LOG.debug("登录申请审批flag=" + flag);
		// 更新失败
		if (flag != 1) {
			return flag;
		}
		// 查询申请信息查询
		TCreditApply caForAppr = daoCA.selectOne(record.getLoanId());
		// 授信批复信息
		TApproveResult ar = new TApproveResult();
		// 登录授信批复表
		flag = insertApproveResult(caForAppr, record, ar);
		// 更新失败
		if (flag != 1) {
			return flag;
		}
		// 登录成功
		ApprovePassMessage apm = new ApprovePassMessage();
		apm.setAppMaxCred(record.getApprAmount().toString())
				.setInterRate(
						record.getApprInte()
								.divide(new BigDecimal("100"), 4,
										BigDecimal.ROUND_HALF_UP).toString())
				.setApptTerm(caForAppr.getApplyTerm())
				.setApptTermUnit(caForAppr.getTermUnit());
		// 登录消息表，发送通知
		flag = insertTMessage(ReviewNoteConstants.MESSAGETYPE_APPROVE,
				apm.toString(), null, caForAppr);
		LOG.debug("登录消息表flag=" + flag);
		// 更新失败
		if (flag != 1) {
			return flag;
		}
		// 生成外呼任务
		flag = insertCallingTask(
				ReviewNoteConstants.CALLING_TASK_CALLINGTYPE_12,
				ar.getApproveId(),
				ReviewNoteConstants.CALLING_TASK_RELABIZPHASE_APR, caForAppr,
				null);
		LOG.debug("生成外呼任务flag=" + flag);
		LOG.debug("updateCreditApplyPass end");
		return flag;
	}

	/**
	 * 拒绝短信入库
	 * 
	 * @param loanid
	 */
	private int insertSmsMessage(String mobilePhone, String channel) {
		LOG.debug("发送短信mobilePhone=" + mobilePhone);
		// 获取短信模板
		TSmsTemplate smsTemplate = tSmsTemplateDao
				.selectByPrimaryKey(SmsTemplateFactory.getRefuseSms(channel));
		// 短信内容
		String sendContent = smsTemplate.getSmsContent();

		// 短信入库

		TSmsMessage message = new TSmsMessage();
		message.setMobile(mobilePhone);
		message.setSendContent(sendContent);
		message.setChannel(channel);
		message.setNotifyType(SmsTypeContants.审批拒绝);
		message.setCreateTime(new Date());
		message.setTempId(SmsTemplateFactory.getRefuseSms(channel));
		sendSmsMessageService.sendSmsMessage(message);
		return 1;
	}

	/**
	 * 上签
	 * 
	 * @see com.hrbb.loan.pos.service.CreditApplyAprvInfoService#updateCreditApplyForUpSign(com.hrbb.loan.pos.dao.entity.TCreditApplyAprvInfo)
	 */
	@Override
	public Map<String, Object> updateCreditApplyForUpSign(
			TCreditApplyAprvInfo record) {

		TCreditApply ca = new TCreditApply();
		ca.setLoanId(record.getLoanId());
		String step = null;
		// 申请状态
		// 风险复审2->3
		if (ReviewNoteConstants.APPLYSTATUS_CODE_33.equals(record
				.getApprState())) {
			ca.setApplyStatus(ReviewNoteConstants.APPLYSTATUS_CODE_34);
			step = "3";
			// 风险复审3->4
		} else if (ReviewNoteConstants.APPLYSTATUS_CODE_34.equals(record
				.getApprState())) {
			ca.setApplyStatus(ReviewNoteConstants.APPLYSTATUS_CODE_35);
			step = "4";
			// 风险复审1->2
		} else {
			ca.setApplyStatus(ReviewNoteConstants.APPLYSTATUS_CODE_33);
			step = "2";
		}
		// 最后操作人
		ca.setLastOperId(record.getApprvId());
		// 最后操作时间
		ca.setLastOperTime(record.getAppEndTime());
		// 更新申请状态
		int flag = daoCA.updateForReview(ca);
		// 保存成功
		if (flag == 1) {
			// 更新申请审批记录表
			flag = dao.updateByPrimaryKeySelective(record);
			// 申请的最终状态保存，以便后面查询状态名
			record.setApprState(ca.getApplyStatus());
		}
		if (flag == 1) {
			// 如果有复审组，则退给指定上签人
			Map<String, Object> reqMap = Maps.newHashMap();
			reqMap.put("userId", record.getApprvId());
			reqMap.put("step", step);
			reqMap.put("status", "0");
			/*Map<String, Object> resMap = tUserGroupDao.selectGroupChief(reqMap);
			if (resMap != null) {
				LOG.info(record.getApprvId() + "该用户有复审小组, 小组chief为" + resMap.get("userName"));
				
				flag = automaticGroupTask(record, (String)resMap.get("userName"));
			} else {*/
				// 自动分配任务给风险复审人员
				flag = automaticAssignmentTask(record);

			/*}*/
		}
		Map<String, Object> respMap = Maps.newHashMap();
		respMap.put("flag", flag);
		respMap.put("record", record);
		return respMap;
	}

	private int automaticGroupTask(TCreditApplyAprvInfo record,
			String aprvId) {
		if (record == null) {
			LOG.info("入参 record 为空");
			return 0;
		}

		if (aprvId == null) {
			LOG.info("入参 aprvId 为空");
			return 0;
		}

		TCreditApplyAprvInfo aprvInfoInsert = new TCreditApplyAprvInfo();
		// 查询上次审批结果
		TCreditApplyAprvInfo aprvInfoLastOne = dao.selectLastSubbmitted(record);
		// 批准金额
		aprvInfoInsert.setApprAmount(aprvInfoLastOne.getApprAmount());
		// 批准利率
		aprvInfoInsert.setApprInte(aprvInfoLastOne.getApprInte());
		// 还款方式
		aprvInfoInsert.setRetuKind(aprvInfoLastOne.getRetuKind());
		// 审批意见
		aprvInfoInsert.setApprResult(aprvInfoLastOne.getApprResult());
		// 通过码
		aprvInfoInsert.setPassCode(aprvInfoLastOne.getPassCode());
		// 拒绝码
		aprvInfoInsert.setRefuseCode(aprvInfoLastOne.getRefuseCode());
		// 审批意见内部
		aprvInfoInsert.setApprInfo(aprvInfoLastOne.getApprInfo());
		// 审批意见外部
		aprvInfoInsert.setApprInfoExt(aprvInfoLastOne.getApprInfoExt());
		// 备注
		aprvInfoInsert.setRemark(aprvInfoLastOne.getRemark());

		aprvInfoInsert.setApprvId(aprvId);
		LOG.debug("待分配人员ID:ApprvId=" + aprvInfoInsert.getApprvId());
		// 没有可以分配 的人
		if (aprvInfoInsert.getApprvId() == null) {
			LOG.info("没有可以分配 的人，不分配。");
			LOG.debug("automaticAssignmentTask end");
			return 1;
		}
		// 登录申请审批记录
		int flag = dao.insertSelective(aprvInfoInsert);

		if (flag == 1) {
			TCreditApply ca = new TCreditApply();
			ca.setLoanId(aprvInfoInsert.getLoanId());
			// 复审人员
			ca.setOperName(aprvInfoInsert.getApprvId());
			// 复审人员
			ca.setLastOperId(aprvInfoInsert.getApprvId());
			// 审批发起时间
			ca.setLastOperTime(aprvInfoInsert.getAppBeginTime());
			// 根据申请状态设置权限，并更新相应操作人
			// 受理状态提交到资料审核
			if (ReviewNoteConstants.APPLYSTATUS_CODE_20.equals(aprvInfoInsert
					.getApprState())) {
				ca.setPrivilege1(ReviewNoteConstants.ROLE_CODE_1);
				// 复审
			} else {
				ca.setPrivilege2(ReviewNoteConstants.ROLE_CODE_2);
			}
			// 更新申请状态
			flag = daoCA.claim(ca);
		}
		LOG.debug("automaticAssignmentTask end");

		return 0;
	}

	/**
	 * 更新审批记录
	 * 
	 * @see com.hrbb.loan.pos.service.CreditApplyAprvInfoService#updateCreditApplyAprv(java.util.Map)
	 */
	@Override
	public int updateCreditApplyAprv(Map<String, Object> reqMap) {
		return dao.updateCreditApplyAprvInfoBySelective(reqMap);
	}

    
    // 从复审人员字符串(可能包含多个复审人员,逗号分隔)中选出当前任务最少的复审人员
 public String getApproveId(String reviewPerson, String applyStatus) {
     String[] a = reviewPerson.split(",");
     if (a.length > 1) {
         List<String> apprIdList = Arrays.asList(a);
         LOG.debug("该规则对应的复审人员有多个");
         Map<String, Object> map = Maps.newHashMap();
         map.put("idList", apprIdList);
         map.put("applystatus", applyStatus);
         List<String> ls = dao.getReviewPersons2(map);
         LOG.debug("选出符合复审分件规则的复审人员名单有" + ls.size() + "个");
         String apprId = dao.getApprIdFromList(ls);
         // String apprId = dao.getApprIdByRuleAndLessWork(apprIdList);
         LOG.debug("分配人员ID" + apprId);
         return apprId;
     } else {
         LOG.debug("该规则只有一个复审人员");
         return a[0];
     }
 }

    
    
 public String getApproveIdByRecord(TCreditApplyAprvInfo record){
     TCreditApply caTemp = daoCA.selectOne(record.getLoanId());
     TPosCustInfo tPosCustInfo = tPosCustInfoDao.selectByPrimaryKey(caTemp.getPosCustId());
     LOG.debug("该笔申请信息的商户地址为" + tPosCustInfo.getPosCustAddress());
     LOG.debug("该笔申请信息的商户名为" + tPosCustInfo.getPosCustName());       
     LOG.debug("该笔申请信息的区域为" + caTemp.getRegion());
     LOG.debug("该笔申请信息的渠道为" + caTemp.getRecOrg());
     LOG.debug("该笔申请信息的行业为" + tPosCustInfo.getIndustryTypeId2());
     String s1="市场";
     String s2="区域";
     String s3="渠道";
     String s4="行业";
     String str1 = "%"+tPosCustInfo.getPosCustAddress()+"%";
     Map<String, Object> map1 = Maps.newHashMap();
     map1.put("rulecontent", str1);
     map1.put("ruletype",s1);
     String str2 = "%"+tPosCustInfo.getPosCustName()+"%";
     Map<String, Object> map2 = Maps.newHashMap();
     map2.put("rulecontent", str2);
     map2.put("ruletype",s1);
     String str3 = "%"+caTemp.getRegion()+"%";
     Map<String, Object> map3 = Maps.newHashMap();
     map3.put("rulecontent", str3);
     map3.put("ruletype",s2);
     String str4 = "%"+caTemp.getRecOrg()+"%";
     Map<String, Object> map4 = Maps.newHashMap();
     map4.put("rulecontent", str4);
     map4.put("ruletype",s3);
     String str5 = "%"+tPosCustInfo.getIndustryTypeId2()+"%";
     Map<String, Object> map5 = Maps.newHashMap();
     map5.put("rulecontent", str5);
     map5.put("ruletype",s4);
     LOG.debug("根据商户地址查询复审分件规则表");
     String reviewPersons1= tReviewAssignTaskDao.getReviewPersonByRule(map1);
     LOG.debug("根据商户名查询复审分件规则表");
     String reviewPersons2= tReviewAssignTaskDao.getReviewPersonByRule(map2);
     LOG.debug("根据区域查询复审分件规则表");
     String reviewPersons3= tReviewAssignTaskDao.getReviewPersonByRule(map3);
     LOG.debug("根据渠道查询复审分件规则表");
     String reviewPersons4= tReviewAssignTaskDao.getReviewPersonByRule(map4);
     LOG.debug("根据行业查询复审分件规则表");
     String reviewPersons5= tReviewAssignTaskDao.getReviewPersonByRule(map5);
     String approveId=null;
     if(reviewPersons4!=null){
         //复审分件规则表区域-------渠道选择复审人员
         LOG.debug("渠道选择复审人员");
         approveId = getApproveId(reviewPersons4,record.getApprState());
     }else if(reviewPersons1!=null){
         //复审分件规则表区域-------商户地址选择复审人员
         LOG.debug("商户地址选择复审人员");
         approveId = getApproveId(reviewPersons1,record.getApprState());
     }
     else if(reviewPersons2!=null){
         //复审分件规则表区域-------商户名选择复审人员
         LOG.debug("商户名选择复审人员");
         approveId = getApproveId(reviewPersons2,record.getApprState());
     }else if(reviewPersons3!=null){
         //复审分件规则表区域-------区域选择复审人员
         LOG.debug("区域选择复审人员");
         approveId = getApproveId(reviewPersons3,record.getApprState());
     }else if(reviewPersons5!=null){
         //复审分件规则表区域-------行业选择复审人员
         LOG.debug("行业选择复审人员");
         approveId = getApproveId(reviewPersons5,record.getApprState());
     }
     return approveId;
 }
 
 /**
  * 自动分配任务，派发申请
  * 
  * @param record
  *            (必输项：LoanId,ApprState)
  * 
  * @return
  */
 @Override
 public int automaticAssignmentTask(TCreditApplyAprvInfo record) {
     LOG.debug("automaticAssignmentTask begin");
     TCreditApplyAprvInfo aprvInfoInsert = new TCreditApplyAprvInfo();
     // 业务编号
     aprvInfoInsert.setLoanId(record.getLoanId());
     // 审批发起时间
     aprvInfoInsert.setAppBeginTime(new Date());

     LOG.debug("LoanId=" + aprvInfoInsert.getLoanId());
     LOG.debug("ApprState=" + record.getApprState());
     TCreditApply caTemp = daoCA.selectOne(record.getLoanId());
     String ApprvId = null;

     // 申请状态
     aprvInfoInsert.setApprState(record.getApprState());
     // 任务最少的人的ID没有时的处理
     // 用户ID是主表，当前任务数是字表
     // 受理状态提交到资料审核
     if (ReviewNoteConstants.APPLYSTATUS_CODE_20.equals(record
             .getApprState())) {
         // 查询备注
         // 备注
         aprvInfoInsert.setRemark(caTemp.getRemark());
         String occurType = caTemp.getOccurType();
         LOG.debug("申请状态为" + record.getApprState());
         if ("02".equals(occurType)) {
             aprvInfoInsert.setApprvId(辜小亮);// 续贷申请在初审通过后，针对模型建议通过的申请，派发给辜小亮
         } else {
//             List<String> ls = dao.getReviewPersons("10");
//             LOG.debug("资料审核权限的复审人员名单有" + ls.size() + "个");
//             ApprvId = getApproveIdByRecord(record);
//             if (ApprvId != null) {
//                 LOG.debug("复审分件规则中找到的复审人员为" + ApprvId);
//                 aprvInfoInsert.setApprvId(ApprvId);
//             } else {
//                 LOG.debug("复审分件规则中没有找到满足条件的复审人员");
//                 aprvInfoInsert.setApprvId(dao.getApprIdFromList(ls));
//             }

             // 取得10资料审核权限任务最少的人的ID
              aprvInfoInsert.setApprvId(dao.getApprIdByLessWork("10"));
         }
         // 复审1状态时，自动带出上次提交的信息
     } else if (ReviewNoteConstants.APPLYSTATUS_CODE_31.equals(record
             .getApprState())) {
         LOG.debug("申请状态为" + record.getApprState());
         List<String> ls = dao.getReviewPersons("12");
         LOG.debug("风险复审1权限的复审人员名单为" +ls);
         ApprvId = getApproveIdByRecord(record);
         if (ApprvId != null) {
             LOG.debug("复审分件规则中找到的复审人员为" + ApprvId);
             aprvInfoInsert.setApprvId(ApprvId);
         } else {
             LOG.debug("复审分件规则中没有找到满足条件的复审人员");
             aprvInfoInsert.setApprvId(dao.getApprIdFromList(ls));
         }
         // 取得风险复审1审核权限任务最少的人的ID
         // aprvInfoInsert.setApprvId(dao.getApprIdByLessWork("12"));

         // 查询上次
         TCreditApplyAprvInfo aprvInfoLastOne = dao
                 .selectLastSubbmitted(record);
         // 批准金额
         aprvInfoInsert.setApprAmount(aprvInfoLastOne.getApprAmount());
         // 批准利率
         aprvInfoInsert.setApprInte(aprvInfoLastOne.getApprInte());
         // 备注
         aprvInfoInsert.setRemark(aprvInfoLastOne.getRemark());

         // 查询还款方式
         // 还款方式
         aprvInfoInsert.setRetuKind(caTemp.getReturnKind());
         // 复审2,3,4状态时，自动带出上次提交的信息
     } else if (ReviewNoteConstants.APPLYSTATUS_CODE_33.equals(record
             .getApprState())
             || ReviewNoteConstants.APPLYSTATUS_CODE_34.equals(record
                     .getApprState())
             || ReviewNoteConstants.APPLYSTATUS_CODE_35.equals(record
                     .getApprState())) {
         if (ReviewNoteConstants.APPLYSTATUS_CODE_33.equals(record
                 .getApprState())) {
             LOG.debug("申请状态为" + record.getApprState());
//             List<String> ls = dao.getReviewPersons("13");
//             LOG.debug("风险复审2权限的复审人员名单有" + ls.size() + "个");
//             ApprvId = getApproveIdByRecord(record);
//             if (ApprvId != null) {
//                 LOG.debug("复审分件规则中找到的复审人员为" + ApprvId);
//                 aprvInfoInsert.setApprvId(ApprvId);
//             } else {
//                 LOG.debug("复审分件规则中没有找到满足条件的复审人员");
//                 aprvInfoInsert.setApprvId(dao.getApprIdFromList(ls));
//             }
             // 取得风险复审2审核权限任务最少的人的ID
              aprvInfoInsert.setApprvId(dao.getApprIdByLessWork("13"));
         } else if (ReviewNoteConstants.APPLYSTATUS_CODE_34.equals(record
                 .getApprState())) {
             LOG.debug("申请状态为" + record.getApprState());
//             List<String> ls = dao.getReviewPersons("14");
//             LOG.debug("风险复审3权限的复审人员名单有" + ls.size() + "个");
//             ApprvId = getApproveIdByRecord(record);
//             if (ApprvId != null) {
//                 LOG.debug("复审分件规则中找到的复审人员为" + ApprvId);
//                 aprvInfoInsert.setApprvId(ApprvId);
//             } else {
//                 LOG.debug("复审分件规则中没有找到满足条件的复审人员");
//                 aprvInfoInsert.setApprvId(dao.getApprIdFromList(ls));
//             }
             // 取得风险复审3审核权限任务最少的人的ID
              aprvInfoInsert.setApprvId(dao.getApprIdByLessWork("14"));
         } else {
             LOG.debug("申请状态为" + record.getApprState());
//             List<String> ls = dao.getReviewPersons("41");
//             LOG.debug("风险复审4权限的复审人员名单有" + ls.size() + "个");
//             ApprvId = getApproveIdByRecord(record);
//             if (ApprvId != null) {
//                 LOG.debug("复审分件规则中找到的复审人员为" + ApprvId);
//                 aprvInfoInsert.setApprvId(ApprvId);
//             } else {
//                 LOG.debug("复审分件规则中没有找到满足条件的复审人员");
//                 aprvInfoInsert.setApprvId(dao.getApprIdFromList(ls));
//             }
             // 取得风险复审4审核权限任务最少的人的ID
              aprvInfoInsert.setApprvId(dao.getApprIdByLessWork("41"));
         }
         // 查询上次审批结果
         TCreditApplyAprvInfo aprvInfoLastOne = dao
                 .selectLastSubbmitted(record);
         // 批准金额
         aprvInfoInsert.setApprAmount(aprvInfoLastOne.getApprAmount());
         // 批准利率
         aprvInfoInsert.setApprInte(aprvInfoLastOne.getApprInte());
         // 还款方式
         aprvInfoInsert.setRetuKind(aprvInfoLastOne.getRetuKind());
         // 审批意见
         aprvInfoInsert.setApprResult(aprvInfoLastOne.getApprResult());
         // 通过码
         aprvInfoInsert.setPassCode(aprvInfoLastOne.getPassCode());
         // 拒绝码
         aprvInfoInsert.setRefuseCode(aprvInfoLastOne.getRefuseCode());
         // 审批意见内部
         aprvInfoInsert.setApprInfo(aprvInfoLastOne.getApprInfo());
         // 审批意见外部
         aprvInfoInsert.setApprInfoExt(aprvInfoLastOne.getApprInfoExt());
         // 备注
         aprvInfoInsert.setRemark(aprvInfoLastOne.getRemark());
     } else {
         LOG.info("其他状态不应该自动非配任务！");
         LOG.debug("automaticAssignmentTask end");
         return 0;
     }
     LOG.debug("待分配人员ID:ApprvId=" + aprvInfoInsert.getApprvId());
     // 没有可以分配 的人
     if (aprvInfoInsert.getApprvId() == null) {
         LOG.info("没有可以分配 的人，不分配。");
         LOG.debug("automaticAssignmentTask end");
         return 1;
     }
     // 登录申请审批记录
     int flag = dao.insertSelective(aprvInfoInsert);

     if (flag == 1) {
         TCreditApply ca = new TCreditApply();
         ca.setLoanId(aprvInfoInsert.getLoanId());
         // 复审人员
         ca.setOperName(aprvInfoInsert.getApprvId());
         // 复审人员
         ca.setLastOperId(aprvInfoInsert.getApprvId());
         // 审批发起时间
         ca.setLastOperTime(aprvInfoInsert.getAppBeginTime());
         // 根据申请状态设置权限，并更新相应操作人
         // 受理状态提交到资料审核
         if (ReviewNoteConstants.APPLYSTATUS_CODE_20.equals(aprvInfoInsert
                 .getApprState())) {
             ca.setPrivilege1(ReviewNoteConstants.ROLE_CODE_1);
             // 复审
         } else {
             ca.setPrivilege2(ReviewNoteConstants.ROLE_CODE_2);
         }
         // 更新申请状态
         flag = daoCA.claim(ca);
     }
     LOG.debug("automaticAssignmentTask end");
     return flag;
 }


	/**
	 * 资金池模型-资料审核通过
	 * 
	 * @see com.hrbb.loan.pos.service.CreditApplyAprvInfoService#updateCreditApplyForCashPooling(com.hrbb.loan.pos.dao.entity.TCreditApplyAprvInfo)
	 */
	@Override
	public Map<String, Object> updateCreditApplyForCashPooling(
			TCreditApplyAprvInfo record, Map<String, Object> resultMap) {
		TCreditApply ca = new TCreditApply();
		ca.setLoanId(record.getLoanId());
		// 申请状态
		ca.setApplyStatus(ReviewNoteConstants.APPLYSTATUS_CODE_60);
		// 最后操作人
		ca.setLastOperId(record.getApprvId());
		// 最后操作时间
		ca.setLastOperTime(record.getAppEndTime());
		// 更新申请状态
		int flag = daoCA.updateForReview(ca);
		// 保存成功
		if (flag == 1) {
			// 更新申请审批记录表
			flag = dao.updateByPrimaryKeySelective(record);
			// 申请的最终状态保存，以便后面查询状态名
			record.setApprState(ca.getApplyStatus());
		}
		// 保存成功
		if (flag == 1) {
			CreditReportDownloadMessage crdm = new CreditReportDownloadMessage();
			crdm.setLoanid(record.getLoanId());
			crdm.setFilepackagename(resultMap.get("zipFileName").toString());
			crdm.setKey(resultMap.get("zipFilePwd").toString());
			// 查询申请信息查询
			TCreditApply caForAppr = daoCA.selectOne(record.getLoanId());
			// 登录消息表，发送通知
			flag = insertTMessage("14", crdm.toString(), null, caForAppr);
			LOG.debug("登录消息表flag=" + flag);
		}
		Map<String, Object> respMap = Maps.newHashMap();
		respMap.put("flag", flag);
		respMap.put("record", record);
		return respMap;
	}

	/**
	 * 资金池模式-申请通过
	 * 
	 * @see com.hrbb.loan.pos.service.CreditApplyAprvInfoService#updateCreditApplyPass(com.hrbb.loan.pos.dao.entity.TCreditApplyAprvInfo)
	 */
	@Override
	public int updateCreditApplyPassForCP(TCreditApplyAprvInfo record,
			TApproveResult ar) {
		LOG.debug("updateCreditApplyPassForCP begin");
		LOG.debug("批复结果为" + ar);
		String loanId = record.getLoanId();
		String apprvId = record.getApprvId();
		BigDecimal amount = record.getApprAmount();
		BigDecimal apprInte = record.getApprInte();
		LOG.debug("loanId=" + loanId);
		LOG.debug("apprvId=" + apprvId);
		LOG.debug("amount=" + amount);
		LOG.debug("apprInte=" + apprInte);

		TCreditApply ca = new TCreditApply();
		ca.setLoanId(loanId);
		// 申请状态
		ca.setApplyStatus(ReviewNoteConstants.APPLYSTATUS_CODE_90);
		// 最后操作人
		ca.setLastOperId(apprvId);
		// 最后操作时间
		ca.setLastOperTime(record.getAppEndTime());

		// 更新申请状态
		int flag = daoCA.updateForReview(ca);
		LOG.debug("更新申请状态flag=" + flag);
		// 更新失败
		if (flag != 1) {
			return flag;
		}
		// 申请状态保存成功
		// 登录申请审批记录
		// 申请状态
		record.setApprState(ReviewNoteConstants.APPLYSTATUS_CODE_60);
		record.setApprResult(ReviewNoteConstants.APPRRESULT_CODE_10);

		flag = dao.insertSelective(record);
		LOG.debug("登录申请审批flag=" + flag);
		// 更新失败
		if (flag != 1) {
			return flag;
		}
		// 查询申请信息查询
		TCreditApply caForAppr = daoCA.selectOne(record.getLoanId());
		LOG.debug("申请信息结果为" + caForAppr);

		TApproveResult approveResult = daoAR.selectByLoanId(record.getLoanId());
		LOG.debug("批复结果信息为" + approveResult);
		if (approveResult == null) {
			// 登录授信批复表
			flag = insertApproveResult(caForAppr, record, ar);
			LOG.debug("插入批复信息成功");
		} else {
			// 更新批复表
			// 批复编号
			ar.setApproveId(approveResult.getApproveId());
			// 业务来源
			ar.setBusinessSource(caForAppr.getChannel());
			// 申请编号
			ar.setLoanId(caForAppr.getLoanId());
			// 客户编号
			ar.setCustId(caForAppr.getCustId());
			// 客户名称
			ar.setCustName(caForAppr.getCustName());
			// 商户id
			ar.setPosCustId(caForAppr.getPosCustId());
			// 商户名称
			ar.setPosCustName(caForAppr.getPosCustName());
			// 申请提交日期
			ar.setApplyCommitDate(caForAppr.getBeginDate());
			// 申请金额
			ar.setApplyAmt(caForAppr.getApplyAmt());
			// 申请币种
			ar.setApplyMoneyKind(caForAppr.getCurrSign());
			// 申请期限单位
			ar.setTermUnit(caForAppr.getTermUnit());
			// 申请期限
			ar.setApplyTerm(caForAppr.getApplyTerm());
			// 批复日期
			ar.setApproveDate(record.getAppEndTime());
			// 批复失效日期
			// Calendar cal = Calendar.getInstance();
			// cal.setTime(ar.getApproveDate());
			// cal.add(Calendar.DATE, 7);
			// ar.setExpiryDate(cal.getTime());
			// 批复金额
			ar.setApproveAmount(record.getApprAmount());
			// 批复币种
			ar.setApproveMoneyKind(caForAppr.getCurrSign());
			// 批复利率
			ar.setApproveInterest(record.getApprInte());
			// 批复期限单位
			ar.setApproveTermUnit(caForAppr.getTermUnit());
			// 批复期限
			ar.setApproveTerm(caForAppr.getApplyTerm());
			// 还款方式
			// ar.setPaybackMethod(record.getRetuKind());
			// 收款账号
			ar.setAcceptAccount(caForAppr.getBankAccno());
			// 账户信息查询
			TBankAccnoInfo ba = daoBA.selectByPrimaryKey(caForAppr
					.getBankAccno());
			LOG.debug("银行账户信息为" + ba);
			// 账户开户行
			ar.setAccountOpenBank(ba.getBankName());
			// 账户分行
			ar.setAccountBranchBank(ba.getBankBranName());
			// 账户支行
			ar.setAccountSubBranchBank(ba.getBankSubbName());
			// 产品编号
			ar.setProductId(caForAppr.getProdId());
			// 批复状态
			// 资金池模式为02已确认
			if (ReviewNoteConstants.LOANTYPE_02.equals(caForAppr.getLoanType())) {
				ar.setApproveStatus(ReviewNoteConstants.APPROVE_STATUS_CODE_02);
				// 还款方式
				ar.setPaybackMethod("90");
				// 批复失效日期
				// 在调用的地方应该已经设置好了
			} else {
				// 还款方式
				ar.setPaybackMethod(record.getRetuKind());
				// 批复失效日期
				Calendar cal = Calendar.getInstance();
				cal.setTime(ar.getApproveDate());
				cal.add(Calendar.DATE, 7);
				ar.setExpiryDate(cal.getTime());
				// 批复状态
				ar.setApproveStatus(ReviewNoteConstants.APPROVE_STATUS_CODE_01);
			}
			// 申请流水号（银联商务）
			ar.setStdshno(caForAppr.getStdshno());
			// 偿还方式
			ar.setLoanPaybackWay(caForAppr.getRepayMethod());

			int a = daoAR.updateByApproveId(ar);

		}

		LOG.debug("updateCreditApplyPassForCP end");
		return flag;
	}

	/**
	 * 资金池模式-申请拒绝
	 * 
	 * @see com.hrbb.loan.pos.service.CreditApplyAprvInfoService#updateCreditApplyRefuse(com.hrbb.loan.pos.dao.entity.TCreditApplyAprvInfo)
	 */
	@Override
	public int updateCreditApplyRefuseForCP(TCreditApplyAprvInfo record) {
		LOG.debug("updateCreditApplyRefuseForCP begin");

		String loanId = record.getLoanId();
		String apprvId = record.getApprvId();
		String apprInfo = record.getApprInfo();
		String apprState = record.getApprState();
		LOG.debug("loanId=" + loanId);
		LOG.debug("apprvId=" + apprvId);
		LOG.debug("审批意见内部apprInfo=" + apprInfo);
		LOG.debug("apprState=" + apprState);

		TCreditApply ca = new TCreditApply();
		ca.setLoanId(loanId);
		// 申请状态
		ca.setApplyStatus(ReviewNoteConstants.APPLYSTATUS_CODE_92);
		// 最后操作人
		ca.setLastOperId(apprvId);
		// 最后操作时间
		ca.setLastOperTime(record.getAppEndTime());

		// 更新申请状态
		int flag = daoCA.updateForReview(ca);
		LOG.debug("更新申请状态flag=" + flag);
		// 更新失败
		if (flag != 1) {
			return flag;
		}
		// 申请状态保存成功
		// 登录申请审批记录
		// 申请状态
		record.setApprState(ReviewNoteConstants.APPLYSTATUS_CODE_60);
		record.setApprResult(ReviewNoteConstants.APPRRESULT_CODE_20);
		flag = dao.insertSelective(record);
		LOG.debug("登录申请审批flag=" + flag);
		LOG.debug("updateCreditApplyRefuseForCP end");
		return flag;
	}

	public List<String> getLoanIdsByDate(String timeout) {
		return dao.selectByApprvBeginTime(timeout);
	}

	/**
	 * 
	 * @see com.hrbb.loan.pos.service.CreditApplyAprvInfoService#adjustApprovalInfo(java.lang.String, java.lang.String, java.lang.String)
	 */
    @Override
    public int adjustApprovalInfo(String loanId, String applyStatus, String userName) {
        LOG.debug("adjustApprovalInfo begin");
        int flag = 0;
        try{
           TCreditApply applyInfo = daoCA.selectOne(loanId);
           Map<String, Object> map = Maps.newHashMap();
           map.put("loanId", loanId);
           map.put("applyStatus", applyStatus);
           map.put("creditRecheckPerson", userName);
           flag = daoCA.updateByPrimaryKeySelectiveMap(map);
           if(flag != 1){
               LOG.debug("update TCreditApplyInfo fail");
               return flag;
           }
           TCreditApplyAprvInfo aprv = new TCreditApplyAprvInfo();
           TCreditApplyAprvInfo aprvInfo;
           aprv.setLoanId(loanId);
           aprvInfo = dao.selectExecutor(aprv);
           if(aprvInfo != null && !StringUtils.isEmpty(aprvInfo.getLoanId())){
               map = Maps.newHashMap();
               map.put("loanId", loanId);
               map.put("apprvId", userName);
               map.put("apprState", applyStatus);
               flag = dao.updateCreditApplyAprvInfoBySelective(map);
           }else{
               aprvInfo = new TCreditApplyAprvInfo();
               TCreditApplyAprvInfo aprvInfoLastOne = dao.selectLastOne(aprv);
               aprvInfo.setLoanId(loanId);
               // 还款方式
               aprvInfo.setRetuKind(aprvInfoLastOne.getRetuKind());
               if(StringUtils.isEmpty(aprvInfo.getRetuKind())){
                   aprvInfo.setRetuKind(applyInfo.getReturnKind());
               }
               // 审批结果
               aprvInfo.setApprResult(aprvInfoLastOne.getApprResult());
               //审批阶段
               aprvInfo.setApprState(applyStatus);
               // 通过码
               aprvInfo.setPassCode(aprvInfoLastOne.getPassCode());
               // 拒绝码
               aprvInfo.setRefuseCode(aprvInfoLastOne.getRefuseCode());
               // 审批意见内部
               aprvInfo.setApprInfo(aprvInfoLastOne.getApprInfo());
               // 审批意见外部
               aprvInfo.setApprInfoExt(aprvInfoLastOne.getApprInfoExt());
               //审批人
               aprvInfo.setApprvId(userName);
               aprvInfo.setAppBeginTime(new Date());
               aprvInfo.setApprAmount(aprvInfoLastOne.getApprAmount());
               aprvInfo.setApprInte(aprvInfoLastOne.getApprInte());
               aprvInfo.setRemark(aprvInfoLastOne.getRemark());
               flag = dao.insertSelective(aprvInfo);
           }
        }catch(Exception e){
           LOG.error("复审调件失败：" + loanId, e);
           throw new RuntimeException("复审调件失败", e);
        }
        LOG.debug("adjustApprovalInfo end");
        return flag;
    }
}
