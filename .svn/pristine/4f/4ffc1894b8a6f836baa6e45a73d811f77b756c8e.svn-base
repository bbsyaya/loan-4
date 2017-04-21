package com.hrbb.loan.sale.service.impl;

import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.hrbb.loan.pos.dao.TPaymentApplyTmpDao;
import com.hrbb.loan.pos.dao.entity.TPaymentApplyTmp;
import com.hrbb.loan.sale.service.LoanSalePaymentApplyService;

@Service("loanSalePaymentApplyService")
public class LoanSalePaymentApplyServiceImpl implements LoanSalePaymentApplyService {

    @Autowired
    TPaymentApplyTmpDao tPaymentApplyTmpDao;
    @Override
    public int insertLoanSalePaymentApply(TPaymentApplyTmp tPaymentApplyTmp) {
        return tPaymentApplyTmpDao.insert(tPaymentApplyTmp);
    }

    @Override
    public int deleteLoanSalePaymentApplyById(String payApplyId) {
        return 0;
    }

    @Override
    public int updateLoanSalePaymentApplyById(TPaymentApplyTmp tPaymentApplyTmp) {
        return 0;
    }

    @Override
    public TPaymentApplyTmp selectLoanSalePaymentApplyById(String payApplyId) {
        return null;
    }

    @Override
    public int insertLoanSalePaymentApplyMap(Map<String, Object> reqMap) {
        return 0;
    }

//    @Override
//    public int insertLoanSalePaymentApplyMap(Map<String, Object> reqMap) {
//        return tPaymentApplyTmpDao.insertSelectiveMap(reqMap);
//    }

}
