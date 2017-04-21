/**
 * 
 */
package com.hrbb.loan.pos.entity.event.impl;

import java.util.EventObject;
import java.util.Map;

import com.hrbb.loan.pos.dao.entity.TPaymentApply;
import com.hrbb.loan.pos.entity.event.EventException;
import com.hrbb.loan.pos.entity.event.ListenerEventAction;
import com.hrbb.loan.pos.entity.event.POSEvent;
import com.hrbb.loan.pos.entity.event.POSEventsSource;

/**
 * <p>Title: CallingTaskEvent.java </p>
 * <p>Description:  </p>
 * <p>Copyright: Copyright (C) 2015 Hrbb Ltd. Co.</p> 
 *     
 * @author linzhaolin@hrbb.com.cn
 * @version 
 * @date 2015年7月8日
 *
 * logs: 1. 
 */
public class CallingTaskEvent extends EventObject implements POSEvent {
	
	private POSEventsSource source = null;
	
	private static final long serialVersionUID = 1L;
	
	public CallingTaskEvent(Object source) {
		super(source);
		this.source = (POSEventsSource)source;
	}

	/* (non-Javadoc)
	 * @see com.hrbb.loan.entity.event.POSEvent#execute()
	 */
	@Override
	public void execute() throws EventException {
		
		ListenerEventAction task = null;
		int type = (int)source.getAttribute(POSEvent.监听事件名称_外呼任务);
		switch(type){
			case ListenerEventAction.监听事件类型_外呼任务_用款审核拒绝:
				TPaymentApply paymentApply = (TPaymentApply)source.getAttribute("paymentApply");
				Map<String,Object> appr = (Map<String,Object>)source.getAttribute("paymentApproval");
				
				task = new IssueRejectTask(paymentApply,appr);
				break;
			default:
				task = new NullEventAction();
				//
		}
		
		task.execute();

	}

}
