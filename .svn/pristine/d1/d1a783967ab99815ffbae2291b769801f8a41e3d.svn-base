package com.hrbb.loan.pos.service;

import java.util.List;
import java.util.Map;

import com.hrbb.loan.pos.dao.entity.TCallingTask;

public interface CallingTaskService {

	public List<Map<String, Object>> selectSelective(Map<String, Object> ct);
	public long selectSelectiveForReviewCount(Map<String, Object> ct);
	public TCallingTask selectOne(String taskNo);
	public boolean updateTaskClaimer(Map<String, Object>reqMap);
	public boolean updateGenerateTime(Map<String, Object>reqMap);
	public List<TCallingTask> getTCallingTask(Map<String, Object> reqMap);
	public int updateTcallingTask1(Map<String, Object> map);
	public int updateTcallingTask2(Map<String, Object> map);
	public int insertSelective(TCallingTask record);
}
