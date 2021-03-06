package com.hrbb.loan.pos.dao;

import java.util.Map;

import com.hrbb.loan.pos.dao.entity.TCreditReportSpouse;

public interface TCreditReportSpouseDao {
    int deleteByPrimaryKey(String reportNo);

    int insert(TCreditReportSpouse record);

    int insertSelective(TCreditReportSpouse record);

    TCreditReportSpouse selectByPrimaryKey(String reportNo);

    int updateByPrimaryKeySelective(TCreditReportSpouse record);

    int updateByPrimaryKey(TCreditReportSpouse record);
    
    public int insertSelectiveMap(Map<String, Object> reqMap);
    
    public TCreditReportSpouse selectByQueryId(String queryId);
}