/**
 * 
 *	哈尔滨银行
 * Copyright (c) 2007-2015 HRBB,Inc.All Rights Reserved.
 */
package com.hrbb.loan.controller;

import java.io.PrintWriter;
import java.util.List;
import java.util.Map;

import javax.servlet.http.HttpServletRequest;

import org.apache.commons.collections.CollectionUtils;
import org.apache.commons.lang.StringUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.ModelAndView;

import com.alibaba.fastjson.JSONObject;
import com.google.common.collect.Maps;
import com.hrbb.loan.constants.customer.CustomerInfoConstants;
import com.hrbb.loan.controller.helper.ControllerHelper;
import com.hrbb.loan.pos.biz.backstage.inter.ILoanPosCustomerBackStageBiz;
import com.hrbb.loan.web.security.entity.User;

/**
 * 
 * @author XLY
 * @version $Id: CustRelaController.java, v 0.1 2015-3-6 下午1:35:01 XLY Exp $
 */
@Controller
@RequestMapping("/custMerchant")
public class CustPosCustController {
    
    @Autowired
    private ILoanPosCustomerBackStageBiz loanPosCustomerBizFacade;
    
    @RequestMapping("/queryCustMerchantInfo")
    public ModelAndView queryCustomerInfo(@RequestParam(value="rows", required = false)Integer pageSize, @RequestParam(value="page", required = false)Integer pageNo,HttpServletRequest request, PrintWriter out){
        Map<String, Object> reqMap1 = Maps.newHashMap();
        String custId = "";
        if(!StringUtils.isEmpty(request.getParameter(CustomerInfoConstants.CUST_NAME)) || 
                !StringUtils.isEmpty(request.getParameter(CustomerInfoConstants.PAPER_ID)) ||
                !StringUtils.isEmpty(request.getParameter(CustomerInfoConstants.CUST_ID)) 
                ){
            if(!StringUtils.isEmpty(request.getParameter(CustomerInfoConstants.CUST_NAME)))reqMap1.put(CustomerInfoConstants.CUST_NAME,  ControllerHelper.getLikeString(request.getParameter(CustomerInfoConstants.CUST_NAME)) );
            if(!StringUtils.isEmpty(request.getParameter(CustomerInfoConstants.PAPER_ID)))reqMap1.put(CustomerInfoConstants.PAPER_ID,  request.getParameter(CustomerInfoConstants.PAPER_ID));
            if(!StringUtils.isEmpty(request.getParameter(CustomerInfoConstants.CUST_ID)))reqMap1.put(CustomerInfoConstants.CUST_ID,  request.getParameter(CustomerInfoConstants.CUST_ID));
            List<Map<String, Object>> lists1 = loanPosCustomerBizFacade.queryCustomerInfo(reqMap1);
            if (CollectionUtils.isNotEmpty(lists1)) {
                custId = (String)( lists1.get(0).get("custId"));
            }
        }
        Map<String, Object> reqMap = Maps.newHashMap();
        if(!StringUtils.isEmpty(custId)){
            reqMap.put(CustomerInfoConstants.CUST_ID,  custId);
        }
        reqMap.put("startPage", (pageNo - 1)*pageSize);
        reqMap.put("limit", pageSize);
        List<Map<String, Object>> lists = loanPosCustomerBizFacade.queryCustMerchantInfo(reqMap);
        Map<String, Object> map = lists.get(lists.size() - 1);
        JSONObject aaJson =  new JSONObject();
        aaJson.put("total", map.get("total"));
        aaJson.put("rows", lists);      
        out.write(aaJson.toJSONString());
        return null;
    }

    /**
     * <h2>获取dbapp记录</h2>
     * @param pageNo, pageSize
     * @return modelAndView
     */
    @RequestMapping("/updateCustMerchant")
    public ModelAndView updateCustomer(HttpServletRequest request, PrintWriter out){
        User user = (User)request.getSession().getAttribute("USER");

        String posCustId =  request.getParameter("posCustId");
        String posCustName = request.getParameter(CustomerInfoConstants.POS_CUST_NAME);
        String busiDivision = request.getParameter(CustomerInfoConstants.BUSI_DIVISION);
        String operName = request.getParameter(CustomerInfoConstants.OPRE_NAME);
        String operDate = request.getParameter(CustomerInfoConstants.OPER_DATE);
        String posCustBusiScope =  request.getParameter(CustomerInfoConstants.POS_CUST_BUSI_SCOPE);
        String posCustAddress = request.getParameter(CustomerInfoConstants.POS_CUST_ADDRESS);
        String operAddrCode = request.getParameter(CustomerInfoConstants.OPER_ADDR_CODE);
        String industryTypeId = request.getParameter(CustomerInfoConstants.INDUSTRY_TYPE_ID);
        String industryTypeId2 = request.getParameter(CustomerInfoConstants.INDUSTRY_TYPE_ID2);
        String regiCode = request.getParameter(CustomerInfoConstants.REGI_CODE);

        Map<String, Object> reqMap = Maps.newHashMap();
        if(!StringUtils.isEmpty(posCustId)){
            reqMap.put(CustomerInfoConstants.POS_CUST_ID, posCustId);
        }else{
            out.print("error");
            return null;
        }
        if(!StringUtils.isEmpty(posCustName))reqMap.put(CustomerInfoConstants.POS_CUST_NAME, posCustName);
        if(!StringUtils.isEmpty(busiDivision)) reqMap.put(CustomerInfoConstants.BUSI_DIVISION, busiDivision);
        if(!StringUtils.isEmpty(operName)) reqMap.put(CustomerInfoConstants.OPRE_NAME, operName);
        if(!StringUtils.isEmpty(operDate))reqMap.put(CustomerInfoConstants.OPER_DATE, operDate);
        if(!StringUtils.isEmpty(posCustBusiScope))reqMap.put(CustomerInfoConstants.POS_CUST_BUSI_SCOPE, posCustBusiScope);
        if(!StringUtils.isEmpty(posCustAddress)) reqMap.put(CustomerInfoConstants.POS_CUST_ADDRESS, posCustAddress);
        if(!StringUtils.isEmpty(operAddrCode)) reqMap.put(CustomerInfoConstants.OPER_ADDR_CODE, operAddrCode);
        if(!StringUtils.isEmpty(industryTypeId))reqMap.put(CustomerInfoConstants.INDUSTRY_TYPE_ID, industryTypeId);
        if(!StringUtils.isEmpty(industryTypeId2))reqMap.put(CustomerInfoConstants.INDUSTRY_TYPE_ID2, industryTypeId2);
        if(!StringUtils.isEmpty(regiCode)) reqMap.put(CustomerInfoConstants.REGI_CODE, regiCode);
        
        loanPosCustomerBizFacade.modifyCustMerchantInfo(reqMap);
        out.print("success");
        return null;
    }
}
