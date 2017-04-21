/**
 * 
 *	哈尔滨银行
 * Copyright (c) 2007-2015 HRBB,Inc.All Rights Reserved.
 */
package com.hrbb.loan.pos.dao.impl;

import org.mybatis.spring.support.SqlSessionDaoSupport;
import org.springframework.stereotype.Repository;

import com.hrbb.loan.pos.dao.TDueDiligenceDao;
import com.hrbb.loan.pos.dao.entity.TDueDiligence;

/**
 * 
 * @author marco
 * @version $Id: TDueDiligenceDaoImpl.java, v 0.1 2015-3-2 下午7:11:42 marco Exp $
 */
@Repository("tDueDiligenceDao")
public class TDueDiligenceDaoImpl extends SqlSessionDaoSupport implements TDueDiligenceDao {

    /**
     * @see com.hrbb.loan.pos.dao.TDueDiligenceDao#deleteByPrimaryKey(java.lang.String)
     */
    @Override
    public int deleteByPrimaryKey(String loanid) {
        return 0;
    }

    /**
     * @see com.hrbb.loan.pos.dao.TDueDiligenceDao#insert(com.hrbb.loan.pos.dao.entity.TDueDiligence)
     */
    @Override
    public int insert(TDueDiligence record) {
        return getSqlSession().insert("TDueDiligenceMapper.insert", record);
    }

    /**
     * @see com.hrbb.loan.pos.dao.TDueDiligenceDao#insertSelective(com.hrbb.loan.pos.dao.entity.TDueDiligence)
     */
    @Override
    public int insertSelective(TDueDiligence record) {
        return getSqlSession().insert("TDueDiligenceMapper.insertSelective", record);
    }

    /**
     * @see com.hrbb.loan.pos.dao.TDueDiligenceDao#selectByPrimaryKey(java.lang.String)
     */
    @Override
    public TDueDiligence selectByPrimaryKey(String loanid) {
        return getSqlSession().selectOne("TDueDiligenceMapper.selectByPrimaryKey", loanid);
    }

    /**
     * 
     * @see com.hrbb.loan.pos.dao.TDueDiligenceDao#updateByPrimaryKeySelective(com.hrbb.loan.pos.dao.entity.TDueDiligence)
     */
    @Override
    public int updateByPrimaryKeySelective(TDueDiligence record) {
        return 0;
    }

    /**
     * 
     * @see com.hrbb.loan.pos.dao.TDueDiligenceDao#updateByPrimaryKey(com.hrbb.loan.pos.dao.entity.TDueDiligence)
     */
    @Override
    public int updateByPrimaryKey(TDueDiligence record) {
        return 0;
    }
}
