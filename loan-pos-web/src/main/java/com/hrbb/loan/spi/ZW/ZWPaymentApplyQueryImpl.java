package com.hrbb.loan.spi.ZW;

import org.springframework.stereotype.Service;

import com.hrbb.loan.spi.TC.TCPaymentApplyQueryImpl;

@Service("zwPaymentApplyQuery")
public class ZWPaymentApplyQueryImpl extends TCPaymentApplyQueryImpl {
	
	/* (non-Javadoc)
	 * @see com.hrbb.loan.spi.POSHService#getChannle()
	 */
	@Override
	public String getChannel() {
		return "ZW";
	}
	
}
