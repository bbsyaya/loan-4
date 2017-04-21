package com.hrbb.loan.pos.dao;

import java.util.List;
import java.util.Map;

import com.hrbb.loan.pos.dao.entity.TAICPersonInfo;

public interface TAICPersonInfoDao {
    int deleteByPrimaryKey(Integer id);

    int insert(TAICPersonInfo record);

    int insertSelective(TAICPersonInfo record);

    TAICPersonInfo selectByPrimaryKey(Integer id);

    int updateByPrimaryKeySelective(TAICPersonInfo record);

    int updateByPrimaryKey(TAICPersonInfo record);
    
    public int insertSelectiveMap(Map<String, Object> reqMap);
    /**
     * 条件查询
     * 
     * @param reqMap
     * @return
     */
    List<Map<String,Object>> selectBySelectiveMap(Map<String,Object> reqMap);
}