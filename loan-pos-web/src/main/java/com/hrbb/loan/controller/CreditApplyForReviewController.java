package com.hrbb.loan.controller;

import java.awt.image.BufferedImage;
import java.io.ByteArrayInputStream;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.io.InputStream;
import java.io.PrintWriter;
import java.util.Date;
import java.util.List;
import java.util.Map;

import javax.imageio.ImageIO;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.apache.commons.codec.binary.Base64;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.ModelAndView;

import com.alibaba.fastjson.JSON;
import com.alibaba.fastjson.JSONObject;
import com.google.common.collect.Maps;
import com.hrbb.loan.controller.helper.ControllerHelper;
import com.hrbb.loan.pos.biz.backstage.inter.ApproveResultBiz;
import com.hrbb.loan.pos.biz.backstage.inter.CreditApplyForReviewBiz;
import com.hrbb.loan.pos.biz.backstage.inter.ILoanPosBusinessCodeBiz;
import com.hrbb.loan.pos.biz.backstage.inter.LoanRiskCheckBiz;
import com.hrbb.loan.pos.dao.entity.TApproveResult;
import com.hrbb.loan.pos.dao.entity.TCreditApply;
import com.hrbb.loan.pos.service.LoanPosCreditApplyService;
import com.hrbb.loan.pos.service.PoliceAndAICConnectService;
import com.hrbb.loan.pos.util.StringUtil;
import com.hrbb.loan.pos.util.constants.ReviewNoteConstants;
import com.hrbb.loan.web.security.entity.User;

/**
 * <h1>CreditApplyForReviewController</h1>
 * 
 * @author marco
 * @version Id: CreditApplyForReviewController.java, v 1.0 2015-2-5 下午3:14:59
 *          marco Exp
 */
@Controller
@RequestMapping("/creditApplyForReview")
public class CreditApplyForReviewController {
    
    private Logger logger = LoggerFactory.getLogger(CreditApplyForReviewController.class);

	@Autowired
	@Qualifier("creditApplyForReviewBiz")
	private CreditApplyForReviewBiz biz;

	@Autowired
	@Qualifier("loanRiskCheckBiz")
	private LoanRiskCheckBiz bizLoanRiskCheck;
	
	@Autowired
	private LoanPosCreditApplyService loanPosCreditApplyService;

	@Autowired
	private PoliceAndAICConnectService policeInfoService;

	@Autowired
	private ILoanPosBusinessCodeBiz loanPosBusinessCodeBiz;

	@Autowired
	private ApproveResultBiz arBiz;

	/**
	 * <h2>获取申请记录</h2>
	 * 
	 * @param pageNo
	 *            , pageSize
	 * @return modelAndView
	 */
	@RequestMapping("/queryCreditApplyForReview")
	public ModelAndView queryCreditApplyForReview(
			@RequestParam(value = "opflag", required = false) String opflag,
			@RequestParam(value = "rows", required = false) Integer limit,
			@RequestParam(value = "page", required = false) Integer startPage,
			HttpServletRequest request, PrintWriter out) {
		TCreditApply ca = new TCreditApply();
		String bizLoanId = request.getParameter("bizLoanId");
		if (!StringUtil.isEmpty(bizLoanId)) {
			ca.setBizLoanId(bizLoanId);
		}
		String loanId = request.getParameter("loanId");
		if (!StringUtil.isEmpty(loanId)) {
			ca.setLoanId(loanId);
		}
		String posCustName = request.getParameter("posCustName");
		if (!StringUtil.isEmpty(posCustName)) {
			ca.setPosCustName(ControllerHelper.getLikeString(posCustName));
		}
		String custId = request.getParameter("custId");
		if (!StringUtil.isEmpty(custId)) {
			ca.setCustId(custId);
		}
		String custName = request.getParameter("custName");
		if (!StringUtil.isEmpty(custName)) {
			ca.setCustName(ControllerHelper.getLikeString(custName));
		}
		String channel = request.getParameter("channel");
		if (!StringUtil.isEmpty(channel)) {
			ca.setChannelCode(channel);
		}
		String occurType = request.getParameter("occurType");
		if (!StringUtil.isEmpty(occurType)) {
			ca.setOccurType(occurType);
		}
		String remark = request.getParameter("remark");
		if(!StringUtil.isEmpty(remark)){
		    ca.setRemark(ControllerHelper.getLikeString(remark));
		}
		// 操作人
		User user = (User) request.getSession().getAttribute("USER");
		ca.setOperName(user.getUserName());
		// 权限控制
		String privileges = request.getSession()
				.getAttribute("assignedPrivileges").toString();
		// 根据权限，设置要更新的各阶段负责人<
		setPrivileges(privileges, ca);
		// 操作标志位
		// ca.setOpflag(opflag.toString());
		ca.setOpflag(opflag == null ? "1" : opflag);
		// 申请开始日期开始
		String beginDateFrom = request.getParameter("beginDateFrom");
		if (!StringUtil.isEmpty(beginDateFrom)) {
			ca.setBeginDateFrom(beginDateFrom);
		}
		// 申请开始日期结束
		String beginDateTo = request.getParameter("beginDateTo");
		if (!StringUtil.isEmpty(beginDateTo)) {
			ca.setBeginDateTo(beginDateTo);
		}
		
		ca.setStartPage((startPage - 1) * limit);
		ca.setLimit(limit);
		List<TCreditApply> lists = biz.selectSelective(ca);
		JSONObject aaJson = new JSONObject();
		aaJson.put("rows", lists);
		// 查询记录总件数
		long count = biz.selectSelectiveCount(ca);
		aaJson.put("total", count);
		out.write(aaJson.toJSONString());
		return null;
	}

	/**
	 * <h2>获取风险预测结果</h2>
	 * 
	 * @param loanId
	 * 
	 * @return modelAndView
	 */
	@RequestMapping("/selectForRiskDetection")
	public ModelAndView selectForRiskDetection(
			@RequestParam(value = "loanId", required = false) String loanId,
			PrintWriter out) {

		List<Map<String, Object>> l = bizLoanRiskCheck
				.selectForRiskDetection(loanId);
		out.print(JSON.toJSONString(l));
		return null;
	}

	/**
	 * <h2>根据权限，设置要更新的各阶段负责人</h2>
	 * 
	 * @param privileges
	 *            , ca
	 * @return
	 */
	private void setPrivileges(String privileges, TCreditApply ca) {
		// 资料录入
		if (privileges.indexOf(ReviewNoteConstants.ROLE_INFO) >= 0) {
			// 资料录入人员
			ca.setPrivilege0(ReviewNoteConstants.ROLE_CODE_0);
		}
		// 资料审核
		if (privileges.indexOf(ReviewNoteConstants.ROLE_INFO_APPR) >= 0) {
			// 资料审核人员
			ca.setPrivilege1(ReviewNoteConstants.ROLE_CODE_1);
			// 资料审核人员可以查看受理状态的申请 add by Lin,Zhaolin
			ca.setPrivilege0(ReviewNoteConstants.ROLE_CODE_0);
		}
		// 风险复审1
		if (privileges.indexOf(ReviewNoteConstants.ROLE_APPR_LV1) >= 0) {
			// 信贷复审人员
			ca.setPrivilege21(ReviewNoteConstants.ROLE_CODE_2);
		}
		// 风险复审2
		if (privileges.indexOf(ReviewNoteConstants.ROLE_APPR_LV2) >= 0) {
			// 信贷复审人员
			ca.setPrivilege22(ReviewNoteConstants.ROLE_CODE_2);
		}
		// 风险复审3
		if (privileges.indexOf(ReviewNoteConstants.ROLE_APPR_LV3) >= 0) {
			// 信贷复审人员
			ca.setPrivilege23(ReviewNoteConstants.ROLE_CODE_2);
		}
		// 风险复审4
		if (privileges.indexOf(ReviewNoteConstants.ROLE_APPR_LV4) >= 0) {
			// 信贷复审人员
			ca.setPrivilege24(ReviewNoteConstants.ROLE_CODE_2);
		}
		// 尽调复审
		if (privileges.indexOf(ReviewNoteConstants.ROLE_DUE_DILI) >= 0) {
			// 尽调人员
			ca.setPrivilege3(ReviewNoteConstants.ROLE_CODE_3);
		}
	}

	/**
	 * <h2>任务认领</h2>
	 * 
	 * @param loanid
	 * @return modelAndView
	 */
	@RequestMapping("/claim")
	public ModelAndView claim(
			@RequestParam(value = "loanid", required = false) String loanid,
			@RequestParam(value = "applyStatus", required = false) String applyStatus,
			@RequestParam(value = "bizLoanId", required = false) String bizLoanId,
			PrintWriter out, HttpServletRequest request) {

		User user = (User) request.getSession().getAttribute("USER");

		TCreditApply ca = new TCreditApply();
		ca.setLoanId(loanid);
		ca.setApplyStatus(applyStatus);
		ca.setBizLoanId(bizLoanId);
		ca.setOperName(user.getUserName());
		ca.setLastOperId(user.getUserName());
		ca.setLastOperTime(new Date());

		String[] loanids = ca.getLoanId().split(
				ReviewNoteConstants.STRING_SEPARATOR_CODE);

		Map<String, Object> respMap = biz.claim(ca);
		int flag = (int) respMap.get("flag");
		ca = (TCreditApply) respMap.get("tCreditApply");
		// 认领失败
		if (flag < 0) {
			out.print("认领失败，请联系系统管理员。");
			// 认领成功
		} else {
			int total = loanids.length;
			// 被认领的申请编号
			List<String> loanIdsClaimed = ca.getLoanIdClaimed();

			StringBuffer msg = new StringBuffer();
			// 认领成功
			if (loanIdsClaimed.size() < total) {
				msg.append("认领成功。");
			}
			for (String loanIdClaimed : loanIdsClaimed) {
				msg.append("\n申请编号为" + loanIdClaimed + "的申请已被他人认领。");
			}
			out.print(msg.toString());
		}
		return null;
	}

	/**
	 * <h2>任务回池</h2>
	 * 
	 * @param loanid
	 * @return modelAndView
	 */
	@RequestMapping("/doNotClaim")
	public ModelAndView doNotClaim(
			@RequestParam(value = "loanid", required = false) String loanid,
			@RequestParam(value = "applyStatus", required = false) String applyStatus,
			@RequestParam(value = "backReason", required = false) String backReason,
			PrintWriter out, HttpServletRequest request) {

		User user = (User) request.getSession().getAttribute("USER");

		TCreditApply ca = new TCreditApply();
		ca.setLoanId(loanid);
		ca.setApplyStatus(applyStatus);
		// 回池原因
		ca.setBackReason(backReason);
		ca.setLastOperId(user.getUserName());
		ca.setLastOperTime(new Date());

		Map<String, Object> respMap = biz.doNotClaim(ca);
		int flag = (int) respMap.get("flag");
		ca = (TCreditApply) respMap.get("tCreditApply");
		// 回池失败
		if (flag < 1) {
			out.print("回池失败，请联系系统管理员。");
			// 回池成功
		} else {
			out.print("回池成功。");
		}
		return null;
	}
	   /**
     * <h2>申请退回</h2>
     * 
     * @param loanid
     * @return modelAndView
     */
    @RequestMapping("/backReason")
    public ModelAndView backReason(
            @RequestParam(value = "loanid", required = false) String loanid,
            @RequestParam(value = "applyStatus", required = false) String applyStatus,
            @RequestParam(value = "backReason", required = false) String backReason,
            PrintWriter out, HttpServletRequest request) {

        User user = (User) request.getSession().getAttribute("USER");

        TCreditApply ca = new TCreditApply();
        ca.setLoanId(loanid);
        ca.setApplyStatus(applyStatus);
        // 回池原因
        ca.setBackReason(backReason);
        ca.setLastOperId(user.getUserName());
        ca.setLastOperTime(new Date());

        Map<String, Object> respMap = biz.doNotClaim(ca);
        int flag = (int) respMap.get("flag");
        ca = (TCreditApply) respMap.get("tCreditApply");
        // 回池失败
        if (flag < 1) {
            logger.info(loanid+"回池失败，请联系系统管理员。");
            out.print("退回失败[原因:回池失败!]");
            // 回池成功
        } else {
            logger.info(loanid+"回池成功。");
            Map<String,Object> updateMap = Maps.newHashMap();
            updateMap.put("applyStatus", "00");
            updateMap.put("loanId", loanid);
            // 更改申请状态到00
            int uptflag= loanPosCreditApplyService.updateApplyStatus(updateMap);
            if(uptflag>0){
                out.print("退回成功!");
            }else{
                out.print("退回失败[原因:回池成功,更改状态失败!]");
            }
        }
        return null;
    }
	
	@RequestMapping("/viewPhoto")
	public ModelAndView viewPhoto(
			@RequestParam(value = "certId", required = true) String certId,
			HttpServletRequest request, HttpServletResponse response)
			throws IOException {

		// String fotoCode = "";
		// 1.在内存中创建一张图片
		BufferedImage bufferImg = null;

		Map<String, Object> reqMap = Maps.newHashMap();
		reqMap.put("idNo", certId);
		List<Map<String, Object>> resultSet = policeInfoService
				.selectByCertNo(reqMap);
		if (resultSet == null || resultSet.size() == 0) {
			// no record
			bufferImg = getDefultPhoto(certId, request);

		} else {
			String fotoCode = (String) resultSet.get(0).get("photo");

			if (fotoCode == null || fotoCode.trim().length() == 0) {
				bufferImg = getDefultPhoto(certId, request);

			} else {
				byte[] decode = Base64.decodeBase64(fotoCode);
				InputStream is = new ByteArrayInputStream(decode);
				bufferImg = ImageIO.read(is);
			}
		}

		// 设置响应头通知浏览器以图片的形式打开
		response.setContentType("image/jpeg");// 等同于response.setHeader("Content-Type",
												// "image/jpeg");
		// 设置响应头控制浏览器不要缓存
		response.setDateHeader("expries", -1);
		response.setHeader("Cache-Control", "no-cache");
		response.setHeader("Pragma", "no-cache");
		// 将图片写给浏览器
		ImageIO.write(bufferImg, "JPG", response.getOutputStream());

		return null;
	}

	private BufferedImage getDefultPhoto(String certId,
			HttpServletRequest request) throws FileNotFoundException,
			IOException {
		String imgPath = request.getSession().getServletContext()
				.getRealPath("/img");
		// System.out.println("imgPath="+imgPath);
		BufferedImage bufferImg = null;

		if (certId == null || certId.length() != 18) {
			imgPath = imgPath + "/nophoto_m.jpg";
		} else {
			int sex = Integer.valueOf(certId.substring(16, 17)); // 性别
			if ((sex % 2) == 0) {
				imgPath = imgPath + "/nophoto_f.jpg";
			} else {
				imgPath = imgPath + "/nophoto_m.jpg";
			}
		}

		bufferImg = ImageIO.read(new FileInputStream(new File(imgPath)));

		return bufferImg;
	}

	/**
	 * <h2>申请复议</h2>
	 * 
	 * @param loanId
	 * 
	 * @return modelAndView
	 */
	@RequestMapping("/reconsider")
	public ModelAndView reconsider(
			@RequestParam(value = "loanId", required = false) String loanId,
			@RequestParam(value = "reconsiderReason", required = false) String reconsiderReason,
			@RequestParam(value = "applyStatus", required = false) String applyStatus,
			HttpServletRequest request, PrintWriter out) {

		// 查询最新申请状态
		TCreditApply ca = biz.selectOne(loanId);
		// 申请状态被别人更新时
		if (!applyStatus.equals(ca.getApplyStatus())) {
			out.print("该笔申请已经被处理，请重新查询。");
			return null;
		}
		// 审批通过发起复议时
		if (ReviewNoteConstants.APPLYSTATUS_CODE_90.equals(applyStatus)) {
			// 获得批复表中的批准信息
			TApproveResult approve = arBiz.selectByLoanId(loanId);
			// 没有数据或没有状态时
			if (approve != null
					&& !ReviewNoteConstants.APPROVE_STATUS_CODE_01
							.equals(approve.getApproveStatus())) {
				out.print("该笔申请的审批结果已被确认，不能复议。");
				return null;
			}
		}
		User user = (User) request.getSession().getAttribute("USER");

		ca = new TCreditApply();
		ca.setLoanId(loanId);
		ca.setApplyStatus(applyStatus);
		ca.setLastOperId(user.getUserName());
		ca.setLastOperTime(new Date());
		// 申请复议理由
		ca.setBackReason(reconsiderReason);
		// 申请复议
		Map<String, Object> respMap = biz.reconsider(ca);
		int flag = (int) respMap.get("flag");
		ca = (TCreditApply) respMap.get("tCreditApply");
		// 申请复议成功
		if (flag == 1) {
			out.print("申请复议成功。");
			// 申请复议失败
		} else {
			out.print("申请复议失败，请联系系统管理员。");
		}
		return null;
	}
}
