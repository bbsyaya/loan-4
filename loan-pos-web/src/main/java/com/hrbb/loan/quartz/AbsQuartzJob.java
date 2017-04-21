/**
 * 
 */
package com.hrbb.loan.quartz;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

/**
 * <p>Title: AbsQuartzJob.java </p>
 * <p>Description:  </p>
 * <p>Copyright: Copyright (C) 2015 Hrbb Ltd. Co.</p> 
 *     
 * @author linzhaolin@hrbb.com.cn
 * @version 
 * @date Aug 30, 2015
 *
 * logs: 1. 
 */
public abstract class AbsQuartzJob implements IQuartzJob{
	
	protected static final String 任务执行状态_成功 = "1";
	protected static final String 任务执行状态_失败 = "9";
	
	protected Logger logger = LoggerFactory.getLogger(this.getClass());
	
	public void execute(){
		try{
			if(!initJob()){
				return;
			}
		}catch(Exception e){
			logger.error("定时任务初始化失败!",e);
			return;
		}
		
		try{
			if(!processJob()){
				return;
			}
		}catch(Exception e){
			logger.error("定时任务执行失败!",e);
			return;
		}
		
		try{
			if(!postJob()){
				return;
			}
		}catch(Exception e){
			logger.error("定时任务手续处理失败!",e);
			return;
		}
		
	}
	
	abstract protected boolean initJob() throws Exception;
	
	abstract protected boolean processJob() throws Exception;
	
	abstract protected boolean postJob() throws Exception;
}
