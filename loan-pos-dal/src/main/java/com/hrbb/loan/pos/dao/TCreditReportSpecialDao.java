package com.hrbb.loan.pos.dao;

import java.util.Map;

import com.hrbb.loan.pos.dao.entity.TCreditReportSpecial;

public interface TCreditReportSpecialDao {
    int deleteByPrimaryKey(String serialNo);

    int insert(TCreditReportSpecial record);

    int insertSelective(TCreditReportSpecial record);

    TCreditReportSpecial selectByPrimaryKey(String serialNo);

    int updateByPrimaryKeySelective(TCreditReportSpecial record);

    int updateByPrimaryKey(TCreditReportSpecial record);
    
    public int insertSelectiveMap(Map<String, Object> reqMap);
    
    public TCreditReportSpecial selectSelective(TCreditReportSpecial record);
}