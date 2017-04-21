/**
 * 
 *哈尔滨银行
 * Copyright (c) 2007-2015 HRBB,Inc.All Rights Reserved.
 */
package com.hrbb.loan.controller;

import java.io.PrintWriter;
import java.math.BigDecimal;
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
import com.hrbb.loan.jms.sender.SmsMessageSender;
import com.hrbb.loan.pos.biz.backstage.inter.BusinessDictionaryBiz;
import com.hrbb.loan.pos.biz.backstage.inter.CreditApplyAprvInfoBiz;
import com.hrbb.loan.pos.biz.backstage.inter.ILoanPosBusinessCodeBiz;
import com.hrbb.loan.pos.biz.backstage.inter.ILoanPosCreditApplyBackStageBiz;
import com.hrbb.loan.pos.biz.backstage.inter.ISmsSenderBiz;
import com.hrbb.loan.pos.dao.entity.TCreditApplyAprvInfo;
import com.hrbb.loan.pos.dao.entity.TSmsMessage;
import com.hrbb.loan.pos.dao.entity.TSmsTemplate;
import com.hrbb.loan.pos.service.constants.SmsTypeContants;
import com.hrbb.loan.pos.util.SmsTemplateFactory;
import com.hrbb.loan.pos.util.StringUtil;
import com.hrbb.loan.pos.util.constants.BusinessDictionaryConstants;
import com.hrbb.loan.pos.util.constants.ReviewNoteConstants;
import com.hrbb.loan.web.security.entity.User;

/**
 * 
 * @author marco
 * @version $Id: SignController.java, v 0.1 2015-3-11 上午11:35:10 marco Exp $
 */
@Controller
@RequestMapping("/addInfo")
public class AddInfoController {

	private Logger LOG = LoggerFactory.getLogger(AddInfoController.class);

	@Autowired
	@Qualifier("smsMessageSender")
	private SmsMessageSender smsMessageSender;
	
	@Autowired
	@Qualifier("creditApplyAprvInfoBiz")
	private CreditApplyAprvInfoBiz biz;

	@Autowired
	private ILoanPosBusinessCodeBiz loanPosBusinessCodeBiz;
	
	@Autowired
	private ILoanPosCreditApplyBackStageBiz loanPosCreditApplyBackStageBiz;
	
	@Autowired
	private ISmsSenderBiz smsSenderBiz;
	
	public final static String ADDINFO_REASONANDCODES = "&";
	/**
	 * <h2>获取补件类型列表</h2>
	 * 
	 * @param loanid
	 * @return modelAndView
	 */
	@RequestMapping("/initAddInfoTable")
	public ModelAndView initAddInfoTable(PrintWriter out) {
		List<Map<String, Object>> l = loanPosBusinessCodeBiz.getItemNames(BusinessDictionaryConstants.BIZ_FILE_TYPE);
		LOG.debug(JSON.toJSONString(l));
		out.print(JSON.toJSONString(l));
		return null;
	}
	

	/**
	 * <h2>保存审批信息</h2>
	 * 
	 * @param reviewid
	 * @return modelAndView
	 */
	@RequestMapping("/addInfoSubmit")
	public ModelAndView addInfoSubmit(
			@RequestParam(value = "loanid", required = false) String loanid,
			@RequestParam(value = "applyStatus", required = false) String apprState,
			@RequestParam(value = "channel", required = false) String channel,
			@RequestParam(value = "appNum", required = false) Integer appNum,
			@RequestParam(value = "addInfoCodes", required = false) String addInfoCodes,
			@RequestParam(value = "apprAmount", required = false) String apprAmount,
			@RequestParam(value = "apprInte", required = false) String apprInte,
			@RequestParam(value = "needReason", required = false) String needReason,
			@RequestParam(value = "apprInfo", required = false) String apprInfo,
			@RequestParam(value = "apprInfoExt", required = false) String apprInfoExt,
			@RequestParam(value = "addinfo", required = false) String addinfoReason,
			@RequestParam(value = "remark", required = false) String remark,
			HttpServletRequest request, PrintWriter out) {

		User user = (User) request.getSession().getAttribute("USER");
		// 申请审批表信息
		TCreditApplyAprvInfo record = new TCreditApplyAprvInfo();
		record.setLoanId(loanid);
		record.setApprState(apprState);
		record.setAppNum(appNum);
		record.setApprResult(ReviewNoteConstants.APPRRESULT_CODE_31);
		
	/*	
		StringBuffer sb = new StringBuffer();
		sb.append(addinfoReason).append(ADDINFO_REASONANDCODES).append(addInfoCodes);
		String addinfo = sb.toString();
		*/
		//退回补件编号
		record.setNeedInforCodes(addInfoCodes);
		record.setNeedReason(needReason);
		record.setApprInfo(apprInfo);
		if (!StringUtil.isEmpty(apprAmount)) {
			record.setApprAmount(new BigDecimal(apprAmount.replaceAll(",", "")));
		}
		if (!StringUtil.isEmpty(apprInte)) {
			record.setApprInte(new BigDecimal(apprInte));
		}
		record.setApprInfoExt(addinfoReason);
		// 备注
		record.setRemark(remark);
		record.setApprvId(user.getUserName());
		// 审批结束时间
		record.setAppEndTime(new Date());
		// 更新申请表，申请审批记录表
		LOG.debug("更新申请表，申请审批记录表");
		Map<String, Object> updateMap = biz.update(record);
		int flag = (int) updateMap.get("flag");
		record = (TCreditApplyAprvInfo) updateMap.get("record");
		// 保存成功
		if (flag == 1) {
			out.print("保存成功。");
			// 补件短信入库
			try {
                insertSmsMessage(loanid);
            } catch (Exception e) {
                LOG.error("补件短信入库异常", e);
            }
			// 保存失败
		} else {
			out.print("保存失败，请联系系统管理员。");
		}
		return null;
	}

    /**
     * 补件短信入库
     * 
     * @param loanid
     */
    private void insertSmsMessage(String loanid) throws Exception{
    	//申请信息
    	List<Map<String,Object>> mapList = loanPosCreditApplyBackStageBiz.getCreditApplyDetail(loanid);
    	String channel = (String)mapList.get(0).get("channel");
    	if(StringUtil.isEmpty(channel)){
    	    return;
    	}
    	/*以下渠道不发送补件短信*/
        if(channel.toUpperCase().matches("(58|ZY|ZW|RN)")) return;
    	String tempId = SmsTemplateFactory.getAddiTemplate(channel);
        //获取短信模板
        TSmsTemplate smsTemplate = smsSenderBiz.getSmsTemplate(tempId);
        //短信内容
        String sendContent = smsTemplate.getSmsContent();
        channel = loanPosBusinessCodeBiz.getItemNameByNo("BizChannel", channel);
        sendContent = sendContent.replace("%channel%", channel);
        //短信入库
        //smsSenderBiz.insertSmsMessage(tempId, (String)mapList.get(1).get("mobilePhone"), sendContent);
        TSmsMessage smsMessage = new TSmsMessage();
        smsMessage.setTempId(tempId);
        smsMessage.setMobile((String)mapList.get(1).get("mobilePhone"));
        smsMessage.setSendContent(sendContent);
        smsMessage.setNotifyType(SmsTypeContants.审核补件);
        smsMessage.setChannel(channel);
        smsMessageSender.sendMessage(smsMessage);    
    
    }
}
