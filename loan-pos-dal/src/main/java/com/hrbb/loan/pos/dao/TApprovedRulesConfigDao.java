package com.hrbb.loan.pos.dao;

import java.util.List;
import java.util.Map;

import com.hrbb.loan.pos.dao.entity.TApprovedRulesConfig;

public interface TApprovedRulesConfigDao {
    int deleteByPrimaryKey(Integer id);

    int insert(TApprovedRulesConfig record);

    int insertSelective(TApprovedRulesConfig record);

    TApprovedRulesConfig selectByPrimaryKey(Integer id);

    int updateByPrimaryKeySelective(TApprovedRulesConfig record);

    int updateByPrimaryKey(TApprovedRulesConfig record);

	List<TApprovedRulesConfig> selectListBySelective(Map<String, Object> reqMap);

	long countListBySelective(Map<String, Object> reqMap);

	TApprovedRulesConfig selectApprovedRulesConfigByRegcode(String string);

	int saveApprovedRulesConfig(Map<String, Object> reqMap);

	int updateByUpdateMap(Map<String, Object> reqMap);

	int deleteApprovedRulesConfigByID(String id);
}