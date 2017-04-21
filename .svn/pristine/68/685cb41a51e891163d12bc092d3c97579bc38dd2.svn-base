/**
 * 
 */
package com.hrbb.loan.pos.factory.handler;

import java.text.ParseException;
import java.util.Date;
import java.util.List;
import java.util.Map;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import com.google.common.collect.Lists;
import com.google.common.collect.Maps;
import com.hrbb.loan.pos.dao.entity.TApplyNotify;
import com.hrbb.loan.pos.dao.entity.TBdInstitution;
import com.hrbb.loan.pos.dao.entity.TMailNotification;
import com.hrbb.loan.pos.entity.SpringBeans;
import com.hrbb.loan.pos.factory.PropertyGroup;
import com.hrbb.loan.pos.factory.SysConfigFactory;
import com.hrbb.loan.pos.service.BDManagementService;
import com.hrbb.loan.pos.service.TMailNotificationService;
import com.hrbb.loan.pos.service.TNotifyAssistantService;
import com.hrbb.loan.pos.service.TemplateService;
import com.hrbb.sh.framework.util.DateUtil;

/**
 * <p>Title: ApprovalSplitedNotifyHandler.java </p>
 * <p>Description:  </p>
 * <p>Copyright: Copyright (C) 2015 Hrbb Ltd. Co.</p> 
 *     
 * @author linzhaolin@hrbb.com.cn
 * @version 
 * @date Oct 21, 2015
 *
 * logs: 1. 
 */
public class ApprovalSplitedNotifyHandler implements IHandler {
	
	protected Logger logger = LoggerFactory.getLogger(this.getClass());
	
	private TemplateService templateService;
	
	private TMailNotificationService tMailNotificationService;
	
	private BDManagementService BDManagementService;
	
	private TNotifyAssistantService tNotifyAssistantService;
	
	private PropertyGroup propertyGroup;
	
	private Date[] range = new Date[2];

	/* (non-Javadoc)
	 * @see com.hrbb.loan.pos.factory.handler.IHandler#execute()
	 */
	@Override
	public boolean execute() throws Exception {
		propertyGroup = SysConfigFactory.getInstance().getService("mailService").getGroup("approvalNotify");
		
		try{
			if(!initHanler()){
				logger.warn("初始化邮件处理对象["+this.getName()+"]失败!");
				return false;
			}
		}catch(Exception e){
			logger.error("初始化邮件处理对象["+this.getName()+"]失败!",e);
			return false;
		}
		
		try{
			if(!executeHanler()){
				logger.warn("执行邮件处理对象["+this.getName()+"]失败!");
				return false;
			}
		}catch(Exception e){
			logger.error("执行邮件处理对象["+this.getName()+"]失败!",e);
			return false;
		}
		
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
	protected boolean initHanler(){
		//-----确定统计区间
		try {
			String today = DateUtil.getToday();
//			String today = "2015-09-30";
			String yesterday = DateUtil.getRelativeDate(today, 0, 0, -1);
			String time = DateUtil.getNowTime("HH:mm");
			
			//审批结果延后2小时通知,举例8点-10点审批的业务在12点批次通知
			if(time.compareTo("08:00") > 0 && time.compareTo("10:00") <= 0){	//8~10 统计 18pm~20pm
				range[0] = DateUtil.parse2Date(today+" 18:00:00", DateUtil.HRRB_LONG_DATETIME_FORMAT);
				range[1] = DateUtil.parse2Date(today+" 20:00:00", DateUtil.HRRB_LONG_DATETIME_FORMAT);
			}else if(time.compareTo("10:00") > 0 && time.compareTo("12:00") <= 0){
				range[0] = DateUtil.parse2Date(yesterday+" 20:00:00", DateUtil.HRRB_LONG_DATETIME_FORMAT);
				range[1] = DateUtil.parse2Date(today+" 08:00:00", DateUtil.HRRB_LONG_DATETIME_FORMAT);
			}else if(time.compareTo("12:00") > 0 && time.compareTo("14:00") <= 0){
				range[0] = DateUtil.parse2Date(today+" 08:00:00", DateUtil.HRRB_LONG_DATETIME_FORMAT);
				range[1] = DateUtil.parse2Date(today+" 10:00:00", DateUtil.HRRB_LONG_DATETIME_FORMAT);
			}else if(time.compareTo("14:00") > 0 && time.compareTo("16:00") <= 0){
				range[0] = DateUtil.parse2Date(today+" 10:00:00", DateUtil.HRRB_LONG_DATETIME_FORMAT);
				range[1] = DateUtil.parse2Date(today+" 12:00:00", DateUtil.HRRB_LONG_DATETIME_FORMAT);
			}else if(time.compareTo("16:00") > 0 && time.compareTo("18:00") <= 0){
				range[0] = DateUtil.parse2Date(today+" 12:00:00", DateUtil.HRRB_LONG_DATETIME_FORMAT);
				range[1] = DateUtil.parse2Date(today+" 14:00:00", DateUtil.HRRB_LONG_DATETIME_FORMAT);
			}else if(time.compareTo("18:00") > 0 && time.compareTo("20:00") <= 0){
				range[0] = DateUtil.parse2Date(today+" 14:00:00", DateUtil.HRRB_LONG_DATETIME_FORMAT);
				range[1] = DateUtil.parse2Date(today+" 16:00:00", DateUtil.HRRB_LONG_DATETIME_FORMAT);
			}else{
				range[0] = DateUtil.parse2Date(today+" 16:00:00", DateUtil.HRRB_LONG_DATETIME_FORMAT);
				range[1] = DateUtil.parse2Date(today+" 18:00:00", DateUtil.HRRB_LONG_DATETIME_FORMAT);
			}
		} catch (ParseException e) {
			logger.error("初始化每日审批结果通知失败!",e);
			return false;
		}
		
		/*get globle Service*/
		templateService = (TemplateService)SpringBeans.getBean("templateService");
		tMailNotificationService = (TMailNotificationService)SpringBeans.getBean("tMailNotificationService");
		BDManagementService = (BDManagementService)SpringBeans.getBean("BDManagementService");
		tNotifyAssistantService = (TNotifyAssistantService)SpringBeans.getBean("tNotifyAssistantService");
		
		return true;
	}
	
	/**
	 * handler的任务处理操作
	 * @return
	 */
	protected boolean executeHanler(){
		List<TApplyNotify> handleObj = Lists.newArrayList();
		String handleChannel = "";
		
		//--------get records
		Map<String, Object> request = Maps.newHashMap();
		request.put("beginTime", range[0]);
		request.put("endTime", range[1]);
		List<TApplyNotify> records = tNotifyAssistantService.selectTimelyApproval(request);
		
		for(TApplyNotify record: records){
			String channel = record.getChannel();
			
			if(handleChannel.length() == 0){		//首次初始化赋值
				handleChannel = channel;
			}
			
			if(!handleChannel.equals(channel)){		//渠道变换时结束编辑邮件
				//完成邮件
				execCompose(handleChannel, handleObj);
				
				//clear list result
				handleObj.clear();
				//renew channel
				handleChannel = channel;
			}
			
			//iterate compose email
			handleObj.add(record);
		}
		
		if(handleObj.size()>0){
			//完成邮件
			execCompose(handleChannel, handleObj);
		}
		
		return true;
	}
	
	private boolean execCompose(String handleChannel, List<TApplyNotify> handleObj){
		TBdInstitution bdi = BDManagementService.selectByAlias(handleChannel);
		if(bdi==null || bdi.getEmail()==null || bdi.getEmail().trim().length()==0){
			logger.info("渠道 ["+handleChannel+"] 没有设定通知邮件地址,但依然会生成通知邮件.");
//			handleChannel = channel;
//			continue;
		}
		
		//finish compose email
		Map<String, Object> vars = Maps.newHashMap();
		vars.put("userName", "尊敬的"+handleChannel+"同事：");
		vars.put("today", DateUtil.getToday());
		vars.put("startTime", DateUtil.formatDate(range[0], "HH:mm MM-dd"));
		vars.put("endTime", DateUtil.formatDate(range[1], "HH:mm MM-dd"));
		vars.put("applyList", handleObj);
		vars.put("totalNum", handleObj.size());
		
		/*bizObject*/
		try{
			TMailNotification mf = new TMailNotification();
			mf.setMailSubject(getSubject());
			mf.setMailTo((bdi==null || bdi.getEmail()==null || bdi.getEmail().trim().length()==0)?"linzhaolin@hrbb.com.cn":bdi.getEmail());
			mf.setMailCc((bdi==null || bdi.getMailCc()==null || bdi.getMailCc().trim().length()==0)?"":bdi.getMailCc());
			mf.setMailBcc((bdi==null || bdi.getMailBcc()==null || bdi.getMailBcc().trim().length()==0)?"":bdi.getMailBcc());
			mf.setTemplateId(getTemplateId());
			mf.setCreateTime(new Date());
			mf.setMailContent(getTemplateText(vars, getTemplateId()));
			tMailNotificationService.insertSelective(mf);
		}catch(Exception ex){
			logger.error("生成邮件通知失败，渠道="+handleChannel,ex);
		}
		
		return true;
	}
	
	public String getMailCc() {
		return propertyGroup.getPropertyValue("mailCc");
	}
	
	public String getSubject() {
		String subject = "申请审批情况通知 "+DateUtil.formatDate(range[0], "HH:mm MM-dd")+" ~ "+DateUtil.formatDate(range[1], "HH:mm MM-dd");
		return subject;
	}
	
	public String getTemplateId() {
		return "notify/mail/timelyAppoval.ftl";
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
			logger.debug("htmlText="+htmlText);
		} catch (Exception e) {
			logger.error("生成邮件正文失败!",e);
		}
		return htmlText;  
	} 
	
	/**
	 * handler的后续处理操作
	 * @return
	 */
	protected boolean postHanler(){
		return false;
	}

	/* (non-Javadoc)
	 * @see com.hrbb.loan.pos.factory.handler.IHandler#getName()
	 */
	@Override
	public String getName() {
		return "审批结果通知";
	}

}
