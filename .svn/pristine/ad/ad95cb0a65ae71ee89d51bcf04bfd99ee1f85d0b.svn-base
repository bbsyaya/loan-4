package com.hrbb.loan.pos.dao.impl;

import java.util.List;
import java.util.Map;
import org.mybatis.spring.support.SqlSessionDaoSupport;
import org.springframework.stereotype.Repository;
import com.hrbb.loan.pos.dao.TApprovingAmountRateUplimitConfigDao;
import com.hrbb.loan.pos.dao.entity.TApprovingAmountRateUplimitfig;
import com.hrbb.loan.pos.dao.entity.TRiskChannelConfig;
import com.hrbb.loan.pos.dao.entity.TRiskZoneConfig;
@Repository("tApprovingAmountRateUplimitConfigDao")
public class TApprovingAmountRateUplimitConfigDaoImpl extends SqlSessionDaoSupport implements TApprovingAmountRateUplimitConfigDao {

	@Override
	public int deleteByPrimaryKey(Integer id) {
		// TODO Auto-generated method stub
		return 0;
	}

	@Override
	public int insert(TApprovingAmountRateUplimitfig record) {
		// TODO Auto-generated method stub
		return 0;
	}

	@Override
	public int insertSelective(TApprovingAmountRateUplimitfig record) {
		// TODO Auto-generated method stub
		return 0;
	}

	@Override
	public int updateByPrimaryKeySelective(TApprovingAmountRateUplimitfig record) {
		// TODO Auto-generated method stub
		return 0;
	}

	@Override
	public int updateByPrimaryKey(TApprovingAmountRateUplimitfig record) {
		// TODO Auto-generated method stub
		return 0;
	}

	

	@Override
	public long countListBySelective(Map<String, Object> reqMap) {
		return getSqlSession().selectOne("TApprovingAmountRateUplimitConfigMapper.countListBySelective",reqMap);
	}                                     

	@Override
	public List<TApprovingAmountRateUplimitfig> selectListBySelective(
			Map<String, Object> reqMap) {
		 return getSqlSession().selectList("TApprovingAmountRateUplimitConfigMapper.selectListBySelective", reqMap);
	}

	@Override
	public int deleteApprovingAmountRateUplimitConfig(String id) {
		 return getSqlSession().delete("TApprovingAmountRateUplimitConfigMapper.deleteApprovingAmountRateUplimitConfigByID", id);
	}

	@Override
	public TApprovingAmountRateUplimitfig selectApprovingAmountRateUplimitConfigByRegcode(String string) {
		 return getSqlSession().selectOne("TApprovingAmountRateUplimitConfigMapper.selectApprovingAmountRateUplimitConfigByRegcode", string);
	}

	@Override
	public TApprovingAmountRateUplimitfig selectByPrimaryKey(Integer id) {
		 return getSqlSession().selectOne("TApprovingAmountRateUplimitConfigMapper.selectByPrimaryKey", id);
	}
	
	@Override
	public int saveApprovingAmountRateUplimitConfig(Map<String, Object> reqMap) {
		 return getSqlSession().insert("TApprovingAmountRateUplimitConfigMapper.saveApprovingAmountRateUplimitConfig", reqMap);
	}
	
	@Override
	public int updateByUpdateMap(Map<String, Object> reqMap) {
		 return getSqlSession().update("TApprovingAmountRateUplimitConfigMapper.updateByUpdateMap", reqMap);
	}

}
