package com.hrbb.activity.action.handler.impl;

import java.util.Map;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.context.annotation.Scope;
import org.springframework.stereotype.Component;

import com.google.common.collect.Maps;
import com.hrbb.activity.action.handler.ActivityHandler;


@Component("handlerOne")
@Scope("prototype")
public class ActivityHandlerImplOne extends ActivityHandler{
	Logger logger = LoggerFactory.getLogger(ActivityHandlerImplOne.class);


	@Override
	public Map<String, Object> doSuccessor() {
		Map<String, Object> resMap = doRequest();
		if(resMap.get("resCode").equals("0")){
			//继续
			return successor.doSuccessor();
		}else{
			return resMap;
		}

	}

	@Override
	public Map<String, Object> doRequest() {
		Map<String, Object> respMap = Maps.newHashMap();
		logger.debug("这是action1");
		respMap.put("resCode", "0");
		return respMap;
	}
	
}
