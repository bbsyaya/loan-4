package com.hrbb.loan.pos.dao.impl;

import java.util.Map;

import org.mybatis.spring.support.SqlSessionDaoSupport;
import org.springframework.stereotype.Repository;

import com.hrbb.loan.pos.dao.TReviewAssignTaskDao;
import com.hrbb.loan.pos.dao.entity.TReviewAssignTask;
@Repository("tReviewAssignTaskDao")
public class TReviewAssignTaskDaoImpl  extends SqlSessionDaoSupport implements TReviewAssignTaskDao {

    @Override
    public int deleteByPrimaryKey(Integer id) {
        // TODO Auto-generated method stub
        return 0;
    }

    @Override
    public int insert(TReviewAssignTask record) {
        // TODO Auto-generated method stub
        return 0;
    }

    @Override
    public int insertSelective(TReviewAssignTask record) {
        // TODO Auto-generated method stub
        return 0;
    }

    @Override
    public TReviewAssignTask selectByPrimaryKey(Integer id) {
        // TODO Auto-generated method stub
        return null;
    }

    @Override
    public int updateByPrimaryKeySelective(TReviewAssignTask record) {
        // TODO Auto-generated method stub
        return 0;
    }

    @Override
    public int updateByPrimaryKey(TReviewAssignTask record) {
        // TODO Auto-generated method stub
        return 0;
    }

    @Override
    public String getReviewPersonByRule(Map<String, Object> map) {
        return getSqlSession().selectOne("TReviewAssignTaskMapper.getReviewPersonByRule", map);
    }

}
