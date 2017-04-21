/**
 * 
 */
package com.hrbb.loan.pos.dao.impl;

import java.util.List;
import java.util.Map;

import org.mybatis.spring.support.SqlSessionDaoSupport;
import org.springframework.stereotype.Repository;

import com.hrbb.loan.pos.dao.IGenericConfigDao;
import com.hrbb.loan.pos.dao.entity.TransactionLog;

/**
* <p>Title: GenericConfigDaoImpl.java </p>
* <p>Description:  </p>
* <p>Copyright: Copyright (C) 2015 Hrbb Ltd. Co.</p> 
*     
* @author linzhaolin@hrbb.com.cn
* @version 
* @date 2015-4-16
*
* logs: 1. 
*/
@Repository("genericConfigDao")
public class GenericConfigDaoImpl extends SqlSessionDaoSupport implements IGenericConfigDao {

	@Override
	public List<Map<String, Object>> selectSelective(Map<String, Object> map) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public Map<String, Object> getIssuerInfo(Map<String, Object> map) {
		return getSqlSession().selectOne("GenericConfigMapper.selectIssuerByBIN", map);
	}

	@Override
	public Map<String, Object> getMobileBelong(Map<String, Object> map) {
		return getSqlSession().selectOne("GenericConfigMapper.selectMobileBelong", map);
	}

	@Override
	public Map<String, Object> getNextWorkingDate(Map<String, Object> map) {
		return getSqlSession().selectOne("GenericConfigMapper.selectNextWorkingDate", map);
	}

	@Override
	public Map<String, Object> getRecInfo(Map<String, Object> map) {
		return getSqlSession().selectOne("GenericConfigMapper.selectRecInfo", map);
	}

	@Override
	public int insertTransactionLog(TransactionLog log) {
		return getSqlSession().insert("GenericConfigMapper.insertTransactionLog", log);
		
	}

	@Override
	public Map<String, Object> getRecInfoById(Integer orgId) {
		return getSqlSession().selectOne("GenericConfigMapper.selectRecInfoById", orgId);
	}

}
