package com.hrbb.loan.pos.factory;

public class StatusChannelMapFactory {
	
	//映射申请状态
	public static String getChannelApplyMapStatus(String channel, String status){
		return null;
	}
	
	
	//映射还款方式
	public static String getChannelReturnKind(String channel, String returnKind){
		switch (channel) {
		case "UM":
		{
			if("01".equals(returnKind)){
				return "90";
			}
		}
		default:
			return returnKind;
		}
	}
	
	public static String getChannelQueryReturnKind(String channel, String returnKind){
		switch (channel) {
		case "UM":{
			if("90".equals(returnKind)){
				return "01";
			}
		}
			
		default:
			return returnKind;
		}
	}
}
