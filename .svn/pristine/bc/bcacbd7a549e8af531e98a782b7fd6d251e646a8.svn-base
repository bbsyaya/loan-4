package com.hrbb.loan.pos.service.impl;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.hrbb.loan.pos.dao.TCallbackRecordDao;
import com.hrbb.loan.pos.dao.entity.TCallbackRecord;
import com.hrbb.loan.pos.service.CallbackRecordService;

/**
 * @author zhangwei5@hrbb.com.cn
 * @date 2015年9月17日下午5:42:06 
 */
@Service("callbackRecordService")
public class CallbackRecordServiceImpl implements CallbackRecordService {
    
    @Autowired
    private TCallbackRecordDao callbackDao;

    /* (non-Javadoc)
     * @see com.hrbb.loan.pos.service.TCallbackRecordService#insertSelective(com.hrbb.loan.pos.dao.entity.TCallbackRecord)
     */
    public int insertSelective(TCallbackRecord record) {
        return callbackDao.insertSelective(record);
    }

    /* (non-Javadoc)
     * @see com.hrbb.loan.pos.service.CallbackRecordService#insert(com.hrbb.loan.pos.dao.entity.TCallbackRecord)
     */
    public int insert(TCallbackRecord record) {
        return callbackDao.insert(record);
    }

}
