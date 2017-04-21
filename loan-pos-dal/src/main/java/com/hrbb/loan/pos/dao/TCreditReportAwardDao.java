package com.hrbb.loan.pos.dao;

import java.util.Map;

import com.hrbb.loan.pos.dao.entity.TCreditReportAward;

public interface TCreditReportAwardDao {
    int deleteByPrimaryKey(String serialNo);

    int insert(TCreditReportAward record);

    int insertSelective(TCreditReportAward record);

    TCreditReportAward selectByPrimaryKey(String serialNo);

    int updateByPrimaryKeySelective(TCreditReportAward record);

    int updateByPrimaryKey(TCreditReportAward record);
    
    public int insertSelectiveMap(Map<String, Object> reqMap);
}