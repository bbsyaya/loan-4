package com.hrbb.loan.pos.dao;

import com.hrbb.loan.pos.dao.entity.TTransactionRelative;

/**
 * 
 * @author cjq
 * @version $Id: TTransactionRelativeDao.java, v 0.1 2015年8月7日 下午1:17:15 cjq Exp $
 */
public interface TTransactionRelativeDao {
    
    int deleteByPrimaryKey(Integer id);

    int insert(TTransactionRelative record);

    int insertSelective(TTransactionRelative record);

    TTransactionRelative selectByPrimaryKey(Integer id);

    int updateByPrimaryKeySelective(TTransactionRelative record);

    int updateByPrimaryKey(TTransactionRelative record);
    
    TTransactionRelative selectByOutBizNo(String outBizNo);
    
    TTransactionRelative selectByBusinessId(String businessId);
}