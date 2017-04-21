package com.hrbb.loan.pos.dao;

import java.util.List;
import java.util.Map;

import com.hrbb.loan.pos.dao.entity.TBdExecutor;

public interface TBdExecutorDao {
    int deleteByPrimaryKey(Integer menberId);

    int insert(TBdExecutor record);

    int insertSelective(TBdExecutor record);

    int insertSelectiveMap(Map<String,Object> reqMap);
    
    TBdExecutor selectByPrimaryKey(Integer menberId);

    int updateByPrimaryKeySelective(TBdExecutor record);
    
    int updateByPrimaryKeySelectiveMap(Map<String,Object> reqMap);

    int updateByPrimaryKey(TBdExecutor record);
    
    List<TBdExecutor> selectListBySelective(Map<String,Object> reqMap);

    long countListBySelective(Map<String, Object> reqMap) ;
    
    List<TBdExecutor> selectByCertNo(String certNo);
    
    int updateExecutorByBelongOrg(String belongOrgName, Integer belongOrg);
    
    int updateExecutorActive(Integer menberId,String active);
    
    
}