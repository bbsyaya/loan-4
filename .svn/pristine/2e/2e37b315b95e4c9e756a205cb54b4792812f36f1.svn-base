package com.hrbb.loan.spi.WX;

import java.util.Date;
import java.util.Map;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.google.common.collect.Maps;
import com.hrbb.loan.pos.biz.backstage.inter.ILoanPosCreditApplyBackStageBiz;
import com.hrbb.loan.pos.util.StringUtil;
import com.hrbb.loan.spiconstants.HServiceReturnCode;
import com.hrbb.sh.framework.HRequest;
import com.hrbb.sh.framework.HResponse;
import com.hrbb.sh.framework.HServiceException;

@Service("wxRepaymentPlanQueryService")
public class WXRepaymentPlanQueryService extends WXHService{
	
	private Logger logger = LoggerFactory.getLogger(WXRepaymentPlanQueryService.class);
	
	@Autowired
	private ILoanPosCreditApplyBackStageBiz loanBiz;

	@Override
	public HResponse serve(HRequest request) throws HServiceException {
		logger.debug("in smRepaymentPlanQuery...");
		Map<String, Object> props = request.getProperties();
		
		HResponse response = new HResponse();
		
		String payApplyId = (String) props.get("issueid");
		
		String startNum = (String) props.get("startnum");
		
		String recNum = (String) props.get("recnum");
		logger.debug("payApplyId=" + payApplyId + "startnum=" + startNum + "recNum=" +recNum);
		
		if(StringUtil.isEmpty(payApplyId)){
			response.setRespCode(HServiceReturnCode.PAYAPPLYID_ERROR.getReturnCode());
			response.setRespMessage(HServiceReturnCode.PAYAPPLYID_ERROR.getReturnMessage());
			response.setRespTime(new Date());
			return response;
		}
		
		if(StringUtil.isEmpty(startNum)){
			response.setRespCode(HServiceReturnCode.STARTNUM_ERROR.getReturnCode());
			response.setRespMessage(HServiceReturnCode.STARTNUM_ERROR.getReturnMessage());
			return response;
		}
		
		if(StringUtil.isEmpty(recNum)){
			response.setRespCode(HServiceReturnCode.RECNUM_ERROR.getReturnCode());
			response.setRespMessage(HServiceReturnCode.RECNUM_ERROR.getReturnMessage());
			return response;
		}
		
		Map<String, Object> reqMap = Maps.newHashMap();
		reqMap.put("payApplyId", payApplyId);
		reqMap.put("startNum", Integer.valueOf(startNum));
		reqMap.put("recNum", Integer.valueOf(recNum));
		logger.debug("还款计划开始查询, reqMap=" + reqMap);
		Map<String, Object> resMap = loanBiz.queryRepaymentPlan(reqMap);
		logger.debug("还款计划查询结果为:" + resMap);
		response.setRespCode(HServiceReturnCode.SUCCESS.getReturnCode());
		response.setRespMessage(HServiceReturnCode.SUCCESS.getReturnMessage());
		response.setProperties(resMap);
		return response;
	}

	private HResponse getBlankResp(HResponse response) {
		Map<String, Object> respMap = Maps.newHashMap();
		respMap.put("issueid", "");
		respMap.put("contno", "");
		respMap.put("custid", "");
		respMap.put("totalnum", "");
		respMap.put("retnum", "");
		respMap.put("schddate", "");
		respMap.put("schdperiod", "");
		respMap.put("schdprincipal", "");
		respMap.put("schdinterest", "");
		respMap.put("schdtotal", "");
		response.setProperties(respMap);
		return response;
	}

}
