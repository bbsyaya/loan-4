/**
 * 
 */
package com.hrbb.loan.pos.service;

import java.util.Date;
import java.util.List;
import java.util.Map;

import com.hrbb.loan.pos.dao.entity.TRepaymentPlan;

/**
 * <p>Title: TRepaymentPlanService.java </p>
 * <p>Description:  </p>
 * <p>Copyright: Copyright (C) 2015 Hrbb Ltd. Co.</p> 
 *     
 * @author linzhaolin@hrbb.com.cn
 * @version 
 * @date 2015年7月30日
 *
 * logs: 1. 
 */
public interface TRepaymentPlanService {
	
	public int insertSelective(TRepaymentPlan record);
	
	int insert(TRepaymentPlan record);
	
	int updateSelective(TRepaymentPlan record);
	
	/**
	 * 获取最近一期的还款计划
	 * 
	 * @param receiptId
	 * @return
	 */
	public TRepaymentPlan getRecentlyPlan(String receiptId);
	/**
	 * 获取一笔借据下的整个还款计划表
	 * @param receiptId
	 * @return
	 */
	public List<TRepaymentPlan> getAllPlan(String receiptId);
	
	public List<TRepaymentPlan> getAllPlan(String receiptId,Date dateFrom);
	
	   /**
     * 获取最近一期的还款计划
     * 
     * @param receiptId
     * @return
     */
    public TRepaymentPlan getPlanByReceiptIdAndPeriod(String receiptId, String period);
    
    /**
     * 查询指定借据的还款计划
     * 
     * @param receiptId
     * @return
     */
    public List<TRepaymentPlan> getAllPlanByReceiptId(String receiptId);
    
    /**
     * 删除指定借据还款计划
     * 
     * @param receiptId
     * @return
     */
    int removeRepaymentPlan(String receiptId);
    
    /**
     * 获取该借据下还款数
     * @param receiptId 借据编号
     */
    Long getPlanCountByReceiptId(String receiptId);
    
    /**
     * @param reqMap contains receiptId,startPage,pageSize
     * @return 查询该借据编号下分页返回的还款计划记录
     */
    List<TRepaymentPlan> getPlansByReceiptIdInPage(Map<String, Object> reqMap);
    
    /**
     * 等额本息提前还款
     * 
     * @param receiptId
     * @return
     */
    Map<String,Object> getBatchRecentRepayPlan(String receiptId);
}
