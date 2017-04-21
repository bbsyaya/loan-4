package com.hrbb.loan.pos.dao.impl;

import java.util.List;
import java.util.Map;

import org.mybatis.spring.support.SqlSessionDaoSupport;
import org.springframework.stereotype.Repository;

import com.hrbb.loan.pos.dao.TCreditReportPoolDao;
import com.hrbb.loan.pos.dao.entity.TCreditReportPool;

@Repository("tCreditReportPoolDao")
public class TCreditReportPoolDaoImpl extends SqlSessionDaoSupport implements TCreditReportPoolDao{

	@Override
	public int deleteByPrimaryKey(Integer id) {
		// TODO Auto-generated method stub
		return 0;
	}

	@Override
	public int insert(TCreditReportPool record) {
		// TODO Auto-generated method stub
		return 0;
	}

	@Override
	public int insertSelective(TCreditReportPool record) {
		return getSqlSession().insert("TCreditReportPoolMapper.insertSelective", record);
	}

	@Override
	public TCreditReportPool selectByPrimaryKey(Integer id) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public int updateByPrimaryKeySelective(TCreditReportPool record) {
		return getSqlSession().update("TCreditReportPoolMapper.updateByPrimaryKeySelective", record);
	}

	@Override
	public int updateByPrimaryKey(TCreditReportPool record) {
		// TODO Auto-generated method stub
		return 0;
	}

	@Override
	public List<TCreditReportPool> selectSelective(Map<String, Object> reqMap) {
		return getSqlSession().selectList("TCreditReportPoolMapper.selectSelective", reqMap);
	}

	@Override
	public int updateSelective(TCreditReportPool record) {
		// TODO Auto-generated method stub
		return 0;
	}
	
}
