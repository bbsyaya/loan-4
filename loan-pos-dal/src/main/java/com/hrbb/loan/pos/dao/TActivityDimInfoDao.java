package com.hrbb.loan.pos.dao;

import java.util.List;
import java.util.Map;

import com.hrbb.loan.pos.dao.entity.TActivityDimInfo;

public interface TActivityDimInfoDao {
    int deleteByPrimaryKey(Integer id);

    int insert(TActivityDimInfo record);

    int insertSelective(TActivityDimInfo record);

    TActivityDimInfo selectByPrimaryKey(Integer id);

    int updateByPrimaryKeySelective(TActivityDimInfo record);

    int updateByPrimaryKey(TActivityDimInfo record);
    
    public List<TActivityDimInfo> selectSelective(Map<String, Object> reqMap);
    
    public String countSelective(Map<String, Object> reqMap);
}