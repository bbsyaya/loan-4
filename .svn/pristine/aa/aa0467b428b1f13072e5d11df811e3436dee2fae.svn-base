/**
 * 
 */
package com.hrbb.loan.pos.service.impl;

import java.util.List;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.hrbb.loan.pos.dao.TAsynchronousNotificationDao;
import com.hrbb.loan.pos.dao.entity.TAsynchronousNotification;
import com.hrbb.loan.pos.service.AsynchronousNotificationService;

/**
 * <p>Title: AsynchronousNotificationServiceImpl.java </p>
 * <p>Description:  </p>
 * <p>Copyright: Copyright (C) 2015 Hrbb Ltd. Co.</p> 
 *     
 * @author linzhaolin@hrbb.com.cn
 * @version 
 * @date Aug 30, 2015
 *
 * logs: 1. 
 */
@Service("asynchronousNotificationService")
public class AsynchronousNotificationServiceImpl implements
		AsynchronousNotificationService {

	@Autowired
	private TAsynchronousNotificationDao tAsynchronousNotificationDao;
	
	/* (non-Javadoc)
	 * @see com.hrbb.loan.pos.service.TAsynchronousNotificationService#deleteByPrimaryKey(java.lang.Integer)
	 */
	@Override
	public int deleteByPrimaryKey(Integer id) {
		return tAsynchronousNotificationDao.deleteByPrimaryKey(id);
	}

	/* (non-Javadoc)
	 * @see com.hrbb.loan.pos.service.TAsynchronousNotificationService#insert(com.hrbb.loan.pos.dao.entity.TAsynchronousNotification)
	 */
	@Override
	public int insert(TAsynchronousNotification record) {
		return tAsynchronousNotificationDao.insert(record);
	}

	/* (non-Javadoc)
	 * @see com.hrbb.loan.pos.service.TAsynchronousNotificationService#insertSelective(com.hrbb.loan.pos.dao.entity.TAsynchronousNotification)
	 */
	@Override
	public int insertSelective(TAsynchronousNotification record) {
		return tAsynchronousNotificationDao.insertSelective(record);
	}

	/* (non-Javadoc)
	 * @see com.hrbb.loan.pos.service.TAsynchronousNotificationService#selectByPrimaryKey(java.lang.Integer)
	 */
	@Override
	public TAsynchronousNotification selectByPrimaryKey(Integer id) {
		return tAsynchronousNotificationDao.selectByPrimaryKey(id);
	}

	/* (non-Javadoc)
	 * @see com.hrbb.loan.pos.service.TAsynchronousNotificationService#updateByPrimaryKeySelective(com.hrbb.loan.pos.dao.entity.TAsynchronousNotification)
	 */
	@Override
	public int updateByPrimaryKeySelective(TAsynchronousNotification record) {
		return tAsynchronousNotificationDao.updateByPrimaryKeySelective(record);
	}

	/* (non-Javadoc)
	 * @see com.hrbb.loan.pos.service.TAsynchronousNotificationService#updateByPrimaryKey(com.hrbb.loan.pos.dao.entity.TAsynchronousNotification)
	 */
	@Override
	public int updateByPrimaryKey(TAsynchronousNotification record) {
		return tAsynchronousNotificationDao.updateByPrimaryKey(record);
	}

	@Override
	public List<TAsynchronousNotification> selectSelective(
			Map<String, Object> map) {
		return tAsynchronousNotificationDao.selectSelective(map);
	}

	@Override
	public List<TAsynchronousNotification> selectTodoList(
			Map<String, Object> map) {
		return tAsynchronousNotificationDao.selectTodoList(map);
	}

	@Override
	public int updateSatusByPrimaryKey(String status, int id) {
		return tAsynchronousNotificationDao.updateSatusByPrimaryKey(status, id);
	}
	
	

}
