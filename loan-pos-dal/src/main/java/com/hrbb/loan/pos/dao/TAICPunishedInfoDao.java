package com.hrbb.loan.pos.dao;

import java.util.List;
import java.util.Map;

import com.hrbb.loan.pos.dao.entity.TAICPunishedInfo;

public interface TAICPunishedInfoDao {
    int deleteByPrimaryKey(Integer id);

    int insert(TAICPunishedInfo record);

    int insertSelective(TAICPunishedInfo record);

    TAICPunishedInfo selectByPrimaryKey(Integer id);

    int updateByPrimaryKeySelective(TAICPunishedInfo record);

    int updateByPrimaryKey(TAICPunishedInfo record);
    
    public int insertSelectiveMap(Map<String, Object> reqMap);
    
    /**
     * 条件查询
     * 
     * @param reqMap
     * @return
     */
    List<Map<String,Object>> selectBySelectiveMap(Map<String,Object> reqMap);
}