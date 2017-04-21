package com.hrbb.loan.pos.dao;

import java.util.Map;

import com.hrbb.loan.pos.dao.entity.TCreditReportQualify;

public interface TCreditReportQualifyDao {
    int deleteByPrimaryKey(String serialNo);

    int insert(TCreditReportQualify record);

    int insertSelective(TCreditReportQualify record);

    TCreditReportQualify selectByPrimaryKey(String serialNo);

    int updateByPrimaryKeySelective(TCreditReportQualify record);

    int updateByPrimaryKey(TCreditReportQualify record);
    
    public int insertSelectiveMap(Map<String, Object> reqMap);
}