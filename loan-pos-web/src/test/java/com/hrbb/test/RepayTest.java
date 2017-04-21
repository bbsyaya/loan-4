package com.hrbb.test;

import org.junit.Test;
import org.springframework.beans.factory.annotation.Autowired;

import com.hrbb.loan.pos.biz.backstage.inter.IRepaymentPlanBiz;

public class RepayTest extends UnitTest{

	@Autowired
	private IRepaymentPlanBiz repaymentPlanBiz; 
	
	@Test
	public void repayTest(){
		repaymentPlanBiz.sendRepaymentMsg();		
	}
	
	@Test
	public void addRepayment(){
		repaymentPlanBiz.addRepaymentApply();
	}
	
	@Test
	public void repayAuto(){
		repaymentPlanBiz.withhold();
	}
}
