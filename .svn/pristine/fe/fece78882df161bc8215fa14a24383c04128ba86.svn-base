/**
 * 
 *	哈尔滨银行
 * Copyright (c) 2007-2015 HRBB,Inc.All Rights Reserved.
 */
package com.hrbb.loan.pos.dao.impl;

import java.util.List;
import java.util.Map;

import org.mybatis.spring.support.SqlSessionDaoSupport;
import org.springframework.stereotype.Repository;

import com.hrbb.loan.pos.dao.TRiskCheckResultDao;
import com.hrbb.loan.pos.dao.entity.TRiskCheckResult;

/**
 * 
 * @author XLY
 * @version $Id: TRiskCheckResultDaoImpl.java, v 0.1 2015-3-9 下午6:46:12 XLY Exp $
 */
@Repository("tRiskCheckResultDao")
public class TRiskCheckResultDaoImpl extends SqlSessionDaoSupport implements TRiskCheckResultDao{
    
    public Long countCreitApply(Map<String, Object> map){
        return getSqlSession().selectOne("TRiskCheckResultMapper.countSelective", map);
    }
    
    @Override
    public List<Map<String, Object>> selectSelectiveMap(Map<String, Object> map) {
        return getSqlSession().selectList("TRiskCheckResultMapper.selectSelectiveMap", map);
    }
    
    public int deleteByPrimaryKey(String riskResultId){
        return getSqlSession().delete("TRiskCheckResultMapper.deleteByPrimaryKey", riskResultId);
    }

    public int insert(TRiskCheckResult record){
        return getSqlSession().insert("TRiskCheckResultMapper.insert", record);
    }

    public  int insertSelective(TRiskCheckResult record){
        return getSqlSession().insert("TRiskCheckResultMapper.insertSelective", record);
    }

    public TRiskCheckResult selectByPrimaryKey(String loanId){
        return getSqlSession().selectOne("TRiskCheckResultMapper.selectByPrimaryKey", loanId);
    }
    
    public TRiskCheckResult selectSelective(String loanId){
    	return getSqlSession().selectOne("TRiskCheckResultMapper.selectSelective", loanId);
    }

    public int updateByPrimaryKeySelective(TRiskCheckResult record){
        return getSqlSession().update("TRiskCheckResultMapper.updateByPrimaryKeySelective", record);
    }

    public int updateByPrimaryKey(TRiskCheckResult record){
        return getSqlSession().update("TRiskCheckResultMapper.updateByPrimaryKey", record);
    }
    
    @Override
    public int insertSelectiveMap(Map<String, Object> map) {
        return getSqlSession().insert("TRiskCheckResultMapper.insertSelectiveMap", map);
    }
    
    @Override
    public int updateByPrimaryKeySelectiveMap(Map<String, Object> map) {
        return getSqlSession().update("TRiskCheckResultMapper.updateByPrimaryKeySelectiveMap", map);
    }
}
