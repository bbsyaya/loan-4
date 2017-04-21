package com.hrbb.loan.pos.dao.impl;

import java.util.List;
import java.util.Map;

import org.mybatis.spring.support.SqlSessionDaoSupport;
import org.springframework.stereotype.Repository;

import com.hrbb.loan.pos.dao.TRiskChannelConfigDao;
import com.hrbb.loan.pos.dao.entity.TRiskChannelConfig;
import com.hrbb.loan.pos.dao.entity.TRiskZoneConfig;
@Repository("tRiskChannelConfigDao")
public class TRiskChannelConfigDaoImpl extends SqlSessionDaoSupport implements TRiskChannelConfigDao {

	@Override
	public int deleteByPrimaryKey(Integer id) {
		// TODO Auto-generated method stub
		return 0;
	}

	@Override
	public int insert(TRiskChannelConfig record) {
		// TODO Auto-generated method stub
		return 0;
	}

	@Override
	public int insertSelective(TRiskChannelConfig record) {
		// TODO Auto-generated method stub
		return 0;
	}

	

	@Override
	public int updateByPrimaryKeySelective(TRiskChannelConfig record) {
		// TODO Auto-generated method stub
		return 0;
	}

	@Override
	public int updateByPrimaryKey(TRiskChannelConfig record) {
		// TODO Auto-generated method stub
		return 0;
	}

	@Override
	public long countListBySelective(Map<String, Object> reqMap) {
		return getSqlSession().selectOne("TRiskChannelConfigMapper.countListBySelective",reqMap);
	}

	@Override
	public List<TRiskChannelConfig> selectListBySelective(
			Map<String, Object> reqMap) {
		 return getSqlSession().selectList("TRiskChannelConfigMapper.selectListBySelective", reqMap);
	}
    
	@Override
	public TRiskChannelConfig selectRiskchannelConfigByRegcode(String string) {
		 return getSqlSession().selectOne("TRiskChannelConfigMapper.selectRiskchannelConfigByRegcode", string);
	}

	@Override
	public TRiskChannelConfig selectByPrimaryKey(Integer id) {
		 return getSqlSession().selectOne("TRiskChannelConfigMapper.selectByPrimaryKey", id);
	}
	
	@Override
	public int saveRiskchannelConfig(Map<String, Object> reqMap) {
		 return getSqlSession().insert("TRiskChannelConfigMapper.saveRiskchannelConfig", reqMap);
	}
	
	@Override
	public int updateByUpdateMap(Map<String, Object> reqMap) {
		 return getSqlSession().update("TRiskChannelConfigMapper.updateByUpdateMap", reqMap);
	}

	@Override
	public int deleteRiskchannelConfigByID(String id) {
		 return getSqlSession().delete("TRiskChannelConfigMapper.deleteRiskchannelConfigByID", id);
	}

}
