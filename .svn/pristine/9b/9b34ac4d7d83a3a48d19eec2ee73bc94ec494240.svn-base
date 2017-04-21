package com.hrbb.loan.pos.dao.impl;

import java.util.List;
import java.util.Map;

import org.mybatis.spring.support.SqlSessionDaoSupport;
import org.springframework.stereotype.Repository;

import com.hrbb.loan.pos.dao.TActivityInfoDao;
import com.hrbb.loan.pos.dao.entity.TActivityInfo;

@Repository("tActivityInfoDao")
public class TActivityInfoDaoImpl extends SqlSessionDaoSupport implements TActivityInfoDao {

	@Override
	public int insert(TActivityInfo record) {
		return getSqlSession().insert("TActivityInfoMapper.insert", record);
	}

	@Override
	public int insertSelective(TActivityInfo record) {
		return getSqlSession().insert("TActivityInfoMapper.insertSelective", record);
	}

	@Override
	public List<TActivityInfo> selectSelective(Map<String, Object> reqMap) {
		return getSqlSession().selectList("TActivityInfoMapper.selectSelective", reqMap);
	}

	@Override
	public int updateSelective(TActivityInfo tActivityInfo) {
		return getSqlSession().update("TActivityInfoMapper.updateSelective", tActivityInfo);
	}

	@Override
	public String countSelective(Map<String, Object> reqMap) {
		return getSqlSession().selectOne("TActivityInfoMapper.countSelective", reqMap);
	}

}
