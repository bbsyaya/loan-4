/**
 * 
 */
package com.hrbb.loan.pos.entity.event.cab;

/**
 * <p>Title: MessageCab.java </p>
 * <p>Description: 消息推送的通用对象 </p>
 * <p>Copyright: Copyright (C) 2015 Hrbb Ltd. Co.</p> 
 *     
 * @author linzhaolin@hrbb.com.cn
 * @version 
 * @date 2015年8月5日
 *
 * logs: 1. 
 */
public class MessageCab extends BaseCab{
	
	public static final int  消息推送_授信审批通过 = 1;
	public static final int  消息推送_授信审批拒绝 = 2;
	public static final int  消息推送_补件通知 = 3;
	public static final int  消息推送_放款结果通知 = 5;
	public static final int  消息推送_协议状态调整 = 6;
	public static final int  消息推送_还款结果通知 = 7;
	public static final int  消息推送_到期还款提醒 = 8;
	public static final int  消息推送_逾期催收通知 = 9;
	public static final int  消息推送_审批结果失效 = 11;
	public static final int  消息推送_影像文件缺失通知 = 12;
	public static final int  消息推送_还款申请失效通知 = 13;
	
	private MessageCab(int type){
		this.setType(type);
	}
	
	public static MessageCab newMessage(int type){
		return new MessageCab(type);
	}
	
}
