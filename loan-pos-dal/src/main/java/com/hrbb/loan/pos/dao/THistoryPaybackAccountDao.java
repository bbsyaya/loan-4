package com.hrbb.loan.pos.dao;

import java.util.Map;

import com.hrbb.loan.pos.dao.entity.THistoryPaybackAccount;

public interface THistoryPaybackAccountDao {
    int deleteByPrimaryKey(String innerRunningId);

    int insert(THistoryPaybackAccount record);

    int insertSelective(THistoryPaybackAccount record);

    THistoryPaybackAccount selectByPrimaryKey(String innerRunningId);

    int updateByPrimaryKeySelective(THistoryPaybackAccount record);

    int updateByPrimaryKey(THistoryPaybackAccount record);
    
    int getHistroyAccountNumber(Map<String, Object> reqMap);
}