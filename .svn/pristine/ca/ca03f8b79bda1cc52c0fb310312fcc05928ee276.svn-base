package com.hrbb.loan.spi.UM;

import java.math.BigDecimal;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.List;
import java.util.Map;

import jodd.util.StringUtil;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.google.common.collect.Maps;
import com.hrbb.loan.acct.facade.MadeLoanProcessBizHession;
import com.hrbb.loan.acct.facade.bean.CalcRamtReq;
import com.hrbb.loan.acct.facade.bean.CalcRamtRes;
import com.hrbb.loan.acct.facade.bean.MadeLoanLoanLedgerBean;
import com.hrbb.loan.acct.facade2.bean.RepayClamQuerySubBean;
import com.hrbb.loan.pos.biz.backstage.inter.IRepaymentAcctBiz;
import com.hrbb.loan.pos.dao.entity.TReceiptInfo;
import com.hrbb.loan.pos.dao.entity.TRepaymentPlan;
import com.hrbb.loan.pos.service.LoanPosPaybackService;
import com.hrbb.loan.pos.service.TRepaymentPlanService;
import com.hrbb.loan.spiconstants.HServiceReturnCode;
import com.hrbb.sh.framework.HRequest;
import com.hrbb.sh.framework.HResponse;
import com.hrbb.sh.framework.HService;
import com.hrbb.sh.framework.HServiceException;

/**
 * 还款试算
 * 
 * @author cjq
 * @version $Id: UMPaybackTryCalculateImpl.java, v 0.1 2015年10月23日 上午9:49:38 cjq Exp $
 */
@Service("umPaybackTryCalculate")
public class UMPaybackTryCalculateImpl implements HService {

    private static final Logger       LOGGER = LoggerFactory.getLogger(UMPaybackTryCalculateImpl.class);
    @Autowired
    private LoanPosPaybackService     loanPosPaybackService;

    @Autowired
    private MadeLoanProcessBizHession madeLoanProcessBizHession;

    @Autowired
    private TRepaymentPlanService     repaymentPlanService;

    @Autowired
    private IRepaymentAcctBiz         repaymentAcctBiz;

    @Override
    public HResponse serve(HRequest request) throws HServiceException {
        LOGGER.debug("executing UMPaybackTryCalculateImpl...");
        HResponse response = new HResponse();
        Map<String, Object> propMap = request.getProperties();
        String listid = propMap.get("listid").toString();
        String aheakind = propMap.get("aheakind").toString();
        LOGGER.info("用款申请编号=[{}],还款类型=[{}]", listid, aheakind);
        try {
            CalcRamtRes res = new CalcRamtRes();
            CalcRamtReq req = new CalcRamtReq();
            String expectretudate = (String) propMap.get("expectretudate");
            SimpleDateFormat sft = new SimpleDateFormat("yyyyMMdd");
            Date d = sft.parse(expectretudate);
            LOGGER.info("还款日期为" + d);
            String receiptId = loanPosPaybackService.getReceiptIdByPayApplyId(listid);
            TReceiptInfo receipt = loanPosPaybackService.getReceiptInfoByReceiptId(receiptId);
		/*	Date bd = R.getBeginDate();
			long t1 = d.getTime();
			long t2 = bd.getTime();
			long t3 = (t1-t2)/(1000860*60*24);
            if(t3<7){
            	logger.error("还款试算失败,不允许七天内还款试算");
            	response.setRespCode(HServiceReturnCode.POS_PAYBACK_TRY_CALCULATE_ERROR2.getReturnCode());
            	response.setRespMessage(HServiceReturnCode.POS_PAYBACK_TRY_CALCULATE_ERROR2.getReturnMessage());
            	response.setRespTime(new Date());
            	return getBlankHResponse(response);
            }else{*/
            String paybackWay = receipt.getPaybackWay();
            if(StringUtil.isNotEmpty(paybackWay)){
                if("90".equals(paybackWay)){
                    //判断是否拖欠
                    TRepaymentPlan plan = repaymentPlanService.getRecentlyPlan(receiptId);
                    if (plan != null) {
                        if ("0".equals(plan.getOverFlag())) {//未拖欠
                            if ("2".equals(aheakind)) {
                                LOGGER.info("还本付息试算接口计算利息");
                                String sumamt = (String) propMap.get("sumamt");
                                Double sumAmount = new Double(sumamt);
                                LOGGER.info("还款总金额为" + sumAmount);
                                req.setAheakind("1");//还款类型
                                req.setSsubsamt(sumAmount);//应放金额
                                req.setWorkDate(d);
                                req.setAheaamtkind("2");
                                MadeLoanLoanLedgerBean bean = new MadeLoanLoanLedgerBean();
                                bean.setInterestRate(receipt.getLoanInterest()); //贷款利率
                                LOGGER.info("贷款利率为" + receipt.getLoanInterest());
                                bean.setBeginDate(receipt.getBeginDate());
                                bean.setLastInteDate(receipt.getBeginDate());
                                LOGGER.info("开始计息日为" + receipt.getBeginDate());
                                bean.setRepayMethod(receipt.getPaybackWay());//还款方式
                                bean.setProdId("1001020306");
                                bean.setPayMethod("90");
                                bean.setaBal(receipt.getLoanTotalBalance());
                                req.setBean(bean);
                                LOGGER.info("核算接口请求参数=[{}]",req);
                                res = madeLoanProcessBizHession.calcRamtWithBean(req);
                                LOGGER.info("核算接口返回结果=[{res}]",res);
                                Map<String, Object> resMap = res.getRes();
                                String capital = (String) resMap.get("rcapi");
                                String interest = (String) resMap.get("rInte");
                                Double loanTotalBalance = loanPosPaybackService
                                    .getLoanTotalBalanceByReceiptId(listid);
                                LOGGER.info("贷款总余额为" + loanTotalBalance);
                                if (sumAmount > loanTotalBalance) {
                                    LOGGER.error("还款总金额已大于剩余借据总余额");
                                } else {
                                    LOGGER.info("归还本金利息总金额为" + sumAmount);
                                }
                                Map<String,Object> map = Maps.newHashMap();
                                map.put("listid", listid);
                                map.put("aheakind", aheakind);
                                map.put("rcapi", capital);
                                map.put("rinte", interest);
                                map.put("sumamt", sumAmount);
                                LOGGER.info("返回给银商的map为" + map);
                                response.setRespCode(HServiceReturnCode.SUCCESS.getReturnCode());
                                response.setRespMessage(HServiceReturnCode.SUCCESS.getReturnMessage());
                                response.setRespTime(new Date());
                                response.setProperties(map);
                            } else if ("1".equals(aheakind)) {
                                Double loanTotalBalance = loanPosPaybackService
                                    .getLoanTotalBalanceByReceiptId(listid);
                                LOGGER.info("剩余贷款总余额为" + loanTotalBalance);
                                LOGGER.info("提前结清试算接口计算利息");
                                req.setAheakind("1");
                                req.setSsubsamt(new Double("0"));//应放金额
                                req.setWorkDate(d);
                                req.setLoanAcNo(receipt.getLoanAcNo());
                                req.setrCapi(receipt.getLoanTotalBalance().doubleValue());
                                req.setAheaamtkind("1");
                                MadeLoanLoanLedgerBean bean = new MadeLoanLoanLedgerBean();
                                bean.setInterestRate(receipt.getLoanInterest()); //贷款利率
                                bean.setLastInteDate(receipt.getBeginDate());
                                bean.setBeginDate(receipt.getBeginDate());
                                bean.setRepayMethod(receipt.getPaybackWay());//还款方式
                                bean.setProdId("1001020306");
                                bean.setPayMethod("90");
                                bean.setaBal(receipt.getLoanTotalBalance());
                                req.setBean(bean);
                                LOGGER.info("核算接口请求参数req=[{}]",req);
                                res = madeLoanProcessBizHession.calcRamtWithBean(req);
                                LOGGER.info("核算接口返回结果res=[{}]",res);
                                Map<String, Object> resMap = res.getRes();
                                String capital = (String) resMap.get("rcapi");
                                String interest = (String) resMap.get("rInte");
                                BigDecimal capitalDec = new BigDecimal(capital);
                                BigDecimal interestDec = new BigDecimal(interest);
                                double tamt = capitalDec.add(interestDec).doubleValue();
                                Map<String,Object> map = Maps.newHashMap();
                                map.put("listid", listid);
                                map.put("aheakind", aheakind);
                                map.put("rcapi", capital);
                                map.put("rinte", interest);
                                map.put("sumamt", tamt);
                                LOGGER.info("返回给银商的map为" + map);
                                response.setRespCode(HServiceReturnCode.SUCCESS.getReturnCode());
                                response.setRespMessage(HServiceReturnCode.SUCCESS.getReturnMessage());
                                response.setRespTime(new Date());
                                response.setProperties(map);
                            }
                        } else {//拖欠
                            String paybackAmt = propMap.get("sumamt").toString();
                            Map<String, Object> resultMap = repaymentAcctBiz.paybackCalc(
                                receipt.getLoanAcNo(), paybackAmt);
                            @SuppressWarnings("unchecked")
                            List<RepayClamQuerySubBean> list = (List<RepayClamQuerySubBean>) resultMap
                                .get("list");
                            for (RepayClamQuerySubBean repayClamQuerySubBean : list) {
                                if ("00".equals(repayClamQuerySubBean.getPayoffFlag())) {
                                    Map<String, Object> map = Maps.newHashMap();
                                    map.put("listid", listid);
                                    map.put("aheakind", aheakind);
                                    map.put("rcapi", repayClamQuerySubBean.getrCapiNew());
                                    map.put("rinte", repayClamQuerySubBean.getrInteNew());
                                    map.put("sumamt", paybackAmt);
                                    LOGGER.info("返回给银商的map为" + map);
                                    response.setRespCode(HServiceReturnCode.SUCCESS.getReturnCode());
                                    response.setRespMessage(HServiceReturnCode.SUCCESS.getReturnMessage());
                                    response.setRespTime(new Date());
                                    response.setProperties(map);
                                }
                            }
                        }
                    }else{
                        LOGGER.info("还款计划为空，或者还款已结清");
                        response.setRespCode(HServiceReturnCode.POS_PAYBACK_TRY_CALCULATE_ERROR
                            .getReturnCode());
                        response.setRespMessage(HServiceReturnCode.POS_PAYBACK_TRY_CALCULATE_ERROR
                            .getReturnMessage());
                        response.setRespTime(new Date());
                    }
                    return response;
                }else if("10".equals(paybackWay)){//等额本息
                    List<TRepaymentPlan> repaymentPlans = repaymentPlanService.getAllPlanByReceiptId(receiptId);
                    BigDecimal sumRcapi = BigDecimal.ZERO;
                    BigDecimal sumRInte = BigDecimal.ZERO;
                    BigDecimal sumAmt = BigDecimal.ZERO;
                    for (TRepaymentPlan tRepaymentPlan : repaymentPlans) {
                        if("00".equals(tRepaymentPlan.getPayoffFlag())){
                            if(!"0".equals(tRepaymentPlan.getOverFlag())){
                                sumRcapi = sumRcapi.add(tRepaymentPlan.getSchedprincipal());
                                sumRInte = sumRInte.add(tRepaymentPlan.getSchedinterest()).add(tRepaymentPlan.getUnpaidinterest());
                                sumAmt = sumAmt.add(tRepaymentPlan.getSchedtotalamt());
                            }else{
                                sumRcapi = sumRcapi.add(tRepaymentPlan.getSchedprincipal());
                                sumRInte = sumRInte.add(tRepaymentPlan.getSchedinterest()).add(tRepaymentPlan.getUnpaidinterest());
                                sumAmt = sumAmt.add(tRepaymentPlan.getSchedtotalamt());
                                break;
                            }
                        }
                    }
                    Map<String, Object> map = Maps.newHashMap();
                    map.put("listid", listid);
                    map.put("aheakind", aheakind);
                    map.put("rcapi", sumRcapi);
                    map.put("rinte", sumRInte);
                    map.put("sumamt", sumAmt);
                    LOGGER.info("返回给银商的map=[{}]" ,map);
                    response.setRespCode(HServiceReturnCode.SUCCESS.getReturnCode());
                    response.setRespMessage(HServiceReturnCode.SUCCESS.getReturnMessage());
                    response.setRespTime(new Date());
                    response.setProperties(map);
                }
            }else{
                LOGGER.info("银商试算接口，用款[{}]的还款方式未知", receiptId);
                response.setRespCode(HServiceReturnCode.POS_PAYBACK_TRY_CALCULATE_ERROR
                    .getReturnCode());
                response.setRespMessage(HServiceReturnCode.POS_PAYBACK_TRY_CALCULATE_ERROR
                    .getReturnMessage());
                response.setRespTime(new Date());
            }
            return response;
        } catch (ParseException e) {
            LOGGER.error("日期解析异常", e);
            response
                .setRespCode(HServiceReturnCode.POS_PAYBACK_TRY_CALCULATE_ERROR.getReturnCode());
            response.setRespMessage(HServiceReturnCode.POS_PAYBACK_TRY_CALCULATE_ERROR
                .getReturnMessage());
            response.setRespTime(new Date());
            return getBlankHResponse(response);

        } catch (Exception e) {
            LOGGER.error("还款试算失败，某些参数为空", e);
            response
                .setRespCode(HServiceReturnCode.POS_PAYBACK_TRY_CALCULATE_ERROR.getReturnCode());
            response.setRespMessage(HServiceReturnCode.POS_PAYBACK_TRY_CALCULATE_ERROR
                .getReturnMessage());
            response.setRespTime(new Date());
            return getBlankHResponse(response);
        }

    }

    private HResponse getBlankHResponse(HResponse response) {
        Map<String, Object> map = Maps.newHashMap();
        map.put("listid", "");
        map.put("aheakind", "");
        map.put("rcapi", "");
        map.put("rinte", "");
        map.put("sumamt", "");
        response.setProperties(map);
        return response;
    }

}
