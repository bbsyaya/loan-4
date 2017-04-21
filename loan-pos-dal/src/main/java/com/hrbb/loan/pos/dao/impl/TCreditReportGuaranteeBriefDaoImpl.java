package com.hrbb.loan.pos.dao.impl;

import java.util.Map;

import org.mybatis.spring.support.SqlSessionDaoSupport;
import org.springframework.stereotype.Repository;

import com.hrbb.loan.pos.dao.TCreditReportGuaranteeBriefDao;
import com.hrbb.loan.pos.dao.entity.TCreditReportGuaranteeBrief;

@Repository("tCreditReportGuaranteeBriefDao")
public class TCreditReportGuaranteeBriefDaoImpl extends SqlSessionDaoSupport implements
		TCreditReportGuaranteeBriefDao {

	@Override
	public int deleteByPrimaryKey(String reportNo) {
		// TODO Auto-generated method stub
		return 0;
	}

	@Override
	public int insert(TCreditReportGuaranteeBrief record) {
		// TODO Auto-generated method stub
		return 0;
	}

	@Override
	public int insertSelective(TCreditReportGuaranteeBrief record) {
		// TODO Auto-generated method stub
		return 0;
	}

	@Override
	public TCreditReportGuaranteeBrief selectByPrimaryKey(String reportNo) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public int updateByPrimaryKeySelective(TCreditReportGuaranteeBrief record) {
		// TODO Auto-generated method stub
		return 0;
	}

	@Override
	public int updateByPrimaryKey(TCreditReportGuaranteeBrief record) {
		// TODO Auto-generated method stub
		return 0;
	}

	@Override
	public int insertSelectiveMap(Map<String, Object> reqMap) {
		return getSqlSession().insert("TCreditReportGuaranteeBriefMapper.insertSelectiveMap", reqMap);
	}

}
