package com.hrbb.loan.pos.biz.backstage.inter.impl;

import java.lang.reflect.Field;
import java.util.List;
import java.util.Map;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import com.alibaba.fastjson.JSON;
import com.alibaba.fastjson.JSONObject;
import com.google.common.collect.Maps;
import com.hrbb.loan.pos.biz.backstage.inter.ActivityBiz;
import com.hrbb.loan.pos.dao.entity.TActivityCommonInfo;
import com.hrbb.loan.pos.dao.entity.TActivityContentInfo;
import com.hrbb.loan.pos.dao.entity.TActivityDimInfo;
import com.hrbb.loan.pos.dao.entity.TActivityInfo;
import com.hrbb.loan.pos.dao.entity.TActivityTypeInfo;
import com.hrbb.loan.pos.service.ActivityService;
import com.hrbb.loan.pos.service.CommonService;
import com.hrbb.loan.pos.util.StringUtil;

@Component("activityBiz")
public class ActivityBizImpl implements ActivityBiz {
	
	private final String ACT_FLAG = "actFlag";
	private final String ID = "id";
	
	private Logger logger = LoggerFactory.getLogger(ActivityBizImpl.class);
	
	@Autowired
	private ActivityService activityService;
	
	@Autowired
	private CommonService commonService;

	@Override
	public TActivityDimInfo getActivityDimById(String id) {
		Map<String, Object> reqMap = Maps.newHashMap();
		reqMap.put(ACT_FLAG, "0");
		reqMap.put(ID, id);
		List<TActivityDimInfo> dimInfoList = activityService.selectActivityDim(reqMap);
		if(!dimInfoList.isEmpty()){
			return dimInfoList.get(0);
		}else{
			return null;
		}
		
	}

	@Override
	public TActivityContentInfo getActivityContentInfoById(String id) {
		Map<String, Object> reqMap = Maps.newHashMap();
		reqMap.put(ACT_FLAG, "0");
		reqMap.put(ID, id);
		List<TActivityContentInfo> contentList = activityService.selectActivityContent(reqMap);
		if(!contentList.isEmpty()){
			return contentList.get(0);
		}else{
			return null;
		}
	}

	@Override
	public List<TActivityInfo> getActivityList(Map<String, Object> reqMap) {
		return activityService.selectActivityInfo(reqMap);
	}

	@Override
	public void addActivityDim(TActivityDimInfo tActivityDimInfo) {
		activityService.addActivityDim(tActivityDimInfo);
	}

	@Override
	public void addActivityContent(TActivityContentInfo tActivityContentInfo) {
		activityService.addActivityContent(tActivityContentInfo);
	}

	@Override
	public void addActivity(TActivityInfo tActivityInfo) {
		activityService.addActivityInfo(tActivityInfo);
	}

	@Override
	public void updateActvityDim(TActivityDimInfo record) {
		activityService.updateActivityDim(record);
	}

	@Override
	public void updateActivityContent(TActivityContentInfo record) {
		activityService.updateActivityContent(record);
	}

	@Override
	public void updateActivityInfo(TActivityInfo record) {
		activityService.updateActivityInfo(record);
	}

	@Override
	public List<TActivityContentInfo> geTActivityContentInfos(
			Map<String, Object> reqMap) {
		return activityService.selectActivityContent(reqMap);
	}

	@Override
	public List<TActivityDimInfo> getTActivityDimInfos(
			Map<String, Object> reqMap) {
		return activityService.selectActivityDim(reqMap);
	}

	@Override
	public String countActivity(Map<String, Object> reqMap) {
		return activityService.countActivity(reqMap);
	}

	@Override
	public String countActivityDim(Map<String, Object> reqMap) {
		return activityService.countActivityDim(reqMap);
	}

	@Override
	public String countActivityContent(Map<String, Object> reqMap) {
		return activityService.countActivityContent(reqMap);
	}

	@Override
	public List<Map<String, Object>> executeCommonQuery(
			String sql) {
		return commonService.executeCommonQuery(sql);
	}

	@Override
	public TActivityCommonInfo getActivityCommonInfo(Map<String, Object> reqMap) {
		return activityService.getActivityCommon(reqMap);
	}

	

	@Override
	public List<TActivityTypeInfo> getTActivityTypeInfos() {
		Map<String, Object> reqMap = Maps.newHashMap();
		return activityService.getActivityTypeInfos(reqMap);
	}
	

}
