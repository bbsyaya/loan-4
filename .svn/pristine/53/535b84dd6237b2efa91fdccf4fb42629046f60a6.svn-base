package com.hrbb.loan.pos.dao;

import java.util.List;
import java.util.Map;

import com.hrbb.loan.pos.dao.entity.TActivityContentInfo;

public interface TActivityContentInfoDao {
    int deleteByPrimaryKey(Integer id);

    int insert(TActivityContentInfo record);

    int insertSelective(TActivityContentInfo record);

    TActivityContentInfo selectByPrimaryKey(Integer id);

    int updateByPrimaryKeySelective(TActivityContentInfo record);

    int updateByPrimaryKey(TActivityContentInfo record);
    
    public List<TActivityContentInfo> selectSelective(Map<String, Object> reqMap);
    
    public String countSelective(Map<String, Object> reqMap);
}