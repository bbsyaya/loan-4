/**
 * 
 */
package com.hrbb.loan.pos.entity.event.impl;

import java.util.EventObject;

import com.hrbb.loan.pos.entity.event.EventException;
import com.hrbb.loan.pos.entity.event.ListenerEventAction;
import com.hrbb.loan.pos.entity.event.POSEvent;
import com.hrbb.loan.pos.entity.event.POSEventsSource;
import com.hrbb.loan.pos.entity.event.cab.NotifyCab;

/**
 * <p>Title: NtfEnent.java </p>
 * <p>Description:  </p>
 * <p>Copyright: Copyright (C) 2015 Hrbb Ltd. Co.</p> 
 *     
 * @author linzhaolin@hrbb.com.cn
 * @version 
 * @date Aug 30, 2015
 *
 * logs: 1. 
 */
public class NtfEvent  extends EventObject implements POSEvent{

	/**
	 * 
	 */
	private static final long serialVersionUID = -6845707497105958861L;
	
	private POSEventsSource source = null;
	
	public NtfEvent(Object source) {
		super(source);
		this.source = (POSEventsSource)source;
	}

	@Override
	public void execute() throws EventException {
		ListenerEventAction notify = null;
		int type = (int)source.getAttribute(POSEvent.监听事件名称_异步通知);
		switch(type){
			case NotifyCab.异步通知_申请变更同步:
				String loanId = (String)source.getAttribute("loanId");
				notify = new NotifyApplyChange(loanId);
				break;
			default:
				notify = new NullEventAction();
		}
		
		notify.execute();
		
	}

}
