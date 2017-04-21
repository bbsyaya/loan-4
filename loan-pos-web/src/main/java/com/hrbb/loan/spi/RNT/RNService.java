package com.hrbb.loan.spi.RNT;

import com.hrbb.loan.spi.AbstractPOSService;
import com.hrbb.loan.spi.POSHService;

public abstract class RNService extends AbstractPOSService{
	/* (non-Javadoc)
	 * @see com.hrbb.loan.spi.POSHService#getChannle()
	 */
	@Override
	public String getChannel() {
		return POSHService.进件渠道_融360;
	}
	
	/**
	 * 前置加解密标签
	 * @return
	 */
	public String getEncryptedRender(){
		return "RNT";
	}
	
	
	/**
	 * 报文中保持银行代码
	 * @return
	 */
	public boolean keepBankNo(){
		return false;
	}
}
