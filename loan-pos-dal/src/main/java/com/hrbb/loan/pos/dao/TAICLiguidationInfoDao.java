package com.hrbb.loan.pos.dao;

import java.util.List;
import java.util.Map;

import com.hrbb.loan.pos.dao.entity.TAICLiguidationInfo;

public interface TAICLiguidationInfoDao {
    int deleteByPrimaryKey(Integer id);

    int insert(TAICLiguidationInfo record);

    int insertSelective(TAICLiguidationInfo record);

    TAICLiguidationInfo selectByPrimaryKey(Integer id);

    int updateByPrimaryKeySelective(TAICLiguidationInfo record);

    int updateByPrimaryKey(TAICLiguidationInfo record);
    
    public List<Map<String, Object>> selectSelective(Map<String, Object> reqMap);
}