package com.hrbb.loan.controller;

import java.io.File;
import java.io.PrintWriter;
import java.util.Date;
import java.util.List;
import java.util.Map;

import javax.servlet.http.HttpServletRequest;

import org.apache.commons.lang.exception.ExceptionUtils;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.ModelAndView;
import org.w3c.dom.events.EventException;

import com.google.common.base.Charsets;
import com.google.common.collect.Lists;
import com.google.common.collect.Maps;
import com.google.common.io.Files;
import com.hrbb.loan.pos.biz.backstage.inter.CautionConfigBiz;
import com.hrbb.loan.pos.biz.backstage.inter.CreditApplyAprvInfoBiz;
import com.hrbb.loan.pos.biz.backstage.inter.CreditApplyForReviewBiz;
import com.hrbb.loan.pos.biz.backstage.inter.ILoanPosCreditApplyBackStageBiz;
import com.hrbb.loan.pos.biz.backstage.inter.IPaymentApplyBiz;
import com.hrbb.loan.pos.biz.backstage.inter.LoanPosContractManagementBiz;
import com.hrbb.loan.pos.dao.TCreditApplyForReviewDao;
import com.hrbb.loan.pos.dao.TMessageDao;
import com.hrbb.loan.pos.dao.entity.TCreditApply;
import com.hrbb.loan.pos.dao.entity.TCustomer;
import com.hrbb.loan.pos.dao.entity.TMessage;
import com.hrbb.loan.pos.service.CallbackRecordService;
import com.hrbb.loan.pos.service.LoanPosCustomerService;
import com.hrbb.loan.pos.service.bean.CreditReportDownloadMessage;
import com.hrbb.loan.pos.util.constants.ReviewNoteConstants;
import com.hrbb.sh.framework.domain.CreditInvestigateRequest;

@Controller
@RequestMapping("/backStageAddMessage")
public class BackStageAddMessageController {
	
	private static final String path = "/tmp/";
	
	private Logger logger = LoggerFactory.getLogger(BackStageAddMessageController.class);
	
	
	@Autowired
	@Qualifier("creditApplyAprvInfoBiz")
	private CreditApplyAprvInfoBiz biz;
	@Autowired
	@Qualifier("creditApplyForReviewBiz")
	private CreditApplyForReviewBiz caBiz;
	
	@Autowired
	IPaymentApplyBiz paymentApplyBiz;
	
	@Autowired
	@Qualifier("tCreditApplyForReviewDao")
	private TCreditApplyForReviewDao daoCA;
	
	@Autowired
	private TMessageDao tMessageDao;
	
	
	@Autowired
	private TMessageDao tMessage;
	
	@Autowired
	private LoanPosContractManagementBiz contBiz;
	
	@Autowired
	private ILoanPosCreditApplyBackStageBiz loanBiz;
	
	@Autowired
	private LoanPosCustomerService custService;
	
	@Autowired
	private CautionConfigBiz cautionConfigBiz;
	
	@Autowired
	private CallbackRecordService callbackRecordService;
	
	
	@RequestMapping("/addInfoMessage")
	public ModelAndView addInfoMessage(HttpServletRequest request, PrintWriter out){
		String fileName = request.getParameter("fileName");
		String filePath = path + fileName;
		
		try{
			List<String> lists = Files.readLines(new File(filePath), Charsets.UTF_8);
			List<String> newList = Lists.newArrayList();
			for(String aa : lists){
				if(aa.contains("LO")){
					newList.add(aa.substring(aa.indexOf("LO")).trim());
					
				}
				
				
			}
			for(String loanId : newList){
				TCreditApply tCreditApply = caBiz.selectOne(loanId);
				TCustomer custInfo = custService.getCustumerInfoById(tCreditApply.getCustId());
				if(custInfo != null){
					Map<String, Object> reqMap = Maps.newHashMap();
					//下载征信报告
					logger.info("回调成功开始下载征信报告");
					CreditInvestigateRequest request1 = new CreditInvestigateRequest();
					// 用户名外部传入
					request1.setCustNme(custInfo.getCustName());
					// 身份证号码外部传入
					request1.setCustId(custInfo.getPaperId());
					// 查询原因外部传入
					request1.setQryWay("02I");
					
					reqMap.put("creditInvestigateRequest", request1);
					Map<String, Object> resMap = loanBiz.creditInvestigate(reqMap);
					if(!"00".equals((String)resMap.get("respCode"))){
						logger.error("征信报告下载失败");
						continue;
						
					}
					logger.info("下载征信报告完成, 接着上传征信报告");
					
					//上传征信报告
					reqMap = Maps.newHashMap();
					reqMap.put("certNo", custInfo.getPaperId());
					reqMap.put("channel", tCreditApply.getChannel());
					Map<String, Object> uploadCreditInvestHtmlResMap = loanBiz.uploadCreditInvestHtml(reqMap);
					if(!"0".equals(uploadCreditInvestHtmlResMap.get("respCode"))){
						logger.error("征信报告上传失败");
						continue;
			
					}
					logger.info("上传征信报告完成");
					TCreditApply ca = new TCreditApply();
					ca.setLoanId(tCreditApply.getLoanId());
					// 申请状态
					ca.setApplyStatus(ReviewNoteConstants.APPLYSTATUS_CODE_60);
					// 最后操作人
					ca.setLastOperId("system");
					// 最后操作时间
					ca.setLastOperTime(new Date());
					// 更新申请状态
					int flag = daoCA.updateForReview(ca);
					// 保存成功
					logger.debug("更新申请" + loanId + "为外部审核状态成功");
					if (flag == 1) {
						CreditReportDownloadMessage crdm = new CreditReportDownloadMessage();
						crdm.setLoanid(tCreditApply.getLoanId());
						crdm.setFilepackagename((String)uploadCreditInvestHtmlResMap.get("zipFileName"));
						crdm.setKey((String)uploadCreditInvestHtmlResMap.get("zipFilePwd"));
						TMessage message = new TMessage();
						message.setMessageInfo(crdm.toString());
						message.setChannel(tCreditApply.getChannel());
						message.setCreateTime(new Date());
						message.setCustId(tCreditApply.getCustId());
						message.setLoanId(tCreditApply.getLoanId());
						message.setMessageType("14");
						message.setStdshNo(tCreditApply.getStdshno());
						message.setInChannelKind(tCreditApply.getInChannelKind());
						tMessageDao.insert(message);
						logger.info("下载征信报告消息插入成功");
					}
				}
				}
			out.print("成功");
		}catch(Exception e){
			logger.error("读取文件失败" + path + fileName + e.getStackTrace());
			out.print("失败");
		}
		return null;
	}
	
	@RequestMapping("downLoadMessage")
	public ModelAndView downLoadMessage(){
		
		return null;
	}
}
