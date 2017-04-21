package com.hrbb.loan.pos.dao.impl;

import java.util.List;
import java.util.Map;

import org.mybatis.spring.support.SqlSessionDaoSupport;
import org.springframework.stereotype.Repository;

import com.hrbb.loan.pos.dao.TImportDao;
@Repository("tImportDao")
public class TImportDaoImpl extends SqlSessionDaoSupport implements TImportDao {

	@Override
	public List<Map<String, Object>> getImportListInfo() {
		return getSqlSession().selectList("TPaybackImportInfoMapper.getImportListInfo");
	}

	@Override
	public int insertImportData(Map<String, Object> importMap) {
		return getSqlSession().insert("TPaybackImportInfoMapper.insertImportData",importMap);
	}

}
