package com.hrbb.loan.pos.dao;

import java.util.Map;

import com.hrbb.loan.pos.dao.entity.TCreditReportSemicardBrief;

public interface TCreditReportSemicardBriefDao {
    int deleteByPrimaryKey(String reportNo);

    int insert(TCreditReportSemicardBrief record);

    int insertSelective(TCreditReportSemicardBrief record);

    TCreditReportSemicardBrief selectByPrimaryKey(String reportNo);

    int updateByPrimaryKeySelective(TCreditReportSemicardBrief record);

    int updateByPrimaryKey(TCreditReportSemicardBrief record);
    
    public int insertSelectiveMap(Map<String, Object> reqMap);
}