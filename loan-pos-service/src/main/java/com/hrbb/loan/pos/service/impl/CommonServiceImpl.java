package com.hrbb.loan.pos.service.impl;

import java.util.List;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.google.common.collect.Maps;
import com.hrbb.loan.pos.dao.CommonDao;
import com.hrbb.loan.pos.service.CommonService;

@Service("commonServices")
public class CommonServiceImpl implements CommonService {

	@Autowired
	private CommonDao commonDao;
	@Override
	public List<Map<String, Object>> executeCommonQuery(String sql) {
		Map<String, Object> reqMap = Maps.newHashMap();
		reqMap.put("sq", sql);
		return commonDao.commonQuery(reqMap);
	}

}
