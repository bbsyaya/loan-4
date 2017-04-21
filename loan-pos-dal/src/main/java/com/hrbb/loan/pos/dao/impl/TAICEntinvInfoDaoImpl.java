package com.hrbb.loan.pos.dao.impl;

import java.util.List;
import java.util.Map;

import org.mybatis.spring.support.SqlSessionDaoSupport;
import org.springframework.stereotype.Repository;

import com.hrbb.loan.pos.dao.TAICEntinvInfoDao;
import com.hrbb.loan.pos.dao.entity.TAICEntinvInfo;

@Repository("tAICEntinvInfoDao")
public class TAICEntinvInfoDaoImpl extends SqlSessionDaoSupport implements TAICEntinvInfoDao{

	@Override
	public int deleteByPrimaryKey(Integer id) {
		// TODO Auto-generated method stub
		return 0;
	}

	@Override
	public int insert(TAICEntinvInfo record) {
		// TODO Auto-generated method stub
		return 0;
	}

	@Override
	public int insertSelective(TAICEntinvInfo record) {
		// TODO Auto-generated method stub
		return 0;
	}

	@Override
	public TAICEntinvInfo selectByPrimaryKey(Integer id) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public int updateByPrimaryKeySelective(TAICEntinvInfo record) {
		// TODO Auto-generated method stub
		return 0;
	}

	@Override
	public int updateByPrimaryKey(TAICEntinvInfo record) {
		// TODO Auto-generated method stub
		return 0;
	}

	@Override
	public int insertSelectiveMap(Map<String, Object> reqMap) {
		return getSqlSession().insert("TAICEntinvInfoMapper.insertSelectiveMap", reqMap);
	}

    @Override
    public List<Map<String, Object>> selectBySelectiveMap(Map<String, Object> reqMap) {
        return getSqlSession().selectList("TAICEntinvInfoMapper.selectBySelectiveMap", reqMap);
    }

	
}