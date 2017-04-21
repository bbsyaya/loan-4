package com.hrbb.loan.pos.service;

import com.hrbb.loan.pos.dao.entity.TCallbackRecord;

/**
 * @author zhangwei5@hrbb.com.cn
 * @date 2015年9月17日下午5:40:10 
 */
public interface CallbackRecordService {
    int insertSelective(TCallbackRecord record);
    int insert(TCallbackRecord record);

}
