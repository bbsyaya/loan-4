/**
 * 
 */
package com.hrbb.loan.pos.entity.track;

import java.util.Map;

/**
 * <p>Title: BizObjectTracker.java </p>
 * <p>Description:  </p>
 * <p>Copyright: Copyright (C) 2015 Hrbb Ltd. Co.</p> 
 *     
 * @author linzhaolin@hrbb.com.cn
 * @version 
 * @date 2015年8月16日
 *
 * logs: 1. 
 */
public interface BizObjectTracker {
	
	public Map<String,TrackField> getTrakeIssues();
	
	public void addTrack(String id, String from,String to);
	
	public void addTrack(String id, Object from,Object to);
	
	/**
	 * 业务对象更新并记录更新痕迹
	 * @param vars
	 * @param userName
	 * @return
	 */
	public boolean updateWithTrack(Map<String,Object> vars, String userName);
	
	/**
	 * 默认以系统自动处理的更新
	 * @param vars
	 * @return
	 */
	public boolean updateWithTrack(Map<String,Object> vars);
	
	public String getBizNo();
	
	public String getBizPhase();
	/**
	 * 更新排除项
	 * @param fields  以逗号分隔
	 */
	public void excludeFields(String fields);
}
