/**
 * 
 *	哈尔滨银行
 * Copyright (c) 2007-2015 HRBB,Inc.All Rights Reserved.
 */
package com.hrbb.loan.pos.dao.impl;

import org.mybatis.spring.support.SqlSessionDaoSupport;
import org.springframework.stereotype.Repository;

import com.hrbb.loan.pos.dao.TRiskCheckCalcIndexDao;
import com.hrbb.loan.pos.dao.entity.TRiskCheckCalcIndex;

/**
 * 
 * @author XLY
 * @version $Id: TRiskCheckCalcIndexDaoImpl.java, v 0.1 2015-3-9 下午6:46:12 XLY
 *          Exp $
 */
@Repository("tRiskCheckCalcIndexDao")
public class TRiskCheckCalcIndexDaoImpl extends SqlSessionDaoSupport implements
		TRiskCheckCalcIndexDao {

	@Override
	public int deleteByPrimaryKey(String riskResultId) {
		return getSqlSession().delete(
				"TRiskCheckCalcIndexMapper.deleteByPrimaryKey", riskResultId);
	}

	@Override
	public int insert(TRiskCheckCalcIndex record) {
		return getSqlSession().insert("TRiskCheckCalcIndexMapper.insert",
				record);
	}

	@Override
	public int insertSelective(TRiskCheckCalcIndex record) {
		return getSqlSession().insert(
				"TRiskCheckCalcIndexMapper.insertSelective", record);
	}

	@Override
	public TRiskCheckCalcIndex selectByPrimaryKey(String riskResultId) {
		return getSqlSession().selectOne(
				"TRiskCheckCalcIndexMapper.selectByPrimaryKey", riskResultId);
	}

	@Override
	public int updateByPrimaryKeySelective(TRiskCheckCalcIndex record) {
		return getSqlSession()
				.update("TRiskCheckCalcIndexMapper.updateByPrimaryKeySelective",
						record);
	}

	@Override
	public int updateByPrimaryKey(TRiskCheckCalcIndex record) {
		return getSqlSession().update(
				"TRiskCheckCalcIndexMapper.updateByPrimaryKey", record);
	}
}
