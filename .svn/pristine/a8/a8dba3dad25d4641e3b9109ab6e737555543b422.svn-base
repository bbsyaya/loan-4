package com.hrbb.loan.spi.WX;

import com.hrbb.loan.constants.CreditApplyConstants;
import com.hrbb.loan.spi.AbstractPOSService;
import com.hrbb.loan.spi.POSHService;

public abstract class WXHService extends AbstractPOSService{

	
	
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
		return POSHService.进件渠道_维信;
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
		return "wx";
	}
	
	
	/**
	 * 报文中保持银行代码
	 * @return
	 */
	public boolean keepBankNo(){
		return true;
	}
}
