package com.hrbb.loan.pos.dao;

import java.util.List;
import java.util.Map;

import com.hrbb.loan.pos.dao.entity.TApprovingAmountRateUplimitfig;
import com.hrbb.loan.pos.dao.entity.TRiskZoneConfig;

public interface TApprovingAmountRateUplimitConfigDao {
    int deleteByPrimaryKey(Integer id);

    int insert(TApprovingAmountRateUplimitfig record);

    int insertSelective(TApprovingAmountRateUplimitfig record);

    TApprovingAmountRateUplimitfig selectByPrimaryKey(Integer id);

    int updateByPrimaryKeySelective(TApprovingAmountRateUplimitfig record);

    int updateByPrimaryKey(TApprovingAmountRateUplimitfig record);

	List<TApprovingAmountRateUplimitfig> selectListBySelective(
			Map<String, Object> reqMap);

	long countListBySelective(Map<String, Object> reqMap);

	int deleteApprovingAmountRateUplimitConfig(String id);

	int updateByUpdateMap(Map<String, Object> reqMap);

	int saveApprovingAmountRateUplimitConfig(Map<String, Object> reqMap);

	TApprovingAmountRateUplimitfig selectApprovingAmountRateUplimitConfigByRegcode(String string);
}