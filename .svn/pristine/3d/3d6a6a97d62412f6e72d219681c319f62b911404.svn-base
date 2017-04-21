package com.hrbb.loan.spi.ZZ;

import java.text.ParseException;
import java.util.Date;
import java.util.Map;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.google.common.collect.Maps;
import com.hrbb.loan.constants.PaymentApplyConstants;
import com.hrbb.loan.pos.biz.backstage.inter.IPaymentApplyBiz;
import com.hrbb.loan.pos.util.DateUtil;
import com.hrbb.loan.pos.util.StringUtil;
import com.hrbb.loan.pos.util.ValidateUtil;
import com.hrbb.loan.spiconstants.HServiceReturnCode;
import com.hrbb.loan.spiconstants.PaymentApplyHServiceConstants;
import com.hrbb.sh.framework.HResponse;
import com.hrbb.sh.framework.HServiceException;

/**
 * TransType:AP0008 -> 用款申请处理.
 * 
 * @author xiongshaogang
 * @version $Id: ZZAPPPaymentApplyServiceImpl.java, v 0.1 2015年4月23日 上午9:55:23 xiongshaogang Exp $
 */
@Service("zzAppPaymentApply")
public class ZZAPPPaymentApplyServiceImpl extends ZZAPPFoundationServiceImpl {
	
	Logger logger = LoggerFactory.getLogger(ZZAPPPaymentApplyServiceImpl.class);
	
	@Autowired
	IPaymentApplyBiz paymentApplyBiz;
	
	@Override
	protected HResponse doProcesser(HResponse resp, Map<String, String> headerMap,
                                    Map<String, String> bodyMap) throws HServiceException {
	    logger.debug("in ZZAPPPaymentApplyServiceImpl...");
	    
	    // 1. 组装biz 入参
        Map<String, Object> bizMap = Maps.newHashMap();
        try {
            bizMap.put(PaymentApplyConstants.contNo, bodyMap.get(PaymentApplyHServiceConstants.contno));
            bizMap.put(PaymentApplyConstants.payApplyAmt, bodyMap.get(PaymentApplyHServiceConstants.tcapi));
            bizMap.put(PaymentApplyConstants.payApplyTerm, bodyMap.get(PaymentApplyHServiceConstants.tterm));
            bizMap.put(PaymentApplyConstants.returnType, bodyMap.get(PaymentApplyHServiceConstants.retukind));
            bizMap.put(PaymentApplyConstants.accNo, bodyMap.get(PaymentApplyHServiceConstants.INDESUBSACNO));
            Date expectDateStr = DateUtil.getDatePattern3((String)bodyMap.get(PaymentApplyHServiceConstants.desireddate));
            logger.debug("传来的日期为:" + bodyMap.get(PaymentApplyHServiceConstants.desireddate));
            logger.debug("转换后的日期为:" + expectDateStr);
            try{
            	bizMap.put(PaymentApplyConstants.expectedDate, expectDateStr);
            	bizMap.put(PaymentApplyConstants.expectedEndDate, DateUtil.getDatePattern3(DateUtil.getRelativeDate(expectDateStr, 0, Integer.valueOf((String)bodyMap.get(PaymentApplyHServiceConstants.tterm)), -1)));
            	
            }catch(Exception e){
            	logger.error("日期转换异常", e);
            }

            bizMap.put(PaymentApplyConstants.applyDate, DateUtil.getDatePattern3(bodyMap.get(PaymentApplyHServiceConstants.begindate)));
        } catch (Exception e) {
            logger.error("报文解析出错", e);
            bodyMap.put("respcode", HServiceReturnCode.PAYAPPLYID_ERROR.getReturnCode());
            bodyMap.put("respmsg", HServiceReturnCode.PAYAPPLYID_ERROR.getReturnMessage());
            resp.setRespCode(HServiceReturnCode.PAYAPPLYID_ERROR.getReturnCode());
            resp.setRespMessage(HServiceReturnCode.PAYAPPLYID_ERROR.getReturnMessage());
            resp.setRespTime(new Date());
            return getBlankHResponse(resp, headerMap, bodyMap);
        }
		
		// 2. 业务入口处理
		Map<String, Object> paymentMap = paymentApplyBiz.insertPaymentApply(bizMap);
		if(paymentMap.isEmpty()){
		    bodyMap.put("respcode", HServiceReturnCode.PAYAPPLYID_ERROR.getReturnCode());
            bodyMap.put("respmsg", HServiceReturnCode.PAYAPPLYID_ERROR.getReturnMessage());
            resp.setRespCode(HServiceReturnCode.PAYAPPLYID_ERROR.getReturnCode());
            resp.setRespMessage(HServiceReturnCode.PAYAPPLYID_ERROR.getReturnMessage());
            resp.setRespTime(new Date());
            return getBlankHResponse(resp, headerMap, bodyMap);
		}
		paymentMap.put("payapplyid", paymentMap.get("listid"));
		paymentMap.remove("listid");
		
		// 3. 成功应答.
		Map<String, Object> respMap = Maps.newHashMap();
		
		// 3.1 签名处理
        headerMap.put("Mac", sign(paymentMap, null));
		
        respMap.put("HrbbHeader", headerMap);
        paymentMap.put("respcode", HServiceReturnCode.SUCCESS.getReturnCode());
        paymentMap.put("respmsg", HServiceReturnCode.SUCCESS.getReturnMessage());
        respMap.put("HrbbBody", paymentMap);
        resp.setProperties(respMap);
        resp.setRespCode(HServiceReturnCode.SUCCESS.getReturnCode());
        resp.setRespMessage(HServiceReturnCode.SUCCESS.getReturnMessage());
        resp.setRespTime(new Date());
        logger.info("回写数据: " + resp.toString());
		logger.debug("out ZZAPPPaymentApplyServiceImpl...");
		return resp;
	}
	
	/**
     * 请求包校验处理.
     * 
     * @param headerMap
     * @param bodyMap
     * @return
     */
    protected boolean validate(Map<String, String> headerMap, Map<String, String> bodyMap, HResponse resp) {
        
        if (!validateHeader(headerMap, bodyMap, resp)) {
            return false;
        }
        
        // 合同编号
        String contNo = bodyMap.get(PaymentApplyHServiceConstants.contno);
        if(StringUtil.isEmpty(contNo)){
            bodyMap.put("respcode", HServiceReturnCode.CONTNO_ERROR.getReturnCode());
            bodyMap.put("respmsg", HServiceReturnCode.CONTNO_ERROR.getReturnMessage());
            resp.setRespCode(HServiceReturnCode.CONTNO_ERROR.getReturnCode());
            resp.setRespMessage(HServiceReturnCode.CONTNO_ERROR.getReturnMessage());
            return false;
        }
        
        // 用款额度
        String payApplyAmt = bodyMap.get(PaymentApplyHServiceConstants.tcapi);
        if(StringUtil.isEmpty(payApplyAmt) || !(ValidateUtil.checkInteger(payApplyAmt) || ValidateUtil.checkDouble(payApplyAmt))){
            bodyMap.put("respcode", HServiceReturnCode.TCAPI_ERROR.getReturnCode());
            bodyMap.put("respmsg", HServiceReturnCode.TCAPI_ERROR.getReturnMessage());
            resp.setRespCode(HServiceReturnCode.TCAPI_ERROR.getReturnCode());
            resp.setRespMessage(HServiceReturnCode.TCAPI_ERROR.getReturnMessage());
            return false;
        }
        
        // 用款期限
        String payApplyTerm = bodyMap.get(PaymentApplyHServiceConstants.tterm);
        if(StringUtil.isEmpty(payApplyTerm) || !ValidateUtil.checkInteger(payApplyTerm)){
            bodyMap.put("respcode", HServiceReturnCode.TTERM_ERROR.getReturnCode());
            bodyMap.put("respmsg", HServiceReturnCode.TTERM_ERROR.getReturnMessage());
            resp.setRespCode(HServiceReturnCode.TTERM_ERROR.getReturnCode());
            resp.setRespMessage(HServiceReturnCode.TTERM_ERROR.getReturnMessage());
            return false;
        }
        
        // 期限单位
        String termunit = bodyMap.get(PaymentApplyHServiceConstants.termunit);
        if(StringUtil.isEmpty(termunit)){
            bodyMap.put("respcode", HServiceReturnCode.TERMUNIT_ERROR.getReturnCode());
            bodyMap.put("respmsg", HServiceReturnCode.TERMUNIT_ERROR.getReturnMessage());
            resp.setRespCode(HServiceReturnCode.TERMUNIT_ERROR.getReturnCode());
            resp.setRespMessage(HServiceReturnCode.TERMUNIT_ERROR.getReturnMessage());
            return false;
        }
        
        // 还款方式
        String returnType = bodyMap.get(PaymentApplyHServiceConstants.retukind);
        if(StringUtil.isEmpty(returnType)
                || "01|90".indexOf(returnType) < 0){
            bodyMap.put("respcode", HServiceReturnCode.RETUKIND_ERROR.getReturnCode());
            bodyMap.put("respmsg", HServiceReturnCode.RETUKIND_ERROR.getReturnMessage());
            resp.setRespCode(HServiceReturnCode.RETUKIND_ERROR.getReturnCode());
            resp.setRespMessage(HServiceReturnCode.RETUKIND_ERROR.getReturnMessage());
            return false;
        }
        
        // 放款账号
        String accNo    = bodyMap.get(PaymentApplyHServiceConstants.INDESUBSACNO);
        if(StringUtil.isEmpty(accNo)){
            bodyMap.put("respcode", HServiceReturnCode.INDESUBSACNO_ERROR.getReturnCode());
            bodyMap.put("respmsg", HServiceReturnCode.INDESUBSACNO_ERROR.getReturnMessage());
            resp.setRespCode(HServiceReturnCode.INDESUBSACNO_ERROR.getReturnCode());
            resp.setRespMessage(HServiceReturnCode.INDESUBSACNO_ERROR.getReturnMessage());
            return false;
        }
        
        // 期望用款日期
        String expectedDate = bodyMap.get(PaymentApplyHServiceConstants.desireddate); 
        if(StringUtil.isEmpty(expectedDate)){
            bodyMap.put("respcode", HServiceReturnCode.DESIREDDATE_ERROR.getReturnCode());
            bodyMap.put("respmsg", HServiceReturnCode.DESIREDDATE_ERROR.getReturnMessage());
            resp.setRespCode(HServiceReturnCode.DESIREDDATE_ERROR.getReturnCode());
            resp.setRespMessage(HServiceReturnCode.DESIREDDATE_ERROR.getReturnMessage());
            return false;
        }
        
        // 申请日期
        String applyDate = bodyMap.get(PaymentApplyHServiceConstants.begindate);
        if(StringUtil.isEmpty(applyDate)){
            bodyMap.put("respcode", HServiceReturnCode.BEGINDATE_ERROR.getReturnCode());
            bodyMap.put("respmsg", HServiceReturnCode.LOANUSE_ERROR.getReturnMessage());
            resp.setRespCode(HServiceReturnCode.BEGINDATE_ERROR.getReturnCode());
            resp.setRespMessage(HServiceReturnCode.BEGINDATE_ERROR.getReturnMessage());
            return false;
        }
        
        return true;
    }
}
