package com.hrbb.loan.controller.helper;


/**
 *<h1></h1>
 *@author Johnson Song
 *@version Id: ControllerHelper.java, v 1.0 2015-3-3 上午11:19:53 Johnson Song Exp
 */
public class ControllerHelper {
	
	public static String getLikeString(String str){
		return "%"+str+"%";
	}
	
	public static String getRLikeString(String str){
		return str+"%";
	}
}
