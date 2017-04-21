package com.hrbb.loan.pos.dao;

import java.util.Map;

import com.hrbb.loan.pos.dao.entity.TCreditReportDissent;

public interface TCreditReportDissentDao {
    int deleteByPrimaryKey(String serialNo);

    int insert(TCreditReportDissent record);

    int insertSelective(TCreditReportDissent record);

    TCreditReportDissent selectByPrimaryKey(String serialNo);

    int updateByPrimaryKeySelective(TCreditReportDissent record);

    int updateByPrimaryKey(TCreditReportDissent record);
    
    public int insertSelectiveMap(Map<String, Object> reqMap);
}