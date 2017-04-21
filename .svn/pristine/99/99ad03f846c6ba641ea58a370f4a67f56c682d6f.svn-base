/**
 * 
 *	哈尔滨银行
 * Copyright (c) 2007-2015 HRBB,Inc.All Rights Reserved.
 */
package com.hrbb.loan.controller;

import java.io.PrintWriter;
import java.util.List;
import java.util.Map;

import javax.annotation.PostConstruct;
import javax.servlet.http.HttpServletRequest;

import org.apache.commons.collections.CollectionUtils;
import org.apache.commons.lang.StringUtils;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.ModelAndView;

import com.alibaba.fastjson.JSON;
import com.alibaba.fastjson.JSONObject;
import com.google.common.collect.Maps;
import com.hrbb.loan.constants.customer.CustomerInfoConstants;
import com.hrbb.loan.controller.helper.ControllerHelper;
import com.hrbb.loan.pos.biz.backstage.inter.ILoanPosBusinessCodeBiz;
import com.hrbb.loan.pos.biz.backstage.inter.ILoanPosCustomerBackStageBiz;
import com.hrbb.loan.pos.dao.entity.TBankProperties;
import com.hrbb.loan.pos.service.LoanPosCustomerService;
import com.hrbb.loan.pos.util.constants.BusinessDictionaryConstants;

/**
 * 
 * @author XLY
 * @version $Id: CustBankController.java, v 0.1 2015-3-6 下午5:31:12 XLY Exp $
 */
@Controller
@RequestMapping("/custBank")
public class CustBankController {
	
	private Logger logger = LoggerFactory.getLogger(CustBankController.class);  
	
	private List<Map<String, Object>> bankNoList;
    
    @Autowired
    private ILoanPosCustomerBackStageBiz loanPosCustomerBizFacade;
    
    @Autowired
	private ILoanPosBusinessCodeBiz loanPosBusinessCodeBiz;
    
    @Autowired
    private LoanPosCustomerService loanPosCustomerService;
    
    @PostConstruct
	public void loadDictionary(){
    	bankNoList = loanPosBusinessCodeBiz.getItemNames(BusinessDictionaryConstants.BankNo);
    }
    
    @RequestMapping("/queryCustBank")
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
         List<Map<String, Object>> lists = loanPosCustomerBizFacade.queryCustBankInfo(reqMap);
         if(lists!=null && lists.size()>0){
        	 for(Map<String, Object> row:lists){
        		 String displayName = loanPosBusinessCodeBiz.getItemNameByNo("BankNo", (String)row.get("bankName"));
        		 row.put("displayName", displayName);
        	 }
         }
//         Map<String, Object> map = lists.get(lists.size() - 1);
         JSONObject aaJson =  new JSONObject();
//         aaJson.put("total", map.get("total"));
         aaJson.put("total", loanPosCustomerService.selectAccountCount(reqMap));
         aaJson.put("rows", lists);
         out.write(aaJson.toJSONString());
         return null;
     }

     /**
      * <h2>获取dbapp记录</h2>
      * @param pageNo, pageSize
      * @return modelAndView
      */
     @RequestMapping("/updateCustBank")
     public ModelAndView updateCustomer(HttpServletRequest request, PrintWriter out){
//         User user = (User)request.getSession().getAttribute("USER");
         //获取参数值
         String bankAccno = request.getParameter(CustomerInfoConstants.BANK_ACC_NO);
         String bankName = request.getParameter(CustomerInfoConstants.BANK_NAME);
         String bankBranNam = request.getParameter(CustomerInfoConstants.BANK_BRAN_NAME);
         String bankSubbName = request.getParameter(CustomerInfoConstants.BANK_SUBB_NAME);
         String cdtbranchid = request.getParameter(CustomerInfoConstants.BANK_CDTBRANCHID);

         Map<String, Object> reqMap = Maps.newHashMap();
         if(!StringUtils.isEmpty(bankName)){
             reqMap.put(CustomerInfoConstants.BANK_ACC_NO, bankAccno);
         }else{
             out.print("error");
             return null;
         }
         
         if(!StringUtils.isEmpty(bankName))reqMap.put(CustomerInfoConstants.BANK_NAME, bankName);
         if(!StringUtils.isEmpty(bankBranNam)) reqMap.put(CustomerInfoConstants.BANK_BRAN_NAME, bankBranNam);
         if(!StringUtils.isEmpty(bankSubbName)) reqMap.put(CustomerInfoConstants.BANK_SUBB_NAME, bankSubbName);
         if(!StringUtils.isEmpty(cdtbranchid)) reqMap.put(CustomerInfoConstants.BANK_CDTBRANCHID, cdtbranchid);
         try{
        	 loanPosCustomerBizFacade.modifyCustBankInfo(reqMap);
        	 out.print("success");
         }catch(Exception e){
        	 logger.error("更新客户银行卡信息失败!",e);
        	 out.print("error");
         }
         return null;
     }
     
     @RequestMapping("/queryBankProperties")
     public ModelAndView queryBankPropertiesByBankName(@RequestParam(value = "bankName", required = true) String bankName,PrintWriter out){
    	 TBankProperties bankProperties=loanPosCustomerBizFacade.queryBankPropertiesByBankName(bankName);
    	 out.write(JSON.toJSONString(bankProperties));
    	 return null;
     }
     
     @RequestMapping("/queryBankLimit")
     public ModelAndView queryBankLimitById(@RequestParam(value = "bankId", required = true) String bankId,PrintWriter out){
    	 TBankProperties bankProperties=loanPosCustomerBizFacade.queryBankLimitById(bankId);
    	 out.write(JSON.toJSONString(bankProperties));
    	 return null;
     }
     
     /**
      * 修改银行卡信息
      * @param accountNo
      * @param out
      * @return
      */
     @RequestMapping("/modifyBankAccount")
     public ModelAndView modifyBankAccount(@RequestParam(value = "accountNo", required = true) String accountNo,
    		 PrintWriter out){
    	 ModelAndView mav = new ModelAndView();
    	 mav.addObject("bankNoList", bankNoList);
    	 
    	 Map<String, Object> reqMap = Maps.newHashMap();
    	 reqMap.put("bankAccno", accountNo);
    	 List<Map<String, Object>> lists = loanPosCustomerBizFacade.queryCustBankInfo(reqMap);
    	 if(lists!=null && lists.size()>0){
    		 mav.addObject("bankAccount",lists.get(0));
    	 }
    	 mav.setViewName("customer/editCustBank"); 
    	 return mav;
     }
}
