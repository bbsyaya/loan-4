/**
 * 
 *	哈尔滨银行
 * Copyright (c) 2007-2015 HRBB,Inc.All Rights Reserved.
 */
package com.hrbb.loan.pos.dao.impl;

import java.util.List;
import java.util.Map;

import org.mybatis.spring.support.SqlSessionDaoSupport;
import org.springframework.stereotype.Repository;

import com.hrbb.loan.pos.dao.TCallingTaskDao;
import com.hrbb.loan.pos.dao.entity.TCallingTask;

/**
 * 
 * @author marco
 * @version $Id: TCallingTaskDaoImpl.java, v 0.1 2015-4-2 下午6:21:57 marco Exp $
 */
@Repository("tCallingTaskDao")
public class TCallingTaskDaoImpl extends SqlSessionDaoSupport implements TCallingTaskDao {

	/** 
	 * @see com.hrbb.loan.pos.dao.TCallingTaskDao#deleteByPrimaryKey(java.lang.String)
	 */
	@Override
	public int deleteByPrimaryKey(String taskNo) {
		return 0;
	}

	/** 
	 * @see com.hrbb.loan.pos.dao.TCallingTaskDao#insert(com.hrbb.loan.pos.dao.entity.TCallingTask)
	 */
	@Override
	public int insert(TCallingTask record) {
		return 0;
	}

	/** 
	 * @see com.hrbb.loan.pos.dao.TCallingTaskDao#insertSelective(com.hrbb.loan.pos.dao.entity.TCallingTask)
	 */
	@Override
	public int insertSelective(TCallingTask record) {
		return getSqlSession().insert("TCallingTaskMapper.insertSelective", record);
	}

	/** 
	 * @see com.hrbb.loan.pos.dao.TCallingTaskDao#selectByPrimaryKey(java.lang.String)
	 */
	@Override
	public TCallingTask selectByPrimaryKey(String taskNo) {
		return  (TCallingTask) getSqlSession().selectOne("TCallingTaskMapper.selectByPrimaryKey", taskNo);
	}

	/** 
	 * @see com.hrbb.loan.pos.dao.TCallingTaskDao#updateByPrimaryKeySelective(com.hrbb.loan.pos.dao.entity.TCallingTask)
	 */
	@Override
	public int updateByPrimaryKeySelective(TCallingTask record) {
		return 0;
	}

	/** 
	 * @see com.hrbb.loan.pos.dao.TCallingTaskDao#updateByPrimaryKey(com.hrbb.loan.pos.dao.entity.TCallingTask)
	 */
	@Override
	public int updateByPrimaryKey(TCallingTask record) {
		return 0;
	}


	@Override
	public List<Map<String, Object>> selectSelective(Map<String, Object> reqMap) {
		// TODO Auto-generated method stub
		return getSqlSession().selectList("TCallingTaskMapper.selectSelectiveForReview", reqMap);
	}
	@Override
	public long selectSelectiveForReviewCount(Map<String, Object> reqMap) {
		// TODO Auto-generated method stub
		return getSqlSession().selectOne("TCallingTaskMapper.selectSelectiveForReviewCount", reqMap);
	}

	@Override
	public int updateTaskClaimer(Map<String, Object> reqMap) {
		// TODO Auto-generated method stub
		return getSqlSession().update("TCallingTaskMapper.updateTaskClaimer", reqMap);
	}

	@Override
	public int updateGenerateTime(Map<String, Object> reqMap) {
		// TODO Auto-generated method stub
		return getSqlSession().update("TCallingTaskMapper.updateGenerateTime", reqMap);
	}

	@Override
	public List<TCallingTask> getTCallingTask(Map<String, Object> reqMap) {
		return getSqlSession().selectList("TCallingTaskMapper.getTCallingTask", reqMap);
	}

	@Override
	public int updateTcallingTask1(Map<String, Object> map) {
		return getSqlSession().update("TCallingTaskMapper.updateTcallingTask1", map);
	}

	@Override
	public int updateTcallingTask2(Map<String, Object> map) {
		return getSqlSession().update("TCallingTaskMapper.updateTcallingTask2", map);
	}

}
