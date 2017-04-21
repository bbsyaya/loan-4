package com.hrbb.loan.pos.biz.backstage.inter.impl.withholder;

import java.util.Calendar;
import java.util.Date;
import java.util.List;
import java.util.Map;

import javax.annotation.PostConstruct;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.google.common.collect.Lists;
import com.google.common.collect.Maps;
import com.hrbb.loan.pos.biz.backstage.inter.LoanPosContractManagementBiz;
import com.hrbb.loan.pos.biz.backstage.inter.LoanPosPaybackBiz;
import com.hrbb.loan.pos.biz.bean.pay.IPayService;
import com.hrbb.loan.pos.biz.bean.pay.PayServiceFactory;
import com.hrbb.loan.pos.biz.bean.pay.constant.PayTypeEnum;
import com.hrbb.loan.pos.dao.TBankAccnoInfoDao;
import com.hrbb.loan.pos.dao.TBankPropertiesDao;
import com.hrbb.loan.pos.dao.TCreditApplyDao;
import com.hrbb.loan.pos.dao.TCustomerDao;
import com.hrbb.loan.pos.dao.TMailNotificationDao;
import com.hrbb.loan.pos.dao.TRepaymentPlanDao;
import com.hrbb.loan.pos.dao.TSmsMessageDao;
import com.hrbb.loan.pos.dao.TSmsTemplateDao;
import com.hrbb.loan.pos.dao.entity.TBankAccnoInfo;
import com.hrbb.loan.pos.dao.entity.TBankProperties;
import com.hrbb.loan.pos.dao.entity.TContractManagement;
import com.hrbb.loan.pos.dao.entity.TCreditApply;
import com.hrbb.loan.pos.dao.entity.TCustomer;
import com.hrbb.loan.pos.dao.entity.TMailNotification;
import com.hrbb.loan.pos.dao.entity.TPaybackApplyInfo;
import com.hrbb.loan.pos.dao.entity.TRepaymentPlan;
import com.hrbb.loan.pos.dao.entity.TSmsMessage;
import com.hrbb.loan.pos.dao.entity.TSmsTemplate;
import com.hrbb.loan.pos.factory.SysConfigFactory;
import com.hrbb.loan.pos.service.TemplateService;
import com.hrbb.loan.pos.util.DateUtil;



@Service("withholderSelf")
public class WithholderSelf implements IWithholderService{
	

	private Logger logger = LoggerFactory.getLogger(this.getClass());
	
	@Autowired
	private LoanPosContractManagementBiz loanPosContractManagementBiz;
	

	
	@Autowired
	private  TemplateService templateService;
	
	@Autowired
	private LoanPosPaybackBiz  loanPosPaybackBiz;
	
	@Autowired
	private TSmsMessageDao msgDao;
	
	@Autowired
	private TSmsTemplateDao templateDao;
	
	@Autowired
	private TBankPropertiesDao tBankPropertiesDao;
	
	@Autowired
	private TRepaymentPlanDao tRepaymentPlanDao;
	
	@Autowired
	private TCreditApplyDao tCreditApplyDao;
	
	@Autowired
	private TCustomerDao tCustomerDao;
	
	@Autowired
	private TMailNotificationDao tMailNotificationDao;
	
	@Autowired
	private TBankAccnoInfoDao tBankAccnoInfoDao;
	
	
	private String canNotSendMessage;
	
	private String mailTos = null;
	
	@PostConstruct
	private void init(){
		canNotSendMessage = SysConfigFactory.getInstance().getService("fundpool").getPropertyValue("cannotSendSms");
		mailTos = SysConfigFactory.getInstance().getInstance().getService("sendEmailService").getPropertyValue("sendWithhoderFailEmail");
	}
	



	@Override
	public Map<String, Object> withholder(TPaybackApplyInfo apply) {

		if(apply == null){
			logger.error("还款申请为空");
			return null;
		}
		try{
			Map<String, Object> resultMap = Maps.newHashMap();
			TContractManagement contract = loanPosContractManagementBiz.getContractByContNo(apply.getContNo());
			if(contract == null){
				logger.error("合同为空");
				return null;
			}
			//代扣
			logger.info("开始进行"+ apply.getPaybackApplyId() + "的自动代扣");
			IPayService service = PayServiceFactory.getThirdPayService(
					PayTypeEnum.REPAY.getPayTypeCode(), apply);
			try {
				resultMap = service.repayMap();
				logger.info("代扣返回结果为:" + resultMap);
			} catch (Exception e) {
				logger.error("代扣异常", e);
				logger.error("代扣发生异常, 不做操作");
				
			}
			if("SUCCESS".equals((String)resultMap.get("resultCode"))){
				logger.info(apply.getPaybackApplyId() + " 调代扣成功, 调核算还款记账");
				//调核算记账
				Map<String, Object> resMap = loanPosPaybackBiz.executeRepayment(apply.getPaybackApplyId());
				logger.info("调核算还款记账结果为:" + resMap);
				logger.info("调核算还款记账结束");
			}
			
			
			//如果失败
			if("FAIL".equals((String)resultMap.get("resultCode")) && ((String)resultMap.get("resultMsg")).contains("余额不足")){
				//如果是资金池模式要扣保证金
				if("02".equals(contract.getLoanType())){
						//资金池模式可以销账
						loanPosPaybackBiz.executeRepayment(apply.getPaybackApplyId());
				
					
				}
				//判断时间如果不超过下午3点就发邮件和短信
				Calendar cal = Calendar.getInstance();
				TCustomer customer = tCustomerDao.selectByPrimaryKey(contract.getCustId());
				TRepaymentPlan repaymentPlan = tRepaymentPlanDao.getPlanByReceiptIdAndPeriod(apply.getReceiptId(), null);
				TCreditApply creditApply = tCreditApplyDao.selectByPrimaryKey(contract.getLoanId());
				TBankAccnoInfo bankAccnoInfo = tBankAccnoInfoDao.selectByPrimaryKey(apply.getAccNo());
				TBankProperties bankProperties = tBankPropertiesDao.selectByBankId(bankAccnoInfo.getBankName());
				if(cal.get(Calendar.HOUR_OF_DAY) < 15 && !canNotSendMessage.contains(contract.getChannel())){
					logger.debug("开始发送催收短信。。。");
					
					sendWithhoderMsg(apply, contract, customer, repaymentPlan,
							bankProperties);
					logger.debug("发送催收短信结束。。。");
					
					logger.info("开始发送邮件...");
					Map<String,Object> vars = Maps.newHashMap();
					vars.put("recOrg", creditApply.getRecOrg());
					vars.put("custName", creditApply.getCustName());
					vars.put("mobilePhone", customer.getMobilePhone());
					vars.put("returnKind", creditApply.getReturnKind());
					vars.put("bankAccno", creditApply.getBankAccno());
					vars.put("bankName", bankProperties.getBankName());
					vars.put("period", repaymentPlan.getPeriod());
					vars.put("schedDate", DateUtil.getDateToString3(repaymentPlan.getScheddate()));
					vars.put("schedPrincipal", repaymentPlan.getSchedprincipal().toString());
					vars.put("schedInterest", repaymentPlan.getSchedinterest().toString());
					vars.put("schedTotalAmt", repaymentPlan.getSchedtotalamt().toString());
					return vars;
					/*for(String mailTo : mailTos.split("[,]")){
						try{
						TMailNotification tMailNotification = new TMailNotification();
						tMailNotification.setMailSubject(DateUtil.getCurrentTimePattern3() + "还款代扣失败用户明细");
						tMailNotification.setMailTo(mailTo);
						tMailNotification.setTemplateId("notify/mail/hasNotWithholderSucc.ftl");
						tMailNotification.setCreateTime(new Date());
						tMailNotification.setNotifyStatus("0");
						
						String htmlText = templateService.getContent("notify/mail/hasNotWithholderSucc.ftl", vars);
						tMailNotification.setMailContent(htmlText);
						tMailNotificationDao.insertSelective(tMailNotification);
						}catch(Exception e){
							logger.error("发送邮件异常:", e);
						}
					}*/
					//logger.info("发邮件结束");
				}
				
				
			}
			
		}catch(Exception e){
			logger.error("自动代扣发生异常:", e);
			return null;
		}
		return null;
		
		
	}




	private void sendWithhoderMsg(TPaybackApplyInfo apply,
			TContractManagement contract, TCustomer customer,
			TRepaymentPlan repaymentPlan, TBankProperties bankProperties) {
		TSmsTemplate smsTemplate = templateDao.selectByPrimaryKey("POS0015");
		if(smsTemplate != null && smsTemplate.getSmsContent() != null){
			smsTemplate.getSmsContent().replace("%endDate%", DateUtil.getDateTOString6(repaymentPlan.getScheddate())).
			replace("%allAmt%", repaymentPlan.getSchedtotalamt().toString()).replace("%repayDate%", DateUtil.getDateTOString6(repaymentPlan.getScheddate()))
			.replace("%bankName%", bankProperties.getBankName()).replace("%acctTail%", apply.getAccNo().substring(apply.getAccNo().length() - 4));
		}
		logger.info("开始发送短信和邮件");
		TSmsMessage message = new TSmsMessage();
		message.setChannel(contract.getChannel());
		message.setCreateTime(new Date());
		
		message.setMobile(customer.getMobilePhone());
		message.setTempId("POS0015");
		msgDao.insert(message);
	}
}
