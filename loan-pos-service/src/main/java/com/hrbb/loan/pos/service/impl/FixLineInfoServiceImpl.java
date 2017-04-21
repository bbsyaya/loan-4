package com.hrbb.loan.pos.service.impl;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import com.hrbb.loan.pos.dao.TFixLineInfoDao;
import com.hrbb.loan.pos.dao.entity.TFixLineInfo;
import com.hrbb.loan.pos.service.FixLineInfoService;

/**
 * @author zhangwei5@hrbb.com.cn
 * @date 2015年10月8日下午7:17:48 
 */
@Service
public class FixLineInfoServiceImpl implements FixLineInfoService {

    @Autowired
    private TFixLineInfoDao fixLineInfoDao;

    @Transactional
    public int save(TFixLineInfo record) {
        return fixLineInfoDao.insertSelective(record);
    }

    public TFixLineInfo findByTelNum(String telNum) {
        return fixLineInfoDao.selectByTelNum(telNum);
    }

    public void update(TFixLineInfo record) {
        fixLineInfoDao.updateByTelNumSelective(record);
    }

}
