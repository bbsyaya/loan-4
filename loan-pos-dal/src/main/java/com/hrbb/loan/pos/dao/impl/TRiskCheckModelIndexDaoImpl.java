/**
 * 
 *	哈尔滨银行
 * Copyright (c) 2007-2015 HRBB,Inc.All Rights Reserved.
 */
package com.hrbb.loan.pos.dao.impl;

import org.mybatis.spring.support.SqlSessionDaoSupport;
import org.springframework.stereotype.Repository;

import com.hrbb.loan.pos.dao.TRiskCheckModelIndexDao;
import com.hrbb.loan.pos.dao.entity.TRiskCheckModelIndex;

/**
 * 
 * @author XLY
 * @version $Id: TRiskCheckModelIndexDaoImpl.java, v 0.1 2015-3-9 下午6:46:12 XLY
 *          Exp $
 */
@Repository("tRiskCheckModelIndexDao")
public class TRiskCheckModelIndexDaoImpl extends SqlSessionDaoSupport implements
		TRiskCheckModelIndexDao {

	@Override
	public int deleteByPrimaryKey(String riskResultId) {
		return getSqlSession().delete(
				"TRiskCheckModelIndexMapper.deleteByPrimaryKey", riskResultId);
	}

	@Override
	public int insert(TRiskCheckModelIndex record) {
		return getSqlSession().insert("TRiskCheckModelIndexMapper.insert",
				record);
	}

	@Override
	public int insertSelective(TRiskCheckModelIndex record) {
		return getSqlSession().insert(
				"TRiskCheckModelIndexMapper.insertSelective", record);
	}

	@Override
	public TRiskCheckModelIndex selectByPrimaryKey(String riskResultId) {
		return getSqlSession().selectOne(
				"TRiskCheckModelIndexMapper.selectByPrimaryKey", riskResultId);
	}

	@Override
	public int updateByPrimaryKeySelective(TRiskCheckModelIndex record) {
		return getSqlSession().update(
				"TRiskCheckModelIndexMapper.updateByPrimaryKeySelective",
				record);
	}

	@Override
	public int updateByPrimaryKey(TRiskCheckModelIndex record) {
		return getSqlSession().update(
				"TRiskCheckModelIndexMapper.updateByPrimaryKey", record);
	}
}
