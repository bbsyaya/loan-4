/**
 * 
 *	哈尔滨银行
 * Copyright (c) 2007-2015 HRBB,Inc.All Rights Reserved.
 */
package com.hrbb.loan.spi.TC;

import java.util.Map;

/**
 * T62用款申请抽象类
 * 
 * @author marco
 * @version $Id: AbsTCPaymentApplyQueryService.java, v 0.1 2015-8-17 下午7:23:03
 *          marco Exp $
 */
public abstract class AbsTCPaymentApplyQueryService extends TCService {

	abstract protected boolean checkBankCardStatus(String accNo);

	abstract protected boolean checkCfgFundingPool();

	abstract protected boolean checkCautionMoney(Map<String, Object> reqMap);
}
