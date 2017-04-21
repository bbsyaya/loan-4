package com.hrbb.loan.pos.factory;

import com.google.common.collect.ImmutableMap;

public class FtpCodeFactory {
	
	
	public static final ImmutableMap<String, String> ftpCodeMap = new ImmutableMap.Builder<String, String>().put("58", "58I").put("SM", "SMI").put("RN", "RNI").build();

	public static String getFtpCode(String channel) {
		return ftpCodeMap.get(channel);
	}
	
}
