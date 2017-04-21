package com.hrbb.loan.spi.ZW;

import org.springframework.stereotype.Service;

import com.hrbb.loan.spi.TC.TCCreditApplyHServiceImpl;

/**
 * 银商业务申请
 * 
 * @author Johnson
 * 
 */
@Service("zwCreditApply")
public class ZWCreditApplyHServiceImpl extends TCCreditApplyHServiceImpl {

	/* (non-Javadoc)
	 * @see com.hrbb.loan.spi.POSHService#getChannle()
	 */
	@Override
	public String getChannel() {
		return "ZW";
	}

}
