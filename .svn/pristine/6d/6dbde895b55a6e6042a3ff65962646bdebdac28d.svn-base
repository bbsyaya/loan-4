package com.hrbb.loan.pos.biz.backstage.inter.impl;


import org.springframework.stereotype.Component;

import com.hrbb.loan.pos.biz.backstage.inter.IPosEventsBiz;
import com.hrbb.loan.pos.entity.event.POSEvent;
import com.hrbb.loan.pos.entity.event.POSEventsSource;
import com.hrbb.loan.pos.entity.event.cab.MailCab;
import com.hrbb.loan.pos.entity.listener.impl.MailListener;

@Component("posEventsBiz")
public class PosEventsBizImpl implements IPosEventsBiz{

	@Override
	public void doPosEvents(String loanid) throws Exception {
		POSEventsSource source = new POSEventsSource();
        source.setAttribute(POSEvent.监听事件名称_邮件通知, MailCab.邮件通知_复审3待处理申请通知);
		source.setAttribute("loanId", loanid);
        source.addListener(new MailListener());
		source.notifyEvent();
		
	}

}
