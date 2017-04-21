/**
 * 
 */
package com.hrbb.loan.pos.biz.bean;

import java.util.Map;

/**
 * <p>Title: HInternalService.java </p>
 * <p>Description:  </p>
 * <p>Copyright: Copyright (C) 2015 Hrbb Ltd. Co.</p> 
 *     
 * @author linzhaolin@hrbb.com.cn
 * @version 
 * @date 2015年7月27日
 *
 * logs: 1. 
 */
public interface HInternalService extends java.io.Serializable{
	/**
	 * 执行接口
	 * @return
	 */
	public boolean execute() throws Exception;
	
	/**
	 * 接口返回内容
	 * @return
	 */
	public Map<String, Object> getRspResult();
}
