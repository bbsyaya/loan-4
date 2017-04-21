package com.hrbb.loan.pos.dao.impl;

import java.util.List;
import java.util.Map;

import org.mybatis.spring.support.SqlSessionDaoSupport;
import org.springframework.stereotype.Repository;

import com.hrbb.loan.pos.dao.TRelativeInfoDao;
import com.hrbb.loan.pos.dao.entity.TRelativeInfo;

/**
 *<h1></h1>
 *@author Johnson Song
 *@version Id: TRelativeInfoDaoImpl.java, v 1.0 2015-3-4 下午3:34:03 Johnson Song Exp
 */
@Repository("tRelativeInfoDao")
public class TRelativeInfoDaoImpl extends SqlSessionDaoSupport implements TRelativeInfoDao {

	@Override
	public int deleteByPrimaryKey(String relativeId) {
		return 0;
	}

	@Override
	public int insert(TRelativeInfo record) {
		return 0;
	}

	@Override
	public int insertSelective(TRelativeInfo record) {
		return 0;
	}

	@Override
	public TRelativeInfo selectByPrimaryKey(String relativeId) {
		return getSqlSession().selectOne("TRelativeInfoMapper.selectByPrimaryKey", relativeId);
	}

	@Override
	public int updateByPrimaryKeySelective(TRelativeInfo record) {
		return 0;
	}

	@Override
	public int updateByPrimaryKey(TRelativeInfo record) {
		return 0;
	}

	@Override
	public List<Map<String, Object>> selectMap(Map<String, Object> map) {
		return getSqlSession().selectList("TRelativeInfoMapper.selectMap", map);
	}

	@Override
	public int insertMap(Map<String, Object> map) {
		return getSqlSession().insert("TRelativeInfoMapper.insertSelectiveMap", map);
	}

	@Override
	public int updateMap(Map<String, Object> map) {
		return getSqlSession().update("TRelativeInfoMapper.updateByPrimaryKeySelectiveMap", map);
	}

}
