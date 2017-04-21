package com.hrbb.loan.pos.dao;

import java.util.List;
import java.util.Map;

import com.hrbb.loan.pos.dao.entity.TApprovingScorecutUplimitConfig;

public interface TApprovingScorecutUplimitConfigDao {
    int deleteByPrimaryKey(Integer id);

    int insert(TApprovingScorecutUplimitConfig record);

    int insertSelective(TApprovingScorecutUplimitConfig record);

    TApprovingScorecutUplimitConfig selectByPrimaryKey(Integer id);

    int updateByPrimaryKeySelective(TApprovingScorecutUplimitConfig record);

    int updateByPrimaryKey(TApprovingScorecutUplimitConfig record);

	List<TApprovingScorecutUplimitConfig> selectListBySelective(
			Map<String, Object> reqMap);

	long countListBySelective(Map<String, Object> reqMap);

	TApprovingScorecutUplimitConfig selectApprovingScorecutUplimitConfigByRegcode(
			String string);

	int saveApprovingScorecutUplimitConfig(Map<String, Object> reqMap);

	int updateByUpdateMap(Map<String, Object> reqMap);

	int deleteApprovingScorecutUplimitConfigByID(String id);
}