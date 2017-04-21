package com.hrbb.loan.jms.listener;


import javax.jms.JMSException;
import javax.jms.Message;
import javax.jms.MessageListener;
import javax.jms.ObjectMessage;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Service;

import com.hrbb.loan.channel.sms.SmsProcesser;
import com.hrbb.loan.pos.dao.entity.TSmsMessage;
import com.hrbb.loan.pos.service.SendSmsMessageService;

/**
 * 短信接收Listener
 * 
 * @author huojunbo
 */

@Service("smsMessageListener")
public class SmsMessageListener implements MessageListener {

    private static final Logger   logger = LoggerFactory.getLogger(SmsMessageListener.class);

    @Autowired
    @Qualifier("smsProcesser")
    private SmsProcesser          smsProcesser;

    @Autowired
    private SendSmsMessageService sendSmsMessageService;

    @Override
    public void onMessage(Message message) {

        if (message instanceof ObjectMessage) {
            ObjectMessage Msg = ((ObjectMessage) message);
            TSmsMessage smsMessage;
            try {
                smsMessage = (TSmsMessage) (Msg.getObject());
                logger.info("server端收到消息：[" + smsMessage.getMobile() + "--->"
                            + smsMessage.getSendContent() + "]");
                boolean res = sendSms(smsMessage);
                logger.info("短信发送结果:[{}]",res);
                if (!res) {
                    saveSmsToDB(smsMessage);
                }
            } catch (JMSException e) {
                logger.error("短信消息接收异常", e);
            }
        }

    }

    /**
     * 
     * 存库，定时发送
     * @return
     */
    public void saveSmsToDB(TSmsMessage msg) {
        sendSmsMessageService.sendSmsMessage(msg);
    }

    /**
     * 
     * 实时发送
     * @return
     */
    public boolean sendSms(TSmsMessage msg) {
        if (smsProcesser.sendSmsNoTemplate(msg.getMobile(), msg.getSendContent())) {
            logger.debug("短信发送成功：{}", msg);
            //将短信记录插入短信历史表中
            sendSmsMessageService.insertSmsMessageHist(msg.getTempId(), msg.getMobile(),
                msg.getSendContent());
            return true;
        } else {
            logger.debug("发送失败,存库、待重发");
            return false;
        }
    }

}
