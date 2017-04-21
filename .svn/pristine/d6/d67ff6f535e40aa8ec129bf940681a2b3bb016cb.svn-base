package com.hrbb.loan.pos.biz.backstage.inter.impl;

import java.math.BigDecimal;
import java.util.Calendar;
import java.util.Date;
import java.util.List;
import java.util.Map;

import javax.annotation.PostConstruct;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.google.common.base.Objects;
import com.google.common.collect.Lists;
import com.google.common.collect.Maps;
import com.hrbb.loan.acct.facade2.MadeLoanProcessBizSimpleFacade;
import com.hrbb.loan.acct.facade2.MadeLoanProcessQueryBankAcctBalFacade;
import com.hrbb.loan.acct.facade2.bean.InnerAccTransferReq;
import com.hrbb.loan.acct.facade2.bean.QueryBankAcctBalReq;
import com.hrbb.loan.acct.facade2.bean.QueryBankAcctBalRes;
import com.hrbb.loan.pos.biz.backstage.inter.IGenericConfigBiz;
import com.hrbb.loan.pos.biz.backstage.inter.IRepaymentPlanBiz;
import com.hrbb.loan.pos.biz.backstage.inter.LoanPosContractManagementBiz;
import com.hrbb.loan.pos.biz.backstage.inter.LoanPosPaybackApplyBiz;
import com.hrbb.loan.pos.biz.backstage.inter.impl.withholder.IWithholderService;
import com.hrbb.loan.pos.biz.backstage.inter.impl.withholder.WithholderFactory;
import com.hrbb.loan.pos.dao.TCfgChannelAccountDao;
import com.hrbb.loan.pos.dao.TCfgFundingPoolDao;
import com.hrbb.loan.pos.dao.TMailNotificationDao;
import com.hrbb.loan.pos.dao.TPaybackApplyInfoDao;
import com.hrbb.loan.pos.dao.TReceiptInfoDao;
import com.hrbb.loan.pos.dao.TRepaymentPlanDao;
import com.hrbb.loan.pos.dao.TSmsMessageDao;
import com.hrbb.loan.pos.dao.TSmsTemplateDao;
import com.hrbb.loan.pos.dao.entity.TCfgChannelAccount;
import com.hrbb.loan.pos.dao.entity.TCfgFundingPool;
import com.hrbb.loan.pos.dao.entity.TContractManagement;
import com.hrbb.loan.pos.dao.entity.TMailNotification;
import com.hrbb.loan.pos.dao.entity.TPaybackApplyInfo;
import com.hrbb.loan.pos.dao.entity.TReceiptInfo;
import com.hrbb.loan.pos.dao.entity.TSmsMessage;
import com.hrbb.loan.pos.dao.entity.TSmsTemplate;
import com.hrbb.loan.pos.entity.SpringBeans;
import com.hrbb.loan.pos.factory.SysConfigFactory;
import com.hrbb.loan.pos.service.TemplateService;
import com.hrbb.loan.pos.service.constants.SmsTypeContants;
import com.hrbb.loan.pos.util.DateUtil;
import com.hrbb.loan.pos.util.IdUtil;
import com.hrbb.loan.pos.util.ListUtil;

@Service("repaymentPlanBiz")
public class RepaymentPlanBizImpl implements IRepaymentPlanBiz {
    
    private Logger logger = LoggerFactory.getLogger(this.getClass());

    @Autowired
    private TRepaymentPlanDao tRepaymentPlanDao;

    @Autowired
    private TSmsTemplateDao templateDao;

	@Autowired
	private TSmsMessageDao smsMessageDao;
	
	@Autowired
	private TReceiptInfoDao tReceiptInfoDao;
	
	@Autowired
	private TPaybackApplyInfoDao payBackDao;
	
	@Autowired
	private LoanPosPaybackApplyBiz loanPosPaybackApplyBiz;
	
	@Autowired
	private TCfgFundingPoolDao tCfgFundingPoolDao;
	
	@Autowired
	private LoanPosContractManagementBiz loanPosContractManagementBiz;
	
	@Autowired
	private IGenericConfigBiz iGenericConfigBiz;
	
	@Autowired
	private TCfgChannelAccountDao tCfgChannelAccountDao;
	
	@Autowired
	private MadeLoanProcessQueryBankAcctBalFacade queryBankAcctBal;
	
	@Autowired
	private TMailNotificationDao tMailNotificationDao;
	

	
	private Map<String, String> channelMap = Maps.newHashMap();
	
	@Autowired
	private MadeLoanProcessBizSimpleFacade madeLoanProcessBizSimpleFacade;
	
	@Autowired
	private TemplateService templateService;
	
	private String mailTos;
	
	@PostConstruct
	public void init(){
		List<TCfgChannelAccount> channelAcctChannelList = tCfgChannelAccountDao.getEffectAccount();
		for(TCfgChannelAccount acct : channelAcctChannelList){
			channelMap.put(acct.getChannel(), Objects.firstNonNull(acct.getAccountIssue(), "") + "," + Objects.firstNonNull(acct.getAcctIssueName(), ""));
		}
		channelMap.put("OTHER", "680101416030010004,不等贷还款专户4");
		
		mailTos = SysConfigFactory.getInstance().getInstance().getService("sendEmailService").getPropertyValue("sendWithhoderFailEmail");
	}


    @Override
    public void sendRepaymentMsg() {
        String withholderSlfChl = SysConfigFactory.getInstance().getService("fundpool").getPropertyValue("fundPoolWithholderself");
        String canNotSendMessage = SysConfigFactory.getInstance().getService("fundpool").getPropertyValue("cannotSendSms");
        logger.debug("send repayment message start...");
        try{
        // 先查询出所有七天后到期的还款计划
        Calendar cal = Calendar.getInstance();
        cal.add(Calendar.DATE, 7);
        Map<String, Object> reqMap = Maps.newHashMap();
        reqMap.put("schedDate1", DateUtil.getDateToString3(cal.getTime()));
        Calendar cal2 = Calendar.getInstance();
        cal2.add(Calendar.DATE, 3);
        reqMap.put("schedDate2", DateUtil.getDateToString3(cal2.getTime()));
        reqMap.put("payoffFlag", "00");
        List<Map<String, Object>> resList = tRepaymentPlanDao
                .getDueRepaymentSevenDaysLater(reqMap);

        

        // 将查询出的记录转化成短信插入到短信表中
        List<TSmsMessage> insertList = Lists.newArrayList();
        for (Map<String, Object> map : resList) {
            try{
            //先查询出合同记录
            String contNo = (String) map.get("contNo");
            TContractManagement contract = loanPosContractManagementBiz.getContractByContNo(contNo);
            if(contract == null){
                logger.info("没有该合同:" + contNo);
                continue;
            }
            if(("01".equals(contract.getLoanType()) || withholderSlfChl.contains("[" + contract.getChannel() + "]"))
                     && !canNotSendMessage.contains("["+ contract.getChannel() +"]")){
                //需要发短信
                //如果偿还方式是主动还款，要发主动还款短信
                if("01".equals(contract.getRepayMethod())){
                    // 再查询出短信模板
                    TSmsTemplate smsTemplate = templateDao.selectByPrimaryKey("POS0014");
                    if (smsTemplate == null) {
                        continue;
                    }
                    logger.info("该合同为主动还款");
                    String sendContent = smsTemplate.getSmsContent();
                    String repayAcctName = channelMap.get(contract.getChannel());
                    if(repayAcctName == null){
                        repayAcctName = channelMap.get("OTHER");
                    }
                    String[] repayAcctNameArray = repayAcctName.split("[,]");
                    sendContent = sendContent.replace("%endDate%", DateUtil.getDateTOString6((Date)map.get("schedDate"))).replace("%allAmt%", ((BigDecimal)map.get("schedTotalAmt")).toString())
                    .replace("%repayDate%", DateUtil.getDateTOString6((Date)map.get("schedDate"))).replace("%acct%", repayAcctNameArray [0]).replace("%acctName%", repayAcctNameArray[1]);
                    TSmsMessage message = new TSmsMessage();
                    message.setCreateTime(new Date());
                    message.setMobile((String) map.get("mobilePhone"));
                    message.setSendContent(sendContent);
                    message.setTempId(smsTemplate.getTempId());
                    message.setChannel(contract.getChannel());
                    message.setNotifyType(SmsTypeContants.还款通知);
                    insertList.add(message);
                }
                //如果偿还方式是代扣，要发代扣短信
                if("02".equals(contract.getRepayMethod())){
                    // 再查询出短信模板
                    TSmsTemplate smsTemplate = templateDao.selectByPrimaryKey("POS0015");
                    if (smsTemplate == null) {
                        continue;
                    }
                    logger.info("该合同为代扣");
                    String sendContent = smsTemplate.getSmsContent();
                    String payAccount = (String)map.get("payAccount");
                    //查询出开户行
                    Map<String, Object> resMap = iGenericConfigBiz.getIssuerInfo(payAccount);
                    String bankName = (String) resMap.get("issueBankName");
                    String lastTail = payAccount.substring(payAccount.length() - 4);
                    sendContent = sendContent.replace("%endDate%", DateUtil.getDateTOString6((Date)map.get("schedDate"))).
                            replace("%allAmt%", ((BigDecimal)map.get("schedTotalAmt")).toString()).replace("%repayDate%", DateUtil.getDateTOString6((Date)map.get("schedDate")))
                            .replace("%bankName%", bankName).replace("%acctTail%", lastTail);
                    TSmsMessage message = new TSmsMessage();
                    message.setCreateTime(new Date());
                    message.setMobile((String) map.get("mobilePhone"));
                    message.setSendContent(sendContent);
                    message.setTempId(smsTemplate.getTempId());
                    message.setChannel(contract.getChannel());
                    message.setNotifyType(SmsTypeContants.还款通知);
                    insertList.add(message);
                }
            }
            }catch(Exception e){
                logger.error("发生异常:", e);
            }
            /*String sendContent = smsTemplate.getSmsContent();
            TSmsMessage message = new TSmsMessage();
            message.setCreateTime(new Date());
            message.setMobile((String) map.get("mobilePhone"));
            message.setSendContent(sendContent);
            message.setTempId(smsTemplate.getTempId());
            insertList.add(message);*/
            //判断是否需要发短信
            
        }
        if(ListUtil.isNotEmpty(insertList)){
            smsMessageDao.insertSmsMsgBatch(insertList);
        }

        logger.debug("send repayment message stop...");
        }catch(Exception e){
            logger.error("send repayment message error:", e);
        }

    }
    
    //将到期的还款计划,插入用款申请
    @Override
    public void addRepaymentApply() {
        logger.info("开始自动生成还款申请");
        try{
        Map<String, Object> reqMap = Maps.newHashMap();
        reqMap.put("schedDate", DateUtil.getCurrentTimePattern3());
        reqMap.put("payoffFlag", "00");
        List<Map<String, Object>> list = tRepaymentPlanDao.getDueRepaymentSevenDaysLaterOther(reqMap);
        for(Map<String, Object> map : list){
            try{
                String receiptId = (String)map.get("receiptId");
                TReceiptInfo receipt = tReceiptInfoDao.selectByPrimaryKey(receiptId);
                if(receipt != null){
                	logger.info("借据为:" + receipt.getReceiptId());
                	if(new BigDecimal("0").compareTo((BigDecimal)map.get("schedInterest")) != 0){
                		String repayApplyId = loanPosPaybackApplyBiz.createPaybackApply(receipt, (String)map.get("period"), (Date)map.get("schedDate"), "1",
                				(BigDecimal)map.get("schedPrincipal"), (BigDecimal)map.get("schedInterest"), (BigDecimal)map.get("unpaidInterest"),(BigDecimal)map.get("schedTotalAmt"), "system", null,null);
                	}
                }
                
            }catch(Exception e){
                logger.error("自动添加还款申请异常", e);
            }
        }
        }catch(Exception e){
            logger.error("自动添加还款申请异常", e);
        }
        logger.info("自动生成还款申请结束");
        
    }


	@Override
	public void withhold() {
		
		//要发的邮件
		List<Map<String, Object>> mailList = Lists.newArrayList();
		
		
		try{
		//logger.info("现在时间:" + new Date() + "执行自动代扣方法" + method + "开始......");
		Map<String, Object> reqMap = Maps.newHashMap();
		//还款日期为当天且偿还方式为代扣的记录
		reqMap.put("expectPaybackDate", DateUtil.getCurrentTimePattern3());
		List<TPaybackApplyInfo> list = payBackDao.getPaybackApplyInfoForAuto(reqMap);
		for(TPaybackApplyInfo info : list){
			try{
				TContractManagement contract = loanPosContractManagementBiz.getContractByContNo(info.getContNo());
				if(contract != null){
					IWithholderService withholderService = (IWithholderService) SpringBeans.getBean(WithholderFactory.getWithholderMethod(info.getLoanPaybackWay(), contract.getLoanType(), contract.getChannel()));
					Map<String, Object> emailMap = withholderService.withholder(info);
					if(emailMap != null){
						mailList.add(emailMap);
					}
				}
			}catch(Exception e){
				logger.error("自动还款异常", e);
			}
		}
		//查询出所有渠道资金池模式配置信息
		/*logger.info("开始查询还款过渡户信息");
		reqMap = Maps.newHashMap();
		
		List<TCfgFundingPool> poolList = tCfgFundingPoolDao.selectSelective(reqMap);
		for(TCfgFundingPool cfgPool : poolList){
			QueryBankAcctBalReq bReq = new QueryBankAcctBalReq();
			bReq.setBankAcctNo(cfgPool.getRepayAccount());
			bReq.setBankAcctName(cfgPool.getRepayAccountName());
			bReq.setSeqNo(IdUtil.getId("Seq"));
	
			QueryBankAcctBalRes bRes = queryBankAcctBal.queryBankAcctBal(bReq);
			logger.info("还款专户余额为: " + bRes.getBankAcctBalance());
			if(new BigDecimal(Objects.firstNonNull(bRes.getBankAcctBalance(), "0")).compareTo(new BigDecimal("0")) < 0){
				logger.info("还款专户余额为负数要扣保证金");
				InnerAccTransferReq req = new InnerAccTransferReq();
				req.setAmt(bRes.getBankAcctBalance());
				req.setChannelId("POS");
				req.setTypeFlag("0");
				req.setReqSeqNo(IdUtil.getInnerTranserId());
				//credit是转入
				req.setCredit(cfgPool.getRepayAccount());
				//debit是转出
				req.setDebit(cfgPool.getBailAccount().split("[,]")[0]);
				madeLoanProcessBizSimpleFacade.doInnerAccTransfer(req);
			} 
		}

		logger.info("查询还款过渡户信息结束");*/
		//withholderService.withholder(list);
		//发邮件
		for(String mailTo : mailTos.split("[,]")){
			try{
				TMailNotification tMailNotification = new TMailNotification();
				tMailNotification.setMailSubject(DateUtil.getCurrentTimePattern3() + "还款代扣失败用户明细");
				tMailNotification.setMailTo(mailTo);
				tMailNotification.setTemplateId("notify/mail/hasNotWithholderSucc.ftl");
				tMailNotification.setCreateTime(new Date());
				tMailNotification.setNotifyStatus("0");
				Map<String, Object> vars = Maps.newHashMap();
				vars.put("applyList", mailList);
				String htmlText = templateService.getContent("notify/mail/hasNotWithholderSucc.ftl", vars);
				tMailNotification.setMailContent(htmlText);
				tMailNotificationDao.insertSelective(tMailNotification);
			}catch(Exception e){
				logger.error("发送邮件异常:", e);
			}
		}
			logger.info("执行自动代扣方法结束....");
		}catch (Exception e){
			logger.error("自动还款发生异常：", e);
		}
		

	}

}
