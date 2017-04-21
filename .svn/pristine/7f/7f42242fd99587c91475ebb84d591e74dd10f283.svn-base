/**
 * 
 */
package com.hrbb.loan.pos.entity.event.cab;

/**
 * <p>Title: MailCab.java </p>
 * <p>Description:  </p>
 * <p>Copyright: Copyright (C) 2015 Hrbb Ltd. Co.</p> 
 *     
 * @author linzhaolin@hrbb.com.cn
 * @version 
 * @date Sep 4, 2015
 *
 * logs: 1. 
 */
public class MailCab extends BaseCab {
	
	public static final int  邮件通知_复审3待处理申请通知 = 1;
	public static final int  邮件通知_还款申请受理通知 = 2;
//	public static final int  邮件通知_复审3待处理申请通知 = 1;
//	public static final int  邮件通知_复审3待处理申请通知 = 1;
//	public static final int  邮件通知_复审3待处理申请通知 = 1;
	
	private MailCab(int type){
		this.setType(type);
	}
	
	public static MailCab newMail(int type){
		return new MailCab(type);
	}
}
