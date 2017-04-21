/**
 * 
 */
package com.hrbb.loan.pos.factory.crquid;

/**
 * <p>Title: ICRQuid.java </p>
 * <p>Description:  </p>
 * <p>Copyright: Copyright (C) 2015 Hrbb Ltd. Co.</p> 
 *     
 * @author linzhaolin@hrbb.com.cn
 * @version 
 * @date Oct 7, 2015
 *
 * logs: 1. 
 */
public interface ICRQuid {
	/**
	 * 查询用户ID编号
	 * @return
	 */
	public String getId();
	
	/**
	 * 获取新周期内的ID
	 * @return
	 */
	public String getIdAsRenew();
	
	/**
	 * 是否为用户空对象
	 * @return
	 */
	public boolean isNull();
	
	/**
	 * 当前的一分钟内调度次数
	 * @return
	 */
	public int getTimesInCurrentMinite();
	
	/**
	 * 追加调用次数
	 */
	public void accumulate();
	
	/**
	 * 重计计数器
	 */
	public void resetCumulate();
}
