package com.hrbb.loan.pos.dao;

import java.util.Map;

import com.hrbb.loan.pos.dao.entity.TCreditReportResidence;

public interface TCreditReportResidenceDao {
    int deleteByPrimaryKey(String serialNo);

    int insert(TCreditReportResidence record);

    int insertSelective(TCreditReportResidence record);

    TCreditReportResidence selectByPrimaryKey(String serialNo);

    int updateByPrimaryKeySelective(TCreditReportResidence record);

    int updateByPrimaryKey(TCreditReportResidence record);
    
    public int insertSelectiveMap(Map<String, Object> reqMap);
}