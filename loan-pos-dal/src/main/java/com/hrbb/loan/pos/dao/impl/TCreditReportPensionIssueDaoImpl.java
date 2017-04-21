package com.hrbb.loan.pos.dao.impl;

import java.util.Map;

import org.mybatis.spring.support.SqlSessionDaoSupport;
import org.springframework.stereotype.Repository;

import com.hrbb.loan.pos.dao.TCreditReportPensionIssueDao;
import com.hrbb.loan.pos.dao.entity.TCreditReportPensionIssue;

@Repository("tCreditReportPensionIssueDao")
public class TCreditReportPensionIssueDaoImpl extends SqlSessionDaoSupport implements TCreditReportPensionIssueDao{

	@Override
	public int deleteByPrimaryKey(String serialNo) {
		// TODO Auto-generated method stub
		return 0;
	}

	@Override
	public int insert(TCreditReportPensionIssue record) {
		// TODO Auto-generated method stub
		return 0;
	}

	@Override
	public int insertSelective(TCreditReportPensionIssue record) {
		// TODO Auto-generated method stub
		return 0;
	}

	@Override
	public TCreditReportPensionIssue selectByPrimaryKey(String serialNo) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public int updateByPrimaryKeySelective(TCreditReportPensionIssue record) {
		// TODO Auto-generated method stub
		return 0;
	}

	@Override
	public int updateByPrimaryKey(TCreditReportPensionIssue record) {
		// TODO Auto-generated method stub
		return 0;
	}

	@Override
	public int insertSelectiveMap(Map<String, Object> reqMap) {
		return getSqlSession().insert("TCreditReportPensionIssueMapper.insertSelectiveMap", reqMap);
	}
    
}