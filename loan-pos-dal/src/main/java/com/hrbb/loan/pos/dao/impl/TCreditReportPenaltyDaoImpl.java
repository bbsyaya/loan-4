package com.hrbb.loan.pos.dao.impl;

import java.util.Map;

import org.mybatis.spring.support.SqlSessionDaoSupport;
import org.springframework.stereotype.Repository;

import com.hrbb.loan.pos.dao.TCreditReportPenaltyDao;
import com.hrbb.loan.pos.dao.entity.TCreditReportPenalty;

@Repository("tCreditReportPenaltyDao")
public class TCreditReportPenaltyDaoImpl extends SqlSessionDaoSupport implements TCreditReportPenaltyDao {

	@Override
	public int deleteByPrimaryKey(String serialNo) {
		// TODO Auto-generated method stub
		return 0;
	}

	@Override
	public int insert(TCreditReportPenalty record) {
		// TODO Auto-generated method stub
		return 0;
	}

	@Override
	public int insertSelective(TCreditReportPenalty record) {
		// TODO Auto-generated method stub
		return 0;
	}

	@Override
	public TCreditReportPenalty selectByPrimaryKey(String serialNo) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public int updateByPrimaryKeySelective(TCreditReportPenalty record) {
		// TODO Auto-generated method stub
		return 0;
	}

	@Override
	public int updateByPrimaryKey(TCreditReportPenalty record) {
		// TODO Auto-generated method stub
		return 0;
	}

	@Override
	public int insertSelectiveMap(Map<String, Object> reqMap) {
		return getSqlSession().insert("TCreditReportPenaltyMapper.insertSelectiveMap", reqMap);
	}
    
}