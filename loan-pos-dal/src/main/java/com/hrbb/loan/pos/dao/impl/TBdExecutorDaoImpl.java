package com.hrbb.loan.pos.dao.impl;

import java.util.List;
import java.util.Map;

import org.mybatis.spring.support.SqlSessionDaoSupport;
import org.springframework.stereotype.Repository;

import com.google.common.collect.Maps;
import com.hrbb.loan.pos.dao.TBdExecutorDao;
import com.hrbb.loan.pos.dao.entity.TBdExecutor;

@Repository("tBdExecutorDao")
public class TBdExecutorDaoImpl extends SqlSessionDaoSupport implements TBdExecutorDao {

    @Override
    public int deleteByPrimaryKey(Integer menberId) {
        return 0;
    }

    @Override
    public int insert(TBdExecutor record) {
        return 0;
    }

    @Override
    public int insertSelective(TBdExecutor record) {
        return getSqlSession().insert("TBdExecutorMapper.insertSelective", record);
    }


    @Override
    public int insertSelectiveMap(Map<String, Object> reqMap) {
        return getSqlSession().insert("TBdExecutorMapper.insertSelectiveMap", reqMap);
    }
    
    @Override
    public TBdExecutor selectByPrimaryKey(Integer menberId) {
        return getSqlSession().selectOne("TBdExecutorMapper.selectByPrimaryKey", menberId);
    }

    @Override
    public int updateByPrimaryKeySelective(TBdExecutor record) {
        return 0;
    }

    @Override
    public int updateByPrimaryKeySelectiveMap(Map<String, Object> reqMap) {
        return getSqlSession().update("TBdExecutorMapper.updateByPrimaryKeySelectiveMap", reqMap);
    }

    
    @Override
    public int updateByPrimaryKey(TBdExecutor record) {
        return 0;
    }

    @Override
    public List<TBdExecutor> selectListBySelective(Map<String, Object> reqMap) {
        return getSqlSession().selectList("TBdExecutorMapper.selectListBySelective", reqMap);
    }

    @Override
    public long countListBySelective(Map<String, Object> reqMap) {
        return getSqlSession().selectOne("TBdExecutorMapper.countListBySelective", reqMap);
    }

    @Override
    public List<TBdExecutor> selectByCertNo(String certNo) {
        return getSqlSession().selectList("TBdExecutorMapper.selectByCertNo", certNo);
    }

    @Override
    public int updateExecutorByBelongOrg(String belongOrgName, Integer belongOrg) {
        Map<String,Object> reqMap = Maps.newHashMap();
        reqMap.put("belongOrgName", belongOrgName);
        reqMap.put("belongOrg", belongOrg);
        return getSqlSession().update("TBdExecutorMapper.updateExecutorByBelongOrg", reqMap);
    }

    @Override
    public int updateExecutorActive(Integer menberId, String active) {
        Map<String,Object> reqMap = Maps.newHashMap();
        reqMap.put("menberId", menberId);
        reqMap.put("active", active);
        return getSqlSession().update("TBdExecutorMapper.updateExecutorActive", reqMap);
    }

}
