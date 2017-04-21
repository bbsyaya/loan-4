/**
 * 
 */
package com.hrbb.loan.quartz;

/**
 * <p>Title: IQuartzJob.java </p>
 * <p>Description:  </p>
 * <p>Copyright: Copyright (C) 2015 Hrbb Ltd. Co.</p> 
 *     
 * @author linzhaolin@hrbb.com.cn
 * @version 
 * @date Aug 30, 2015
 *
 * logs: 1. 
 */
public interface IQuartzJob {
	
	public void execute();
	
	public String getJobName();
}
