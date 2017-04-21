package com.hrbb.loan.pos.dao.impl;

import java.util.List;
import java.util.Map;

import org.mybatis.spring.support.SqlSessionDaoSupport;
import org.springframework.stereotype.Repository;

import com.hrbb.loan.pos.dao.TChannelBankInfoDao;
import com.hrbb.loan.pos.dao.entity.TChannelBankInfo;

@Repository("tChannelBankDao")
public class TChannelBankDaoImpl extends SqlSessionDaoSupport implements TChannelBankInfoDao{

	@Override
	public int deleteByPrimaryKey(Integer serial) {
		// TODO Auto-generated method stub
		return 0;
	}

	@Override
	public int insert(TChannelBankInfo record) {
		// TODO Auto-generated method stub
		return 0;
	}

	@Override
	public int insertSelective(TChannelBankInfo record) {
		// TODO Auto-generated method stub
		return 0;
	}

	@Override
	public TChannelBankInfo selectByPrimaryKey(Integer serial) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public int updateByPrimaryKeySelective(TChannelBankInfo record) {
		// TODO Auto-generated method stub
		return 0;
	}

	@Override
	public int updateByPrimaryKey(TChannelBankInfo record) {
		// TODO Auto-generated method stub
		return 0;
	}

	@Override
	public List<Map<String, Object>> getSeletiveMap(Map<String, Object> reqMap) {
		return getSqlSession().selectList("TChannelBankInfoMapper.getSelectiveMap", reqMap);
	}
	
	

}
