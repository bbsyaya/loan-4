/**
 * 
 *哈尔滨银行
 * Copyright (c) 2007-2015 HRBB,Inc.All Rights Reserved.
 */
package com.hrbb.loan.controller;

import java.io.PrintWriter;
import java.util.Date;
import java.util.List;
import java.util.Map;

import javax.servlet.http.HttpServletRequest;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.ModelAndView;

import com.google.common.collect.Lists;
import com.google.common.collect.Maps;
import com.hrbb.loan.constants.CreditApplyConstants;
import com.hrbb.loan.pos.biz.backstage.inter.CreditApplyAprvInfoBiz;
import com.hrbb.loan.pos.biz.backstage.inter.CreditApplyForReviewBiz;
import com.hrbb.loan.pos.biz.backstage.inter.ILoanPosBusinessCodeBiz;
import com.hrbb.loan.pos.dao.entity.TCreditApply;
import com.hrbb.loan.pos.dao.entity.TCreditApplyAprvInfo;
import com.hrbb.loan.pos.util.StringUtil;
import com.hrbb.loan.pos.util.constants.ReviewNoteConstants;
import com.hrbb.loan.web.security.entity.User;

/**
 * 
 * @author marco
 * @version $Id: AddDataController.java, v 0.1 2015-3-11 上午11:35:10 marco Exp $
 */
@Controller
@RequestMapping("/addData")
public class AddDataController {

	private Logger LOG = LoggerFactory.getLogger(AddDataController.class);

	@Autowired
	@Qualifier("creditApplyForReviewBiz")
	private CreditApplyForReviewBiz bizCA;

	@Autowired
	@Qualifier("creditApplyAprvInfoBiz")
	private CreditApplyAprvInfoBiz biz;

	@Autowired
	private ILoanPosBusinessCodeBiz loanPosBusinessCodeBiz;

	/**
	 * <h2>保存流水</h2>
	 * 
	 * @param reviewid
	 * @return modelAndView
	 */
	@RequestMapping("/addDataBankSerialInfo")
	public ModelAndView addDataBankSerialInfo(
			@RequestParam(value = "loanid", required = false) String loanid,
			HttpServletRequest request, PrintWriter out) {

		// 查询最新申请状态
		TCreditApply ca = bizCA.selectOne(loanid);
		// 被主动撤销时
		if (ReviewNoteConstants.APPLYSTATUS_CODE_93.equals(ca.getApplyStatus())) {
			out.print("该笔申请已经被客户主动撤销，无需继续完成审批。");
			return null;
		}
		User user = (User) request.getSession().getAttribute("USER");
		// 申请审批表信息
		TCreditApplyAprvInfo record = new TCreditApplyAprvInfo();
		record.setLoanId(loanid);
		record.setApprvId(user.getUserName());
		//查询审批序号
		TCreditApplyAprvInfo recordForAppNum = biz.selectNotSubmit(record);
		record.setAppNum(recordForAppNum.getAppNum());
		record.setCustId(ca.getCustId());
		record.setCustName(ca.getCustName());
		// 审批结束时间
		record.setAppEndTime(new Date());
		// 银行流水信息
		List<Map<String, Object>> bankSerialList = Lists.newArrayList();
		for (int i = 0; i < CreditApplyConstants.monthNum; i++) {
			if (!StringUtil.isEmpty(request
					.getParameter(CreditApplyConstants.currMonth + i))) {

				Map<String, Object> map = Maps.newHashMap();
				map.put(CreditApplyConstants.currMonth,
						StringUtil.isEmpty(request
								.getParameter(CreditApplyConstants.currMonth
										+ i)) ? null : request
								.getParameter(CreditApplyConstants.currMonth
										+ i));
				map.put(CreditApplyConstants.bankName,
						StringUtil.isEmpty(request
								.getParameter(CreditApplyConstants.bankName + i)) ? null
								: request
										.getParameter(CreditApplyConstants.bankName
												+ i));
				map.put(CreditApplyConstants.bankAccno,
						StringUtil.isEmpty(request
								.getParameter(CreditApplyConstants.bankAccno
										+ i)) ? null : request
								.getParameter(CreditApplyConstants.bankAccno
										+ i));
				map.put(CreditApplyConstants.currMonthIn,
						StringUtil.isEmpty(request
								.getParameter(CreditApplyConstants.currMonthIn
										+ i)) ? null : request
								.getParameter(CreditApplyConstants.currMonthIn
										+ i));
				map.put(CreditApplyConstants.currMonthOut,
						StringUtil.isEmpty(request
								.getParameter(CreditApplyConstants.currMonthOut
										+ i)) ? null : request
								.getParameter(CreditApplyConstants.currMonthOut
										+ i));
				map.put(CreditApplyConstants.currSeaInterestAmt,
						StringUtil.isEmpty(request
								.getParameter(CreditApplyConstants.currSeaInterestAmt
										+ i)) ? null
								: request
										.getParameter(CreditApplyConstants.currSeaInterestAmt
												+ i));
				bankSerialList.add(map);
			}
		}
		// 更新申请表，申请审批记录表
		int flag = biz.updateByBankSerialInfo(record, bankSerialList);
		// 保存成功
		if (flag == 1) {
			out.print("保存成功。");
			// 保存失败
		} else {
			out.print("保存失败，请联系系统管理员。");
		}
		return null;
	}
}
