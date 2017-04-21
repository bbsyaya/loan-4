/**
 * 
 */
package com.hrbb.loan.pos.service.impl;

import java.util.Map;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.ui.freemarker.FreeMarkerTemplateUtils;
import org.springframework.web.servlet.view.freemarker.FreeMarkerConfigurer;

import com.hrbb.loan.pos.service.TemplateService;

import freemarker.template.Template;

/**
 * <p>Title: TemplateServiceImpl.java </p>
 * <p>Description:  </p>
 * <p>Copyright: Copyright (C) 2015 Hrbb Ltd. Co.</p> 
 *     
 * @author linzhaolin@hrbb.com.cn
 * @version 
 * @date Sep 5, 2015
 *
 * logs: 1. 
 */
@Service("templateService")
public class TemplateServiceImpl implements TemplateService {
	
	private final Logger logger = LoggerFactory.getLogger(this.getClass());

	private static FreeMarkerConfigurer freeMarkerConfigurer;

//	private Configuration freeMarkerConfiguration;

	public void setFreeMarkerConfigurer(FreeMarkerConfigurer freeMarkerConfigurer) {
		TemplateServiceImpl.freeMarkerConfigurer = freeMarkerConfigurer;
	}
//
//	public void setFreeMarkerConfiguration(Configuration freeMarkerConfiguration) {
//		this.freeMarkerConfiguration = freeMarkerConfiguration;
//	}

	/* (non-Javadoc)
	 * @see com.hrbb.loan.pos.service.TemplateService#getContent(java.lang.String, java.util.Map)
	 */
	@Override
	public String getContent(String templateName, Map<String, Object> model) {
		try {
			Template t = freeMarkerConfigurer.getConfiguration().getTemplate(templateName);
			return FreeMarkerTemplateUtils.processTemplateIntoString(t, model);
			// 通过指定模板名获取FreeMarker模板实例
		} catch (Exception ex) {
//			ex.printStackTrace();
			logger.error("1.模板转换失败!",ex);
//			try {
//				Template t = freeMarkerConfiguration.getTemplate(templateName);
//				return FreeMarkerTemplateUtils.processTemplateIntoString(t, model);
//			} catch (Exception e) {
////				e.printStackTrace();
////				logger.equals(e.getMessage());
//				logger.error("2.模板转换失败!",ex);
//			}
		}

		return null;
	}

}
