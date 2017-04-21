package com.hrbb.loan.pos.dao.impl;

import java.util.List;
import java.util.Map;

import org.mybatis.spring.support.SqlSessionDaoSupport;
import org.springframework.stereotype.Repository;

import com.hrbb.loan.pos.dao.TApprovingScorecutUplimitConfigDao;
import com.hrbb.loan.pos.dao.entity.TApprovingScorecutUplimitConfig;
@Repository("tApprovingScorecutUplimitConfigDao")
public class TApprovingScorecutUplimitConfigDaoImpl extends SqlSessionDaoSupport implements TApprovingScorecutUplimitConfigDao {

	@Override
	public int deleteByPrimaryKey(Integer id) {
		// TODO Auto-geneScorecutd method stub
		return 0;
	}

	@Override
	public int insert(TApprovingScorecutUplimitConfig record) {
		// TODO Auto-geneScorecutd method stub
		return 0;
	}

	@Override
	public int insertSelective(TApprovingScorecutUplimitConfig record) {
		// TODO Auto-geneScorecutd method stub
		return 0;
	}

	@Override
	public int updateByPrimaryKeySelective(TApprovingScorecutUplimitConfig record) {
		// TODO Auto-geneScorecutd method stub
		return 0;
	}

	@Override
	public int updateByPrimaryKey(TApprovingScorecutUplimitConfig record) {
		// TODO Auto-geneScorecutd method stub
		return 0;
	}

	@Override
	public List<TApprovingScorecutUplimitConfig> selectListBySelective(Map<String, Object> reqMap) {
		 return getSqlSession().selectList("TApprovingScorecutUplimitConfigMapper.selectListBySelective", reqMap);
	}

	@Override
	public long countListBySelective(Map<String, Object> reqMap) {
		return getSqlSession().selectOne("TApprovingScorecutUplimitConfigMapper.countListBySelective",reqMap);
	}

	@Override
	public TApprovingScorecutUplimitConfig selectApprovingScorecutUplimitConfigByRegcode(String string) {
		 return getSqlSession().selectOne("TApprovingScorecutUplimitConfigMapper.selectApprovingScorecutUplimitConfigByRegcode", string);
	}

	@Override
	public int saveApprovingScorecutUplimitConfig(Map<String, Object> reqMap) {
		 return getSqlSession().insert("TApprovingScorecutUplimitConfigMapper.saveApprovingScorecutUplimitConfig", reqMap);
	}

	@Override
	public TApprovingScorecutUplimitConfig selectByPrimaryKey(Integer id) {
		 return getSqlSession().selectOne("TApprovingScorecutUplimitConfigMapper.selectByPrimaryKey", id);
	}

	@Override
	public int updateByUpdateMap(Map<String, Object> reqMap) {
		 return getSqlSession().update("TApprovingScorecutUplimitConfigMapper.updateByUpdateMap", reqMap);
	}

	@Override
	public int deleteApprovingScorecutUplimitConfigByID(String id) {
		 return getSqlSession().delete("TApprovingScorecutUplimitConfigMapper.deleteApprovingScorecutUplimitConfigByID",id);
	}
}

