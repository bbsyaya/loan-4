package com.hrbb.loan.pos.dao.impl;

import java.util.Map;

import org.mybatis.spring.support.SqlSessionDaoSupport;
import org.springframework.stereotype.Repository;

import com.hrbb.loan.pos.dao.TCreditReportQueryDetailDao;
import com.hrbb.loan.pos.dao.entity.TCreditReportQueryDetail;

/**
 * <h1>信贷审批查询记录明细</h1>
 * 
 * @author Johnson Song
 * @version Id: TCreditReportQueryDetailDaoImpl.java, v 1.0 2015-3-2 上午10:56:57
 *          Johnson Song Exp
 */
@Repository("tCreditReportQueryDetailDao")
public class TCreditReportQueryDetailDaoImpl extends SqlSessionDaoSupport implements
		TCreditReportQueryDetailDao {

	@Override
	public int deleteByPrimaryKey(String serialNo) {
		// TODO 自动生成的方法存根
		return 0;
	}

	@Override
	public int insert(TCreditReportQueryDetail record) {
		// TODO 自动生成的方法存根
		return 0;
	}

	@Override
	public int insertSelective(TCreditReportQueryDetail record) {
		// TODO 自动生成的方法存根
		return 0;
	}

	@Override
	public TCreditReportQueryDetail selectByPrimaryKey(String serialNo) {
		// TODO 自动生成的方法存根
		return null;
	}

	@Override
	public int updateByPrimaryKeySelective(TCreditReportQueryDetail record) {
		// TODO 自动生成的方法存根
		return 0;
	}

	@Override
	public int updateByPrimaryKey(TCreditReportQueryDetail record) {
		// TODO 自动生成的方法存根
		return 0;
	}

	@Override
	public int insertSelectiveMap(Map<String, Object> reqMap) {
		return getSqlSession().insert("TCreditReportQueryDetailMapper.insertSelectiveMap", reqMap);
	}
	
	@Override
	public TCreditReportQueryDetail selectCount(TCreditReportQueryDetail record) {
		// TODO 自动生成的方法存根
		return getSqlSession().selectOne(
				"TCreditReportQueryDetailMapper.selectCount", record);
	}
	
	@Override
	public TCreditReportQueryDetail selectCountMap(TCreditReportQueryDetail record) {
		// TODO 自动生成的方法存根
		return getSqlSession().selectOne(
				"TCreditReportQueryDetailMapper.selectCountMap", record);
	}
}
