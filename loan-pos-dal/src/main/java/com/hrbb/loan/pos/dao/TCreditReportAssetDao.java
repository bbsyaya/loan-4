package com.hrbb.loan.pos.dao;

import java.util.Map;

import com.hrbb.loan.pos.dao.entity.TCreditReportAsset;

public interface TCreditReportAssetDao {
    int deleteByPrimaryKey(String serialNo);

    int insert(TCreditReportAsset record);

    int insertSelective(TCreditReportAsset record);

    TCreditReportAsset selectByPrimaryKey(String serialNo);

    int updateByPrimaryKeySelective(TCreditReportAsset record);

    int updateByPrimaryKey(TCreditReportAsset record);
    
    public int insertSelectiveMap(Map<String, Object> reqMap);
}