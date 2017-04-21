/**
 * 
 *	哈尔滨银行
 * Copyright (c) 2007-2015 HRBB,Inc.All Rights Reserved.
 */
package com.hrbb.loan.pos.tools.main.synFile.fileMaker;

import com.hrbb.loan.pos.util.constants.ReviewNoteConstants;

/**
 * 数据同步接口
 * 
 * @author marco
 * @version $Id: SynFileMakerZW.java, v 0.1 2015-4-24 下午4:20:22 marco Exp $
 */
public class SynFileMakerZW extends SynFileMaker58 {

	@Override
	public String getChannel() {
		return ReviewNoteConstants.CHANNEL_CODE_ZW;
	}
}
