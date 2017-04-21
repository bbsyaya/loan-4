package com.hrbb.loan.pos.dao;

import java.util.Map;

import com.hrbb.loan.pos.dao.entity.TSmsMessageHist;

public interface TSmsMessageHistDao {
    int deleteByPrimaryKey(Integer id);

    int insert(TSmsMessageHist record);

    int insertSelective(TSmsMessageHist record);

    TSmsMessageHist selectByPrimaryKey(Integer id);

    int updateByPrimaryKeySelective(TSmsMessageHist record);

    int updateByPrimaryKey(TSmsMessageHist record);
    
    public int insertSelectiveMap(Map<String, Object> reqMap);
}