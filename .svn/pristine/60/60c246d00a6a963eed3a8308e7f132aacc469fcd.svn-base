/**
 * 
 */
package com.hrbb.loan.pos.entity.listener.impl;

import com.hrbb.loan.pos.entity.event.EventException;
import com.hrbb.loan.pos.entity.event.POSEvent;
import com.hrbb.loan.pos.entity.listener.POSListener;

/**
 * <p>Title: POSLinstener.java </p>
 * <p>Description:  </p>
 * <p>Copyright: Copyright (C) 2015 Hrbb Ltd. Co.</p> 
 *     
 * @author linzhaolin@hrbb.com.cn
 * @version 
 * @date 2015年7月8日
 *
 * logs: 1. 
 */
public class MsgListener implements POSListener {
	
	@Override
	public void handleEvent(POSEvent event) throws EventException {
		// TODO Auto-generated method stub
		event.execute();
	}

	@Override
	public int getType() {
		return POSListener.监听事件类型_消息推送;
	}

}
