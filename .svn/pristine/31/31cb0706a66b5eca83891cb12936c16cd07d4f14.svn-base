/**
 * 
 */
package com.hrbb.loan.pos.service.impl;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Service;

import com.hrbb.loan.pos.dao.IStatisticsExecuteDao;
import com.hrbb.loan.pos.service.LoanPosBusinessCodeService;
import com.hrbb.loan.pos.service.StatisticsExecuteService;

/**
* <p>Title: StatisticsExecuteServiceImpl.java </p>
* <p>Description:  </p>
* <p>Copyright: Copyright (C) 2015 Hrbb Ltd. Co.</p> 
*     
* @author linzhaolin@hrbb.com.cn
* @version 
* @date 2015-4-16
*
* logs: 1. 
*/
@Service("statisticsExecuteService")
public class StatisticsExecuteServiceImpl implements StatisticsExecuteService {
	
	@Autowired
	@Qualifier("statisticsExecuteDao")
	private IStatisticsExecuteDao dao;
	
	@Autowired
	private LoanPosBusinessCodeService codeService;

	@Override
	public Map<String, Object> getSeletiveOne(Map<String, Object> reqMap) {
		// TODO Auto-generated method stub
		return dao.selectOne(reqMap);
	}
	
	@Override
	public List<Map<String, Object>> selectTodoCallingTasks(
			Map<String, Object> reqMap) {
		List<Map<String, Object>> list = dao.selectTodoCallingTasks(reqMap);
		for(Map<String, Object> data: list){
			String calllingType = (String) data.get("callingType");
			String typeName = codeService.getItemNameByNo("CallingType", calllingType);
			data.put("TypeName", typeName);
		}
		
		return list;
	}

	@Override
	public List<Map<String, Object>> selectTodoReviews(
			Map<String, Object> reqMap) {
		List<Map<String, Object>> list = dao.selectTodoReviews(reqMap);
		for(Map<String, Object> data: list){
			String applyStatus = (String) data.get("applyStatus");
			String applyStatusName = "";
			if(applyStatus!=null && applyStatus.equals("xx")){
				applyStatusName = "未认领";
			}else{
				applyStatusName = codeService.getItemNameByNo("ApplyStatus", applyStatus);
			}
			data.put("ApplyStatusName", applyStatusName);
		}
		
		return list;
	}

	@Override
	public List<Map<String, Object>> selectTodoIssues(Map<String, Object> reqMap) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public Map<String, List<Map<String, Object>>> selectDailyStatistic(
			Map<String, Object> reqMap) {
		/*每日进件数*/
		List<Map<String, Object>> list1 = dao.selectDailyEntries(reqMap);
		/*每日处理情况*/
		List<Map<String, Object>> list2 = dao.selectDailyExecutes(reqMap);
		
		Map<String, List<Map<String, Object>>> result = new HashMap<String, List<Map<String, Object>>>();
		result.put("entries", list1);
		result.put("executes", list2);
		
		return result;
	}

	@Override
	public List<Map<String, Object>> selectChannelEntries(
			Map<String, Object> reqMap) {
		// TODO Auto-generated method stub
		List<Map<String, Object>> list = dao.selectChannelEntries(reqMap);
		for(Map<String, Object> data: list){
			String channel = (String) data.get("channel");
			String channelName = codeService.getItemNameByNo("BizChannel", channel);
			data.put("channelName", channelName);
		}
		
		return list;
	}
	
	@Override
	public List<Map<String, Object>> queryTaskTips1(Map<String, Object> reqMap) {
		return dao.queryTaskTips1(reqMap);
	}

	@Override
	public int queryTaskTips2(Map<String, Object> reqMap) {
		// TODO Auto-generated method stub
		return dao.queryTaskTips2(reqMap);
	}

	@Override
	public List<Map<String, Object>> queryTaskTips3(Map<String, Object> reqMap) {
		// TODO Auto-generated method stub
		return dao.queryTaskTips3(reqMap);
	}

	@Override
	public List<Map<String, Object>> queryTaskTips4(Map<String, Object> reqMap) {
		// TODO Auto-generated method stub
		return dao.queryTaskTips4(reqMap);
	}

	@Override
	public List<Map<String, Object>> queryTaskTips5(Map<String, Object> reqMap) {
		// TODO Auto-generated method stub
		return dao.queryTaskTips5(reqMap);
	}

	@Override
	public List<Map<String, Object>> queryTaskTips6(Map<String, Object> reqMap) {
		// TODO Auto-generated method stub
		return dao.queryTaskTips6(reqMap);
	}

	@Override
	public List<Map<String, Object>> queryTaskTips7(Map<String, Object> reqMap) {
		// TODO Auto-generated method stub
		return dao.queryTaskTips7(reqMap);
	}

	@Override
	public List<Map<String, Object>> queryTaskTips8(Map<String, Object> reqMap) {
		// TODO Auto-generated method stub
		return dao.queryTaskTips8(reqMap);
	}

	@Override
	public List<Map<String, Object>> queryTaskTips9(Map<String, Object> reqMap) {
		// TODO Auto-generated method stub
		return dao.queryTaskTips9(reqMap);
	}
	
}
