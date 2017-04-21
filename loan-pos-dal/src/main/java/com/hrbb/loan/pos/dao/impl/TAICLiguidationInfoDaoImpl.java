package com.hrbb.loan.pos.dao.impl;

import java.util.List;
import java.util.Map;

import org.mybatis.spring.support.SqlSessionDaoSupport;
import org.springframework.stereotype.Repository;

import com.hrbb.loan.pos.dao.TAICLiguidationInfoDao;
import com.hrbb.loan.pos.dao.entity.TAICLiguidationInfo;

@Repository("tAICLiguidationInfoDao")
public class TAICLiguidationInfoDaoImpl extends SqlSessionDaoSupport implements TAICLiguidationInfoDao{

	@Override
	public int deleteByPrimaryKey(Integer id) {
		// TODO Auto-generated method stub
		return 0;
	}

	@Override
	public int insert(TAICLiguidationInfo record) {
		// TODO Auto-generated method stub
		return 0;
	}

	@Override
	public int insertSelective(TAICLiguidationInfo record) {
		return getSqlSession().insert("TAICLiguidationInfoMapper.insertSelective", record);
	}

	@Override
	public TAICLiguidationInfo selectByPrimaryKey(Integer id) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public int updateByPrimaryKeySelective(TAICLiguidationInfo record) {
		// TODO Auto-generated method stub
		return 0;
	}

	@Override
	public int updateByPrimaryKey(TAICLiguidationInfo record) {
		// TODO Auto-generated method stub
		return 0;
	}

	@Override
	public List<Map<String, Object>> selectSelective(Map<String, Object> reqMap) {
		return getSqlSession().selectList("TAICLiguidationInfoMapper.selectSelective", reqMap);
	}

}
