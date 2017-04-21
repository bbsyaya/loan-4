package com.hrbb.loan.spi.SM;

import org.springframework.stereotype.Service;

import com.hrbb.loan.constants.CreditApplyConstants;
import com.hrbb.loan.spi.POSHService;
import com.hrbb.loan.spi.TC2.TC2ApproveResultFeedbackHServiceImpl;

@Service("smApproveResultFeedbackHservice")
public class SMApproveResultFeedbackHserviceImpl extends TC2ApproveResultFeedbackHServiceImpl{
	
	
	
	
	
	/**
	 * 贷款方式
	 * @return
	 */
	public String getLoanType(){
		return POSHService.贷款模式_资金池;
	}
	
	/**
	 * 产品编号
	 * @return
	 */
	public String getProdId(){
		return CreditApplyConstants.consumeLoanFlag;
	}
	
	/**
	 * 产品名称
	 * @return
	 */
	public String getProdName(){
		return CreditApplyConstants.consumeLoanName;
	}
	
	@Override
	public String getChannel() {
		return POSHService.进件渠道_萨摩耶;
	}
//
//	/**
//	 * 推荐机构
//	 * @return
//	 */
//	public String getPromOrg(){
//		return "58.com";
//	}
//	
//	/**
//	 * 推荐人
//	 * @return
//	 */
//	public String getPromMan(){
//		return "58.com";
//	}
	
	/**
	 * 前置加解密标签
	 * @return
	 */
	public String getEncryptedRender(){
		return "sm";
	}
}
