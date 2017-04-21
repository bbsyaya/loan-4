package com.hrbb.loan.pos.dao.impl;

import java.util.List;
import java.util.Map;

import org.mybatis.spring.support.SqlSessionDaoSupport;
import org.springframework.stereotype.Repository;

import com.hrbb.loan.pos.dao.TCreditReportCreditCardDao;
import com.hrbb.loan.pos.dao.entity.TCreditReportCreditCard;

@Repository("tCreditReportCreditCardDao")
public class TCreditReportCreditCardDaoImpl extends SqlSessionDaoSupport
		implements TCreditReportCreditCardDao {

	@Override
	public int deleteByPrimaryKey(String serialNo) {
		// TODO Auto-generated method stub
		return 0;
	}

	@Override
	public int insert(TCreditReportCreditCard record) {
		// TODO Auto-generated method stub
		return 0;
	}

	@Override
	public int insertSelective(TCreditReportCreditCard record) {
		// TODO Auto-generated method stub
		return 0;
	}

	@Override
	public TCreditReportCreditCard selectByPrimaryKey(String serialNo) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public int updateByPrimaryKeySelective(TCreditReportCreditCard record) {
		// TODO Auto-generated method stub
		return 0;
	}

	@Override
	public int updateByPrimaryKey(TCreditReportCreditCard record) {
		// TODO Auto-generated method stub
		return 0;
	}

	@Override
	public int insertSelectiveMap(Map<String, Object> reqMap) {
		return getSqlSession().insert(
				"TCreditReportCreditCardMapper.insertSelectiveMap", reqMap);

	}

	@Override
	public TCreditReportCreditCard selectSum(TCreditReportCreditCard record) {
		// TODO 自动生成的方法存根
		return getSqlSession().selectOne(
				"TCreditReportCreditCardMapper.selectSum", record);
	}

	@Override
	public TCreditReportCreditCard selectCount(TCreditReportCreditCard record) {
		// TODO 自动生成的方法存根
		return getSqlSession().selectOne(
				"TCreditReportCreditCardMapper.selectCount", record);
	}

	@Override
	public List<TCreditReportCreditCard> selectList(
			TCreditReportCreditCard record) {
		// TODO 自动生成的方法存根
		return getSqlSession().selectList(
				"TCreditReportCreditCardMapper.selectList", record);
	}

	@Override
	public List<TCreditReportCreditCard> selectListNot(
			TCreditReportCreditCard record) {
		// TODO 自动生成的方法存根
		return getSqlSession().selectList(
				"TCreditReportCreditCardMapper.selectListNot", record);
	}

	@Override
	public TCreditReportCreditCard selectSumLimitAmtNew(
			TCreditReportCreditCard record) {
		// TODO 自动生成的方法存根
		return getSqlSession().selectOne(
				"TCreditReportCreditCardMapper.selectSumLimitAmtNew", record);
	}

	@Override
	public TCreditReportCreditCard selectSelectiveMax(
			TCreditReportCreditCard record) {
		// TODO 自动生成的方法存根
		return getSqlSession().selectOne(
				"TCreditReportCreditCardMapper.selectSelectiveMax", record);
	}
}