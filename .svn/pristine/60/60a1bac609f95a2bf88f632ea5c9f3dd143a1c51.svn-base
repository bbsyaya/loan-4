package com.hrbb.loan.pos.dao.impl;

import java.util.List;
import java.util.Map;

import org.mybatis.spring.support.SqlSessionDaoSupport;
import org.springframework.stereotype.Repository;

import com.hrbb.loan.pos.dao.TAICMorguaInfoDao;
import com.hrbb.loan.pos.dao.entity.TAICMorguaInfo;

@Repository("tAICMorguaInfoDao")
public class TAICMorguaInfoDaoImpl extends SqlSessionDaoSupport implements TAICMorguaInfoDao {

	@Override
	public int deleteByPrimaryKey(Integer id) {
		// TODO Auto-generated method stub
		return 0;
	}

	@Override
	public int insert(TAICMorguaInfo record) {
		// TODO Auto-generated method stub
		return 0;
	}

	@Override
	public int insertSelective(TAICMorguaInfo record) {
		return getSqlSession().insert("TAICMorguaInfoMapper.insertSelective", record);
	}

	@Override
	public TAICMorguaInfo selectByPrimaryKey(Integer id) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public int updateByPrimaryKeySelective(TAICMorguaInfo record) {
		// TODO Auto-generated method stub
		return 0;
	}

	@Override
	public int updateByPrimaryKey(TAICMorguaInfo record) {
		// TODO Auto-generated method stub
		return 0;
	}

	@Override
	public List<Map<String, Object>> selectSelective(Map<String, Object> reqMap) {
		return getSqlSession().selectList("TAICMorguaInfoMapper.selectSelective", reqMap);
	}

}
