/**
 * 
 */
package com.hrbb.loan.quartz.mail;

import com.hrbb.loan.pos.factory.SysConfigFactory;

/**
 * <p>Title: GeneralMailNotify.java </p>
 * <p>Description:  </p>
 * <p>Copyright: Copyright (C) 2015 Hrbb Ltd. Co.</p> 
 *     
 * @author linzhaolin@hrbb.com.cn
 * @version 
 * @date Sep 4, 2015
 *
 * logs: 1. 
 */
public class GeneralMailNotify extends AbsMailNotifyJob {

	/* (non-Javadoc)
	 * @see com.hrbb.loan.quartz.IQuartzJob#getJobName()
	 */
	@Override
	public String getJobName() {
		return "通用邮件通知";
	}

	/* (non-Javadoc)
	 * @see com.hrbb.loan.quartz.mail.AbsMailNotifyJob#assignHandlers()
	 */
	@Override
	protected String[] assignHandlers() {
		String vhdlrs = SysConfigFactory.getInstance().getService("mailService").getPropertyValue("handlers.generalMailNotify");
		if(vhdlrs==null || vhdlrs.length()==0) return null;
		
		String[] handlers = vhdlrs.split(vhdlrs, -1);
		
		return handlers;
	}

}
