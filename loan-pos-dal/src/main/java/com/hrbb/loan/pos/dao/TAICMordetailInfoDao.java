package com.hrbb.loan.pos.dao;

import java.util.List;
import java.util.Map;

import com.hrbb.loan.pos.dao.entity.TAICMordetailInfo;

public interface TAICMordetailInfoDao {
    int deleteByPrimaryKey(Integer id);

    int insert(TAICMordetailInfo record);

    int insertSelective(TAICMordetailInfo record);

    TAICMordetailInfo selectByPrimaryKey(Integer id);

    int updateByPrimaryKeySelective(TAICMordetailInfo record);

    int updateByPrimaryKey(TAICMordetailInfo record);
    
    public List<Map<String, Object>> selectSelective(Map<String, Object> reqMap);
}