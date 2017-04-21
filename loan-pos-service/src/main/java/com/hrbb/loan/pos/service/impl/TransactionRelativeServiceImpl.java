package com.hrbb.loan.pos.service.impl;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.hrbb.loan.pos.dao.TTransactionRelativeDao;
import com.hrbb.loan.pos.dao.entity.TTransactionRelative;
import com.hrbb.loan.pos.service.TransactionRelativeService;

@Service("transactionRelativeService")
public class TransactionRelativeServiceImpl implements TransactionRelativeService {

    @Autowired
    private TTransactionRelativeDao tTransactionRelativeDao;
    
    @Override
    public int saveTTransactionRelative(TTransactionRelative tTransactionRelative) {
        return tTransactionRelativeDao.insert(tTransactionRelative);
    }

    @Override
    public TTransactionRelative queryTTransactionRelativeByOutBizNo(String outBizNo) {
        return tTransactionRelativeDao.selectByOutBizNo(outBizNo);
    }

    @Override
    public TTransactionRelative queryTTransactionRelativeByBusinessId(String businessId) {
        return tTransactionRelativeDao.selectByBusinessId(businessId);
    }

}
