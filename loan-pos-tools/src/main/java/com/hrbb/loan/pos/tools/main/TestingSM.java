/**
 * 
 *	哈尔滨银行
 * Copyright (c) 2007-2015 HRBB,Inc.All Rights Reserved.
 */
package com.hrbb.loan.pos.tools.main;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

import com.hrbb.sh.framework.SendSMMessageService;


/**
 * 
 * @author byp
 * @version $Id: BankMaxWithhold.java, v 0.1 2015年3月19日 上午10:01:32 byp Exp $
 */
public class TestingSM {

    private final static Logger logger = LoggerFactory.getLogger(TestingSM.class);
    
    /**
     * 启动入口  
     * @param args
     */
    public static void main(String[] args) {
        logger.info(">>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>发送任务启动...");
        String mobile = "13701945757";
        String content = "哈尔滨银行互联网金融事业部!";
        if (args.length >=2){
            mobile = args[0];
            content = args[1];
        }            
        
        try {
            //TODO 发送           
            ApplicationContext contex = new ClassPathXmlApplicationContext(  
                    "remote-client.xml");  
      
            // 获得客户端的Hessian代理工厂bean  
            SendSMMessageService service = (SendSMMessageService) contex.getBean("sendSM");  

            boolean result = service.sendSM(mobile,content);
            logger.info(">>>>>>发送任务结果:"+result);

            logger.info(">>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>发送任务结束!");
        } catch (Exception e) {
            logger.error(e.getMessage(), (Throwable)e);
            return;
        } finally {
        }
    }
}
