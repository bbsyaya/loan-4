package com.hrbb.loan.spi.ZZ;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Date;
import java.util.List;
import java.util.Map;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.google.common.collect.Maps;
import com.hrbb.loan.pos.biz.backstage.inter.BusinessDictionaryBiz;
import com.hrbb.loan.pos.biz.backstage.inter.IPDFService;
import com.hrbb.loan.pos.biz.backstage.inter.LoanPosContractManagementBiz;
import com.hrbb.loan.pos.dao.entity.TBusinessDictionary;
import com.hrbb.loan.pos.dao.entity.TPdfSignature;
import com.hrbb.loan.pos.factory.SysConfigFactory;
import com.hrbb.loan.pos.service.LoanPosContractManagementService;
import com.hrbb.loan.pos.service.PdfSignatureService;
import com.hrbb.loan.pos.util.PdfNameGenerator;
import com.hrbb.loan.pos.util.StringUtil;
import com.hrbb.loan.pos.util.ValidateUtil;
import com.hrbb.loan.pos.util.constants.BusinessDictionaryConstants;
import com.hrbb.loan.spiconstants.HServiceReturnCode;
import com.hrbb.loan.util.HtmlGenerator;
import com.hrbb.sh.framework.HResponse;
import com.hrbb.sh.framework.HServiceException;

/**
 * TransType:AP0026 -> 电子协议回传.
 * 
 * @author xiongshaogang
 * @version $Id: ZZAPPElectronicProtocolBackhaulServiceImpl.java, v 0.1
 *          2015年4月21日 下午2:01:29 xiongshaogang Exp $
 */
@Service("zzAppElectronicProtocolBackhaul2")
public class ZZAPPElectronicProtocolBackhaul2ServiceImpl extends
		ZZAPPFoundationServiceImpl {

	private final Logger logger = LoggerFactory
			.getLogger(ZZAPPElectronicProtocolBackhaul2ServiceImpl.class);

	@Autowired
	private LoanPosContractManagementService loanPosContractManagementService;

	@Autowired
	private LoanPosContractManagementBiz loanPosContractManagementBiz;
	
	@Autowired
	private PdfSignatureService pdfSignatureService;

	private String URL;

	@Autowired
	private BusinessDictionaryBiz businessDictionaryBiz;
	
	@Autowired
	private IPDFService pdfService;
	
	/**
	 * @see com.hrbb.sh.framework.HService#serve(com.hrbb.sh.framework.HRequest)
	 */
	@Override
	protected HResponse doProcesser(HResponse resp, Map<String, String> headerMap, Map<String, String> bodyMap)
			throws HServiceException {

		logger.debug("in ZZAPPElectronicProtocolBackhaul2ServiceImpl...");
		try{
			String loanId = (String) bodyMap.get("loanid");
	
			String signDate = (String) bodyMap.get("signdate");
	
			String contNo = (String) bodyMap.get("contno");
	
			String repayMethod = (String) bodyMap.get("repaymethod");
			String signature = (String) bodyMap.get("signature");
			 //加载系统参数配置 
			URL = SysConfigFactory.getInstance().getService("basicService")
					.getPropertyValue("webUrl");
			pdfSignatureService.insert(new TPdfSignature(contNo, signature));
			// 1. 电子协议检索
			Map<String, Object> reqMap = Maps.newHashMap();
			reqMap.put("contNo", contNo);
			List<Map<String, Object>> lists = loanPosContractManagementService
					.selectSelectiveMap(reqMap);
			if (lists.isEmpty()) {
				bodyMap.put("respcode",
						HServiceReturnCode.HASNO_CONT.getReturnCode());
				bodyMap.put("respmsg",
						HServiceReturnCode.HASNO_CONT.getReturnMessage());
				resp.setRespCode(HServiceReturnCode.HASNO_CONT.getReturnCode());
				resp.setRespMessage(HServiceReturnCode.HASNO_CONT
						.getReturnMessage());
				resp.setRespTime(new Date());
				logger.error("不存在该协议：" + contNo);
				return getBlankHResponse(resp, headerMap, bodyMap);
			}
	
			// 组装model
			Map<String, Object> contractMap = lists.get(0);
			String imageFilePackageName = PdfNameGenerator.getContractName(contNo, (String)contractMap.get("custId"));
			Map<String, Object> model = loanPosContractManagementBiz
					.transferToPdfArgee(contractMap);
			TBusinessDictionary dictionary = new TBusinessDictionary();
			dictionary.setCodeNo(BusinessDictionaryConstants.BankNo);
			dictionary.setItemNo((String) contractMap.get("accountOpenBank"));
			TBusinessDictionary record = businessDictionaryBiz
					.selectOne(dictionary);
	
			String openBankName = record.getItemName();
			if(null != openBankName){
			    openBankName = openBankName.replaceAll("银行", "");
			}
			model.put("loanBankName", openBankName);
			model.put("repayBankName", openBankName);
			String[] dateStrs = signDate.split("-");
			String signYear = dateStrs[0];
			String signMonth = dateStrs[1];
			String signDay = dateStrs[2];
			model.put("signYear", signYear);
			model.put("signMonth", signMonth);
			model.put("signDay", signDay);
			model.put("repayMethod", repayMethod.trim());
			String signImageName = contNo + ".jpg";
			model.put("signUrl", signImageName);
			// 获取协议模板
			String template = HtmlGenerator.generate("agreement.ftl", model);
			String resourcePath = null;
			// resourcePath =
			// ResourceUtils.getURL(ResourceUtils.CLASSPATH_URL_PREFIX+"font/").toString();
			resourcePath = ZZAPPElectronicProtocolBackhaul2ServiceImpl.class.getClassLoader().getResource("font")
					.toURI().toString();
			// 异步调用生成pdf
			pdfService.generate(loanId, template, resourcePath,
					imageFilePackageName, signature, signImageName);
			// 4. 回写成功
			Map<String, Object> rootMap = Maps.newHashMap();
			bodyMap = Maps.newHashMap();
			bodyMap.put("respcode", HServiceReturnCode.SUCCESS.getReturnCode());
			bodyMap.put("respmsg", HServiceReturnCode.SUCCESS.getReturnMessage());
	
			// 4.1 签名处理
			Map<String, Object> signMap = Maps.newHashMap();
			for (Map.Entry<String, String> en : bodyMap.entrySet()) {
				String key = en.getKey();
				signMap.put(key, en.getValue());
			}
			headerMap.put("Mac", sign(signMap, null));
	
			rootMap.put("HrbbHeader", headerMap);
			rootMap.put("HrbbBody", bodyMap);
			resp.setRespCode(HServiceReturnCode.SUCCESS.getReturnCode());
			resp.setRespMessage(HServiceReturnCode.SUCCESS.getReturnMessage());
			resp.setRespTime(new Date());
			resp.setProperties(rootMap);
			logger.info("回写数据: " + resp.toString());
			logger.debug("out ZZAPPElectronicProtocolBackhaul2ServiceImpl...");
			return resp;
		}catch(Exception e){
			logger.error("第二种协议回传发生异常：", e);
			bodyMap.put("respcode",
					HServiceReturnCode.OTHER_ERROR.getReturnCode());
			bodyMap.put("respmsg",
					HServiceReturnCode.OTHER_ERROR.getReturnMessage());
			resp.setRespCode(HServiceReturnCode.OTHER_ERROR.getReturnCode());
			resp.setRespMessage(HServiceReturnCode.HASNO_CONT
					.getReturnMessage());
			resp.setRespTime(new Date());
			return getBlankHResponse(resp, headerMap, bodyMap);
		}
		
	}	
	
	/**
	 * 请求包校验处理.
	 * 
	 * @param headerMap
	 * @param bodyMap
	 * @return
	 * @throws Exception
	 */
	protected boolean validate(Map<String, String> headerMap,
			Map<String, String> bodyMap, HResponse resp)
			throws HServiceException {
		if (!validateHeader(headerMap, bodyMap, resp)) {
			return false;
		}

		String loanId = (String) bodyMap.get("loanid");
		if (StringUtil.isEmpty(loanId)) {
			bodyMap.put("respcode",
					HServiceReturnCode.LOANID_ERROR.getReturnCode());
			bodyMap.put("respmsg",
					HServiceReturnCode.LOANID_ERROR.getReturnMessage());
			resp.setRespCode(HServiceReturnCode.LOANID_ERROR.getReturnCode());
			resp.setRespMessage(HServiceReturnCode.LOANID_ERROR
					.getReturnMessage());
			resp.setRespTime(new Date());
			logger.error("loanId为空");
			return false;
		}
		String imageFilePackageName = (String) bodyMap
				.get("imagefilepackagename");
		if (StringUtil.isEmpty(imageFilePackageName)) {
			bodyMap.put("respcode",
					HServiceReturnCode.IMAGEFILEPACKAGENAME_ERROR
							.getReturnCode());
			bodyMap.put("respmsg",
					HServiceReturnCode.IMAGEFILEPACKAGENAME_ERROR
							.getReturnMessage());
			resp.setRespCode(HServiceReturnCode.IMAGEFILEPACKAGENAME_ERROR
					.getReturnCode());
			resp.setRespMessage(HServiceReturnCode.IMAGEFILEPACKAGENAME_ERROR
					.getReturnMessage());
			resp.setRespTime(new Date());
			logger.error("imagefilepackagename为空");
			return false;
		}

		String signDate = (String) bodyMap.get("signdate");
		if (StringUtil.isEmpty(signDate)
				|| !ValidateUtil.checkDate(signDate, "yyyy-MM-dd")) {
			bodyMap.put("respcode",
					HServiceReturnCode.SIGNDATE_ERROR.getReturnCode());
			bodyMap.put("respmsg",
					HServiceReturnCode.SIGNDATE_ERROR.getReturnMessage());
			resp.setRespCode(HServiceReturnCode.SIGNDATE_ERROR.getReturnCode());
			resp.setRespMessage(HServiceReturnCode.SIGNDATE_ERROR
					.getReturnMessage());
			resp.setRespTime(new Date());
			logger.error("signDate有误:" + signDate);
			return false;
		}

		String contNo = (String) bodyMap.get("contno");
		if (StringUtil.isEmpty(contNo)) {
			bodyMap.put("respcode",
					HServiceReturnCode.CONTNO_ERROR.getReturnCode());
			bodyMap.put("respmsg",
					HServiceReturnCode.CONTNO_ERROR.getReturnMessage());
			resp.setRespCode(HServiceReturnCode.CONTNO_ERROR.getReturnCode());
			resp.setRespMessage(HServiceReturnCode.CONTNO_ERROR
					.getReturnMessage());
			resp.setRespTime(new Date());
			logger.error("contno有误:" + contNo);
			return false;
		}

		List<String> repayMethodList = new ArrayList<String>(Arrays.asList(
				"01", "02"));

		String repayMethod = (String) bodyMap.get("repaymethod");
		if (StringUtil.isEmpty(repayMethod)
				|| !repayMethodList.contains(repayMethod)) {
			bodyMap.put("respcode",
					HServiceReturnCode.REPAYMETHOD_ERROR.getReturnCode());
			bodyMap.put("respmsg",
					HServiceReturnCode.REPAYMETHOD_ERROR.getReturnMessage());
			resp.setRespCode(HServiceReturnCode.REPAYMETHOD_ERROR
					.getReturnCode());
			resp.setRespMessage(HServiceReturnCode.REPAYMETHOD_ERROR
					.getReturnMessage());
			resp.setRespTime(new Date());
			logger.error("repayMethod有误:" + signDate);
			return false;
		}
		String signature = (String) bodyMap.get("signature");
		if (StringUtil.isEmpty(signature)) {
			bodyMap.put("respcode",
					HServiceReturnCode.SIGNATURE_ERROR.getReturnCode());
			bodyMap.put("respmsg",
					HServiceReturnCode.SIGNATURE_ERROR.getReturnMessage());
			resp.setRespCode(HServiceReturnCode.SIGNATURE_ERROR.getReturnCode());
			resp.setRespMessage(HServiceReturnCode.SIGNATURE_ERROR
					.getReturnMessage());
			resp.setRespTime(new Date());
			logger.error("signature有误:" + signDate);
			return false;
		}

		return true;
	}
}
