package com.hrbb.loan.pos.biz.backstage.inter;

import java.util.List;
import java.util.Map;

import com.hrbb.loan.pos.dao.entity.TActivityCommonInfo;
import com.hrbb.loan.pos.dao.entity.TActivityContentInfo;
import com.hrbb.loan.pos.dao.entity.TActivityDimInfo;
import com.hrbb.loan.pos.dao.entity.TActivityInfo;
import com.hrbb.loan.pos.dao.entity.TActivityTypeInfo;

public interface ActivityBiz {

	public TActivityDimInfo getActivityDimById(String id);
	
	public TActivityContentInfo getActivityContentInfoById(String id);
	
	public List<TActivityInfo> getActivityList(Map<String, Object> reqMap);
	
	public List<TActivityContentInfo> geTActivityContentInfos(Map<String, Object> reqMap);
	
	public List<TActivityDimInfo> getTActivityDimInfos(Map<String, Object> reqMap);
	
	public List<TActivityTypeInfo> getTActivityTypeInfos();
	
	public void addActivityDim(TActivityDimInfo tActivityDimInfo);
	
	public void addActivityContent(TActivityContentInfo tActivityContentInfo);
	
	public void addActivity(TActivityInfo tActivityInfo);
	
	public void updateActvityDim(TActivityDimInfo record);
	
	public void updateActivityContent(TActivityContentInfo record);
	
	public void updateActivityInfo(TActivityInfo record);
	
	public String countActivity(Map<String, Object> reqMap);
	
	public String countActivityDim(Map<String, Object> reqMap);
	
	public String countActivityContent(Map<String, Object> reqMap);
	
	public List<Map<String, Object>> executeCommonQuery(String sql);
	
	public TActivityCommonInfo getActivityCommonInfo(Map<String, Object> reqMap);

}
