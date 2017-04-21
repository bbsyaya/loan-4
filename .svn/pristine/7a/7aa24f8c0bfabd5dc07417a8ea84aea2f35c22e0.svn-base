package com.hrbb.loan.pos.biz.backstage.inter.impl.withholder;

import com.hrbb.loan.pos.factory.SysConfigFactory;

public class WithholderFactory {
	
	public static String getWithholderMethod(String repayMethod, String loanType, String channel){
		
		String withholderSlfChl = SysConfigFactory.getInstance().getService("fundpool").getPropertyValue("fundPoolWithholderself");
		

		switch(loanType){
			//如果是自营模式，且是代扣的
			case "01" :{
				if("02".equals(repayMethod)){
					return "withholderSelf";
				}else{
					return "withholderNull";
				}
			}
			
			case "02" : {
				if(withholderSlfChl.contains("[" + channel + "]") && "02".equals(repayMethod)){
					return "withholderSelf";
				}else{
					return "withholderFromAcct";
				}
			}
			
			default : {
				return "withholderNull"; 
			}
			
		}
		
	}
}
