package com.hrbb.loan.pos.dao;

import java.util.List;
import java.util.Map;

import com.hrbb.loan.pos.dao.entity.TApprovingRateUplimitConfig;

public interface TApprovingRateUplimitConfigDao {
    int deleteByPrimaryKey(Integer id);

    int insert(TApprovingRateUplimitConfig record);

    int insertSelective(TApprovingRateUplimitConfig record);

    TApprovingRateUplimitConfig selectByPrimaryKey(Integer id);

    int updateByPrimaryKeySelective(TApprovingRateUplimitConfig record);

    int updateByPrimaryKey(TApprovingRateUplimitConfig record);

	List<TApprovingRateUplimitConfig> selectListBySelective(
			Map<String, Object> reqMap);

	long countListBySelective(Map<String, Object> reqMap);

	TApprovingRateUplimitConfig selectApprovingRateUplimitConfigByRegcode(
			String string);

	int saveApprovingRateUplimitConfig(Map<String, Object> reqMap);

	int updateByUpdateMap(Map<String, Object> reqMap);

	int deleteApprovingRateUplimitConfigByID(String id);
}