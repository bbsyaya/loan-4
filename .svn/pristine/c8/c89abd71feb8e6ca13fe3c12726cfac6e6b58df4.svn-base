package com.hrbb.loan.jms.listener;

import java.util.Date;
import java.util.Map;

import javax.jms.Message;
import javax.jms.MessageListener;
import javax.jms.TextMessage;

import jodd.util.StringUtil;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.alibaba.fastjson.JSON;
import com.google.common.collect.Maps;
import com.hrbb.loan.pay.api.response.SingleCollectResponse;
import com.hrbb.loan.pay.constants.RespStatus;
import com.hrbb.loan.pos.biz.backstage.inter.LoanPosPaybackBiz;
import com.hrbb.loan.pos.biz.bean.pay.constant.PayTypeEnum;
import com.hrbb.loan.pos.dao.entity.TTransactionRelative;
import com.hrbb.loan.pos.service.LoanPosPaybacApplykService;
import com.hrbb.loan.pos.service.TransactionRelativeService;

/**
 * 第三方代扣  异步回调处理Listener
 * 
 * @author cjq
 * @version $Id: CollectOrderListener.java, v 0.1 2015年8月6日 下午9:12:23 cjq Exp $
 */
@Service("collectOrderListener")
public class CollectOrderListener implements MessageListener {

    private static final Logger        logger = LoggerFactory.getLogger(CollectOrderListener.class);

    @Autowired
    private LoanPosPaybackBiz          loanPosPaybackBiz;

    @Autowired
    private LoanPosPaybacApplykService loanPosPaybacApplykService;

    @Autowired
    private TransactionRelativeService transactionRelativeService;

    @Override
    public void onMessage(Message message) {
        TextMessage textMsg = (TextMessage) message;
        try {
            logger.info("CollectOrderListener received a text message: " + textMsg.getText());
            SingleCollectResponse genericResponse = JSON.parseObject(textMsg.getText(),
                SingleCollectResponse.class);
            // 解析订单号，即orderNo
            String orderNo = genericResponse.getOrderNo();
            if(!StringUtil.isEmpty(orderNo)){
                // 对应该笔交易记录
                TTransactionRelative tTransactionRelative = transactionRelativeService
                        .queryTTransactionRelativeByOutBizNo(orderNo);
                if (tTransactionRelative !=null && tTransactionRelative.getTransactionType().equals("repay")) {
                    String paybackApplyId = tTransactionRelative.getBusinessId();
                    Map<String, Object> resultVar = Maps.newHashMap();
                    if (RespStatus.SUCCESS.getValue().equals(genericResponse.getStatus())) {
                        logger.info("还款申请"+paybackApplyId+"代扣成功");
                        resultVar = loanPosPaybackBiz.executeRepayment(paybackApplyId);
                        if (resultVar != null && resultVar.size() > 0) {
                            //do nothing
                            String respCode = (String) resultVar.get("respCode");
                            if (respCode.equals("000")) {
                                logger.info("还款申请[" + paybackApplyId + "] 易极付代扣执行成功!");
                            } else {
                                logger.info("还款申请[" + paybackApplyId + "] 易极付代扣执行失败!");
                            }
                        } else {
                            logger.info("还款申请[" + paybackApplyId + "] 执行失败!");
                        }
                    } else if (RespStatus.PROCESSING.getValue().equals(genericResponse.getStatus())) {
                        logger.info("还款申请[" + paybackApplyId + "] 易极付代扣处理中!");
                    } else {
                        logger.info("易极付代扣失败");
                    }
                    //交易记录
                    TTransactionRelative tTransactionRelativeNew = new TTransactionRelative();
                    tTransactionRelativeNew.setBusinessId(paybackApplyId);
                    tTransactionRelativeNew.setRelativeId(orderNo);
                    tTransactionRelativeNew.setTransactionOpponent(tTransactionRelative.getTransactionOpponent());
                    tTransactionRelativeNew.setTransactionStatus(genericResponse.getStatus());
                    tTransactionRelativeNew.setTransactionType(PayTypeEnum.REPAY.getPayTypeCode());
                    tTransactionRelativeNew.setCreateTime(new Date());
                    transactionRelativeService.saveTTransactionRelative(tTransactionRelativeNew);
                }
            }
        } catch (Exception e) {
            logger.error("error", e);
        }
    }

}
