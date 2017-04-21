package com.hrbb.loan.pos.dao;

import java.util.List;
import java.util.Map;

import com.hrbb.loan.pos.dao.entity.TCreditReportCreditCard;

public interface TCreditReportCreditCardDao {
	int deleteByPrimaryKey(String serialNo);

	int insert(TCreditReportCreditCard record);

	int insertSelective(TCreditReportCreditCard record);

	TCreditReportCreditCard selectByPrimaryKey(String serialNo);

	int updateByPrimaryKeySelective(TCreditReportCreditCard record);

	int updateByPrimaryKey(TCreditReportCreditCard record);

	public int insertSelectiveMap(Map<String, Object> reqMap);

	public TCreditReportCreditCard selectSum(TCreditReportCreditCard record);

	public TCreditReportCreditCard selectCount(TCreditReportCreditCard record);

	public List<TCreditReportCreditCard> selectList(
			TCreditReportCreditCard record);

	public List<TCreditReportCreditCard> selectListNot(
			TCreditReportCreditCard record);

	public TCreditReportCreditCard selectSumLimitAmtNew(
			TCreditReportCreditCard record);

	public TCreditReportCreditCard selectSelectiveMax(
			TCreditReportCreditCard record);
}