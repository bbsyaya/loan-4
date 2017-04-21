package com.hrbb.loan.spi.RNT;

import org.springframework.stereotype.Service;

import com.hrbb.loan.spi.POSHService;
import com.hrbb.loan.spi.TC.TCQueryApplyInfoHServiceImpl;

/**
 * T52申请信息及状态查询
 * 
 * @author marco
 * 
 */
@Service("rnQueryApplyInfo")
public class RNQueryApplyInfoHServiceImpl extends TCQueryApplyInfoHServiceImpl {
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
