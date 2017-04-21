package com.hrbb.loan.pos.dao;

import java.util.Map;

import com.hrbb.loan.pos.dao.entity.TCreditReportNpl;

public interface TCreditReportNplDao {
    int deleteByPrimaryKey(String reportNo);

    int insert(TCreditReportNpl record);

    int insertSelective(TCreditReportNpl record);

    TCreditReportNpl selectByPrimaryKey(String reportNo);

    int updateByPrimaryKeySelective(TCreditReportNpl record);

    int updateByPrimaryKey(TCreditReportNpl record);
    
    public int insertSelectiveMap(Map<String, Object> reqMap);
}