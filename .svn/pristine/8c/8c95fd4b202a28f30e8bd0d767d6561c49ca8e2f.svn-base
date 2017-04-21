package com.hrbb.loan.pos.util;

public class SmsTemplateFactory {
	
	public static String getCheckTemplate(String channel){
		switch (channel) {
		case "UM":
			return "POS0003";
		case "58":
			return "580001";
		
		default:
			return "POS0003";
		}
	}
	
	//补件短信模板
	public static String getAddiTemplate(String channel){
		switch (channel) {
		case "UM":
			
			return "POS0004";
		
		case "58":
			
			return "580002";
		default:
			return "POS0004";
		}
	}
	
	//拒绝
	public static String getRefuseSms(String channel){
		switch (channel) {
		case "UM":
			
			return "POS0010";
		
		case "58":
			return "580009";

		default:
			return "POS0010";
		}
	}
	
	//协议生效
	public static String getContractSms(String channel){
		switch (channel) {
		case "UM":
			return "POS0005";
		case "58":
			return "580003";
		default:
			return "POS0005";
		}
	}
	
	//用款
	public static String getPaymentSms(String channel){
		switch (channel) {
		case "UM":
			return "POS0006";
		case "58":
			return "580004";

		default:
			return "POS0006";
		}
	}
}
