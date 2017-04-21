/**
 * 
 */
package com.hrbb.loan.pos.biz.bean;

import java.util.Date;

import com.hrbb.loan.acct.facade.MadeLoanProcessBizHession;
import com.hrbb.loan.acct.facade.bean.MadeLoanExecPrepayReq;
import com.hrbb.loan.acct.facade.bean.MadeLoanExecPrepayRes;
import com.hrbb.loan.acct.facade.bean.MadeLoanExecTurnOverReq;
import com.hrbb.loan.acct.facade.bean.MadeLoanExecTurnOverRes;
import com.hrbb.loan.acct.facade.common.constants.AcctRetConstants;
import com.hrbb.loan.acct.facade.common.constants.ChannelConstants;
import com.hrbb.loan.pos.dao.entity.TRepaymentPlan;
import com.hrbb.loan.pos.dao.entity.TransactionLog;
import com.hrbb.loan.pos.entity.SpringBeans;
import com.hrbb.loan.pos.service.IGenericConfigService;
import com.hrbb.loan.pos.service.TRepaymentPlanService;
import com.hrbb.loan.pos.util.DateUtil;
import com.hrbb.sh.framework.HServiceException;

/**
 * <p>Title: RepaymentExecDo.java </p>
 * <p>Description: 执行还款交易 </p>
 * <p>Copyright: Copyright (C) 2015 Hrbb Ltd. Co.</p> 
 *     
 * @author linzhaolin@hrbb.com.cn
 * @version 
 * @date 2015年7月29日
 *
 * logs: 1. 
 */
public class RepaymentExecDo extends AbsInternalService {
	
	private String prepaymentId;
	
	private String loanAcNo;
	
	private String receiptId;
	
	private String term;
	
	private boolean overFlag = false; //拖欠标识
	
	private IGenericConfigService genericConfigService = null;
	
	private TransactionLog txlog = null;
	
    private TRepaymentPlanService repaymentPlanService;
	
	public String getPrepaymentId() {
		return prepaymentId;
	}

	public String getLoanAcNo() {
		return loanAcNo;
	}
	
	public RepaymentExecDo(String prepaymentId, String loanAcNo, String receiptId, String term){
		this.prepaymentId = prepaymentId;
		this.loanAcNo = loanAcNo;
		this.receiptId = receiptId;
		this.term = term;
	}

	@Override
	public boolean initService() throws HServiceException {
		genericConfigService = (IGenericConfigService)SpringBeans.getBean("genericConfigService");
		/*日志记录对象*/
		txlog = new TransactionLog(getPrepaymentId());
		try {
		    repaymentPlanService = (TRepaymentPlanService)SpringBeans.getBean("repaymentPlanService");
            TRepaymentPlan repaymentPlan = repaymentPlanService.getPlanByReceiptIdAndPeriod(receiptId,term);
            Date schedDate = (Date)repaymentPlan.getScheddate();
            if(DateUtil.getDateDiffByDay(schedDate, new Date())<0){
                logger.info("该笔借据[{}]的第[{}]期已经拖欠",receiptId,term);
                overFlag = true;
            }
        } catch (Exception e) {
            logger.error("判断是否拖欠异常,receiptId="+receiptId, e);
            return false;
        }
		return true;
	}

	@Override
	public boolean processService() throws HServiceException {
	    
	    MadeLoanProcessBizHession madeLoanProcessBizHession = (MadeLoanProcessBizHession)SpringBeans.getBean("madeLoanProcessBizHession");
	    
	    if(overFlag){
	        MadeLoanExecTurnOverReq req = new MadeLoanExecTurnOverReq();
	        req.setListId(getPrepaymentId());
	        req.setLoanAcNo(getLoanAcNo());
            try {
                MadeLoanExecTurnOverRes res = madeLoanProcessBizHession.processTurnOver(req);
                /*日志记录对象*/
                txlog.setTransObject(req, res);
                
                if(res!=null && res.getRespCode().equals(AcctRetConstants.SUCCESS.getValue())){
                    logger.info("借据["+getPrepaymentId()+"| "+getLoanAcNo()+"]还款执行成功!");
                    return true;
                    
                }else{
                    logger.error("借据["+getLoanAcNo()+"]还款执行失败!");
                    return false;
                }
            } catch (Exception e) {
                e.printStackTrace();
                logger.error("还款申请[" + getPrepaymentId() + "]执行失败!");

                /*日志记录对象*/
                txlog.setTransObject(req, e.getMessage());
                txlog.setStatus(TransactionLog.核心交易状态_失败);
            } finally {
                /*记录交易日志*/
                txlog.setRspTime();
                genericConfigService.insertTransactionLog(txlog);
            }
	    }else{
    		MadeLoanExecPrepayReq repayReq = new MadeLoanExecPrepayReq();
    		repayReq.setChannelId(ChannelConstants.POS.getValue());
    		repayReq.setListId(getPrepaymentId());
    		repayReq.setListtype("03");			//03 提前还款  02正常还款 04逾期还款		//FIXME;需要根据还款日期判断是否为正常还款
    		repayReq.setLoanAcNo(getLoanAcNo());
    		try{
    			MadeLoanExecPrepayRes response = madeLoanProcessBizHession.processPrepayment(repayReq);
    			/*日志记录对象*/
    	    	txlog.setTransObject(repayReq, response);
    	    	
    			if(response!=null && response.getRespCode().equals(AcctRetConstants.SUCCESS.getValue())){
    				logger.info("借据["+getPrepaymentId()+"| "+getLoanAcNo()+"]还款执行成功!");
    				return true;
    				
    			}else{
    				logger.error("借据["+getLoanAcNo()+"]还款执行失败!");
    				return false;
    			}
    			
    		}catch(Exception e){
    			logger.error("还款申请["+getPrepaymentId()+"]执行失败!");
    			
    			/*日志记录对象*/
    			txlog.setTransObject(repayReq, e.getMessage());
    			txlog.setStatus(TransactionLog.核心交易状态_失败);
    		}finally{
    			/*记录交易日志*/
    			txlog.setRspTime();
    	        genericConfigService.insertTransactionLog(txlog);
    		}
	    }
		
		return true;
	}

	@Override
	public boolean processService(String fileName, byte[] bytes)
			throws HServiceException {
		// TODO Auto-generated method stub
		return false;
	}

}
