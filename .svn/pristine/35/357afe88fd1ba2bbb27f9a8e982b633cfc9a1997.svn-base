package com.hrbb.loan.pos.service.impl;

import java.util.List;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.hrbb.loan.pos.dao.TBizOperationRecordDao;
import com.hrbb.loan.pos.dao.entity.TBizOperationRecord;
import com.hrbb.loan.pos.service.BizOperationRecordService;

@Service("bizOperationRecordService")
public class BizOperationRecordServiceImpl implements BizOperationRecordService {

    @Autowired
    private TBizOperationRecordDao bizOperationRecordDao;
    
    @Override
    public int saveBizOperationRecord(TBizOperationRecord record) {
        return bizOperationRecordDao.insertSelective(record);
    }

    @Override
    public int insertSelectiveMapBatch(List<Map<String, Object>> records){
    	return bizOperationRecordDao.insertSelectiveMapBatch(records);
    }
}
