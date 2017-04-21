package com.hrbb.loan.pos.dao.impl;

import java.util.Map;

import org.mybatis.spring.support.SqlSessionDaoSupport;
import org.springframework.stereotype.Repository;

import com.hrbb.loan.pos.dao.TCreditReportIndicatorDao;
import com.hrbb.loan.pos.dao.entity.TCreditReportIndicator;

/**
 * <h1>征信报告指标</h1>
 * 
 * @author Johnson Song
 * @version Id: TCreditReportIndicatorDaoImpl.java, v 1.0 2015-2-15 上午11:03:53
 *          Johnson Song Exp
 */
@Repository("tCreditReportIndicatorDao")
public class TCreditReportIndicatorDaoImpl extends SqlSessionDaoSupport
		implements TCreditReportIndicatorDao {

	@Override
	public int deleteByPrimaryKey(String CR001) {
		// TODO 自动生成的方法存根
		return getSqlSession().delete(
				"TCreditReportIndicatorMapper.deleteByPrimaryKey", CR001);
	}

	@Override
	public int insert(TCreditReportIndicator record) {
		// TODO 自动生成的方法存根
		return 0;
	}

	@Override
	public int insertSelective(TCreditReportIndicator record) {
		// TODO 自动生成的方法存根
		return getSqlSession().insert(
				"TCreditReportIndicatorMapper.insertSelective", record);
	}

	@Override
	public TCreditReportIndicator selectByPrimaryKey(String CR001) {
		// TODO 自动生成的方法存根
		return null;
	}

	@Override
	public int updateByPrimaryKeySelective(TCreditReportIndicator record) {
		// TODO 自动生成的方法存根
		return 0;
	}

	@Override
	public int updateByPrimaryKey(TCreditReportIndicator record) {
		// TODO 自动生成的方法存根
		return 0;
	}

	@Override
	public int insertSelectiveMap(Map<String, Object> reqMap) {
		return getSqlSession().insert("TCreditReportIndicatorMapper.insertSelectiveMap", reqMap);
	}

}
