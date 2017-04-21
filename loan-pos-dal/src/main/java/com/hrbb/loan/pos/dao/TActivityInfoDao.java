package com.hrbb.loan.pos.dao;

import java.util.List;
import java.util.Map;

import com.hrbb.loan.pos.dao.entity.TActivityInfo;

public interface TActivityInfoDao {
    int insert(TActivityInfo record);

    int insertSelective(TActivityInfo record);
    
    public List<TActivityInfo> selectSelective(Map<String, Object> reqMap);
    
    public int updateSelective(TActivityInfo tActivityInfo);
    
    public String countSelective(Map<String, Object> reqMap);
}