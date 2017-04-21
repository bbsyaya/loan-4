/**
 * 
 *	哈尔滨银行
 * Copyright (c) 2007-2015 HRBB,Inc.All Rights Reserved.
 */
package com.hrbb.loan.pos.tools.main.synFile;

/**
 * 台账数据同步接口
 * 
 * @author marco
 * @version $Id: SynFileConstants.java, v 0.1 2015-3-10 下午5:31:14 marco Exp $
 */
public class SynFileConstants {

	public final static String CHANNEL_CODE_UM = "UM";
	public final static String CHANNEL_CODE_58 = "58";
	public final static String CHANNEL_CODE_ZW = "ZW";
	public final static String CHANNEL_CODE_HC = "HC";
	public static final String CHANNEL_CODE_SM = "SM";
	public static final String CHANNEL_CODE_RN = "RN";
	public final static String CLEARSTATUS_01 = "01";// 已结清
	public final static String CLEARSTATUS_02 = "02";// 正常
	public final static String CLEARSTATUS_03 = "03";// 逾期

	public final static String STRING_UNDERLINE = "_";
	public final static String STRING_COMMA = ",";
	public final static String KEY_SYNCHROFILEPATH = "synchrofilepath";
	public final static String KEY_CHANNELS = "channels";
	public final static String KEY_CHANNELFTPIDS = "channelFtpIds";

	// 渠道等信息文件
	public final static String SYNFILEINFONAME = "synFileInfo.properties";

	// 银商统计报表
	public final static String NO_STATISTICS = "StatisticsFile";
	public final static String SHEET_NAME = "data";
	public final static String REGION = "region";
	
}
