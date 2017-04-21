package com.hrbb.loan.spi.ZZ;

import java.util.Date;
import java.util.Map;
import java.util.Set;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.google.common.collect.Maps;
import com.hrbb.loan.pos.biz.backstage.inter.IGenericConfigBiz;
import com.hrbb.loan.pos.util.MapUtils;
import com.hrbb.loan.pos.util.SignUtil;
import com.hrbb.loan.spiconstants.HServiceReturnCode;
import com.hrbb.sh.framework.HRequest;
import com.hrbb.sh.framework.HResponse;
import com.hrbb.sh.framework.HService;
import com.hrbb.sh.framework.HServiceException;
//AP0019
@Service("zZAPPQueryCardbin")
public class ZZAPPQueryCardbinServiceImpl implements HService {

	private Logger logger = LoggerFactory.getLogger(this.getClass());
	
	@Autowired
	private IGenericConfigBiz genericConfigBiz;

	@Override
	public HResponse serve(HRequest request) throws HServiceException {
		logger.info("开始查询cardbin");
		Map<String, String> headerMap = (Map<String, String>) request
				.getProperties().get("HrbbHeader");
		Map<String, String> bodyMap = (Map<String, String>) request
				.getProperties().get("HrbbBody");
		HResponse resp = new HResponse();
		logger.info("headerMap : " + MapUtils.toString(headerMap));
		logger.info("bodyMap : " + MapUtils.toString(bodyMap));
		
		String cardbin = bodyMap.get("cardbin");
		Map<String, Object> resMap = genericConfigBiz.getIssuerInfo(cardbin);
		
		resMap = formateMap(resMap);
		Map<String, Object> respMap = Maps.newHashMap();
		resMap.put("respcode", HServiceReturnCode.SUCCESS.getReturnCode());
		resMap.put("respmsg", HServiceReturnCode.SUCCESS.getReturnMessage());
		respMap.put("HrbbBody", resMap);
		respMap.put("HrbbHeader", headerMap);
		
		// 6.1 签名处理
        headerMap.put("Mac", sign(resMap, null));
		
		resp.setProperties(respMap);
		resp.setRespCode(HServiceReturnCode.SUCCESS.getReturnCode());
		resp.setRespMessage(HServiceReturnCode.SUCCESS.getReturnMessage());
		resp.setRespTime(new Date());
		logger.info("回写数据: " + resp.toString());
		logger.info("查询cardbin结束...");
		return resp;
		
	}
	
	private Map<String, Object> formateMap(Map<String, Object> reqMap){
		
		Map<String, Object> resMap = Maps.newHashMap();
		
		for(Map.Entry<String, Object> en : reqMap.entrySet()){
			resMap.put(en.getKey().toLowerCase(), en.getValue());
		}
		return resMap;
	} 
	
	/**
     * 回写签名处理.
     * 
     * @param signMap
     * @param ignoreSet
     * @return
     */
    protected String sign(Map<String, Object> signMap, Set<String> ignoreSet) {
        String signedMsg = SignUtil.getSignMsg(signMap, ignoreSet);
        logger.info("应答待签名串 signedMsg = [" + signedMsg + "]");
        String signRet = SignUtil.sign(SignUtil.MD5_ALG, signedMsg, SignUtil.getProperty("app_posloan_signkey"));
        logger.info("应答签名 Mac = [" + signRet + "]");
        return signRet;
    }

}
