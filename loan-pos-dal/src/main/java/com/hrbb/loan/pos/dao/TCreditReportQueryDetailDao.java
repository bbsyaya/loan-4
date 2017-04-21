package com.hrbb.loan.pos.dao;

import java.util.Map;

import com.hrbb.loan.pos.dao.entity.TCreditReportQueryDetail;

public interface TCreditReportQueryDetailDao {
	int deleteByPrimaryKey(String serialNo);

	int insert(TCreditReportQueryDetail record);

	int insertSelective(TCreditReportQueryDetail record);

	TCreditReportQueryDetail selectByPrimaryKey(String serialNo);

	int updateByPrimaryKeySelective(TCreditReportQueryDetail record);

	int updateByPrimaryKey(TCreditReportQueryDetail record);

	public int insertSelectiveMap(Map<String, Object> reqMap);

	public TCreditReportQueryDetail selectCount(TCreditReportQueryDetail record);

	public TCreditReportQueryDetail selectCountMap(
			TCreditReportQueryDetail record);
}