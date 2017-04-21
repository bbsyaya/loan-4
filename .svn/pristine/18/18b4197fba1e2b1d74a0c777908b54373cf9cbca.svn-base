package com.hrbb.loan.pos.dao;

import java.util.List;
import java.util.Map;

import com.hrbb.loan.pos.dao.entity.TAICFrpositionInfo;

public interface TAICFrpositionInfoDao {
    int deleteByPrimaryKey(Integer id);

    int insert(TAICFrpositionInfo record);

    int insertSelective(TAICFrpositionInfo record);

    TAICFrpositionInfo selectByPrimaryKey(Integer id);

    int updateByPrimaryKeySelective(TAICFrpositionInfo record);

    int updateByPrimaryKey(TAICFrpositionInfo record);
    
    public int insertSelectiveMap(Map<String, Object> reqMap);
    
    /**
     * 条件查询
     * 
     * @param reqMap
     * @return
     */
    List<Map<String,Object>> selectBySelectiveMap(Map<String,Object> reqMap);
}