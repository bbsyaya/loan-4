package com.hrbb.loan.pos.dao;

import java.util.List;
import java.util.Map;

import com.hrbb.loan.pos.dao.entity.TAICBasicInfo;

public interface TAICBasicInfoDao {
    int deleteByPrimaryKey(Integer id);

    int insert(TAICBasicInfo record);

    int insertSelective(TAICBasicInfo record);

    TAICBasicInfo selectByPrimaryKey(Integer id);

    int updateByPrimaryKeySelective(TAICBasicInfo record);

    int updateByPrimaryKey(TAICBasicInfo record);
    
    public int insertSelectiveMap(Map<String, Object> reqMap);
    
    /**
     * 条件查询
     * 
     * @param reqMap
     * @return
     */
    List<Map<String,Object>> selectBySelectiveMap(Map<String,Object> reqMap);
}