/**
 * 
 */
package com.hrbb.loan.pos.service.impl;

import java.util.List;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.hrbb.loan.pos.dao.TMailNotificationDao;
import com.hrbb.loan.pos.dao.entity.TMailNotification;
import com.hrbb.loan.pos.service.TMailNotificationService;

/**
 * <p>Title: TMailNotificationServiceImpl.java </p>
 * <p>Description:  </p>
 * <p>Copyright: Copyright (C) 2015 Hrbb Ltd. Co.</p> 
 *     
 * @author linzhaolin@hrbb.com.cn
 * @version 
 * @date Sep 4, 2015
 *
 * logs: 1. 
 */
@Service("tMailNotificationService")
public class TMailNotificationServiceImpl implements TMailNotificationService {

	
	@Autowired
	private TMailNotificationDao tMailNotificationDao;
	
	/* (non-Javadoc)
	 * @see com.hrbb.loan.pos.service.TMailNotificationService#deleteByPrimaryKey(java.lang.Integer)
	 */
	@Override
	public int deleteByPrimaryKey(Integer id) {
		return tMailNotificationDao.deleteByPrimaryKey(id);
	}

	/* (non-Javadoc)
	 * @see com.hrbb.loan.pos.service.TMailNotificationService#insert(com.hrbb.loan.pos.dao.entity.TMailNotification)
	 */
	@Override
	public int insert(TMailNotification record) {
		return tMailNotificationDao.insert(record);
	}

	/* (non-Javadoc)
	 * @see com.hrbb.loan.pos.service.TMailNotificationService#insertSelective(com.hrbb.loan.pos.dao.entity.TMailNotification)
	 */
	@Override
	public int insertSelective(TMailNotification record) {
		return tMailNotificationDao.insertSelective(record);
	}

	/* (non-Javadoc)
	 * @see com.hrbb.loan.pos.service.TMailNotificationService#selectByPrimaryKey(java.lang.Integer)
	 */
	@Override
	public TMailNotification selectByPrimaryKey(Integer id) {
		return tMailNotificationDao.selectByPrimaryKey(id);
	}

	/* (non-Javadoc)
	 * @see com.hrbb.loan.pos.service.TMailNotificationService#updateByPrimaryKeySelective(com.hrbb.loan.pos.dao.entity.TMailNotification)
	 */
	@Override
	public int updateByPrimaryKeySelective(TMailNotification record) {
		return tMailNotificationDao.updateByPrimaryKeySelective(record);
	}

	/* (non-Javadoc)
	 * @see com.hrbb.loan.pos.service.TMailNotificationService#updateByPrimaryKey(com.hrbb.loan.pos.dao.entity.TMailNotification)
	 */
	@Override
	public int updateByPrimaryKey(TMailNotification record) {
		return tMailNotificationDao.updateByPrimaryKey(record);
	}

	@Override
	public List<TMailNotification> selectTodoList() {
		return tMailNotificationDao.selectTodoList();
	}

    @Override
    public int updateCount(Map<String, Object> map) {
        return tMailNotificationDao.updateCount(map);
    }

}
