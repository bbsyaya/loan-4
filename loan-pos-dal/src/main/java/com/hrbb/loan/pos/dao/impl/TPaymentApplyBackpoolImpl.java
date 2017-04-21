package com.hrbb.loan.pos.dao.impl;

import org.mybatis.spring.support.SqlSessionDaoSupport;
import org.springframework.stereotype.Repository;

import com.hrbb.loan.pos.dao.TPaymentApplyBackpoolDao;
import com.hrbb.loan.pos.dao.entity.TPaymentApplyBackpool;

@Repository("tPaymentApplyBackpoolDao")
public class TPaymentApplyBackpoolImpl extends SqlSessionDaoSupport implements TPaymentApplyBackpoolDao {

    @Override
    public int deleteByPrimaryKey(Integer id) {
        return 0;
    }

    @Override
    public int insert(TPaymentApplyBackpool record) {
        return 0;
    }

    @Override
    public int insertSelective(TPaymentApplyBackpool record) {
        return getSqlSession().insert("TPaymentApplyBackpoolMapper.insertSelective",record);
    }

    @Override
    public TPaymentApplyBackpool selectByPrimaryKey(Integer id) {
        return null;
    }

    @Override
    public int updateByPrimaryKeySelective(TPaymentApplyBackpool record) {
        return 0;
    }

    @Override
    public int updateByPrimaryKey(TPaymentApplyBackpool record) {
        return 0;
    }

}
