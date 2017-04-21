/**
 * 
 */
package com.hrbb.loan.pos.entity.track;

import java.util.Map;

import com.hrbb.loan.pos.dao.entity.TCreditApply;
import com.hrbb.loan.pos.entity.SpringBeans;
import com.hrbb.loan.pos.service.LoanPosCreditApplyService;

/**
 * <p>Title: BaseBizObjectTracker.java </p>
 * <p>Description:  </p>
 * <p>Copyright: Copyright (C) 2015 Hrbb Ltd. Co.</p> 
 *     
 * @author linzhaolin@hrbb.com.cn
 * @version 
 * @date 2015年8月17日
 *
 * logs: 1. 
 */
public class TCreditApplyTracker extends AbsBizObjectTracker {
	
	private TCreditApply apply;
	
	private LoanPosCreditApplyService loanPosCreditApplyService;
	
	public TCreditApplyTracker(String loanId){
		/*get Service*/
		loanPosCreditApplyService = (LoanPosCreditApplyService)SpringBeans.getBean("loanPosCreditApplyService");
		
		/*get Apply*/
		this.apply = loanPosCreditApplyService.queryCreditApply(loanId);
		
		this.excludeFields("loanId,applyAmt,channel,currSign,returnKind,busiDivision,posCustProv,posCustCity");
	}

	@Override
	public String getBizNo() {
		return apply.getLoanId();
	}

	@Override
	public String getBizPhase() {
		return "APP";
	}

	@Override
	protected boolean executeUpdate(Map<String, Object> vars, String userName) {
		if(vars==null || vars.size()==0){
			logger.error("Do not initialize the update target yet!");
			return false;
		}
		
		try{
			Map<String, Object> changedFields = this.applyChanges(apply, vars);		//应用变更项
			if(changedFields.size()>0) {
				/*更新申请*/
				changedFields.put("loanId", getBizNo());		/*一般情况关键字不会作为变更项,因此需要补充关键字s*/
				loanPosCreditApplyService.updateCreditApplyMap(changedFields);
			}
			
		}catch(Exception e){
			logger.error("更新申请信息失败",e);
			return false;
		}
		return true;
	}

}
