/**
 * 
 *	哈尔滨银行
 * Copyright (c) 2007-2015 HRBB,Inc.All Rights Reserved.
 */
package com.hrbb.loan.spi.TC;

import java.util.Map;

/**
 * 
 * @author marco
 * @version $Id: AbsApplyService.java, v 0.1 2015-8-17 下午7:23:03 marco Exp $
 */
public abstract class AbsTCApplyService extends TCService {

	abstract protected boolean executeExtensionAction(Map<String,Object> creMap, Map<String,Object> custMap, Map<String,Object> posCustMap, Map<String,Object> bankMap, Map<String,Object> relaMap);

}
