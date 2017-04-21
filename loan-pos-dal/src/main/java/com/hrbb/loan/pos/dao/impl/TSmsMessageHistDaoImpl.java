package com.hrbb.loan.pos.dao.impl;

import java.util.Map;

import org.mybatis.spring.support.SqlSessionDaoSupport;
import org.springframework.stereotype.Repository;

import com.hrbb.loan.pos.dao.TSmsMessageHistDao;
import com.hrbb.loan.pos.dao.entity.TSmsMessageHist;

@Repository("tSmsMessageHistDao")
public class TSmsMessageHistDaoImpl extends SqlSessionDaoSupport implements TSmsMessageHistDao {

	@Override
	public int deleteByPrimaryKey(Integer id) {
		// TODO Auto-generated method stub
		return 0;
	}

	@Override
	public int insert(TSmsMessageHist record) {
		// TODO Auto-generated method stub
		return 0;
	}

	@Override
	public int insertSelective(TSmsMessageHist record) {
		// TODO Auto-generated method stub
		return 0;
	}

	@Override
	public TSmsMessageHist selectByPrimaryKey(Integer id) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public int updateByPrimaryKeySelective(TSmsMessageHist record) {
		// TODO Auto-generated method stub
		return 0;
	}

	@Override
	public int updateByPrimaryKey(TSmsMessageHist record) {
		// TODO Auto-generated method stub
		return 0;
	}

	@Override
	public int insertSelectiveMap(Map<String, Object> reqMap) {
		return getSqlSession().insert("TSmsMessageHistMapper.insertSelectiveMap", reqMap);
	}

}
