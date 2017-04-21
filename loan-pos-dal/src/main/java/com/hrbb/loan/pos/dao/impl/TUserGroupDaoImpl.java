package com.hrbb.loan.pos.dao.impl;

import java.util.Map;

import org.mybatis.spring.support.SqlSessionDaoSupport;
import org.springframework.stereotype.Repository;

import com.hrbb.loan.pos.dao.TUserApprInfoDao;
import com.hrbb.loan.pos.dao.TUserGroupDao;
import com.hrbb.loan.pos.dao.entity.TUserApprInfo;
import com.hrbb.loan.pos.dao.entity.TUserGroupKey;

@Repository("tUserGroupDao")
public class TUserGroupDaoImpl extends SqlSessionDaoSupport implements TUserGroupDao {

	@Override
	public int deleteByPrimaryKey(TUserGroupKey key) {
		return getSqlSession().delete("TUserGroupMapper.deleteByPrimaryKey", key);
	}

	@Override
	public int insert(TUserGroupKey record) {
		return getSqlSession().insert("TUserGroupMapper.insert", record);
	}

	@Override
	public int insertSelective(TUserGroupKey record) {
		return getSqlSession().insert("TUserGroupMapper.insertSelective", record);
	}

	@Override
	public TUserGroupKey selectSelective(Map<String, Object> reqMap) {
		return getSqlSession().selectOne("TUserGroupMapper.selectSelective", reqMap);
	}

	@Override
	public Map<String, Object> selectGroupChief(Map<String, Object> reqMap) {
		return getSqlSession().selectOne("TUserGroupMapper.selectGroupChief", reqMap);
	}

	

}
