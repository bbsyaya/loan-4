package com.hrbb.loan.pos.dao.impl;

import java.util.Map;

import org.mybatis.spring.support.SqlSessionDaoSupport;
import org.springframework.stereotype.Repository;

import com.hrbb.loan.pos.dao.TCreditReportHousingDao;
import com.hrbb.loan.pos.dao.entity.TCreditReportHousing;

@Repository("tCreditReportHousingDao")
public class TCreditReportHousingDaoImpl extends SqlSessionDaoSupport implements TCreditReportHousingDao {

	@Override
	public int deleteByPrimaryKey(String serialNo) {
		// TODO Auto-generated method stub
		return 0;
	}

	@Override
	public int insert(TCreditReportHousing record) {
		// TODO Auto-generated method stub
		return 0;
	}

	@Override
	public int insertSelective(TCreditReportHousing record) {
		// TODO Auto-generated method stub
		return 0;
	}

	@Override
	public TCreditReportHousing selectByPrimaryKey(String serialNo) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public int updateByPrimaryKeySelective(TCreditReportHousing record) {
		// TODO Auto-generated method stub
		return 0;
	}

	@Override
	public int updateByPrimaryKey(TCreditReportHousing record) {
		// TODO Auto-generated method stub
		return 0;
	}

	@Override
	public int insertSelectiveMap(Map<String, Object> reqMap) {
		return getSqlSession().insert("TCreditReportHousingMapper.insertSelectiveMap", reqMap);
	}

	
}