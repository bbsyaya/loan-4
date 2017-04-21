package com.hrbb.loan.pos.dao.impl;

import java.util.List;
import java.util.Map;

import org.mybatis.spring.support.SqlSessionDaoSupport;
import org.springframework.stereotype.Repository;

import com.hrbb.loan.pos.dao.TCreditReportLoanInfoDao;
import com.hrbb.loan.pos.dao.entity.TCreditReportLoanInfo;

/**
 * <h1>贷款信息</h1>
 * 
 * @author Johnson Song
 * @version Id: tCreditReportLoanInfoDao.java, v 1.0 2015-3-2 上午10:56:57 Johnson
 *          Song Exp
 */
@Repository("tCreditReportLoanInfoDao")
public class TCreditReportLoanInfoDaoImpl extends SqlSessionDaoSupport implements TCreditReportLoanInfoDao {

	@Override
	public int deleteByPrimaryKey(String serialNo) {
		// TODO 自动生成的方法存根
		return 0;
	}

	@Override
	public int insert(TCreditReportLoanInfo record) {
		// TODO 自动生成的方法存根
		return 0;
	}

	@Override
	public int insertSelective(TCreditReportLoanInfo record) {
		// TODO 自动生成的方法存根
		return 0;
	}

	@Override
	public TCreditReportLoanInfo selectByPrimaryKey(String serialNo) {
		// TODO 自动生成的方法存根
		return null;
	}

	@Override
	public int updateByPrimaryKeySelective(TCreditReportLoanInfo record) {
		// TODO 自动生成的方法存根
		return 0;
	}

	@Override
	public int updateByPrimaryKey(TCreditReportLoanInfo record) {
		// TODO 自动生成的方法存根
		return 0;
	}

	@Override
	public int insertSelectiveMap(Map<String, Object> reqMap) {
		return getSqlSession().insert("TCreditReportLoanInfoMapper.insertSelectiveMap", reqMap);
	}
	
	@Override
	public TCreditReportLoanInfo selectSum(TCreditReportLoanInfo record) {
		// TODO 自动生成的方法存根
		return getSqlSession().selectOne("TCreditReportLoanInfoMapper.selectSum", record);
	}
	
	@Override
	public TCreditReportLoanInfo selectMax(TCreditReportLoanInfo record) {
		// TODO 自动生成的方法存根
		return getSqlSession().selectOne("TCreditReportLoanInfoMapper.selectMax", record);
	}
	
	@Override
	public TCreditReportLoanInfo selectSelectiveMax(TCreditReportLoanInfo record) {
		// TODO 自动生成的方法存根
		return getSqlSession().selectOne("TCreditReportLoanInfoMapper.selectSelectiveMax", record);
	}

	@Override
	public TCreditReportLoanInfo selectSumBalance(TCreditReportLoanInfo record) {
		// TODO 自动生成的方法存根
		return getSqlSession().selectOne("TCreditReportLoanInfoMapper.selectSumBalance", record);
	}
	
	@Override
	public List<TCreditReportLoanInfo> selectListNot(TCreditReportLoanInfo record) {
		// TODO 自动生成的方法存根
		return getSqlSession().selectList("TCreditReportLoanInfoMapper.selectListNot", record);
	}
	
	@Override
	public TCreditReportLoanInfo selectCount(TCreditReportLoanInfo record) {
		// TODO 自动生成的方法存根
		return getSqlSession().selectOne("TCreditReportLoanInfoMapper.selectCount", record);
	}
	
	@Override
	public TCreditReportLoanInfo selectSumBalanceNew(TCreditReportLoanInfo record) {
		// TODO 自动生成的方法存根
		return getSqlSession().selectOne("TCreditReportLoanInfoMapper.selectSumBalanceNew", record);
	}
	
	@Override
	public TCreditReportLoanInfo selectFirstIssueMonth(TCreditReportLoanInfo record) {
		// TODO 自动生成的方法存根
		return getSqlSession().selectOne("TCreditReportLoanInfoMapper.selectFirstIssueMonth", record);
	}
}
