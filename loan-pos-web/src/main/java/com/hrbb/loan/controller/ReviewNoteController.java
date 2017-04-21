/**
 * 
 *	哈尔滨银行
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

import com.alibaba.fastjson.JSON;
import com.hrbb.loan.pos.biz.backstage.inter.ILoanPosBusinessCodeBiz;
import com.hrbb.loan.pos.biz.backstage.inter.ILoanPosCreditApplyBackStageBiz;
import com.hrbb.loan.pos.biz.backstage.inter.ReviewNoteBiz;
import com.hrbb.loan.pos.dao.entity.TReviewNote;
import com.hrbb.loan.pos.util.constants.BusinessDictionaryConstants;
import com.hrbb.loan.web.security.entity.User;

/**
 * 
 * @author marco
 * @version $Id: ReviewNoteController.java, v 0.1 2015-3-2 下午3:38:17 marco Exp $
 */
@Controller
@RequestMapping("/reviewNote")
public class ReviewNoteController {

	private Logger LOG = LoggerFactory.getLogger(ReviewNoteController.class);

	@Autowired
	@Qualifier("reviewNoteBiz")
	private ReviewNoteBiz reviewNoteBiz;

	@Autowired
	private ILoanPosBusinessCodeBiz loanPosBusinessCodeBiz;

	@Autowired
	private ILoanPosCreditApplyBackStageBiz creditApplyBackStageBiz;

	/**
	 * <h2>插入复审照会一条记录</h2>
	 * 
	 * @param reviewid
	 * @return modelAndView
	 * @throws Exception
	 */
	@RequestMapping("/insertReviewNote")
	public ModelAndView insertReviewNote(
			@RequestParam(value = "loanid", required = false) String loanid,
			@RequestParam(value = "teltype", required = false) String teltype,
			@RequestParam(value = "tel", required = false) String tel,
			@RequestParam(value = "relationtype", required = false) String relationtype,
			@RequestParam(value = "result", required = false) String result,
			// @RequestParam(value = "reviewday", required = false) String
			// reviewday,
			@RequestParam(value = "note", required = false) String note,
			@RequestParam(value = "flag", required = true) int flag,
			@RequestParam(value = "reviewId", required = false) Integer reviewId,
			PrintWriter out, HttpServletRequest request) throws Exception {

		User user = (User) request.getSession().getAttribute("USER");

		TReviewNote tReviewNote = new TReviewNote();
		tReviewNote.setloanid(loanid);
		tReviewNote.setReviewid(reviewId);
		tReviewNote.setTeltype(teltype);
		tReviewNote.setTel(tel);
		tReviewNote.setRelationtype(relationtype);
		tReviewNote.setResult(result);
		// tReviewNote.setReviewday(DateUtil.getDatePattern3(reviewday));
		tReviewNote.setReviewday(new Date());
		tReviewNote.setRegistrarname(user.getUserName());
		tReviewNote.setRegistrationday(new Date());
		tReviewNote.setNote(note);

		int ret = 0;
		// 登录
		if (flag == 1) {
			ret = reviewNoteBiz.insertTReviewNoteInfo(tReviewNote);
			// 更新
		} else {
			ret = reviewNoteBiz.updateByPrimaryKeySelective(tReviewNote);
		}
		// 成功
		if (ret == 1) {
			// 登录
			if (flag == 1) {
				out.print("录入成功。");
				// 更新
			} else {
				out.print("更新成功。");
			}
			// 失败
		} else {
			// 登录
			if (flag == 1) {
				out.print("录入失败，请联系系统管理员。");
				// 更新
			} else {
				out.print("更新失败，请联系系统管理员。");
			}
		}
		return null;
	}

	/**
	 * <h2>获取复审照会一条记录</h2>
	 * 
	 * @param reviewid
	 * @return modelAndView
	 */
	@RequestMapping("/queryReviewNoteByOne")
	public ModelAndView queryReviewNoteByOne(
			@RequestParam(value = "loanid", required = false) String loanid,
			@RequestParam(value = "reviewid", required = false) int reviewid) {
		TReviewNote tReviewNote = new TReviewNote();
		tReviewNote.setloanid(loanid);
		tReviewNote.setReviewid(reviewid);

		tReviewNote = reviewNoteBiz.getReviewNoteInfoById(tReviewNote);

		ModelAndView mav = new ModelAndView();
		mav.addObject("reviewNote", tReviewNote);
		mav.setViewName("reviewNoteByOne");
		return mav;
	}

	/**
	 * <h2>获取复审照会所有记录</h2>
	 * 
	 * @param pageNo
	 *            , pageSize
	 * @return modelAndView
	 */
	@RequestMapping("/queryReviewNoteAll")
	public ModelAndView queryReviewNoteAll(
			@RequestParam(value = "loanid", required = false) String loanid,
			HttpServletRequest request, PrintWriter out) {

		TReviewNote tReviewNote = new TReviewNote();
		tReviewNote.setloanid(loanid);
		List<TReviewNote> list = reviewNoteBiz
				.getReviewNoteInfoSelective(tReviewNote);

		out.write(JSON.toJSONString(list));
		return null;
	}

	/**
	 * <h2>删除复审照会记录</h2>
	 * 
	 * @param reviewid
	 * @return modelAndView
	 */
	@RequestMapping("/deleteReviewNote")
	public ModelAndView deleteReviewNote(
			@RequestParam(value = "loanid", required = false) String loanid,
			@RequestParam(value = "reviewids", required = false) String reviewids,
			PrintWriter out) {

		TReviewNote tReviewNote = new TReviewNote();
		tReviewNote.setloanid(loanid);
		tReviewNote.setReviewids(reviewids.split("[|]"));

		int flag = reviewNoteBiz.deleteTReviewNoteInfo(tReviewNote);
		// 删除失败
		if (flag < 0) {
			out.print("删除失败，请联系系统管理员。");
			// 删除成功
		} else {
			out.print("删除成功。");
		}
		return null;
	}

	/**
	 * 根据申请流水号获取审批相关的业务数据
	 * 
	 * @param loanId
	 * @param directTo
	 * @return
	 */
	@RequestMapping("/openReviewEditView")
	public ModelAndView openReviewEditView(
			@RequestParam(value = "loanId", required = true) String loanId,
			@RequestParam(value = "flag", required = true) int flag,
			@RequestParam(value = "reviewId", required = false) Integer reviewId,
			@RequestParam(value = "direct2Path", required = false) String direct2Path) {

		// 查询出申请详情中的各部分信息0业务申请信息;1客户信息;3商户信息;4银行账户信息;2亲属信息
		List<Map<String, Object>> resList = creditApplyBackStageBiz
				.getCreditApplyDetail(loanId);

		ModelAndView mav = new ModelAndView();

		// STEP 1 照会人行电话号码
		String peopleBankPhone = reviewNoteBiz
				.selectPeopleBankPhone((String) resList.get(1).get("paperId"));
		mav.addObject("peopleBankPhone", peopleBankPhone);
		mav.addObject("mobilePhone", (String) resList.get(1).get("mobilePhone"));
		mav.addObject("tel", (String) resList.get(1).get("tel"));
		mav.addObject("mateMobilephone",
				(String) resList.get(1).get("mateMobilephone"));
		mav.addObject("relaMobilePhone",
				(String) resList.get(2).get("relaMobilePhone"));
		mav.addObject("relaTel", (String) resList.get(2).get("relaTel"));
		
		// STEP 2 照会电话类
		List<Map<String, Object>> l = loanPosBusinessCodeBiz
				.getItemNames(BusinessDictionaryConstants.NoticePhone);
		mav.addObject("NoticePhones", l);

		// STEP 3 照会对象
		List<Map<String, Object>> r = loanPosBusinessCodeBiz
				.getItemNames(BusinessDictionaryConstants.NoticeTarget);
		mav.addObject("Relatives", r);

		mav.setViewName(direct2Path);

		// 更新
		TReviewNote tReviewNote = new TReviewNote();
		if (flag == 1) {
			tReviewNote.setTel((String) resList.get(1).get("mobilePhone"));
			tReviewNote.setResult("01");
		} else {
			tReviewNote.setloanid(loanId);
			tReviewNote.setReviewid(reviewId);
			tReviewNote = reviewNoteBiz.getReviewNoteInfoById(tReviewNote);
		}
		mav.addObject("reviewNote", tReviewNote);
		mav.addObject("reviewId", reviewId);
		mav.addObject("flag", flag);
		return mav;
	}
}
