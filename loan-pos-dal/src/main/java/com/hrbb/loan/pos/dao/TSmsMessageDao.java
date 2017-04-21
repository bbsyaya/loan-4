package com.hrbb.loan.pos.dao;

import java.util.List;
import java.util.Map;

import com.hrbb.loan.pos.dao.entity.TSmsMessage;

public interface TSmsMessageDao {
    int deleteByPrimaryKey(Integer id);

    int insert(TSmsMessage record);

    int insertSelective(TSmsMessage record);

    TSmsMessage selectByPrimaryKey(Integer id);

    int updateByPrimaryKeySelective(TSmsMessage record);

    int updateByPrimaryKey(TSmsMessage record);
    
    public List<Map<String, Object>> getSelectiveMap(Map<String, Object> reqMap);
    
    public int insertSelectiveMap(Map<String, Object> reqMap);
    
    public void insertSmsMsgBatch(List<TSmsMessage> list);
    
    /**
     * 批量短信插入
     * @param messages 批量短信
     * @return
     */
    int batchInsert(List<TSmsMessage> messages);
}