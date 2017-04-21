package com.hrbb.loan.spi.TC2;

import java.util.Date;
import java.util.List;
import java.util.Map;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.google.common.collect.Maps;
import com.hrbb.loan.hessian.inter.IBankCardCheckHessianService;
import com.hrbb.loan.pos.biz.backstage.inter.ILoanPosCustomerBackStageBiz;
import com.hrbb.loan.pos.dao.TContractManagementDao;
import com.hrbb.loan.pos.dao.entity.TContractManagement;
import com.hrbb.loan.pos.util.ListUtil;
import com.hrbb.loan.pos.util.StringUtil;
import com.hrbb.loan.spi.TC.TCService;
import com.hrbb.loan.spiconstants.HServiceReturnCode;
import com.hrbb.sh.framework.HRequest;
import com.hrbb.sh.framework.HResponse;
import com.hrbb.sh.framework.HServiceException;

/**
 * T66银行卡换卡
 * 
 * @author 
 * @version $Id: TC2ChangeBankAccountHServiceImpl.java, v 0.1 2015-8-21 下午2:15:51  Exp $
 */
@Service("tc2ChangeBankAccount")
public class TC2ChangeBankAccountHServiceImpl extends TCService{
	
	Logger logger = LoggerFactory.getLogger(TC2ChangeBankAccountHServiceImpl.class);
	
	@Autowired
	private IBankCardCheckHessianService bankService;
	
	@Autowired
	private ILoanPosCustomerBackStageBiz loanPosCustomerBackStageBiz;
	
	@Autowired
	private TContractManagementDao contDao;

	@Override
	public HResponse serve(HRequest request) throws HServiceException {
		HResponse response = new HResponse();
		Map<String, Object> props = request.getProperties();
		
		String contNo = (String)props.get("contno");
		
		String custId = (String)props.get("custid");
		
		String bankAccno = (String)props.get("bankaccno");
		
		String bankName = (String)props.get("bankName");
		
		String bankBrandName = (String)props.get("bankBrandName"); 
		
		String bankSubName = (String)props.get("bankSubName");

		String reservdNo = (String) props.get("reservedno");
		
		logger.info("contNo为" + contNo+ "custid为"+custId+"的用户换卡绑定, 换的卡号为:" + bankAccno);
		
		if(StringUtil.isEmpty(contNo)){
			logger.error("contNo为空");
			response.setRespCode(HServiceReturnCode.CONTNO_ERROR.getReturnCode());
			response.setRespMessage(HServiceReturnCode.CONTNO_ERROR.getReturnMessage());
			return response;
		}
		
		TContractManagement contract = contDao.getContractInfoByContNo(contNo);
		
		if(contract == null){
			logger.error("没有该笔合同");
			response.setRespCode(HServiceReturnCode.HASNO_CONT.getReturnCode());
			response.setRespMessage(HServiceReturnCode.HASNO_CONT.getReturnMessage());
			return response;
		}
		
		if(StringUtil.isEmpty(custId)){
			logger.error("custId为空或有误");
			response.setRespCode(HServiceReturnCode.CUSTID_ERROR.getReturnCode());
			response.setRespMessage(HServiceReturnCode.CUSTID_ERROR.getReturnMessage());
			return response;
		}
		Map<String, Object> reqMap = Maps.newHashMap();
		reqMap.put("custId", custId);
			logger.error(custId+"没有该用户");
				List<Map<String, Object>> list = loanPosCustomerBackStageBiz.queryCustomerInfo(reqMap);
				if(!ListUtil.isNotEmpty(list)){
					response.setRespCode(HServiceReturnCode.HAS_NO_CUST_ERROR.getReturnCode());
					response.setRespMessage(HServiceReturnCode.HAS_NO_CUST_ERROR.getReturnMessage());
					return response;
				}
		String custName = (String) list.get(0).get("custName");
		String paperId = (String) list.get(0).get("paperId");
		if(StringUtil.isEmpty(custName)){
			logger.error("custName为空或有误");
			response.setRespCode(HServiceReturnCode.CUSTNAME_ERROR.getReturnCode());
			response.setRespMessage(HServiceReturnCode.CUSTNAME_ERROR.getReturnMessage());
			return response;
		}
		
		if(StringUtil.isEmpty(bankAccno)){
			logger.error("bankAccno为空或有误");
			response.setRespCode(HServiceReturnCode.BANKACCNO_ERROR.getReturnCode());
			response.setRespMessage(HServiceReturnCode.BANKACCNO_ERROR.getReturnMessage());
			return response;
		}
		
		if(StringUtil.isEmpty(bankName)){
			logger.error("bankName为空或有误");
			response.setRespCode(HServiceReturnCode.BANKNAME_ERROR.getReturnCode());
			response.setRespMessage(HServiceReturnCode.BANKNAME_ERROR.getReturnMessage());
			return response;
		}
		
		if(StringUtil.isEmpty(bankBrandName)){
			logger.error("bankBrandName为空或有误");
			response.setRespCode(HServiceReturnCode.BANKBRANNAME_ERROR.getReturnCode());
			response.setRespMessage(HServiceReturnCode.BANKBRANNAME_ERROR.getReturnMessage());
			return response;
		}
		
		if(StringUtil.isEmpty(bankSubName)){
			logger.error("bankSubName为空或有误");
			response.setRespCode(HServiceReturnCode.BANKSUBNAME_ERROR.getReturnCode());
			response.setRespMessage(HServiceReturnCode.BANKSUBNAME_ERROR.getReturnMessage());
			return response;
		}
		
		if(!StringUtil.isEmpty(reservdNo)){
			logger.error("reservdNo为空或有误");
			response.setRespCode(HServiceReturnCode.RESERVDNO_ERROR.getReturnCode());
			response.setRespMessage(HServiceReturnCode.RESERVDNO_ERROR.getReturnMessage());
			return response;
		}
		
		Map<String, String> bankCardMap = Maps.newHashMap();
		bankCardMap.put("cardNo", bankAccno);
		bankCardMap.put("cardName", custName);
		bankCardMap.put("channel", getChannel());
		bankCardMap.put("custId", custId);
		bankCardMap.put("bankName", bankName);
		bankCardMap.put("bankBranName", bankBrandName);
		bankCardMap.put("bankSubbName", bankSubName);
		bankCardMap.put("certNo", paperId);
		Map<String, String> resMap = bankService.bankCardCheck(bankCardMap);
		if("00".equals(resMap.get("respCode"))){
			//验证成功
			contract.setAcceptAccount(bankAccno);
			contract.setAccountOpenBank(bankName);
			contract.setAccountBranchBank(bankBrandName);
			contract.setAccountSubBranchBank(bankSubName);
			contDao.updateByPrimaryKeySelective(contract);
			response.setRespCode(HServiceReturnCode.SUCCESS.getReturnCode());
			response.setRespMessage(HServiceReturnCode.SUCCESS.getReturnMessage());
			response.setRespTime(new Date());
			logger.info("response is"+response);
			return response;
		}else{
			response.setRespCode(HServiceReturnCode.BANKCHECK_ERROR.getReturnCode());
			response.setRespMessage(HServiceReturnCode.BANKCHECK_ERROR.getReturnMessage());
			response.setRespTime(new Date());
			logger.info("response is"+response);
			return response;
		}

	}

}
