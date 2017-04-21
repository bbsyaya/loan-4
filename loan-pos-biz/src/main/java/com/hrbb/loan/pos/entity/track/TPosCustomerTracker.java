/**
 * 
 */
package com.hrbb.loan.pos.entity.track;

import java.util.Map;

import com.hrbb.loan.pos.dao.entity.TPosCustInfo;
import com.hrbb.loan.pos.entity.SpringBeans;
import com.hrbb.loan.pos.service.LoanPosCustService;

/**
 * <p>Title: TPosCustomerTracker.java </p>
 * <p>Description:  </p>
 * <p>Copyright: Copyright (C) 2015 Hrbb Ltd. Co.</p> 
 *     
 * @author linzhaolin@hrbb.com.cn
 * @version 
 * @date 2015年8月19日
 *
 * logs: 1. 
 */
public class TPosCustomerTracker extends AbsBizObjectTracker {

	private TPosCustInfo posCustomer;
	
	private LoanPosCustService loanPosCustService;
	
	public TPosCustomerTracker(String posCustId){
		/*get service*/
		loanPosCustService = (LoanPosCustService)SpringBeans.getBean("loanPosCustService");
		/*get bizObject*/
		posCustomer = loanPosCustService.selectOnePosCust(posCustId);
		
		this.excludeFields("poCustId,operAddrCode,posCustProv,posCustCity");
	}
	/* (non-Javadoc)
	 * @see com.hrbb.loan.pos.entity.track.BizObjectTracker#getBizNo()
	 */
	@Override
	public String getBizNo() {
		return posCustomer.getPosCustId();
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
			Map<String, Object> changedFields = this.applyChanges(posCustomer, vars);		//应用变更项
			if(changedFields.size()>0) {
				/*更新申请*/
				changedFields.put("posCustId", getBizNo());		/*一般情况关键字不会作为变更项,因此需要补充关键字s*/
				loanPosCustService.updateByPrimaryKeySelectiveMap(changedFields);
			}
			
		}catch(Exception e){
			logger.error("更新商户信息失败",e);
			return false;
		}
		return true;
	}

}
