package com.hrbb.loan.pos.dao.impl;

import java.util.Map;

import org.mybatis.spring.support.SqlSessionDaoSupport;
import org.springframework.stereotype.Repository;

import com.hrbb.loan.pos.dao.TActivityCommonInfoDao;
import com.hrbb.loan.pos.dao.entity.TActivityCommonInfo;

@Repository("tActivityCommonDao")
public class TActivityCommonDaoImpl extends SqlSessionDaoSupport implements TActivityCommonInfoDao {

	@Override
	public int deleteByPrimaryKey(Integer id) {
		// TODO Auto-generated method stub
		return 0;
	}

	@Override
	public int insert(TActivityCommonInfo record) {
		// TODO Auto-generated method stub
		return 0;
	}

	@Override
	public int insertSelective(TActivityCommonInfo record) {
		// TODO Auto-generated method stub
		return 0;
	}

	@Override
	public TActivityCommonInfo selectByPrimaryKey(Integer id) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public int updateByPrimaryKeySelective(TActivityCommonInfo record) {
		// TODO Auto-generated method stub
		return 0;
	}

	@Override
	public int updateByPrimaryKey(TActivityCommonInfo record) {
		// TODO Auto-generated method stub
		return 0;
	}

	@Override
	public TActivityCommonInfo selectSelective(Map<String, Object> reqMap) {
		return getSqlSession().selectOne("TActivityCommonInfoMapper.selectSelective", reqMap);
	}

}
