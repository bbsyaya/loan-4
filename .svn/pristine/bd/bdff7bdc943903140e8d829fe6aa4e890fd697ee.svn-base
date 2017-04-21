package com.hrbb.loan.pos.dao.impl;

import java.util.List;
import java.util.Map;

import org.mybatis.spring.support.SqlSessionDaoSupport;
import org.springframework.stereotype.Repository;

import com.hrbb.loan.pos.dao.TBankSerialnoInfoDao;
import com.hrbb.loan.pos.dao.entity.TBankSerialnoInfo;

/**
 *<h1></h1>
 *@author Johnson Song
 *@version Id: TBankSerialnoInfoDaoImpl.java, v 1.0 2015-3-5 上午10:52:30 Johnson Song Exp
 */
@Repository("tBankSerialnoInfoDao")
public class TBankSerialnoInfoDaoImpl extends SqlSessionDaoSupport implements TBankSerialnoInfoDao {
	

	@Override
	public int deleteByPrimaryKey(String serialNo) {
		return 0;
	}

	@Override
	public int insert(TBankSerialnoInfo record) {
		return 0;
	}

	@Override
	public int insertSelective(TBankSerialnoInfo record) {
		return 0;
	}

	@Override
	public TBankSerialnoInfo selectByPrimaryKey(String serialNo) {
		return null;
	}

	@Override
	public int updateByPrimaryKeySelective(TBankSerialnoInfo record) {
		return 0;
	}

	@Override
	public int updateByPrimaryKey(TBankSerialnoInfo record) {
		return 0;
	}

	@Override
	public List<Map<String, Object>> selectMap(Map<String, Object> reqMap) {
		return getSqlSession().selectList("TBankSerialnoInfoMapper.selectMap", reqMap);
	}
	
	@Override
    public List<Map<String, Object>> selectMapByCurrMonth(Map<String, Object> reqMap) {
        return getSqlSession().selectList("TBankSerialnoInfoMapper.selectMapByCurrMonth", reqMap);
    }
	
	@Override
	public int updateSelectiveMap(Map<String, Object> reqMap) {
		return getSqlSession().update("TBankSerialnoInfoMapper.updateSelectiveMap", reqMap);
	}

	@Override
	public int insertSelectiveMap(Map<String, Object> reqMap) {
		return getSqlSession().insert("TBankSerialnoInfoMapper.insertSelectiveMap", reqMap);
	}

	@Override
	public Long countMap(Map<String, Object> reqMap) {
		return getSqlSession().selectOne("TBankSerialnoInfoMapper.countMap", reqMap);
	}

}
