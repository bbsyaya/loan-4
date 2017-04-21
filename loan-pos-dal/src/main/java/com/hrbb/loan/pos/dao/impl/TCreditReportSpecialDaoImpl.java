package com.hrbb.loan.pos.dao.impl;

import java.util.Map;

import org.mybatis.spring.support.SqlSessionDaoSupport;
import org.springframework.stereotype.Repository;

import com.hrbb.loan.pos.dao.TCreditReportSpecialDao;
import com.hrbb.loan.pos.dao.entity.TCreditReportSpecial;

/**
 *<h1>贷款特殊信息</h1>
 *@author Johnson Song
 *@version Id: TCreditApplyDaoImpl.java, v 1.0 2015-2-15 上午11:03:53 Johnson Song Exp
 */
@Repository("tCreditReportSpecialDao")
public class TCreditReportSpecialDaoImpl extends SqlSessionDaoSupport implements TCreditReportSpecialDao {

	@Override
	public int deleteByPrimaryKey(String serialNo) {
		// TODO 自动生成的方法存根
		return 0;
	}

	@Override
	public int insert(TCreditReportSpecial record) {
		// TODO 自动生成的方法存根
		return 0;
	}

	@Override
	public int insertSelective(TCreditReportSpecial record) {
		// TODO 自动生成的方法存根
		return 0;
	}

	@Override
	public TCreditReportSpecial selectByPrimaryKey(String serialNo) {
		// TODO 自动生成的方法存根
		return null;
	}
	
	@Override
	public TCreditReportSpecial selectSelective(TCreditReportSpecial record) {
		// TODO 自动生成的方法存根
		return getSqlSession().selectOne("TCreditReportSpecialMapper.selectSelective", record);
	}

	@Override
	public int updateByPrimaryKeySelective(TCreditReportSpecial record) {
		// TODO 自动生成的方法存根
		return 0;
	}

	@Override
	public int updateByPrimaryKey(TCreditReportSpecial record) {
		// TODO 自动生成的方法存根
		return 0;
	}

	@Override
	public int insertSelectiveMap(Map<String, Object> reqMap) {
		return getSqlSession().insert("TCreditReportSpecialMapper.insertSelectiveMap", reqMap);
	}
}
