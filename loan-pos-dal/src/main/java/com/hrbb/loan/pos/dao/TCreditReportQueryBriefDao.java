package com.hrbb.loan.pos.dao;

import java.util.Map;

import com.hrbb.loan.pos.dao.entity.TCreditReportQueryBrief;

public interface TCreditReportQueryBriefDao {
    int deleteByPrimaryKey(String reportNo);

    int insert(TCreditReportQueryBrief record);

    int insertSelective(TCreditReportQueryBrief record);

    TCreditReportQueryBrief selectByPrimaryKey(String reportNo);

    int updateByPrimaryKeySelective(TCreditReportQueryBrief record);

    int updateByPrimaryKey(TCreditReportQueryBrief record);
    
    public int insertSelectiveMap(Map<String, Object> reqMap);
}