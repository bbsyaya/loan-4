package com.hrbb.loan.pos.dao.impl;

import java.util.Map;

import org.mybatis.spring.support.SqlSessionDaoSupport;
import org.springframework.stereotype.Repository;

import com.hrbb.loan.pos.dao.TCreditReportAwardDao;
import com.hrbb.loan.pos.dao.entity.TCreditReportAward;


@Repository("tCreditReportAwardDao")
public class TCreditReportAwardDaoImpl extends SqlSessionDaoSupport implements TCreditReportAwardDao{

	@Override
	public int deleteByPrimaryKey(String serialNo) {
		// TODO Auto-generated method stub
		return 0;
	}

	@Override
	public int insert(TCreditReportAward record) {
		// TODO Auto-generated method stub
		return 0;
	}

	@Override
	public int insertSelective(TCreditReportAward record) {
		// TODO Auto-generated method stub
		return 0;
	}

	@Override
	public TCreditReportAward selectByPrimaryKey(String serialNo) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public int updateByPrimaryKeySelective(TCreditReportAward record) {
		// TODO Auto-generated method stub
		return 0;
	}

	@Override
	public int updateByPrimaryKey(TCreditReportAward record) {
		// TODO Auto-generated method stub
		return 0;
	}

	@Override
	public int insertSelectiveMap(Map<String, Object> reqMap) {
		return getSqlSession().insert("TCreditReportAwardMapper.insertSelective", reqMap);
	}
    
}