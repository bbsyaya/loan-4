package com.hrbb.loan.pos.biz.backstage.inter.impl;

import java.math.BigDecimal;
import java.text.ParseException;
import java.util.Date;
import java.util.List;
import java.util.Map;

import org.apache.commons.lang3.StringUtils;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import com.google.common.collect.Maps;
import com.hrbb.loan.pos.biz.backstage.inter.IRepaymentApplyBiz;
import com.hrbb.loan.pos.biz.backstage.inter.LoanPosPaybackApplyBiz;
import com.hrbb.loan.pos.biz.bean.OTInterestPayableCalc;
import com.hrbb.loan.pos.dao.TReceiptInfoDao;
import com.hrbb.loan.pos.dao.entity.TReceiptInfo;
import com.hrbb.loan.pos.dao.entity.TRepaymentPlan;
import com.hrbb.loan.pos.entity.event.POSEvent;
import com.hrbb.loan.pos.entity.event.POSEventsSource;
import com.hrbb.loan.pos.entity.event.cab.MailCab;
import com.hrbb.loan.pos.entity.listener.impl.MailListener;
import com.hrbb.loan.pos.service.RepaymentApplyService;
import com.hrbb.loan.pos.service.TRepaymentPlanService;
import com.hrbb.loan.pos.service.bean.OTRespResult;
import com.hrbb.loan.pos.util.DateUtil;

/**
 * 还款业务实现.
 * 
 * @author xiongshaogang
 * @version $Id: RepaymentApplyBizImpl.java, v 0.1 2015年4月29日 上午10:40:26 xiongshaogang Exp $
 */
@Component("repaymentApplyBiz")
public class RepaymentApplyBizImpl implements IRepaymentApplyBiz {

    Logger logger = LoggerFactory.getLogger(RepaymentApplyBizImpl.class);
    
    @Autowired
    private RepaymentApplyService repaymentApplyService;
    
    @Autowired
	private TReceiptInfoDao tReceiptInfoDao;
    
    @Autowired
    private LoanPosPaybackApplyBiz loanPosPaybackApplyBiz;
    
    @Autowired
    private TRepaymentPlanService    repaymentPlanService;
    
    @Override
    public List<Map<String, Object>> queryRepaymentApplyDetailsByZzApp(Map<String, Object> queryMap) {
        return repaymentApplyService.queryRepaymentListByZzApp(queryMap);
    }

	@Override
	public OTRespResult paybackApply(Map<String, Object> request) throws Exception {
		
		OTRespResult respResult = OTRespResult.newResult();
		
		String paymentApplyNo = (String) request.get("listid");

		TReceiptInfo receipt = null;
		if (!StringUtils.isEmpty(paymentApplyNo)) {
			receipt = tReceiptInfoDao.selectByPayApplyId(paymentApplyNo);
			
			/*判断该笔用款的状态*/
			if(receipt==null){
				respResult.setRespSuccess(OTRespResult.在线交易反馈状态_失败);
				respResult.setRespMessage("不存在对应的有效用款");
				return respResult;
			}
			
		} else {
			logger.warn("用款申请编号不能空");
			respResult.setRespSuccess(OTRespResult.在线交易反馈状态_失败);
			respResult.setRespMessage("用款申请编号不能空");
			return respResult;
		}
		
		/**
		 * new repayment validated
		 */
		String type = (String) request.get("retutype");
		String amount = (String) request.get("sumamt");
		//获取用款申请
		String preType = (String) request.get("aheakind");
		String accNo = (String) request.get("subsaccno");
		String applyDateReq = (String) request.get("retudate");
		String merchantNo = (String) request.get("stdmerno");
		String stdrpno = (String) request.get("stdrpno");		//58及以后版本
		String repayMethod = (String) request.get("repaymethod"); //58专用
		
		Date applyDate = null;
		try {
			applyDate = DateUtil.parse2Date(applyDateReq, DateUtil.HRRB_SHORT_DATETIME_FORMAT_BRIEF);	//yyyyMMdd
		} catch (ParseException ex) {
			logger.warn("期望还款日期["+applyDateReq+"]格式错误",ex);
			respResult.setRespSuccess(OTRespResult.在线交易反馈状态_失败);
			respResult.setRespMessage("期望还款日期格式错误");
			return respResult;
		}

		BigDecimal applyAmt = null;
		if (!StringUtils.isEmpty(amount)) {
			try {
				applyAmt = new BigDecimal(amount);
			} catch (Exception ex) {
				logger.warn("还款总金额["+amount+"]格式错误",ex);
				respResult.setRespSuccess(OTRespResult.在线交易反馈状态_失败);
				respResult.setRespMessage("还款金额格式错误");
				return respResult;
			}
		} else {
			logger.warn("还款总金额为空");
			respResult.setRespSuccess(OTRespResult.在线交易反馈状态_失败);
			respResult.setRespMessage("还款总金额为空");
			return respResult;
		}
		
		
		/**
		 * 利息试算
		 */
		Map<String,Object> returnResult = Maps.newHashMap();
		OTInterestPayableCalc calc = new OTInterestPayableCalc(receipt);
		try{
			calc.setPaybackAmt(applyAmt.doubleValue());
		    calc.setRepayDate(applyDate);
		    calc.setRepayType("1");		//0归还指定本金 /1归还指定总额/2归还剩余本金
			
		    if(calc.execute()){
		    	returnResult = calc.getRspResult();
		    }else{
		    	logger.debug("还款试算失败，请稍后再试。");
				respResult.setRespSuccess(OTRespResult.在线交易反馈状态_失败);
				respResult.setRespMessage("还款试算失败，请稍后再试。");
				return respResult;
		    }
		    
		    
		}catch(Exception e){
			logger.error("还款试算失败",e);
	       	
	       	respResult.setRespSuccess(OTRespResult.在线交易反馈状态_失败);
			respResult.setRespMessage("还款试算失败，请稍后再试。");
			return respResult;
		}
		
		/**
		 * 校验用款申请合法性
		 */
		BigDecimal pbPrincipal = (BigDecimal)returnResult.get("repayPrincipal");
		BigDecimal pbInterest = (BigDecimal)returnResult.get("repayInterest");
		BigDecimal pbTotalAmount = (BigDecimal)returnResult.get("repayTotalAmt");
		Map<String,Object> vResult = loanPosPaybackApplyBiz.validatePaybackApply(receipt, applyDate, pbPrincipal, pbInterest, pbTotalAmount);
		if(!vResult.get("returnCode").equals("000")){
			respResult.setRespSuccess(OTRespResult.在线交易反馈状态_失败);
			respResult.setRespMessage((String)vResult.get("returnMsg"));
			return respResult;
		}
		/**
		 * 创建还款申请
		 */
		logger.debug("创建还款申请开始");
		TRepaymentPlan plan = repaymentPlanService.getRecentlyPlan(receipt.getReceiptId());
		String repaymentNo = null;
		if(plan != null ){
		    repaymentNo = loanPosPaybackApplyBiz.createPaybackApply(receipt, plan.getPeriod(), applyDate, "1", pbPrincipal, pbInterest, null, pbTotalAmount, "system", stdrpno, repayMethod);
		}
		if(repaymentNo!=null){
			respResult.setAttribute("repaymentNo", repaymentNo);
			respResult.setRespMessage("创建还款申请成功.");
			logger.debug("创建还款申请成功");
			try{
				/*增加邮件通知listener*/
				POSEventsSource source = new POSEventsSource();
		        source.setAttribute(POSEvent.监听事件名称_邮件通知, MailCab.邮件通知_还款申请受理通知);
				source.setAttribute("repaymentNo", repaymentNo);
		        source.addListener(new MailListener());
				source.notifyEvent();
			}catch(Exception ex){
				logger.warn("添加邮件征听listener失败!",ex);
			}
		}else{
			logger.debug("创建用款申请失败!");
			respResult.setRespSuccess(OTRespResult.在线交易反馈状态_失败);
			respResult.setRespMessage("创建用款申请失败!Err:Interal error");
		}
		
        return respResult;
	}
    
}
