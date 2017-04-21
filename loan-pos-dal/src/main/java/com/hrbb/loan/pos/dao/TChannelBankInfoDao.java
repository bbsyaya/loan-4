package com.hrbb.loan.pos.dao;

import java.util.List;
import java.util.Map;

import com.hrbb.loan.pos.dao.entity.TChannelBankInfo;

public interface TChannelBankInfoDao {
    int deleteByPrimaryKey(Integer serial);

    int insert(TChannelBankInfo record);

    int insertSelective(TChannelBankInfo record);

    TChannelBankInfo selectByPrimaryKey(Integer serial);

    int updateByPrimaryKeySelective(TChannelBankInfo record);

    int updateByPrimaryKey(TChannelBankInfo record);
    
    public List<Map<String, Object>> getSeletiveMap(Map<String, Object> reqMap);
}