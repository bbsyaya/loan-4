package com.hrbb.loan.pos.dao.impl;

import java.util.Map;

import org.mybatis.spring.support.SqlSessionDaoSupport;
import org.springframework.stereotype.Repository;

import com.hrbb.loan.pos.dao.TCreditReportSpouseDao;
import com.hrbb.loan.pos.dao.entity.TCreditReportSpouse;

/**
 *<h1>配偶信息</h1>
 *@author Johnson Song
 *@version Id: TCreditApplyDaoImpl.java, v 1.0 2015-2-15 上午11:03:53 Johnson Song Exp
 */
@Repository("tCreditReportSpouseDao")
public class TCreditReportSpouseDaoImpl extends SqlSessionDaoSupport implements TCreditReportSpouseDao {

	@Override
	public int deleteByPrimaryKey(String reportNo) {
		// TODO 自动生成的方法存根
		return 0;
	}

	@Override
	public int insert(TCreditReportSpouse record) {
		// TODO 自动生成的方法存根
		return 0;
	}

	@Override
	public int insertSelective(TCreditReportSpouse record) {
		// TODO 自动生成的方法存根
		return 0;
	}

	@Override
	public TCreditReportSpouse selectByPrimaryKey(String reportNo) {
		// TODO 自动生成的方法存根
		return getSqlSession().selectOne("TCreditReportSpouseMapper.selectByPrimaryKey", reportNo);
	}

	@Override
	public int updateByPrimaryKeySelective(TCreditReportSpouse record) {
		// TODO 自动生成的方法存根
		return 0;
	}

	@Override
	public int updateByPrimaryKey(TCreditReportSpouse record) {
		// TODO 自动生成的方法存根
		return 0;
	}

	@Override
	public int insertSelectiveMap(Map<String, Object> reqMap) {
		return getSqlSession().insert("TCreditReportSpouseMapper.insertSelectiveMap", reqMap);
	}
	
	@Override
	public TCreditReportSpouse selectByQueryId(String queryId) {
		// TODO 自动生成的方法存根
		return getSqlSession().selectOne("TCreditReportSpouseMapper.selectByQueryId", queryId);
	}
}
