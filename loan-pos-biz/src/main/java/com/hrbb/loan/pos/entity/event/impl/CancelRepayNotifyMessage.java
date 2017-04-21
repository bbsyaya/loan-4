package com.hrbb.loan.pos.entity.event.impl;

import java.util.Date;
import java.util.Map;

import com.google.common.base.Objects;
import com.hrbb.loan.pos.biz.backstage.inter.LoanPosContractManagementBiz;
import com.hrbb.loan.pos.dao.TMessageDao;
import com.hrbb.loan.pos.dao.entity.TContractManagement;
import com.hrbb.loan.pos.dao.entity.TMessage;
import com.hrbb.loan.pos.dao.entity.TPaybackApplyInfo;
import com.hrbb.loan.pos.dao.entity.TReceiptInfo;
import com.hrbb.loan.pos.entity.SpringBeans;
import com.hrbb.loan.pos.entity.event.EventException;
import com.hrbb.loan.pos.entity.event.ListenerEventAction;
import com.hrbb.loan.pos.entity.event.cab.MessageCab;
import com.hrbb.loan.pos.service.LoanPosCreditApplyService;
import com.hrbb.loan.pos.service.ReceiptInfoService;

/**
 * 还款作废消息通知
 * 
 * @author cjq
 * @version $Id: CancelRepayNotifyMessage.java, v 0.1 2015年9月11日 下午6:04:30 cjq Exp $
 */
public class CancelRepayNotifyMessage implements ListenerEventAction{
    
    private TPaybackApplyInfo paybackApplyInfo;
    
    public CancelRepayNotifyMessage(TPaybackApplyInfo paybackApplyInfo){
        this.paybackApplyInfo = paybackApplyInfo;
    }

    private TPaybackApplyInfo getPaybackApplyInfo() {
        return paybackApplyInfo;
    }

    @Override
    public void execute() throws EventException {
        
        /*获取Sprig Bean*/
        LoanPosCreditApplyService loanPosCreditApplyService = (LoanPosCreditApplyService)SpringBeans.getBean("loanPosCreditApplyService");
        LoanPosContractManagementBiz loanPosContractManagementBiz = (LoanPosContractManagementBiz)SpringBeans.getBean("loanPosContractManagementBiz");
        TContractManagement contract = loanPosContractManagementBiz.getContractByContNo(getPaybackApplyInfo().getContNo());
        ReceiptInfoService receiptInfoService = (ReceiptInfoService)SpringBeans.getBean("receiptInfoService");
        TReceiptInfo receipt = receiptInfoService.selectReceiptByPrimary(getPaybackApplyInfo().getReceiptId());
        /*组装报文*/
        String sPaybackMethod = contract.getPaybackMethod();
        if(contract!=null && contract.getChannel().equals("UM")){
            if(sPaybackMethod.equals("90")) sPaybackMethod = "01";
        }
        
        MessageCab message13 = MessageCab.newMessage(MessageCab.消息推送_还款申请失效通知);
        message13.addAttribute("repaylistid", paybackApplyInfo.getPaybackApplyId());//还款申请编号
        message13.addAttribute("expiredreason", "扣款失败");
        TMessage message = new TMessage();
        message.setChannel(contract.getChannel());
        message.setInChannelKind(contract.getInChannelKind());
        message.setLoanId(contract.getLoanId());
        message.setCustId(contract.getCustId());
        message.setListId(receipt.getPayApplyId());
        message.setContNo(getPaybackApplyInfo().getContNo());
        message.setCreateTime(new Date());
        message.setMessageType(message13.getType());
        message.setMessageInfo(message13.toMessageString());
        
        //申请信息
        Map<String, Object> loanMap = loanPosCreditApplyService.getOneCreditApply(Objects.firstNonNull(contract.getLoanId(), ""));
        if(loanMap != null){
            message.setStdshNo((String)loanMap.get("stdshno"));
            message.setStdMerNo((String)loanMap.get("stdmerno"));
        }else{
            message.setStdshNo("");
            message.setStdMerNo("");
        }
        
        TMessageDao tMessageDao = (TMessageDao)SpringBeans.getBean("tMessageDao");
        tMessageDao.insert(message);
    }

}
