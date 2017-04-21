package com.hrbb.loan.pos.dao;

import java.util.List;
import java.util.Map;

import com.hrbb.loan.pos.dao.entity.TAICMorguaInfo;

public interface TAICMorguaInfoDao{
    int deleteByPrimaryKey(Integer id);

    int insert(TAICMorguaInfo record);

    int insertSelective(TAICMorguaInfo record);

    TAICMorguaInfo selectByPrimaryKey(Integer id);

    int updateByPrimaryKeySelective(TAICMorguaInfo record);

    int updateByPrimaryKey(TAICMorguaInfo record);
    
    public List<Map<String, Object>> selectSelective(Map<String, Object> reqMap);
}