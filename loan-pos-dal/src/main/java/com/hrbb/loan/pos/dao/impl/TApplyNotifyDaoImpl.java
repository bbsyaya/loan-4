/**
 * 
 */
package com.hrbb.loan.pos.dao.impl;

import java.util.List;
import java.util.Map;

import org.mybatis.spring.support.SqlSessionDaoSupport;
import org.springframework.stereotype.Repository;

import com.hrbb.loan.pos.dao.TApplyNotifyDao;
import com.hrbb.loan.pos.dao.entity.TApplyNotify;

/**
 * <p>Title: TApplyNotifyDaoImpl.java </p>
 * <p>Description:  </p>
 * <p>Copyright: Copyright (C) 2015 Hrbb Ltd. Co.</p> 
 *     
 * @author linzhaolin@hrbb.com.cn
 * @version 
 * @date Sep 7, 2015
 *
 * logs: 1. 
 */
@Repository("tApplyNotifyDao")
public class TApplyNotifyDaoImpl extends SqlSessionDaoSupport implements TApplyNotifyDao {

	/* (non-Javadoc)
	 * @see com.hrbb.loan.pos.dao.TApplyNotifyDao#selectTimelyApproval(java.util.Map)
	 */
	@Override
	public List<TApplyNotify> selectTimelyApproval(Map<String, Object> request) {
		return getSqlSession().selectList("TApplyNotifyMapper.selectTimelyApproval", request);
	}

}
