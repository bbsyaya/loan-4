package com.hrbb.loan.spi.ZW;

import org.springframework.stereotype.Service;

import com.hrbb.loan.spi.TC.TCPaybackTryCalculateImpl;

@Service("zwPaybackTryCalculate")
public class ZWPaybackTryCalculateImpl extends TCPaybackTryCalculateImpl {
	
	/* (non-Javadoc)
	 * @see com.hrbb.loan.spi.POSHService#getChannle()
	 */
	@Override
	public String getChannel() {
		return "ZW";
	}
}
