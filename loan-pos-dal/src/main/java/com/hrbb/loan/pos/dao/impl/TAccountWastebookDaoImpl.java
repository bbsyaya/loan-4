package com.hrbb.loan.pos.dao.impl;

import java.util.Map;

import org.mybatis.spring.support.SqlSessionDaoSupport;
import org.springframework.stereotype.Repository;

import com.hrbb.loan.pos.dao.TAccountWastebookDao;
import com.hrbb.loan.pos.dao.entity.TAccountWastebook;
@Repository("tAccountWastebookDao")
public class TAccountWastebookDaoImpl  extends SqlSessionDaoSupport implements TAccountWastebookDao {

	@Override
	public int deleteByPrimaryKey(String runningId) {
		// TODO Auto-generated method stub
		return 0;
	}

	@Override
	public int insert(TAccountWastebook record) {
		// TODO Auto-generated method stub
		return 0;
	}

	@Override
	public int insertSelective(TAccountWastebook record) {
		// TODO Auto-generated method stub
		return 0;
	}

	@Override
	public TAccountWastebook selectByPrimaryKey(String runningId) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public int updateByPrimaryKeySelective(TAccountWastebook record) {
		// TODO Auto-generated method stub
		return 0;
	}

	@Override
	public int updateByPrimaryKey(TAccountWastebook record) {
		// TODO Auto-generated method stub
		return 0;
	}

	@Override
	public int insertAccountWastebook(Map<String, Object> wasteMap) {
		return getSqlSession().insert("TAccountWastebookMapper.insertAccountWastebook", wasteMap);
	}

}
