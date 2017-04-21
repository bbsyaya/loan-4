package com.hrbb.loan.pos.dao;

import java.util.List;
import java.util.Map;

import com.hrbb.loan.pos.dao.entity.TCreditReportBrief;

public interface TCreditReportBriefDao {
    int deleteByPrimaryKey(String reportNo);

    int insert(TCreditReportBrief record);

    int insertSelective(TCreditReportBrief record);

    TCreditReportBrief selectByPrimaryKey(String reportNo);

    int updateByPrimaryKeySelective(TCreditReportBrief record);

    int updateByPrimaryKey(TCreditReportBrief record);
    
    TCreditReportBrief selectOne(TCreditReportBrief record) ;
    
    public int insertSelectivMap(Map<String, Object> reqMap);
    
    public TCreditReportBrief selectOneByCertNo(Map<String, Object> reqMap);
    
    public List<Map<String, Object>> selectByMap(Map<String, Object> reqMap);
    
    public int updateMap(Map<String, Object> reqMap);
}