package com.hrbb.loan.pos.dao.impl;

import org.mybatis.spring.support.SqlSessionDaoSupport;
import org.springframework.stereotype.Repository;

import com.hrbb.loan.pos.dao.TTransactionRelativeDao;
import com.hrbb.loan.pos.dao.entity.TTransactionRelative;

@Repository("tTransactionRelativeDao")
public class TTransactionRelativeDaoImpl extends SqlSessionDaoSupport implements TTransactionRelativeDao {

    @Override
    public int deleteByPrimaryKey(Integer id) {
        return 0;
    }

    @Override
    public int insert(TTransactionRelative record) {
        return getSqlSession().insert("TTransactionRelativeMapper.insert",record);
    }

    @Override
    public int insertSelective(TTransactionRelative record) {
        return getSqlSession().insert("TTransactionRelativeMapper.insertSelective",record);
    }

    @Override
    public TTransactionRelative selectByPrimaryKey(Integer id) {
        return null;
    }

    @Override
    public int updateByPrimaryKeySelective(TTransactionRelative record) {
        return 0;
    }

    @Override
    public int updateByPrimaryKey(TTransactionRelative record) {
        return 0;
    }

    @Override
    public TTransactionRelative selectByOutBizNo(String outBizNo) {
        return getSqlSession().selectOne("TTransactionRelativeMapper.selectByOutBizNo", outBizNo);
    }

    @Override
    public TTransactionRelative selectByBusinessId(String businessId) {
        return getSqlSession().selectOne("TTransactionRelativeMapper.selectByBusinessId", businessId);
    }

}
