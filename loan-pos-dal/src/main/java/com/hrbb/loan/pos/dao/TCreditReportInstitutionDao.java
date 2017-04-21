package com.hrbb.loan.pos.dao;

import java.util.Map;

import com.hrbb.loan.pos.dao.entity.TCreditReportInstitution;

public interface TCreditReportInstitutionDao {
    int deleteByPrimaryKey(String serialNo);

    int insert(TCreditReportInstitution record);

    int insertSelective(TCreditReportInstitution record);

    TCreditReportInstitution selectByPrimaryKey(String serialNo);

    int updateByPrimaryKeySelective(TCreditReportInstitution record);

    int updateByPrimaryKey(TCreditReportInstitution record);
    
    public int insertSelectiveMap(Map<String, Object> reqMap);
}