package com.hrbb.loan.pos.util;

import java.util.List;

/**
 *<h1></h1>
 *@author Johnson Song
 *@version Id: ListUtil.java, v 1.0 2015-3-6 下午2:14:49 Johnson Song Exp
 */
public class ListUtil {
	
	public static boolean isNotEmpty(List<? extends Object> list){
		if(null != list && list.size() != 0){
			return true;
		}else{
			return false;
		}
	}
}
