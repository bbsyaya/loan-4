package com.hrbb.loan.pos.util;


public class PwdUtil {
	
	public static String getTcZipPwd(String certNo){
		if(StringUtil.isNotEmpty(certNo)){
			return "pwd" + "%" + RandomUtil.getRandom(4) + "!" + certNo.substring(certNo.length()-4, certNo.length());
		}else{
			return null;
		}
	}
}
