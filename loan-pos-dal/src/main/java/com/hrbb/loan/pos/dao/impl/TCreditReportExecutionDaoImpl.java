package com.hrbb.loan.pos.dao.impl;

import java.util.Map;

import org.mybatis.spring.support.SqlSessionDaoSupport;
import org.springframework.stereotype.Repository;

import com.hrbb.loan.pos.dao.TCreditReportExecutionDao;
import com.hrbb.loan.pos.dao.entity.TCreditReportExecution;

@Repository("tCreditReportExecutionDao")
public class TCreditReportExecutionDaoImpl extends SqlSessionDaoSupport implements TCreditReportExecutionDao{

	@Override
	public int deleteByPrimaryKey(String serialNo) {
		// TODO Auto-generated method stub
		return 0;
	}

	@Override
	public int insert(TCreditReportExecution record) {
		// TODO Auto-generated method stub
		return 0;
	}

	@Override
	public int insertSelective(TCreditReportExecution record) {
		// TODO Auto-generated method stub
		return 0;
	}

	@Override
	public TCreditReportExecution selectByPrimaryKey(String serialNo) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public int updateByPrimaryKeySelective(TCreditReportExecution record) {
		// TODO Auto-generated method stub
		return 0;
	}

	@Override
	public int updateByPrimaryKey(TCreditReportExecution record) {
		// TODO Auto-generated method stub
		return 0;
	}

	@Override
	public int insertSelectiveMap(Map<String, Object> reqMap) {
		return getSqlSession().insert("TCreditReportExecutionMapper.insertSelectiveMap", reqMap);
	}
	
}