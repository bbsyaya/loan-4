/**
 * 
 *	哈尔滨银行
 * Copyright (c) 2007-2015 HRBB,Inc.All Rights Reserved.
 */
package com.hrbb.loan.controller;

import java.io.PrintWriter;
import java.util.ArrayList;
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
import com.hrbb.loan.constants.black.BlacklistConstants;
import com.hrbb.loan.constants.black.BlacklistIntervalTypeEnum;
import com.hrbb.loan.pos.biz.backstage.inter.CreditApplyForReviewBiz;
import com.hrbb.loan.pos.biz.backstage.inter.CreditReportIdentityBiz;
import com.hrbb.loan.pos.biz.backstage.inter.ILoanPosBlacklistBackStageBiz;
import com.hrbb.loan.pos.dao.entity.TBlacklist;
import com.hrbb.loan.pos.dao.entity.TCreditReportIdentity;
import com.hrbb.loan.pos.util.constants.ReviewNoteConstants;
import com.hrbb.loan.pos.util.enums.BlackListTypeEnum;
import com.hrbb.loan.web.security.entity.User;

/**
 * 复审-添加黑名单
 * 
 * @author marco
 * @version $Id: CreditApplyBlackListController.java, v 0.1 2015-3-31 下午4:29:27
 *          marco Exp $
 */
@Controller
@RequestMapping("/creditApplyBlackList")
public class CreditApplyBlackListController {

	private final Logger logger = LoggerFactory
			.getLogger(CreditApplyBlackListController.class);

	@Autowired
	@Qualifier("creditApplyForReviewBiz")
	private CreditApplyForReviewBiz biz;

	@Autowired
	@Qualifier("creditReportIdentityBiz")
	private CreditReportIdentityBiz creditReportIdentityBiz;

	@Autowired
	@Qualifier("iLoanPosBlacklistBackStageBiz")
	private ILoanPosBlacklistBackStageBiz iLoanPosBlacklistBackStageBiz;

	/**
	 * <h2>补件资料下载成功后，创建补件发起人的工作</h2>
	 * 
	 * @param reviewid
	 * @return modelAndView
	 */
	@RequestMapping("/initBlackList")
	public ModelAndView initBlackList(
			@RequestParam(value = "loanId", required = false) String loanId,
			HttpServletRequest request, PrintWriter out) {
		// 检索黑名单认定维度申请信息
		Map<String, Object> m = biz.selectForRiskDetectionByOne(loanId);

		String paperId = m
				.get(ReviewNoteConstants.RISKDETECTIO_MAP_KEY_PAPERID)
				.toString();
		// 检索黑名单认定维度征信信息
		TCreditReportIdentity cri = creditReportIdentityBiz
				.selectInfor(paperId);

		List<TBlacklist> l = new ArrayList<>();
		// 申请人身份证号
		TBlacklist bl = new TBlacklist();
		bl.setInfoDimension(BlackListTypeEnum.INFODIMENSION_PAPERID
				.getDescription());
		bl.setInfoType(BlackListTypeEnum.INFOTYPE_PAPERID.getValue());
		bl.setInfoTypeName(BlackListTypeEnum.INFOTYPE_PAPERID.getDescription());
		bl.setInfoDetail(paperId);
		l.add(bl);
		// 申请人手机
		bl = new TBlacklist();
		bl.setInfoDimension(BlackListTypeEnum.INFODIMENSION_MOBILEPHONE
				.getDescription());
		bl.setInfoType(BlackListTypeEnum.INFOTYPE_TEL.getValue());
		bl.setInfoTypeName(BlackListTypeEnum.INFOTYPE_TEL.getDescription());
		bl.setInfoDetail(m.get(
				ReviewNoteConstants.RISKDETECTIO_MAP_KEY_MOBILEPHONE)
				.toString());
		l.add(bl);
		// 申请人办公电话
		bl = new TBlacklist();
		bl.setInfoDimension(BlackListTypeEnum.INFODIMENSION_TEL
				.getDescription());
		bl.setInfoType(BlackListTypeEnum.INFOTYPE_TEL.getValue());
		bl.setInfoTypeName(BlackListTypeEnum.INFOTYPE_TEL.getDescription());
		bl.setInfoDetail(m.get(ReviewNoteConstants.RISKDETECTIO_MAP_KEY_TEL)
				.toString());
		l.add(bl);
		// 申请人住宅地址
		bl = new TBlacklist();
		bl.setInfoDimension(BlackListTypeEnum.INFODIMENSION_RESIDENTDETAIL
				.getDescription());
		bl.setInfoType(BlackListTypeEnum.INFOTYPE_ADDRESS.getValue());
		bl.setInfoTypeName(BlackListTypeEnum.INFOTYPE_ADDRESS.getDescription());
		bl.setInfoDetail(m.get(
				ReviewNoteConstants.RISKDETECTIO_MAP_KEY_RESIDENTDETAIL)
				.toString());
		l.add(bl);
		// 商户名称
		bl = new TBlacklist();
		bl.setInfoDimension(BlackListTypeEnum.INFODIMENSION_POSCUSTNAME
				.getDescription());
		bl.setInfoType(BlackListTypeEnum.INFOTYPE_NAME.getValue());
		bl.setInfoTypeName(BlackListTypeEnum.INFOTYPE_NAME.getDescription());
		bl.setInfoDetail(m.get(
				ReviewNoteConstants.RISKDETECTIO_MAP_KEY_POSCUSTNAME)
				.toString());
		l.add(bl);
		// 商户经营地址
		bl = new TBlacklist();
		bl.setInfoDimension(BlackListTypeEnum.INFODIMENSION_POSCUSTADDRESS
				.getDescription());
		bl.setInfoType(BlackListTypeEnum.INFOTYPE_ADDRESS.getValue());
		bl.setInfoTypeName(BlackListTypeEnum.INFOTYPE_ADDRESS.getDescription());
		bl.setInfoDetail(m.get(
				ReviewNoteConstants.RISKDETECTIO_MAP_KEY_POSCUSTADDRESS)
				.toString());
		l.add(bl);
		// 征信报告申请人手机号码
		bl = new TBlacklist();
		bl.setInfoDimension(BlackListTypeEnum.INFODIMENSION_MOBILE
				.getDescription());
		bl.setInfoType(BlackListTypeEnum.INFOTYPE_TEL.getValue());
		bl.setInfoTypeName(BlackListTypeEnum.INFOTYPE_TEL.getDescription());
		bl.setInfoDetail(cri.getMobile());
		l.add(bl);
		// 征信报告申请人住宅电话
		bl = new TBlacklist();
		bl.setInfoDimension(BlackListTypeEnum.INFODIMENSION_HOMETEL
				.getDescription());
		bl.setInfoType(BlackListTypeEnum.INFOTYPE_TEL.getValue());
		bl.setInfoTypeName(BlackListTypeEnum.INFOTYPE_TEL.getDescription());
		bl.setInfoDetail(cri.getHomeTel());
		l.add(bl);

		out.write(JSON.toJSONString(l));
		return null;
	}

	/**
	 * <h2>保存黑名单</h2>
	 * 
	 * @param reviewid
	 * @return modelAndView
	 */
	@RequestMapping("/saveBlackListForReview")
	public ModelAndView saveBlackListForReview(
			@RequestParam(value = "infoTypes", required = false) String infoTypes,
			@RequestParam(value = "infoDetails", required = false) String infoDetails,
			@RequestParam(value = "confirmReason", required = false) String confirmReason,
			HttpServletRequest request, PrintWriter out) {
		logger.debug("saveBlackListForReview begin");
		// 操作人
		User user = (User) request.getSession().getAttribute("USER");
		Date now = new Date();
		TBlacklist bl = new TBlacklist();
		bl.setInfoType(infoTypes);
		bl.setInfoDetail(infoDetails);
		bl.setConfirmUser(user.getUserName());
		bl.setConfirmTime(now);
		bl.setConfirmReason(confirmReason);
		bl.setEffectTime(now);
		bl.setIntervalType(BlacklistIntervalTypeEnum.INTERVAL_TYPE_EVER.getValue());
		bl.setCreateTime(now);
		bl.setDelFlag(BlacklistConstants.DEL_FLAG_NUDEL);
		bl.setConfirmUserId(user.getUserName());
		bl.setEffectFlag(BlacklistConstants.EFFECT_FLAG_Y);
		int flag = iLoanPosBlacklistBackStageBiz.insertBlacklists(bl);
		logger.debug("flag=" + flag);
		// 保存成功
		if (flag >= 0) {
			out.print("添加黑名单成功。");
			// 保存失败
		} else {
			out.print("添加黑名单失败。");
		}
		logger.debug("saveBlackListForReview end");
		return null;
	}
}
