package com.hrbb.loan.spi.RNT;

import org.springframework.stereotype.Service;

import com.hrbb.loan.spi.POSHService;
import com.hrbb.loan.spi.TC2.TC2ApproveResultFeedbackHServiceImpl;

/**
 * T61审批结果反馈
 * 
 * @author marco
 * 
 */
@Service("rnApproveResultFeedback")
public class RNApproveResultFeedbackHServiceImpl extends
		TC2ApproveResultFeedbackHServiceImpl {
	@Override
	public String getChannel() {
		return POSHService.进件渠道_融360;
	}

	/**
	 * 前置加解密标签
	 * 
	 * @return
	 */
	@Override
	public String getEncryptedRender() {
		return "RNT";
	}

}
