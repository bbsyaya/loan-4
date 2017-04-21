package com.hrbb.loan.pos.dao;

import java.util.List;
import java.util.Map;

import com.hrbb.loan.pos.dao.entity.TRiskZoneConfig;

public interface TRiskZoneConfigDao {
    int deleteByPrimaryKey(Integer id);

    int insert(TRiskZoneConfig record);

    int insertSelective(TRiskZoneConfig record);

    TRiskZoneConfig selectByPrimaryKey(Integer id);

    int updateByPrimaryKeySelective(TRiskZoneConfig record);

    int updateByPrimaryKey(TRiskZoneConfig record);
    
    List<TRiskZoneConfig> selectListBySelective(Map<String,Object> reqMap);
    
	long countListBySelective(Map<String, Object> reqMap);

	TRiskZoneConfig selectRiskzoneConfigByRegcode(String string);

	int saveRiskzoneConfig(Map<String, Object> reqMap);

	int updateByUpdateMap(Map<String, Object> reqMap);

	int deleteRiskzoneConfigByID(String id);

}