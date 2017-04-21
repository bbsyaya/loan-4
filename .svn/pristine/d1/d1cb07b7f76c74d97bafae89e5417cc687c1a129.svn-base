/**
 * 
 */
package com.hrbb.loan.pos.entity.event.impl;

import java.util.Date;
import java.util.Map;

import com.hrbb.loan.pos.dao.entity.TCallingTask;
import com.hrbb.loan.pos.dao.entity.TPaymentApply;
import com.hrbb.loan.pos.entity.SpringBeans;
import com.hrbb.loan.pos.entity.event.EventException;
import com.hrbb.loan.pos.entity.event.ListenerEventAction;
import com.hrbb.loan.pos.service.CallingTaskService;
import com.hrbb.loan.pos.util.IdUtil;
import com.hrbb.loan.pos.util.constants.ReviewNoteConstants;

/**
 * <p>Title: IssueRejectTask.java </p>
 * <p>Description:  </p>
 * <p>Copyright: Copyright (C) 2015 Hrbb Ltd. Co.</p> 
 *     
 * @author linzhaolin@hrbb.com.cn
 * @version 
 * @date 2015年7月9日
 *
 * logs: 1. 
 */
public class IssueRejectTask implements ListenerEventAction {
	
	private TPaymentApply paymentApply;
	
	private Map<String,Object> approval;
	
	public IssueRejectTask(TPaymentApply paymentApply,Map<String,Object> approval){
		this.paymentApply = paymentApply;
		this.approval = approval;
	}
	
	/* (non-Javadoc)
	 * @see com.hrbb.loan.pos.entity.event.ListenerEventAction#execute()
	 */
	@Override
	public void execute() throws EventException {
		///
		/*获取Sprig Bean*/
		CallingTaskService callingTaskService = (CallingTaskService)SpringBeans.getBean("CallingTaskService");
		
		TCallingTask ct = new TCallingTask();
    	ct.setTaskNo(IdUtil.getId(ReviewNoteConstants.CALLING_TASK_KEY_PREFIX));
    	ct.setGenerateTime(new Date());
    	ct.setCallingType(ReviewNoteConstants.CALLING_TASK_CALLINGTYPE_14);
    	ct.setRelaBizNo(paymentApply.getPayApplyId());
    	ct.setRelaBizPhase(ReviewNoteConstants.CALLING_TASK_RELABIZPHASE_ISS);
    	ct.setCustId(paymentApply.getCustId());
    	ct.setPosCustId(paymentApply.getPosCustId());
    	ct.setDealInfo((String)approval.get("approvalContent"));
    	
    	callingTaskService.insertSelective(ct);
		
	}

}
