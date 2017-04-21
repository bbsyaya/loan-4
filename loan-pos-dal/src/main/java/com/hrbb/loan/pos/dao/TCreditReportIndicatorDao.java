package com.hrbb.loan.pos.dao;

import java.util.Map;

import com.hrbb.loan.pos.dao.entity.TCreditReportIndicator;

public interface TCreditReportIndicatorDao {
    int deleteByPrimaryKey(String CR001);

    int insert(TCreditReportIndicator record);

    int insertSelective(TCreditReportIndicator record);

    TCreditReportIndicator selectByPrimaryKey(String CR001);

    int updateByPrimaryKeySelective(TCreditReportIndicator record);

    int updateByPrimaryKey(TCreditReportIndicator record);
    
    public int insertSelectiveMap(Map<String, Object> reqMap);
}