package com.hrbb.loan.pos.dao.impl;

import java.util.List;
import java.util.Map;

import org.mybatis.spring.support.SqlSessionDaoSupport;
import org.springframework.stereotype.Repository;

import com.hrbb.loan.pos.dao.TAICFrinvInfoDao;
import com.hrbb.loan.pos.dao.entity.TAICFrinvInfo;

@Repository
public class TAICFrinvInfoDaoImp extends SqlSessionDaoSupport implements TAICFrinvInfoDao{

	@Override
	public int deleteByPrimaryKey(Integer id) {
		// TODO Auto-generated method stub
		return 0;
	}

	@Override
	public int insert(TAICFrinvInfo record) {
		// TODO Auto-generated method stub
		return 0;
	}

	@Override
	public int insertSelective(TAICFrinvInfo record) {
		// TODO Auto-generated method stub
		return 0;
	}

	@Override
	public TAICFrinvInfo selectByPrimaryKey(Integer id) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public int updateByPrimaryKeySelective(TAICFrinvInfo record) {
		// TODO Auto-generated method stub
		return 0;
	}

	@Override
	public int updateByPrimaryKey(TAICFrinvInfo record) {
		// TODO Auto-generated method stub
		return 0;
	}

	@Override
	public int insertFrinvInfoMap(Map<String, Object> reqMap) {
		return getSqlSession().insert("TAICFrinvInfoMapper.insertSelectiveMap", reqMap);
	}

    @Override
    public List<Map<String, Object>> selectBySelectiveMap(Map<String, Object> reqMap) {
        return getSqlSession().selectList("TAICFrinvInfoMapper.selectBySelectiveMap", reqMap);
    }
	
}