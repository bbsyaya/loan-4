package com.hrbb.loan.spi.KQ;

import org.springframework.stereotype.Service;

import com.hrbb.loan.spi.POSHService;
import com.hrbb.loan.spi.TC.TCCreditApplyHServiceImpl;
import com.hrbb.loan.spi.UM.UMCreditApplyHServiceImpl;

/**
 * 银商业务申请
 * 
 * @author Johnson
 * 
 */
@Service("kqCreditApply")
public class KQCreditApplyHServiceImpl extends TCCreditApplyHServiceImpl {

	/* (non-Javadoc)
	 * @see com.hrbb.loan.spi.POSHService#getChannle()
	 */
	@Override
	public String getChannel() {
		return POSHService.进件渠道_快钱;
	}

}
