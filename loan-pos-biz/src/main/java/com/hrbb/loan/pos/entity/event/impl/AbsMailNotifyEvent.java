/**
 * 
 */
package com.hrbb.loan.pos.entity.event.impl;

import java.util.Date;
import java.util.Map;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import com.hrbb.loan.pos.dao.entity.TMailNotification;
import com.hrbb.loan.pos.entity.SpringBeans;
import com.hrbb.loan.pos.entity.event.EventException;
import com.hrbb.loan.pos.entity.event.ListenerEventAction;
import com.hrbb.loan.pos.service.TMailNotificationService;
import com.hrbb.loan.pos.service.TemplateService;

/**
 * <p>Title: AbsMailNotifyEvent.java </p>
 * <p>Description:  </p>
 * <p>Copyright: Copyright (C) 2015 Hrbb Ltd. Co.</p> 
 *     
 * @author linzhaolin@hrbb.com.cn
 * @version 
 * @date Sep 5, 2015
 *
 * logs: 1. 
 */
public abstract class AbsMailNotifyEvent implements ListenerEventAction,ITemplatedMail {
	
	protected Logger logger = LoggerFactory.getLogger(this.getClass());
	
	private TMailNotificationService tMailNotificationService;
	
	private TemplateService templateService;
	
	/* (non-Javadoc)
	 * @see com.hrbb.loan.pos.entity.event.ListenerEventAction#execute()
	 */
	@Override
	public void execute() throws EventException {
		/*getservice*/
		tMailNotificationService = (TMailNotificationService)SpringBeans.getBean("tMailNotificationService");
		templateService = (TemplateService)SpringBeans.getBean("templateService");
		
		/*bizObject*/
		try{
			TMailNotification mf = new TMailNotification();
			mf.setMailSubject(getSubject());
			mf.setMailTo(getMailTo());
			mf.setMailCc(getMailCc());
			mf.setTemplateId(getTemplateId());
			mf.setCreateTime(new Date());
			mf.setMailContent(composeMail());
			tMailNotificationService.insertSelective(mf);
		}catch(Exception ex){
			logger.error("生成邮件通知失败",ex);
		}
	}
//	
//	abstract protected String getSubject();
//	
//	abstract protected String getMailTo();
//	
//	abstract protected String getMailCc();
//	
//	abstract protected String composeMail();
//	
//	abstract protected String appendAttachments();
//	
//	abstract protected String getTemplateId();
	
	public String sayHello(){
		return "小伙伴";
	}
	
	/** 
	 * 生成html模板字符串 
	 * @param root 存储动态数据的map 
	 * @return 
	 */  
	protected String getMailText(Map<String,Object> root,String templateName){  
		String htmlText = "";
		try {
			// 通过指定模板名获取FreeMarker模板实例
			htmlText = templateService.getContent(templateName, root);
		} catch (Exception e) {
			logger.error("生成邮件正文失败!",e);
		}
		return htmlText;  
	} 

}
