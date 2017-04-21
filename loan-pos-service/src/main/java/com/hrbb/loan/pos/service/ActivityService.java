package com.hrbb.loan.pos.service;

import java.util.List;
import java.util.Map;

import com.hrbb.loan.pos.dao.entity.TActivityCommonInfo;
import com.hrbb.loan.pos.dao.entity.TActivityContentInfo;
import com.hrbb.loan.pos.dao.entity.TActivityDimInfo;
import com.hrbb.loan.pos.dao.entity.TActivityInfo;
import com.hrbb.loan.pos.dao.entity.TActivityTypeInfo;

public interface ActivityService {
	
	
	public void updateActivityDim(TActivityDimInfo tActivityDimInfo);
	
	public void addActivityDim(TActivityDimInfo tActivityDimInfo);
	
	public List<TActivityDimInfo> selectActivityDim(Map<String, Object> reqMap);
	
	public void updateActivityContent(TActivityContentInfo tActivityContentInfo);
	
	public void addActivityContent(TActivityContentInfo tActivityContentInfo);
	
	public List<TActivityContentInfo> selectActivityContent(Map<String, Object> reqMap);
	
	public void updateActivityInfo(TActivityInfo tActivityInfo);
	
	public void addActivityInfo(TActivityInfo tActivityInfo);
	
	public List<TActivityInfo> selectActivityInfo(Map<String, Object> reqMap);
	
	public String countActivityDim(Map<String, Object> reqMap);
	
	public String countActivityContent(Map<String, Object> reqMap);
	
	public String countActivity(Map<String, Object> reqMap);
	
	public TActivityCommonInfo getActivityCommon(Map<String, Object> reqMap);
	
	public List<TActivityTypeInfo> getActivityTypeInfos(Map<String, Object> reqMap);
	
	public TActivityTypeInfo getActivityTypeInfoByName(String activityName);
	
}
