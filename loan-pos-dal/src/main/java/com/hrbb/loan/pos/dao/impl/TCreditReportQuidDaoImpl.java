package com.hrbb.loan.pos.dao.impl;

import java.util.Map;

import org.mybatis.spring.support.SqlSessionDaoSupport;
import org.springframework.stereotype.Repository;

import com.hrbb.loan.pos.dao.TCreditReportQuidDao;
import com.hrbb.loan.pos.dao.entity.TCreditReportQuid;

@Repository("tCreditReportQuidDao")
public class TCreditReportQuidDaoImpl extends SqlSessionDaoSupport implements TCreditReportQuidDao{

	@Override
	public int deleteByPrimaryKey(String serialNo) {
		// TODO Auto-generated method stub
		return 0;
	}

	@Override
	public int insert(TCreditReportQuid record) {
		// TODO Auto-generated method stub
		return 0;
	}

	@Override
	public int insertSelective(TCreditReportQuid record) {
		// TODO Auto-generated method stub
		return 0;
	}

	@Override
	public TCreditReportQuid selectByPrimaryKey(String serialNo) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public int updateByPrimaryKeySelective(TCreditReportQuid record) {
		// TODO Auto-generated method stub
		return 0;
	}

	@Override
	public int updateByPrimaryKey(TCreditReportQuid record) {
		// TODO Auto-generated method stub
		return 0;
	}

	@Override
	public int insertSelectiveMap(Map<String, Object> reqMap) {
		return getSqlSession().insert("TCreditReportQuidDao.insertSelectiveMap", reqMap);
	}
   
}