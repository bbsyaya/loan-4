package com.hrbb.loan.pos.biz.backstage.inter.impl;

import java.math.BigDecimal;
import java.util.Date;
import java.util.List;
import java.util.Map;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import com.google.common.collect.Maps;
import com.hrbb.loan.pos.biz.backstage.inter.LoanPosPaybackApplyBiz;
import com.hrbb.loan.pos.biz.backstage.inter.LoanPosPaybackBiz;
import com.hrbb.loan.pos.dao.entity.TPaybackApplyInfo;
import com.hrbb.loan.pos.dao.entity.TReceiptInfo;
import com.hrbb.loan.pos.service.LoanPosPaybacApplykService;
import com.hrbb.loan.pos.service.LoanPosPaybackService;
import com.hrbb.loan.pos.util.DateUtil;
import com.hrbb.loan.pos.util.IdUtil;

@Component("loanPosPaybackApplyBiz")
public class LoanPosPaybackApplyBizImpl implements LoanPosPaybackApplyBiz {

    private static final Logger        logger = LoggerFactory.getLogger(LoanPosPaybackApplyBizImpl.class);

    @Autowired
    private LoanPosPaybacApplykService loanPosPaybackApplyService;
    
    @Autowired
    private LoanPosPaybackService      loanPosPaybackService;

    @Autowired
    private LoanPosPaybackBiz          loanPosPaybackBiz;

    @Override
    public List<TPaybackApplyInfo> queryPaybackApplyInfo(Map<String, Object> reqMap) {
        List<TPaybackApplyInfo> l = loanPosPaybackApplyService.getPaybackApplyMap(reqMap);
        if (l != null && l.size() > 0) {
            for (TPaybackApplyInfo tPaybackApplyInfo : l) {
                if (tPaybackApplyInfo.getLoanPaybackWay() != null
                    && tPaybackApplyInfo.getLoanPaybackWay().equals("01")) {
                    tPaybackApplyInfo.setLoanPaybackWay("主动还款");
                } else if (tPaybackApplyInfo.getLoanPaybackWay() != null
                           && tPaybackApplyInfo.getLoanPaybackWay().equals("02")) {
                    tPaybackApplyInfo.setLoanPaybackWay("代扣");
                } else {
                    logger.info("偿还贷款方式有误");
                }
            }
        }
        return l;
    }

    @Override
    public int updatePaybackApply(Map<String, Object> updateMap) {
        return loanPosPaybackApplyService.updatePaybackApply(updateMap);
    }

    @Override
    public List<Map<String, Object>> queryPaybackDetailsByMaps(Map<String, Object> map) {
        return loanPosPaybackApplyService.queryPaybackDetailsByMaps(map);
    }

    @Override
    public List<Map<String, Object>> queryPaybackDetailsBySlApp(Map<String, Object> map) {
        return loanPosPaybackApplyService.queryPaybackDetailsBySlApp(map);
    }

    /**
     * 校验还款申请合法性
     * 
     * @param receiptId
     * @param expectPaybackDate
     * @param paybackPrincipal
     * @param paybackInterest
     * @param paybackTotalAmount
     * @return
     */
    @Override
    public Map<String, Object> validatePaybackApply(TReceiptInfo receipt, Date expectPaybackDate,
                                                    BigDecimal paybackPrincipal,
                                                    BigDecimal paybackInterest,
                                                    BigDecimal paybackPenalty,
                                                    BigDecimal paybackTotalAmount,
                                                    boolean limitCalcDate) {
        Map<String, Object> vResult = Maps.newHashMap();
        /*还款金额校验*/
        if (paybackTotalAmount.compareTo(paybackPrincipal.add(paybackInterest).add(paybackPenalty)) != 0) {
            vResult.put("returnCode", "901");
            vResult.put("returnMsg", "还款总额不等于还款本金/还款利息/还款罚息之和");
            return vResult;
        }
        if (paybackPrincipal.compareTo(receipt.getLoanTotalBalance()) > 0) {
            vResult.put("returnCode", "902");
            vResult.put("returnMsg", "还款本金超过贷款余额");
            return vResult;
        }

        /*剩下可还贷款余额校验: 刨除当天多次还款的情况*/
        Map<String, Object> reqMap = Maps.newHashMap();
        reqMap.put("receiptId", receipt.getReceiptId());
        reqMap.put("paybackApplyDate", new Date());
        reqMap.put("flagTodo", "Y");
        List<TPaybackApplyInfo> records = loanPosPaybackService.queryPaybackApplyList(reqMap);
        if (records != null && records.size() > 0) {
            BigDecimal onloadApply = new BigDecimal("0");
            for (TPaybackApplyInfo apply : records) {
                onloadApply = onloadApply.add(apply.getPaybackAmount());
            }
            /*累计还款金额超出贷款余额*/
            if ((onloadApply.add(paybackPrincipal)).compareTo(receipt.getLoanTotalBalance()) > 0) {
                vResult.put("returnCode", "904");
                vResult.put("returnMsg", "当日累计还款金额(" + onloadApply + "+" + paybackPrincipal
                                         + ")超出贷款余额.");
                return vResult;
            }
        }

        if (limitCalcDate) {
            /* 允许发起过往日期的还款申请*/
            if (expectPaybackDate != null) {
                String paybackDate = DateUtil.formatDate(expectPaybackDate,
                    DateUtil.HRRB_SHORT_DATETIME_FORMAT);
                if (paybackDate.compareTo(DateUtil.getToday()) < 0) {
                    vResult.put("returnCode", "903");
                    vResult.put("returnMsg", "期望还款日期不能小于当前日期");
                    return vResult;
                }
            }
        }

        vResult.put("returnCode", "000");
        vResult.put("returnMsg", "SUCCESS");
        return vResult;
    }

    /** 
     * @see com.hrbb.loan.pos.biz.backstage.inter.LoanPosPaybackApplyBiz#createPaybackApply(com.hrbb.loan.pos.dao.entity.TReceiptInfo, java.util.Date, java.lang.String, java.math.BigDecimal, java.math.BigDecimal, java.math.BigDecimal, java.lang.String, java.lang.String)
     */
    @Override
    public String createPaybackApply(TReceiptInfo receipt, Date paybackDate, String prcpType,
                                     BigDecimal principal, BigDecimal interest,
                                     BigDecimal totalAmt, String userName, String stdrpno) {

        if (receipt == null) {
            logger.error("借据不存在,还款申请创建失败");
            return null;
        }
        /*生成还款申请编号*/
        String paybackApplyId = IdUtil.getRepaymentApplyId();

        /*还款申请*/
        TPaybackApplyInfo paybackApplyInfo = new TPaybackApplyInfo();

        paybackApplyInfo.setPaybackApplyId(paybackApplyId); //还款申请编号
        paybackApplyInfo.setReceiptId(receipt.getReceiptId()); //借据编号
        paybackApplyInfo.setLoanBalance(receipt.getLoanTotalBalance()); //贷款余额
        paybackApplyInfo.setPaybackWay(receipt.getPaybackWay()); //还款方式
        paybackApplyInfo.setLoanPaybackWay(receipt.getLoanPaybackWay()); //贷款偿还方式
        paybackApplyInfo.setExpectPaybackDate(paybackDate); //期望还款日期
        paybackApplyInfo.setReturnPrincipalType(prcpType); //归还本金类型
        paybackApplyInfo.setPaybackAmount(principal); //还款本金
        paybackApplyInfo.setPaybackInterest(interest); //还款利息
        paybackApplyInfo.setPaybackTotalAmount(totalAmt); //还款总金额
        paybackApplyInfo.setPaybackStatus("00"); //00待发送指令
        paybackApplyInfo.setOperatePerson(userName); //操作人
        paybackApplyInfo.setPaybackApplyDate(new Date()); //还款申请日期
        paybackApplyInfo.setAccNo(receipt.getPayAccount()); //还款账号
        paybackApplyInfo.setContNo(receipt.getContNo()); //合同编号
        paybackApplyInfo.setCustId(receipt.getCustId()); //渠道还款流水编号
        paybackApplyInfo.setStdrpno(stdrpno);

        try {
            loanPosPaybackBiz.savePaybackApply(paybackApplyInfo);
        } catch (Exception e) {
            logger.error("还款申请创建失败", e);
            return null;
        }
        return paybackApplyId;
    }

    /** 
     * @see com.hrbb.loan.pos.biz.backstage.inter.LoanPosPaybackApplyBiz#createPaybackApply(com.hrbb.loan.pos.dao.entity.TReceiptInfo, java.util.Date, java.lang.String, java.math.BigDecimal, java.math.BigDecimal, java.math.BigDecimal, java.lang.String, java.lang.String)
     */
    @Override
    public String createPaybackApply(TReceiptInfo receipt, Date paybackDate, String prcpType,
                                     BigDecimal principal, BigDecimal interest,
                                     BigDecimal totalAmt, String userName, String stdrpno,
                                     String repayMethod) {

        if (receipt == null) {
            logger.error("借据不存在,还款申请创建失败");
            return null;
        }
        /*生成还款申请编号*/
        String paybackApplyId = IdUtil.getRepaymentApplyId();

        /*还款申请*/
        TPaybackApplyInfo paybackApplyInfo = new TPaybackApplyInfo();

        paybackApplyInfo.setPaybackApplyId(paybackApplyId); //还款申请编号
        paybackApplyInfo.setReceiptId(receipt.getReceiptId()); //借据编号
        paybackApplyInfo.setLoanBalance(receipt.getLoanTotalBalance()); //贷款余额
        paybackApplyInfo.setPaybackWay(receipt.getPaybackWay()); //还款方式
        if (repayMethod != null) {
            paybackApplyInfo.setLoanPaybackWay(repayMethod);
        } else {
            paybackApplyInfo.setLoanPaybackWay(receipt.getLoanPaybackWay()); //贷款偿还方式
        }
        paybackApplyInfo.setExpectPaybackDate(paybackDate); //期望还款日期
        paybackApplyInfo.setReturnPrincipalType(prcpType); //归还本金类型
        paybackApplyInfo.setPaybackAmount(principal); //还款本金
        paybackApplyInfo.setPaybackInterest(interest); //还款利息
        paybackApplyInfo.setPaybackTotalAmount(totalAmt); //还款总金额
        paybackApplyInfo.setPaybackStatus("00"); //00待发送指令
        paybackApplyInfo.setOperatePerson(userName); //操作人
        paybackApplyInfo.setPaybackApplyDate(new Date()); //还款申请日期
        paybackApplyInfo.setAccNo(receipt.getPayAccount()); //还款账号
        paybackApplyInfo.setContNo(receipt.getContNo()); //合同编号
        paybackApplyInfo.setCustId(receipt.getCustId()); //渠道还款流水编号
        paybackApplyInfo.setStdrpno(stdrpno);

        try {
            loanPosPaybackBiz.savePaybackApply(paybackApplyInfo);
        } catch (Exception e) {
            logger.error("还款申请创建失败", e);
            return null;
        }
        return paybackApplyId;
    }

    @Override
    public long countNumber(Map<String, Object> reqMap) {
        return loanPosPaybackApplyService.countNumber(reqMap);
    }

    @Override
    public Map<String, Object> validatePaybackApply(TReceiptInfo receipt, Date expectPaybackDate,
                                                    BigDecimal paybackPrincipal,
                                                    BigDecimal paybackInterest,
                                                    BigDecimal paybackTotalAmount) {
        return validatePaybackApply(receipt, expectPaybackDate, paybackPrincipal, paybackInterest,
            BigDecimal.ZERO, paybackTotalAmount, true);
    }

    @Override
    public TPaybackApplyInfo queryPaybackApplyInfoById(String paybackApplyId) {
        return loanPosPaybackApplyService.selectByPrimaryKey(paybackApplyId);
    }

    @Override
    public List<String> queryPaybackApplyIdList02() {
        return loanPosPaybackApplyService.queryPaybackApplyIdList02();
    }

    @Override
    public int updatePaybackApplyInfo(String paybackApplyId) {
        return loanPosPaybackApplyService.updatePaybackApplyInfo(paybackApplyId);
    }

    @Override
    public List<TPaybackApplyInfo> queryPaybackApplyInfo01() {
        return loanPosPaybackApplyService.queryPaybackApplyInfo01();
    }

    @Override
    public String createPaybackApply(TReceiptInfo receipt,String term, Date paybackDate, String prcpType,
                                     BigDecimal principal, BigDecimal interest,BigDecimal penalty,
                                     BigDecimal totalAmt, String userName, String stdrpno, String repayMethod) {

        if (receipt == null) {
            logger.error("借据不存在,还款申请创建失败");
            return null;
        }
        /*生成还款申请编号*/
        String paybackApplyId = IdUtil.getRepaymentApplyId();

        /*还款申请*/
        TPaybackApplyInfo paybackApplyInfo = new TPaybackApplyInfo();

        paybackApplyInfo.setPaybackApplyId(paybackApplyId); //还款申请编号
        paybackApplyInfo.setReceiptId(receipt.getReceiptId()); //借据编号
        paybackApplyInfo.setTerm(term); //期次
        paybackApplyInfo.setLoanBalance(receipt.getLoanTotalBalance()); //贷款余额
        paybackApplyInfo.setPaybackWay(receipt.getPaybackWay());   
        if(repayMethod != null){
            paybackApplyInfo.setLoanPaybackWay(repayMethod); 
        }else{
        paybackApplyInfo.setLoanPaybackWay(receipt.getLoanPaybackWay()); //贷款偿还方式
        }//还款方式
        paybackApplyInfo.setExpectPaybackDate(paybackDate); //期望还款日期
        paybackApplyInfo.setReturnPrincipalType(prcpType); //归还本金类型
        paybackApplyInfo.setPaybackAmount(principal); //还款本金
        paybackApplyInfo.setPaybackInterest(interest); //还款利息
        paybackApplyInfo.setPaybackPenalty(penalty); //还款罚息
        paybackApplyInfo.setPaybackTotalAmount(totalAmt); //还款总金额
        paybackApplyInfo.setPaybackStatus("00"); //00待发送指令
        paybackApplyInfo.setOperatePerson(userName); //操作人
        paybackApplyInfo.setPaybackApplyDate(new Date()); //还款申请日期
        paybackApplyInfo.setAccNo(receipt.getPayAccount()); //还款账号
        paybackApplyInfo.setContNo(receipt.getContNo()); //合同编号
        paybackApplyInfo.setCustId(receipt.getCustId()); //渠道还款流水编号
        paybackApplyInfo.setStdrpno(stdrpno);

        try {
            loanPosPaybackBiz.savePaybackApply(paybackApplyInfo);
        } catch (Exception e) {
            logger.error("还款申请创建失败", e);
            return null;
        }
        return paybackApplyId;
    }

    @Override
    public TPaybackApplyInfo queryPaybackApply(String receiptId, String term) {
        Map<String, Object> reqMap = Maps.newHashMap();
        reqMap.put("receiptId", receiptId);
        reqMap.put("term", term);
        return loanPosPaybackApplyService.queryPaybackApplyInfo(reqMap);
    }

    /** 
     * @see com.hrbb.loan.pos.biz.backstage.inter.LoanPosPaybackApplyBiz#validatePaybackApply(com.hrbb.loan.pos.dao.entity.TReceiptInfo, java.util.Date, java.math.BigDecimal, java.math.BigDecimal, java.math.BigDecimal, java.math.BigDecimal)
     */
    @Override
    public Map<String, Object> validatePaybackApply(TReceiptInfo receipt, Date expectPaybackDate,
                                                    BigDecimal paybackPrincipal,
                                                    BigDecimal paybackInterest,
                                                    BigDecimal paybackPenalty,
                                                    BigDecimal paybackTotalAmount) {
        return validatePaybackApply(receipt, expectPaybackDate, paybackPrincipal, paybackInterest,
            paybackPenalty, paybackTotalAmount, true);
    }

}
