package com.hrbb.loan.pos.dao;

import java.util.Map;

import com.hrbb.loan.pos.dao.entity.TCreditReportAnnounce;

public interface TCreditReportAnnounceDao {
    int deleteByPrimaryKey(String serialNo);

    int insert(TCreditReportAnnounce record);

    int insertSelective(TCreditReportAnnounce record);

    TCreditReportAnnounce selectByPrimaryKey(String serialNo);

    int updateByPrimaryKeySelective(TCreditReportAnnounce record);

    int updateByPrimaryKey(TCreditReportAnnounce record);
    
    public int insertSelectiveMap(Map<String, Object> reqMap);
}