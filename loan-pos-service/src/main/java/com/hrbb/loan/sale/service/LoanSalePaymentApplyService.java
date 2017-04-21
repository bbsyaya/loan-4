package com.hrbb.loan.sale.service;

import java.util.Map;

import com.hrbb.loan.pos.dao.entity.TPaymentApplyTmp;

/**
 * 用款申请临时表
 * @author litengfeng
 * @version $Id: LoanSalePaymentApplyTempService.java, v 0.1 2015年5月13日 下午7:02:00 litengfeng Exp $
 */
public interface LoanSalePaymentApplyService {
    public int insertLoanSalePaymentApply(TPaymentApplyTmp tPaymentApplyTmp);
    public int deleteLoanSalePaymentApplyById(String payApplyId);
    public int updateLoanSalePaymentApplyById(TPaymentApplyTmp tPaymentApplyTmp);
    public TPaymentApplyTmp selectLoanSalePaymentApplyById(String payApplyId);
    public int insertLoanSalePaymentApplyMap(Map<String, Object> reqMap);
}
