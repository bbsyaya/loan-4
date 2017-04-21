package com.hrbb.loan.quartz;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import com.hrbb.loan.pos.biz.backstage.inter.ISendMessageBiz;
import com.hrbb.loan.pos.factory.SysConfigFactory;
import com.hrbb.loan.pos.util.StringUtil;

@Component("sendMessageTask")
public class SendMessageTask {
    private static final Logger LOG = LoggerFactory.getLogger(SendMessageTask.class);
    @Autowired
    private ISendMessageBiz     sendMessageBiz;

    public void execute() {
        
        try {
            String switchFlag = SysConfigFactory.getInstance().getService("quartzSwitchService")
                .getPropertyValue("messageSwitch");
            if (StringUtil.isEmpty(switchFlag) || "false".equals(switchFlag.toLowerCase())) {
                LOG.info("消息推送开关为false,不推送消息");
                return;
            }
            //推送消息
            sendMessageBiz.sendMessage();
        } catch (Exception e) {
            LOG.error("消息推送异常:" + e.getMessage());
        }
    }
}
