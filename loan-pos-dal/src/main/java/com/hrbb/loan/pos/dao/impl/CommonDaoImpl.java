package com.hrbb.loan.pos.dao.impl;

import java.util.List;
import java.util.Map;

import org.mybatis.spring.support.SqlSessionDaoSupport;
import org.springframework.stereotype.Repository;

import com.hrbb.loan.pos.dao.CommonDao;

@Repository("commonDao")
public class CommonDaoImpl extends SqlSessionDaoSupport implements CommonDao {

	@Override
	public List<Map<String, Object>> commonQuery(Map<String, Object> reqMap) {
		return getSqlSession().selectList("commonMapper.commonSelect", reqMap);
	}

}
