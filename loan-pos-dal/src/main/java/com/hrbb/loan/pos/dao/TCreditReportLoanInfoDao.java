package com.hrbb.loan.pos.dao;

import java.util.List;
import java.util.Map;

import com.hrbb.loan.pos.dao.entity.TCreditReportLoanInfo;

public interface TCreditReportLoanInfoDao {
	int deleteByPrimaryKey(String serialNo);

	int insert(TCreditReportLoanInfo record);

	int insertSelective(TCreditReportLoanInfo record);

	TCreditReportLoanInfo selectByPrimaryKey(String serialNo);

	int updateByPrimaryKeySelective(TCreditReportLoanInfo record);

	int updateByPrimaryKey(TCreditReportLoanInfo record);

	public int insertSelectiveMap(Map<String, Object> reqMap);

	public TCreditReportLoanInfo selectSum(TCreditReportLoanInfo record);

	public TCreditReportLoanInfo selectMax(TCreditReportLoanInfo record);

	public TCreditReportLoanInfo selectSelectiveMax(TCreditReportLoanInfo record);

	public TCreditReportLoanInfo selectSumBalance(TCreditReportLoanInfo record);

	public List<TCreditReportLoanInfo> selectListNot(
			TCreditReportLoanInfo record);

	public TCreditReportLoanInfo selectCount(TCreditReportLoanInfo record);

	public TCreditReportLoanInfo selectSumBalanceNew(
			TCreditReportLoanInfo record);

	public TCreditReportLoanInfo selectFirstIssueMonth(
			TCreditReportLoanInfo record);
}