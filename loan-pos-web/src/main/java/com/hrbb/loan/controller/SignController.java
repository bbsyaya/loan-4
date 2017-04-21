/**
 * 
 *	哈尔滨银行
 * Copyright (c) 2007-2015 HRBB,Inc.All Rights Reserved.
 */
package com.hrbb.loan.controller;

import java.io.PrintWriter;
import java.math.BigDecimal;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;
import java.util.Map;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.apache.commons.lang3.StringUtils;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.ModelAndView;

import com.alibaba.fastjson.JSON;
import com.google.common.collect.Maps;
import com.hrbb.loan.pos.biz.backstage.inter.BusinessDictionaryBiz;
import com.hrbb.loan.pos.biz.backstage.inter.CreditApplyAprvInfoBiz;
import com.hrbb.loan.pos.biz.backstage.inter.CreditApplyForReviewBiz;
import com.hrbb.loan.pos.biz.backstage.inter.CreditReportBiz;
import com.hrbb.loan.pos.biz.backstage.inter.ILoanPosBusinessCodeBiz;
import com.hrbb.loan.pos.biz.backstage.inter.ILoanPosCreditApplyBackStageBiz;
import com.hrbb.loan.pos.biz.backstage.inter.IPosEventsBiz;
import com.hrbb.loan.pos.biz.backstage.inter.UserApprInfoBiz;
import com.hrbb.loan.pos.dao.entity.TBusinessDictionary;
import com.hrbb.loan.pos.dao.entity.TCreditApply;
import com.hrbb.loan.pos.dao.entity.TCreditApplyAprvInfo;
import com.hrbb.loan.pos.dao.entity.TUserApprInfo;
import com.hrbb.loan.pos.util.StringUtil;
import com.hrbb.loan.pos.util.constants.ReviewNoteConstants;
import com.hrbb.loan.web.security.entity.User;
import com.hrbb.loan.web.security.service.UserService;

/**
 * 
 * @author marco
 * @version $Id: SignController.java, v 0.1 2015-3-11 上午11:35:10 marco Exp $
 */
@Controller
@RequestMapping("/sign")
public class SignController {

	private Logger LOG = LoggerFactory.getLogger(SignController.class);

	@Autowired
	@Qualifier("creditApplyAprvInfoBiz")
	private CreditApplyAprvInfoBiz biz;

	@Autowired
	@Qualifier("creditApplyForReviewBiz")
	private CreditApplyForReviewBiz bizCA;

	@Autowired
	@Qualifier("loanPosBusinessCodeBiz")
	private ILoanPosBusinessCodeBiz bizCode;

	@Autowired
	@Qualifier("businessDictionaryBiz")
	private BusinessDictionaryBiz bizDB;

	@Autowired
	@Qualifier("userApprInfoBiz")
	private UserApprInfoBiz userApprInfoBiz;

	@Autowired
	@Qualifier("creditReportBiz")
	private CreditReportBiz creditReportBiz;

	@Autowired
	@Qualifier("loanPosCreditApplyBackStageBiz")
	private ILoanPosCreditApplyBackStageBiz ILoanPosCreditApplyBackStageBiz;
	
	@Autowired
	@Qualifier("posEventsBiz")
	private IPosEventsBiz posEventsBiz;

	@Autowired
	@Qualifier("userService")
	private UserService userService;
	
	
	/**
	 * <h2>获取回退人，状态，名称信息</h2>
	 * 
	 * @param loanid
	 * @return modelAndView
	 */
	/**/
	@RequestMapping("/selectBackToInfo")
	public ModelAndView selectBackToInfo(
			@RequestParam(value = "loanid", required = false) String loanid,
			@RequestParam(value = "applyStatus", required = false) String apprState,
			HttpServletRequest request, PrintWriter out) {

		TCreditApplyAprvInfo info = new TCreditApplyAprvInfo();
		// 申请状态设定
		List<String> applyStatuses = new ArrayList<String>();

		applyStatuses.add(ReviewNoteConstants.APPLYSTATUS_CODE_20);
		// applyStatuses.add(ReviewNoteConstants.APPLYSTATUS_CODE_21);
		// 复审2阶段
		if (ReviewNoteConstants.APPLYSTATUS_CODE_33.equals(apprState)) {
			applyStatuses.add(ReviewNoteConstants.APPLYSTATUS_CODE_31);
		// 复审3阶段	
		}else if(ReviewNoteConstants.APPLYSTATUS_CODE_34.equals(apprState)){	
			applyStatuses.add(ReviewNoteConstants.APPLYSTATUS_CODE_33);
			// 尽调复审
		} else if (ReviewNoteConstants.APPLYSTATUS_CODE_41.equals(apprState)) {
			applyStatuses.add(ReviewNoteConstants.APPLYSTATUS_CODE_31);
			applyStatuses.add(ReviewNoteConstants.APPLYSTATUS_CODE_33);
			applyStatuses.add(ReviewNoteConstants.APPLYSTATUS_CODE_34);
			applyStatuses.add(ReviewNoteConstants.APPLYSTATUS_CODE_35);
			// applyStatuses.add(ReviewNoteConstants.APPLYSTATUS_CODE_32);
		}
		info.setLoanId(loanid);
		info.setApplyStatuses(applyStatuses);
		List<TCreditApplyAprvInfo> l = biz.selectBackToInfo(info);

		if (l != null && l.size() > 0) {
			out.print(JSON.toJSONString(l));
		}
		return null;
	}

	/**
	 * <h2>保存审批信息</h2>
	 * 
	 * @param reviewid
	 * @return modelAndView
	 */
	@RequestMapping("/saveSignInfo")
	public ModelAndView saveSignInfo(
			@RequestParam(value = "operFlagSign", required = false) int operFlagSign,
			@RequestParam(value = "loanid", required = false) String loanid,
			@RequestParam(value = "paperId", required = false) String paperId,
			@RequestParam(value = "applyStatus", required = false) String apprState,
			@RequestParam(value = "appNum", required = false) Integer appNum,
			@RequestParam(value = "apprAmount", required = false) String apprAmount,
			@RequestParam(value = "apprInte", required = false) String apprInte,
			@RequestParam(value = "apprResult", required = false) String apprResult,
			@RequestParam(value = "backToInfos", required = false) String backToInfos,
			@RequestParam(value = "apprInfo", required = false) String apprInfo,
			@RequestParam(value = "apprInfoExt", required = false) String apprInfoExt,
			@RequestParam(value = "refuseCode", required = false) String refuseCode,
			@RequestParam(value = "passCode", required = false) String passCode,
			@RequestParam(value = "returnKind", required = false) String returnKind,
			@RequestParam(value = "remark", required = false) String remark,
			@RequestParam(value = "loanType", required = false) String loanType,
			HttpServletRequest request, HttpServletResponse response,
			PrintWriter out) {

		// firefox下的正常提示
		response.setContentType("text/html;charset=UTF-8");

		// 查询最新申请状态
		TCreditApply ca = bizCA.selectOne(loanid);
		// 被主动撤销时
		if (ReviewNoteConstants.APPLYSTATUS_CODE_93.equals(ca.getApplyStatus())) {
			out.print("99:该笔申请已经被客户主动撤销，无需继续完成审批。");
			return null;
		}
		User user = (User) request.getSession().getAttribute("USER");
		// 申请审批表信息
		TCreditApplyAprvInfo record = new TCreditApplyAprvInfo();
		record.setLoanId(loanid);
		record.setApprState(apprState);
		record.setAppNum(appNum);

		if (!StringUtil.isEmpty(apprAmount)) {
			record.setApprAmount(new BigDecimal(apprAmount.replaceAll(",", "")));
		}
		if (!StringUtil.isEmpty(apprInte)) {
			record.setApprInte(new BigDecimal(apprInte));
		}

		record.setApprResult(apprResult);
		// 回退前手人ID:回退状态
		record.setBackToId(backToInfos);
		record.setApprInfo(apprInfo);
		record.setApprInfoExt(apprInfoExt);
		record.setApprvId(user.getUserName());
		// 权限控制
		String privileges = request.getSession()
				.getAttribute("assignedPrivileges").toString();
		record.setPrivileges(privileges);
		// 拒绝码
		record.setRefuseCode(refuseCode);
		// 通过码
		record.setPassCode(passCode);
		// 还款方式
		record.setRetuKind(returnKind);
		// 备注
		record.setRemark(remark);

		int flag = 0;
		// 保存
		if (operFlagSign == 0) {
			// 更新申请审批记录表
			flag = biz.updateByPrimaryKeySelective(record);
			// 提交
		} else if (operFlagSign == 1) {
			// 资料审核或资料审核补件,且通过时,检查征信报告有效性
			if ((ReviewNoteConstants.APPLYSTATUS_CODE_20.equals(apprState) || ReviewNoteConstants.APPLYSTATUS_CODE_21
					.equals(apprState))
					&& ReviewNoteConstants.APPRRESULT_CODE_10
							.equals(apprResult)) {
				// 检查征信报告有效性
				int result = creditReportBiz.checkCreditReport(paperId);
				LOG.debug("查询结果result=" + result);
				// 征信报告有效
				if (result == ReviewNoteConstants.CREDIT_REPORT_RESULT_VALUE_0) {
					LOG.debug("loanType=" + loanType);
					// 资金池模式
					if (ReviewNoteConstants.LOANTYPE_02.equals(loanType)) {
						Map<String, Object> reqMap = Maps.newHashMap();
						reqMap.put("certNo", paperId);
						reqMap.put("channel", ca.getChannel());
						// 打包征信报告，加密，推ftp
						Map<String, Object> resultMap = ILoanPosCreditApplyBackStageBiz
								.uploadCreditInvestHtml(reqMap);
						if (resultMap == null) {
							out.print("25:打包征信报告失败，请联系技术人员！");
							flag = 2;
						} else {
							// 打包成功
							if ("0".equals(resultMap.get("respCode"))) {
								// 审批结束时间
								record.setAppEndTime(new Date());
								// 更新
								Map<String, Object> updateResMap = biz
										.updateCreditApplyForCashPooling(
												record, resultMap);
								flag = (int) updateResMap.get("flag");
								record = (TCreditApplyAprvInfo) updateResMap
										.get("record");
							} else {
								out.print("29:" + resultMap.get("respMsg"));
								flag = 2;
							}
						}
					} else {
						// 审批结束时间
						record.setAppEndTime(new Date());
						// 更新申请表，申请审批记录表
						Map<String, Object> updateResMap = biz.update(record);
						flag = (int) updateResMap.get("flag");
						record = (TCreditApplyAprvInfo) updateResMap
								.get("record");
					}
					// 征信报告不完整
				} else if (result == ReviewNoteConstants.CREDIT_REPORT_RESULT_VALUE_2) {
					out.print("24:征信报告不完整，请联系技术人员！");
					flag = 2;
					// 申请人姓名与征信报告不一致
				} else if (result == ReviewNoteConstants.CREDIT_REPORT_RESULT_VALUE_5) {
					out.print("23:申请人姓名与征信报告不一致，请确认修改后重新提交！");
					flag = 2;
					// CREDIT_REPORT_RESULT_VALUE=1,4
				} else {
					out.print("22:征信报告不存在或超过20天，请获取最新的征信报告。");
					flag = 2;
				}
				// 资料审核通过前检查征信报告是否有效
				// if (checkCreditReport(paperId)) {
				// // 审批结束时间
				// record.setAppEndTime(new Date());
				// // 更新申请表，申请审批记录表
				// flag = biz.update(record);
				// } else {
				// out.print("21:征信报告不存在或超过20天，请获取最新的征信报告。");
				// flag = 2;
				// }
				// 资料审核或资料审核补件以外，或通过以外
				// 在复审1，2, 3阶段，选择通过或拒绝时，如果批复金额大于最大批复通过金额或最大批复拒绝金额时，自动改为上签操作
			} else if ((ReviewNoteConstants.APPLYSTATUS_CODE_31
					.equals(apprState) || ReviewNoteConstants.APPLYSTATUS_CODE_33
					.equals(apprState) || ReviewNoteConstants.APPLYSTATUS_CODE_34
					.equals(apprState))
					&& (ReviewNoteConstants.APPRRESULT_CODE_10
							.equals(apprResult) || ReviewNoteConstants.APPRRESULT_CODE_20
							.equals(apprResult))) {
				// 审批结束时间
				record.setAppEndTime(new Date());
				// 查询保存的审批信息
				TUserApprInfo uai = userApprInfoBiz.selectByPrimaryKey(user
						.getUserName());
				// 查询操作者的最大批复拒绝金额
				if (uai == null) {
					// 更新申请表，申请审批记录表
					Map<String, Object> updateMap = biz
							.updateCreditApplyForUpSign(record);
					flag = (int) updateMap.get("flag");
					record = (TCreditApplyAprvInfo) updateMap.get("record");
				} else {
					// 通过时
					if (ReviewNoteConstants.APPRRESULT_CODE_10
							.equals(apprResult)) {
						if (uai.getQuota() == null) {
							// 更新申请表，申请审批记录表
							Map<String, Object> updateMap = biz
									.updateCreditApplyForUpSign(record);
							flag = (int) updateMap.get("flag");
							record = (TCreditApplyAprvInfo) updateMap
									.get("record");
						} else {
							// 最大批复通过金额
							BigDecimal quota = uai.getQuota();
							// 批复金额
							BigDecimal apprAmountBD = new BigDecimal(
									apprAmount.replaceAll(",", ""));
							// 批复金额大于最大批复通过金额时
							if (apprAmountBD.compareTo(quota) == 1) {
								// 更新申请表，申请审批记录表
								Map<String, Object> updateMap = biz
										.updateCreditApplyForUpSign(record);
								flag = (int) updateMap.get("flag");
								record = (TCreditApplyAprvInfo) updateMap
										.get("record");
							} else {
								// 更新申请表，申请审批记录表
								Map<String, Object> updateMap = biz
										.update(record);
								flag = (int) updateMap.get("flag");
								record = (TCreditApplyAprvInfo) updateMap
										.get("record");
							}
						}
						
						// 拒绝时
					} else {
						if (uai.getRefuseQuota() == null) {
							// 更新申请表，申请审批记录表
							Map<String, Object> updateMap = biz
									.updateCreditApplyForUpSign(record);
							flag = (int) updateMap.get("flag");
							record = (TCreditApplyAprvInfo) updateMap
									.get("record");
						} else {
							// 最大批复拒绝金额
							BigDecimal refuseQuota = uai.getRefuseQuota();
							// 批复金额
							BigDecimal apprAmountBD = null;
							if (StringUtil.isEmpty(apprAmount)) {
								apprAmountBD = BigDecimal.ZERO;
							} else {
								apprAmountBD = new BigDecimal(
										apprAmount.replaceAll(",", ""));
							}
							// 批复金额大于最大批复拒绝金额时
							if (apprAmountBD.compareTo(refuseQuota) == 1) {
								// 更新申请表，申请审批记录表
								Map<String, Object> updateMap = biz
										.updateCreditApplyForUpSign(record);
								flag = (int) updateMap.get("flag");
								record = (TCreditApplyAprvInfo) updateMap
										.get("record");
							} else {
								// 更新申请表，申请审批记录表
								// 更新申请表，申请审批记录表
								Map<String, Object> updateMap = biz
										.update(record);
								flag = (int) updateMap.get("flag");
								record = (TCreditApplyAprvInfo) updateMap
										.get("record");
							}
						}
					}
				}
			} else {
				// 审批结束时间
				record.setAppEndTime(new Date());
				// 更新申请表，申请审批记录表
				Map<String, Object> updateMap = biz.update(record);
				flag = (int) updateMap.get("flag");
				record = (TCreditApplyAprvInfo) updateMap.get("record");
			}
			// 上签
		} else {
			// 审批结束时间
			record.setAppEndTime(new Date());
			// 更新申请表，申请审批记录表
			Map<String, Object> updateMap = biz
					.updateCreditApplyForUpSign(record);
			flag = (int) updateMap.get("flag");
			record = (TCreditApplyAprvInfo) updateMap.get("record");
		}
		
		/*提交到复审4时推送mail通知*/
		if(record.getApprState().equals(ReviewNoteConstants.APPLYSTATUS_CODE_35)){
			try{
				posEventsBiz.doPosEvents(loanid);
			}catch(Exception ex){
				LOG.warn("添加邮件征听listener失败!",ex);
			}
		}

		// 保存成功
		if (flag == 1) {
			// 保存
			if (operFlagSign == 0) {
				out.print("11:保存成功。");
				// 提交
			} else {
				// 申请状态名称查询
				TBusinessDictionary bd = new TBusinessDictionary();
				bd.setCodeNo(ReviewNoteConstants.BD_CODENO_APPLYSTATUS);
				bd.setItemNo(record.getApprState());
				bd = bizDB.selectOne(bd);
				out.print("12:该笔申请成功提交到" + bd.getItemName() + "阶段");
			}
			// 保存失败
		} else if (flag == 0) {
			// 保存
			if (operFlagSign == 0) {
				out.print("91:保存失败，请联系系统管理员。");
				// 提交
			} else {
				out.print("92:提交失败，请联系系统管理员。");
			}
		}
		// 征信报告失效时，不做后续处理。

		return null;
	}

	/**
	 * <h2>查询操作者的审批额度</h2>
	 * 
	 * @param UserName
	 * @return modelAndView
	 */
	@RequestMapping("/queryUserApprQuota")
	public ModelAndView queryUserApprQuota(HttpServletRequest request,
			PrintWriter out) {

		User user = (User) request.getSession().getAttribute("USER");
		// 查询保存的审批信息
		TUserApprInfo uai = userApprInfoBiz.selectByPrimaryKey(user
				.getUserName());
		// 查询操作者的最大审批额度
		if (uai == null || uai.getQuota() == null) {
			out.print(JSON.toJSONString(BigDecimal.ZERO));
		} else {
			out.print(JSON.toJSONString(uai.getQuota()));
		}
		return null;
	}
	
	/**
	 * 打开复审调件窗口
	 * 
	 * @param loanId
	 * @return
	 */
	@RequestMapping("/openAdjustApproval")
	public ModelAndView openAdjustApproval(@RequestParam(value="loanId", required=true) String loanId){
	    ModelAndView mav = new ModelAndView();
	    TCreditApply applyInfo = bizCA.selectOne(loanId);
	    List<Map<String, Object>> userList = userService.selectUsersByApplyStatus(applyInfo.getApplyStatus());
	    mav.addObject("userList", userList);
	    mav.addObject("applyInfo", applyInfo);
	    mav.setViewName("review/adjustApproval");
	    return mav;
	}
	
	@RequestMapping("/adjustApproval")
	public ModelAndView adjustApproval(@RequestParam(value="loanId", required=true) String loanId,
	                                   HttpServletRequest request, PrintWriter out){
	    TCreditApply applyInfo = bizCA.selectOne(loanId);   
	    String applyStatus =  request.getParameter("applyStatus");
	    String loginName = request.getParameter("loginName");
	    String userName = request.getParameter("userName");
	    String applyStatusName = request.getParameter("applyStatusName");
	    LOG.debug("复审调件 loanId：" + loanId + ", applyStatus: " + applyStatus + ", userName: " + userName);
	    if(!StringUtils.isEmpty(applyStatus)&&!StringUtils.isEmpty(userName)){
	        if(!ReviewNoteConstants.APPLYSTATUS_CODE_31.equals(applyInfo.getApplyStatus())&&
	                !ReviewNoteConstants.APPLYSTATUS_CODE_33.equals(applyInfo.getApplyStatus())&&
	                !ReviewNoteConstants.APPLYSTATUS_CODE_34.equals(applyInfo.getApplyStatus())&&
	                !ReviewNoteConstants.APPLYSTATUS_CODE_35.equals(applyInfo.getApplyStatus())){
	            out.print(JSON.toJSONString("不是复审阶段的申请,不能调件!"));
	            return null;
	        }
	        int flag = biz.adjustApprovalInfo(loanId, applyStatus, userName);
	        if(flag == 1){
	            out.print("成功调件到：" + applyStatusName +", " + loginName);
	            return null;
	        }else{
	            out.print(JSON.toJSONString("调件失败!"));
	            return null;
	        }
	    }
	    out.print(JSON.toJSONString("调件失败复审阶段或复审人为空!"));
	    return null;
	}
}
