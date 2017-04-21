package com.hrbb.loan.pos.dao.impl;

import java.util.List;
import java.util.Map;

import org.mybatis.spring.support.SqlSessionDaoSupport;
import org.springframework.stereotype.Repository;

import com.hrbb.loan.pos.dao.TAICPunishBreakInfoDao;
import com.hrbb.loan.pos.dao.entity.TAICPunishBreakInfo;

@Repository("tAICPunishBreakInfoDao")
public class TAICPunishBreakInfoDaoImpl extends SqlSessionDaoSupport implements TAICPunishBreakInfoDao{

	@Override
	public int deleteByPrimaryKey(Integer id) {
		// TODO Auto-generated method stub
		return 0;
	}

	@Override
	public int insert(TAICPunishBreakInfo record) {
		// TODO Auto-generated method stub
		return 0;
	}

	@Override
	public int insertSelective(TAICPunishBreakInfo record) {
		// TODO Auto-generated method stub
		return 0;
	}

	@Override
	public TAICPunishBreakInfo selectByPrimaryKey(Integer id) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public int updateByPrimaryKeySelective(TAICPunishBreakInfo record) {
		// TODO Auto-generated method stub
		return 0;
	}

	@Override
	public int updateByPrimaryKey(TAICPunishBreakInfo record) {
		// TODO Auto-generated method stub
		return 0;
	}

	@Override
	public int insertSelectiveMap(Map<String, Object> reqMap) {
		return getSqlSession().insert("TAICPunishBreakInfoMapper.insertSelectiveMap", reqMap);
	}

    @Override
    public List<Map<String, Object>> selectBySelectiveMap(Map<String, Object> reqMap) {
        return getSqlSession().selectList("TAICPunishBreakInfoMapper.selectBySelectiveMap", reqMap);
    }
	
}