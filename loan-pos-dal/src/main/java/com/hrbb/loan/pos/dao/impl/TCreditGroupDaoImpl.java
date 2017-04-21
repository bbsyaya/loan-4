package com.hrbb.loan.pos.dao.impl;

import org.mybatis.spring.support.SqlSessionDaoSupport;
import org.springframework.stereotype.Repository;

import com.hrbb.loan.pos.dao.TCreditGroupDao;
import com.hrbb.loan.pos.dao.entity.TCreditGroup;

@Repository("tCreditGroupDao")
public class TCreditGroupDaoImpl extends SqlSessionDaoSupport implements TCreditGroupDao {

	@Override
	public int deleteByPrimaryKey(String groupId) {
		// TODO Auto-generated method stub
		return 0;
	}

	@Override
	public int insert(TCreditGroup record) {
		// TODO Auto-generated method stub
		return 0;
	}

	@Override
	public int insertSelective(TCreditGroup record) {
		return getSqlSession().insert("TCreditGroupMapper.insertSelective", record);
	}

	@Override
	public TCreditGroup selectByPrimaryKey(String groupId) {
		return getSqlSession().selectOne("TCreditGroupMapper.selectByPrimaryKey", groupId);
	}

	@Override
	public int updateByPrimaryKeySelective(TCreditGroup record) {
		return getSqlSession().update("TCreditGroupMapper.updateByPrimaryKeySelective", record);
	}

	@Override
	public int updateByPrimaryKey(TCreditGroup record) {
		return getSqlSession().update("TCreditGroupMapper.updateByPrimaryKey", record);
	}

}
