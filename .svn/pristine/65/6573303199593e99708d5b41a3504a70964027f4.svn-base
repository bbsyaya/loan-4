package com.hrbb.loan.spi.KQ;

import org.springframework.stereotype.Service;

import com.hrbb.loan.spi.POSHService;
import com.hrbb.loan.spi.TC.TCElectricContractGenerateHserviceImpl;

@Service("kqElectricContractGenerate")
public class KQElectricContractGenerateHserviceImpl extends TCElectricContractGenerateHserviceImpl {
	/* (non-Javadoc)
	 * @see com.hrbb.loan.spi.POSHService#getChannle()
	 */
	@Override
	public String getChannel() {
		return POSHService.进件渠道_快钱;
	}
	
	/**
	 * 报文中保持银行代码
	 * @return
	 */
	public boolean keepBankNo(){
		return true;
	}
}
