package com.hrbb.loan.pos.dao;

import java.util.List;
import java.util.Map;

import com.hrbb.loan.pos.dao.entity.TAICOrderlistInfo;

public interface TAICOrderlistInfoDao {
    int deleteByPrimaryKey(Integer id);

    int insert(TAICOrderlistInfo record);

    int insertSelective(TAICOrderlistInfo record);

    TAICOrderlistInfo selectByPrimaryKey(Integer id);

    int updateByPrimaryKeySelective(TAICOrderlistInfo record);

    int updateByPrimaryKey(TAICOrderlistInfo record);
    
    public int insertSelectiveMap(Map<String, Object> reqMap);
    
    public List<Map<String, Object>> queryMap(Map<String, Object> reqMap);
}