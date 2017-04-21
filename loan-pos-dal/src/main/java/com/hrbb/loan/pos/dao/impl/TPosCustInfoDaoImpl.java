package com.hrbb.loan.pos.dao.impl;

import java.util.List;
import java.util.Map;

import org.mybatis.spring.support.SqlSessionDaoSupport;
import org.springframework.stereotype.Repository;

import com.hrbb.loan.pos.dao.TPosCustInfoDao;
import com.hrbb.loan.pos.dao.entity.TPosCustInfo;

/**
 *<h1></h1>
 *@author Johnson Song
 *@version Id: TPosCustInfoDaoImpl.java, v 1.0 2015-3-2 上午10:58:14 Johnson Song Exp
 */
@Repository("tPosCustInfoDao")
public class TPosCustInfoDaoImpl extends SqlSessionDaoSupport implements TPosCustInfoDao {

	@Override
	public int deleteByPrimaryKey(String posCustId) {
		return getSqlSession().delete("TPosCustInfoMapper.deleteByPrimaryKey", posCustId);
	}

	@Override
	public int insert(TPosCustInfo record) {
		return getSqlSession().insert("TPosCustInfoMapper.insert", record);
	}

	@Override
	public int insertSelective(TPosCustInfo record) {
		return getSqlSession().insert("TPosCustInfoMapper.insertSelective", record);
	}

	@Override
	public TPosCustInfo selectByPrimaryKey(String posCustId) {
		return getSqlSession().selectOne("TPosCustInfoMapper.selectByPrimaryKey", posCustId);
	}

	@Override
	public int updateByPrimaryKeySelective(TPosCustInfo record) {
		return getSqlSession().update("TPosCustInfoMapper.updateByPrimaryKeySelective", record);
	}

	@Override
	public int updateByPrimaryKey(TPosCustInfo record) {
		return getSqlSession().update("TPosCustInfoMapper.updateByPrimaryKey", record);
	}

	@Override
	public int insertSelectiveMap(Map<String, Object> map) {
		return getSqlSession().insert("TPosCustInfoMapper.insertSelectiveMap", map);
	}

	@Override
	public List<Map<String, Object>> selectMap(Map<String, Object> reqMap) {
		return getSqlSession().selectList("TPosCustInfoMapper.selectMap", reqMap);
	}

	@Override
	public int updateByPrimaryKeySelectiveMap(Map<String, Object> reqMap) {
		return getSqlSession().update("TPosCustInfoMapper.updateByPrimaryKeySelectiveMap", reqMap);
	}
	
    public int updateMap(Map<String, Object> reqMap){
        return getSqlSession().update("TPosCustInfoMapper.updateByPrimaryKeySelectiveMap", reqMap);
    }
	

}
