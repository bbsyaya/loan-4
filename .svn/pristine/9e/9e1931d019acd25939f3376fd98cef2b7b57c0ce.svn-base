/**
 * 
 *	哈尔滨银行
 * Copyright (c) 2007-2015 HRBB,Inc.All Rights Reserved.
 */
package com.hrbb.loan.spi.RNT;

import org.springframework.stereotype.Service;

import com.hrbb.loan.spi.POSHService;
import com.hrbb.loan.spi.TC.TCAddInforServiceImpl;

/**
 * T53补充资料上传
 * 
 * @author marco
 */
@Service("rnAddInfo")
public class RNAddInforServiceImpl extends TCAddInforServiceImpl {
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
