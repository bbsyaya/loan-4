package com.hrbb.loan.pos.dao.impl;

import java.util.Map;

import org.mybatis.spring.support.SqlSessionDaoSupport;
import org.springframework.stereotype.Repository;

import com.hrbb.loan.pos.dao.TPaybackAllocateDao;
import com.hrbb.loan.pos.dao.entity.TPaybackAllocate;
@Repository("tPaybackAllocateDao")
public class TPaybackAllocateDaoImpl  extends SqlSessionDaoSupport implements TPaybackAllocateDao {

	@Override
	public int deleteByPrimaryKey(String importRunningId) {
		// TODO Auto-generated method stub
		return 0;
	}

	@Override
	public int insert(TPaybackAllocate record) {
		// TODO Auto-generated method stub
		return 0;
	}

	@Override
	public int insertSelective(TPaybackAllocate record) {
		// TODO Auto-generated method stub
		return 0;
	}

	@Override
	public TPaybackAllocate selectByPrimaryKey(String importRunningId) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public int updateByPrimaryKeySelective(TPaybackAllocate record) {
		// TODO Auto-generated method stub
		return 0;
	}

	@Override
	public int updateByPrimaryKey(TPaybackAllocate record) {
		// TODO Auto-generated method stub
		return 0;
	}

	@Override
	public int insertPaybackAllocate(Map<String, Object> map) {
		return getSqlSession().insert("TPaybackAllocateMapper.insertPaybackAllocate", map);
	}

}
