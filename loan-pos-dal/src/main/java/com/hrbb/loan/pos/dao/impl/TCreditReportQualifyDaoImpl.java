package com.hrbb.loan.pos.dao.impl;

import java.util.Map;

import org.mybatis.spring.support.SqlSessionDaoSupport;
import org.springframework.stereotype.Repository;

import com.hrbb.loan.pos.dao.TCreditReportQualifyDao;
import com.hrbb.loan.pos.dao.entity.TCreditReportQualify;

@Repository("tCreditReportQualifyDao")
public class TCreditReportQualifyDaoImpl extends SqlSessionDaoSupport implements TCreditReportQualifyDao{

	@Override
	public int deleteByPrimaryKey(String serialNo) {
		// TODO Auto-generated method stub
		return 0;
	}

	@Override
	public int insert(TCreditReportQualify record) {
		// TODO Auto-generated method stub
		return 0;
	}

	@Override
	public int insertSelective(TCreditReportQualify record) {
		// TODO Auto-generated method stub
		return 0;
	}

	@Override
	public TCreditReportQualify selectByPrimaryKey(String serialNo) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public int updateByPrimaryKeySelective(TCreditReportQualify record) {
		// TODO Auto-generated method stub
		return 0;
	}

	@Override
	public int updateByPrimaryKey(TCreditReportQualify record) {
		// TODO Auto-generated method stub
		return 0;
	}

	@Override
	public int insertSelectiveMap(Map<String, Object> reqMap) {
		return getSqlSession().insert("TCreditReportQualifyMapper.insertSelectiveMap", reqMap);
	}
	
}