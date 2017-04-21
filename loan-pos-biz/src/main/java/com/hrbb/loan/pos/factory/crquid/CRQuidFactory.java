/**
 * 
 */
package com.hrbb.loan.pos.factory.crquid;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import com.hrbb.loan.pos.factory.SysConfigFactory;
import com.hrbb.loan.pos.util.DateUtil;

/**
 * <p>Title: CRQuidFactory.java </p>
 * <p>Description:  </p>
 * <p>Copyright: Copyright (C) 2015 Hrbb Ltd. Co.</p> 
 *     
 * @author linzhaolin@hrbb.com.cn
 * @version 
 * @date Oct 7, 2015
 *
 * logs: 1. 
 */
public class CRQuidFactory {
	
	private static int 单账号每分钟允许查询次数 = 6;
	
	private static Logger logger = LoggerFactory.getLogger(CRQuidFactory.class);
	
	private volatile static CRQuidFactory service = null;
	
	private ICRQuid[] queriers = null;		//查询对象
	
	private ICRQuid nullId = new NullQuid();
	
	private String ctrlMinite = null;	//受限所在分钟
	
	private int quidNum = 0;			//查询账户个数
	
	private int totalQueryTimes = 0;	//每分钟可查询总数
	
	private int availabeNum = 0;		//当前可用账户个数
	
	public ICRQuid getCRQuid(){
		String currMinite = DateUtil.getNowTime("yyyy-MM-dd HH:mm");
		if(!currMinite.equals(ctrlMinite)){
			availabeNum = totalQueryTimes;	//reset
			ctrlMinite = currMinite;
		}
		
		if(availabeNum>=0){
			int idx = availabeNum % quidNum;	//模除账户个数,作为获取账户的索引index
			availabeNum --;
			
			return queriers[idx];
		}
		
		nullId.accumulate();
		return nullId;
	}
	
	public static CRQuidFactory getInstance(){
		if(service == null){
			synchronized (CRQuidFactory.class){
				if(service == null){
					service = new CRQuidFactory();
				}
			}
		}
		return service;
	}
	
	private CRQuidFactory(){
		if(!SysConfigFactory.getInstance().hasService("CRService")) return;
		
		String uids = SysConfigFactory.getInstance().getService("CRService").getPropertyValue("uid");
//		String uids = "hlwjr-wsy,hlwjr-gjf,hlwjr-gxl";
		if(uids==null || uids.trim().length()==0){
			logger.error("征信查询账户未配置. 参见 sys-config-service.xml");
			return;
		}
		
		logger.debug("initialize Credit Reference Querier Factory begin ...");
		ctrlMinite = DateUtil.getNowTime("yyyy-MM-dd HH:mm");
		logger.debug("current date-time is "+ctrlMinite);
		
		String[] array = uids.split(",", -1);
		quidNum = array.length;
		totalQueryTimes = quidNum * 单账号每分钟允许查询次数 -1;
		availabeNum = totalQueryTimes;
		
		logger.debug("共有 " + quidNum + " 个可用的查询账户, 每分钟可查询 "+totalQueryTimes+" 次征信报告.");
		queriers = new ICRQuid[quidNum];
		
		for(int i=0; i<quidNum; i++){
			queriers[i] = new DefaultCRQuid(array[i]);
		}
		
	}
}
