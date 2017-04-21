package com.hrbb.test;

import junit.framework.Assert;

import org.apache.log4j.Logger;
import org.junit.Test;
import org.springframework.beans.factory.annotation.Autowired;

import com.hrbb.loan.acct.facade.MadeLoanProcessBizHession;
import com.hrbb.loan.acct.facade.bean.MadeLoanAddReturnOverReq;
import com.hrbb.loan.acct.facade.bean.MadeLoanAddReturnOverRes;
import com.hrbb.loan.acct.facade.bean.MadeLoanExecTurnOverReq;
import com.hrbb.loan.acct.facade.bean.MadeLoanExecTurnOverRes;
import com.hrbb.loan.acct.facade2.MadeLoanProcessQuerySimpleFacade;
import com.hrbb.loan.acct.facade2.bean.RepayCalmQueryReq;
import com.hrbb.loan.acct.facade2.bean.RepayCalmQueryRes;
import com.hrbb.loan.pos.entity.SpringBeans;
import com.hrbb.loan.pos.util.DateUtil;

/**
 * 核算拖欠还款测试
 * 
 * @author cjq
 * @version $Id: AcctRepaymentNewTest.java, v 0.1 2015年9月23日 下午5:31:03 cjq Exp $
 */
public class AcctRepaymentNewTest extends UnitTest {
    
    private Logger logger = Logger.getLogger(AcctRepaymentNewTest.class);

    @Autowired
    private MadeLoanProcessBizHession        madeLoanProcessBizHession;

    @Autowired
    private MadeLoanProcessQuerySimpleFacade madeLoanProcessQuerySimpleFacade;

    /**
     * 还款试算
     */
    @Test
    public void testDoRepayCalm() {
        RepayCalmQueryReq req = new RepayCalmQueryReq();
        req.setLoanAcNo("056801000000049131");
        RepayCalmQueryRes res = madeLoanProcessQuerySimpleFacade.doRepayCalm(req);
        logger.debug(res);
    }

    /**
     * 拖欠添加借据
     * @throws Exception
     */
    @Test
    public void testAddReturnOverList() throws Exception {
        MadeLoanProcessBizHession madeLoanProcessBizHession = (MadeLoanProcessBizHession) SpringBeans
            .getBean("madeLoanProcessBizHession");
        MadeLoanAddReturnOverReq req = new MadeLoanAddReturnOverReq();
        req.setLoanAcNo("056801000000048985");//核心借据号
        req.setTerm("1");//还款期数
        req.setsDate(DateUtil.getDatePattern3("2015-12-23"));//应还日期
        req.setsCapi("1000.00");//应还本金
        req.setsInte("45.50");//应还利息
        req.setSaFine("0.00");//实还本金罚息
        req.setrDate((DateUtil.getDatePattern3("2015-12-23")));//实还日期
        req.setrCapi("1000.00");//实还本金
        req.setrInte("45.50");//实还利息
        req.setRaFine("0.00");//实还本金罚息
        req.setrEtway("01");
        req.setSumAmt(1000.00 + 45.50 + 0.00 + "");
        req.setOperId("680199");
        req.setChargeId("6801");
        req.setCheckId("6801");
        //req.setSubSacNo();//扣款账号
        //req.setSubSacName();//扣款账户命名

        MadeLoanAddReturnOverRes res = madeLoanProcessBizHession.addReturnOverList(req);
        logger.debug(res);
    }

    /**
     * 拖欠还款
     */
    @Test
    public void testProcessTurnOver() {
        MadeLoanExecTurnOverReq req = new MadeLoanExecTurnOverReq();
        req.setListId("0000000007");
        req.setLoanAcNo("056801000000048985");
        MadeLoanExecTurnOverRes res = madeLoanProcessBizHession.processTurnOver(req);
        logger.debug(res);
    }
}
