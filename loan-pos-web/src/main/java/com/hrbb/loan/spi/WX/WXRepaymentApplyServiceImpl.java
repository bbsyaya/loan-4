/**
 * 
 *	哈尔滨银行
 * Copyright (c) 2007-2015 HRBB,Inc.All Rights Reserved.
 */
package com.hrbb.loan.spi.WX;

import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.hrbb.loan.pos.biz.backstage.inter.IPaymentApplyBiz;
import com.hrbb.loan.spi.POSHService;
import com.hrbb.loan.spi.TC.TCRepaymentApplyServiceImpl;

/**
 * T56还款申请
 * 
 * @author marco
 * @version $Id: TC2RepaymentApplyServiceImpl.java, v 0.1 2015-8-20 上午11:39:50
 *          marco Exp $
 */
@Service("wxRepaymentApply")
public class WXRepaymentApplyServiceImpl extends TCRepaymentApplyServiceImpl {
	@Autowired
	IPaymentApplyBiz paymentApplyBiz;
	@Override
	public String getChannel() {
		return POSHService.进件渠道_维信;
	}

	/**
	 * 前置加解密标签
	 * 
	 * @return
	 */
	@Override
	public String getEncryptedRender() {
		return "wx";
	}

	protected boolean initRepaymentEnv(Map<String, Object> request){
		String contno=(String)request.get("contno");
		String issueid = paymentApplyBiz.getPaymentApplyIdByContno(contno);
		request.put("issueid", issueid);
		return true;
	}
	
}
