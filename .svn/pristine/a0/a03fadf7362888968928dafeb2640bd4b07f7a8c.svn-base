package com.hrbb.loan.pos.service.impl;

import java.util.List;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.hrbb.loan.pos.dao.TCfgCnapsInfoDao;
import com.hrbb.loan.pos.dao.entity.TCfgCnapsInfo;
import com.hrbb.loan.pos.service.BankInfoService;

@Service("bankInfoService")
public class BankInfoServiceImpl implements BankInfoService {
    
    @Autowired
    private TCfgCnapsInfoDao cfgCnapsInfoDao;
    
    @Override
    public List<TCfgCnapsInfo> getBankInfoBySelective(Map<String, Object> reqMap) {
        return cfgCnapsInfoDao.getBankInfoBySelective(reqMap);
    }

}
