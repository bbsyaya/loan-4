/**
 * 
 */
package com.hrbb.loan.pos.entity.event.impl;

import java.util.EventObject;

import com.hrbb.loan.pos.entity.event.EventException;
import com.hrbb.loan.pos.entity.event.ListenerEventAction;
import com.hrbb.loan.pos.entity.event.POSEvent;
import com.hrbb.loan.pos.entity.event.POSEventsSource;
import com.hrbb.loan.pos.entity.event.cab.MailCab;

/**
 * <p>Title: MailEvent.java </p>
 * <p>Description:  </p>
 * <p>Copyright: Copyright (C) 2015 Hrbb Ltd. Co.</p> 
 *     
 * @author linzhaolin@hrbb.com.cn
 * @version 
 * @date Aug 30, 2015
 *
 * logs: 1. 
 */
public class MailEvent extends EventObject implements POSEvent{

	/**
	 * 
	 */
	private static final long serialVersionUID = 9147157247802604167L;
	
	private POSEventsSource source = null;
	
	public MailEvent(Object source) {
		super(source);
		this.source = (POSEventsSource)source;
	}

	@Override
	public void execute() throws EventException {
		ListenerEventAction notify = null;
		int type = (int)source.getAttribute(POSEvent.监听事件名称_邮件通知);
		switch(type){
			case MailCab.邮件通知_还款申请受理通知:
				String repaymentNo = (String)source.getAttribute("repaymentNo");
				notify = new NotifyRepaymentApply(repaymentNo);
				break;
			case MailCab.邮件通知_复审3待处理申请通知:
				String loanId = (String)source.getAttribute("loanId");
				notify = new NotifyLevel3Approval(loanId);
				break;
			default:
				notify = new NullEventAction();
		}
		
		notify.execute();
		
	}

}
