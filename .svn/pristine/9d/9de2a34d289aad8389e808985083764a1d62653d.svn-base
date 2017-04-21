/**
 * 
 *	哈尔滨银行
 * Copyright (c) 2007-2015 HRBB,Inc.All Rights Reserved.
 */
package com.hrbb.loan.controller;

import java.io.PrintWriter;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.ModelAndView;

import com.alibaba.fastjson.JSON;
import com.hrbb.loan.pos.biz.facade.DueDiligenceBizFacadeImpl;
import com.hrbb.loan.pos.dao.entity.TDueDiligence;
import com.hrbb.loan.pos.facade.DueDiligenceBizFacade;
import com.hrbb.loan.pos.facade.bean.DueDiligenceReq;

/**
 * 
 * @author marco
 * @version $Id: DueDiligence.java, v 0.1 2015-3-2 下午8:04:52 marco Exp $
 */
@Controller
@RequestMapping("/dueDiligence")
public class DueDiligenceController {

	private Logger LOG = LoggerFactory.getLogger(ReviewNoteController.class);

	@Autowired
	private DueDiligenceBizFacadeImpl biz;

	@Autowired
	@Qualifier("dueDiligenceBiz")
	DueDiligenceBizFacade bizFacade;

	/**
	 * <h2>获取尽职调查表一条记录</h2>
	 * 
	 * @param reviewid
	 * @return modelAndView
	 */
	@RequestMapping("/queryDueDiligenceByOne")
	public ModelAndView queryDueDiligenceByOne(
			@RequestParam(value = "loanid", required = false) String loanid, PrintWriter out) {
		
		TDueDiligence dd = biz.selectByPrimaryKey(loanid);
		
		if (dd != null) {
			out.print(JSON.toJSONString(dd));
		};
		return null;
	}

	/**
	 * <h2>测试-尽职调查表录入</h2>
	 * 
	 * @param reviewid
	 * @return modelAndView
	 */
	@RequestMapping("/insertDueDiligence")
	public ModelAndView insertDueDiligence() {

		DueDiligenceReq record = new DueDiligenceReq();

		record.setLoanid("Loanid");
		record.setWorkcorp("Workcorp");
		record.setApplydate("Applydate");
		record.setSurveydate("Surveydate");
		record.setInvestigatorname("Investigatorname");
		record.setInvestigatorid("Investigatorid");
		record.setEnterprisename("Enterprisename");
		record.setApplicantname("Applicantname");
		record.setApplicantid("Applicantid");
		record.setAnnualturnover("Annualturnover");
		record.setSeasonal("1");
		record.setPeakseason("Peakseason");
		record.setOffseason("Offseason");
		record.setChecklicense("0");
		record.setCheckpos("1");
		record.setCheckid("0");
		record.setCheckpremises("1");
		record.setCheckhouse("0");
		record.setCheckphotoatdoor("1");
		record.setCheckagreement("0");
		record.setCheckphotoinpremises("1");
		record.setCheckform("0");
		record.setCheckphotosign("1");
		record.setNote("Note");
		record.setOpinion("Opinion");

		bizFacade.insertSelective(record);
		return null;
	}
}
