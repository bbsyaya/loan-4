package com.hrbb.loan.pos.dao.impl;

import java.util.List;
import java.util.Map;

import org.mybatis.spring.support.SqlSessionDaoSupport;
import org.springframework.stereotype.Repository;

import com.hrbb.loan.pos.dao.TCreditReportBriefDao;
import com.hrbb.loan.pos.dao.entity.TCreditReportBrief;

/**
 * <h1>报告概要</h1>
 * 
 * @author Johnson Song
 * @version Id: TCreditApplyDaoImpl.java, v 1.0 2015-2-15 上午11:03:53 Johnson
 *          Song Exp
 */
@Repository("tCreditReportBriefDao")
public class TCreditReportBriefDaoImpl extends SqlSessionDaoSupport implements
		TCreditReportBriefDao {

	@Override
	public int deleteByPrimaryKey(String reportNo) {
		// TODO 自动生成的方法存根
		return 0;
	}

	@Override
	public int insert(TCreditReportBrief record) {
		// TODO 自动生成的方法存根
		return 0;
	}

	@Override
	public int insertSelective(TCreditReportBrief record) {
		// TODO 自动生成的方法存根
		return 0;
	}

	@Override
	public TCreditReportBrief selectByPrimaryKey(String reportNo) {
		// TODO 自动生成的方法存根
		return null;
	}

	@Override
	public int updateByPrimaryKeySelective(TCreditReportBrief record) {
		// TODO 自动生成的方法存根
		return 0;
	}

	@Override
	public int updateByPrimaryKey(TCreditReportBrief record) {
		// TODO 自动生成的方法存根
		return 0;
	}

	@Override
	public TCreditReportBrief selectOne(TCreditReportBrief record) {
		return getSqlSession().selectOne("TCreditReportBriefMapper.selectOne",
				record);
	}

	@Override
	public int insertSelectivMap(Map<String, Object> reqMap) {
		return getSqlSession().insert(
				"TCreditReportBriefMapper.insertSelectiveMap", reqMap);
	}

	@Override
	public TCreditReportBrief selectOneByCertNo(Map<String, Object> reqMap) {
		return getSqlSession().selectOne(
				"TCreditReportBriefMapper.selectOneByCertNo", reqMap);
	}

	@Override
	public List<Map<String, Object>> selectByMap(Map<String, Object> reqMap) {
		return getSqlSession().selectList("TCreditReportBriefMapper.selectByMap", reqMap);
	}

	@Override
	public int updateMap(Map<String, Object> reqMap) {
		return getSqlSession().update("TCreditReportBriefMapper.updateMap", reqMap);
	}
}
