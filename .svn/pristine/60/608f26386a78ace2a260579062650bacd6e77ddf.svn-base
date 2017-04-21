package com.hrbb.loan.pos.dao;

import java.util.List;
import java.util.Map;

import com.hrbb.loan.pos.dao.entity.TAICPunishBreakInfo;

public interface TAICPunishBreakInfoDao {
    int deleteByPrimaryKey(Integer id);

    int insert(TAICPunishBreakInfo record);

    int insertSelective(TAICPunishBreakInfo record);

    TAICPunishBreakInfo selectByPrimaryKey(Integer id);

    int updateByPrimaryKeySelective(TAICPunishBreakInfo record);

    int updateByPrimaryKey(TAICPunishBreakInfo record);
    
    public int insertSelectiveMap(Map<String, Object> reqMap);
    
    /**
     * 条件查询
     * 
     * @param reqMap
     * @return
     */
    List<Map<String,Object>> selectBySelectiveMap(Map<String,Object> reqMap);
}