/**
 * 
 *	哈尔滨银行
 * Copyright (c) 2007-2015 HRBB,Inc.All Rights Reserved.
 */
package com.hrbb.loan.pos.biz.backstage.inter.impl;

import java.util.List;
import java.util.Map;

import org.apache.commons.codec.binary.Base64;
import org.apache.log4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Service;

import com.google.common.collect.Maps;
import com.hrbb.loan.pos.biz.backstage.inter.ZZAppTranserTaskBiz;
import com.hrbb.loan.pos.dao.entity.TMessage;
import com.hrbb.loan.pos.dao.entity.TMessageHist;
import com.hrbb.loan.pos.service.LoanPosMessageService;
import com.hrbb.loan.pos.util.constants.ReviewNoteConstants;
import com.hrbb.sh.framework.ZZAppTranserTaskService;

/**
 * 
 * @author maosheng
 * @version $Id: ZZAppTransforTaskBizImpl.java, v 0.1 2015-5-15 下午4:29:11 maosheng Exp $
 */
@Service("zzAppTransforTaskBiz")
public class ZZAppTranserTaskBizImpl implements ZZAppTranserTaskBiz{
    
    private Logger logger = Logger.getLogger(ZZAppTranserTaskBizImpl.class);
    
    @Autowired
    private LoanPosMessageService loanPosMessageService;
    
    @Autowired
    @Qualifier("zzAppTranser")
    private ZZAppTranserTaskService zzAppTranserTaskService;
    
    
    
    
    @Override
    public void transer() {
        Map<String,Object> qryMap = Maps.newHashMap();
        qryMap.put("channel", "ZZ");
        qryMap.put("inChannelKind", "01");
        List<TMessage> msgList = loanPosMessageService.selectByMap(qryMap);
        logger.info(">>>>.Total number is : " + msgList.size());
        for (TMessage message : msgList) {
            String messageInfo = message.getMessageInfo();
            try{
                logger.info(">>>>>>开始发送尽调消息：id="+message.getId());
                zzAppTranserTaskService.zzAppTranser(messageInfo);              
                TMessageHist tMessageHist = new TMessageHist();
                tMessageHist.setId(message.getId());
                tMessageHist.setMessageType(message.getMessageType());
                tMessageHist.setMessageInfo(message.getMessageInfo());
                tMessageHist.setMessageAddi(message.getMessageAddi());
                tMessageHist.setCustId(message.getCustId());
                tMessageHist.setLoanId(message.getLoanId());
                tMessageHist.setContNo(message.getContNo());
                tMessageHist.setListId(message.getListId());
                tMessageHist.setLoanAcNo(message.getLoanAcNo());
                tMessageHist.setCreateTime(message.getCreateTime());
                tMessageHist.setTimerDate(message.getTimerDate());
                tMessageHist.setStdshNo(message.getStdshNo());
                tMessageHist.setStdMerNo(message.getStdMerNo());
                tMessageHist.setChannel(message.getChannel());
                tMessageHist.setInChannelKind(message.getInChannelKind());
                loanPosMessageService.insertMessageHist(tMessageHist);
                loanPosMessageService.deleteById(message.getId());
                logger.info(">>>>>>发送成功，删除消息：id="+message.getId());
            }catch(Exception e){
                logger.error("发生异常:" + e.getMessage());
            }
           
        }
    }

}
