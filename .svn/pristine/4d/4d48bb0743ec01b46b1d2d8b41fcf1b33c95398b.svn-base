/**
 * 
 *	哈尔滨银行
 * Copyright (c) 2007-2015 HRBB,Inc.All Rights Reserved.
 */
package com.hrbb.loan.pos.biz.backstage.inter.impl;

import java.util.Map;

import javax.annotation.PostConstruct;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Component;

import com.google.common.collect.Maps;
import com.hrbb.loan.pos.biz.backstage.inter.CreditApplyRiskCheckBiz;
import com.hrbb.loan.pos.biz.backstage.inter.IAsyncLoadPoliceInfoService;
import com.hrbb.loan.pos.biz.backstage.inter.IId5Service;
import com.hrbb.loan.pos.biz.backstage.inter.LoanRiskCheckBiz;
import com.hrbb.loan.pos.biz.constants.RiskSuggestionDescEnum;
import com.hrbb.loan.pos.dao.entity.TCreditApplyAprvInfo;
import com.hrbb.loan.pos.dao.entity.TRiskCheckResult;
import com.hrbb.loan.pos.service.BusinessDictionaryService;
import com.hrbb.loan.pos.service.CreditApplyAprvInfoService;
import com.hrbb.loan.pos.service.CreditApplyForReviewService;
import com.hrbb.loan.pos.util.constants.ReviewNoteConstants;

/**
 * 
 * @author marco
 * @version $Id: CreditApplyRiskCheckBizImpl.java, v 0.1 2015-4-10 上午10:39:41
 *          marco Exp $
 */
@Component("creditApplyRiskCheckBiz")
public class CreditApplyRiskCheckBizImpl implements CreditApplyRiskCheckBiz {

	private Logger log = LoggerFactory
			.getLogger(CreditApplyRiskCheckBizImpl.class);

	@Autowired
	@Qualifier("creditApplyForReviewService")
	private CreditApplyForReviewService serivce;

	@Autowired
	@Qualifier("loanRiskCheckBiz")
	private LoanRiskCheckBiz riskCheck;

	@Autowired
	@Qualifier("creditApplyAprvInfoService")
	private CreditApplyAprvInfoService serivceCAAI;

	@Autowired
	@Qualifier("businessDictionaryService")
	private BusinessDictionaryService businessDictionaryService;
	@Autowired
	private IAsyncLoadPoliceInfoService loadPoliceInfoService;
	@Autowired
	private IId5Service asyncLoadId5InfoSservice;
	
	
	
	

	/**
	 * @see com.hrbb.loan.pos.biz.backstage.inter.CreditApplyRiskCheckBiz#doRiskCheck(String
	 *      loanId)
	 */
	@Override
	public void doRiskCheck(String loanId) {
		log.debug("doRiskCheck begin");
		log.debug("LoanId=" + loanId);
		try{
		// 执行风险初审
		TRiskCheckResult riskCheckResult = riskCheck.execRiskCheck(loanId);
		if(riskCheckResult == null){
			log.error("====执行分先初审发生异常，不继续执行=========");
			return;
		}
		// 模型授信决定
		String result = riskCheckResult.getResult07();
		log.debug("rezult=" + result);

		// 审批记录
		TCreditApplyAprvInfo caai = new TCreditApplyAprvInfo();
		caai.setLoanId(loanId);
		// 管理员ID
		caai.setApprvId(ReviewNoteConstants.ROLE_SYSTEM_ID);

		int rezult = 0;
		// 审核结果通过
		if (RiskSuggestionDescEnum.SUGGESTIONREZULT_OK.getDescription().equals(
				result)) {
            //async加载公安信息
		    loadPoliceInfoService.loadPoliceInfo(loanId);
		    //async加载固话综合信息
		    asyncLoadId5InfoSservice.asyncQueryFixedLineData(loanId);
			// 模型授信额度
			caai.setApprAmount(riskCheckResult.getResult08());
			// 模型授信额度
			caai.setApprInte(riskCheckResult.getResult09());
			// test
			riskCheckResult.setRiskLevel(false);
			log.debug("RiskLevel=" + riskCheckResult.getRiskLevel());
			// 极低风险：系统自动审批通过。
			if (riskCheckResult.getRiskLevel()) {
				// 初审直接通过
				try {
					rezult = serivceCAAI.updateCreditApplyPass(caai);
				} catch (Exception ex) {
					String msg = "failed to update creditApplyAprv";
					log.error("failed to update creditApplyAprv", ex);
					throw new RuntimeException(msg, ex);
				}
				// 非极低风险：系统自动提交到待处理业务池。
			} else {
				// 风险初审-通过，插入审批记录
				try {
					rezult = serivceCAAI.insertCreditApplyAprvInfo30(caai);
				} catch (Exception ex) {
					String msg = "failed to insert creditApplyAprv";
					log.error("failed to insert creditApplyAprv", ex);
					throw new RuntimeException(msg, ex);
				}
			}

			// 审核结果拒绝
		} else {
			// 申请状态
			caai.setApprState(ReviewNoteConstants.APPLYSTATUS_CODE_30);
			// 审批意见内部
			caai.setApprInfo(businessDictionaryService
					.getApprInfoExtMsg(riskCheckResult.getResult10()));
			// 审批意见外部
			caai.setApprInfoExt(riskCheckResult.getResult10());
			// 生成审批记录
			rezult = serivceCAAI.updateCreditApplyRefuse(caai);
		}
		if (rezult == 1) {
			log.debug("申请状态更新成功！");
		} else {
			log.debug("申请状态更新失败！");
		}

		log.debug("doRiskCheck end");
		}catch(Exception e){
			log.error("风险初审发生异常:", e);
			return;
		}
	}
}
