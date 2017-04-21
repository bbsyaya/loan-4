/**
 * 
 */
package com.hrbb.loan.quartz.mail;

import com.hrbb.loan.pos.factory.handler.IHandler;
import com.hrbb.loan.quartz.AbsQuartzJob;

/**
 * <p>Title: AbsMailNotifyJob.java </p>
 * <p>Description:  </p>
 * <p>Copyright: Copyright (C) 2015 Hrbb Ltd. Co.</p> 
 *     
 * @author linzhaolin@hrbb.com.cn
 * @version 
 * @date Sep 4, 2015
 *
 * logs: 1. 
 */
public abstract class AbsMailNotifyJob extends AbsQuartzJob {
	
	/* (non-Javadoc)
	 * @see com.hrbb.loan.quartz.AbsQuartzJob#intiJob()
	 */
	@Override
	protected boolean initJob() throws Exception {
		if(assignHandlers()==null || assignHandlers().length==0) {
			logger.error("邮件发送任务["+this.getJobName()+"]未指定执行class");
			return false;
		}
		return true;
	}

	/* (non-Javadoc)
	 * @see com.hrbb.loan.quartz.AbsQuartzJob#processJob()
	 */
	@Override
	protected boolean processJob() throws Exception {
		for(int clz=0;clz<assignHandlers().length;clz++){
			String className = assignHandlers()[clz];
			try {
				IHandler handler = (IHandler)Class.forName(className).newInstance();
				if(handler.execute()){
					logger.info("邮件发送任务["+handler.getName()+"]执行成功!");
				}else{
					logger.warn("邮件发送任务["+handler.getName()+"]执行失败!");
				}
				
			} catch (InstantiationException | IllegalAccessException
					| ClassNotFoundException e) {
				logger.error("执行mail处理任务["+className+"]初始化失败!",e);
				continue;
			}
		}
		return true;
	}

	/* (non-Javadoc)
	 * @see com.hrbb.loan.quartz.AbsQuartzJob#postJob()
	 */
	@Override
	protected boolean postJob() throws Exception {
		
		return true;
	}
	
	abstract protected String[] assignHandlers();

}
