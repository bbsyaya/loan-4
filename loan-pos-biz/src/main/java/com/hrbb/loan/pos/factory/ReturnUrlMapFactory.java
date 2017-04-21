package com.hrbb.loan.pos.factory;

import com.google.common.collect.ImmutableSet;

public class ReturnUrlMapFactory {

	public static final ImmutableSet<String> channelSet = new ImmutableSet.Builder<String>().add("SM").add("58").add("RN").add("WX")
			.build();
	//萨摩耶模式是下载完影像资料后自动上传征信报告
	public static boolean isContainChannel(String channel){
		if(channelSet.contains(channel)){
			return true;
		}else{
			return false;
		}
	}
	
	//根据渠道修改合同状态， 比如58协议回传后改为06，萨摩耶改为01
	public static final ImmutableSet<String> contractStatusSet = new ImmutableSet.Builder<String>().add("SM").add("RN").add("58").build();
	
	public static boolean isContainContractChannel(String channel){
		if(contractStatusSet.contains(channel)){
			return true;
		}else{
			return false;
		}
	}
	
	public static final ImmutableSet<String> generatePaymentApplyAutoSet = new ImmutableSet.Builder<String>().add("RN").build();
	
	//融360类型渠道电子协议回传后,自动生成用款
	public static boolean isGeneratePaymentApplyAuto(String channel){
		if(generatePaymentApplyAutoSet.contains(channel)){
			return true;
		}else{
			return false;
		}
	}
	
	
	
}


