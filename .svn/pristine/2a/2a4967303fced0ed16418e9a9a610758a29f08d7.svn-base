package com.hrbb.loan.pos.service.impl;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.hrbb.loan.pos.dao.TPoliceInfoDao;
import com.hrbb.loan.pos.dao.entity.TPoliceInfo;
import com.hrbb.loan.pos.service.PoliceInfoService;

/**
 * @author zhangwei5@hrbb.com.cn
 * @date 2015年9月24日下午3:04:56 
 */
@Service("policeInfoService")
public class PoliceInfoServiceImpl implements PoliceInfoService {
    
    @Autowired
    private TPoliceInfoDao policeInfoDao;

    @Override
    public TPoliceInfo queryPoliceInfoByLoadId(String loanId) {
        return policeInfoDao.selectByLoanId(loanId);
    }

}
