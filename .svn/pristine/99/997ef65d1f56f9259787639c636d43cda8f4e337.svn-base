package com.hrbb.loan.pos.service.impl;

import java.util.List;
import java.util.Map;

import org.aspectj.apache.bcel.generic.ReturnaddressType;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import com.google.common.collect.Maps;
import com.hrbb.loan.pos.dao.TActivityCommonInfoDao;
import com.hrbb.loan.pos.dao.TActivityContentInfoDao;
import com.hrbb.loan.pos.dao.TActivityDimInfoDao;
import com.hrbb.loan.pos.dao.TActivityInfoDao;
import com.hrbb.loan.pos.dao.TActivityTypeInfoDao;
import com.hrbb.loan.pos.dao.entity.TActivityCommonInfo;
import com.hrbb.loan.pos.dao.entity.TActivityContentInfo;
import com.hrbb.loan.pos.dao.entity.TActivityDimInfo;
import com.hrbb.loan.pos.dao.entity.TActivityInfo;
import com.hrbb.loan.pos.dao.entity.TActivityTypeInfo;
import com.hrbb.loan.pos.service.ActivityService;

@Repository("activityService")
public class ActivityServiceImpl implements ActivityService {
	
	@Autowired
	private TActivityContentInfoDao tActivityContentInfoDao;
	
	@Autowired
	private TActivityDimInfoDao tActivityDimInfoDao;
	
	@Autowired
	private TActivityInfoDao tActivityInfoDao;
	
	@Autowired
	private TActivityCommonInfoDao tActivityCommonInfoDao;
	
	@Autowired
	private TActivityTypeInfoDao tActivityTypeInfoDao;

	@Override
	public void updateActivityDim(TActivityDimInfo tActivityDimInfo) {
		tActivityDimInfoDao.updateByPrimaryKeySelective(tActivityDimInfo);

	}

	@Override
	public void addActivityDim(TActivityDimInfo tActivityDimInfo) {
		tActivityDimInfoDao.insertSelective(tActivityDimInfo);
	}

	@Override
	public List<TActivityDimInfo> selectActivityDim(Map<String, Object> reqMap) {
		return tActivityDimInfoDao.selectSelective(reqMap);
	}

	@Override
	public void updateActivityContent(TActivityContentInfo tActivityContentInfo) {
		tActivityContentInfoDao.updateByPrimaryKeySelective(tActivityContentInfo);

	}

	@Override
	public void addActivityContent(TActivityContentInfo tActivityContentInfo) {
		tActivityContentInfoDao.insertSelective(tActivityContentInfo);
	}

	@Override
	public List<TActivityContentInfo> selectActivityContent(Map<String, Object> reqMap){
			return tActivityContentInfoDao.selectSelective(reqMap);
	}

	@Override
	public void updateActivityInfo(TActivityInfo tActivityInfo) {
		tActivityInfoDao.updateSelective(tActivityInfo);

	}

	@Override
	public void addActivityInfo(TActivityInfo tActivityInfo) {
		tActivityInfoDao.insertSelective(tActivityInfo);

	}

	@Override
	public List<TActivityInfo> selectActivityInfo(Map<String, Object> reqMap) {
		return tActivityInfoDao.selectSelective(reqMap);
	}

	@Override
	public String countActivityDim(Map<String, Object> reqMap) {
		return tActivityDimInfoDao.countSelective(reqMap);
	}

	@Override
	public String countActivityContent(Map<String, Object> reqMap) {
		return tActivityContentInfoDao.countSelective(reqMap);
	}

	@Override
	public String countActivity(Map<String, Object> reqMap) {
		return tActivityInfoDao.countSelective(reqMap);
	}

	@Override
	public TActivityCommonInfo getActivityCommon(Map<String, Object> reqMap) {
		return tActivityCommonInfoDao.selectSelective(reqMap);
	}

	@Override
	public List<TActivityTypeInfo> getActivityTypeInfos(
			Map<String, Object> reqMap) {
		return  tActivityTypeInfoDao.selectSelective(reqMap);
	}

	@Override
	public TActivityTypeInfo getActivityTypeInfoByName(String activityName) {
		Map<String, Object> reqMap = Maps.newHashMap();
		reqMap.put("activityName", activityName);
		
		return getActivityTypeInfos(reqMap).get(0);
	}

}
