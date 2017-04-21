package com.hrbb.loan.pos.dao;

import java.util.List;
import java.util.Map;

import com.hrbb.loan.pos.dao.entity.TCreditReportPool;

public interface TCreditReportPoolDao {
    int deleteByPrimaryKey(Integer id);

    int insert(TCreditReportPool record);

    int insertSelective(TCreditReportPool record);

    TCreditReportPool selectByPrimaryKey(Integer id);

    int updateByPrimaryKeySelective(TCreditReportPool record);

    int updateByPrimaryKey(TCreditReportPool record);
    
    public List<TCreditReportPool> selectSelective(Map<String, Object> reqMap);
    
    public int  updateSelective(TCreditReportPool record);
    
    
}