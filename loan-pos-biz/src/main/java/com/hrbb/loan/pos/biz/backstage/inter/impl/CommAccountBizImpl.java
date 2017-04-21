package com.hrbb.loan.pos.biz.backstage.inter.impl;

import java.math.BigDecimal;
import java.util.Date;
import java.util.Map;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import com.google.common.collect.Maps;
import com.hrbb.loan.acct.facade.MadeLoanProcessBizHession;
import com.hrbb.loan.acct.facade.bean.CalcRamtReq;
import com.hrbb.loan.acct.facade.bean.CalcRamtRes;
import com.hrbb.loan.acct.facade.bean.MadeLoanLoanLedgerBean;
import com.hrbb.loan.pos.biz.backstage.inter.ICommAccountBiz;
import com.hrbb.loan.pos.dao.entity.TReceiptInfo;
import com.hrbb.loan.pos.service.LoanPosPaybackService;
import com.hrbb.loan.pos.service.ReceiptInfoService;

/**
 * 通用核算处理业务类.
 * 
 * @author xiongshaogang
 * @version $Id: CommAccountBizImpl.java, v 0.1 2015年6月12日 上午9:13:22 xiongshaogang Exp $
 */
@Component("commAccountBiz")
public class CommAccountBizImpl implements ICommAccountBiz {

    private Logger                    logger = LoggerFactory.getLogger(CommAccountBizImpl.class);

    @Autowired
    private ReceiptInfoService        receiptInfoService;

    @Autowired
    private MadeLoanProcessBizHession madeLoanProcessBizHession;

    @Autowired
    private LoanPosPaybackService     loanPosPaybackService;

    @Override
    public Map<String, Object> repayCalculate(Map<String, String> calculateMap) {

        logger.debug("in ZZAPPRepaymentTryCalculateServiceImpl...");

        // 0. 声明应答对象
        Map<String, Object> retMap = Maps.newHashMap();

        // 1. 查询借据
        TReceiptInfo tReceiptInfo = receiptInfoService.selectReceiptOne(calculateMap.get("payapplyid"));
        if (tReceiptInfo == null) {
            //        if (tReceiptInfo == null || StringUtil.isEmpty(tReceiptInfo.getLoanAcNo())) {
            logger.error("该笔用款的借据不存在!");
            retMap.put("code", "001");
            retMap.put("msg", "该笔用款的借据不存在!");
            return retMap;
        }

        // 2. 试算处理
        try {
            CalcRamtRes res = new CalcRamtRes();
            CalcRamtReq req = new CalcRamtReq();
            String receiptId = loanPosPaybackService.getReceiptIdByPayApplyId(calculateMap.get("payapplyid"));
            TReceiptInfo R = loanPosPaybackService.getReceiptInfoByReceiptId(receiptId);
            if ("02".equals(calculateMap.get("aheakind"))) {

                logger.info("还本付息试算接口计算利息");
                Double sumAmount = new Double(calculateMap.get("sumamt"));
                logger.info("还款总金额为" + sumAmount);

                req.setAheakind("1");//还款类型
                req.setSsubsamt(sumAmount);//应放金额
                req.setWorkDate(new Date());
                req.setAheaamtkind("2");
                MadeLoanLoanLedgerBean bean = new MadeLoanLoanLedgerBean();
                bean.setInterestRate(R.getLoanInterest()); //贷款利率
                logger.info("贷款利率为" + R.getLoanInterest());
                bean.setBeginDate(R.getBeginDate());
                bean.setLastInteDate(R.getBeginDate());
                logger.info("开始计息日为" + R.getBeginDate());
                bean.setRepayMethod(R.getPaybackWay());//还款方式
                bean.setProdId("1001020306");
                bean.setPayMethod("90");
                bean.setaBal(R.getLoanTotalBalance());
                req.setBean(bean);
                res = madeLoanProcessBizHession.calcRamtWithBean(req);
                Map<String, Object> resMap = res.getRes();
                logger.info("核算接口返回的map为" + resMap);
                String capital = (String) resMap.get("rcapi");
                logger.info("计算出来的本金为" + capital);
                String interest = (String) resMap.get("rInte");
                logger.info("计算出来的利息为" + interest);
                Double loanTotalBalance = loanPosPaybackService
                    .getLoanTotalBalanceByReceiptId(calculateMap.get("payapplyid"));
                logger.info("贷款总余额为" + loanTotalBalance);
                if (sumAmount > loanTotalBalance) {
                    logger.error("还款总金额已大于剩余借据总余额");
                } else {
                    logger.info("归还本金利息总金额为" + sumAmount);
                }
                retMap.put("rcapi", capital);
                retMap.put("rinte", interest);
                retMap.put("sumamt", String.valueOf(sumAmount));
                retMap.put("unreturnedamt", String.valueOf(loanTotalBalance));
            } else if ("01".equals(calculateMap.get("aheakind"))) {
                Double loanTotalBalance = loanPosPaybackService
                    .getLoanTotalBalanceByReceiptId(calculateMap.get("payapplyid"));
                logger.info("剩余贷款总余额为" + loanTotalBalance);

                logger.info("提前结清试算接口计算利息");
                req.setAheakind("1");
                req.setSsubsamt(new Double("0"));//应放金额
                req.setWorkDate(new Date());
                req.setLoanAcNo(R.getLoanAcNo());
                logger.info("核心借据号为" + R.getLoanAcNo());
                req.setrCapi(R.getLoanTotalBalance().doubleValue());
                logger.info("借据余额为" + R.getLoanTotalBalance());
                req.setAheaamtkind("1");
                MadeLoanLoanLedgerBean bean = new MadeLoanLoanLedgerBean();
                bean.setInterestRate(R.getLoanInterest()); //贷款利率
                logger.info("贷款利率为" + R.getLoanInterest());
                bean.setLastInteDate(R.getBeginDate());
                logger.info("开始计息日为" + R.getBeginDate());
                bean.setBeginDate(R.getBeginDate());
                bean.setRepayMethod(R.getPaybackWay());//还款方式
                bean.setProdId("1001020306");
                bean.setPayMethod("90");
                bean.setaBal(R.getLoanTotalBalance());
                req.setBean(bean);
                res = madeLoanProcessBizHession.calcRamtWithBean(req);
                Map<String, Object> resMap = res.getRes();
                logger.info("核算接口返回的map为" + resMap);
                String capital = (String) resMap.get("rcapi");
                logger.info("计算出来的本金为" + capital);
                BigDecimal capital1 = new BigDecimal(capital);
                String interest = (String) resMap.get("rInte");
                logger.info("计算出来的利息为" + interest);
                BigDecimal interest1 = new BigDecimal(interest);
                double tamt = capital1.add(interest1).doubleValue();
                retMap.put("rcapi", capital);
                retMap.put("rinte", interest);
                retMap.put("sumamt", String.valueOf(tamt));
                retMap.put("unreturnedamt", String.valueOf(loanTotalBalance));
            } else {
                logger.error("暂不支持当前提前还款类型");
                retMap.put("code", "002");
                retMap.put("msg", "暂不支持当前提前还款类型");
                return retMap;
            }
        } catch (Exception e) {
            logger.error("还款试算异常", e);
            retMap.put("code", "003");
            retMap.put("msg", "还款试算异常");
            return retMap;
        }

        logger.error("还款试算成功");
        retMap.put("code", "000");
        retMap.put("msg", "还款试算成功");
        return retMap;
    }
}