package com.hrbb.loan.pos.dao.impl;

import java.util.Map;

import org.mybatis.spring.support.SqlSessionDaoSupport;
import org.springframework.stereotype.Repository;

import com.hrbb.loan.pos.dao.TCreditReportNormalDao;
import com.hrbb.loan.pos.dao.entity.TCreditReportNormal;

/**
 *<h1>未结清贷款信息汇总</h1>
 *@author Johnson Song
 *@version Id: TCreditApplyDaoImpl.java, v 1.0 2015-2-15 上午11:03:53 Johnson Song Exp
 */
@Repository("tCreditReportNormalDao")
public class TCreditReportNormalDaoImpl extends SqlSessionDaoSupport implements TCreditReportNormalDao {

	@Override
	public int deleteByPrimaryKey(String reportNo) {
		// TODO 自动生成的方法存根
		return 0;
	}

	@Override
	public int insert(TCreditReportNormal record) {
		// TODO 自动生成的方法存根
		return 0;
	}

	@Override
	public int insertSelective(TCreditReportNormal record) {
		// TODO 自动生成的方法存根
		return 0;
	}

	@Override
	public TCreditReportNormal selectByPrimaryKey(String reportNo) {
		// TODO 自动生成的方法存根
		return getSqlSession().selectOne("TCreditReportNormalMapper.selectByPrimaryKey", reportNo);
	}

	@Override
	public int updateByPrimaryKeySelective(TCreditReportNormal record) {
		// TODO 自动生成的方法存根
		return 0;
	}

	@Override
	public int updateByPrimaryKey(TCreditReportNormal record) {
		// TODO 自动生成的方法存根
		return 0;
	}
	
	@Override
	public int insertSelectiveMap(Map<String, Object> reqMap) {
		return getSqlSession().insert("TCreditReportNormalMapper.insertSelectiveMap", reqMap);
	}

	@Override
	public TCreditReportNormal selectByQueryId(String queryId) {
		// TODO 自动生成的方法存根
		return getSqlSession().selectOne("TCreditReportNormalMapper.selectByQueryId", queryId);
	}
}
