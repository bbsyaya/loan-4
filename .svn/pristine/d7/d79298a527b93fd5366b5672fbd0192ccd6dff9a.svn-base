package com.hrbb.loan.pos.dao.impl;

import java.util.List;
import java.util.Map;

import org.mybatis.spring.support.SqlSessionDaoSupport;
import org.springframework.stereotype.Repository;

import com.hrbb.loan.pos.dao.TAICOrderlistInfoDao;
import com.hrbb.loan.pos.dao.entity.TAICOrderlistInfo;

@Repository("tAICOrderlistInfoDao")
public class TAICOrderlistInfoDaoImpl extends SqlSessionDaoSupport implements TAICOrderlistInfoDao{

	@Override
	public int deleteByPrimaryKey(Integer id) {
		// TODO Auto-generated method stub
		return 0;
	}

	@Override
	public int insert(TAICOrderlistInfo record) {
		// TODO Auto-generated method stub
		return 0;
	}

	@Override
	public int insertSelective(TAICOrderlistInfo record) {
		// TODO Auto-generated method stub
		return 0;
	}

	@Override
	public TAICOrderlistInfo selectByPrimaryKey(Integer id) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public int updateByPrimaryKeySelective(TAICOrderlistInfo record) {
		// TODO Auto-generated method stub
		return 0;
	}

	@Override
	public int updateByPrimaryKey(TAICOrderlistInfo record) {
		// TODO Auto-generated method stub
		return 0;
	}

	@Override
	public int insertSelectiveMap(Map<String, Object> reqMap) {
		return getSqlSession().insert("TAICOrderlistInfoMapper.insertSelectiveMap", reqMap);
	}

	@Override
	public List<Map<String, Object>> queryMap(Map<String, Object> reqMap) {
		return getSqlSession().selectList("TAICOrderlistInfoMapper.selectMap", reqMap);
	}
    
}