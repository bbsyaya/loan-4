/**
 * 
 */
package com.hrbb.loan.pos.entity.event.impl;

import java.util.Date;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import com.hrbb.loan.pos.dao.entity.TAsynchronousNotification;
import com.hrbb.loan.pos.dao.entity.TBankAccnoInfo;
import com.hrbb.loan.pos.dao.entity.TCreditApply;
import com.hrbb.loan.pos.dao.entity.TCustomer;
import com.hrbb.loan.pos.entity.SpringBeans;
import com.hrbb.loan.pos.entity.event.EventException;
import com.hrbb.loan.pos.entity.event.ListenerEventAction;
import com.hrbb.loan.pos.entity.event.cab.NotifyCab;
import com.hrbb.loan.pos.factory.ConfigService;
import com.hrbb.loan.pos.factory.SysConfigFactory;
import com.hrbb.loan.pos.service.AsynchronousNotificationService;
import com.hrbb.loan.pos.service.LoanPosCreditApplyService;
import com.hrbb.loan.pos.service.LoanPosCustomerService;

/**
 * <p>Title: NotifyApplyChange.java </p>
 * <p>Description:  </p>
 * <p>Copyright: Copyright (C) 2015 Hrbb Ltd. Co.</p> 
 *     
 * @author linzhaolin@hrbb.com.cn
 * @version 
 * @date Aug 30, 2015
 *
 * logs: 1. 
 */
public class NotifyApplyChange implements ListenerEventAction {
	
	private Logger logger = LoggerFactory.getLogger(this.getClass());
	
	private String loanId;
	
	public NotifyApplyChange(String loanId){
		this.loanId = loanId;
	}
	
	public String getLoanId() {
		return loanId;
	}

	/* (non-Javadoc)
	 * @see com.hrbb.loan.pos.entity.event.ListenerEventAction#execute()
	 */
	@Override
	public void execute() throws EventException {
		/*获取Sprig Bean*/
		LoanPosCreditApplyService loanPosCreditApplyService = (LoanPosCreditApplyService)SpringBeans.getBean("loanPosCreditApplyService");
		//获取更新后的申请信息
		TCreditApply apply = loanPosCreditApplyService.queryCreditApply(loanId);
		if(apply==null) {
			logger.error("所需同步的申请["+loanId+"]不存在。");
			return;
		}
		//获取更新后的客户信息
		LoanPosCustomerService loanPosCustomerService = (LoanPosCustomerService)SpringBeans.getBean("loanPosCustomerService");
		TCustomer cutomer = loanPosCustomerService.getCustumerInfoById(apply.getCustId());
		if(cutomer==null) {
			logger.error("所需同步申请["+loanId+"]的客户["+apply.getCustId()+"]不存在。");
			return;
		}
		//获取更新后的银行卡信息
		TBankAccnoInfo bankAccount = loanPosCustomerService.getBanAccnoById(apply.getBankAccno());
		if(bankAccount==null) {
			logger.error("所需同步申请["+loanId+"]的客户银行卡账户["+apply.getBankAccno()+"]不存在。");
			return;
		}
		
		/*ConfigService 获取渠道对应的同步接口编码*/
		ConfigService cfg = SysConfigFactory.getInstance().getService(apply.getChannel());
		if(cfg==null) {
			logger.error("渠道["+apply.getChannel()+"]缺少正确的申请同步更新参数配置.");
			return;
		}
		
		String transCode = cfg.getPropertyValue("transCode.syncApply");
		if(transCode==null || transCode.trim().length()==0) {
			logger.error("渠道["+apply.getChannel()+"]未配置申请同步的交易代码.");
			return;
		}
		
		NotifyCab notify = NotifyCab.newNotify(NotifyCab.异步通知_申请变更同步);
		//交易编号
		notify.addAttribute("TransType", transCode);
		//申请相关
		notify.addAttribute("poscustname", apply.getPosCustName());		//商户名称
		notify.addAttribute("custname", apply.getCustName());			//客户姓名
		notify.addAttribute("retukind", apply.getReturnKind());			//还款方式
		notify.addAttribute("repaymethod", apply.getRepayMethod());		//贷款偿还方式
		notify.addAttribute("bankaccno", apply.getBankAccno());			//银行账号/卡号
		notify.addAttribute("stdshno", apply.getStdshno());	
		notify.addAttribute("loanid", apply.getLoanId());	
		//客户相关
		notify.addAttribute("paperkind", cutomer.getPaperKind());
		notify.addAttribute("paperid", cutomer.getPaperId());
		notify.addAttribute("mobilephone", cutomer.getMobilePhone());
		notify.addAttribute("tel", cutomer.getTel());
		notify.addAttribute("familycustname", cutomer.getFamilyCustName());
		notify.addAttribute("matepaperkind", cutomer.getMatePaperKind());
		notify.addAttribute("matepaperid", cutomer.getMatePaperId());
		notify.addAttribute("matemobilephone", cutomer.getMateMobilephone());
		//银行卡相关
		notify.addAttribute("bankName", bankAccount.getBankName());
		notify.addAttribute("bankBrandName", bankAccount.getBankBranName());
		notify.addAttribute("bankSubName", bankAccount.getBankSubbName());
		
		/*保存消息*/
		TAsynchronousNotification record = new TAsynchronousNotification();
		record.setChannel(apply.getChannel());
		record.setSchedualTime(new Date());
		record.setNotifyType("SyncApply");
		record.setNotifyContent(notify.toJSONString());
		AsynchronousNotificationService asynchronousNotificationService = (AsynchronousNotificationService)SpringBeans.getBean("asynchronousNotificationService");
		asynchronousNotificationService.insertSelective(record);
	}

}
