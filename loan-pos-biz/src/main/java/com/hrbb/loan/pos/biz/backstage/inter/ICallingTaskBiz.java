package com.hrbb.loan.pos.biz.backstage.inter;

import java.util.List;
import java.util.Map;

import com.hrbb.loan.pos.dao.entity.TCallingTask;


public interface ICallingTaskBiz {

	public List<Map<String, Object>> selectSelective(Map<String, Object> ct);
	public long selectSelectiveForReviewCount(Map<String, Object> ct);
	public TCallingTask selectOne(String taskNo);
	public boolean updateTaskClaimer(Map<String, Object>reqMap);
	public boolean updateGenerateTime(Map<String, Object> reqMap);
	public int insertSelective(TCallingTask record);
}
