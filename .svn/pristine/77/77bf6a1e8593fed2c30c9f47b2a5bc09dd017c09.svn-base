package com.hrbb.loan.pos.dao;

import java.util.List;
import java.util.Map;

import com.hrbb.loan.pos.dao.entity.TBizOperationRecord;

public interface TBizOperationRecordDao {
    int deleteByPrimaryKey(Integer id);

    int insert(TBizOperationRecord record);

    int insertSelective(TBizOperationRecord record);

    TBizOperationRecord selectByPrimaryKey(Integer id);

    int updateByPrimaryKeySelective(TBizOperationRecord record);

    int updateByPrimaryKey(TBizOperationRecord record);
    
    public int insertSelectiveMapBatch(List<Map<String, Object>> list);
}