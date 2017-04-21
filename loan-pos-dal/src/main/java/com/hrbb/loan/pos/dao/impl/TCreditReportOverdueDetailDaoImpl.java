package com.hrbb.loan.pos.dao.impl;

import java.util.Map;

import org.mybatis.spring.support.SqlSessionDaoSupport;
import org.springframework.stereotype.Repository;

import com.hrbb.loan.pos.dao.TCreditReportOverdueDetailDao;
import com.hrbb.loan.pos.dao.entity.TCreditReportOverdueDetail;

/**
 *<h1>未销户贷记卡信息汇总</h1>
 *@author Johnson Song
 *@version Id: TCreditReportOverdueDetailDaoImpl.java, v 1.0 2015-2-15 上午11:03:53 Johnson Song Exp
 */
@Repository("tCreditReportOverdueDetailDao")
public class TCreditReportOverdueDetailDaoImpl extends SqlSessionDaoSupport implements
		TCreditReportOverdueDetailDao {

	@Override
	public int deleteByPrimaryKey(String serialNo) {
		// TODO 自动生成的方法存根
		return 0;
	}

	@Override
	public int insert(TCreditReportOverdueDetail record) {
		// TODO 自动生成的方法存根
		return 0;
	}

	@Override
	public int insertSelective(TCreditReportOverdueDetail record) {
		// TODO 自动生成的方法存根
		return 0;
	}

	@Override
	public TCreditReportOverdueDetail selectByPrimaryKey(String serialNo) {
		// TODO 自动生成的方法存根
		return null;
	}

	@Override
	public int updateByPrimaryKeySelective(TCreditReportOverdueDetail record) {
		// TODO 自动生成的方法存根
		return 0;
	}

	@Override
	public int updateByPrimaryKey(TCreditReportOverdueDetail record) {
		// TODO 自动生成的方法存根
		return 0;
	}

	@Override
	public int insertSelectiveMap(Map<String, Object> reqMap) {
		return getSqlSession().insert("TCreditReportOverdueDetailMapper.insertSelectiveMap", reqMap);
	}
	
	@Override
	public TCreditReportOverdueDetail selectByCreditCard(
			TCreditReportOverdueDetail record) {
		// TODO 自动生成的方法存根
		return getSqlSession().selectOne("TCreditReportOverdueDetailMapper.selectByCreditCard", record);
	}
	
	@Override
	public TCreditReportOverdueDetail selectByLoanInfo(
			TCreditReportOverdueDetail record) {
		// TODO 自动生成的方法存根
		return getSqlSession().selectOne("TCreditReportOverdueDetailMapper.selectByLoanInfo", record);
	}

}
