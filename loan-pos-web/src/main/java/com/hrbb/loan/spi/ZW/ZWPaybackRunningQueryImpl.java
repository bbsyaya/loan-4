package com.hrbb.loan.spi.ZW;

import org.springframework.stereotype.Service;

import com.hrbb.loan.spi.TC.TCPaybackRunningQueryImpl;

@Service("zwPaybackRunningQuery")
public class ZWPaybackRunningQueryImpl extends TCPaybackRunningQueryImpl {
	
	/* (non-Javadoc)
	 * @see com.hrbb.loan.spi.POSHService#getChannle()
	 */
	@Override
	public String getChannel() {
		return "ZW";
	}
}
