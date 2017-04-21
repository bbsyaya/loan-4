package com.hrbb.loan.pos.dao.impl;

import java.util.Map;

import org.mybatis.spring.support.SqlSessionDaoSupport;
import org.springframework.stereotype.Repository;

import com.hrbb.loan.pos.dao.THistoryPaybackAccountDao;
import com.hrbb.loan.pos.dao.entity.THistoryPaybackAccount;
@Repository("tHistoryPaybackAccountDao")
public class THistoryPaybackAccountDaoImpl extends SqlSessionDaoSupport implements THistoryPaybackAccountDao {

	@Override
	public int deleteByPrimaryKey(String innerRunningId) {
		// TODO Auto-generated method stub
		return 0;
	}

	@Override
	public int insert(THistoryPaybackAccount record) {
		// TODO Auto-generated method stub
		return 0;
	}

	@Override
	public int insertSelective(THistoryPaybackAccount record) {
		// TODO Auto-generated method stub
		return 0;
	}

	@Override
	public THistoryPaybackAccount selectByPrimaryKey(String innerRunningId) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public int updateByPrimaryKeySelective(THistoryPaybackAccount record) {
		// TODO Auto-generated method stub
		return 0;
	}

	@Override
	public int updateByPrimaryKey(THistoryPaybackAccount record) {
		// TODO Auto-generated method stub
		return 0;
	}

	@Override
	public int getHistroyAccountNumber(Map<String, Object> reqMap) {
		return getSqlSession().selectOne("THistoryPaybackAccountMapper.getHistroyAccountNumber",reqMap);
	}

}
