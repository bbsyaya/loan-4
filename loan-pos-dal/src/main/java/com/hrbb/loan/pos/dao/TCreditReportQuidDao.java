package com.hrbb.loan.pos.dao;

import java.util.Map;

import com.hrbb.loan.pos.dao.entity.TCreditReportQuid;

public interface TCreditReportQuidDao {
    int deleteByPrimaryKey(String serialNo);

    int insert(TCreditReportQuid record);

    int insertSelective(TCreditReportQuid record);

    TCreditReportQuid selectByPrimaryKey(String serialNo);

    int updateByPrimaryKeySelective(TCreditReportQuid record);

    int updateByPrimaryKey(TCreditReportQuid record);
    
    public int insertSelectiveMap(Map<String, Object> reqMap);
}