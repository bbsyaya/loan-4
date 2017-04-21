package com.hrbb.loan.pos.dao;

import java.util.List;

import com.hrbb.loan.pos.dao.entity.TUpsIndexMonthConsumeCondition;

public interface TUpsIndexMonthConsumeConditionDao {
    int deleteByPrimaryKey(Integer id);

    int insert(TUpsIndexMonthConsumeCondition record);

    int insertSelective(TUpsIndexMonthConsumeCondition record);
    
    int insertBatch(List<TUpsIndexMonthConsumeCondition> record);

    TUpsIndexMonthConsumeCondition selectByPrimaryKey(Integer id);

    int updateByPrimaryKeySelective(TUpsIndexMonthConsumeCondition record);

    int updateByPrimaryKey(TUpsIndexMonthConsumeCondition record);
    
    /**
     * 查询汇总情况
     * 
     * @param fileUuid
     * @return
     */
    List<TUpsIndexMonthConsumeCondition> selectListByFileUuid(String fileUuid);
}