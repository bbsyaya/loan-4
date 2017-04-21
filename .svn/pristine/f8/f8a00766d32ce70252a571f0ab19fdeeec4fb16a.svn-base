/**
 * 
 */
package com.hrbb.loan.pos.service;

import java.util.List;
import java.util.Map;

/**
* <p>Title: StatisticsExecuteService.java </p>
* <p>Description:  </p>
* <p>Copyright: Copyright (C) 2015 Hrbb Ltd. Co.</p> 
*     
* @author linzhaolin@hrbb.com.cn
* @version 
* @date 2015-4-16
*
* logs: 1. 
*/
public interface StatisticsExecuteService {

	public List<Map<String, Object>> selectTodoCallingTasks(Map<String, Object> reqMap);
	
	public List<Map<String, Object>> selectTodoReviews(Map<String, Object> reqMap);
	
	public List<Map<String, Object>> selectTodoIssues(Map<String, Object> reqMap);
	
	public Map<String, List<Map<String, Object>>> selectDailyStatistic(Map<String, Object> reqMap);
	
	public Map<String, Object> getSeletiveOne(Map<String, Object> reqMap);
	
	public List<Map<String, Object>> selectChannelEntries(Map<String, Object> reqMap);
	
	/**
	 * 待认领审批的业务申请
	 * @param reqMap
	 * @return
	 */
	public List<Map<String, Object>> queryTaskTips1(Map<String, Object> reqMap);
	/**
	 * 未确认审批结果
	 * @param reqMap
	 * @return
	 */
	public int queryTaskTips2(Map<String, Object> reqMap);
	/**
	 * 待处理外呼任务
	 * @param reqMap
	 * @return
	 */
	public List<Map<String, Object>> queryTaskTips3(Map<String, Object> reqMap);
	/**
	 * 贷款在一周内到期
	 * @param reqMap
	 * @return
	 */
	public List<Map<String, Object>> queryTaskTips4(Map<String, Object> reqMap);
	/**
	 * 待处理的业务受理
	 * @param reqMap
	 * @return
	 */
	public List<Map<String, Object>> queryTaskTips5(Map<String, Object> reqMap);
	/**
	 * 已签约未生效协议
	 * @param reqMap
	 * @return
	 */
	public List<Map<String, Object>> queryTaskTips6(Map<String, Object> reqMap);
	/**
	 * 待审核用款申请
	 * @param reqMap
	 * @return
	 */
	public List<Map<String, Object>> queryTaskTips7(Map<String, Object> reqMap);
	
	public List<Map<String, Object>> queryTaskTips8(Map<String, Object> reqMap);
	
	/**
	 * 待发送用款申请
	 * @param reqMap
	 * @return
	 */
	public List<Map<String, Object>> queryTaskTips9(Map<String, Object> reqMap);
}
