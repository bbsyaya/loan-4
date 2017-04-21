/**
 * 
 *	哈尔滨银行
 * Copyright (c) 2007-2015 HRBB,Inc.All Rights Reserved.
 */
package com.hrbb.loan.pos.tools.main;

import java.io.StringWriter;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Calendar;
import java.util.Date;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.apache.commons.lang.CharSet;
import org.apache.ibatis.session.SqlSession;
import org.apache.ibatis.session.SqlSessionFactory;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;
import org.springframework.context.support.FileSystemXmlApplicationContext;
import org.springframework.remoting.caucho.HessianProxyFactoryBean;

import com.hrbb.loan.pos.dao.entity.TBankProperties;
import com.hrbb.pos.loan.tools.database.LoanDatabase;
import com.hrbb.sh.framework.FrontierProvider;
import com.hrbb.sh.framework.HRequest;
import com.hrbb.sh.framework.HResponse;
import com.hrbb.sh.framework.HService;
import com.hrbb.sh.framework.util.BankUtil;

import freemarker.template.Configuration;
import freemarker.template.Template;

/**
 * 
 * @author byp
 * @version $Id: BankMaxWithhold.java, v 0.1 2015年3月19日 上午10:01:32 byp Exp $
 */
public class BankMaxWithhold {

    private final static Logger logger = LoggerFactory.getLogger(BankMaxWithhold.class);
    private static final String SPRINT_FILEPATH_CONTEXT = "/spring/frontier-context.xml";  
    private static SimpleDateFormat dateFormat = new SimpleDateFormat("yyyyMMdd");
    private static SimpleDateFormat dayTimeFormat = new SimpleDateFormat("HHmmss");
    
    
    // 持久层会话工厂
    private static SqlSessionFactory sqlSessionFactory = null;
    static {
           sqlSessionFactory = LoanDatabase.getSqlSessionFactory();
    }
    
    /**
     * 启动入口  
     * @param args
     */
    public static void main(String[] args) {
        logger.info(">>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>发送任务启动...");
        
        // 读取配置
        SqlSession sqlSession = sqlSessionFactory.openSession();
        try {
            //判断是否连通？
            List msgList = sqlSession.selectList("TBankPropertiesMapper.selectBy","withhold");
            
            HRequest req = new HRequest();
            //head info?
            //TODO 
            req.setBizType("HB15");
            //req.setChannelType("");
            Date date = new Date();
            req.setRequestTime(date);
            
            StringBuffer buffer = new StringBuffer();
            Map<String,Object> propMap = new HashMap<String, Object>();
            req.setProperties(propMap);
            propMap.put("transCode", "HB15");
            propMap.put("totalNum", msgList.size());
            propMap.put("retNum", msgList.size());
            propMap.put("srcReqDate", dateFormat.format(date));
            propMap.put("srcReqTime", dayTimeFormat.format(date));
            propMap.put("srcReqId", "1");
            propMap.put("channelId", "002");
            
            buffer.append(msgList.size()).append('|').append(msgList.size());
            
            List<Map<String,Object>> list = new ArrayList<Map<String,Object>>();
            propMap.put("LIST", list);            
            for (Object msg : msgList) {
                TBankProperties message = (TBankProperties)msg;
                if(message.getPropValue()==null || Integer.valueOf(message.getPropValue())==0){
                    continue;
                }
                HashMap<String, Object> oneRec = new HashMap<String, Object>();
                oneRec.put("bankno", message.getBankId());
                oneRec.put("bankname",message.getBankName());
                oneRec.put("maxcapi", message.getPropValue());
                list.add(oneRec);
                
                buffer.append('|').append(message.getBankId()).append('|').append(message.getBankName())
                      .append('|').append(message.getPropValue());
                
                logger.info(">>>>. send out [bankname:"+message.getBankName()+",maxcapi:"+message.getPropValue()+"]");
            }
            
            propMap.put("mac", BankUtil.getMD5(buffer.toString(), "GBK"));
            
            //TODO 发送           
            ApplicationContext contex = new ClassPathXmlApplicationContext(  
                    "remote-client.xml");  
      
            // 获得客户端的Hessian代理工厂bean  
            HService service = (HService) contex.getBean("toUM");  

            HResponse resp = service.serve(req);
            logger.info(">>>>>>发送任务结果:"+resp.getRespCode()+"-"+resp.getRespMessage());
            if (logger.isDebugEnabled()) {
                logger.debug(resp.toString());
            }
            logger.info(">>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>发送任务结束!");
            
        } catch (Exception e) {
            logger.error(e.getMessage(), (Throwable)e);
            return;
        } finally {
            sqlSession.close();
        }
    }
}
