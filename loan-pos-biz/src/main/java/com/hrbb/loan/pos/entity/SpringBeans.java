package com.hrbb.loan.pos.entity;

import org.apache.log4j.Logger;
import org.springframework.beans.BeansException;
import org.springframework.context.ApplicationContext;
import org.springframework.context.ApplicationContextAware;

/**
 * <p>Title: SpringBeans.java </p>
 * <p>Description:  </p>
 * <p>Copyright: Copyright (C) 2015 Hrbb Ltd. Co.</p> 
 *     
 * @author linzhaolin@hrbb.com.cn
 * @version 
 * @date 2015年7月8日
 *
 * logs: 1. 
 */
public class SpringBeans implements ApplicationContextAware{
	private static Logger logger = Logger.getLogger(SpringBeans.class);
	
	private static ApplicationContext applicationContext = null;
	
	@Override
	public void setApplicationContext(ApplicationContext applicationContext)
			throws BeansException {
		if(SpringBeans.applicationContext == null){ 
			SpringBeans.applicationContext  = applicationContext; 

			logger.info("-------------------------------------------------------------------"); 
			logger.info("========ApplicationContext配置成功,在普通类可以通过调用SpringBeans.=========="); 
			logger.info("-------------------------------------------------------------------"); 
		} 
	}

	public static ApplicationContext getApplicationContext() {
		return applicationContext;
	}
	
	public static Object getBean(String name) {
		return getApplicationContext().getBean(name);
	}
}
