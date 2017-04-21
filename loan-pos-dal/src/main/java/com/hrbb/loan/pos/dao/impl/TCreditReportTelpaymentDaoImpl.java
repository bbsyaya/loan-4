package com.hrbb.loan.pos.dao.impl;

import java.util.Map;

import org.mybatis.spring.support.SqlSessionDaoSupport;
import org.springframework.stereotype.Repository;

import com.hrbb.loan.pos.dao.TCreditReportTelpaymentDao;
import com.hrbb.loan.pos.dao.entity.TCreditReportTelpayment;

@Repository("tCreditReportTelpaymentDao")
public class TCreditReportTelpaymentDaoImpl extends SqlSessionDaoSupport implements TCreditReportTelpaymentDao {

	@Override
	public int deleteByPrimaryKey(String serialNo) {
		// TODO Auto-generated method stub
		return 0;
	}

	@Override
	public int insert(TCreditReportTelpayment record) {
		// TODO Auto-generated method stub
		return 0;
	}

	@Override
	public int insertSelective(TCreditReportTelpayment record) {
		// TODO Auto-generated method stub
		return 0;
	}

	@Override
	public TCreditReportTelpayment selectByPrimaryKey(String serialNo) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public int updateByPrimaryKeySelective(TCreditReportTelpayment record) {
		// TODO Auto-generated method stub
		return 0;
	}

	@Override
	public int updateByPrimaryKey(TCreditReportTelpayment record) {
		// TODO Auto-generated method stub
		return 0;
	}

	@Override
	public int insertSelectiveMap(Map<String, Object> reqMap) {
		return getSqlSession().insert("TCreditReportTelpaymentMapper.insertSelectiveMap", reqMap);
	}
    
}