package com.hrbb.loan.pos.dao;

import java.util.List;
import java.util.Map;

import com.hrbb.loan.pos.dao.entity.TAICCaseInfo;

public interface TAICCaseInfoDao {
    int deleteByPrimaryKey(Integer id);

    int insert(TAICCaseInfo record);

    int insertSelective(TAICCaseInfo record);

    TAICCaseInfo selectByPrimaryKey(Integer id);

    int updateByPrimaryKeySelective(TAICCaseInfo record);

    int updateByPrimaryKey(TAICCaseInfo record);
    
    public int insertSelectiveMap(Map<String,Object> reqMap);
    
    /**
     * 条件查询
     * 
     * @param reqMap
     * @return
     */
    List<Map<String,Object>> selectBySelectiveMap(Map<String,Object> reqMap);
}