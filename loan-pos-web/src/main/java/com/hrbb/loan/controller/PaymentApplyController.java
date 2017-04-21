package com.hrbb.loan.controller;

import java.io.PrintWriter;
import java.math.BigDecimal;
import java.text.ParseException;
import java.util.List;
import java.util.Map;

import javax.annotation.PostConstruct;
import javax.servlet.http.HttpServletRequest;

import org.apache.commons.lang.StringUtils;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.ModelAndView;

import com.alibaba.fastjson.JSONObject;
import com.google.common.collect.Maps;
import com.hrbb.loan.constants.CreditApplyConstants;
import com.hrbb.loan.constants.PaymentApplyConstants;
import com.hrbb.loan.controller.helper.ControllerHelper;
import com.hrbb.loan.pos.biz.backstage.inter.ILoanPosBusinessCodeBiz;
import com.hrbb.loan.pos.biz.backstage.inter.IPaymentApplyBiz;
import com.hrbb.loan.pos.biz.backstage.inter.IPaymentApplyCheckBiz;
import com.hrbb.loan.pos.biz.backstage.inter.IReceiptManageBiz;
import com.hrbb.loan.pos.biz.backstage.inter.LoanPosContractManagementBiz;
import com.hrbb.loan.pos.dao.entity.TBankAccnoInfo;
import com.hrbb.loan.pos.dao.entity.TContractManagement;
import com.hrbb.loan.pos.dao.entity.TCustomer;
import com.hrbb.loan.pos.dao.entity.TPaymentApply;
import com.hrbb.loan.pos.dao.entity.TPaymentApplyApproval;
import com.hrbb.loan.pos.dao.entity.TReceiptInfo;
import com.hrbb.loan.pos.service.IGenericConfigService;
import com.hrbb.loan.pos.service.LoanPosCreditApplyService;
import com.hrbb.loan.pos.service.LoanPosCustomerService;
import com.hrbb.loan.pos.service.PaymentApplyApprovalService;
import com.hrbb.loan.pos.service.ReceiptInfoService;
import com.hrbb.loan.pos.util.DateUtil;
import com.hrbb.loan.pos.util.StringUtil;
import com.hrbb.loan.pos.util.constants.BusinessDictionaryConstants;
import com.hrbb.loan.web.security.entity.User;

/**
 * 用款业务
 * 
 * @author jianQing
 * @version $Id: PaymentApplyController.java, v 0.1 2015年4月17日 下午2:35:56 jianQing Exp $
 */
@Controller
@RequestMapping("/paymentApply")
public class PaymentApplyController {
    private Logger logger = LoggerFactory.getLogger(PaymentApplyController.class);
    
    @Autowired
    private IPaymentApplyBiz paymentApplyBiz ;
    
    @Autowired
    private IGenericConfigService genericConfigService;
    
    @Autowired
    private ILoanPosBusinessCodeBiz loanPosBusinessCodeBiz;
    
    @Autowired
    private IPaymentApplyCheckBiz paymentApplyCheckBiz;
    
    @Autowired
    private LoanPosContractManagementBiz loanPosContractManagementBiz;
    
    @Autowired
	private LoanPosCustomerService loanPosCustomerService;
    
    @Autowired
    private PaymentApplyApprovalService paymentApplyApprovalService;
    
    @Autowired
	private LoanPosCreditApplyService loanPosCreditApplyService;
    
    @Autowired
    private ReceiptInfoService receiptInfoService;
    
    @Autowired
    private IReceiptManageBiz receiptManageBiz;
    
	private List<Map<String, Object>> paperList;
	
	private List<Map<String, Object>> currSignList;
	
	private List<Map<String, Object>> returnKindList;
	
	private List<Map<String, Object>> sexList;
	
	private List<Map<String, Object>> maritalList;
	
	private List<Map<String, Object>> eduList;
	
	private List<Map<String, Object>> relList;
	
	private List<Map<String, Object>> cities;
	
	private List<Map<String, Object>> divisions;
	
	private List<Map<String, Object>> bankNoList;
	
	private List<Map<String, Object>> implTypeList;
	
	private List<Map<String, Object>> repayMethodList;
	
	private List<Map<String, Object>> contactFlags;
	
//	private List<Map<String, Object>> payChannelList;	/*支付通道*/
	
	private List<Map<String, Object>> provinceList;
	
    @PostConstruct
	public void loadDictionary(){
		Map<String, Object> reqMap = Maps.newHashMap();
		reqMap.put("codeNo", BusinessDictionaryConstants.AdminDivision);		//add by Lin,Zhaolin
		reqMap.put(CreditApplyConstants.ITEMN_NO_LIKE, "____00");
		reqMap.put(CreditApplyConstants.ITEM_NO_NOT_LIKE, "__0000");
		cities = loanPosBusinessCodeBiz.getSeletiveMap(reqMap);
		reqMap = Maps.newHashMap();
		reqMap.put("codeNo", BusinessDictionaryConstants.AdminDivision);		//add by Lin,Zhaolin
		reqMap.put(CreditApplyConstants.ITEMN_NO_LIKE, "______");
		reqMap.put(CreditApplyConstants.ITEM_NO_NOT_LIKE, "__0000");
		reqMap.put(CreditApplyConstants.ITEM_NO_NOT_LIKE_2, "____00");
		divisions = loanPosBusinessCodeBiz.getSeletiveMap(reqMap);
		paperList = loanPosBusinessCodeBiz.getItemNames(BusinessDictionaryConstants.CertType);
		currSignList = loanPosBusinessCodeBiz.getItemNames(BusinessDictionaryConstants.Currency);
		returnKindList = loanPosBusinessCodeBiz.getItemNames(BusinessDictionaryConstants.AccrualType);
		sexList = loanPosBusinessCodeBiz.getItemNames(BusinessDictionaryConstants.Sex);
		maritalList = loanPosBusinessCodeBiz.getItemNames(BusinessDictionaryConstants.Marital);
		eduList = loanPosBusinessCodeBiz.getItemNames(BusinessDictionaryConstants.Education);
		relList = loanPosBusinessCodeBiz.getItemNames(BusinessDictionaryConstants.Relationship);
		bankNoList = loanPosBusinessCodeBiz.getItemNames(BusinessDictionaryConstants.BankNo);
		implTypeList = loanPosBusinessCodeBiz.getItemNames(BusinessDictionaryConstants.ImplType);
		repayMethodList = loanPosBusinessCodeBiz.getItemNames(BusinessDictionaryConstants.RepayMethod);
		contactFlags = loanPosBusinessCodeBiz.getItemNames(BusinessDictionaryConstants.CONTACT_ADDRESS);
//		payChannelList = loanPosBusinessCodeBiz.getItemNames(BusinessDictionaryConstants.CODE_PAYCHANNEL);
		provinceList = loanPosBusinessCodeBiz.getProvinceCityOrDic("__0000");
	}
    
    /**
     * 查詢用款申請
     * 
     * @param pageSize 页容量
     * @param pageNo   页码
     * @param request  请求
     * @param out  输出流
     * @return
     */
    @RequestMapping("/queryPaymentApply")
    public ModelAndView queryPaymentApply(
    		@RequestParam(value = "paymentStatus", required=false)String paymentStatus,
 		   	@RequestParam(value = "excuteStatus", required=false)String excuteStatus, 
            @RequestParam(value = "rows", required = false) Integer pageSize,
            @RequestParam(value = "page", required = false) Integer pageNo,
            HttpServletRequest request, PrintWriter out) {
        Map<String, Object> reqMap = Maps.newHashMap();
        //合同编号
        if (!StringUtils.isEmpty(request
                .getParameter(PaymentApplyConstants.CONTNO_LIKE))) {
            reqMap.put(PaymentApplyConstants.CONTNO_LIKE, ControllerHelper
                    .getLikeString(request
                            .getParameter(PaymentApplyConstants.CONTNO_LIKE)));
        }
        //商户名称
        if (!StringUtils.isEmpty(request
                .getParameter(PaymentApplyConstants.POS_CUST_NAME_LIKE))) {
            reqMap.put(PaymentApplyConstants.POS_CUST_NAME_LIKE, ControllerHelper
                    .getLikeString(request
                            .getParameter(PaymentApplyConstants.POS_CUST_NAME_LIKE)));
        }
        //客户名称
        if(!StringUtils.isEmpty(request
                .getParameter(PaymentApplyConstants.CUST_NAME_LIKE))){
            reqMap.put(PaymentApplyConstants.CUST_NAME_LIKE, ControllerHelper
                .getLikeString(request.getParameter(PaymentApplyConstants.CUST_NAME_LIKE)));
        
        // 证件号码
        if(!StringUtils.isEmpty(request
                .getParameter(PaymentApplyConstants.PAPER_ID_LIKE))){
            reqMap.put(PaymentApplyConstants.PAPER_ID_LIKE, ControllerHelper
                .getLikeString(request.getParameter(PaymentApplyConstants.PAPER_ID_LIKE)));}
        }
        
        if(!StringUtils.isEmpty(paymentStatus) && !paymentStatus.equals("99")){		//全量查询是不区分状态
	        // 申请状态
	        if(!StringUtils.isEmpty(request.getParameter("paymentStatus"))){
	            reqMap.put(PaymentApplyConstants.status,request.getParameter("paymentStatus"));
	        }
	        // 放款状态
	        if(!StringUtils.isEmpty(request.getParameter("excuteStatus"))){
	            reqMap.put("excuteStatus",request.getParameter("excuteStatus"));
	        }
        }
        reqMap.put("startPage", (pageNo - 1) * pageSize);
        reqMap.put("pageSize", pageSize);
        List<Map<String, Object>> lists = paymentApplyBiz.queryPaymentApply(reqMap);
        JSONObject aaJson = new JSONObject();
        if(lists != null && lists.size()>0){
            //获取总数map
            Map<String,Object> map = lists.get(lists.size()-1);
            lists.remove(lists.size()-1);
            aaJson.put("rows", lists);
            aaJson.put("total", map.get("total"));
        }else{
            aaJson.put("rows", lists);
            aaJson.put("total", 0);
        }
        out.write(aaJson.toJSONString());  
        return null;
    }
    
    
    /**
     * 增加用款申请
     * 
     * @param request
     * @param out
     * @return
     */
    @RequestMapping("/savePaymentApply")
    public ModelAndView savePaymentApply(HttpServletRequest request, PrintWriter out) {
        //合同号
        String contNo = request.getParameter(PaymentApplyConstants.contNo);
        //用款金额
        String payApplyAmt = request.getParameter(PaymentApplyConstants.payApplyAmt);
        //用款期限
        String payApplyTerm = request.getParameter(PaymentApplyConstants.payApplyTerm);
        //用款利率
        String payApplyInterest = request.getParameter(PaymentApplyConstants.payApplyInterest);
        //期待用款日期
        String expectedDate = request.getParameter(PaymentApplyConstants.expectedDate);
        //期待用款结束日
        String expectedEndDate = request.getParameter(PaymentApplyConstants.expectedEndDate);
        //还款方式
        String returnType = request.getParameter(PaymentApplyConstants.returnType);
        //用款账号
        String accNo = request.getParameter(PaymentApplyConstants.accNo);
        Map<String, Object> reqMap = Maps.newHashMap();
        if(!StringUtils.isEmpty(contNo)){
            reqMap.put(PaymentApplyConstants.contNo, contNo);
        }
        if(!StringUtils.isEmpty(payApplyAmt)){
            reqMap.put(PaymentApplyConstants.payApplyAmt, payApplyAmt);
        }
        if(!StringUtils.isEmpty(payApplyTerm)){
            reqMap.put(PaymentApplyConstants.payApplyTerm, payApplyTerm);
        }
        if(!StringUtils.isEmpty(payApplyInterest)){
            reqMap.put(PaymentApplyConstants.payApplyInterest, payApplyInterest);
        }
        if(!StringUtils.isEmpty(expectedDate)){
            reqMap.put(PaymentApplyConstants.expectedDate, expectedDate);
        }
        if(!StringUtils.isEmpty(expectedEndDate)){
            reqMap.put(PaymentApplyConstants.expectedEndDate, expectedEndDate);
        }
        if(!StringUtils.isEmpty(returnType)){
            reqMap.put(PaymentApplyConstants.returnType, returnType);
        }
        if(!StringUtils.isEmpty(accNo)){
            reqMap.put(PaymentApplyConstants.accNo, accNo);
        }
        try{
            paymentApplyBiz.insertPaymentApplyZJ(reqMap);
            out.print("新增用款申请成功");
        } catch (Exception e) {
            logger.error("新增用款申请异常" , e);
            out.print("新增用款申请失败,系统异常！");
        }
        return null;
    }
    /**
     * 提交用款审核
     * 
     * @param payApplyId
     * @param out
     * @return
     */
    @RequestMapping("/submitPaymentApply")
    public ModelAndView submitPaymentApply(@RequestParam(value="payApplyId",required=false) String payApplyId,PrintWriter out){
        logger.info("payApplyId = " + payApplyId);
        Map<String, Object> reqMap = Maps.newHashMap();
        reqMap.put("payApplyId", payApplyId);
        reqMap.put("status", "10");
        try {
            Map<String,Object> respMap = paymentApplyCheckBiz.paymentApplyCheck(payApplyId);
            logger.info("respMap = " + respMap);
            if(respMap.get("respCode") != null && "000".equals(respMap.get("respCode"))){
                paymentApplyBiz.updatePaymentApply(reqMap);
                out.print("提交审核成功");
            }else{
                out.print("提交审核失败，"+respMap.get("respMsg"));
            }
        } catch (Exception e) {
            logger.error("用款提交失败", e);
            out.print("用款提交审核失败");
        }
        return null;
        
    }
    /**
     * 取消用款
     * 
     * @param cancelPayApplyId
     * @param out
     * @return
     */
    @RequestMapping("/cancelPaymentApply")
    public ModelAndView cancelPaymentApply(@RequestParam(value="cancelPayApplyId",required=false)String cancelPayApplyId,PrintWriter out){
        Map<String, Object> reqMap = Maps.newHashMap();
        reqMap.put("payApplyId", cancelPayApplyId);
        reqMap.put("status", "93");
        try {
            paymentApplyBiz.updatePaymentApply(reqMap);
            out.print("取消用款成功");
        } catch (Exception e) {
            logger.error("取消用款失败", e);
            out.print("取消用款失败");
        }
        return null;
    }
    
    /**
     * 计算日期,考虑到还款方式对到期日的影响
     * 
     * @param expectedDate
     * @param payApplyTerm
     * @param out
     * @return
     */
    @RequestMapping("/calculateDate")
    public ModelAndView calculateDate(@RequestParam(value="expectedDate",required=true) String expectedDate,
                                      @RequestParam(value="payApplyTerm",required=true) int payApplyTerm,
                                      @RequestParam(value="paybackMethod",required=true) String paybackMethod,
                                      PrintWriter out){
        if(!StringUtil.isEmpty(expectedDate) && payApplyTerm > 0){
            try {
                String expectedEndDate = DateUtil.getRelativeDate(expectedDate, 0, payApplyTerm, -1);
                if(paybackMethod!=null && paybackMethod.equals("90")){
                	//加入对周末和节假日的延后处理 add by Lin,Zhaolin at 2015-5-27
                	String workingDate = genericConfigService.getNextWorkingDate(DateUtil.parse2Date(expectedEndDate));
                	out.print(workingDate);
                }else{
                	out.print(expectedEndDate);
                }
            } catch (ParseException e) {
                logger.error("日期转换错误", e);
                return null;
            }
        }
        return null;
    }
    
    /**
     * 计算标准的到期日,不考虑节假日影像 
     * @param expectedDate
     * @param payApplyTerm
     * @param paybackMethod
     * @param out
     * @return
     */
    @RequestMapping("/calculateStdMaturity")
    public ModelAndView calculateStdMaturity(@RequestParam(value="calcDateFrom",required=true) String calcDateFrom,
                                      @RequestParam(value="calcTerm",required=true) int calcTerm,
                                      PrintWriter out){
        if(!StringUtil.isEmpty(calcDateFrom) && calcTerm > 0){
            try {
                String expectedEndDate = DateUtil.getRelativeDate(calcDateFrom, 0, calcTerm, -1);
                out.print(expectedEndDate);
            } catch (ParseException e) {
                logger.error("日期转换错误", e);
                return null;
            }
        }
        return null;
    }
    
    /**
     * 查詢用款申請
     * 
     * @param pageSize 页容量
     * @param pageNo   页码
     * @param request  请求
     * @param out  输出流
     * @return
     */
    @RequestMapping("/queryAvailableClaimPaymentApply")
    public ModelAndView queryAvailableClaimPaymentApply(
            @RequestParam(value = "rows", required = false) Integer pageSize,
            @RequestParam(value = "page", required = false) Integer pageNo,
            HttpServletRequest request, PrintWriter out) {
        Map<String, Object> reqMap = Maps.newHashMap();
        //合同编号
        if (!StringUtils.isEmpty(request
                .getParameter(PaymentApplyConstants.CONTNO_LIKE))) {
            reqMap.put(PaymentApplyConstants.CONTNO_LIKE, ControllerHelper
                    .getLikeString(request
                            .getParameter(PaymentApplyConstants.CONTNO_LIKE)));
        }
        //商户名称
        if (!StringUtils.isEmpty(request
                .getParameter(PaymentApplyConstants.POS_CUST_NAME_LIKE))) {
            reqMap.put(PaymentApplyConstants.POS_CUST_NAME_LIKE, ControllerHelper
                    .getLikeString(request
                            .getParameter(PaymentApplyConstants.POS_CUST_NAME_LIKE)));
        }
        //客户名称
        if(!StringUtils.isEmpty(request
                .getParameter(PaymentApplyConstants.CUST_NAME_LIKE))){
            reqMap.put(PaymentApplyConstants.CUST_NAME_LIKE, ControllerHelper
                .getLikeString(request.getParameter(PaymentApplyConstants.CUST_NAME_LIKE)));
        
        //证件号码
        if(!StringUtils.isEmpty(request
                .getParameter(PaymentApplyConstants.PAPER_ID_LIKE))){
            reqMap.put(PaymentApplyConstants.PAPER_ID_LIKE, ControllerHelper
                .getLikeString(request.getParameter(PaymentApplyConstants.PAPER_ID_LIKE)));}
        }
        if(!StringUtils.isEmpty(request.getParameter("paymentStatus"))){
            reqMap.put(PaymentApplyConstants.status,request.getParameter("paymentStatus"));
        }
        reqMap.put("startPage", (pageNo - 1) * pageSize);
        reqMap.put("pageSize", pageSize);
        List<Map<String, Object>> lists = paymentApplyBiz.queryAvailablePaymentApply(reqMap);
        JSONObject aaJson = new JSONObject();
        if(lists != null && lists.size()>0){
            //获取总数map
            Map<String,Object> map = lists.get(lists.size()-1);
            lists.remove(lists.size()-1);
            aaJson.put("rows", lists);
            aaJson.put("total", map.get("total"));
        }else{
            aaJson.put("rows", lists);
            aaJson.put("total", 0);
        }
        out.write(aaJson.toJSONString());  
        return null;
    }
    
    /**
     * 用款详情
     * @param payApplyId
     * @param direct2Path
     * @return
     */
    @RequestMapping("/openDetailPaymentApply")
    public ModelAndView openDetailPaymentApply(@RequestParam(value="payApplyId",required=false) String payApplyId,
    		@RequestParam(value="direct2Path",required=false)String direct2Path,
    		HttpServletRequest request){
        ModelAndView mav = new ModelAndView();
        TPaymentApply paymentApply = new TPaymentApply();
        TContractManagement contractManagement = new TContractManagement();
        TCustomer customer = new TCustomer();
        //List<Map<String,Object>> creditApplyMap = new ArrayList<Map<String,Object>>();
        String channelName = "";
        String paybackMethodName = "";
//        String expectedEndDate = "";
        String openBankName = "";
        /*审核意见对象*/
//        Map<String,Object> apprOpinion = Maps.newHashMap();
        
        if(!StringUtil.isEmpty(payApplyId)){
            paymentApply = paymentApplyBiz.queryPaymentApplyById(payApplyId);
            
            User user = (User) request.getSession().getAttribute("USER");
            Map<String,Object> reqPayAppr = Maps.newHashMap();
            reqPayAppr.put("payApplyId", payApplyId);
            reqPayAppr.put("userName", user.getUserName());
            
            /*用款审批信息*/
            TPaymentApplyApproval payAppr = paymentApplyApprovalService.selectApprOpinion(reqPayAppr,paymentApply);
            /*设置宽限期和期次的默认值，作为预留入口*/
            payAppr.setGraceDays(3);
            if(paymentApply.getReturnType().equals("90")){		//利随本清默认1
            	payAppr.setScheduleTimes(1);
            }else{
            	//按月等额本息 10
            	payAppr.setScheduleTimes(Integer.valueOf(paymentApply.getPayApplyTerm()).intValue());
            }
            mav.addObject("payApprOpinion", payAppr);
            
            /*支付通道*/
            List<Map<String,Object>> payChannelList = null;
            Map<String,Object> reqMap = Maps.newHashMap();
            reqMap.put("codeNo", BusinessDictionaryConstants.CODE_PAYCHANNEL);
            if(paymentApply.getPayApplyAmt().compareTo(new BigDecimal(50000))>0){		//5万以上走大额支付.5万以下走小额
            	reqMap.put("extAttrLike", "%大额%");
            }else{
            	reqMap.put("extAttrLike", "%小额%");
            }
            payChannelList = loanPosBusinessCodeBiz.getSeletiveMap(reqMap);
            mav.addObject("payChannelList", payChannelList);
        }
        
        String contNo = paymentApply.getContNo();
        if(!StringUtil.isEmpty(contNo)){
            // 协议信息
            contractManagement = loanPosContractManagementBiz.getContractByContNo(contNo);
            contractManagement.getChannel();
            channelName = loanPosBusinessCodeBiz.getItemNameByNo("BizChannel", contractManagement.getChannel());
            paybackMethodName = loanPosBusinessCodeBiz.getItemNameByNo("AccrualType", contractManagement.getPaybackMethod());
            openBankName = loanPosBusinessCodeBiz.getItemNameByNo("BankNo", contractManagement.getAccountOpenBank());
            // 申请信息		//comment by Lin,Zhaolin
            //if(!StringUtil.isEmpty(contractManagement.getLoanId())){
            //    creditApplyMap = loanPosCreditApplyBackStageBiz.getCreditApplyDetail(contractManagement.getLoanId());
            //}
            String bankAccount = contractManagement.getAcceptAccount();
            TBankAccnoInfo account = loanPosCreditApplyService.selectByBankAccno(bankAccount);
            if(account!=null){
            	mav.addObject("bankAccount", account);
            }
        }
        //get customerinfo from db, add by Lin,Zhaolin
        String residentDetail = "";
        if(!StringUtil.isEmpty(contractManagement.getCustId())){
        	customer = loanPosCustomerService.getCustumerInfoById(contractManagement.getCustId());
        	//逆序确认行政区划  区县-->城市-->省
        	String residentDivision = customer.getResidentDivision()!=null?customer.getResidentDivision():(customer.getResidentCity()!=null?customer.getResidentCity():customer.getResidentProv());
        	String divisionName = loanPosBusinessCodeBiz.getExtAttrByNo("AdminDivision", residentDivision);
        	residentDetail = (divisionName==null?"":divisionName)+" "+(customer.getResidentDetail()==null?"":customer.getResidentDetail());
        }
        //add End
        
        /*get receipt info*/
        TReceiptInfo receipt = receiptInfoService.selectReceiptOne(payApplyId);
        if(receipt!=null){
        	 mav.addObject("transferStatus",receipt.getLoanExecuteStatus());
        }
        
        //calculate availableBalance , add by cjq 20150825
        BigDecimal sum = (receiptManageBiz.sumLoanTotalBalance(contNo)) == null ? BigDecimal.ZERO
            : new BigDecimal(receiptManageBiz.sumLoanTotalBalance(contNo));
        BigDecimal availableBalance = contractManagement.getCreditLine().subtract(sum);
        mav.addObject("availableBalance",availableBalance);
        //end by cjq
        
        mav.addObject("contract", contractManagement);
        mav.addObject("paymentApply",paymentApply);
        mav.addObject("customer",customer);
        //mav.addObject("creditApplyMap",creditApplyMap);		//comment by Lin,Zhaolin
        mav.addObject("payApplyId",payApplyId);
        mav.addObject("channelName",channelName);
        mav.addObject("paybackMethodName",paybackMethodName);
        mav.addObject("openBankName",openBankName);
//        mav.addObject("expectedEndDate",expectedEndDate);		//comment by Lin,Zhaolin
        mav.addObject("paperList", paperList);
        mav.addObject("returnKindList", returnKindList);
        mav.addObject("currSignList", currSignList);
        mav.addObject("sexList", sexList);
        mav.addObject("maritalList", maritalList);
        mav.addObject("eduList", eduList);
        mav.addObject("relList", relList);
        mav.addObject("cities", cities);
        mav.addObject("divisions", divisions);
        mav.addObject("bankNoList", bankNoList);
        mav.addObject("implTypeList", implTypeList);
        mav.addObject("repayMethodList", repayMethodList);
        mav.addObject("contactFlags", contactFlags);	//add by Lin,Zhaolin
        mav.addObject("residentDetail", residentDetail);
        
        mav.addObject("province", provinceList);
        mav.setViewName(direct2Path);
        return mav;
    }
    
}

