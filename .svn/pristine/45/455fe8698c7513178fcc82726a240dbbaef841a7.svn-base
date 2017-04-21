package com.hrbb.loan.spi.TC;

import java.util.Date;
import java.util.List;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.google.common.collect.Lists;
import com.google.common.collect.Maps;
import com.hrbb.loan.pos.biz.backstage.inter.IPaymentApplyBiz;
import com.hrbb.loan.pos.util.StringUtil;
import com.hrbb.loan.pos.util.ValidateUtil;
import com.hrbb.loan.spiconstants.CreditApplyHServiceConstants;
import com.hrbb.loan.spiconstants.HServiceReturnCode;
import com.hrbb.loan.spiconstants.PaymentApplyHServiceConstants;
import com.hrbb.sh.framework.HRequest;
import com.hrbb.sh.framework.HResponse;
import com.hrbb.sh.framework.HServiceException;

@Service("tcPaymentApplyQuery")
public class TCPaymentApplyQueryImpl extends TCService {
	
	@Autowired
	private IPaymentApplyBiz paymentApplyBiz;
	
//	private Logger logger = LoggerFactory.getLogger(TCPaymentApplyQueryImpl.class); 

	@Override
	public HResponse serve(HRequest request) throws HServiceException {
		logger.debug("开始用款申请查询");
		Map<String, Object> reqMap = request.getProperties();
		HResponse resp = new HResponse();
		String stdmerno = (String)reqMap.get(CreditApplyHServiceConstants.stdmerno);
		/*if(StringUtil.isEmpty(stdmerno)){
			resp.setRespCode(HServiceReturnCode.STDMERNO_PAY_ERROR.getReturnCode());
			resp.setRespMessage(HServiceReturnCode.STDMERNO_PAY_ERROR.getReturnMessage());
			resp.setRespTime(new Date());
			return getBlankResponse(resp);
		}*/
		String stdshno = (String)reqMap.get(CreditApplyHServiceConstants.stdshno);
		String startnum = (String)reqMap.get(CreditApplyHServiceConstants.startnum);
		if(StringUtil.isEmpty(startnum) || !ValidateUtil.checkInteger(startnum)){
			resp.setRespCode(HServiceReturnCode.STARTNUM_PAY_ERROR.getReturnCode());
			resp.setRespMessage(HServiceReturnCode.STARTNUM_PAY_ERROR.getReturnMessage());
			resp.setRespTime(new Date());
			return getBlankResponse(resp);
		}
		String recnum = (String)reqMap.get(CreditApplyHServiceConstants.recnum);
		if(StringUtil.isEmpty(recnum) || !ValidateUtil.checkInteger(recnum)){
			resp.setRespCode(HServiceReturnCode.RECNUM_PAY_ERROR.getReturnCode());
			resp.setRespMessage(HServiceReturnCode.RECNUM_PAY_ERROR.getReturnMessage());
			resp.setRespTime(new Date());
			return getBlankResponse(resp);
		}
		String payApplyId = (String)reqMap.get(CreditApplyHServiceConstants.issueid);
		String contNo = (String)reqMap.get(CreditApplyHServiceConstants.contno);
		String custId = (String)reqMap.get(CreditApplyHServiceConstants.custid);
		
		if(StringUtil.isEmpty(payApplyId) && StringUtil.isEmpty(contNo) && StringUtil.isEmpty(custId)){
			resp.setRespCode(HServiceReturnCode.QUERY_PAYMENT_DATA_BLANK.getReturnCode());
			resp.setRespMessage(HServiceReturnCode.QUERY_PAYMENT_DATA_BLANK.getReturnMessage());
			resp.setRespTime(new Date());
			return getBlankResponse(resp);
		}
		//logger.debug("stdshno:"+stdshno+"\n");
		Map<String, Object> resMap = paymentApplyBiz.queryPaymentByStdmerno(custId, payApplyId, contNo,stdshno, stdmerno, getChannel(), startnum, recnum);
		if(reqMap.isEmpty()){
			resp.setRespCode(HServiceReturnCode.OTHER_ERROR.getReturnCode());
			resp.setRespMessage(HServiceReturnCode.OTHER_ERROR.getReturnMessage());
			return getBlankResponse(resp);
		}
		logger.debug("查询结束\n");
		resp.setRespCode(HServiceReturnCode.SUCCESS.getReturnCode());
		resp.setRespMessage(HServiceReturnCode.SUCCESS.getReturnMessage());
		resp.setProperties(resMap);
		return resp;
	}
	
	private HResponse getBlankResponse(HResponse resp){
		Map<String, Object> respMap = Maps.newHashMap();
		List<Map<String, Object>> aaMaps = Lists.newArrayList();
		Map<String, Object> respMap1 = Maps.newHashMap();
		respMap1.put(PaymentApplyHServiceConstants.totalnum, "0");
		respMap1.put(PaymentApplyHServiceConstants.retnum, "0");
		respMap.put(PaymentApplyHServiceConstants.custid, "");
		respMap.put(PaymentApplyHServiceConstants.custname, "");
		respMap.put(PaymentApplyHServiceConstants.paperkind, "");
		respMap.put(PaymentApplyHServiceConstants.paperid, "");
		respMap.put(PaymentApplyHServiceConstants.loanid, "");
		respMap.put(PaymentApplyHServiceConstants.contno, "");
		respMap.put(PaymentApplyHServiceConstants.cncontno, "");
		respMap.put(PaymentApplyHServiceConstants.listid, "");
		respMap.put(PaymentApplyHServiceConstants.liststat, "");
		respMap.put(PaymentApplyHServiceConstants.refusereason, "");
		respMap.put(PaymentApplyHServiceConstants.begindate, "");
		respMap.put(PaymentApplyHServiceConstants.enddate, "");
		respMap.put(PaymentApplyHServiceConstants.tcapi, "");
		respMap.put(PaymentApplyHServiceConstants.bal, "");
		respMap.put(PaymentApplyHServiceConstants.overinte, "");
		respMap.put(PaymentApplyHServiceConstants.interate, "");
		respMap.put(PaymentApplyHServiceConstants.retukind, "");
		respMap.put(PaymentApplyHServiceConstants.acflag, "");
		respMap.put(PaymentApplyHServiceConstants.payoffflag, "");
		respMap.put(PaymentApplyHServiceConstants.stdshno, "");
		respMap.put(PaymentApplyHServiceConstants.stdmerno, "");
		aaMaps.add(respMap);
		respMap1.put("rows", aaMaps);
		resp.setProperties(respMap1);
		return resp;
	}
	
	
}
