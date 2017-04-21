/**
 * 
 */
package com.hrbb.loan.pos.factory;

import java.util.Map;
import java.util.Properties;

import com.google.common.collect.Maps;

/**
 * <p>Title: ConfigService.java </p>
 * <p>Description:  </p>
 * <p>Copyright: Copyright (C) 2015 Hrbb Ltd. Co.</p> 
 *     
 * @author linzhaolin@hrbb.com.cn
 * @version 
 * @date Aug 26, 2015
 *
 * logs: 1. 
 */
public class ConfigService {
	private String name = "";
	private String label = "";
	private Properties properties = new Properties();
	private Map<String,PropertyGroup> groups = Maps.newHashMap();
	
	public ConfigService(String name, String label){
		this.name = name;
		this.label = label;
	}
	
	public void addGroup(PropertyGroup group){
		groups.put(group.getName(), group);
	}
	
	public PropertyGroup getGroup(String name){
		return groups.get(name);
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

	public String getLabel() {
		return label;
	}
	
	public String toString(){
		return "name="+getName()+" |label="+getLabel()+" |props="+properties.toString();
	}
}
