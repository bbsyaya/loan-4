package com.hrbb.loan.pos.dao;

import java.util.Map;

import com.hrbb.loan.pos.dao.entity.TCreditReportIdentity;

public interface TCreditReportIdentityDao {
	int deleteByPrimaryKey(String reportNo);

	int insert(TCreditReportIdentity record);

	int insertSelective(TCreditReportIdentity record);

	TCreditReportIdentity selectByPrimaryKey(String reportNo);

	int updateByPrimaryKeySelective(TCreditReportIdentity record);

	int updateByPrimaryKey(TCreditReportIdentity record);

	public int insertSelectiveMap(Map<String, Object> reqMap);

	public TCreditReportIdentity selectInfor(Map<String, Object> reqMap);
	
	public TCreditReportIdentity selectByQueryId(String queryId);
}