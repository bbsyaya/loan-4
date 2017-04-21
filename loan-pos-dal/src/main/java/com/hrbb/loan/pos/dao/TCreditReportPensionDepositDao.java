package com.hrbb.loan.pos.dao;

import java.util.Map;

import com.hrbb.loan.pos.dao.entity.TCreditReportPensionDeposit;

public interface TCreditReportPensionDepositDao {
    int deleteByPrimaryKey(String serialNo);

    int insert(TCreditReportPensionDeposit record);

    int insertSelective(TCreditReportPensionDeposit record);

    TCreditReportPensionDeposit selectByPrimaryKey(String serialNo);

    int updateByPrimaryKeySelective(TCreditReportPensionDeposit record);

    int updateByPrimaryKey(TCreditReportPensionDeposit record);
    
    public int insertSelectiveMap(Map<String, Object> reqMap);
}