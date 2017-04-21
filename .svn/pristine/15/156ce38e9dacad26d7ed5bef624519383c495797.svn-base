package com.hrbb.loan.pos.dao.impl;

import java.util.List;
import java.util.Map;

import org.mybatis.spring.support.SqlSessionDaoSupport;
import org.springframework.stereotype.Repository;

import com.hrbb.loan.pos.dao.TPaymentApplyTmpDao;
import com.hrbb.loan.pos.dao.entity.TPaymentApplyTmp;

@Repository("tPaymentApplyTmpDao")
public class TPaymentApplyTmpDaoImpl extends SqlSessionDaoSupport implements TPaymentApplyTmpDao {

    @Override
    public int deleteByPrimaryKey(String payApplyId) {
        return this.getSqlSession().delete("TPaymentApplyTmpMapper.deleteByPrimaryKey",payApplyId);
    }

    @Override
    public int insert(TPaymentApplyTmp record) {
        return this.getSqlSession().insert("TPaymentApplyTmpMapper.insert", record);
    }

    @Override
    public int insertSelective(TPaymentApplyTmp record) {
        return this.getSqlSession().insert("TPaymentApplyTmpMapper.insertSelective", record);
    }

    @Override
    public TPaymentApplyTmp selectByPrimaryKey(String payApplyId) {
        return this.getSqlSession().selectOne("TPaymentApplyTmpMapper.selectByPrimaryKey", payApplyId);
    }

    @Override
    public int updateByPrimaryKeySelective(TPaymentApplyTmp record) {
        return this.getSqlSession().update("TPaymentApplyTmpMapper.updateByPrimaryKeySelective", record);
    }

    @Override
    public int updateByPrimaryKey(TPaymentApplyTmp record) {
        return this.getSqlSession().update("TPaymentApplyTmpMapper.updateByPrimaryKey", record);
    }

    @Override
    public List<TPaymentApplyTmp> selectByObj(Map<String, Object> objMap) {
        return this.getSqlSession().selectList("TPaymentApplyTmpMapper.selectByObj", objMap);
    }
    
    @Override
    public int insertSelectiveMap(Map<String, Object> reqMap) {
        return this.getSqlSession().insert("TPaymentApplyTmpMapper.insertSelectiveMap", reqMap);

    }
}
