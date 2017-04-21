package com.hrbb.loan.pos.dao;

import java.util.List;
import java.util.Map;

import com.hrbb.loan.pos.dao.entity.TBlacklist;

/**
 * 
 * 
 * @author XLY
 * @version $Id: TBlacklistDao.java, v 0.1 2015-2-28 下午2:30:54 XLY Exp $
 */
public interface TBlacklistDao {
    /**
     * 
     * 
     * @param id
     * @return
     */
    int deleteByPrimaryKey(String id);

    /**
     * 
     * 
     * @param record
     * @return
     */
    int insert(TBlacklist record);

    /**
     * 
     * 
     * @param record
     * @return
     */
    int insertSelective(TBlacklist record);

    /**
     * 
     * 
     * @param id
     * @return
     */
    TBlacklist selectByPrimaryKey(String id);

    /**
     * 
     * 
     * @param record
     * @return
     */
    int updateByPrimaryKeySelective(TBlacklist record);
    /**
     * 
     * 
     * @param record
     * @return
     */
    int updateByPrimaryKey(TBlacklist record);
    
    /**
     * 
     * 
     * @param map
     * @return
     */
    List<TBlacklist> selectSelective(Map<String, Object> map);
 
    /**
     * 
     * 
     * @param map
     * @return
     */
    List<Map<String, Object>> selectSelectiveMap(Map<String, Object> map);

    
    Long selectSelectiveNum(Map<String, Object> map);
    
    Long countBlacklist(Map<String, Object> map);
    
    int insertSelectiveMap(Map<String, Object> map);
    
    int updateSelectiveMap(Map<String, Object> map);
    
    Long selectForRiskCheck(List<String> l);
}