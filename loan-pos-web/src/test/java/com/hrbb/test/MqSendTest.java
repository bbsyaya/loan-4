package com.hrbb.test;

import java.util.Date;

import org.junit.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.test.context.ContextConfiguration;

import com.hrbb.loan.jms.sender.SmsMessageSender;
import com.hrbb.loan.pos.dao.entity.TSmsMessage;
import com.hrbb.loan.pos.service.constants.SmsTypeContants;
import com.hrbb.sh.framework.HServiceException;
import com.hrbb.test.UnitTest;


@ContextConfiguration(locations = {
                                   "classpath:config/context/jms-context.xml"})
public class MqSendTest extends UnitTest {
	
	@Autowired
	@Qualifier("smsMessageSender")
    private SmsMessageSender smsMessageSender;

	@Test
	public void testServe() throws HServiceException {
	    
	    TSmsMessage message = new  TSmsMessage();
	    message.setMobile("13262923036");
	    message.setSendContent("asdasdasdasdasd");
	    message.setChannel("SM");
	    message.setNotifyType(SmsTypeContants.放款通知);
	    message.setCreateTime(new Date());
	    message.setRealtime(false);
	    smsMessageSender.sendMessage(message);
	}
}
