/**
 * 
 */
package com.hrbb.loan.pos.entity.listener.impl;

import com.hrbb.loan.pos.entity.event.EventException;
import com.hrbb.loan.pos.entity.event.POSEvent;
import com.hrbb.loan.pos.entity.listener.POSListener;

/**
 * <p>Title: NtfListener.java </p>
 * <p>Description:  </p>
 * <p>Copyright: Copyright (C) 2015 Hrbb Ltd. Co.</p> 
 *     
 * @author linzhaolin@hrbb.com.cn
 * @version 
 * @date Aug 30, 2015
 *
 * logs: 1. 
 */
public class NtfListener implements POSListener {

	/* (non-Javadoc)
	 * @see com.hrbb.loan.pos.entity.listener.POSListener#handleEvent(com.hrbb.loan.pos.entity.event.POSEvent)
	 */
	@Override
	public void handleEvent(POSEvent event) throws EventException {
		event.execute();

	}

	/* (non-Javadoc)
	 * @see com.hrbb.loan.pos.entity.listener.POSListener#getType()
	 */
	@Override
	public int getType() {
		return POSListener.监听事件类型_异步通知;
	}

}
