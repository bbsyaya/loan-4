package com.hrbb.loan.pos.dao;

import java.util.List;
import java.util.Map;

import com.hrbb.loan.pos.dao.entity.TCreditReportProfession;

public interface TCreditReportProfessionDao {
    int deleteByPrimaryKey(String serialNo);

    int insert(TCreditReportProfession record);

    int insertSelective(TCreditReportProfession record);

    TCreditReportProfession selectByPrimaryKey(String serialNo);

    int updateByPrimaryKeySelective(TCreditReportProfession record);

    int updateByPrimaryKey(TCreditReportProfession record);
    
    public int insertSelectiveMap(Map<String, Object> reqMap);
    
    public List<TCreditReportProfession> selectSelective(TCreditReportProfession record);
}