package com.hrbb.loan.spi.WX;

import java.util.Date;

import org.springframework.stereotype.Service;

import com.hrbb.loan.constants.CreditApplyConstants;
import com.hrbb.loan.pos.util.StringUtil;
import com.hrbb.loan.pos.util.ValidateUtil;
import com.hrbb.loan.spi.POSHService;
import com.hrbb.loan.spi.TC2.TC2ContractBackHserviceImpl;
import com.hrbb.loan.spiconstants.HServiceReturnCode;
import com.hrbb.sh.framework.HResponse;

@Service("wxContractBackHService")
public class WXContractBackHServiceImpl extends TC2ContractBackHserviceImpl{

	/**
	 * 贷款方式
	 * @return
	 */
	public String getLoanType(){
		return POSHService.贷款模式_资金池;
	}
	
	/**
	 * 产品编号
	 * @return
	 */
	public String getProdId(){
		return CreditApplyConstants.consumeLoanFlag;
	}
	
	/**
	 * 产品名称
	 * @return
	 */
	public String getProdName(){
		return CreditApplyConstants.consumeLoanName;
	}
	
	@Override
	public String getChannel() {
		return POSHService.进件渠道_萨摩耶;
	}
//
//	/**
//	 * 推荐机构
//	 * @return
//	 */
//	public String getPromOrg(){
//		return "58.com";
//	}
//	
//	/**
//	 * 推荐人
//	 * @return
//	 */
//	public String getPromMan(){
//		return "58.com";
//	}
	
	/**
	 * 前置加解密标签
	 * @return
	 */
	public String getEncryptedRender(){
		return "sm";
	}
	
	public HResponse checkParam(HResponse response, String loanId, String custId,
			String custName, String apptcApi, String inteRate, String signDate,
			String endDate, String retuKind, String repayMethod,
			String loanBankName, String loanBankBranch, String loanBankSub,
			String loanBankAcno, String imagefilepackagename, String contTerm) {
		if(StringUtil.isEmpty(loanId)){
			response.setRespCode(HServiceReturnCode.LOANID_ERROR.getReturnCode());
			response.setRespMessage(HServiceReturnCode.LOANID_ERROR.getReturnMessage());
			response.setRespTime(new Date());
			return response;
		}
		
		if(StringUtil.isEmpty(custId)){
			response.setRespCode(HServiceReturnCode.CUSTID_ERROR.getReturnCode());
			response.setRespMessage(HServiceReturnCode.CUSTID_ERROR.getReturnMessage());
			return response;
		}
		
		if(StringUtil.isEmpty(custName) || !ValidateUtil.checkChinese(custName)){
			response.setRespCode(HServiceReturnCode.CUSTNAME_ERROR.getReturnCode());
			response.setRespMessage(HServiceReturnCode.CUSTNAME_ERROR.getReturnMessage());
			return response;
		}
		
		if(StringUtil.isEmpty(apptcApi) || !ValidateUtil.checkDouble(apptcApi)){
			response.setRespCode(HServiceReturnCode.APPTCAPI_ERROR.getReturnCode());
			response.setRespMessage(HServiceReturnCode.APPTCAPI_ERROR.getReturnMessage());
			return response;
		}
		
		if(StringUtil.isEmpty(inteRate) || !ValidateUtil.checkDouble(inteRate)){
			response.setRespCode(HServiceReturnCode.INTERATE_ERROR.getReturnCode());
			response.setRespMessage(HServiceReturnCode.INTERATE_ERROR.getReturnMessage());
			return response;
		}
		
		if(StringUtil.isEmpty(signDate)){
			response.setRespCode(HServiceReturnCode.SIGNDATE_ERROR.getReturnCode());
			response.setRespMessage(HServiceReturnCode.SIGNDATE_ERROR.getReturnMessage());
			return response;
		}
		
		if(StringUtil.isEmpty(endDate)){
			response.setRespCode(HServiceReturnCode.ENDDATE_ERORR.getReturnCode());
			response.setRespMessage(HServiceReturnCode.ENDDATE_ERORR.getReturnMessage());
			return response;
		}
		
		if(StringUtil.isEmpty(retuKind)){
			response.setRespCode(HServiceReturnCode.RETURNKIND_ERROR.getReturnCode());
			response.setRespMessage(HServiceReturnCode.RETURNKIND_ERROR.getReturnMessage());
			return response;
		}
		
		if(StringUtil.isEmpty(repayMethod)){
			response.setRespCode(HServiceReturnCode.REPAYMETHOD_ERROR.getReturnCode());
			response.setRespMessage(HServiceReturnCode.REPAYMETHOD_ERROR.getReturnMessage());
			return response;
		}
		
		
		if(StringUtil.isEmpty(imagefilepackagename)){
			response.setRespCode(HServiceReturnCode.IMAGEFILEPACKAGENAME_ERROR.getReturnCode());
			response.setRespMessage(HServiceReturnCode.IMAGEFILEPACKAGENAME_ERROR.getReturnMessage());
			return response;
		}
		response.setRespCode(HServiceReturnCode.SUCCESS.getReturnCode());
		return response;
	}
}
