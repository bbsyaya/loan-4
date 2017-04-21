package com.hrbb.loan.quartz;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.hrbb.loan.pos.biz.backstage.inter.IRepaymentPlanBiz;

@Service("addRepaymentAutoTask")
public class AddRepaymentAutoTask {
	
	@Autowired
	private IRepaymentPlanBiz repaymentPlanBiz;
	
	public void execute(){
		repaymentPlanBiz.addRepaymentApply();
	}
}
