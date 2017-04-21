/**
 * 
 */
package com.hrbb.loan.pos.entity.event.impl;

import java.math.BigDecimal;
import java.util.Date;
import java.util.Map;

import com.google.common.base.Objects;
import com.hrbb.loan.pos.biz.backstage.inter.LoanPosContractManagementBiz;
import com.hrbb.loan.pos.dao.TMessageDao;
import com.hrbb.loan.pos.dao.entity.TContractManagement;
import com.hrbb.loan.pos.dao.entity.TMessage;
import com.hrbb.loan.pos.dao.entity.TPaymentApply;
import com.hrbb.loan.pos.entity.SpringBeans;
import com.hrbb.loan.pos.entity.event.EventException;
import com.hrbb.loan.pos.entity.event.ListenerEventAction;
import com.hrbb.loan.pos.service.LoanPosCreditApplyService;
import com.hrbb.loan.pos.service.bean.IssueResultMessage;
import com.hrbb.loan.pos.util.DateUtil;

/**
 * <p>Title: IssueMessage.java </p>
 * <p>Description:  </p>
 * <p>Copyright: Copyright (C) 2015 Hrbb Ltd. Co.</p> 
 *     
 * @author linzhaolin@hrbb.com.cn
 * @version 
 * @date 2015年7月8日
 *
 * logs: 1. 
 */
public class IssueMessage implements ListenerEventAction {
//	
//	@Autowired
//	private LoanPosContractManagementBiz loanPosContractManagementBiz;
//	
//	@Autowired
//	private LoanPosCreditApplyService loanPosCreditApplyService;
//	
//	@Autowired
//	private TMessageDao tMessageDao;
	
	private TPaymentApply paymentApply;
	
	private Map<String,Object> approval;
	
	private String issueResult;
	
	public IssueMessage(TPaymentApply apply, Map<String,Object> appr,String issueResult){
		this.paymentApply = apply;
		this.approval = appr;
		this.issueResult = issueResult;
	}

	/* (non-Javadoc)
	 * @see com.hrbb.loan.pos.entity.event.impl.POSMessage#execute()
	 */
	@Override
	public void execute() throws EventException {
		
		/*获取Sprig Bean*/
		LoanPosContractManagementBiz loanPosContractManagementBiz = (LoanPosContractManagementBiz)SpringBeans.getBean("loanPosContractManagementBiz");
		
		LoanPosCreditApplyService loanPosCreditApplyService = (LoanPosCreditApplyService)SpringBeans.getBean("loanPosCreditApplyService");
		
		TMessageDao tMessageDao = (TMessageDao)SpringBeans.getBean("tMessageDao");
		
		/*生成消息*/
		 TContractManagement contract = loanPosContractManagementBiz.getContractInfoByContNo(Objects.firstNonNull(paymentApply.getContNo(), ""));
	        // 推送消息
	        IssueResultMessage issueMessage = new IssueResultMessage();
	        //9代表拒绝
	        issueMessage.setIssueResult(issueResult);
	        //用款申请号
	        issueMessage.setListId(Objects.firstNonNull(paymentApply.getPayApplyId(), ""));
	        //金额
	        issueMessage.setIssueAmt(Objects.firstNonNull(paymentApply.getPayApplyAmt(), "").toString());
	        //贷款利率
	        if(paymentApply.getPayApplyInterest() != null){
	            BigDecimal interRate = ((paymentApply.getPayApplyInterest()).divide(new BigDecimal("100"))).setScale(4,BigDecimal.ROUND_HALF_UP);
	            issueMessage.setInterRate(interRate.toString());
	        }else{
	            issueMessage.setInterRate(BigDecimal.ZERO.toString());
	        }
	        Date apprBeginDate = (Date)approval.get("apprBeginDate");
	        Date apprEndDate = (Date)approval.get("apprEndDate");
	        if(contract.getChannel().equals("UM")){
	        	 //起待日
	            if(apprBeginDate != null){
	                issueMessage.setValueDate(DateUtil.getDateToString3(apprBeginDate));
	            }else{
	                issueMessage.setValueDate("");
	            }
	            //到期日
	            if(apprEndDate != null){
	                issueMessage.setExpDate(DateUtil.getDateToString3(apprEndDate));
	            }
	            
	            //还款方式
	            issueMessage.setRetuKind(returnKindUM.get(paymentApply.getReturnType()));
	        }else {
	            //起待日
	            if(apprBeginDate != null){
	                issueMessage.setValueDate(DateUtil.getDateToString1(apprBeginDate));
	            }else{
	                issueMessage.setValueDate("");
	            }
	            //到期日
	            if(apprEndDate != null){
	                issueMessage.setExpDate(DateUtil.getDateToString1(apprEndDate));
	            }
	            
	            //还款方式
	            issueMessage.setRetuKind(paymentApply.getReturnType());
	        }
	        //计息方式
	        issueMessage.setIntCalcMeth("");
	        //查出渠道，再根据渠道返回还款方式
	        
//	        if(contract != null){
//	            issueMessage.setRetuKind(returnKindMap(contract.getChannel(), paymentApply.getReturnType()));
//	        }else{
//	            logger.error(paymentApply.getContNo()+"没有该协议");
//	        }
	        issueMessage.setBankAcNo(Objects.firstNonNull(paymentApply.getAccNo(), ""));
	        
	        issueMessage.setBankName(Objects.firstNonNull(contract.getAccountOpenBank(), ""));
	        issueMessage.setBankSubName(Objects.firstNonNull(contract.getAccountSubBranchBank(), ""));
	        issueMessage.setBankBranchName(contract.getAccountBranchBank());
	        if("1".equals(issueResult)){
	            issueMessage.setRefuseReason((String)approval.get("approvalContent"));
	        }else{
	            issueMessage.setRefuseReason("");
	        }
	        
	        TMessage message = new TMessage();
	        message.setChannel(contract.getChannel());
	        message.setInChannelKind(contract.getInChannelKind());
	        message.setLoanId(contract.getLoanId());
	        message.setCustId(contract.getCustId());
	        message.setListId(paymentApply.getPayApplyId());
	        message.setContNo(paymentApply.getContNo());
	        message.setCreateTime(new Date());
	        message.setMessageType("5");
	        message.setMessageInfo(issueMessage.toString());
	        
	        //申请信息
	        Map<String, Object> loanMap = loanPosCreditApplyService.getOneCreditApply(Objects.firstNonNull(contract.getLoanId(), ""));
	        if(loanMap != null){
	            message.setStdshNo((String)loanMap.get("stdshno"));
	            message.setStdMerNo((String)loanMap.get("stdmerno"));
	        }else{
	            message.setStdshNo("");
	            message.setStdMerNo("");
	        }
	        tMessageDao.insert(message);
	}

}
