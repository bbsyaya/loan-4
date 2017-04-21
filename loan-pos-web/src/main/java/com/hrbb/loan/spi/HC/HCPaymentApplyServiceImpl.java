package com.hrbb.loan.spi.HC;

import org.springframework.stereotype.Service;

import com.hrbb.loan.spi.POSHService;
import com.hrbb.loan.spi.TC.TCPaymentApplyServiceImpl;

@Service("hcPaymentApply")
public class HCPaymentApplyServiceImpl extends TCPaymentApplyServiceImpl{
	/* (non-Javadoc)
	 * @see com.hrbb.loan.spi.POSHService#getChannle()
	 */
	@Override
	public String getChannel() {
		return POSHService.进件渠道_慧聪网;
	}

}
