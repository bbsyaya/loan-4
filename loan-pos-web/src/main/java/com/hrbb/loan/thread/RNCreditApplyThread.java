package com.hrbb.loan.thread;

import java.util.Map;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Scope;
import org.springframework.stereotype.Component;

import com.google.common.collect.ImmutableSet;
import com.google.common.collect.Maps;
import com.hrbb.loan.hessian.inter.IAICHessianService;
import com.hrbb.loan.hessian.inter.IBankCardCheckHessianService;
import com.hrbb.loan.hessian.inter.IPoliceHessianService;
import com.hrbb.loan.pos.biz.backstage.inter.ILoanPosCreditApplyBackStageBiz;
import com.hrbb.loan.pos.biz.backstage.inter.ILoanPosCreditApplyCheckRegBiz;
import com.hrbb.loan.pos.service.LoanPosCreditApplyService;
import com.hrbb.loan.pos.util.StringUtil;

@Scope("prototype")
@Component("rnCreditApplyThread")
public class RNCreditApplyThread implements Runnable {

	@Autowired
	private ILoanPosCreditApplyBackStageBiz iLoanPosCreditApplyBackStageBiz;
	
	@Autowired
	private IAICHessianService aicHessianService;
	
	@Autowired
	private IPoliceHessianService iPoliceHessianService;
	
	@Autowired
	private IBankCardCheckHessianService iBankCardCheckService;
	
	@Autowired
	private LoanPosCreditApplyService loanPosCreditApplyService;
	
	
	@Autowired
	private ILoanPosCreditApplyCheckRegBiz loanPosCreditApplyCheckRegBiz;
	
	private Logger logger = LoggerFactory.getLogger(RNCreditApplyThread.class);
	
	private Map<String, Object> reqMap;
	
	
	
	
	




	




	public Map<String, Object> getReqMap() {
		return reqMap;
	}




	public void setReqMap(Map<String, Object> reqMap) {
		this.reqMap = reqMap;
	}


	@Override
	public void run() {
			try{
				boolean uploadImg = iLoanPosCreditApplyBackStageBiz.getUmImg(reqMap);
				if(!uploadImg){
					Map<String, Object> statusMap = Maps.newHashMap();
					statusMap.put("loanId", reqMap.get("loanid"));
					statusMap.put("applyStatus", "10");
					loanPosCreditApplyService.updateApplyStatus(statusMap);
				}						
			}catch(Exception e){
				logger.error("调影像资料下载异常:", e);
				Map<String, Object> statusMap = Maps.newHashMap();
				statusMap.put("loanId", reqMap.get("loanid"));
				statusMap.put("applyStatus", "10");
				loanPosCreditApplyService.updateApplyStatus(statusMap);
			}

		}

}
