package com.hrbb.loan.pos.dao.impl;

import java.util.List;
import java.util.Map;

import org.mybatis.spring.support.SqlSessionDaoSupport;
import org.springframework.stereotype.Repository;

import com.hrbb.loan.pos.dao.TAICAlterInfoDao;
import com.hrbb.loan.pos.dao.entity.TAICAlterInfo;
@Repository("tAICAlterInfoDao")
public class TAICAlterInfoDaoImpl extends SqlSessionDaoSupport implements TAICAlterInfoDao {

	@Override
	public int deleteByPrimaryKey(Integer id) {
		// TODO Auto-generated method stub
		return 0;
	}

	@Override
	public int insert(TAICAlterInfo record) {
		// TODO Auto-generated method stub
		return 0;
	}

	@Override
	public int insertSelective(TAICAlterInfo record) {
		return getSqlSession().insert("TAICAlterInfoMapper.insertSelective", record);
	}

	@Override
	public TAICAlterInfo selectByPrimaryKey(Integer id) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public int updateByPrimaryKeySelective(TAICAlterInfo record) {
		// TODO Auto-generated method stub
		return 0;
	}

	@Override
	public int updateByPrimaryKey(TAICAlterInfo record) {
		// TODO Auto-generated method stub
		return 0;
	}

	@Override
	public List<Map<String, Object>> selectSelective(Map<String, Object> reqMap) {
		return getSqlSession().selectList("TAICAlterInfoMapper.selectSelective", reqMap);
	}

}
