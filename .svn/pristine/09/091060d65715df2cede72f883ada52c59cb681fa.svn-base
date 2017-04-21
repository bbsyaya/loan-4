package com.hrbb.loan.pos.dao.impl;

import java.util.List;
import java.util.Map;

import org.mybatis.spring.support.SqlSessionDaoSupport;
import org.springframework.stereotype.Repository;

import com.hrbb.loan.pos.dao.TCreditApplyAprvHisDao;
import com.hrbb.loan.pos.dao.entity.TCreditApplyAprvHis;
import com.hrbb.loan.pos.dao.entity.TCreditApplyAprvHisKey;

/**
 *<h1></h1>
 *@author Johnson Song
 *@version Id: TCreditApplyAprvHisDaoImpl.java, v 1.0 2015-2-15 上午10:35:28 Johnson Song Exp
 */
@Repository("tCreditApplyAprvHisDao")
public class TCreditApplyAprvHisDaoImpl extends SqlSessionDaoSupport implements TCreditApplyAprvHisDao {

	@Override
	public int deleteByPrimaryKey(TCreditApplyAprvHisKey key) {
		return getSqlSession().delete("TCreditApplyAprvHisMapper.deleteByPrimaryKey", key);
	}

	@Override
	public int insert(TCreditApplyAprvHis record) {
		return getSqlSession().insert("TCreditApplyAprvHisMapper.insert", record);
	}

	@Override
	public int insertSelective(TCreditApplyAprvHis record) {
		return getSqlSession().insert("TCreditApplyAprvHisMapper.insertSelective", record);
	}

	@Override
	public TCreditApplyAprvHis selectByPrimaryKey(TCreditApplyAprvHisKey key) {
		return getSqlSession().selectOne("TCreditApplyAprvHisMapper.selectByPrimaryKey", key);
	}

	@Override
	public List<TCreditApplyAprvHis> selectSelective(Map<String, Object> map) {
		return getSqlSession().selectList("TCreditApplyAprvHisMapper.select", map);
	}

	@Override
	public int updateByPrimaryKeySelective(TCreditApplyAprvHis record) {
		return getSqlSession().update("TCreditApplyAprvHisMapper.updateByPrimaryKeySelective", record);
	}

	@Override
	public int updateByPrimaryKey(TCreditApplyAprvHis record) {
		return getSqlSession().update("TCreditApplyAprvHisMapper.updateByPrimaryKey", record);
	}

}
