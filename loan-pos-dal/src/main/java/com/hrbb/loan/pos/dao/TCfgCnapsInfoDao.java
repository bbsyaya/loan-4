package com.hrbb.loan.pos.dao;

import java.util.List;
import java.util.Map;

import com.hrbb.loan.pos.dao.entity.TCfgCnapsInfo;

public interface TCfgCnapsInfoDao {
    int deleteByPrimaryKey(Integer id);

    int insert(TCfgCnapsInfo record);

    int insertSelective(TCfgCnapsInfo record);

    TCfgCnapsInfo selectByPrimaryKey(Integer id);

    int updateByPrimaryKeySelective(TCfgCnapsInfo record);

    int updateByPrimaryKey(TCfgCnapsInfo record);
    
    /**
     * 
     * @param reqMap
     * @return
     */
    List<TCfgCnapsInfo> getBankInfoBySelective(Map<String,Object> reqMap);
}