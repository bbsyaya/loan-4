package com.hrbb.loan.pos.dao;

import java.util.Map;

import com.hrbb.loan.pos.dao.entity.TCreditReportOverdueDetail;

public interface TCreditReportOverdueDetailDao {
    int deleteByPrimaryKey(String serialNo);

    int insert(TCreditReportOverdueDetail record);

    int insertSelective(TCreditReportOverdueDetail record);

    TCreditReportOverdueDetail selectByPrimaryKey(String serialNo);

    int updateByPrimaryKeySelective(TCreditReportOverdueDetail record);

    int updateByPrimaryKey(TCreditReportOverdueDetail record);
    
    public int insertSelectiveMap(Map<String, Object> reqMap);
    
    TCreditReportOverdueDetail selectByCreditCard(TCreditReportOverdueDetail record);
    TCreditReportOverdueDetail selectByLoanInfo(TCreditReportOverdueDetail record);
}