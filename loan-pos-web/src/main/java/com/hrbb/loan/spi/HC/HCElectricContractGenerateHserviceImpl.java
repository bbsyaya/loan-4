package com.hrbb.loan.spi.HC;

import org.springframework.stereotype.Service;

import com.hrbb.loan.spi.POSHService;
import com.hrbb.loan.spi.TC.TCElectricContractGenerateHserviceImpl;

@Service("hcElectricContractGenerate")
public class HCElectricContractGenerateHserviceImpl extends TCElectricContractGenerateHserviceImpl {
	/* (non-Javadoc)
	 * @see com.hrbb.loan.spi.POSHService#getChannle()
	 */
	@Override
	public String getChannel() {
		return POSHService.进件渠道_慧聪网;
	}
	
	/**
	 * 报文中保持银行代码
	 * @return
	 */
	public boolean keepBankNo(){
		return true;
	}
}
