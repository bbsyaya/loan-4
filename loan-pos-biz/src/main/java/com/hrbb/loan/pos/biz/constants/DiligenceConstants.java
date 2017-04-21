/**
 * 
 *	哈尔滨银行
 * Copyright (c) 2007-2015 HRBB,Inc.All Rights Reserved.
 */
package com.hrbb.loan.pos.biz.constants;

import java.util.HashSet;
import java.util.Set;

/**
 * 尽调标志
 * 
 * @author XLY
 * @version $Id: DiligenceConstants.java, v 0.1 2015-3-10 下午5:31:14 XLY Exp $
 */
public class DiligenceConstants {

	/**
	 * 建议尽调
	 */
	public static final String DO_DILIGENCE = "Y";
	/**
	 * 建议不尽调
	 */
	public static final String UN_DILIGENCE = "N";

	public static final Set<String> A_REGION = new HashSet<String>();

	static {
		A_REGION.add("11");// 北京
		A_REGION.add("21");// 上海
	}
}
