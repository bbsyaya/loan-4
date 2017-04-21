package com.hrbb.loan.spi.TC2;

import java.util.Date;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.hrbb.loan.constants.PaymentApplyConstants;
import com.hrbb.loan.pos.biz.backstage.inter.IPaymentApplyBiz;
import com.hrbb.loan.pos.biz.backstage.inter.LoanPosContractManagementBiz;
import com.hrbb.loan.pos.dao.TMessageDao;
import com.hrbb.loan.pos.dao.TPaymentApplyDao;
import com.hrbb.loan.pos.dao.entity.TContractManagement;
import com.hrbb.loan.pos.dao.entity.TPaymentApply;
import com.hrbb.loan.pos.util.StringUtil;
import com.hrbb.loan.pos.util.ValidateUtil;
import com.hrbb.loan.spi.TC.TCService;
import com.hrbb.loan.spiconstants.HServiceReturnCode;
import com.hrbb.sh.framework.HRequest;
import com.hrbb.sh.framework.HResponse;
import com.hrbb.sh.framework.HServiceException;

/**
 * T59保证金补足通知
 * 
 * @author 
 * @version $Id: TC2AddCautionMoneyHService.java, v 0.1 2015-8-21 下午2:13:32  Exp $
 */
@Service("TC2AddCautionMoney")
public class TC2AddCautionMoneyHService extends TCService{
	
	@Autowired
	private LoanPosContractManagementBiz contBiz;
	
	
	@Autowired
	private IPaymentApplyBiz paymentApplyBiz;
	
	@Autowired
	private TMessageDao tMessageDao;

	@Autowired
	private TC2PaymentApplyServiceImpl paymentApplyservice;
	
	@Autowired
	private TPaymentApplyDao tPaymentApplyDao;
	
	@Override
	public HResponse serve(HRequest request) throws HServiceException {
		HResponse response = new HResponse();
		response.setRespTime(new Date());
		Map<String, Object> props = request.getProperties();
		
		String payApplyId = (String)props.get("issusid");
		
		String accountNo = (String)props.get("accountno");
		
		String schedAmt = (String)props.get("schedamt");
		
		String actulAmt = (String)props.get("actulamt");
		
		String depositTime = (String)props.get("deposittime");
		
		if(StringUtil.isEmpty(payApplyId)){
			logger.error("issusid为空或有误");
			response.setRespCode(HServiceReturnCode.PAYAPPLYID_ERROR.getReturnCode());
			response.setRespMessage(HServiceReturnCode.PAYAPPLYID_ERROR.getReturnMessage());
			return response;
		}
		
		//根据用款申请号查询合同记录
		//如果不存在合同记录，则返回错误信息
		TContractManagement contract = contBiz.getContractByPayApplyId(payApplyId);
		if(contract == null){
			response.setRespCode(HServiceReturnCode.CONTNO_ERROR.getReturnCode());
			response.setRespMessage(HServiceReturnCode.CONTNO_ERROR.getReturnMessage());
			return response;
		}
		
		if(StringUtil.isEmpty(accountNo)){
			logger.error("accountno为空或有误");
			response.setRespCode(HServiceReturnCode.BANKACCNO_ERROR.getReturnCode());
			response.setRespMessage(HServiceReturnCode.BANKACCNO_ERROR.getReturnCode());
			return response;
		}
		
		if(StringUtil.isEmpty(schedAmt) || !ValidateUtil.checkDouble(schedAmt)){
			logger.error("schedAmt为空或有误");
			response.setRespCode(HServiceReturnCode.SCHEDAMT_ERROR.getReturnCode());
			response.setRespMessage(HServiceReturnCode.SCHEDAMT_ERROR.getReturnMessage());
			return response;
		}
		
		if(StringUtil.isEmpty(actulAmt) || !ValidateUtil.checkDouble(actulAmt)){
			logger.error("actulAmt为空或有误");
			response.setRespCode(HServiceReturnCode.ACTULAMT_ERROR.getReturnCode());
			response.setRespMessage(HServiceReturnCode.ACTULAMT_ERROR.getReturnMessage());
			return response;
		}
		
		if(StringUtil.isEmpty(depositTime)){
			logger.error("depositTime为空或有误");
			response.setRespCode(HServiceReturnCode.DEPOSITTIME_ERROR.getReturnCode());
			response.setRespCode(HServiceReturnCode.DEPOSITTIME_ERROR.getReturnMessage());
			return response;
		}
		logger.info("用款申请号为:"+payApplyId+"对保证金账号："+accountNo+"增加保证金:" + actulAmt);
//		boolean flag = true;
		//调用用款申请的方法，这里不需要重写了
		TPaymentApply p = tPaymentApplyDao.selectByPrimaryKey(payApplyId);
		if(p == null){
			response.setRespCode(HServiceReturnCode.PAYAPPLYID_ERROR.getReturnCode());
			response.setRespMessage(HServiceReturnCode.PAYAPPLYID_ERROR.getReturnMessage());
			return response;
		}
		props.put(PaymentApplyConstants.payApplyAmt, p.getPayApplyAmt());
		props.put(PaymentApplyConstants.ISSUE_ID, payApplyId);
		boolean result = paymentApplyservice.checkCautionMoney(props);
		if(result){
			response.setRespCode(HServiceReturnCode.SUCCESS.getReturnCode());
			response.setRespMessage(HServiceReturnCode.SUCCESS.getReturnMessage());
		}else{
			response.setRespCode(HServiceReturnCode.OTHER_ERROR.getReturnCode());
			response.setRespMessage(HServiceReturnCode.OTHER_ERROR.getReturnMessage());
		}
		//调用核算查询保证金账户余额
//		if(flag){
//			//修改用款申请状态为待审核
//			Map<String, Object> reqMap = Maps.newHashMap();
//			reqMap.put("status", "10");
//			reqMap.put("payApplyId", payApplyId);
//			paymentApplyBiz.updatePaymentApply(reqMap);
//		}else{
//			//推送不足保证金消息
//			TMessage message = new TMessage();
//			BondSupplementMessage boMessage = new BondSupplementMessage();
//			message.setListId(payApplyId);
//			message.setContNo(contract.getContNo());
//			message.setLoanId(contract.getLoanId());
//			message.setCustId(contract.getCustId());
//			message.setChannel(getChannel());
//			message.setMessageType("15");
//			message.setInChannelKind(getInChannelKind());
//			boMessage.setAccno(accountNo);
//			String balance = "10000";
//			boMessage.setBalance(new BigDecimal(balance));
//			boMessage.setIssueid(payApplyId);
//			boMessage.setMargin(new BigDecimal("100000"));
//			message.setMessageInfo(boMessage.toString());
//			tMessageDao.insert(message);
//			response.setRespCode(HServiceReturnCode.SUCCESS.getReturnCode());
//			response.setRespMessage(HServiceReturnCode.SUCCESS.getReturnMessage());
//		}
		
		return response;
	}

	
}
