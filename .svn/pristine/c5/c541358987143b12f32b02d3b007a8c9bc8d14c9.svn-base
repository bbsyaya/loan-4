package com.hrbb.loan.pos.dao.impl;

import java.util.List;

import org.mybatis.spring.support.SqlSessionDaoSupport;
import org.springframework.stereotype.Repository;

import com.hrbb.loan.pos.dao.TCfgChannelAccountDao;
import com.hrbb.loan.pos.dao.entity.TCfgChannelAccount;

@Repository("tCfgChannelAccountDao")
public class TCfgChannelAccountDaoImpl extends SqlSessionDaoSupport implements TCfgChannelAccountDao {

	@Override
	public int deleteByPrimaryKey(Integer id) {
		// TODO Auto-generated method stub
		return 0;
	}

	@Override
	public int insert(TCfgChannelAccount record) {
		// TODO Auto-generated method stub
		return 0;
	}

	@Override
	public int insertSelective(TCfgChannelAccount record) {
		// TODO Auto-generated method stub
		return 0;
	}

	@Override
	public TCfgChannelAccount selectByPrimaryKey(Integer id) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public int updateByPrimaryKeySelective(TCfgChannelAccount record) {
		// TODO Auto-generated method stub
		return 0;
	}

	@Override
	public int updateByPrimaryKey(TCfgChannelAccount record) {
		// TODO Auto-generated method stub
		return 0;
	}

	@Override
	public List<TCfgChannelAccount> getEffectAccount() {
		return getSqlSession().selectList("TCfgChannelAccountMapper.getEffectAccount");
	}

	@Override
	public TCfgChannelAccount getChannelAccount(String channel) {
		return getSqlSession().selectOne("TCfgChannelAccountMapper.getChannelAccount", channel);
	}

}
