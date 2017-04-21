package com.hrbb.loan.pos.dao;

import com.hrbb.loan.pos.dao.entity.TPaymentApplyBackpool;

/**
 * 
 * @author cjq
 * @version $Id: TPaymentApplyBackpoolDao.java, v 0.1 2015年8月26日 下午4:18:55 cjq Exp $
 */
public interface TPaymentApplyBackpoolDao {
    
    int deleteByPrimaryKey(Integer id);

    int insert(TPaymentApplyBackpool record);

    int insertSelective(TPaymentApplyBackpool record);

    TPaymentApplyBackpool selectByPrimaryKey(Integer id);

    int updateByPrimaryKeySelective(TPaymentApplyBackpool record);

    int updateByPrimaryKey(TPaymentApplyBackpool record);
}