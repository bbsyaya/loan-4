package com.hrbb.loan.pos.dao.impl;

import java.util.Map;

import org.mybatis.spring.support.SqlSessionDaoSupport;
import org.springframework.stereotype.Repository;

import com.hrbb.loan.pos.dao.TCreditReportResidenceDao;
import com.hrbb.loan.pos.dao.entity.TCreditReportResidence;

@Repository("tCreditReportResidenceDao")
public class TCreditReportResidenceDaoImpl extends SqlSessionDaoSupport implements TCreditReportResidenceDao{

	@Override
	public int deleteByPrimaryKey(String serialNo) {
		// TODO Auto-generated method stub
		return 0;
	}

	@Override
	public int insert(TCreditReportResidence record) {
		// TODO Auto-generated method stub
		return 0;
	}

	@Override
	public int insertSelective(TCreditReportResidence record) {
		// TODO Auto-generated method stub
		return 0;
	}

	@Override
	public TCreditReportResidence selectByPrimaryKey(String serialNo) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public int updateByPrimaryKeySelective(TCreditReportResidence record) {
		// TODO Auto-generated method stub
		return 0;
	}

	@Override
	public int updateByPrimaryKey(TCreditReportResidence record) {
		// TODO Auto-generated method stub
		return 0;
	}

	@Override
	public int insertSelectiveMap(Map<String, Object> reqMap) {
		return getSqlSession().insert("TCreditReportResidenceMapper.insertSelectiveMap", reqMap);
	}
    
}