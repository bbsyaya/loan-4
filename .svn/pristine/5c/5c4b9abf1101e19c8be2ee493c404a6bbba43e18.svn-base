/**
 * 
 *	哈尔滨银行
 * Copyright (c) 2007-2015 HRBB,Inc.All Rights Reserved.
 */
package com.hrbb.loan.controller;

import java.io.PrintWriter;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.ModelAndView;

import com.alibaba.fastjson.JSON;
import com.hrbb.loan.pos.biz.backstage.inter.CreditApplyRiskCheckBiz;
import com.hrbb.loan.pos.biz.backstage.inter.LoanRiskCheckBiz;
import com.hrbb.loan.pos.dao.entity.TRiskCheckResult;

/**
 * <h1>执行风险初审</h1>
 * 
 * @author marco
 * @version Id: creditApplyRiskCheck.java, v 1.0 2015-2-5 下午3:14:59 marco Exp
 */
@Controller
@RequestMapping("/creditApplyRiskCheck")
public class CreditApplyRiskCheckController {

	@Autowired
	@Qualifier("creditApplyRiskCheckBiz")
	private CreditApplyRiskCheckBiz biz;

	@Autowired
	@Qualifier("loanRiskCheckBiz")
	private LoanRiskCheckBiz riskCheckBiz;

	/**
	 * <h2>执行风险初审</h2>
	 * 
	 * @param loanId
	 * 
	 * @return modelAndView
	 */
	@RequestMapping("/doRiskCheck")
	public ModelAndView doRiskCheck(
			@RequestParam(value = "loanId", required = false) String loanId) {
		biz.doRiskCheck(loanId);
		return null;
	}

	/**
	 * <h2>查询风险初审结果</h2>
	 * 
	 * @param loanId
	 * 
	 * @return modelAndView
	 */
	@RequestMapping("/queryRiskCheckResult")
	public ModelAndView queryRiskCheckResult(
			@RequestParam(value = "loanId", required = false) String loanId,
			PrintWriter out) {
		TRiskCheckResult result = riskCheckBiz.queryRiskCheckResult(loanId);
		out.print(JSON.toJSONString(result));
		return null;
	}
}
