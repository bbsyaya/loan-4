package com.hrbb.loan.timer;

import java.math.BigDecimal;
import java.util.Date;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import javax.annotation.Resource;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.scheduling.annotation.Scheduled;
import org.springframework.stereotype.Service;

import com.google.common.base.Objects;
import com.google.common.collect.Maps;
import com.hrbb.loan.acct.facade.MadeLoanProcessBizHession;
import com.hrbb.loan.acct.facade.bean.BatchPayoutResultReq;
import com.hrbb.loan.acct.facade.bean.BatchPayoutResultRes;
import com.hrbb.loan.acct.facade.common.constants.AcctRetConstants;
import com.hrbb.loan.jms.sender.SmsMessageSender;
import com.hrbb.loan.pos.biz.backstage.inter.IReceiptManageBiz;
import com.hrbb.loan.pos.biz.backstage.inter.ISmsSenderBiz;
import com.hrbb.loan.pos.biz.backstage.inter.LoanPosContractManagementBiz;
import com.hrbb.loan.pos.dao.TMessageDao;
import com.hrbb.loan.pos.dao.entity.TContractManagement;
import com.hrbb.loan.pos.dao.entity.TCustomer;
import com.hrbb.loan.pos.dao.entity.TMessage;
import com.hrbb.loan.pos.dao.entity.TReceiptInfo;
import com.hrbb.loan.pos.dao.entity.TSmsMessage;
import com.hrbb.loan.pos.dao.entity.TSmsTemplate;
import com.hrbb.loan.pos.service.IGenericConfigService;
import com.hrbb.loan.pos.service.LoanPosCreditApplyService;
import com.hrbb.loan.pos.service.LoanPosCustomerService;
import com.hrbb.loan.pos.service.bean.IssueResultMessage;
import com.hrbb.loan.pos.service.constants.SmsTypeContants;
import com.hrbb.loan.pos.util.DateUtil;
import com.hrbb.loan.pos.util.SmsTemplateFactory;
import com.hrbb.loan.pos.util.StringUtil;

@Service("ZjPaymentTimer")
public class POSPaymentTimer {
    
    private static final Logger LOG = LoggerFactory.getLogger(POSPaymentTimer.class);
    
    @Autowired
    private IReceiptManageBiz receiptManageBiz;
    
    /** 核算接口*/
    @Resource(name="madeLoanProcessBizHession")
    MadeLoanProcessBizHession madeLoanProcessBizHession;
    
    @Autowired
    private LoanPosContractManagementBiz loanPosContractManagementBiz;
    
    @Autowired
    private LoanPosCreditApplyService loanPosCreditApplyService;
    
    @Autowired
    private LoanPosCustomerService loanPosCustomerService;
    
    @Autowired
    private TMessageDao tMessageDao;
    
    @Autowired
    private ISmsSenderBiz smsSenderBiz;
    
    @Autowired
    private IGenericConfigService genericConfigService;
    
    @Autowired
    @Qualifier("smsMessageSender")
    private SmsMessageSender smsMessageSender;
    
    /**
     * 定时查询放款结果
     * 
     */
    @Scheduled(cron="0 0/10 * * * ?")
    public void run(){
        /*   
        "0";//发送前校验成功
        "1";//大小额转账发送成功，并不代表转账真正成功
        "2";//大小额发送失败
        "3";//大小额转账最终确认成功
        "4";//大小额转账最终确认失败
         */
        try {
			Map<String,String> resultMap = new HashMap<String,String>();
			BatchPayoutResultRes res = new BatchPayoutResultRes();
			BatchPayoutResultReq req = new BatchPayoutResultReq();
			List<TReceiptInfo> receiptList = receiptManageBiz.getReceiptList10();
			if(receiptList != null && receiptList.size()>0){
			    String[] outReqNoList = new String[receiptList.size()];
			    for (int i = 0; i < outReqNoList.length; i++) {
			        outReqNoList[i] = receiptList.get(i).getExeSeq();
			    }
			    req.setOutReqNoList(outReqNoList);
			    LOG.info("调用核算queryBatchPayout接口，返回结果=[{}]",req);
			    res = madeLoanProcessBizHession.queryBatchPayout(req);
			    LOG.info("调用核算queryBatchPayout接口，返回结果=[{}]",res);
			    if(AcctRetConstants.SUCCESS.getValue().equals(res.getRespCode())){
			        LOG.info("放款查询成功");
			        resultMap = res.getResultMap();
			        if(resultMap == null || resultMap.size()<=0){
			            LOG.error("没有查询到放款结果");
			        }else{
			        //遍历借据，更新放款状态
			        for (Map.Entry<String, String> en : resultMap.entrySet()) {
			            // 查询该笔借据
			        	String exeSeq = en.getKey();
			        	TReceiptInfo receipt = receiptManageBiz.selectByExeSeq(exeSeq);
		                if(receipt == null){
		                    LOG.error("放款序号["+exeSeq+"]对应借据不存在");
		                }else{
		                    LOG.info("放款序号="+exeSeq+" : [facilityId="+receipt.getReceiptId()+"]放款成功，借据起始日期为:" + receipt.getBeginDate());
		                	String resultValue = resultMap.get(exeSeq);
		                	LOG.info("放款结果内容为[{}]"+resultValue);
		                	String[] vals = resultValue.split("\\|");
		                	if(vals.length == 0){
		                	    LOG.error("结果为null");
		                	}else{
    		                	String payState = vals[0];
    		                	/*更新实际放款日期*/
    		                	Date issueDate = new Date();
    		                	if(vals.length == 2){
    		                	    if(StringUtil.isNotEmpty(vals[1]) && !"null".equals(vals[1])){
    		                	        issueDate = DateUtil.getDatePattern3(vals[1]);
    		                	    }
    		                	}
    		                	if("3".equals(payState)){		//转账成功
    			                    // 更新借据数据
    			                    Map<String,Object> reqMap = Maps.newHashMap();
    			                    reqMap.put("receiptId", receipt.getReceiptId());
    			                    reqMap.put("loanExecuteStatus", "20");
    			                    reqMap.put("lnExctStsUpdtTm", new Date());
    			                    reqMap.put("loanTotalBalance", receipt.getPayApplyAmt());
    			                    reqMap.put("normalBalance", receipt.getPayApplyAmt());
    			                    reqMap.put("overdueBalance", BigDecimal.ZERO);
    			                    reqMap.put("innerOwnedInterest", BigDecimal.ZERO);
    			                    reqMap.put("outterOwnedInterest", BigDecimal.ZERO);
    			                    reqMap.put("loanStatus", "01");			//贷款状态=01正常
    			                    
    			                    // 理论到期日（起息日+期限）
    			                    Date endDateTemp = DateUtil.getDatePattern3(DateUtil.getRelativeDate(issueDate, 0, Integer.parseInt(receipt.getPayApplyTerm()), -1));
    			                    //利随本清  实际到期日跳过节假日
    			                    Date endDate = null;
    			                	if(receipt.getPaybackWay()!=null && receipt.getPaybackWay().equals("90")){
    				                    endDate = genericConfigService.getWorkingDate(endDateTemp);
    			                	}else{
    			                		endDate = endDateTemp;
    			                	}
    			                    reqMap.put("actualIssueDate", issueDate);
    			                    reqMap.put("actualMaturity", endDate);
    			                    reqMap.put("issueTime", issueDate);		//支付时间
    			                    
    			                    receiptManageBiz.updateReceiptInfo(reqMap);
    			                    
    			                    //再查询出这笔记录
    			                    receipt = receiptManageBiz.selectReceiptByPrimary(receipt.getReceiptId());
    			                    //推送消息
    			                    senMessage(receipt, "2");
    			                    LOG.info("[facilityId="+receipt.getReceiptId()+"]放款成功消息入库成功");
    			                    
    			                    //短信入库
    			                    TContractManagement tCont = loanPosContractManagementBiz.getContractByContNo(receipt.getContNo());
                                    insertPaymentSmsMessage(receipt, tCont.getChannel());
                                    LOG.info("[facilityId="+receipt.getReceiptId()+"]放款成功短信入库成功");
    				            }else if("4".equals(payState)){
    				                LOG.info("放款序号[exeSeq="+exeSeq+"] 对应借据[facilityId="+receipt.getReceiptId()+"]转账失败.");
    				                Map<String,Object> reqMap = Maps.newHashMap();
    				                reqMap.put("receiptId", receipt.getReceiptId());
    				                reqMap.put("loanExecuteStatus", "29");
    				                reqMap.put("lnExctStsUpdtTm", new Date());
    				                receiptManageBiz.updateReceiptInfo(reqMap);
    				            }else{
    				                LOG.info(exeSeq+":"+resultMap.get(exeSeq));
    				            }
		                	}
		                }
			        }
			    }
			    }
			}
		} catch (Exception e) {
		    LOG.error("定时轮询放款结果异常" + e.getMessage());
		}
    }
    
    //推送消息
    private void senMessage(TReceiptInfo receipt, String issueResult){
    	  //查出渠道，再根据渠道返回还款方式
        TContractManagement contract = loanPosContractManagementBiz.getContractInfoByContNo(Objects.firstNonNull(receipt.getContNo(), ""));
    	// 推送消息
        IssueResultMessage issueMessage = new IssueResultMessage();
        //1代表成功
        issueMessage.setIssueResult(issueResult);
        //用款申请号
        issueMessage.setListId(Objects.firstNonNull(receipt.getPayApplyId(), ""));
        //金额
        issueMessage.setIssueAmt(Objects.firstNonNull(receipt.getPayApplyAmt(), "").toString());
        //贷款利率
        if(receipt.getLoanInterest() != null){
            BigDecimal interRate = ((receipt.getLoanInterest()).divide(new BigDecimal("100"))).setScale(4,BigDecimal.ROUND_HALF_UP);
            issueMessage.setInterRate(interRate.toString());
        }else{
            issueMessage.setInterRate(BigDecimal.ZERO.toString());
        }
        
        
        if(contract.getChannel().equals("UM")){
        	 //起待日
            if(receipt.getBeginDate() != null){
            	issueMessage.setValueDate(DateUtil.getDateToString3(receipt.getActualIssueDate()));
            }else{
            	issueMessage.setValueDate("");
            }
            //到期日
            if(receipt.getEndDate() != null){
            	issueMessage.setExpDate(DateUtil.getDateToString3(receipt.getActualMaturity()));
            }
       }else {
    	   //起待日
           if(receipt.getBeginDate() != null){
           	issueMessage.setValueDate(DateUtil.getDateToString1(receipt.getActualIssueDate()));
           }else{
           	issueMessage.setValueDate("");
           }
           //到期日
           if(receipt.getEndDate() != null){
           	issueMessage.setExpDate(DateUtil.getDateToString1(receipt.getActualMaturity()));
           }
       }
        //计息方式
        issueMessage.setIntCalcMeth("");
        
        if(contract != null){
        	issueMessage.setRetuKind(returnKindMap(contract.getChannel(), receipt.getPaybackWay()));
        }
        LOG.error(receipt.getContNo()+"没有该协议");
        issueMessage.setBankAcNo(Objects.firstNonNull(receipt.getPayAccount(), ""));
        
        issueMessage.setBankName(Objects.firstNonNull(receipt.getAccountOpenBank(), ""));
        issueMessage.setBankSubName(Objects.firstNonNull(receipt.getAccountSubBranchBank(), ""));
        issueMessage.setBankBranchName(receipt.getAccountBranchBank());
        issueMessage.setRefuseReason("");
        TMessage message = new TMessage();
        message.setChannel(contract.getChannel());
        message.setInChannelKind(contract.getInChannelKind());
        message.setLoanId(contract.getLoanId());
        message.setCustId(contract.getCustId());
        message.setListId(receipt.getPayApplyId());
        message.setContNo(receipt.getContNo());
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
    
    private String returnKindMap(String channel, String returnKind){
    	switch (channel) {
		case "UM":
			if("90".equals(returnKind)){
				return "01";
			}
		default:
			return returnKind;
		}
    }
    
    /**
     * 放款短信入库
     * 
     * @param contract
     */
    private void insertPaymentSmsMessage(TReceiptInfo receipt, String channel) throws Exception{
        // 发送短信
        String tempId = SmsTemplateFactory.getPaymentSms(channel);
        // 获取短信模板
        TSmsTemplate smsTemplate = smsSenderBiz.getSmsTemplate(tempId);
        // 编辑短信内容
        String sendContent = smsTemplate.getSmsContent();
        // 用款金额
        sendContent = sendContent.replace("%amount1%", receipt.getPayApplyAmt().toString());
        // 放款日期
        sendContent = sendContent.replace("%date%", DateUtil.getCurrentTimePattern3());
        // 银行卡号后4位
        String payAccount = receipt.getPayAccount();
        payAccount = payAccount.substring(payAccount.length()-4,payAccount.length());
        sendContent = sendContent.replace("%amount2%",payAccount);
        // 获取手机号
        TCustomer customer = loanPosCustomerService.getCustumerInfoById(receipt.getCustId());
        // 短信入库
        //smsSenderBiz.insertSmsMessage(tempId, customer.getMobilePhone(), sendContent);
        TSmsMessage smsMessage = new TSmsMessage();
        smsMessage.setTempId(tempId);
        smsMessage.setMobile(customer.getMobilePhone());
        smsMessage.setSendContent(sendContent);
        smsMessage.setNotifyType(SmsTypeContants.放款通知);
        smsMessage.setChannel(channel);
        smsMessage.setRealtime(false);
        smsMessageSender.sendMessage(smsMessage);
    }

}
