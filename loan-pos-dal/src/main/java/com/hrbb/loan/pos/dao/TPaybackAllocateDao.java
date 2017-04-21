package com.hrbb.loan.pos.dao;

import java.util.Map;

import com.hrbb.loan.pos.dao.entity.TPaybackAllocate;

public interface TPaybackAllocateDao {
    int deleteByPrimaryKey(String importRunningId);

    int insert(TPaybackAllocate record);

    int insertSelective(TPaybackAllocate record);

    TPaybackAllocate selectByPrimaryKey(String importRunningId);

    int updateByPrimaryKeySelective(TPaybackAllocate record);

    int updateByPrimaryKey(TPaybackAllocate record);
    
    int insertPaybackAllocate(Map<String, Object> map);

}