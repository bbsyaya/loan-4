/**
 * 
 */
package com.hrbb.loan.pos.factory.handler;

import java.util.Date;
import java.util.Map;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import com.hrbb.loan.pos.dao.entity.TMailNotification;
import com.hrbb.loan.pos.entity.SpringBeans;
import com.hrbb.loan.pos.entity.event.impl.ITemplatedMail;
import com.hrbb.loan.pos.factory.PropertyGroup;
import com.hrbb.loan.pos.factory.SysConfigFactory;
import com.hrbb.loan.pos.service.TMailNotificationService;
import com.hrbb.loan.pos.service.TemplateService;

/**
 * <p>Title: AbsMailHandler.java </p>
 * <p>Description:  </p>
 * <p>Copyright: Copyright (C) 2015 Hrbb Ltd. Co.</p> 
 *     
 * @author linzhaolin@hrbb.com.cn
 * @version 
 * @date Sep 4, 2015
 *
 * logs: 1. 
 */
public abstract class AbsMailHandler implements IHandler,ITemplatedMail {

	protected Logger logger = LoggerFactory.getLogger(this.getClass());
	
	protected String htmlText;
	
	private TemplateService templateService;
	
	private PropertyGroup propertyGroup;
	
	/* (non-Javadoc)
	 * @see com.hrbb.loan.pos.factory.handler.IHandler#execute()
	 */
	@Override
	public boolean execute() throws Exception {
		/**/
		propertyGroup = SysConfigFactory.getInstance().getService("mailService").getGroup(groupName());
		
		try{
			if(!initHanler()){
				logger.warn("初始化邮件处理对象["+this.getName()+"]失败!");
				return false;
			}
		}catch(Exception e){
			logger.error("初始化邮件处理对象["+this.getName()+"]失败!",e);
			return false;
		}
//		
//		try{
//			if(!executeHanler()){
//				logger.warn("执行邮件处理对象["+this.getName()+"]失败!");
//				return false;
//			}
//		}catch(Exception e){
//			logger.error("执行邮件处理对象["+this.getName()+"]失败!",e);
//			return false;
//		}
		
		try{
			if(!postHanler()){
				logger.warn("邮件服务["+this.getName()+"]后续处理失败!");
				return false;
			}
		}catch(Exception e){
			logger.error("邮件服务["+this.getName()+"]后续处理失败!",e);
			return false;
		}
		
		return true;
	}
	
	/**
	 * handler的初始化操作
	 * @return
	 */
	abstract protected boolean initHanler();
	/**
	 * handler处理主体
	 * @return
	 */
//	abstract protected boolean executeHanler();
	
	/**
	 * 所属的property-group名称
	 * @return
	 */
	abstract protected String groupName();
	
	/**
	 * handler主体处理完毕后的后续处理
	 * @return
	 */
	protected boolean postHanler(){
		/*getservice*/
		TMailNotificationService tMailNotificationService = (TMailNotificationService)SpringBeans.getBean("tMailNotificationService");
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
			return false;
		}
		return true;
	}
	
	@Override
	public String getMailTo() {
		return propertyGroup.getPropertyValue("mailTo");
	}

	@Override
	public String getMailCc() {
		return propertyGroup.getPropertyValue("mailCc");
	}
	
	@Override
	public String sayHello() {
		String propVal = propertyGroup.getPropertyValue("sayHello");
		return (propVal==null || propVal.trim().length()==0)?"小伙伴":propVal.trim();
	}
	
	/** 
	 * 生成html模板字符串 
	 * @param root 存储动态数据的map 
	 * @return 
	 */  
	protected String getTemplateText(Map<String,Object> root,String templateName){  
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
