package com.hrbb.loan.pos.dao;

import java.util.List;
import java.util.Map;

import com.hrbb.loan.pos.dao.entity.TAICFrinvInfo;

public interface TAICFrinvInfoDao {
    int deleteByPrimaryKey(Integer id);

    int insert(TAICFrinvInfo record);

    int insertSelective(TAICFrinvInfo record);

    TAICFrinvInfo selectByPrimaryKey(Integer id);

    int updateByPrimaryKeySelective(TAICFrinvInfo record);

    int updateByPrimaryKey(TAICFrinvInfo record);
    
    public int insertFrinvInfoMap(Map<String, Object> reqMap);
    
    /**
     * 条件查询
     * 
     * @param reqMap
     * @return
     */
    List<Map<String,Object>> selectBySelectiveMap(Map<String,Object> reqMap);
}