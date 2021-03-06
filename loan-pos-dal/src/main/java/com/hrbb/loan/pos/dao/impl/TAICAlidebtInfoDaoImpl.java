package com.hrbb.loan.pos.dao.impl;

import java.util.List;
import java.util.Map;

import org.mybatis.spring.support.SqlSessionDaoSupport;
import org.springframework.stereotype.Repository;

import com.hrbb.loan.pos.dao.TAICAlidebtInfoDao;
import com.hrbb.loan.pos.dao.entity.TAICAlidebtInfo;

@Repository("tAICAlidebtInfoDao")
public class TAICAlidebtInfoDaoImpl extends SqlSessionDaoSupport implements TAICAlidebtInfoDao{

	@Override
	public int deleteByPrimaryKey(Integer id) {
		// TODO Auto-generated method stub
		return 0;
	}

	@Override
	public int insert(TAICAlidebtInfo record) {
		// TODO Auto-generated method stub
		return 0;
	}

	@Override
	public int insertSelective(TAICAlidebtInfo record) {
		// TODO Auto-generated method stub
		return 0;
	}

	@Override
	public TAICAlidebtInfo selectByPrimaryKey(Integer id) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public int updateByPrimaryKeySelective(TAICAlidebtInfo record) {
		// TODO Auto-generated method stub
		return 0;
	}

	@Override
	public int updateByPrimaryKey(TAICAlidebtInfo record) {
		// TODO Auto-generated method stub
		return 0;
	}

	@Override
	public int insertSelectiveMap(Map<String, Object> reqMap) {
		return getSqlSession().insert("TAICAlidebtInfoMapper.insertSelectiveMap", reqMap);
	}

    @Override
    public List<Map<String, Object>> selectBySelectiveMap(Map<String, Object> reqMap) {
        return getSqlSession().selectList("TAICAlidebtInfoMapper.selectBySelectiveMap", reqMap);
    }

}