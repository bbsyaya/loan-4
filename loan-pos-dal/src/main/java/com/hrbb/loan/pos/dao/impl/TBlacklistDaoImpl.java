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

import com.hrbb.loan.pos.dao.TBlacklistDao;
import com.hrbb.loan.pos.dao.entity.TBlacklist;

/**
 * 
 * @author XLY
 * @version $Id: TBlacklistDaoImpl.java, v 0.1 2015-2-28 下午2:10:49 XLY Exp $
 */
@Repository("tBlacklistDao")
public class TBlacklistDaoImpl extends SqlSessionDaoSupport implements TBlacklistDao{

    public int deleteByPrimaryKey(String id){
        return getSqlSession().delete("TBlacklistMapper.deleteByPrimaryKey", id);
    }

    public int insert(TBlacklist record){
        return getSqlSession().insert("TBlacklistMapper.insert", record);
    }

    public int insertSelective(TBlacklist record){
        return getSqlSession().insert("TBlacklistMapper.insertSelective", record);

    }

    public TBlacklist selectByPrimaryKey(String id){
        return getSqlSession().selectOne("TBlacklistMapper.selectByPrimaryKey", id);
    }

    public int updateByPrimaryKeySelective(TBlacklist record){
        return getSqlSession().update("TBlacklistMapper.updateByPrimaryKeySelective", record);
    }

    public int updateByPrimaryKey(TBlacklist record){
        return getSqlSession().update("TBlacklistMapper.updateByPrimaryKey", record);
    }
    
    /**
     * <h2>选择性获取数据</h2>
     * @param Map
     * @return List
     */
    @Override
    public List<TBlacklist> selectSelective(Map<String, Object> map) {
        return getSqlSession().selectList("TBlacklistMapper.selectSelective", map);
    }
    
    @Override
    public Long selectSelectiveNum(Map<String, Object> map) {
        Long totalRecords=(Long)this.getSqlSession().selectOne("TBlacklistMapper.queryCount",map);
        return totalRecords;
    }
    
    @Override
    public Long countBlacklist(Map<String, Object> map){   
        return getSqlSession().selectOne("TBlacklistMapper.countSelective", map);
    
    }
    
    @Override
    public List<Map<String, Object>> selectSelectiveMap(Map<String, Object> map) {
        return getSqlSession().selectList("TBlacklistMapper.selectSelectiveMap", map);
    }
    
    @Override
    public int insertSelectiveMap(Map<String, Object> map) {
        return getSqlSession().insert("TBlacklistMapper.insertSelectiveMap", map);
    }
    
    @Override
    public int updateSelectiveMap(Map<String, Object> map){
        return getSqlSession().update("TBlacklistMapper.updateByPrimaryKeySelectiveMap", map);
    }
    
    @Override
    public Long selectForRiskCheck(List<String> l){   
        return getSqlSession().selectOne("TBlacklistMapper.selectForRiskCheck", l);
    }
}
