/**
 * 
 */
package com.hrbb.loan.pos.factory;

import java.util.Properties;

/**
 * <p>Title: PropertyGroup.java </p>
 * <p>Description:  </p>
 * <p>Copyright: Copyright (C) 2015 Hrbb Ltd. Co.</p> 
 *     
 * @author linzhaolin@hrbb.com.cn
 * @version 
 * @date Sep 8, 2015
 *
 * logs: 1. 
 */
public class PropertyGroup {
	private String name = "";
	private Properties properties = new Properties();
	
	public PropertyGroup(String name){
		this.name = name;
	}
	
	public void addProperty(String key, String value){
		if(key!=null) key = key.trim();
		value = value==null?"":value.trim();
		
		properties.setProperty(key, value);
	}
	
	public String getPropertyValue(String key){
		if(properties.containsKey(key)){
			return properties.getProperty(key);
		}
		return null;
	}
	
	public String getName() {
		return name;
	}
	
	public String toString(){
		return "name="+getName()+" |props="+properties.toString();
	}
}
