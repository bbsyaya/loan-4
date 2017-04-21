/**
 * 
 */
package com.hrbb.loan.pos.biz.bean;

import java.util.Map;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import com.google.common.collect.Maps;
import com.hrbb.sh.framework.HServiceException;

/**
 * <p>Title: AbsInternalService.java </p>
 * <p>Description:  </p>
 * <p>Copyright: Copyright (C) 2015 Hrbb Ltd. Co.</p> 
 *     
 * @author linzhaolin@hrbb.com.cn
 * @version 
 * @date 2015年7月27日
 *
 * logs: 1. 
 */
public abstract class AbsInternalService implements HInternalService {
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;

	protected Logger logger = LoggerFactory.getLogger(this.getClass());
	
	protected Map<String,Object> rspResult = Maps.newHashMap();
	
	public boolean execute() throws Exception {
		try {
			if(!initService()) return false;
		} catch (HServiceException e) {
			logger.error("服务初始化失败!",e);
			return false;
		}
		
		try {
			if(!processService()) return false;
		} catch (HServiceException e) {
			logger.error("服务执行失败!",e);
			return false;
		}
		
		return true;
	}
	
	public boolean executeForPeanut(String fileName, byte[] bytes) throws Exception{
		try {
			if(!initService()) return false;
		} catch (HServiceException e) {
			logger.error("服务初始化失败!",e);
			return false;
		}
		
		try {
			if(!processService(fileName, bytes)) return false;
		} catch (HServiceException e) {
			logger.error("服务执行失败!",e);
			return false;
		}
		return true;
	}

	/* (non-Javadoc)
	 * @see com.hrbb.loan.pos.biz.bean.HInternalService#getRspResult()
	 */
	@Override
	public Map<String, Object> getRspResult() {
		return rspResult;
	}
	
	abstract public boolean initService() throws HServiceException;
	
	abstract public boolean processService() throws HServiceException;
	
	abstract public boolean processService(String fileName, byte[] bytes) throws HServiceException;

}
