package com.hrbb.loan.pos.dao;

import java.util.List;
import java.util.Map;

import com.hrbb.loan.pos.dao.entity.TAICShareHolder;

public interface TAICShareHolderDao {
    int deleteByPrimaryKey(Integer id);

    int insert(TAICShareHolder record);

    int insertSelective(TAICShareHolder record);

    TAICShareHolder selectByPrimaryKey(Integer id);

    int updateByPrimaryKeySelective(TAICShareHolder record);

    int updateByPrimaryKey(TAICShareHolder record);
    
    public int insertSelectiveMap(Map<String, Object> reqMap);
    
    /**
     * 条件查询
     * 
     * @param reqMap
     * @return
     */
    List<Map<String,Object>> selectBySelectiveMap(Map<String,Object> reqMap);
}