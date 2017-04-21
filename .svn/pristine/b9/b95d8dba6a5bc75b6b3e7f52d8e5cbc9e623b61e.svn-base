package com.hrbb.loan.pos.dao.impl;

import java.util.List;
import java.util.Map;

import org.mybatis.spring.support.SqlSessionDaoSupport;
import org.springframework.stereotype.Repository;

import com.hrbb.loan.pos.dao.TAICCaseInfoDao;
import com.hrbb.loan.pos.dao.entity.TAICCaseInfo;

@Repository("tAICCaseInfoDao")
public class TAICCaseInfoDaoImpl extends SqlSessionDaoSupport implements TAICCaseInfoDao{

	@Override
	public int deleteByPrimaryKey(Integer id) {
		// TODO Auto-generated method stub
		return 0;
	}

	@Override
	public int insert(TAICCaseInfo record) {
		// TODO Auto-generated method stub
		return 0;
	}

	@Override
	public int insertSelective(TAICCaseInfo record) {
		// TODO Auto-generated method stub
		return 0;
	}

	@Override
	public TAICCaseInfo selectByPrimaryKey(Integer id) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public int updateByPrimaryKeySelective(TAICCaseInfo record) {
		// TODO Auto-generated method stub
		return 0;
	}

	@Override
	public int updateByPrimaryKey(TAICCaseInfo record) {
		// TODO Auto-generated method stub
		return 0;
	}

	@Override
	public int insertSelectiveMap(Map<String, Object> reqMap) {
		return getSqlSession().insert("TAICCaseInfoMapper.insertSelectiveMap", reqMap);
	}

    @Override
    public List<Map<String, Object>> selectBySelectiveMap(Map<String, Object> reqMap) {
        return getSqlSession().selectList("TAICCaseInfoMapper.selectBySelectiveMap", reqMap);
    }

	
}