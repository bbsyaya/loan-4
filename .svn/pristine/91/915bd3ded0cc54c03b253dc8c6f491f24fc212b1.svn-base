/**
 * 
 */
package com.hrbb.loan.web.security.entity;

import java.io.Serializable;
import java.util.Set;

import com.google.common.collect.Sets;

/**
 * <p>Title: AccessPrivilege.java </p>
 * <p>Description:  </p>
 * <p>Copyright: Copyright (C) 2015 Hrbb Ltd. Co.</p> 
 *     
 * @author linzhaolin@hrbb.com.cn
 * @version 
 * @date 2015年5月29日
 *
 * logs: 1. 
 */
public class AccessPrivilege implements Serializable{
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	
	/**
	 * 配置权限结合
	 */
	private Set<String> assignedPrivilege = Sets.newHashSet();
	
	/**
	 * 追加系统权限
	 * @param ap
	 */
	public void addPrivilege(String ap){
		if(ap==null || ap.trim().length()==0) return;
		
		if(!assignedPrivilege.contains(ap.trim())){
			assignedPrivilege.add(ap.trim());
		}
	}
	
	/**
	 * 是否拥有指定权限，多个权限以都号分割
	 * @param aps
	 * @return
	 */
	public boolean hasAnyPrivilege(String aps){
		if(aps == null || aps.trim().length()==0) return false;
		
		String[] arrayAPs = aps.split(";");
		for(String ap: arrayAPs){
			if(ap == null || ap.trim().length()==0) continue;
			
			if(assignedPrivilege.contains(ap.trim())){
				return true;
			}
		}
		
		return false;
	}
	
	public String toString(){
		return assignedPrivilege.toString();
	}
}
