package com.hrbb.loan.pos.dao;

import java.util.Map;

import com.hrbb.loan.pos.dao.entity.TCreditReportTaxarrear;

public interface TCreditReportTaxarrearDao {
    int deleteByPrimaryKey(String serialNo);

    int insert(TCreditReportTaxarrear record);

    int insertSelective(TCreditReportTaxarrear record);

    TCreditReportTaxarrear selectByPrimaryKey(String serialNo);

    int updateByPrimaryKeySelective(TCreditReportTaxarrear record);

    int updateByPrimaryKey(TCreditReportTaxarrear record);
    
    public int insertSelectiveMap(Map<String, Object> reqMap);
}