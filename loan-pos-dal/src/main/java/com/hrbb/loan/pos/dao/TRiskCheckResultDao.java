package com.hrbb.loan.pos.dao;

import java.util.List;
import java.util.Map;

import com.hrbb.loan.pos.dao.entity.TRiskCheckResult;

public interface TRiskCheckResultDao {
    
    Long countCreitApply(Map<String, Object> map);
    
    List<Map<String, Object>> selectSelectiveMap(Map<String, Object> map);
    
    int insertSelectiveMap(Map<String, Object> map);

    int updateByPrimaryKeySelectiveMap(Map<String, Object> map);

    int deleteByPrimaryKey(String riskResultId);

    int insert(TRiskCheckResult record);

    int insertSelective(TRiskCheckResult record);

    TRiskCheckResult selectByPrimaryKey(String riskResultId);
    
    TRiskCheckResult selectSelective(String riskResultId);

    int updateByPrimaryKeySelective(TRiskCheckResult record);

    int updateByPrimaryKey(TRiskCheckResult record);
}