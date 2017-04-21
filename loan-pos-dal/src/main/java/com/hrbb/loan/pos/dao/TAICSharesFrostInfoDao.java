package com.hrbb.loan.pos.dao;

import java.util.List;
import java.util.Map;

import com.hrbb.loan.pos.dao.entity.TAICSharesFrostInfo;

public interface TAICSharesFrostInfoDao {
    int deleteByPrimaryKey(Integer id);

    int insert(TAICSharesFrostInfo record);

    int insertSelective(TAICSharesFrostInfo record);

    TAICSharesFrostInfo selectByPrimaryKey(Integer id);

    int updateByPrimaryKeySelective(TAICSharesFrostInfo record);

    int updateByPrimaryKey(TAICSharesFrostInfo record);
    
    public List<Map<String, Object>> selectSelective(Map<String, Object> reqMap);
}