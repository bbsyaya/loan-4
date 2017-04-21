package com.hrbb.loan.spi.ZZ;

import java.math.BigDecimal;
import java.util.Date;
import java.util.Iterator;
import java.util.Map;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.google.common.collect.Maps;
import com.hrbb.loan.acct.facade.MadeLoanProcessBizHession;
import com.hrbb.loan.acct.facade.bean.CalcRamtReq;
import com.hrbb.loan.acct.facade.bean.CalcRamtRes;
import com.hrbb.loan.acct.facade.bean.MadeLoanLoanLedgerBean;
import com.hrbb.loan.pos.dao.entity.TReceiptInfo;
import com.hrbb.loan.pos.service.LoanPosPaybackService;
import com.hrbb.loan.pos.service.ReceiptInfoService;
import com.hrbb.loan.pos.util.StringUtil;
import com.hrbb.loan.spiconstants.HServiceReturnCode;
import com.hrbb.loan.spiconstants.PaymentApplyHServiceConstants;
import com.hrbb.sh.framework.HResponse;
import com.hrbb.sh.framework.HServiceException;

/**
 * TransType:AP0010 -> 还款试算服务接口.
 * 
 * @author xiongshaogang
 * @version $Id: ZZAPPRepaymentTryCalculateServiceImpl.java, v 0.1 2015年4月29日 下午1:36:59 xiongshaogang Exp $
 */
@Service("zzAppRepaymentTryCalculate")
public class ZZAPPRepaymentTryCalculateServiceImpl extends ZZAPPFoundationServiceImpl {
    
	Logger logger = LoggerFactory.getLogger(ZZAPPRepaymentTryCalculateServiceImpl.class);
	
	@Autowired
	private ReceiptInfoService receiptInfoService;
	
	@Autowired
    private MadeLoanProcessBizHession madeLoanProcessBizHession;
	
	@Autowired
    private LoanPosPaybackService loanPosPaybackService;
	
	@Override
	protected HResponse doProcesser(HResponse resp, Map<String, String> headerMap,
                                    Map<String, String> bodyMap) throws HServiceException {
	    
	    logger.debug("in ZZAPPRepaymentTryCalculateServiceImpl...");
	    
        // 1. 查询借据
        TReceiptInfo tReceiptInfo = receiptInfoService.selectReceiptOne(bodyMap.get("payapplyid"));
        if (tReceiptInfo == null) {
//        if (tReceiptInfo == null || StringUtil.isEmpty(tReceiptInfo.getLoanAcNo())) {
            logger.error("试算接口异常，借据不存在!");
            bodyMap.put("respcode", HServiceReturnCode.LISTID_REPAY_ERROR.getReturnCode());
            bodyMap.put("respmsg", HServiceReturnCode.LISTID_REPAY_ERROR.getReturnMessage());
            resp.setRespCode(HServiceReturnCode.LISTID_REPAY_ERROR.getReturnCode());
            resp.setRespMessage(HServiceReturnCode.LISTID_REPAY_ERROR.getReturnMessage());
            resp.setRespTime(new Date());
            return getBlankHResponse(resp, headerMap, bodyMap);
        }
        
        // 2. 试算处理
        try {
            CalcRamtRes res = new CalcRamtRes();
            CalcRamtReq req = new CalcRamtReq();
            String receiptId = loanPosPaybackService.getReceiptIdByPayApplyId(bodyMap.get("payapplyid"));
            TReceiptInfo R = loanPosPaybackService.getReceiptInfoByReceiptId(receiptId);
            if ("02".equals(bodyMap.get(PaymentApplyHServiceConstants.aheakind))) {

                logger.info("还本付息试算接口计算利息");
                String sumamt = bodyMap.get("sumamt");
                String rcapi = bodyMap.get("rcapi");
                logger.debug("sumamt=" + sumamt + "rcapi" + rcapi);
                if(StringUtil.isNotEmpty(rcapi)){
                	
                }
                Double sumAmount = null;
                if(StringUtil.isNotEmpty(sumamt)){
                	sumAmount = new Double(sumamt);
                	req.setSsubsamt(sumAmount);//应放金额
                	req.setAheaamtkind("2");
                }
                
                if(StringUtil.isNotEmpty(rcapi)){
                	sumAmount = new Double("0");
                	req.setrCapi(new Double(rcapi));
                	req.setSsubsamt(sumAmount);
                	req.setAheaamtkind("1");
                	req.setLoanAcNo(R.getLoanAcNo());
                }
                logger.info("还款总金额为" + sumAmount);

                req.setAheakind("1");//还款类型
                req.setWorkDate(new Date());
                MadeLoanLoanLedgerBean bean = new MadeLoanLoanLedgerBean();
                bean.setInterestRate(R.getLoanInterest()); //贷款利率
                logger.info("贷款利率为" + R.getLoanInterest());
                bean.setBeginDate(R.getBeginDate());
                bean.setLastInteDate(R.getBeginDate());
                logger.info("开始计息日为" + R.getBeginDate());
                bean.setRepayMethod(R.getPaybackWay());//还款方式
                bean.setProdId("1001020306");
                bean.setPayMethod("90");
                bean.setaBal(R.getLoanTotalBalance());
                req.setBean(bean);
                res = madeLoanProcessBizHession.calcRamtWithBean(req);
                Map<String, Object> resMap = res.getRes();
                logger.info("核算接口返回的map为" + resMap);
                String capital = (String) resMap.get("rcapi");
                logger.info("计算出来的本金为" + capital);
                String interest = (String) resMap.get("rInte");
                logger.info("计算出来的利息为" + interest);
                Double loanTotalBalance = loanPosPaybackService
                    .getLoanTotalBalanceByReceiptId(bodyMap.get("payapplyid"));
                logger.info("贷款总余额为" + loanTotalBalance);
                if (sumAmount > loanTotalBalance) {
                    logger.error("还款总金额已大于剩余借据总余额");
                    //logger.error("还款试算失败");
                    bodyMap.put("respcode", HServiceReturnCode.OVERAMT_ERROR.getReturnCode());
                    bodyMap.put("respmsg", HServiceReturnCode.OVERAMT_ERROR.getReturnMessage());
                    resp.setRespCode(HServiceReturnCode.OVERAMT_ERROR.getReturnCode());
                    resp.setRespMessage(HServiceReturnCode.OVERAMT_ERROR.getReturnMessage());
                    resp.setRespTime(new Date());
                    return getBlankHResponse(resp, headerMap, bodyMap);
                } else {
                    logger.info("归还本金利息总金额为" + sumAmount);
                }
                bodyMap.put("rcapi", capital);
                bodyMap.put("rinte", interest);
                double tamt = new BigDecimal(capital).add(new BigDecimal(interest)).doubleValue();
                bodyMap.put("sumamt", String.valueOf(tamt));
                bodyMap.put("unreturnedamt", String.valueOf(loanTotalBalance));
            } else if ("01".equals(bodyMap.get(PaymentApplyHServiceConstants.aheakind))) {
                Double loanTotalBalance = loanPosPaybackService
                    .getLoanTotalBalanceByReceiptId(bodyMap.get("payapplyid"));
                logger.info("剩余贷款总余额为" + loanTotalBalance);

                logger.info("提前结清试算接口计算利息");
                req.setAheakind("1");
                req.setSsubsamt(new Double("0"));//应放金额
                req.setWorkDate(new Date());
                req.setLoanAcNo(R.getLoanAcNo());
                logger.info("核心借据号为" + R.getLoanAcNo());
                req.setrCapi(R.getLoanTotalBalance().doubleValue());
                logger.info("借据余额为" + R.getLoanTotalBalance());
                req.setAheaamtkind("1");
                MadeLoanLoanLedgerBean bean = new MadeLoanLoanLedgerBean();
                bean.setInterestRate(R.getLoanInterest()); //贷款利率
                logger.info("贷款利率为" + R.getLoanInterest());
                bean.setLastInteDate(R.getBeginDate());
                logger.info("开始计息日为" + R.getBeginDate());
                bean.setBeginDate(R.getBeginDate());
                bean.setRepayMethod(R.getPaybackWay());//还款方式
                bean.setProdId("1001020306");
                bean.setPayMethod("90");
                bean.setaBal(R.getLoanTotalBalance());
                req.setBean(bean);
                res = madeLoanProcessBizHession.calcRamtWithBean(req);
                Map<String, Object> resMap = res.getRes();
                logger.info("核算接口返回的map为" + resMap);
                String capital = (String) resMap.get("rcapi");
                logger.info("计算出来的本金为" + capital);
                BigDecimal capital1 = new BigDecimal(capital);
                String interest = (String) resMap.get("rInte");
                logger.info("计算出来的利息为" + interest);
                BigDecimal interest1 = new BigDecimal(interest);
                double tamt = capital1.add(interest1).doubleValue();
                bodyMap.put("rcapi", capital);
                bodyMap.put("rinte", interest);
                bodyMap.put("sumamt", String.valueOf(tamt));
                bodyMap.put("unreturnedamt", String.valueOf(loanTotalBalance));
            }
        } catch (Exception e) {
            logger.error("还款试算失败，某些参数为空" + e);
            bodyMap.put("respcode", HServiceReturnCode.POS_PAYBACK_TRY_CALCULATE_ERROR.getReturnCode());
            bodyMap.put("respmsg", HServiceReturnCode.POS_PAYBACK_TRY_CALCULATE_ERROR.getReturnMessage());
            resp.setRespCode(HServiceReturnCode.POS_PAYBACK_TRY_CALCULATE_ERROR.getReturnCode());
            resp.setRespMessage(HServiceReturnCode.POS_PAYBACK_TRY_CALCULATE_ERROR.getReturnMessage());
            resp.setRespTime(new Date());
            return getBlankHResponse(resp, headerMap, bodyMap);
        }
        
        
	    
//	    // 4. 试算
//        CalcRamtReq calcRamtReq = new CalcRamtReq(); 
//        // 暂时写死
//        calcRamtReq.setLoanAcNo(tReceiptInfo.getLoanAcNo());
//        
//        // 操作员信息，暂时参照学生贷
//        calcRamtReq.setOprId("680199");
//        calcRamtReq.setOprName("");
//        
//        /**
//         *  <select name="aheakind" desc="提前还款类型">
//                <option value="1" text="还本付息" />
//                <option value="2" text="提前结清" />
//                <option value="3" text="提前还本" />
//            </select>
//         */
//        if ("01".equals(bodyMap.get(PaymentApplyHServiceConstants.aheakind))) {
//            calcRamtReq.setAheakind("2");
//        } else if ("02".equals(bodyMap.get(PaymentApplyHServiceConstants.aheakind))) {
//            calcRamtReq.setAheakind("1");
//        } else {
//            logger.error("试算接口异常,暂不支持！");
//            bodyMap.put("respcode", HServiceReturnCode.NO_SUPPORT_ERROR.getReturnCode());
//            bodyMap.put("respmsg", HServiceReturnCode.NO_SUPPORT_ERROR.getReturnMessage());
//            resp.setRespCode(HServiceReturnCode.NO_SUPPORT_ERROR.getReturnCode());
//            resp.setRespMessage(HServiceReturnCode.NO_SUPPORT_ERROR.getReturnMessage());
//            resp.setRespTime(new Date());
//            return getBlankHResponse(resp, headerMap, bodyMap);
//        }
//        
//        // POS贷 固定：POS
//        calcRamtReq.setChannelId("POS");
//        // 还款总金额
//        calcRamtReq.setSsubsamt(Double.parseDouble(bodyMap.get(PaymentApplyHServiceConstants.sumamt)));
//        logger.info("核算平台 还款试算请求报文 = [" + calcRamtReq.toString() + "]");
//        CalcRamtRes calcRamtRes = madeLoanProcessBizHession.calcRAmt(calcRamtReq);
//        if (calcRamtRes == null) {
//            logger.error("核算平台 试算接口异常，无应答返回!");
//            bodyMap.put("respcode", HServiceReturnCode.OTHER_ERROR.getReturnCode());
//            bodyMap.put("respmsg", HServiceReturnCode.OTHER_ERROR.getReturnMessage());
//            resp.setRespCode(HServiceReturnCode.OTHER_ERROR.getReturnCode());
//            resp.setRespMessage(HServiceReturnCode.OTHER_ERROR.getReturnMessage());
//            resp.setRespTime(new Date());
//            return getBlankHResponse(resp, headerMap, bodyMap);
//        }
//        
//        /**
//         *  rcapi: 提前归还本金
//            rInte:提前归还利息
//            sAlloInte:贴息金额
//            OtherKillAmt:其他抵扣金额
//            sSubsInte:扣收利息
//            rfoul:违约金
//            sSubsAmt:扣收金额
//            newamt:分期还款额
//            SumAmt:实还金额
//            clew:
//            sTerm//当前期次
//            scTerm//当前期次[理论]
//            cTerm//贷款期数[理论
//            sTermNum//理论，当前第几期？
//             sRepayDate //应还款日期
//             rRepayDate //实际还款日期 
//         * 
//         * @return
//         */
//        Map<String,Object> resMap = calcRamtRes.getRes();
//        if (resMap == null || resMap.size() < 0) {
//            logger.error("核算平台 试算接口异常，无应答返回!");
//            bodyMap.put("respcode", HServiceReturnCode.OTHER_ERROR.getReturnCode());
//            bodyMap.put("respmsg", HServiceReturnCode.OTHER_ERROR.getReturnMessage());
//            resp.setRespCode(HServiceReturnCode.OTHER_ERROR.getReturnCode());
//            resp.setRespMessage(HServiceReturnCode.OTHER_ERROR.getReturnMessage());
//            resp.setRespTime(new Date());
//            return getBlankHResponse(resp, headerMap, bodyMap);
//        }
//        logger.info("核算平台 还款试算应答报文 = [" + MapUtils.toString(resMap) + "]");
//        
//        // 5. 组装应答数据
//        // 5. 1 归还利息
//        bodyMap.put("rinte", (String)resMap.get("rInte"));
//        // 5. 2 归还本金
//        bodyMap.put("rcapi", (String)resMap.get("rcapi"));
//        // 5. 3 提前还款总金额
//        bodyMap.put("sumamt", (String)resMap.get("SumAmt"));
        
        // 3. 成功应答
        Map<String, Object> rootMap = Maps.newHashMap();
        bodyMap.put("respcode", HServiceReturnCode.SUCCESS.getReturnCode());
        bodyMap.put("respmsg", HServiceReturnCode.SUCCESS.getReturnMessage());
        
        // 3.1 签名处理
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
        logger.debug("out ZZAPPRepaymentTryCalculateServiceImpl...");
        return resp;
	    
	}
	
	/**
     * 请求包校验处理.
     * 
     * @param headerMap
     * @param bodyMap
     * @return
     * @throws Exception 
     */
    protected boolean validate(Map<String, String> headerMap, Map<String, String> bodyMap,
                             HResponse resp) throws HServiceException {
        if (!validateHeader(headerMap, bodyMap, resp)) {
            return false;
        }
        
        // 用款申请编号
        if (StringUtil.isEmpty(bodyMap.get("payapplyid"))) {
            logger.error("用款申请编号为空或不合法:[]", bodyMap.get("payapplyid"));
            bodyMap.put("respcode", HServiceReturnCode.PAYAPPLYID_ERROR.getReturnCode());
            bodyMap.put("respmsg", HServiceReturnCode.PAYAPPLYID_ERROR.getReturnMessage());
            resp.setRespCode(HServiceReturnCode.PAYAPPLYID_ERROR.getReturnCode());
            resp.setRespMessage(HServiceReturnCode.PAYAPPLYID_ERROR.getReturnMessage());
            return false;
        }
        
        // 提前还款类型
        if (StringUtil.isEmpty(bodyMap.get("aheakind"))
            || "01|02".indexOf(bodyMap.get("aheakind")) < -1) {
            logger.error("提前还款类型为空或不合法:[]", bodyMap.get("aheakind"));
            bodyMap.put("respcode", HServiceReturnCode.AHEAKIND_ERRO_ERROR.getReturnCode());
            bodyMap.put("respmsg", HServiceReturnCode.AHEAKIND_ERRO_ERROR.getReturnMessage());
            resp.setRespCode(HServiceReturnCode.AHEAKIND_ERRO_ERROR.getReturnCode());
            resp.setRespMessage(HServiceReturnCode.AHEAKIND_ERRO_ERROR.getReturnMessage());
            return false;
        }
        
        // 归还本金
//        if (StringUtil.isEmpty(bodyMap.get("rcapi"))
//            || !ValidateUtil.checkDouble(bodyMap.get("rcapi"))) {
//            logger.error("归还本金为空或不合法:[]", bodyMap.get("rcapi"));
//            bodyMap.put("respcode", HServiceReturnCode.RCAPI_ERRO_ERROR.getReturnCode());
//            bodyMap.put("respmsg", HServiceReturnCode.RCAPI_ERRO_ERROR.getReturnMessage());
//            resp.setRespCode(HServiceReturnCode.RCAPI_ERRO_ERROR.getReturnCode());
//            resp.setRespMessage(HServiceReturnCode.RCAPI_ERRO_ERROR.getReturnMessage());
//            return false;
//        }
        
        // 还款总金额
//        if (StringUtil.isEmpty(bodyMap.get("sumamt"))
//            || !ValidateUtil.checkDouble(bodyMap.get("sumamt"))) {
//            logger.error("还款总金额为空或不合法:[]", bodyMap.get("sumamt"));
//            bodyMap.put("respcode", HServiceReturnCode.SUMAMT_ERROR.getReturnCode());
//            bodyMap.put("respmsg", HServiceReturnCode.SUMAMT_ERROR.getReturnMessage());
//            resp.setRespCode(HServiceReturnCode.SUMAMT_ERROR.getReturnCode());
//            resp.setRespMessage(HServiceReturnCode.SUMAMT_ERROR.getReturnMessage());
//            return false;
//        }

        return true;
    }
}
