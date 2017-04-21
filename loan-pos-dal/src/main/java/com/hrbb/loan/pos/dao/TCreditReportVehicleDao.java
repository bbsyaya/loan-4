package com.hrbb.loan.pos.dao;

import java.util.Map;

import com.hrbb.loan.pos.dao.entity.TCreditReportVehicle;

public interface TCreditReportVehicleDao {
    int deleteByPrimaryKey(String serialNo);

    int insert(TCreditReportVehicle record);

    int insertSelective(TCreditReportVehicle record);

    TCreditReportVehicle selectByPrimaryKey(String serialNo);

    int updateByPrimaryKeySelective(TCreditReportVehicle record);

    int updateByPrimaryKey(TCreditReportVehicle record);
    
    public int insertSelectiveMap(Map<String, Object> reqMap);
}