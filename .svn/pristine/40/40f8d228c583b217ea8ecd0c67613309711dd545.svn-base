package com.hrbb.loan.pos.dao;

import java.util.List;
import java.util.Map;

import com.hrbb.loan.pos.dao.entity.TBankSerialnoInfo;

public interface TBankSerialnoInfoDao {
    public int deleteByPrimaryKey(String serialNo);

    public int insert(TBankSerialnoInfo record);

    public int insertSelective(TBankSerialnoInfo record);

    public TBankSerialnoInfo selectByPrimaryKey(String serialNo);

    public int updateByPrimaryKeySelective(TBankSerialnoInfo record);

    public int updateByPrimaryKey(TBankSerialnoInfo record);
    
    public List<Map<String, Object>> selectMap(Map<String, Object> reqMap);
    
    public List<Map<String, Object>> selectMapByCurrMonth(Map<String, Object> reqMap);
    
    public int updateSelectiveMap(Map<String, Object> reqMap);
    
    public int insertSelectiveMap(Map<String, Object> reqMap);
    
    public Long countMap(Map<String, Object> reqMap);
}