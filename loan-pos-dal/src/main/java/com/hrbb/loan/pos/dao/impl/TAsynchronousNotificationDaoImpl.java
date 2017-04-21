/**
 * 
 */
package com.hrbb.loan.pos.dao.impl;

import java.util.Date;
import java.util.List;
import java.util.Map;

import org.mybatis.spring.support.SqlSessionDaoSupport;
import org.springframework.stereotype.Repository;

import com.google.common.collect.Maps;
import com.hrbb.loan.pos.dao.TAsynchronousNotificationDao;
import com.hrbb.loan.pos.dao.entity.TAsynchronousNotification;

/**
 * <p>Title: TAsynchronousNotificationDaoImpl.java </p>
 * <p>Description:  </p>
 * <p>Copyright: Copyright (C) 2015 Hrbb Ltd. Co.</p> 
 *     
 * @author linzhaolin@hrbb.com.cn
 * @version 
 * @date Aug 30, 2015
 *
 * logs: 1. 
 */
@Repository("tAsynchronousNotificationDao")
public class TAsynchronousNotificationDaoImpl extends SqlSessionDaoSupport 
	implements TAsynchronousNotificationDao {

	/* (non-Javadoc)
	 * @see com.hrbb.loan.pos.dao.TAsynchronousNotificationDao#deleteByPrimaryKey(java.lang.Integer)
	 */
	@Override
	public int deleteByPrimaryKey(Integer id) {
		return getSqlSession().delete("TAsynchronousNotificationMapper.deleteByPrimaryKey", id);
	}

	/* (non-Javadoc)
	 * @see com.hrbb.loan.pos.dao.TAsynchronousNotificationDao#insert(com.hrbb.loan.pos.dao.entity.TAsynchronousNotification)
	 */
	@Override
	public int insert(TAsynchronousNotification record) {
		return getSqlSession().insert("TAsynchronousNotificationMapper.insert", record);
	}

	/* (non-Javadoc)
	 * @see com.hrbb.loan.pos.dao.TAsynchronousNotificationDao#insertSelective(com.hrbb.loan.pos.dao.entity.TAsynchronousNotification)
	 */
	@Override
	public int insertSelective(TAsynchronousNotification record) {
		return getSqlSession().insert("TAsynchronousNotificationMapper.insertSelective", record);
	}

	/* (non-Javadoc)
	 * @see com.hrbb.loan.pos.dao.TAsynchronousNotificationDao#selectByPrimaryKey(java.lang.Integer)
	 */
	@Override
	public TAsynchronousNotification selectByPrimaryKey(Integer id) {
		return getSqlSession().selectOne("TAsynchronousNotificationMapper.selectByPrimaryKey", id);
	}

	/* (non-Javadoc)
	 * @see com.hrbb.loan.pos.dao.TAsynchronousNotificationDao#updateByPrimaryKeySelective(com.hrbb.loan.pos.dao.entity.TAsynchronousNotification)
	 */
	@Override
	public int updateByPrimaryKeySelective(TAsynchronousNotification record) {
		return getSqlSession().update("TAsynchronousNotificationMapper.updateByPrimaryKeySelective", record);
	}

	/* (non-Javadoc)
	 * @see com.hrbb.loan.pos.dao.TAsynchronousNotificationDao#updateByPrimaryKey(com.hrbb.loan.pos.dao.entity.TAsynchronousNotification)
	 */
	@Override
	public int updateByPrimaryKey(TAsynchronousNotification record) {
		return getSqlSession().update("TAsynchronousNotificationMapper.updateByPrimaryKey", record);
	}

	@Override
	public List<TAsynchronousNotification> selectSelective(
			Map<String, Object> map) {
		return getSqlSession().selectList("TAsynchronousNotificationMapper.selectSelective", map);
	}

	@Override
	public List<TAsynchronousNotification> selectTodoList(
			Map<String, Object> map) {
		return getSqlSession().selectList("TAsynchronousNotificationMapper.selectTodoList", map);
	}

	@Override
	public int updateSatusByPrimaryKey(String status, int id) {
		Map<String,Object> map = Maps.newHashMap();
		map.put("id", id);
		map.put("notifyStatus", status);
		map.put("executeTime", new Date());
		return getSqlSession().update("TAsynchronousNotificationMapper.updateStatusByPrimaryKey", map);
	}

}
