package com.hrbb.loan.pos.dao.impl;

import java.util.List;
import java.util.Map;

import org.mybatis.spring.support.SqlSessionDaoSupport;
import org.springframework.stereotype.Repository;

import com.hrbb.loan.pos.dao.TActivityDimInfoDao;
import com.hrbb.loan.pos.dao.entity.TActivityDimInfo;
@Repository("tActivityDimInfoDao")
public class TActivityDimInfoDaoImpl extends SqlSessionDaoSupport implements TActivityDimInfoDao {

	@Override
	public int deleteByPrimaryKey(Integer id) {
		// TODO Auto-generated method stub
		return 0;
	}

	@Override
	public int insert(TActivityDimInfo record) {
		// TODO Auto-generated method stub
		return 0;
	}

	@Override
	public int insertSelective(TActivityDimInfo record) {
		return getSqlSession().insert("TActivityDimInfoMapper.insertSelective", record);
	}

	@Override
	public TActivityDimInfo selectByPrimaryKey(Integer id) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public int updateByPrimaryKeySelective(TActivityDimInfo record) {
		return getSqlSession().update("TActivityDimInfoMapper.updateByPrimaryKeySelective", record);
	}

	@Override
	public int updateByPrimaryKey(TActivityDimInfo record) {
		// TODO Auto-generated method stub
		return 0;
	}

	@Override
	public List<TActivityDimInfo> selectSelective(Map<String, Object> reqMap) {
		return getSqlSession().selectList("TActivityDimInfoMapper.selectSelective", reqMap);
	}

	@Override
	public String countSelective(Map<String, Object> reqMap) {
		return getSqlSession().selectOne("TActivityDimInfoMapper.countSelective", reqMap);
	}

}
