/**
 * 
 *	哈尔滨银行
 * Copyright (c) 2007-2015 HRBB,Inc.All Rights Reserved.
 */
package com.hrbb.loan.pos.biz.backstage.inter;

/**
 * 
 * @author marco
 * @version $Id: SynFileBiz.java, v 0.1 2015-4-24 下午4:18:52 marco Exp $
 */
public interface SynFileBiz {
	public boolean makeSynFile(String pathStr, String fileName, String channel,
			String excuteDay);
}