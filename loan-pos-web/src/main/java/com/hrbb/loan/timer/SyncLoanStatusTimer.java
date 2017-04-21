package com.hrbb.loan.timer;

import java.math.BigDecimal;
import java.util.List;
import java.util.Map;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.scheduling.annotation.Scheduled;
import org.springframework.stereotype.Service;

import com.google.common.collect.Maps;
import com.hrbb.loan.pos.biz.backstage.inter.IRepaymentAcctBiz;
import com.hrbb.loan.pos.dao.TRepaymentPlanDao;
import com.hrbb.loan.pos.dao.entity.TReceiptInfo;
import com.hrbb.loan.pos.service.ReceiptInfoService;

/**
 * @author yida
 * @date 2015年10月20日 下午12:03:39
 */
@Service
public class SyncLoanStatusTimer {
    
    private static final Logger LOGGER = LoggerFactory.getLogger(SyncLoanStatusTimer.class);

    @Autowired
    private ReceiptInfoService receiptInfoService;
    @Autowired
    private IRepaymentAcctBiz repaymentAcctBiz;
    @Autowired
    private TRepaymentPlanDao repaymentPlanDao;

    /**
     * 同步核算还款状态
     */
    @Scheduled(cron = "0 0 6 * * ?")
    public void syncRepay() {
        List<TReceiptInfo> receipts = receiptInfoService.getUnFinishedReceipt();
        for (TReceiptInfo receipt : receipts) {
            // 同步还款计划
            String receiptId = receipt.getReceiptId();
            repaymentAcctBiz.updateRepaymentPlan(receiptId);
            // 查询还款计划表中标识为拖欠的所有拖欠余额
            Map<String, BigDecimal> map = repaymentPlanDao.getOverRepaymentAmtAndInterestByReceiptId(receiptId);
            if (null != map) {
                try {
                    BigDecimal overAmtTotal = map.get("overdueBalance");
                    BigDecimal overInterestTotal = map.get("innerOwnedInterest");
                    // 更新借据表预期余额，表内欠息字段
                    Map<String, Object> reqMap = Maps.newHashMap();
                    BigDecimal loanTotalBalance = receipt.getLoanTotalBalance();
                    if(null ==loanTotalBalance || null == overAmtTotal){
                        LOGGER.warn("同步还款计划，更新借据表失败，receiptId="+receiptId+",loanTotalBalance ="+loanTotalBalance+",overAmtTotal = "+overAmtTotal);
                        continue;
                    }
                    BigDecimal normalBalance = loanTotalBalance.subtract(overAmtTotal);
                    reqMap.put("normalBalance", normalBalance);
                    reqMap.put("receiptId", receiptId);
                    reqMap.put("overdueBalance", overAmtTotal);
                    reqMap.put("innerOwnedInterest", overInterestTotal);
                    receiptInfoService.updateReceiptInfo(reqMap);
                    LOGGER.debug("receiptId="+receiptId+"的核算还款状态同步更新成功");
                } catch (RuntimeException e) {
                    LOGGER.error("同步核算还款状态失败\n",e);
                }
            }
        }
    }

}