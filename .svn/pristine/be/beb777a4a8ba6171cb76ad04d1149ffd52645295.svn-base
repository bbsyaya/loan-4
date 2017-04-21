/**
 * 
 *	哈尔滨银行
 * Copyright (c) 2007-2015 HRBB,Inc.All Rights Reserved.
 */
package com.hrbb.loan.controller;

import java.io.PrintWriter;
import java.math.BigDecimal;
import java.text.ParseException;
import java.util.Date;
import java.util.HashMap;
import java.util.List;

import javax.annotation.Resource;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.apache.commons.lang.StringUtils;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.ModelAndView;

import com.alibaba.fastjson.JSONObject;
import com.hrbb.loan.acct.facade.MadeLoanProcessBizHession;
import com.hrbb.loan.acct.facade.MadeLoanSchdFacade;
import com.hrbb.loan.acct.facade.bean.AddAccSubjectOccurHisReq;
import com.hrbb.loan.acct.facade.bean.AddAccSubjectOccurHisRes;
import com.hrbb.loan.acct.facade.bean.BusiPropQueryReq;
import com.hrbb.loan.acct.facade.bean.BusiPropQueryRes;
import com.hrbb.loan.acct.facade.bean.InvokerPaySucHandlerReq;
import com.hrbb.loan.acct.facade.bean.InvokerPaySucHandlerRes;
import com.hrbb.loan.acct.facade.bean.KeepAcccountsReq;
import com.hrbb.loan.acct.facade.bean.KeepAcccountsRes;
import com.hrbb.loan.acct.facade.bean.MadeLoanLoanLedgerBean;
import com.hrbb.loan.acct.facade.bean.ProcessOccurDayBatchReq;
import com.hrbb.loan.acct.facade.bean.ProcessOccurDayBatchRes;
import com.hrbb.loan.acct.facade.bean.QueryAccSubjectOccSuspendReq;
import com.hrbb.loan.acct.facade.bean.QueryAccSubjectOccSuspendRes;
import com.hrbb.loan.acct.facade.bean.QueryAccSubjectOccurHisReq;
import com.hrbb.loan.acct.facade.bean.QueryAccSubjectOccurHisRes;
import com.hrbb.loan.acct.facade.bean.QueryLoanLedgerInfoReq;
import com.hrbb.loan.acct.facade.bean.QueryLoanLedgerInfoRes;
import com.hrbb.loan.acct.facade.bean.SchedulerReq;
import com.hrbb.loan.acct.facade.bean.SchedulerRes;
import com.hrbb.loan.acctschd.facade.LoanAcctSchdHessian;
import com.hrbb.loan.acctschd.facade.bean.QueryCheckRecordReq;
import com.hrbb.loan.acctschd.facade.bean.QueryCheckRecordRes;
import com.hrbb.loan.pos.util.DateUtil;
import com.hrbb.loan.pos.util.StringUtil;

/**
 * 
 * @author maosheng
 * @version $Id: AcctManagerController.java, v 0.1 2015-7-13 下午4:43:58 maosheng Exp $
 */
@Controller
@RequestMapping("/acctManager")
public class AcctManagerController {
    
    private Logger logger = LoggerFactory.getLogger(PaymentReviewController.class);
    
    /** 核算批量记账接口*/
    @Resource(name="madeLoanSchdFacade")
    private MadeLoanSchdFacade madeLoanSchdFacade;
    
    /** 核算接口*/
    @Resource(name="madeLoanProcessBizHession")
    MadeLoanProcessBizHession madeLoanProcessBizHession;
    
    LoanAcctSchdHessian loanAcctSchdHessian;
    
    /**
     * 核算管理页面
     * 
     * @param req
     * @param res
     * @return
     */
    @RequestMapping("/acctPageNav")
    public ModelAndView acctPageNav(HttpServletRequest req,HttpServletResponse res){
        ModelAndView mav = new ModelAndView();
        mav.setViewName("creditApply/acctPage");  
        return mav;
        
    }
    
    /**
     * 批量记账
     * @param req
     * @param res
     * @return
     */
    @RequestMapping("/batchKeepAccounts")
    public ModelAndView batchKeepAccounts(HttpServletRequest request,HttpServletResponse response){
        ModelAndView mav = new ModelAndView();
        SchedulerReq req = new SchedulerReq();
        req.setTaskId("loanAcctBatchKeepAccountsService");
        SchedulerRes res = null;
        try{
            res = madeLoanSchdFacade.reconciled(req);
            mav.addObject("result", res.getMemo());
        }catch(Exception e){
            logger.error("调用核算批量记账接口失败", e);    
            mav.addObject("result", "调用核算批量记账接口失败");
        }
        mav.setViewName("creditApply/acctPage");
        return mav;        
    }
    
    @RequestMapping("/getAccSubjectOccurHis")
    public ModelAndView getAccSubjectOccurHis(@RequestParam(value = "rows", required = false) Integer pageSize,
                                              @RequestParam(value = "page", required = false) Integer pageNo,
                                              HttpServletRequest request, PrintWriter out){
        QueryAccSubjectOccurHisReq req = new QueryAccSubjectOccurHisReq();
        QueryAccSubjectOccurHisRes res = new QueryAccSubjectOccurHisRes();
        req.setWorkDate(getAcctWorkDate());
        req.setAcStat("0");
        req.setAmt(BigDecimal.ZERO);
        req.setStartPage((pageNo - 1)*pageSize);
        req.setLimit(pageSize);
        List<HashMap<String, Object>> lists = null;
        Integer totalCount = 0; 
        try{
            res= madeLoanSchdFacade.queryAccSubjectOccurHis(req);
            lists = res.getResList();
            totalCount = res.getCount();
            
        }catch(Exception e){
            logger.error("查询账务科目发生额信息失败", e);    
        }
        JSONObject aaJson = new JSONObject();
        if(null != lists && lists.size()>0){
            aaJson.put("total", totalCount);
            aaJson.put("rows", lists);
        }else{
            aaJson.put("total", 0);
            aaJson.put("rows", lists);
        }
        out.write(aaJson.toJSONString());
        
        return null;
        
    }
    
    
    /**
     * 调用核算系统获取workDate
     * @return
     */
    public Date getAcctWorkDate(){
        BusiPropQueryReq busiPropQueryReq = new BusiPropQueryReq();
        busiPropQueryReq.setName("workDate");
        BusiPropQueryRes busiPropQueryRes = madeLoanProcessBizHession.queryBusiProperties(busiPropQueryReq);
        Date workDate = busiPropQueryRes.getWorkDate();
        return workDate;
    }

    /**
     * 分户账信息列表
     * @param req
     * @param res
     * @return
     */
    @RequestMapping("/acctPageOfLedgerList")
    public ModelAndView acctPageLedgerList(HttpServletRequest req,HttpServletResponse res){
        ModelAndView mav = new ModelAndView();
        mav.setViewName("creditApply/pageOfLedgerList");  
        return mav;
    }
    @RequestMapping("/getAcctLedgerListInfo")
    public ModelAndView getAcctLedgerListInfo(
    		@RequestParam(value = "rows", required = false) Integer pageSize,
            @RequestParam(value = "page", required = false) Integer pageNo,
            HttpServletRequest request, PrintWriter out){
    	QueryLoanLedgerInfoRes res = new QueryLoanLedgerInfoRes();
    	QueryLoanLedgerInfoReq req = new QueryLoanLedgerInfoReq();
    	
    	if (!StringUtil.isEmpty(request.getParameter("loanAcNo"))) {
    		req.getLoanAcNos().add(request.getParameter("loanAcNo"));
		}
    	if (!StringUtil.isEmpty(request.getParameter("beginDate"))
    			&&!StringUtil.isEmpty(request.getParameter("endDate"))) {
    		String beginDateString = request.getParameter("beginDate");
    		String endDateString = request.getParameter("endDate");
    		Date beginDate = null;
    		Date endDate = null;
			try {
				beginDate=DateUtil.parse2Date(beginDateString);
				endDate = DateUtil.parse2Date(endDateString);
				req.setRepayDateBegin(beginDate);
				req.setRepayDateEnd(endDate);
			} catch (Exception e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		}
    	req.setCurPage(pageNo);
    	req.setPageSize(pageSize);
    	req.setAcFlag("1");
        
    	List<MadeLoanLoanLedgerBean> lists = null;
    	Long totalCount = 0L;
    	try {
    		res = madeLoanProcessBizHession.queryLoanLegderInfoList(req);
    		lists = res.getResList();
    		totalCount = res.getSum();
		} catch (Exception e) {
			logger.error("查询分户账信息失败", e);
			// TODO: handle exception
		}
    	JSONObject aaJson = new JSONObject();
        if(null != lists && lists.size()>0){
            aaJson.put("total", totalCount);
            aaJson.put("rows", lists);
        }else{
            aaJson.put("total", 0);
            aaJson.put("rows", lists);
        }
        out.write(aaJson.toJSONString());
		return null;
    	
    }
    
    @RequestMapping("/strikeBalancePage")
    public ModelAndView strikeBalancePage(HttpServletRequest request,HttpServletResponse response){
        ModelAndView mav = new ModelAndView();
        mav.setViewName("acctManager/strikeBalancePage"); 
        return mav;
    }
    
    @RequestMapping("/addAccSubjectOccurHis")
    public ModelAndView addAccSubjectOccurHis(HttpServletRequest request,HttpServletResponse response){
        ModelAndView mav = new ModelAndView();
        AddAccSubjectOccurHisReq req = new AddAccSubjectOccurHisReq();
        req.setAcDate(request.getParameter("acDate"));
        req.setAcBankId(request.getParameter("acBankId"));
        req.setAmt(request.getParameter("amt"));
        req.setDebitSubjId(request.getParameter("debitSubjId"));
        req.setCreditSubjId(request.getParameter("creditSubjId"));
        req.setAcStat(request.getParameter("acStat"));
        req.setListType(request.getParameter("listType"));
        req.setListRem(request.getParameter("listRem"));
        req.setOtherListNo(request.getParameter("otherListNo"));
        req.setSeqOrder(request.getParameter("seqOrder"));
        AddAccSubjectOccurHisRes res = null;
        try{
            res = madeLoanSchdFacade.addAccSubjectOccurHis(req);
            mav.addObject("result", res.getMemo());
        }catch(Exception e){
            logger.error("冲账记录增加失败", e);
            mav.addObject("result", "增加冲账记录失败");
        }
        mav.setViewName("acctManager/strikeBalancePage"); 
        return mav;
        
    }
    
    @RequestMapping("/checkRecordPage")
    public ModelAndView checkRecordPage(HttpServletRequest request,HttpServletResponse response){
        ModelAndView mav = new ModelAndView();
        mav.setViewName("acctManager/checkRecordPage"); 
        return mav;
    }
    
    @RequestMapping("/queryCheckRecord")
    public ModelAndView queryCheckRecord(@RequestParam(value = "rows", required = false) Integer pageSize,
                                              @RequestParam(value = "page", required = false) Integer pageNo,
                                              HttpServletRequest request, PrintWriter out){
        QueryCheckRecordReq req = new QueryCheckRecordReq();
        QueryCheckRecordRes res = new QueryCheckRecordRes();
        String trandate = request.getParameter("trandate");
        if(StringUtils.isNotEmpty(trandate)){
            req.setTrandate(trandate.substring(0, 10));
        }       
        req.setStartPage((pageNo - 1)*pageSize);
        req.setLimit(pageSize);
        List<HashMap<String, Object>> lists = null;
        Integer totalCount = 0; 
        try{
            res= loanAcctSchdHessian.queryCreditCheckRecord(req);
            lists = res.getResList();
            totalCount = res.getCount();
            
        }catch(Exception e){
            logger.error("查询账务科目发生额信息失败", e);    
        }
        JSONObject aaJson = new JSONObject();
        if(null != lists && lists.size()>0){
            aaJson.put("total", totalCount);
            aaJson.put("rows", lists);
        }else{
            aaJson.put("total", 0);
            aaJson.put("rows", lists);
        }
        out.write(aaJson.toJSONString());
        
        return null;
        
    }
    
    @RequestMapping("/occurSuspendPage")
    public ModelAndView occurSuspendPage(HttpServletRequest request,HttpServletResponse response){
        ModelAndView mav = new ModelAndView();
        mav.setViewName("acctManager/occurSuspendPage"); 
        return mav;
    }
    
    @RequestMapping("/queryOccurSuspend")
    public ModelAndView queryOccurSuspend(@RequestParam(value = "rows", required = false) Integer pageSize,
                                              @RequestParam(value = "page", required = false) Integer pageNo,
                                              HttpServletRequest request, PrintWriter out){
        QueryAccSubjectOccSuspendReq req = new QueryAccSubjectOccSuspendReq();
        QueryAccSubjectOccSuspendRes res = new QueryAccSubjectOccSuspendRes();
        String acDate = request.getParameter("acDate");
        if(StringUtils.isNotEmpty(acDate)){
            req.setAcDate(acDate.substring(0, 10));
        }       
        req.setStartPage((pageNo - 1)*pageSize);
        req.setLimit(pageSize);
        List<HashMap<String, Object>> lists = null;
        Integer totalCount = 0; 
        try{
            res= madeLoanSchdFacade.queryAccSubjectOccSuspend(req);
            lists = res.getResList();
            totalCount = res.getCount();
            
        }catch(Exception e){
            logger.error("查询账务科目发生额信息失败", e);    
        }
        JSONObject aaJson = new JSONObject();
        if(null != lists && lists.size()>0){
            aaJson.put("total", totalCount);
            aaJson.put("rows", lists);
        }else{
            aaJson.put("total", 0);
            aaJson.put("rows", lists);
        }
        out.write(aaJson.toJSONString());
        
        return null;
        
    }
    
    @RequestMapping("/handleKeepAcccounts")
    public ModelAndView handleKeepAcccounts(HttpServletRequest request,HttpServletResponse response){
        ModelAndView mav = new ModelAndView();
        KeepAcccountsReq req = new KeepAcccountsReq();
        req.setListId(request.getParameter("listId"));
        req.setLoanAcNo(request.getParameter("loanAcNo"));
        req.setWorkDate(new Date());
        KeepAcccountsRes res = null;
        try{
            res = madeLoanSchdFacade.handleKeepAcccounts(req);
            mav.addObject("result", res.getMemo());
        }catch(Exception e){
            logger.error("补发核心记账失败", e);
            mav.addObject("result", "补发核心记账失败");
        }
        mav.setViewName("acctManager/occurSuspendPage"); 
        return mav;
        
    }
    
    
    @RequestMapping("/payoutSucessHandler")
    public ModelAndView payoutSucessHandler(HttpServletRequest request,HttpServletResponse response){
        ModelAndView mav = new ModelAndView();
        InvokerPaySucHandlerReq req = new InvokerPaySucHandlerReq();
        req.setReqSeqNo(request.getParameter("reqSeqNo"));
        req.setWorkDate(request.getParameter("workDate"));
        InvokerPaySucHandlerRes res = null;
        try{
            res = madeLoanSchdFacade.invoker(req);
            mav.addObject("result", res.getMemo());
        }catch(Exception e){
            logger.error("调用放款成功后处理操作失败", e);
            mav.addObject("result", "调用放款成功后处理操作失败");
        }
        mav.setViewName("acctManager/strikeBalancePage"); 
        return mav;
        
    }
    
    @RequestMapping("/batchDataPage")
    public ModelAndView batchDataPage(HttpServletRequest request,HttpServletResponse response){
        ModelAndView mav = new ModelAndView();
        mav.setViewName("acctManager/batchDataPage"); 
        return mav;
        
    }
    @RequestMapping("/queryOccurDayBatch")
    public ModelAndView queryOccurDayBatch(@RequestParam(value = "rows", required = false) Integer pageSize,
                                              @RequestParam(value = "page", required = false) Integer pageNo,
                                              HttpServletRequest request, PrintWriter out){
        ProcessOccurDayBatchReq req = new ProcessOccurDayBatchReq();
        ProcessOccurDayBatchRes res = new ProcessOccurDayBatchRes();
        String acDate = request.getParameter("acDate");
        if(StringUtils.isNotEmpty(acDate)){
            req.setAcDate(acDate.substring(0, 10));
        }       
        req.setStartPage((pageNo - 1)*pageSize);
        req.setLimit(pageSize);
        String recordType = request.getParameter("recordType");
        req.setRecordType(recordType);
        List<HashMap<String, Object>> lists = null;
        Integer totalCount = 0; 
        try{
            res= madeLoanSchdFacade.queryOccurDayBatch(req);
            lists = res.getResList();
            totalCount = res.getCount();
            
        }catch(Exception e){
            logger.error("查询查询批量放款失败的记录错误", e);    
        }
        JSONObject aaJson = new JSONObject();
        if(null != lists && lists.size()>0){
            aaJson.put("total", totalCount);
            aaJson.put("rows", lists);
        }else{
            aaJson.put("total", 0);
            aaJson.put("rows", lists);
        }
        out.write(aaJson.toJSONString());
        
        return null;
        
    }
        
    @RequestMapping("/processOccurDayBatch")
    public ModelAndView processOccurDayBatch(HttpServletRequest request,HttpServletResponse response){
        ModelAndView mav = new ModelAndView();
        ProcessOccurDayBatchReq req = new ProcessOccurDayBatchReq();
        String acDate = request.getParameter("acDate");
        if(StringUtils.isNotEmpty(acDate)){
            req.setAcDate(acDate.substring(0, 10));
        } 
        String recordType = request.getParameter("recordType");
        req.setRecordType(recordType);
        ProcessOccurDayBatchRes res = null;
        try{
            res = madeLoanSchdFacade.processOccurDayBatch(req);
            mav.addObject("result", res.getMemo());
        }catch(Exception e){
            logger.error("补发核心记账失败", e);
            mav.addObject("result", "补发核心记账失败");
        }
        mav.setViewName("acctManager/batchDataPage"); 
        return mav;
        
    }
    
}
