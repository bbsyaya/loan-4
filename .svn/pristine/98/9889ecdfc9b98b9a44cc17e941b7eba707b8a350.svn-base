/**
 * 哈尔滨银行互联网金融事业部 ()
 * Copyright (c) 2015 Hrbbank Ltd. All Rights Reserved.
 */
package com.hrbb.loan.pos.tools.main;

import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.apache.ibatis.session.SqlSession;
import org.apache.ibatis.session.SqlSessionFactory;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;
import org.springframework.context.support.FileSystemXmlApplicationContext;

import com.hrbb.loan.pos.dao.entity.TMessage;
import com.hrbb.loan.pos.util.DateUtil;
import com.hrbb.pos.loan.tools.database.LoanDatabase;
import com.hrbb.sh.framework.FrontierProvider;
import com.hrbb.sh.framework.HRequest;
import com.hrbb.sh.framework.HResponse;
import com.hrbb.sh.framework.HService;
import com.hrbb.sh.framework.util.BankUtil;


/**
 * 对账任务线程启动入口.
 * 
 * @author byp
 * @since 2015年3月18日 上午9:49:36
 */
public class PosLoanMessagePush {
	
	// 日志对象.
	private final static Logger logger = LoggerFactory.getLogger(PosLoanMessagePush.class);
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
		    List msgList = sqlSession.selectList("TMessageMapper.selectAll");
		    logger.info(">>>>.Total number is : " + msgList.size());
		    for (Object msg : msgList) {
		        TMessage message = (TMessage)msg;
		        //一期只处理银商 portal 进件的 消息
		        if (!"UM".equals(message.getChannel()) || !"02".equals(message.getInChannelKind())){
		            logger.info(">>>>. CHANNEL is : " + message.getChannel());
		            continue;
		        }
		        HRequest req = new HRequest();
		        //header info
		        req.setBizType("HB13");
		        //req.setChannelType("");
	            Date date = new Date();
	            req.setRequestTime(date);
		        //TODO 
	            StringBuffer buffer = new StringBuffer();

	            Map<String,Object> propMap = new HashMap<String, Object>();
	            req.setProperties(propMap);
	            propMap.put("messagetype", message.getMessageType());
                propMap.put("messageinfo", message.getMessageInfo());
                propMap.put("messageaddi", message.getMessageAddi());
                propMap.put("custid", message.getCustId());
                propMap.put("loanId", message.getLoanId());
                propMap.put("contno", message.getContNo());
                propMap.put("listid", message.getListId());
                propMap.put("loanacno", message.getLoanAcNo());
                String dateStr = DateUtil.getCurrentTimePatterna();
                propMap.put("pushdate", dateStr);
                propMap.put("stdshno", message.getStdshNo());
                propMap.put("stdmerno", message.getStdMerNo());

                propMap.put("srcReqDate", dateFormat.format(date));
                propMap.put("srcReqTime", dayTimeFormat.format(date));
                propMap.put("srcReqId", "1");
                propMap.put("channelId", "002");
                
                buffer.append(message.getMessageType()).append('|').append(message.getMessageInfo()).append('|')
                      .append(message.getMessageAddi()).append('|').append(message.getCustId()).append('|')
                      .append(message.getLoanId()).append('|').append(message.getListId()).append('|')
                      .append(message.getLoanAcNo()).append('|').append(dateStr).append('|')
                      .append(message.getStdshNo()).append('|').append(message.getStdMerNo());
                propMap.put("mac", BankUtil.getMD5(buffer.toString(), "GBK"));
		        //发送
                //TODO
                ApplicationContext contex = new ClassPathXmlApplicationContext(  
                        "remote-client.xml");  
          
                // 获得客户端的Hessian代理工厂bean  
                HService service = (HService) contex.getBean("toUM");  
                HResponse resp = service.serve(req);
                logger.info(">>>>>>发送结果:"+resp.getRespCode()+"-"+resp.getRespMessage());
                if ("00000000".equals(resp.getProperties().get("RespCode")) ){
                    sqlSession.delete("TMessageMapper.deleteById", message.getId());
                    sqlSession.commit();
                    logger.info(">>>>>>发送成功，删除消息：id="+message.getId());
                }
                if (logger.isDebugEnabled()) {
                    logger.debug(resp.toString());
                }
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
