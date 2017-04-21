/**
 * 
 */
package com.hrbb.loan.pos.dao.impl;

import java.util.List;
import java.util.Map;

import org.mybatis.spring.support.SqlSessionDaoSupport;
import org.springframework.stereotype.Repository;

import com.hrbb.loan.pos.dao.IStatisticsExecuteDao;

/**
* <p>Title: StatisticsExecuteDaoImpl.java </p>
* <p>Description:  </p>
* <p>Copyright: Copyright (C) 2015 Hrbb Ltd. Co.</p> 
*     
* @author linzhaolin@hrbb.com.cn
* @version 
* @date 2015-4-16
*
* logs: 1. 
*/
@Repository("statisticsExecuteDao")
public class StatisticsExecuteDaoImpl extends SqlSessionDaoSupport implements
		IStatisticsExecuteDao {
	
	/* (non-Javadoc)
	 * @see com.hrbb.loan.pos.dao.IStatisticsExecuteDao#selectOne(java.util.Map)
	 */
	@Override
	public Map<String, Object> selectOne(Map<String, Object> reqMap) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public List<Map<String, Object>> selectTodoCallingTasks(
			Map<String, Object> reqMap) {
		// TODO Auto-generated method stub
		return getSqlSession().selectList("StatisticsMapper.selectCallingTasks", reqMap);
	}

	@Override
	public List<Map<String, Object>> selectTodoReviews(
			Map<String, Object> reqMap) {
		// TODO Auto-generated method stub
		return getSqlSession().selectList("StatisticsMapper.selectTodoReviews", reqMap);
	}

	@Override
	public List<Map<String, Object>> selectTodoIssues(Map<String, Object> reqMap) {
		// TODO Auto-generated method stub
		return getSqlSession().selectList("StatisticsMapper.selectTodoIssues", reqMap);
	}

	@Override
	public List<Map<String, Object>> selectDailyEntries(
			Map<String, Object> reqMap) {
		// TODO Auto-generated method stub
		return getSqlSession().selectList("StatisticsMapper.selectDailyEntries", reqMap);
	}

	@Override
	public List<Map<String, Object>> selectChannelEntries(
			Map<String, Object> reqMap) {
		// TODO Auto-generated method stub
		return getSqlSession().selectList("StatisticsMapper.selectChannelEntries", reqMap);
	}

	@Override
	public List<Map<String, Object>> selectDailyExecutes(
			Map<String, Object> reqMap) {
		// TODO Auto-generated method stub
		return getSqlSession().selectList("StatisticsMapper.selectDailyExecutes", reqMap);
	}

	@Override
	public List<Map<String, Object>> queryTaskTips1(Map<String, Object> reqMap) {
		// TODO Auto-generated method stub
		return getSqlSession().selectList("StatisticsMapper.queryTaskTips1", reqMap);
	}

	@Override
	public int queryTaskTips2(Map<String, Object> reqMap) {
		// TODO Auto-generated method stub
		return getSqlSession().selectOne("StatisticsMapper.queryTaskTips2", reqMap);
	}

	@Override
	public List<Map<String, Object>> queryTaskTips3(Map<String, Object> reqMap) {
		// TODO Auto-generated method stub
		return getSqlSession().selectList("StatisticsMapper.queryTaskTips3", reqMap);
	}

	@Override
	public List<Map<String, Object>> queryTaskTips4(Map<String, Object> reqMap) {
		// TODO Auto-generated method stub
		return getSqlSession().selectList("StatisticsMapper.queryTaskTips4", reqMap);
	}

	@Override
	public List<Map<String, Object>> queryTaskTips5(Map<String, Object> reqMap) {
		// TODO Auto-generated method stub
		return getSqlSession().selectList("StatisticsMapper.queryTaskTips5", reqMap);
	}

	@Override
	public List<Map<String, Object>> queryTaskTips6(Map<String, Object> reqMap) {
		// TODO Auto-generated method stub
		return getSqlSession().selectList("StatisticsMapper.queryTaskTips6", reqMap);
	}

	@Override
	public List<Map<String, Object>> queryTaskTips7(Map<String, Object> reqMap) {
		// TODO Auto-generated method stub
		return getSqlSession().selectList("StatisticsMapper.queryTaskTips7", reqMap);
	}

	@Override
	public List<Map<String, Object>> queryTaskTips8(Map<String, Object> reqMap) {
		// TODO Auto-generated method stub
		return getSqlSession().selectList("StatisticsMapper.queryTaskTips8", reqMap);
	}

	@Override
	public List<Map<String, Object>> queryTaskTips9(Map<String, Object> reqMap) {
		// TODO Auto-generated method stub
		return getSqlSession().selectList("StatisticsMapper.queryTaskTips9", reqMap);
	}
	
}


