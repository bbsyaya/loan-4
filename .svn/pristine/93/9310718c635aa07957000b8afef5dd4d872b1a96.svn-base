package com.hrbb.loan.pos.dao;

import java.util.List;
import java.util.Map;

import com.hrbb.loan.pos.dao.entity.TRiskChannelConfig;
import com.hrbb.loan.pos.dao.entity.TRiskZoneConfig;

public interface TRiskChannelConfigDao {
    int deleteByPrimaryKey(Integer id);

    int insert(TRiskChannelConfig record);

    int insertSelective(TRiskChannelConfig record);

    TRiskChannelConfig selectByPrimaryKey(Integer id);

    int updateByPrimaryKeySelective(TRiskChannelConfig record);

    int updateByPrimaryKey(TRiskChannelConfig record);

	long countListBySelective(Map<String, Object> reqMap);

	List<TRiskChannelConfig> selectListBySelective(Map<String, Object> reqMap);

	int saveRiskchannelConfig(Map<String, Object> reqMap);

	TRiskChannelConfig selectRiskchannelConfigByRegcode(String string);

	int updateByUpdateMap(Map<String, Object> reqMap);

	int deleteRiskchannelConfigByID(String id);
}