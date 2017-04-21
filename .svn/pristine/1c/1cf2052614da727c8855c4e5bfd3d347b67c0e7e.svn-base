/**
 * 
 */
package com.hrbb.loan.pos.entity.track;

import java.util.Date;
import java.util.Map;

import com.google.common.collect.Maps;
import com.hrbb.loan.pos.dao.entity.TBankAccnoInfo;
import com.hrbb.loan.pos.dao.entity.TCreditApply;
import com.hrbb.loan.pos.entity.SpringBeans;
import com.hrbb.loan.pos.service.LoanPosCreditApplyService;
import com.hrbb.loan.pos.service.LoanPosCustomerService;

/**
 * <p>Title: TBankAcntTracker.java </p>
 * <p>Description:  </p>
 * <p>Copyright: Copyright (C) 2015 Hrbb Ltd. Co.</p> 
 *     
 * @author linzhaolin@hrbb.com.cn
 * @version 
 * @date 2015年8月19日
 *
 * logs: 1. 
 */
public class TBankAcntTracker extends AbsBizObjectTracker {

	private TBankAccnoInfo bankAccount;
	
	private LoanPosCustomerService loanPosCustomerService;
	
	private LoanPosCreditApplyService loanPosCreditApplyService;
	
	private TCreditApply apply;
	
	private String bankAccno;
	
	public TBankAcntTracker(String bankAccno,String loanId){
		/*get service*/
		loanPosCustomerService = (LoanPosCustomerService)SpringBeans.getBean("loanPosCustomerService");
		loanPosCreditApplyService = (LoanPosCreditApplyService)SpringBeans.getBean("loanPosCreditApplyService");
		
		/*get bizObject*/
		bankAccount = loanPosCustomerService.getBanAccnoById(bankAccno);
		
		/*relative-bizId*/
		this.apply = loanPosCreditApplyService.queryCreditApply(loanId);
		this.bankAccno = bankAccno;
		
		this.excludeFields("createTime");
	}
	
	/* (non-Javadoc)
	 * @see com.hrbb.loan.pos.entity.track.BizObjectTracker#getBizNo()
	 */
	@Override
	public String getBizNo() {
		return this.bankAccno;
	}
	
	/* (non-Javadoc)
	 * @see com.hrbb.loan.pos.entity.track.BizObjectTracker#getBizPhase()
	 */
	@Override
	public String getBizPhase() {
		return "APP";
	}

	/* (non-Javadoc)
	 * @see com.hrbb.loan.pos.entity.track.AbsBizObjectTracker#executeUpdate(java.util.Map, java.lang.String)
	 */
	@Override
	protected boolean executeUpdate(Map<String, Object> vars, String userName) {
		if(vars==null || vars.size()==0){
			logger.error("Do not initialize the update target yet!");
			return false;
		}
		
		try{
			if(bankAccount == null){
				/*如果卡号变则新增*/
				Map<String,Object> insertMap = Maps.newHashMap();
				insertMap.put("bankAccno", vars.get("bankAccno"));
				insertMap.put("custId", apply.getCustId());
				insertMap.put("bankName", vars.get("bankName"));
				insertMap.put("bankBranName", vars.get("bankBranName"));
				insertMap.put("bankSubbName", vars.get("bankSubbName"));
				insertMap.put("createTime", new Date());
				insertMap.put("status", "00");
				//新增银行卡
				loanPosCustomerService.insertBankAccno(insertMap);
				
//				//更换银行卡
				Map<String,Object> updatetMap = Maps.newHashMap();
				updatetMap.put("bankAccno", vars.get("bankAccno"));
				updatetMap.put("loanId", apply.getLoanId());
				loanPosCreditApplyService.updateCreditApplyMap(updatetMap);
			}else{
				Map<String, Object> changedFields = this.applyChanges(bankAccount, vars);		//应用变更项
				if(changedFields.size()>0) {
					/*更新银行卡*/
					changedFields.put("bankAccno", getBizNo());		/*一般情况关键字不会作为变更项,因此需要补充关键字s*/
					loanPosCustomerService.updateBankAccno(changedFields);
				}
			}
			
		}catch(Exception e){
			logger.error("更新银行卡信息失败",e);
			return false;
		}
		return true;
	}

}
