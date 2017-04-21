package com.hrbb.loan.pos.biz.backstage.inter.impl;

import java.util.Date;
import java.util.Map;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.google.common.base.Objects;
import com.google.common.collect.Maps;
import com.hrbb.loan.pos.biz.backstage.inter.IPoliceAndAICConnectBiz;
import com.hrbb.loan.pos.service.LoanPosCustomerService;
import com.hrbb.loan.pos.service.PoliceAndAICConnectService;
import com.hrbb.loan.pos.util.ListUtil;
import com.hrbb.sh.frontier.biz.nciic.NciicFacade;
import com.hrbb.sh.gateway.xscredit.bean.IdCardPhotoRequest;
import com.hrbb.sh.gateway.xscredit.bean.IdCardPhotoResponse;
import com.hrbb.sh.gateway.xscredit.facade.XsCreditFacade;

/**
 * TODO this class copy PoliceHessianServiceImpl in loan-pos-web project,so must sync with PoliceHessianServiceImpl when it update
 * @author zhangwei5@hrbb.com.cn
 * @date 2015年9月28日上午11:58:28 
 */
@Service
public class LoadPoliceInfoService{
	
	Logger logger = LoggerFactory.getLogger(LoadPoliceInfoService.class);

	
	@Autowired
	private IPoliceAndAICConnectBiz policeAndAICConnectBiz;
	
	@Autowired
	private PoliceAndAICConnectService policeAndAICConnectService;
	
	@Autowired
	private LoanPosCustomerService loanPosCustomerService;
	
	@Autowired
	private XsCreditFacade xsCreditFacade;
	
	@Autowired
	private NciicFacade nciicFacade;

	public Map<String, String> getCustPoliceInfo(Map<String, String> reqMap) {
        Map<String, String> respMap = Maps.newHashMap();
        String custName = reqMap.get("custName");
        String idNo = reqMap.get("idNo");
        String custId = reqMap.get("custId");

            //需要查询
            Map<String, String> reqXmlMap = policeAndAICConnectBiz.getPolicReqXmp(idNo, custName);
            String reqXml = reqXmlMap.get("reqXml");
            /*String license = reqXmlMap.get("license");
            String url = reqXmlMap.get("url");*/
            String resXml = null;
            try{
                resXml = nciicFacade.nciicCombineSearch(reqXml);
                Map<String, Object> analMap = policeAndAICConnectBiz.getPoliceInfo(resXml, custId);
                respMap.put("returnCode", (String)analMap.get("returnCode"));
                respMap.put("returnMsg", (String)analMap.get("returnMsg"));
                if(!"00".equals(respMap.get("returnCode"))){
                    logger.debug("第一选择没有成功，调用其他渠道");
                    IdCardPhotoRequest request = new IdCardPhotoRequest();
                    request.setIdCardName(custName);
                    request.setIdCardNo(idNo);
                    return getPoliceInfoOtherMethod(request);
                }
                return respMap;
            }catch(Exception e){
                respMap.put("returnCode", "01");
                respMap.put("returnMsg", "查询异常");
                logger.error("调用公安查询接口异常:" + e.getMessage());
                logger.error("发生异常调其他渠道获取公安信息");
                IdCardPhotoRequest request = new IdCardPhotoRequest();
                request.setIdCardName(custName);
                request.setIdCardNo(idNo);
                return getPoliceInfoOtherMethod(request);
            }
            
        
    }
    
    //其他获取公安信息的渠道
    private Map<String, String> getPoliceInfoOtherMethod(IdCardPhotoRequest request){
        Map<String, String> respMap = Maps.newHashMap();
        IdCardPhotoResponse response =  xsCreditFacade.idCardPhotoQuery(request);
        logger.info("调用公安查询返回结果为:" + response.getRc() + "," + response.getMsg());
        if(!"0000".equals(response.getRc())){
            respMap.put("returnCode", "01");
            respMap.put("returnMsg", "查询失败");
            return respMap;
        }
        
            Map<String, Object> insertMap = Maps.newHashMap();


            insertMap.put("custName", request.getIdCardName());
            insertMap
                    .put("idNo", request.getIdCardNo());
            insertMap.put("photo", Objects.firstNonNull(response.getData().getIdCardPhoto(), "").replaceAll("\u0020", "").replaceAll("\r\n", ""));

            insertMap.put("policeCustName", response.getData().getIdCardName());
            insertMap.put("policeIdNo", response.getData().getIdCardCode());
            insertMap.put("result", response.getData().getMessage());
            //先查询表中是否有该用户的公安信息，如果有公安信息，则更新数据
            Map<String, Object> reqMap = Maps.newHashMap();
            reqMap.put("idNo", request.getIdCardNo());
            reqMap.put("custName", request.getIdCardName());
            Date date = new Date();
            if(ListUtil.isNotEmpty(policeAndAICConnectService.queryPoliceInfoList(reqMap))){
                insertMap.put("updateTime", date);
                insertMap.put("queryTime", date);
                policeAndAICConnectService.updatePoliceInfo(insertMap);
            }else{
                insertMap.put("createTime", date);
                insertMap.put("queryTime", date);
                insertMap.put("updateTime", date);
                policeAndAICConnectService.insertPoliceInfo(insertMap);
                
            }
            // 更新用户表
            Map<String, Object> custMap = Maps.newHashMap();
            custMap.put("custName", response.getData().getIdCardName());
            custMap.put("paperId", response.getData().getIdCardCode());
            loanPosCustomerService.updateCustomerInfoMap(custMap);
            respMap.put("returnCode", "00");
            respMap.put("returnMsg", "查询成功");
            return respMap;
    }
}
