package com.hrbb.loan.pos.dao;

import java.util.Map;

import com.hrbb.loan.pos.dao.entity.TCreditReportCreditInfo;

public interface TCreditReportCreditInfoDao {
	int deleteByPrimaryKey(String reportNo);

	int insert(TCreditReportCreditInfo record);

	int insertSelective(TCreditReportCreditInfo record);

	TCreditReportCreditInfo selectByPrimaryKey(String reportNo);

	int updateByPrimaryKeySelective(TCreditReportCreditInfo record);

	int updateByPrimaryKey(TCreditReportCreditInfo record);

	public int insertSelectiveMap(Map<String, Object> reqMap);

	public TCreditReportCreditInfo selectByQueryId(String queryId);
}