package com.hrbb.loan.pos.dao.impl;

import java.util.List;

import org.mybatis.spring.support.SqlSessionDaoSupport;
import org.springframework.stereotype.Repository;

import com.hrbb.loan.pos.dao.TUpsIndexMonthConsumeConditionDao;
import com.hrbb.loan.pos.dao.entity.TUpsIndexMonthConsumeCondition;

@Repository("tUpsIndexMonthConsumeConditionDao")
public class TUpsIndexMonthConsumeConditionDaoImpl extends SqlSessionDaoSupport implements TUpsIndexMonthConsumeConditionDao {

    @Override
    public int deleteByPrimaryKey(Integer id) {
        return getSqlSession().delete("TUpsIndexMonthConsumeConditionMapper.deleteByPrimaryKey",id);
    }

    @Override
    public int insert(TUpsIndexMonthConsumeCondition record) {
        return getSqlSession().insert("TUpsIndexMonthConsumeConditionMapper.insert",record);
    }

    @Override
    public int insertSelective(TUpsIndexMonthConsumeCondition record) {
        return getSqlSession().insert("TUpsIndexMonthConsumeConditionMapper.insertSelective",record);
    }

    @Override
    public TUpsIndexMonthConsumeCondition selectByPrimaryKey(Integer id) {
        return getSqlSession().selectOne("TUpsIndexMonthConsumeConditionMapper.selectByPrimaryKey",id);
    }

    @Override
    public int updateByPrimaryKeySelective(TUpsIndexMonthConsumeCondition record) {
        return getSqlSession().update("TUpsIndexMonthConsumeConditionMapper.updateByPrimaryKey",record);
    }

    @Override
    public int updateByPrimaryKey(TUpsIndexMonthConsumeCondition record) {
        return getSqlSession().selectOne("TUpsIndexMonthConsumeConditionMapper.updateByPrimaryKey",record);
    }

    @Override
    public int insertBatch(List<TUpsIndexMonthConsumeCondition> record) {
        return getSqlSession().insert("TUpsIndexMonthConsumeConditionMapper.insertBatch",record);
    }

    @Override
    public List<TUpsIndexMonthConsumeCondition> selectListByFileUuid(String fileUuid) {
        return getSqlSession().selectList("TUpsIndexMonthConsumeConditionMapper.selectByFileUuid", fileUuid);
    }

}
