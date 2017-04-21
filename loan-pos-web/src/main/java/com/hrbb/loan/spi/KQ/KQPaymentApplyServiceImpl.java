package com.hrbb.loan.spi.KQ;

import org.springframework.stereotype.Service;

import com.hrbb.loan.spi.POSHService;
import com.hrbb.loan.spi.TC.TCPaymentApplyServiceImpl;

@Service("kqPaymentApply")
public class KQPaymentApplyServiceImpl extends TCPaymentApplyServiceImpl{
	/* (non-Javadoc)
	 * @see com.hrbb.loan.spi.POSHService#getChannle()
	 */
	@Override
	public String getChannel() {
		return POSHService.进件渠道_快钱;
	}

}
