package com.hrbb.loan.pos.dao;

import java.util.Map;

import com.hrbb.loan.pos.dao.entity.TCreditReportExecution;

public interface TCreditReportExecutionDao {
    int deleteByPrimaryKey(String serialNo);

    int insert(TCreditReportExecution record);

    int insertSelective(TCreditReportExecution record);

    TCreditReportExecution selectByPrimaryKey(String serialNo);

    int updateByPrimaryKeySelective(TCreditReportExecution record);

    int updateByPrimaryKey(TCreditReportExecution record);
    
    public int insertSelectiveMap(Map<String, Object> reqMap);
}