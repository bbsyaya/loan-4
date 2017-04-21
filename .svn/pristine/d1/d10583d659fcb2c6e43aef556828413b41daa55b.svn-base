package com.hrbb.loan.pos.dao;

import java.util.Map;

import com.hrbb.loan.pos.dao.entity.TCreditReportNormal;

public interface TCreditReportNormalDao {
	int deleteByPrimaryKey(String reportNo);

	int insert(TCreditReportNormal record);

	int insertSelective(TCreditReportNormal record);

	TCreditReportNormal selectByPrimaryKey(String reportNo);

	int updateByPrimaryKeySelective(TCreditReportNormal record);

	int updateByPrimaryKey(TCreditReportNormal record);

	public int insertSelectiveMap(Map<String, Object> reqMap);

	public TCreditReportNormal selectByQueryId(String queryId);
}