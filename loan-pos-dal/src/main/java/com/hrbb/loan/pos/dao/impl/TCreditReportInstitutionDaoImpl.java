package com.hrbb.loan.pos.dao.impl;

import java.util.Map;

import org.mybatis.spring.support.SqlSessionDaoSupport;
import org.springframework.stereotype.Repository;

import com.hrbb.loan.pos.dao.TCreditReportInstitutionDao;
import com.hrbb.loan.pos.dao.entity.TCreditReportInstitution;

@Repository("tCreditReportInstitutionDao")
public class TCreditReportInstitutionDaoImpl extends SqlSessionDaoSupport implements TCreditReportInstitutionDao {

	@Override
	public int deleteByPrimaryKey(String serialNo) {
		// TODO Auto-generated method stub
		return 0;
	}

	@Override
	public int insert(TCreditReportInstitution record) {
		// TODO Auto-generated method stub
		return 0;
	}

	@Override
	public int insertSelective(TCreditReportInstitution record) {
		// TODO Auto-generated method stub
		return 0;
	}

	@Override
	public TCreditReportInstitution selectByPrimaryKey(String serialNo) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public int updateByPrimaryKeySelective(TCreditReportInstitution record) {
		// TODO Auto-generated method stub
		return 0;
	}

	@Override
	public int updateByPrimaryKey(TCreditReportInstitution record) {
		// TODO Auto-generated method stub
		return 0;
	}

	@Override
	public int insertSelectiveMap(Map<String, Object> reqMap) {
		return getSqlSession().insert("TCreditReportInstitutionMapper.insertSelectiveMap", reqMap);
	}

	
}