package com.hrbb.loan.quartz;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.hrbb.loan.pos.biz.backstage.inter.IExpiredApprove;


@Service("expiredApproveTask")
public class ExpiredApproveTask {
	
	@Autowired
	private IExpiredApprove expiredApprove;
	
	public void execute(){
		expiredApprove.expiredApprove();
	}

}
