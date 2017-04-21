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
 * @version $Id: CustomerController.java, v 0.1 2015-2-28 下午7:52:55 XLY Exp $
 */
@Controller
@RequestMapping("/customer")
public class CustomerController {

    @Autowired
    private ILoanPosCustomerBackStageBiz loanPosCustomerBizFacade;
    
    @RequestMapping("/queryCustomerInfo")
   public ModelAndView queryCustomerInfo(@RequestParam(value="rows", required = false)Integer pageSize, @RequestParam(value="page", required = false)Integer pageNo,HttpServletRequest request, PrintWriter out){
        Map<String, Object> reqMap = Maps.newHashMap();
        if(!StringUtils.isEmpty(request.getParameter(CustomerInfoConstants.PAPER_ID))){
            reqMap.put(CustomerInfoConstants.PAPER_ID,  request.getParameter(CustomerInfoConstants.PAPER_ID) );
        }
        if(!StringUtils.isEmpty(request.getParameter(CustomerInfoConstants.CUST_NAME))){
            reqMap.put(CustomerInfoConstants.CUST_NAME, ControllerHelper.getLikeString(request.getParameter(CustomerInfoConstants.CUST_NAME)));
        }
        if(!StringUtils.isEmpty(request.getParameter(CustomerInfoConstants.MOBILE_PHONE))){
            reqMap.put(CustomerInfoConstants.MOBILE_PHONE, ControllerHelper.getLikeString(request.getParameter(CustomerInfoConstants.MOBILE_PHONE)));
        }
        reqMap.put("startPage", (pageNo - 1)*pageSize);
        reqMap.put("limit", pageSize);
        List<Map<String, Object>> lists = loanPosCustomerBizFacade.queryCustomerInfo(reqMap);
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
    @RequestMapping("/updatecustomer")
    public ModelAndView updateCustomer(HttpServletRequest request, PrintWriter out){
        User user = (User)request.getSession().getAttribute("USER");
        //获取参数值
        String custId =  request.getParameter("custId");
        String custName = request.getParameter(CustomerInfoConstants.CUST_NAME);
        String busiYear = request.getParameter(CustomerInfoConstants.BUSI_YEAR);
        String contactAddrFlag = request.getParameter(CustomerInfoConstants.CONTACT_ADDR_FALG);
        String inhabStatSign = request.getParameter(CustomerInfoConstants.INHAB_STAT_SIGN);
        String workCorp = request.getParameter(CustomerInfoConstants.WORK_CORP);
        String corpAddr = request.getParameter(CustomerInfoConstants.CORP_ADDR);

        String mobilePhone = request.getParameter(CustomerInfoConstants.MOBILE_PHONE);
        String tel = request.getParameter(CustomerInfoConstants.TEL);
        String weixin = request.getParameter(CustomerInfoConstants.WEIXIN_NO);
        String qqNo = request.getParameter(CustomerInfoConstants.QQ_NO);
        String email = request.getParameter(CustomerInfoConstants.EMAIL);
        String remarks = request.getParameter(CustomerInfoConstants.REMARKS);
        
        String loanPaperId = request.getParameter(CustomerInfoConstants.LOAN_PAPER_ID);
        String loanPaperCheckDate = request.getParameter(CustomerInfoConstants.LOAN_PAPER_CHECK_DATE);
        String localHouseNum = request.getParameter(CustomerInfoConstants.LOCAL_HOUSE_NUM);
        String otherHouseNum = request.getParameter(CustomerInfoConstants.OTHER_HOUSE_NUM);

        String familyCustName = request.getParameter(CustomerInfoConstants.FAMILY_CUST_NAME);
        String mateBirtDate = request.getParameter(CustomerInfoConstants.MATE_BIRT_DATE);
        String matePhone = request.getParameter(CustomerInfoConstants.MATE_MOBILE_PHONE);
        String metaPaperKind = request.getParameter(CustomerInfoConstants.MATE_PAPER_KIND);
        String metaPaperId = request.getParameter(CustomerInfoConstants.MATE_PAPER_ID);

        Map<String, Object> reqMap = Maps.newHashMap();
        if(!StringUtils.isEmpty(custId)){
            reqMap.put(CustomerInfoConstants.CUST_ID, custId);
        }else{
            out.print("error");
            return null;
        }
        reqMap.put(CustomerInfoConstants.LAST_CHAN_PERSON, user.getUserName());
        if(!StringUtils.isEmpty(busiYear))reqMap.put(CustomerInfoConstants.BUSI_YEAR, busiYear);
        if(!StringUtils.isEmpty(contactAddrFlag))reqMap.put(CustomerInfoConstants.CONTACT_ADDR_FALG, contactAddrFlag);
        if(!StringUtils.isEmpty(corpAddr)) reqMap.put(CustomerInfoConstants.CORP_ADDR, corpAddr);
        if(!StringUtils.isEmpty(inhabStatSign)) reqMap.put(CustomerInfoConstants.INHAB_STAT_SIGN, inhabStatSign);
        if(!StringUtils.isEmpty(workCorp)) reqMap.put(CustomerInfoConstants.WORK_CORP, workCorp);
        if(!StringUtils.isEmpty(custName)) reqMap.put(CustomerInfoConstants.CUST_NAME, custName);
        
        if(!StringUtils.isEmpty(mobilePhone))    reqMap.put(CustomerInfoConstants.MOBILE_PHONE, mobilePhone);
        if(!StringUtils.isEmpty(tel))    reqMap.put(CustomerInfoConstants.TEL, tel);
        if(!StringUtils.isEmpty(weixin))    reqMap.put(CustomerInfoConstants.WEIXIN_NO, weixin);
        if(!StringUtils.isEmpty(qqNo))    reqMap.put(CustomerInfoConstants.QQ_NO, qqNo);
        if(!StringUtils.isEmpty(email))    reqMap.put(CustomerInfoConstants.EMAIL, email);
        if(!StringUtils.isEmpty(remarks))    reqMap.put(CustomerInfoConstants.REMARKS, remarks);
 
        if(!StringUtils.isEmpty(loanPaperId))    reqMap.put(CustomerInfoConstants.LOAN_PAPER_ID, loanPaperId);
        if(!StringUtils.isEmpty(loanPaperCheckDate))    reqMap.put(CustomerInfoConstants.LOAN_PAPER_CHECK_DATE, loanPaperCheckDate);
        if(!StringUtils.isEmpty(localHouseNum))    reqMap.put(CustomerInfoConstants.LOCAL_HOUSE_NUM, localHouseNum);
        if(!StringUtils.isEmpty(otherHouseNum))    reqMap.put(CustomerInfoConstants.OTHER_HOUSE_NUM, otherHouseNum);
        
        if(!StringUtils.isEmpty(familyCustName))reqMap.put(CustomerInfoConstants.FAMILY_CUST_NAME, familyCustName);
        if(!StringUtils.isEmpty(mateBirtDate))reqMap.put(CustomerInfoConstants.MATE_BIRT_DATE, mateBirtDate);
        if(!StringUtils.isEmpty(metaPaperKind))reqMap.put(CustomerInfoConstants.MATE_PAPER_KIND, metaPaperKind);
        if(!StringUtils.isEmpty(metaPaperId))reqMap.put(CustomerInfoConstants.MATE_PAPER_ID, metaPaperId);
        if(!StringUtils.isEmpty(matePhone))reqMap.put(CustomerInfoConstants.MATE_MOBILE_PHONE, matePhone);
        
        loanPosCustomerBizFacade.modifyCustomerInfo(reqMap);
        out.print("success");
        return null;
    }
    
    /**
     * 逻辑删除
     * @param request
     * @param out
     * @param deleteItems
     * @return
     */
    @RequestMapping("/deleteCustomer")
    public ModelAndView deleteblacklist(HttpServletRequest request,
            PrintWriter out, @RequestParam(value = "deleteItem", required = false)String deleteItems){
//        User user = (User)request.getSession().getAttribute("USER");
//        String[] blacklistIds = deleteItems.split("[|]");
//        if(blacklistIds == null || blacklistIds.length == 0){
//            out.print("0");
//            return null;
//        }
//        for(String blacklistId : blacklistIds){
//            Map<String, Object> reqMap = Maps.newHashMap();
//            reqMap.put(BlacklistConstants.ID, blacklistId);
//            reqMap.put("modifyTime", new Date());
//            reqMap.put(BlacklistConstants.CONFIRM_USER_ID,  user.getUserId());
//            reqMap.put(BlacklistConstants.CONFIRM_USER, user.getUserName());
//            reqMap.put(BlacklistConstants.DEL_FLAG, BlacklistConstants.DEL_FLAG_DODEL);
//            loanPosCustomerBizFacade.;
//        }
//        
//        out.print("delete success");
        //逻辑删除
        return null;
    }
}
