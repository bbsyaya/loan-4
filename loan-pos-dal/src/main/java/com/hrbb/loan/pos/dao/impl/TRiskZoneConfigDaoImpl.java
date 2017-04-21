package com.hrbb.loan.pos.dao.impl;

import java.util.List;
import java.util.Map;

import org.mybatis.spring.support.SqlSessionDaoSupport;
import org.springframework.stereotype.Repository;

import com.hrbb.loan.pos.dao.TRiskZoneConfigDao;
import com.hrbb.loan.pos.dao.entity.TRiskZoneConfig;
@Repository("tRiskZoneConfigDao")
public class TRiskZoneConfigDaoImpl extends SqlSessionDaoSupport implements TRiskZoneConfigDao {

	@Override
	public int deleteByPrimaryKey(Integer id) {
		// TODO Auto-generated method stub
		return 0;
	}

	@Override
	public int insert(TRiskZoneConfig record) {
		// TODO Auto-generated method stub
		return 0;
	}

	@Override
	public int insertSelective(TRiskZoneConfig record) {
		// TODO Auto-generated method stub
		return 0;
	}

	@Override
	public int updateByPrimaryKeySelective(TRiskZoneConfig record) {
		// TODO Auto-generated method stub
		return 0;
	}

	@Override
	public int updateByPrimaryKey(TRiskZoneConfig record) {
		// TODO Auto-generated method stub
		return 0;
	}

	@Override
	public List<TRiskZoneConfig> selectListBySelective(Map<String, Object> reqMap) {
		 return getSqlSession().selectList("TRiskZoneConfigMapper.selectListBySelective", reqMap);
	}

	@Override
	public long countListBySelective(Map<String, Object> reqMap) {
		return getSqlSession().selectOne("TRiskZoneConfigMapper.countListBySelective",reqMap);
	}

	@Override
	public TRiskZoneConfig selectRiskzoneConfigByRegcode(String string) {
		 return getSqlSession().selectOne("TRiskZoneConfigMapper.selectRiskzoneConfigByRegcode", string);
	}

	@Override
	public int saveRiskzoneConfig(Map<String, Object> reqMap) {
		 return getSqlSession().insert("TRiskZoneConfigMapper.saveRiskzoneConfig", reqMap);
	}

	@Override
	public TRiskZoneConfig selectByPrimaryKey(Integer id) {
		 return getSqlSession().selectOne("TRiskZoneConfigMapper.selectByPrimaryKey", id);
	}

	@Override
	public int updateByUpdateMap(Map<String, Object> reqMap) {
		 return getSqlSession().update("TRiskZoneConfigMapper.updateByUpdateMap", reqMap);
	}

	@Override
	public int deleteRiskzoneConfigByID(String id) {
		 return getSqlSession().delete("TRiskZoneConfigMapper.deleteRiskzoneConfigByID",id);
	}
}

