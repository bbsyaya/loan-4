package com.hrbb.loan.spi.TC;

import java.util.Date;
import java.util.Map;

import org.apache.cxf.common.util.StringUtils;
import org.apache.log4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.util.Assert;

import com.google.common.collect.Maps;
import com.hrbb.loan.pos.biz.backstage.inter.IRepaymentApplyBiz;
import com.hrbb.loan.pos.service.bean.OTRespResult;
import com.hrbb.loan.pos.util.StringUtil;
import com.hrbb.loan.spiconstants.HServiceReturnCode;
import com.hrbb.loan.spiconstants.PaymentApplyHServiceConstants;
import com.hrbb.sh.framework.HRequest;
import com.hrbb.sh.framework.HResponse;
import com.hrbb.sh.framework.HServiceException;

@Service("tcRepaymentApply")
public class TCRepaymentApplyServiceImpl extends TCService {
	private final Logger logger = Logger.getLogger(TCRepaymentApplyServiceImpl.class);

	@Autowired
	private IRepaymentApplyBiz repaymentApplyBiz;
	
	private HResponse getBlankResponse(HResponse resp) {
		Map<String, Object> reqMap = Maps.newHashMap();
		reqMap.put(PaymentApplyHServiceConstants.listid, "");
		resp.setProperties(reqMap);
		return resp;
	}

	@Override
	public HResponse serve(HRequest request) throws HServiceException {
		if (logger.isDebugEnabled()) {
			logger.debug("repayment request received");
		}

//		Assert.notNull(repaymentApplyService,
//				"doesn't allow empty repaymentApplyService");

		Map<String, Object> properties = request.getProperties();

		Assert.notNull(properties, "doesn't allow empty properties");
		HResponse hResponse = new HResponse();
		
		//增加扩展的还款条件扩展入口，默认不做任何事
		if(!initRepaymentEnv(properties)){
			hResponse.setRespCode(HServiceReturnCode.OTHER_ERROR.getReturnCode());
			hResponse.setRespMessage(HServiceReturnCode.OTHER_ERROR.getReturnMessage());
			hResponse.setRespTime(new Date());
			return getBlankResponse(hResponse);
		}
		
		if (!properties.containsKey("issueid")) {
			logger.info("用款申请编号为空或有误");
			hResponse.setRespCode(HServiceReturnCode.LISTID_REPAY_ERROR
					.getReturnCode());
			hResponse.setRespMessage(HServiceReturnCode.LISTID_REPAY_ERROR
					.getReturnMessage());
			hResponse.setRespTime(new Date());
			return getBlankResponse(hResponse);
		}
		
		if(StringUtil.isEmpty((String)properties.get("issueid"))){
			logger.info("合同项下缺少有效用款");
			hResponse.setRespCode(HServiceReturnCode.PAYMENTLESS_ERROR.getReturnCode());
			hResponse.setRespMessage(HServiceReturnCode.PAYMENTLESS_ERROR.getReturnMessage());
			hResponse.setRespTime(new Date());
			return getBlankResponse(hResponse);
		}

		try {
			String amount = String.valueOf(properties.get("sumamt"));
			Double.parseDouble(amount);
			logger.info("还款机内为"+amount);
		} catch (Exception ex) {
			logger.warn("invalid amount...", ex);
			hResponse.setRespCode(HServiceReturnCode.AMT_REPAY_ERROR
					.getReturnCode());
			hResponse.setRespMessage(HServiceReturnCode.AMT_REPAY_ERROR
					.getReturnMessage());
			hResponse.setRespTime(new Date());
			return getBlankResponse(hResponse);
		}
		
		try {
			String issueid = properties.get("issueid").toString();
			properties.put("listid",issueid);
			OTRespResult respResult = repaymentApplyBiz.paybackApply(properties);
			if(respResult.isRespSuccess()){
				String repaymentNo = (String)respResult.getAttribute("repaymentNo");
				logger.info("还款流水号为"+repaymentNo);
				Map<String, Object> reqMap = Maps.newHashMap();
				reqMap.put("listid", repaymentNo);
				hResponse.setProperties(reqMap);
				
				hResponse.setRespCode(HServiceReturnCode.SUCCESS.getReturnCode());
				hResponse.setRespMessage(HServiceReturnCode.SUCCESS.getReturnMessage());
				return hResponse;
			}else{
				hResponse.setRespCode(HServiceReturnCode.FAILURE_REPAY_ERROR.getReturnCode());
				hResponse.setRespMessage(respResult.getRespMessage());
				return getBlankResponse(hResponse);
			}
		} catch (Exception ex) {
			logger.error("failed to apply repayment...", ex);

			hResponse.setRespCode(HServiceReturnCode.FAILURE_REPAY_ERROR
					.getReturnCode());
			hResponse.setRespMessage(HServiceReturnCode.FAILURE_REPAY_ERROR
					.getReturnMessage());
			hResponse.setRespTime(new Date());

			return getBlankResponse(hResponse);
		}
	}

	protected boolean initRepaymentEnv(Map<String, Object> request){
		//do nothing just for extension
		return true;
	}
}
