package com.hrbb.activity.action;

import java.lang.reflect.Field;
import java.util.List;
import java.util.Map;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import com.alibaba.fastjson.JSON;
import com.google.common.collect.Lists;
import com.google.common.collect.Maps;
import com.hrbb.activity.action.handler.ActivityHandler;
import com.hrbb.loan.pos.biz.backstage.inter.ActivityBiz;
import com.hrbb.loan.pos.dao.entity.TActivityInfo;
import com.hrbb.loan.pos.dao.entity.TActivityTypeInfo;
import com.hrbb.loan.pos.service.ActivityService;
import com.hrbb.loan.pos.service.CommonService;
import com.hrbb.loan.pos.util.StringUtil;

@Component
public class GetActivityResultImpl implements GetActivityResultInter{
	
	private Logger logger = LoggerFactory.getLogger(GetActivityResultImpl.class);

	@Autowired
	private ActivityService activityService;
	
	@Autowired
	private CommonService commonService;
	
	@Autowired
	private BeanAware beanAware;
	
	@Autowired
	private ActivityBiz activityBiz;
	
	@SuppressWarnings("unchecked")
	@Override
	public Map<String, Object> takePartInActivity(Map<String, Object> activityMap){
		Map<String, Object> resMap = Maps.newHashMap();
		/*List<>*/
		try{
			for(Map.Entry<String, Object> en: activityMap.entrySet()){
				List<ActivityHandler> handlerList = Lists.newArrayList();
				ActivityHandler resHandler = null;
				Object obj = en.getValue();
				Map<String, Object> reqMap = Maps.newHashMap();
				reqMap.put("actId", en.getKey());
				TActivityInfo info = activityBiz.getActivityList(reqMap).get(0);
				String[] beanNames = null;
				if(StringUtil.isNotEmpty(info.getActionName())){
					 beanNames = info.getActionName().split("\\|");
				}
				if(beanNames != null){
					for(String beanName : beanNames){
						ActivityHandler handler = (ActivityHandler) beanAware.getBeanByName(beanName);
						handler.setReqMap((Map<String, Object>)activityMap.get(en.getKey()));
						handlerList.add(handler);
					}
				}
				for(int i = handlerList.size() - 1; i>0; i--){
					handlerList.get(i-1).setSuccessor(handlerList.get(i));
				}
				if(handlerList.size() > 0 ){
					resHandler = handlerList.get(0);
				}
				return resHandler.doSuccessor();
			}
			return resMap;
		}catch(Exception e){
			logger.error("参加活动发生异常", e);
			return Maps.newHashMap();
		}
		
	}

	@Override
	public List<String> checkCanTakePartInActivity(Object obj) {
		if(obj == null){
			return null;
		}
		String sql = null;
		try{
		List<String> result = Lists.newArrayList();
		Map<String, Object> reqMap = Maps.newHashMap();
		@SuppressWarnings("rawtypes")
		Class clazz = obj.getClass();
		String className = clazz.getSimpleName();
		TActivityTypeInfo typeInfo = activityService.getActivityTypeInfoByName(className);
		if(typeInfo != null){
			reqMap.put("activityType", typeInfo.getActivityType());
		}
		List<TActivityInfo> activityList = activityService.selectActivityInfo(reqMap);
		for(TActivityInfo info : activityList){
			Field[] fields = clazz.getDeclaredFields();
			for(Field field : fields){
				field.setAccessible(true);
				if(field.get(obj) instanceof String && field.getName().contains("Id") && field.get(obj) != null){
					sql = info.getActContentSql().replace("#"+field.getName(), (String)field.get(obj));
				}
			}
			if(StringUtil.isNotEmpty(info.getActParam())){
				Map<String, String> paraMap = (Map<String, String>) JSON.parse(info.getActParam());
				for(Map.Entry<String, String> en : paraMap.entrySet()){
					sql = sql.replace("#"+en.getKey(), en.getValue());
				}
			}
			Map<String, Object> queryResultMap = commonService.executeCommonQuery(sql).get(0);
			String beanName = (String)queryResultMap.get("result");
			if(StringUtil.isNotEmpty(beanName)){
				result.add(info.getActId());
			}
			
		}
		return result;
		}catch(Exception e){
			logger.error("发生异常:", e);
			return Lists.newArrayList();
		}
	}
}
