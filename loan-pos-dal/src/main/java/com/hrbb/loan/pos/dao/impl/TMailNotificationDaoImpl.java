/**
 * 
 */
package com.hrbb.loan.pos.dao.impl;

import java.util.List;
import java.util.Map;

import org.mybatis.spring.support.SqlSessionDaoSupport;
import org.springframework.stereotype.Repository;

import com.hrbb.loan.pos.dao.TMailNotificationDao;
import com.hrbb.loan.pos.dao.entity.TMailNotification;

/**
 * <p>Title: TMailNotificationDaoImpl.java </p>
 * <p>Description:  </p>
 * <p>Copyright: Copyright (C) 2015 Hrbb Ltd. Co.</p> 
 *     
 * @author linzhaolin@hrbb.com.cn
 * @version 
 * @date Sep 4, 2015
 * 
 * logs: 1. 
 */
@Repository("tMailNotificationDao")
public class TMailNotificationDaoImpl extends SqlSessionDaoSupport implements TMailNotificationDao {

	/* (non-Javadoc)
	 * @see com.hrbb.loan.pos.dao.TMailNotificationDao#deleteByPrimaryKey(java.lang.Integer)
	 */
	@Override
	public int deleteByPrimaryKey(Integer id) {
		return getSqlSession().delete("TMailNotificationMapper.deleteByPrimaryKey", id);
	}

	/* (non-Javadoc)
	 * @see com.hrbb.loan.pos.dao.TMailNotificationDao#insert(com.hrbb.loan.pos.dao.entity.TMailNotification)
	 */
	@Override
	public int insert(TMailNotification record) {
		return getSqlSession().insert("TMailNotificationMapper.insert", record);
	}

	/* (non-Javadoc)
	 * @see com.hrbb.loan.pos.dao.TMailNotificationDao#insertSelective(com.hrbb.loan.pos.dao.entity.TMailNotification)
	 */
	@Override
	public int insertSelective(TMailNotification record) {
		return getSqlSession().insert("TMailNotificationMapper.insertSelective", record);
	}

	/* (non-Javadoc)
	 * @see com.hrbb.loan.pos.dao.TMailNotificationDao#selectByPrimaryKey(java.lang.Integer)
	 */
	@Override
	public TMailNotification selectByPrimaryKey(Integer id) {
		return getSqlSession().selectOne("TMailNotificationMapper.selectByPrimaryKey", id);
	}

	/* (non-Javadoc)
	 * @see com.hrbb.loan.pos.dao.TMailNotificationDao#updateByPrimaryKeySelective(com.hrbb.loan.pos.dao.entity.TMailNotification)
	 */
	@Override
	public int updateByPrimaryKeySelective(TMailNotification record) {
		return getSqlSession().update("TMailNotificationMapper.updateByPrimaryKeySelective", record);
	}

	/* (non-Javadoc)
	 * @see com.hrbb.loan.pos.dao.TMailNotificationDao#updateByPrimaryKey(com.hrbb.loan.pos.dao.entity.TMailNotification)
	 */
	@Override
	public int updateByPrimaryKey(TMailNotification record) {
		return getSqlSession().update("TMailNotificationMapper.updateByPrimaryKey", record);
	}

	@Override
	public List<TMailNotification> selectTodoList() {
		return getSqlSession().selectList("TMailNotificationMapper.selectTodoList");
	}

    @Override
    public int updateCount(Map<String, Object> map) {
        return getSqlSession().update("TMailNotificationMapper.updateCount",map);
    }

}
