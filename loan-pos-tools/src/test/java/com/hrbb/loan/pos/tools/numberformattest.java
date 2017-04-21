package com.hrbb.loan.pos.tools;

import java.text.DecimalFormat;

public class numberformattest {
	public static void main(String args[]) {
		
		DecimalFormat df1 = new DecimalFormat("#.00");
		
		System.out.println(df1.format(1234.5678));
		
	}
	
}
