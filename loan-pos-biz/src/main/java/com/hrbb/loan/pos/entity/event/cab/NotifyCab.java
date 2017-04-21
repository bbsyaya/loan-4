/**
 * 
 */
package com.hrbb.loan.pos.entity.event.cab;

/**
 * <p>Title: NotificationCab.java </p>
 * <p>Description:  </p>
 * <p>Copyright: Copyright (C) 2015 Hrbb Ltd. Co.</p> 
 *     
 * @author linzhaolin@hrbb.com.cn
 * @version 
 * @date Aug 30, 2015
 *
 * logs: 1. 
 */
public class NotifyCab extends BaseCab{
	public static final int  异步通知_申请变更同步 = 1;
	
	private NotifyCab(int type){
		this.setType(type);
	}
	
	public static NotifyCab newNotify(int type){
		return new NotifyCab(type);
	}
}
