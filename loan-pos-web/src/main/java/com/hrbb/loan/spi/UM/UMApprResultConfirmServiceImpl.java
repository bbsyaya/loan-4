/**
 * 
 *	哈尔滨银行
 * Copyright (c) 2007-2015 HRBB,Inc.All Rights Reserved.
 */
package com.hrbb.loan.spi.UM;

import java.util.Date;
import java.util.Map;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Service;

import com.google.common.collect.Maps;
import com.hrbb.loan.pos.biz.backstage.inter.LoanPosContractManagementBiz;
import com.hrbb.loan.pos.dao.TApproveResultDao;
import com.hrbb.loan.pos.dao.TCreditApplyForReviewDao;
import com.hrbb.loan.pos.dao.entity.TApproveResult;
import com.hrbb.loan.pos.dao.entity.TCallingTask;
import com.hrbb.loan.pos.dao.entity.TCreditApply;
import com.hrbb.loan.pos.service.CallingTaskService;
import com.hrbb.loan.pos.util.IdUtil;
import com.hrbb.loan.pos.util.StringUtil;
import com.hrbb.loan.pos.util.constants.ReviewNoteConstants;
import com.hrbb.loan.spiconstants.HServiceReturnCode;
import com.hrbb.loan.spiconstants.PaymentApplyHServiceConstants;
import com.hrbb.sh.framework.HRequest;
import com.hrbb.sh.framework.HResponse;
import com.hrbb.sh.framework.HService;
import com.hrbb.sh.framework.HServiceException;

/**
 * 线上审批结果确认反馈HB05
 * 
 * @author marco
 * @version $Id: UMApprResultConfirmServiceImpl.java, v 0.1 2015-6-3 下午5:47:06
 *          marco Exp $
 */
@Service("umApprResultConfirm")
public class UMApprResultConfirmServiceImpl implements HService {

	private final Logger logger = LoggerFactory
			.getLogger(UMApprResultConfirmServiceImpl.class);

	@Autowired
	@Qualifier("tCreditApplyForReviewDao")
	private TCreditApplyForReviewDao daoCA;

	@Autowired
	@Qualifier("tApproveResultDao")
	private TApproveResultDao daoAR;

	@Autowired
	@Qualifier("CallingTaskService")
	private CallingTaskService service;

	@Autowired
	private LoanPosContractManagementBiz loanPosContractManagementBiz;

	/**
	 * @see com.hrbb.sh.framework.HService#serve(com.hrbb.sh.framework.HRequest)
	 */
	@Override
	public HResponse serve(HRequest request) throws HServiceException {

		logger.debug("executing UMApprResultConfirmServiceImpl...");

		Map<String, Object> props = request.getProperties();
		// 申请流水号
		String loanid = (String) props
				.get(PaymentApplyHServiceConstants.loanid);
		logger.debug("loanid=" + loanid);
		// 取得申请信息
		TCreditApply ca = daoCA.selectOne(loanid);

		HResponse response = new HResponse();
		response.setRespTime(new Date());

		// 申请信息不存在
		if (ca == null) {
			logger.debug("申请信息不存在");
			response.setRespCode(HServiceReturnCode.LOANID_EXIST_ERROR
					.getReturnCode());
			response.setRespMessage(HServiceReturnCode.LOANID_EXIST_ERROR
					.getReturnMessage());
			logger.debug("UMApprResultConfirmServiceImpl end");
			return response;
		}
		logger.debug("申请信息存在");

		// 获得申请审批表中的批准信息
		TApproveResult approve = daoAR.selectByLoanId(loanid);
		if (approve == null || StringUtil.isEmpty(approve.getApproveId())) {
			logger.debug("批准信息不存在ApproveId is null");
			response.setRespCode(HServiceReturnCode.APPROVEID_EXIST_ERROR
					.getReturnCode());
			response.setRespMessage(HServiceReturnCode.APPROVEID_EXIST_ERROR
					.getReturnMessage());
			logger.debug("UMApprResultConfirmServiceImpl end");
			return response;
		} else {
			logger.debug("批准信息存在ApproveId=" + approve.getApproveId());
		}
		// 是否接受0:是;1:否
		String isaccept = (String) props
				.get(PaymentApplyHServiceConstants.isaccept);
		logger.debug("isaccept(0:是;1:否)=" + isaccept);
		// 接受
		if ("0".equals(isaccept)) {
			// 接受批复
			int result = accept(approve.getApproveId());
			// 更新失败
			if (result != 1) {
				response.setRespCode(HServiceReturnCode.DB_ERROR_ERROR
						.getReturnCode());
				response.setRespMessage(HServiceReturnCode.DB_ERROR_ERROR
						.getReturnMessage());
				// 更新成功
			} else {
				response.setRespCode(HServiceReturnCode.SUCCESS.getReturnCode());
				response.setRespMessage(HServiceReturnCode.SUCCESS
						.getReturnMessage());
			}
			// 不接受
		} else {
			// 不接受原因
			String refusereason = (String) props
					.get(PaymentApplyHServiceConstants.refusereason);
			logger.debug("refusereason=" + refusereason);
			// 不接受批复
			int result = notAccept(approve.getApproveId(), refusereason);
			// 更新失败
			if (result != 1) {
				response.setRespCode(HServiceReturnCode.DB_ERROR_ERROR
						.getReturnCode());
				response.setRespMessage(HServiceReturnCode.DB_ERROR_ERROR
						.getReturnMessage());
				// 更新成功
			} else {
				response.setRespCode(HServiceReturnCode.SUCCESS.getReturnCode());
				response.setRespMessage(HServiceReturnCode.SUCCESS
						.getReturnMessage());
				//拒绝时生成外呼任务
				//生成外呼任务
				insertCallingTask(approve, refusereason);
			}
		}
		logger.debug("RespCode=" + response.getRespCode());
		logger.debug("RespMessage=" + response.getRespMessage());
		logger.debug("UMApprResultConfirmServiceImpl end");
		return response;
	}

	/**
	 * 接受批复
	 * 
	 * @param approveId
	 * @return result
	 */
	private int accept(String approveId) {
		Map<String, Object> updateMap = Maps.newHashMap();
		updateMap.put("approveId", approveId);
		updateMap.put("approveStatus", "02");
		int result = loanPosContractManagementBiz
				.modifyContractManagementInfo(updateMap);
		if (result != 1) {
			logger.debug("批复信息更新失败！result=" + result);
			return result;
		}
		logger.debug("批复信息更新成功！result=" + result);
//2015.06.23 guoyu 审批同意时不更新外呼任务
//		Date d = new Date();
//
//		Map<String, Object> reqVars = Maps.newHashMap();
//		reqVars.put("relaBizNo", approveId); // 外呼对象为批复
//		reqVars.put("relaBizPhase", "APR");
//		List<TCallingTask> tasks = service.getTCallingTask(reqVars);
//		if (tasks != null && tasks.size() > 0) {
//			TCallingTask TC = tasks.get(0);
//			logger.debug("外呼任务为" + TC);
//			Date ct = TC.getCallingTime();
//			String taskNo = TC.getTaskNo();
//			logger.debug("外呼任务号为" + taskNo);
//
//			if (ct != null) {
//				logger.debug("该外呼任务已经处理过");
//			} else if (TC.getClaimerName() != null && TC.getClaimerId() != null
//					&& TC.getClaimTime() != null) {
//				logger.debug("该外呼任务已被认领但未被处理");
//				Map<String, Object> Map = Maps.newHashMap();
//				Map.put("taskNo", taskNo);
//				Map.put("callingTime", d);
//				Map.put("dealInfo", "通过");
//				logger.debug("外呼任务map为" + Map);
//				int b = service.updateTcallingTask1(Map);
//				if (b == 1) {
//					logger.debug("更新外呼任务成功");
//				} else {
//					logger.debug("更新外呼任务失败");
//				}
//			} else {
//				logger.info("该笔外呼任务未被认领处理");
//				Map<String, Object> Map = Maps.newHashMap();
//				Map.put("taskNo", taskNo);
//				Map.put("claimerId", "system");
//				Map.put("claimerName", "系统自动处理");
//				Map.put("claimTime", d);
//				Map.put("callingTime", d);
//				Map.put("dealInfo", "通过");
//				logger.info("外呼任务map为" + Map);
//				int b = service.updateTcallingTask2(Map);
//				if (b == 1) {
//					logger.debug("更新外呼任务成功");
//				} else {
//					logger.debug("更新外呼任务失败");
//				}
//			}
//		}
		return result;
	}

	/**
	 * 不接受批复
	 * 
	 * @param approveId
	 * @param refusereason
	 * @return
	 */
	private int notAccept(String approveId, String refusereason) {
		Map<String, Object> updateMap = Maps.newHashMap();
		updateMap.put("approveId", approveId);
		updateMap.put("approveStatus", "03");
		int result = loanPosContractManagementBiz
				.modifyContractManagementInfo(updateMap);

		if (result != 1) {
			logger.debug("批复信息更新失败！result=" + result);
			return result;
		}
		logger.debug("批复信息更新成功！result=" + result);
//2015.06.23 guoyu 审批不接受时不更新外呼任务
//		Map<String, Object> map = Maps.newHashMap();
//		Date dt = new Date();
//
//		int f = loanPosContractManagementBiz
//				.selectRejectMaxApproveNumByApproveId(approveId);
//		map.put("approveId", approveId);
//		map.put("approvenum", f);
//		map.put("rejectreason", "其他");
//		map.put("rejdetail", refusereason);
//		map.put("rejdt", dt);
//		map.put("rejperson", "system");
//		result = loanPosContractManagementBiz.insertApproveReject(map);
//		if (result != 1) {
//			logger.debug("插入批复拒绝表失败！result=" + result);
//			return result;
//		}
//		logger.debug("插入批复拒绝表成功！result=" + result);
//
//		Map<String, Object> reqVars = Maps.newHashMap();
//		reqVars.put("relaBizNo", approveId); // 外呼对象为批复
//		reqVars.put("relaBizPhase", "APR");
//		List<TCallingTask> tasks = service.getTCallingTask(reqVars);
//		if (tasks != null && tasks.size() > 0) {
//			TCallingTask TC = tasks.get(0);
//			logger.debug("外呼任务为" + TC);
//			Date ct = TC.getCallingTime();
//			String taskNo = TC.getTaskNo();
//			logger.debug("外呼任务号为" + taskNo);
//
//			String dealInfo = "拒绝," + refusereason;
//			// if (!rejreason.equals("其他")) {
//			// dealInfo = "拒绝," + rejreason;
//			// } else {
//			// dealInfo = "拒绝," + reasondetail;
//			// }
//
//			if (ct != null) {
//				logger.debug("该外呼任务已经处理过");
//			} else if (TC.getClaimerName() != null && TC.getClaimerId() != null
//					&& TC.getClaimTime() != null) {
//				logger.debug("该外呼任务已被认领但未被处理");
//				Map<String, Object> Map = Maps.newHashMap();
//				Map.put("taskNo", taskNo);
//				Map.put("callingTime", dt);
//				Map.put("dealInfo", dealInfo);
//				logger.debug("外呼任务map为" + Map);
//				int b = service.updateTcallingTask1(Map);
//				if (b == 1) {
//					logger.debug("更新外呼任务成功");
//				} else {
//					logger.debug("更新外呼任务失败");
//				}
//			} else {
//				logger.debug("该笔外呼任务未被认领处理");
//				Map<String, Object> Map = Maps.newHashMap();
//				Map.put("taskNo", taskNo);
//				Map.put("claimerId", "system");
//				Map.put("claimerName", "系统自动处理");
//				Map.put("claimTime", dt);
//				Map.put("callingTime", dt);
//				Map.put("dealInfo", dealInfo);
//				logger.debug("外呼任务map为" + Map);
//				int b = service.updateTcallingTask2(Map);
//				if (b == 1) {
//					logger.debug("更新外呼任务成功");
//				} else {
//					logger.debug("更新外呼任务失败");
//				}
//			}
//		}
		return result;
	}
    /**
     * 生成外呼任务
     * 
     * @param ar,refusereason
     * @return
     */
    private int insertCallingTask(TApproveResult ar,String refusereason){
    	TCallingTask ct = new TCallingTask();
    	ct.setTaskNo(IdUtil.getId(ReviewNoteConstants.CALLING_TASK_KEY_PREFIX));
    	ct.setGenerateTime(new Date());
    	ct.setCallingType(ReviewNoteConstants.CALLING_TASK_CALLINGTYPE_05);
    	ct.setRelaBizNo(ar.getApproveId());
    	ct.setRelaBizPhase(ReviewNoteConstants.CALLING_TASK_RELABIZPHASE_APR);
    	ct.setCustId(ar.getCustId());
    	ct.setPosCustId(ar.getPosCustId());
    	ct.setDealInfo(refusereason);
    	return service.insertSelective(ct);
    }
}
