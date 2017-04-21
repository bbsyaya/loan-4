/**
 * 
 */
package com.hrbb.loan.quartz.mail;

import org.springframework.stereotype.Component;

import com.hrbb.loan.pos.factory.SysConfigFactory;

/**
 * <p>Title: ApprovalMailNotify.java </p>
 * <p>Description:  </p>
 * <p>Copyright: Copyright (C) 2015 Hrbb Ltd. Co.</p> 
 *     
 * @author linzhaolin@hrbb.com.cn
 * @version 
 * @date Sep 5, 2015
 *
 * logs: 1. 
 */
@Component("approvalMailNotify")
public class ApprovalMailNotify extends AbsMailNotifyJob {

	/* (non-Javadoc)
	 * @see com.hrbb.loan.quartz.IQuartzJob#getJobName()
	 */
	@Override
	public String getJobName() {
		return "当日审批结果通知";
	}

	/* (non-Javadoc)
	 * @see com.hrbb.loan.quartz.mail.AbsMailNotifyJob#assignHandlers()
	 */
	@Override
	protected String[] assignHandlers() {
		String hdlr = SysConfigFactory.getInstance().getService("mailService").getGroup("approvalNotify").getPropertyValue("handlers");
		String[] handlers = hdlr.split(",", -1);
		return handlers;
	}

}
