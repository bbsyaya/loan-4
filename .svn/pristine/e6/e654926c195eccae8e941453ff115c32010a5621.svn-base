package com.hrbb.loan.pos.dao.impl;

import java.util.List;
import java.util.Map;

import org.mybatis.spring.support.SqlSessionDaoSupport;
import org.springframework.stereotype.Repository;

import com.hrbb.loan.pos.dao.TApprovedRulesConfigDao;
import com.hrbb.loan.pos.dao.entity.TApprovedRulesConfig;
@Repository("tApprovedRulesConfigDao")
public class TApprovedRulesConfigDaoImpl extends SqlSessionDaoSupport implements TApprovedRulesConfigDao {
	@Override
	public int deleteByPrimaryKey(Integer id) {
		// TODO Auto-geneScorecutd method stub
		return 0;
	}

	@Override
	public int insert(TApprovedRulesConfig record) {
		// TODO Auto-generated method stub
		return 0;
	}

	@Override
	public int insertSelective(TApprovedRulesConfig record) {
		// TODO Auto-generated method stub
		return 0;
	}

	@Override
	public int updateByPrimaryKeySelective(TApprovedRulesConfig record) {
		// TODO Auto-generated method stub
		return 0;
	}

	@Override
	public int updateByPrimaryKey(TApprovedRulesConfig record) {
		// TODO Auto-generated method stub
		return 0;
	}

	@Override
	public List<TApprovedRulesConfig> selectListBySelective(Map<String, Object> reqMap) {
		 return getSqlSession().selectList("TApprovedRulesConfigMapper.selectListBySelective", reqMap);
	}

	@Override
	public long countListBySelective(Map<String, Object> reqMap) {
		return getSqlSession().selectOne("TApprovedRulesConfigMapper.countListBySelective",reqMap);
	}

	@Override
	public TApprovedRulesConfig selectApprovedRulesConfigByRegcode(String string) {
		 return getSqlSession().selectOne("TApprovedRulesConfigMapper.selectApprovedRulesConfigByRegcode", string);
	}

	@Override
	public int saveApprovedRulesConfig(Map<String, Object> reqMap) {
		 return getSqlSession().insert("TApprovedRulesConfigMapper.saveApprovedRulesConfig", reqMap);
	}

	@Override
	public TApprovedRulesConfig selectByPrimaryKey(Integer id) {
		 return getSqlSession().selectOne("TApprovedRulesConfigMapper.selectByPrimaryKey", id);
	}

	@Override
	public int updateByUpdateMap(Map<String, Object> reqMap) {
		 return getSqlSession().update("TApprovedRulesConfigMapper.updateByUpdateMap", reqMap);
	}

	@Override
	public int deleteApprovedRulesConfigByID(String id) {
		 return getSqlSession().delete("TApprovedRulesConfigMapper.deleteApprovedRulesConfigByID",id);
	}

}

