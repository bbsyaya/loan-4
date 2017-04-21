package com.hrbb.loan.pos.dao;

import java.util.List;
import java.util.Map;

import com.hrbb.loan.pos.dao.entity.TCallingTask;

public interface TCallingTaskDao {
    int deleteByPrimaryKey(String taskNo);

    int insert(TCallingTask record);

    int insertSelective(TCallingTask record);

    TCallingTask selectByPrimaryKey(String taskNo);

    int updateByPrimaryKeySelective(TCallingTask record);

    int updateByPrimaryKey(TCallingTask record);
    
    List<Map<String, Object>> selectSelective(Map<String, Object> reqMap);
    long selectSelectiveForReviewCount(Map<String, Object> reqMap) ;
    
    int updateTaskClaimer(Map<String, Object> reqMap);
    
    int updateGenerateTime(Map<String, Object>reqMap);

    List<TCallingTask> getTCallingTask(Map<String, Object> reqMap);

	int updateTcallingTask1(Map<String, Object> map);

	int updateTcallingTask2(Map<String, Object> map);
    
}