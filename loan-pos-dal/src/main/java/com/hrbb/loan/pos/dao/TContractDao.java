package com.hrbb.loan.pos.dao;

import java.util.List;
import java.util.Map;

import com.hrbb.loan.pos.dao.entity.TContract;

public interface TContractDao {
    public int deleteByPrimaryKey(String contNo);

    public int insert(TContract record);

    public int insertSelective(TContract record);

    public TContract selectByPrimaryKey(String contNo);
    
    public List<TContract> selectSelective(Map<String, Object> map);

    public int updateByPrimaryKeySelective(TContract record);

    public int updateByPrimaryKey(TContract record);
    
}