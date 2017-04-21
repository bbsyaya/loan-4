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
@RequestMapping("/custRela")
public class CustRelaController {
    
    @Autowired
    private ILoanPosCustomerBackStageBiz loanPosCustomerBizFacade;
    
    @RequestMapping("/queryCustRelaInfo")
   public ModelAndView queryCustomerInfo(@RequestParam(value="rows", required = false)Integer pageSize, @RequestParam(value="page", required = false)Integer pageNo,HttpServletRequest request, PrintWriter out){
        Map<String, Object> reqMap1 = Maps.newHashMap();
        String custId = "";
        String paperId=request.getParameter(CustomerInfoConstants.PAPER_ID);
        if(!StringUtils.isEmpty(request.getParameter(CustomerInfoConstants.CUST_NAME)) || 
                !StringUtils.isEmpty(request.getParameter(CustomerInfoConstants.PAPER_ID)) ){
            if(!StringUtils.isEmpty(request.getParameter(CustomerInfoConstants.CUST_NAME)))reqMap1.put(CustomerInfoConstants.CUST_NAME,  ControllerHelper.getLikeString(request.getParameter(CustomerInfoConstants.CUST_NAME)) );
            if(!StringUtils.isEmpty(request.getParameter(CustomerInfoConstants.PAPER_ID)))reqMap1.put(CustomerInfoConstants.PAPER_ID,  request.getParameter(CustomerInfoConstants.PAPER_ID));
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
        List<Map<String, Object>> lists = loanPosCustomerBizFacade.queryCustRelaInfo(reqMap);
        Map<String, Object> map = lists.get(lists.size() - 1);
//        lists.remove(lists.size() -1);
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
    @RequestMapping("/updateCustRela")
    public ModelAndView updateCustomer(HttpServletRequest request, PrintWriter out){
        User user = (User)request.getSession().getAttribute("USER");
        //获取参数值
        String relativeId =  request.getParameter("relativeId");
        String relaCustName = request.getParameter(CustomerInfoConstants.RELA_CUST_NAME);
        String relaKind = request.getParameter(CustomerInfoConstants.RELA_KIND);
        String relaMobilephone = request.getParameter(CustomerInfoConstants.RELA_MOBILEPHONE);
        String relaTel = request.getParameter(CustomerInfoConstants.RELA_TEL);

        Map<String, Object> reqMap = Maps.newHashMap();
        if(!StringUtils.isEmpty(relativeId)){
            reqMap.put(CustomerInfoConstants.RELA_ID, relativeId);
        }else{
            out.print("error");
            return null;
        }
        if(!StringUtils.isEmpty(relaCustName))reqMap.put(CustomerInfoConstants.RELA_CUST_NAME, relaCustName);
        if(!StringUtils.isEmpty(relaKind))reqMap.put(CustomerInfoConstants.RELA_KIND, relaKind);
        if(!StringUtils.isEmpty(relaMobilephone)) reqMap.put(CustomerInfoConstants.RELA_MOBILEPHONE, relaMobilephone);
        if(!StringUtils.isEmpty(relaTel)) reqMap.put(CustomerInfoConstants.RELA_TEL, relaTel);
        
        loanPosCustomerBizFacade.modifyCustRelaInfo(reqMap);
        out.print("success");
        return null;
    }
}
