package com.hrbb.loan.pos.dao;

import java.util.List;
import java.util.Map;

import com.hrbb.loan.pos.dao.entity.TAICAlidebtInfo;

public interface TAICAlidebtInfoDao {
    int deleteByPrimaryKey(Integer id);

    int insert(TAICAlidebtInfo record);

    int insertSelective(TAICAlidebtInfo record);

    TAICAlidebtInfo selectByPrimaryKey(Integer id);

    int updateByPrimaryKeySelective(TAICAlidebtInfo record);

    int updateByPrimaryKey(TAICAlidebtInfo record);
    
    public int insertSelectiveMap(Map<String, Object> reqMap);
    
    List<Map<String,Object>> selectBySelectiveMap(Map<String,Object> reqMap);
}