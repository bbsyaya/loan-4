package com.hrbb.loan.spi.UM;

import java.math.BigDecimal;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.google.common.collect.Lists;
import com.google.common.collect.Maps;
import com.hrbb.loan.pos.service.LoanPosPaybackRunningRecordService;
import com.hrbb.loan.pos.service.LoanPosPaybackService;
import com.hrbb.loan.spiconstants.HServiceReturnCode;
import com.hrbb.loan.spiconstants.PaymentApplyHServiceConstants;
import com.hrbb.sh.framework.HRequest;
import com.hrbb.sh.framework.HResponse;
import com.hrbb.sh.framework.HService;
import com.hrbb.sh.framework.HServiceException;
@Service("umPaybackRunningQuery")
public class UMPaybackRunningQueryImpl implements HService {
	Logger logger = LoggerFactory.getLogger(UMPaybackRunningQueryImpl.class);
	@Autowired
	private LoanPosPaybackService loanPosPaybackService;
	@Autowired
	private LoanPosPaybackRunningRecordService loanPosPaybackRunningRecordService;
	@Override
	public HResponse serve(HRequest request) throws HServiceException {
		// TODO Auto-generated method stub
		logger.debug("executing UMPaybackRunningQueryImpl...");
		HResponse response = new HResponse();
		Map<String, Object> propMap = request.getProperties();
		String  listid = propMap.get("listid").toString();
		logger.info("用款申请号为"+listid);
		String receiptId = loanPosPaybackService.getReceiptIdByPayApplyId(listid);
		logger.info("借据编号为"+receiptId);
		String  stdshno = propMap.get("stdshno").toString();
		String  stdmerno = propMap.get("stdmerno").toString();
		long startnum =Long.valueOf(propMap.get("startnum").toString()) ;
		long recnum =Long.valueOf(propMap.get("recnum").toString()) ;
		Map<String, Object> reqMap = Maps.newHashMap();
		reqMap.put("receiptId",receiptId);
		reqMap.put("startnum",startnum);
		reqMap.put("recnum",recnum);
		
		try{
			List<Map<String, Object>> paybackRunninglist =loanPosPaybackRunningRecordService.getPaybackRunningRecordList(reqMap);
			int t =  paybackRunninglist.size();
			String tn = String.valueOf(t);
			List<Map<String, Object>> c = Lists.newArrayList();
			
			for(Map<String, Object> a :paybackRunninglist){
				String custId = (String) a.get("custId");
				String custName = (String) a.get("custName");
				String paperId = (String) a.get("paperId");
				String paperKind = (String) a.get("paperKind");
				String loanId = (String) a.get("loanId");
				String contNo = (String) a.get("contNo");
				String cnContNo = (String) a.get("cnContNo");
				String payApplyId = (String) a.get("payApplyId");
				String paybackRunningRecordId = (String) a.get("paybackRunningRecordId");
				String acceptAccount = (String) a.get("acceptAccount");
				Date actualPaybackDate = (Date) a.get("actualPaybackDate");
				SimpleDateFormat sft = new SimpleDateFormat("yyyy-MM-dd");
				String apt = sft.format(actualPaybackDate);
				
				BigDecimal actualTotalAmount = (BigDecimal) a.get("actualTotalAmount");
				BigDecimal actualCapital = (BigDecimal) a.get("actualCapital");
				BigDecimal actualInterest = (BigDecimal) a.get("actualInterest");
				Map<String, Object> b = Maps.newHashMap();
	            b.put("custid", custId);
	            b.put("custname", custName);
	            b.put("paperid", paperId);
	            b.put("paperkind", paperKind);
	            b.put("loanid", loanId);
	            b.put("contno", contNo);
	            b.put("cncontno", cnContNo);
	            b.put("listid", payApplyId);
	            b.put("retulistid", paybackRunningRecordId);
	            b.put("subsaccno", acceptAccount);
	            b.put("acdate", apt);
	            b.put("sumamt", actualTotalAmount.toString());
	            b.put("rcapi", actualCapital.toString());
	            b.put("rinte", actualInterest.toString());
	            b.put("retutype",String.valueOf(03));
	            b.put("rfine",String.valueOf(0));
	            b.put("stdshno",stdshno);
		        b.put("stdmerno",stdmerno);
		        c.add(b);
			 }
			
			response.setRespCode(HServiceReturnCode.SUCCESS.getReturnCode());
			response.setRespMessage(HServiceReturnCode.SUCCESS.getReturnMessage());
			response.setRespTime(new Date());
			Map<String, Object> respMap = Maps.newHashMap();
			respMap.put("totalnum",tn);
			respMap.put("retnum",String.valueOf(10));
			respMap.put("rows", c);
			response.setProperties(respMap);
			return response;
		}catch(Exception e){
			logger.error("还款流水查询失败",e);
			response.setRespCode(HServiceReturnCode.POS_PAYBACK_RUNNING_QUERY_ERROR.getReturnCode());
			response.setRespMessage(HServiceReturnCode.POS_PAYBACK_RUNNING_QUERY_ERROR
						.getReturnMessage());
			response.setRespTime(new Date());
			return getBlankHResponse(response);
			
		}
		
	}

	
	private HResponse getBlankHResponse(HResponse response){
		Map<String, Object> respMap = Maps.newHashMap();
		List<Map<String, Object>> aaMaps = Lists.newArrayList();
		Map<String, Object> respMap1 = Maps.newHashMap();
		respMap1.put(PaymentApplyHServiceConstants.totalnum, "0");
		respMap1.put(PaymentApplyHServiceConstants.retnum, "0");
		respMap1.put("totalnum", "0");
		respMap1.put("retnum", "0");
		respMap.put("custid", "");
		respMap.put("custname", "");
		respMap.put("paperkind", "");
		respMap.put("paperid", "");
		respMap.put("loanid", "");
		respMap.put("contno", "");
		respMap.put("cncontno", "");
		respMap.put("begindate", "");
		respMap.put("enddate", "");
		respMap.put("conttotalamt", "");
		respMap.put("conttouseamt", "");
		respMap.put("interate", "");
		respMap.put("retukind", "");
		respMap.put("contstatus", "");
		respMap.put("adjustreason", "");
		respMap.put("refreshdate", "");
		respMap.put("stdshno", "");
		respMap.put("stdmerno", "");
		aaMaps.add(respMap);
		respMap1.put("rows", aaMaps);
		response.setProperties(respMap1);
		return response;
	}
	
}
