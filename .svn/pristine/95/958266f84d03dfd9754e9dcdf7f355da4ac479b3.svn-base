package com.hrbb.loan.spi.ZW;

import org.springframework.stereotype.Service;

import com.hrbb.loan.spi.TC.TCElectricContractGenerateHserviceImpl;

@Service("zwElectricContractGenerate")
public class ZWElectricContractGenerateHserviceImpl extends TCElectricContractGenerateHserviceImpl {
	/* (non-Javadoc)
	 * @see com.hrbb.loan.spi.POSHService#getChannle()
	 */
	@Override
	public String getChannel() {
		return "ZW";
	}
	
	/**
	 * 报文中保持银行代码
	 * @return
	 */
	public boolean keepBankNo(){
		return true;
	}
}
