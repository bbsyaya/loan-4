package com.hrbb.loan.pos.dao;

import java.util.List;
import java.util.Map;

import com.hrbb.loan.pos.dao.entity.TPosCustInfo;

public interface TPosCustInfoDao {
    public int deleteByPrimaryKey(String posCustId);

    public int insert(TPosCustInfo record);

    public int insertSelective(TPosCustInfo record);

    public TPosCustInfo selectByPrimaryKey(String posCustId);

    public int updateByPrimaryKeySelective(TPosCustInfo record);

    public int updateByPrimaryKey(TPosCustInfo record);
    
    public int insertSelectiveMap(Map<String, Object> map);

    public List<Map<String, Object>> selectMap(Map<String, Object> reqMap);
    
    public int updateMap(Map<String, Object> map);

    public int updateByPrimaryKeySelectiveMap(Map<String, Object> reqMap);
}