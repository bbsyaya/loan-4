package com.hrbb.loan.pos.dao.impl;

import java.util.Map;

import org.mybatis.spring.support.SqlSessionDaoSupport;
import org.springframework.stereotype.Repository;

import com.hrbb.loan.pos.dao.TCreditReportOverdueDao;
import com.hrbb.loan.pos.dao.entity.TCreditReportOverdue;

/**
 *<h1>逾期(透支)信息汇总</h1>
 *@author Johnson Song
 *@version Id: TCreditReportOverdueDaoImpl.java, v 1.0 2015-2-15 上午11:03:53 Johnson Song Exp
 */
@Repository("tCreditReportOverdueDao")
public class TCreditReportOverdueDaoImpl extends SqlSessionDaoSupport implements TCreditReportOverdueDao {

	@Override
	public int deleteByPrimaryKey(String reportNo) {
		// TODO 自动生成的方法存根
		return 0;
	}

	@Override
	public int insert(TCreditReportOverdue record) {
		// TODO 自动生成的方法存根
		return 0;
	}

	@Override
	public int insertSelective(TCreditReportOverdue record) {
		// TODO 自动生成的方法存根
		return 0;
	}

	@Override
	public TCreditReportOverdue selectByPrimaryKey(String reportNo) {
		// TODO 自动生成的方法存根
		return getSqlSession().selectOne("TCreditReportOverdueMapper.selectByPrimaryKey", reportNo);
	}

	@Override
	public int updateByPrimaryKeySelective(TCreditReportOverdue record) {
		// TODO 自动生成的方法存根
		return 0;
	}

	@Override
	public int updateByPrimaryKey(TCreditReportOverdue record) {
		// TODO 自动生成的方法存根
		return 0;
	}

	@Override
	public int insertSelectiveMap(Map<String, Object> reqMap) {
		return getSqlSession().insert("TCreditReportOverdueMapper.insertSelectiveMap", reqMap);
	}
	
	@Override
	public TCreditReportOverdue selectByQueryId(String queryId) {
		// TODO 自动生成的方法存根
		return getSqlSession().selectOne("TCreditReportOverdueMapper.selectByQueryId", queryId);
	}
}
