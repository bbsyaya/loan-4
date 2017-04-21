package com.hrbb.loan.pos.dao.impl;

import java.util.Map;

import org.mybatis.spring.support.SqlSessionDaoSupport;
import org.springframework.stereotype.Repository;

import com.hrbb.loan.pos.dao.TCreditReportReliefDao;
import com.hrbb.loan.pos.dao.entity.TCreditReportRelief;

@Repository("tCreditReportReliefDao")
public class TCreditReportReliefDaoImpl extends SqlSessionDaoSupport implements TCreditReportReliefDao{

	@Override
	public int deleteByPrimaryKey(String serialNo) {
		// TODO Auto-generated method stub
		return 0;
	}

	@Override
	public int insert(TCreditReportRelief record) {
		// TODO Auto-generated method stub
		return 0;
	}

	@Override
	public int insertSelective(TCreditReportRelief record) {
		// TODO Auto-generated method stub
		return 0;
	}

	@Override
	public TCreditReportRelief selectByPrimaryKey(String serialNo) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public int updateByPrimaryKeySelective(TCreditReportRelief record) {
		// TODO Auto-generated method stub
		return 0;
	}

	@Override
	public int updateByPrimaryKey(TCreditReportRelief record) {
		// TODO Auto-generated method stub
		return 0;
	}

	@Override
	public int insertSelectiveMap(Map<String, Object> reqMap) {
		return getSqlSession().insert("TCreditReportReliefMapper.insertSelectiveMap", reqMap);
	}
    
}