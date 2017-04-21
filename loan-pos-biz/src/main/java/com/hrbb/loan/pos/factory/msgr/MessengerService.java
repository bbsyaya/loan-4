/**
 * 
 */
package com.hrbb.loan.pos.factory.msgr;

import com.hrbb.loan.pos.biz.bean.HInternalService;
import com.hrbb.loan.pos.dao.entity.TMessage;

/**
 * <p>Title: MessengerService.java </p>
 * <p>Description:  </p>
 * <p>Copyright: Copyright (C) 2015 Hrbb Ltd. Co.</p> 
 *     
 * @author linzhaolin@hrbb.com.cn
 * @version 
 * @date Aug 26, 2015
 *
 * logs: 1. 
 */
public interface MessengerService extends HInternalService {
	/**
	 * 渠道编号
	 * @return
	 */
	public String getChannel();
	
	/**
	 * 加密通道名称
	 * @return
	 */
	public String getEncryptedRander();
	
	/**
	 * 服务名称
	 * @return
	 */
	public String getTransCode();
	
	/**
	 * 处理消息报文内容
	 * @param message
	 * @return
	 */
	public void addMessage(TMessage message);
	
	/**
	 * 个性化用款申请编号
	 * @return
	 */
	public String getListId();
	
	/**
	 * 消息推送的url
	 * @return
	 */
	public String getUrl();
	
}
