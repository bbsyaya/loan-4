package com.hrbb.loan.pos.dao.impl;

import java.util.List;
import java.util.Map;

import org.mybatis.spring.support.SqlSessionDaoSupport;
import org.springframework.stereotype.Repository;

import com.hrbb.loan.pos.dao.TActivityContentInfoDao;
import com.hrbb.loan.pos.dao.entity.TActivityContentInfo;

@Repository("tActivityContentInfoDao")
public class TActivityContentInfoDaoImpl extends SqlSessionDaoSupport implements TActivityContentInfoDao {

	@Override
	public int deleteByPrimaryKey(Integer id) {
		// TODO Auto-generated method stub
		return 0;
	}

	@Override
	public int insert(TActivityContentInfo record) {
		// TODO Auto-generated method stub
		return 0;
	}

	@Override
	public int insertSelective(TActivityContentInfo record) {
		return getSqlSession().insert("TActivityContentInfoMapper.insertSelective", record);
	}

	@Override
	public TActivityContentInfo selectByPrimaryKey(Integer id) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public int updateByPrimaryKeySelective(TActivityContentInfo record) {
		return getSqlSession().update("TActivityContentInfoMapper.updateByPrimaryKeySelective", record);
	}

	@Override
	public int updateByPrimaryKey(TActivityContentInfo record) {
		// TODO Auto-generated method stub
		return 0;
	}

	@Override
	public List<TActivityContentInfo> selectSelective(Map<String, Object> reqMap) {
		return getSqlSession().selectList("TActivityContentInfoMapper.selectSelective", reqMap);
	}

	@Override
	public String countSelective(Map<String, Object> reqMap) {
		return getSqlSession().selectOne("TActivityContentInfoMapper.countSelective", reqMap);
	}

}
