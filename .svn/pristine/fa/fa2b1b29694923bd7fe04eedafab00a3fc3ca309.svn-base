/**
 * 
 */
package com.hrbb.loan.pos.entity.event.cab;

import java.math.BigDecimal;
import java.util.Date;

/**
 * <p>Title: ICab.java </p>
 * <p>Description:  </p>
 * <p>Copyright: Copyright (C) 2015 Hrbb Ltd. Co.</p> 
 *     
 * @author linzhaolin@hrbb.com.cn
 * @version 
 * @date Aug 30, 2015
 *
 * logs: 1. 
 */
public interface ICab {
	
	public String getType();

	public void addAttribute(String key, String value);
	
	public void addAttribute(String key, Date value);
	
	public void addAttribute(String key, Date value, String format);
	
	public void addAttribute(String key, BigDecimal value);
	
	public void addAttribute(String key, int value);
	
	public void addAttribute(String key, double value);
	
	public String getAttribute(String key);
	
	public String toMessageString();
}
