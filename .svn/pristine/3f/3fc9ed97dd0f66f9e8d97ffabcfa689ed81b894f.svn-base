package com.hrbb.loan.pos.service.impl;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.hrbb.loan.pos.dao.TPaymentApplyBackpoolDao;
import com.hrbb.loan.pos.dao.entity.TPaymentApplyBackpool;
import com.hrbb.loan.pos.service.PaymentApplyBackpoolService;

/**
 * 
 * @author cjq
 * @version $Id: PaymentApplyBackpoolServiceImpl.java, v 0.1 2015年8月26日 下午5:05:03 cjq Exp $
 */
@Service("paymentApplyBackpoolService")
public class PaymentApplyBackpoolServiceImpl implements PaymentApplyBackpoolService {
    
    @Autowired
    TPaymentApplyBackpoolDao paymentApplyBackpoolDao;

    @Override
    public int savePaymentApplyBackpool(TPaymentApplyBackpool record){
        return paymentApplyBackpoolDao.insertSelective(record);
    }

}
