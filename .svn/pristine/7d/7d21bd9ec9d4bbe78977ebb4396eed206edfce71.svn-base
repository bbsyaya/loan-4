package com.hrbb.loan.spi.RNT;

import org.springframework.stereotype.Service;

import com.hrbb.loan.spi.POSHService;
import com.hrbb.loan.spi.TC.TCContractQueryHserviceImpl;

/**
 * T55协议查询接口
 * 
 * @author marco
 * 
 */
@Service("rnContractQuery")
public class RNContractQueryHserviceImpl extends TCContractQueryHserviceImpl {
	@Override
	public String getChannel() {
		return POSHService.进件渠道_融360;
	}

	/**
	 * 前置加解密标签
	 * 
	 * @return
	 */
	@Override
	public String getEncryptedRender() {
		return "RNT";
	}
}
