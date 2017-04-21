/**
 * 
 */
package com.hrbb.loan.pos.entity.event.cab;

import java.math.BigDecimal;
import java.util.Date;
import java.util.Map;

import com.alibaba.fastjson.JSONObject;
import com.google.common.collect.Maps;
import com.hrbb.loan.pos.util.DateUtil;

/**
 * <p>Title: BaseCab.java </p>
 * <p>Description:  </p>
 * <p>Copyright: Copyright (C) 2015 Hrbb Ltd. Co.</p> 
 *     
 * @author linzhaolin@hrbb.com.cn
 * @version 
 * @date Aug 30, 2015
 *
 * logs: 1. 
 */
public abstract class BaseCab implements ICab {
	
	private int type;
	
	private Map<String,String> attr = Maps.newHashMap();
	
	public void setType(int type) {
		this.type = type;
	}

	public String getType() {
		return String.valueOf(type);
	}
	
	public void addAttribute(String key, String value){
		attr.put(key, value);
	}
	
	public void addAttribute(String key, Date value){
		addAttribute(key, value, DateUtil.HRRB_SHORT_DATETIME_FORMAT);
	}
	
	public void addAttribute(String key, Date value, String format){
		attr.put(key, DateUtil.formatDate(value,format));
	}
	
	public void addAttribute(String key, BigDecimal value){
		attr.put(key, String.valueOf(value));
	}
	
	public void addAttribute(String key, int value){
		attr.put(key, String.valueOf(value));
	}
	
	public void addAttribute(String key, double value){
		attr.put(key, String.valueOf(value));
	}
	
	public String getAttribute(String key){
		return attr.get(key);
	}
	
	public String toMessageString(){
		String msgStr = JSONObject.toJSONString(attr);
		return msgStr.substring(1, msgStr.length()-1);		//取{xxxx}中的xxxx
	}
	
	public String toJSONString(){
		return JSONObject.toJSONString(attr);
	}
	
	public String toString(){
		return "type="+getType()+" |MAP="+attr.toString();
	}

}
