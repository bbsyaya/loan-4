package com.hrbb.loan.jms.sender;

import org.apache.activemq.command.ActiveMQQueue;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jms.core.JmsTemplate;

import com.hrbb.loan.pos.dao.entity.TSmsMessage;
import com.hrbb.loan.pos.service.SendSmsMessageService;

public class SmsMessageSender {

    private ActiveMQQueue destination;
    
    private JmsTemplate jmsTemplate;
    
    @Autowired
    private SendSmsMessageService sendSmsMessageService;
    

    public JmsTemplate getJmsTemplate() {
        return jmsTemplate;
    }

    public void setJmsTemplate(JmsTemplate jmsTemplate) {
        this.jmsTemplate = jmsTemplate;
    }
    
    public ActiveMQQueue getDestination() {
        return destination;
    }

    public void setDestination(ActiveMQQueue destination) {
        this.destination = destination;
    }
    
    
  //发送消息
    public void sendMessage(TSmsMessage smsMessage){
        
        if(smsMessage.isRealtime()){
            //发送MQ消息
            this.jmsTemplate.convertAndSend(destination, smsMessage);
        }else{
            //存库,定时发送
            sendSmsMessageService.sendSmsMessage(smsMessage);
        }
    }
    
}
