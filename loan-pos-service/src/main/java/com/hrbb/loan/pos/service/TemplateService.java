/**
 * 
 */
package com.hrbb.loan.pos.service;

import java.util.Map;

/**
 * <p>Title: TemplateService.java </p>
 * <p>Description:  </p>
 * <p>Copyright: Copyright (C) 2015 Hrbb Ltd. Co.</p> 
 *     
 * @author linzhaolin@hrbb.com.cn
 * @version 
 * @date Sep 5, 2015
 *
 * logs: 1. 
 */
public interface TemplateService {
	
	public String getContent(String templateName, Map<String, Object> model);
}
