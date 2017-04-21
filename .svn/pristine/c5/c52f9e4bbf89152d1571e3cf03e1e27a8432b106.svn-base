package com.hrbb.activity.action;

import org.springframework.beans.BeansException;
import org.springframework.beans.factory.BeanFactory;
import org.springframework.beans.factory.BeanFactoryAware;
import org.springframework.stereotype.Component;


@Component
public class BeanAware implements BeanFactoryAware{
	
	private BeanFactory beanFactory;

	@Override
	public void setBeanFactory(BeanFactory beanFactory) throws BeansException {
		this.beanFactory = beanFactory; 
		
	}
	
	public  Object getBeanByName(String name){
		return beanFactory.getBean(name);
	}

}
