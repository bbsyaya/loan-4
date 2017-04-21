package com.hrbb.loan.pos.dao.impl;

import java.util.List;
import java.util.Map;

import org.mybatis.spring.support.SqlSessionDaoSupport;
import org.springframework.stereotype.Repository;

import com.hrbb.loan.pos.dao.TApprovingRateUplimitConfigDao;
import com.hrbb.loan.pos.dao.entity.TApprovingRateUplimitConfig;
@Repository("tApprovingRateUplimitConfigDao")
public class TApprovingRateUplimitConfigDaoImpl extends SqlSessionDaoSupport implements TApprovingRateUplimitConfigDao {

	@Override
	public int deleteByPrimaryKey(Integer id) {
		// TODO Auto-generated method stub
		return 0;
	}

	@Override
	public int insert(TApprovingRateUplimitConfig record) {
		// TODO Auto-generated method stub
		return 0;
	}

	@Override
	public int insertSelective(TApprovingRateUplimitConfig record) {
		// TODO Auto-generated method stub
		return 0;
	}

	@Override
	public int updateByPrimaryKeySelective(TApprovingRateUplimitConfig record) {
		// TODO Auto-generated method stub
		return 0;
	}

	@Override
	public int updateByPrimaryKey(TApprovingRateUplimitConfig record) {
		// TODO Auto-generated method stub
		return 0;
	}

	@Override
	public List<TApprovingRateUplimitConfig> selectListBySelective(Map<String, Object> reqMap) {
		 return getSqlSession().selectList("TApprovingRateUplimitConfigMapper.selectListBySelective", reqMap);
	}

	@Override
	public long countListBySelective(Map<String, Object> reqMap) {
		return getSqlSession().selectOne("TApprovingRateUplimitConfigMapper.countListBySelective",reqMap);
	}

	@Override
	public TApprovingRateUplimitConfig selectApprovingRateUplimitConfigByRegcode(String string) {
		 return getSqlSession().selectOne("TApprovingRateUplimitConfigMapper.selectApprovingRateUplimitConfigByRegcode", string);
	}

	@Override
	public int saveApprovingRateUplimitConfig(Map<String, Object> reqMap) {
		 return getSqlSession().insert("TApprovingRateUplimitConfigMapper.saveApprovingRateUplimitConfig", reqMap);
	}

	@Override
	public TApprovingRateUplimitConfig selectByPrimaryKey(Integer id) {
		 return getSqlSession().selectOne("TApprovingRateUplimitConfigMapper.selectByPrimaryKey", id);
	}

	@Override
	public int updateByUpdateMap(Map<String, Object> reqMap) {
		 return getSqlSession().update("TApprovingRateUplimitConfigMapper.updateByUpdateMap", reqMap);
	}

	@Override
	public int deleteApprovingRateUplimitConfigByID(String id) {
		 return getSqlSession().delete("TApprovingRateUplimitConfigMapper.deleteApprovingRateUplimitConfigByID",id);
	}
}

