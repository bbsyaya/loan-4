
package com.hrbb.loan.quartz;

import java.math.BigDecimal;
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
import com.hrbb.loan.constants.PaymentApplyConstants;
import com.hrbb.loan.pos.biz.backstage.inter.CautionConfigBiz;
import com.hrbb.loan.pos.biz.backstage.inter.IPaymentApplyBiz;
import com.hrbb.loan.pos.dao.TContractManagementDao;
import com.hrbb.loan.pos.dao.entity.TContractManagement;
import com.hrbb.loan.pos.util.DateUtil;

@Service("insertPaymentAutoTask")
public class InsertPaymentAutoTask {
	
	private static final List<String> channelList = Lists.newArrayList();
	
	private Logger logger = LoggerFactory.getLogger(this.getClass());
	
	@Autowired
	private TContractManagementDao contractDao;
	
	@Autowired
	private IPaymentApplyBiz paymentApplyBiz;
	
	@PostConstruct
	public void init(){
		channelList.add("RN");
	}
	
	@Autowired
	private CautionConfigBiz cautionConfigBiz;
	
	//目前只有融360需要自动生成用款申请
	public void execute(){
		
		
		//查询出所有需要自动生成用款申请的合同
		List<TContractManagement> list = contractDao.selectContractForPaymentAuto(channelList);
		
		for(TContractManagement contract : list){
			try{
				Map<String, Object> reqMap = Maps.newHashMap();
				reqMap.put("channelType", contract.getChannel());
				reqMap.put(PaymentApplyConstants.contNo, contract.getContNo());
				//用款额度
				BigDecimal payApplyAmt = contract.getContTotalAmt();
				reqMap.put(PaymentApplyConstants.payApplyAmt, payApplyAmt);
				//用款期限
				String payApplyTerm = contract.getContTerm();
				if(payApplyTerm.startsWith("0")){
					payApplyTerm = payApplyTerm.replaceFirst("0", "");
				}
				reqMap.put(PaymentApplyConstants.payApplyTerm, payApplyTerm);
				/*  期限单位
				String termunit = (String)props.get(PaymentApplyHServiceConstants.termunit);
				if(StringUtil.isEmpty(termunit)){
					resp.setRespCode(HServiceReturnCode.TERMUNIT_ERROR.getReturnCode());
					resp.setRespMessage(HServiceReturnCode.TERMUNIT_ERROR.getReturnMessage());
					resp.setRespTime(new Date());
					return getBlankResponse(resp);
				}*/
				//还款方式
				String returnType = contract.getPaybackMethod();

				reqMap.put(PaymentApplyConstants.returnType, returnType);
				/*   放款账号
				String accNo	= (String)props.get(PaymentApplyHServiceConstants.INDESUBSACNO);
				if(StringUtil.isEmpty(accNo)){
					resp.setRespCode(HServiceReturnCode.INDESUBSACNO_ERROR.getReturnCode());
					resp.setRespMessage(HServiceReturnCode.INDESUBSACNO_ERROR.getReturnMessage());
					resp.setRespTime(new Date());
					return getBlankResponse(resp);
				}*/
				String accNo = contract.getAcceptAccount();
				reqMap.put(PaymentApplyConstants.accNo, accNo);
				
				
				//期望用款日期
				String expectedDate = DateUtil.getDateToString3(contract.getBeginDate());
				
				try{
					Date expectDateStr = DateUtil.getStrToDate1(expectedDate);
					//到期日
					reqMap.put(PaymentApplyConstants.expectedEndDate, DateUtil.getDatePattern3(DateUtil.getRelativeDate(expectDateStr, 0, Integer.valueOf(payApplyTerm), -1)));
					reqMap.put(PaymentApplyConstants.expectedDate, expectDateStr);
				}catch(Exception e){
					logger.error("日期转换异常[]", e.getMessage());
				}

					reqMap.put(PaymentApplyConstants.applyDate, contract.getBeginDate());

				/*  商户id
				String stdmerno = (String)props.get(PaymentApplyHServiceConstants.stdmerno);
				if(StringUtil.isEmpty(stdmerno)){
					resp.setRespCode(HServiceReturnCode.STDMERNO_PAY_ERROR.getReturnCode());
					resp.setRespMessage(HServiceReturnCode.STDMERNO_PAY_ERROR.getReturnMessage());
					resp.setRespTime(new Date());
					return getBlankResponse(resp);
				}
				reqMap.put(CreditApplyHServiceConstants.merchantNo, stdmerno);
				*/
				//检查保证金配置信息
				if(!cautionConfigBiz.checkCfgFundingPool(contract.getChannel())){
					logger.error("未发现保证金配置信息");
					return;
				}
				
				
				reqMap.put("status", "00");
				Map<String, Object> respMap = paymentApplyBiz.insertPaymentApply(reqMap);
				logger.debug("自动添加用款申请返回结果为:" + respMap);
				//校验保证金
				respMap.put(PaymentApplyConstants.payApplyAmt, payApplyAmt);
				
				if(respMap.isEmpty()){
					logger.error("用款申请入库异常");
				}
				if (cautionConfigBiz.checkCautionMoney(respMap)){
					logger.info("保证金充足, 将用款申请修改为审批状态");
					Map<String, Object> updateMap1 = Maps.newHashMap();
					updateMap1.put("payApplyId", respMap.get("issueid"));
					updateMap1.put("status", "10");
					paymentApplyBiz.updatePaymentApply(updateMap1);
					logger.info("更新用款申请状态为审批状态结束。。。");
					
				}else{
					logger.error("保证金余额不足");
					
				}
			}catch(Exception e){
				logger.error(contract.getContNo() + "自动生成用款申请异常", e);
			}
		}
		
		
	}
}
