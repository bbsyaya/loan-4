package com.hrbb.loan.pos.dao.impl;

import java.util.List;
import java.util.Map;

import org.mybatis.spring.support.SqlSessionDaoSupport;
import org.springframework.stereotype.Repository;

import com.hrbb.loan.pos.dao.TAICMordetailInfoDao;
import com.hrbb.loan.pos.dao.entity.TAICMordetailInfo;
@Repository("tAICMordetailInfoDao")
public class TAICMordetailInfoDaoImpl extends SqlSessionDaoSupport implements TAICMordetailInfoDao {

	@Override
	public int deleteByPrimaryKey(Integer id) {
		// TODO Auto-generated method stub
		return 0;
	}

	@Override
	public int insert(TAICMordetailInfo record) {
		// TODO Auto-generated method stub
		return 0;
	}

	@Override
	public int insertSelective(TAICMordetailInfo record) {
		return getSqlSession().insert("TAICMordetailInfoMapper.insertSelective", record);
	}

	@Override
	public TAICMordetailInfo selectByPrimaryKey(Integer id) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public int updateByPrimaryKeySelective(TAICMordetailInfo record) {
		// TODO Auto-generated method stub
		return 0;
	}

	@Override
	public int updateByPrimaryKey(TAICMordetailInfo record) {
		// TODO Auto-generated method stub
		return 0;
	}

	@Override
	public List<Map<String, Object>> selectSelective(Map<String, Object> reqMap) {
		return getSqlSession().selectList("TAICMordetailInfoMapper.selectSelective", reqMap);
	}

}
