package com.hrbb.loan.controller;

import java.io.PrintWriter;

import javax.servlet.http.HttpServletRequest;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.ModelAndView;

import com.hrbb.loan.acct.facade2.MadeLoanProcessQueryBankAcctBalFacade;
import com.hrbb.loan.acct.facade2.bean.QueryBankAcctBalReq;
import com.hrbb.loan.acct.facade2.bean.QueryBankAcctBalRes;
import com.hrbb.loan.pos.util.IdUtil;


@Controller("channelFundController")
@RequestMapping("channelFund")
public class ChannelFundController {
	
	@Autowired
	private MadeLoanProcessQueryBankAcctBalFacade queryFacade;
	
	private Logger logger = LoggerFactory.getLogger(ChannelFundController.class);

	
	@RequestMapping("queryChannelFund")
	public ModelAndView queryChannlFund(PrintWriter out, HttpServletRequest request){
		String acctName = request.getParameter("acctName");
		String account = request.getParameter("account");
		
		QueryBankAcctBalReq req = new QueryBankAcctBalReq();
		String seqNo = IdUtil.getqueryBalSeq();
		req.setBankAcctName(acctName);
		req.setBankAcctNo(account);
		req.setSeqNo(seqNo);
		try {
			QueryBankAcctBalRes res = queryFacade.queryBankAcctBal(req);
			out.print("该账户保证金余额为:" + res.getBankAcctBalance());
		} catch (Exception e) {
			logger.error("查询保证金余额异常", e);
			out.print("查询异常");
		}
		return null;
	}
}
