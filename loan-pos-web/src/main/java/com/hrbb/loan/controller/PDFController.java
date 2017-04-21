/**
 * 
 *	哈尔滨银行
 * Copyright (c) 2007-2015 HRBB,Inc.All Rights Reserved.
 */
package com.hrbb.loan.controller;

import java.io.File;
import java.io.FileInputStream;
import java.io.IOException;
import java.io.InputStream;
import java.io.OutputStream;
import java.math.BigDecimal;
import java.util.Date;
import java.util.List;
import java.util.Map;

import javax.servlet.http.HttpServletResponse;

import org.apache.commons.lang.exception.ExceptionUtils;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;

import com.google.common.collect.Maps;
import com.hrbb.loan.pos.biz.backstage.inter.BusinessDictionaryBiz;
import com.hrbb.loan.pos.biz.backstage.inter.IPDFService;
import com.hrbb.loan.pos.biz.backstage.inter.LoanPosContractManagementBiz;
import com.hrbb.loan.pos.dao.entity.TBusinessDictionary;
import com.hrbb.loan.pos.service.LoanPosPaybackRunningRecordService;
import com.hrbb.loan.pos.service.PdfSignatureService;
import com.hrbb.loan.pos.service.ReceiptInfoService;
import com.hrbb.loan.pos.util.DateUtil;
import com.hrbb.loan.pos.util.MoneyUtils;
import com.hrbb.loan.pos.util.PDFGenerator;
import com.hrbb.loan.pos.util.PdfNameGenerator;
import com.hrbb.loan.pos.util.constants.BusinessDictionaryConstants;
import com.hrbb.loan.util.HtmlGenerator;

/**
 * @author yida
 * @date 2015年10月28日 下午1:53:22
 */
@Controller
@RequestMapping("/pdf")
public class PDFController {

    private static final Logger LOGGER = LoggerFactory.getLogger(PDFController.class);
    @Autowired
    private IPDFService pdfService;
    @Autowired
    private LoanPosContractManagementBiz loanPosContractManagementBiz;
    @Autowired
    private BusinessDictionaryBiz businessDictionaryBiz;
    @Autowired
    private ReceiptInfoService receiptInfoService;
    @Autowired
    private PdfSignatureService pdfSignatureService;
    @Autowired
    private LoanPosPaybackRunningRecordService paybackRunningRecordService;

    /**
     * @param loanId 申请编号
     * @param imageFilePackageName pdf文件名
     * @param signDate 签约日期
     * @param contNo 合同编号
     * @param repayMethod 还款方式
     * @param signature base64图片字符串
     */
    @RequestMapping(value = "generate", method = RequestMethod.POST, produces = "text/html;charset=utf-8")
    @ResponseBody
    public String generatePdf(@RequestParam String contNo) {
        Map<String, Object> pdfParam = pdfSignatureService.findSignatureByContNo(contNo);
        String respMsg = null;
        if (null == pdfParam) {
            respMsg = "找不到该合同协议回传生成pdf的记录，请确认contNo是否正确！";
            LOGGER.warn(respMsg);
            return respMsg;
        }
        String repayMethod = (String) pdfParam.get("repayMethod");
        String loanId = (String) pdfParam.get("loanId");
        String imageFilePackageName = PdfNameGenerator.getContractName(contNo, (String)pdfParam.get("custId"));
        String signature = (String) pdfParam.get("signature");
        Map<String, Object> reqMap = Maps.newHashMap();
        reqMap.put("contNo", contNo);
        List<Map<String, Object>> lists = loanPosContractManagementBiz.selectSelectiveMap(reqMap);
        if (lists.isEmpty()) {
            respMsg = "合同编号有误，查询不到编号为" + loanId + "的合同信息";
            LOGGER.warn(respMsg);
            return respMsg;
        }
        //组装model
        Map<String, Object> contractMap = lists.get(0);
        String signDate = DateUtil.formatDate((Date)contractMap.get("signDate"), DateUtil.HRRB_SHORT_DATETIME_FORMAT) ;
        Map<String, Object> model = loanPosContractManagementBiz.transferToPdfArgee(contractMap);
        TBusinessDictionary dictionary = new TBusinessDictionary();
        dictionary.setCodeNo(BusinessDictionaryConstants.BankNo);
        dictionary.setItemNo((String) contractMap.get("accountOpenBank"));
        TBusinessDictionary record = businessDictionaryBiz.selectOne(dictionary);
        if (null == record) {
            respMsg = "找不到编号为" + (String) contractMap.get("accountOpenBank") + "的开户行信息";
            LOGGER.warn(respMsg);
            return respMsg;
        }
        String openBankName = record.getItemName();
        if(null != openBankName){
            openBankName = openBankName.replaceAll("银行", "");
        }
        model.put("loanBankName", openBankName);
        model.put("repayBankName", openBankName);
        String[] dateStrs = signDate.split("-");
        String signYear = dateStrs[0];
        String signMonth = dateStrs[1];
        String signDay = dateStrs[2];
        model.put("signYear", signYear);
        model.put("signMonth", signMonth);
        model.put("signDay", signDay);
        model.put("repayMethod", repayMethod.trim());
        String signImageName = contNo + ".jpg";
        model.put("signUrl", signImageName);
        //获取协议模板
        String template = HtmlGenerator.generate("agreement.ftl", model);
        String resourcePath = null;
        try {
            resourcePath = PDFController.class.getClassLoader().getResource("font").toString();
            //异步调用生成pdf
            pdfService.generate(loanId, template, resourcePath, imageFilePackageName, signature, signImageName);
            respMsg = "通知生成协议消息成功，pdf正在生成中";
        } catch (Exception e) {
            LOGGER.error(ExceptionUtils.getFullStackTrace(e));
        }
        return respMsg;
    }

    /**
     * 贷款还清凭证下载
     * @param receiptId 收据编号
     * @param response 响应
     */
    @RequestMapping(value = "downloadFinishedCertificate", method = RequestMethod.GET)
    @ResponseBody
    public void downloadFinishedCertificate(@RequestParam String receiptId, HttpServletResponse response) {
        //获取model
        Map<String, Object> receiptInfo = receiptInfoService.selectReceiptInfoByReceiptId(receiptId);
        Map<String, Object> model = Maps.newConcurrentMap();
        String custName = (String) receiptInfo.get("custName");
        model.put("custName", custName);
        model.put("idCard", receiptInfo.get("paperId"));
        model.put("money", MoneyUtils.format((BigDecimal) receiptInfo.get("loanTotalBalance")));
        model.put("receiptId", receiptId);
        Date beginDate = (Date) receiptInfo.get("beginDate");
        if (null != beginDate) {
            String beginDateStr = DateUtil.formatDate(beginDate, DateUtil.HRRB_SHORT_DATETIME_FORMAT_BRIEF);
            String beginYear = beginDateStr.substring(0, 4);
            String beginMonth = beginDateStr.substring(4, 6);
            String beginDay = beginDateStr.substring(6, 8);
            model.put("beginYear", beginYear);
            model.put("beginMonth", beginMonth);
            model.put("beginDay", beginDay);
        }
        Date endDate = (Date) receiptInfo.get("finishDate");
        if (null != endDate) {
            String endDateStr = DateUtil.formatDate(endDate, DateUtil.HRRB_SHORT_DATETIME_FORMAT_BRIEF);
            String endYear = endDateStr.substring(0, 4);
            String endMonth = endDateStr.substring(4, 6);
            String endDay = endDateStr.substring(6, 8);
            model.put("endYear", endYear);
            model.put("endMonth", endMonth);
            model.put("endDay", endDay);
        }
        //组装模板
        String template = HtmlGenerator.generate("finishedCertificate.ftl", model);
        //生成pdf
        String resourcePath = PDFController.class.getClassLoader().getResource("font").toString();
        File pdf = PDFGenerator.generate(template, resourcePath, custName);
        if (!pdf.exists()) {
            LOGGER.warn("生成贷款结清证明pdf失败");
            return;
        }
        byte[] cache = new byte[2048];
        try {
            //pdf写入response
            response.setHeader("Content-Disposition", "attachment;fileName=" + new String(custName.getBytes("utf-8"), "ISO8859-1") + "_" + receiptId + ".pdf");
            response.setContentType("application/octet-stream;charset=UTF-8");
            OutputStream os = response.getOutputStream();
            InputStream inputStream = new FileInputStream(pdf);
            int length = 0;
            while ((length = inputStream.read(cache)) > 0) {
                os.write(cache, 0, length);
            }
            os.flush();
            os.close();
            inputStream.close();
        } catch (IOException e) {
            LOGGER.error("贷款结清证明下载失败", e);
        }
        //删除pdf文件
        if (null != pdf) {
            boolean deleteFlag = pdf.delete();
            if (!deleteFlag) {
                LOGGER.warn("pdf文件删除失败，请手动删除，pdf电子协议文件路径为：" + pdf.getAbsolutePath());
            }
        }
    }

    /**
     * 未结清已还款凭证下载
     * @param receiptId 收据编号
     * @param response 响应
     */
    @RequestMapping(value = "downloadPaymentCertificate", method = RequestMethod.GET)
    @ResponseBody
    public void downloadPaymentCertificate(@RequestParam String paybackRunningRecordId, HttpServletResponse response) {
        //获取model
        Map<String, Object> paybackRunningRecord = paybackRunningRecordService.getPdfInfo(paybackRunningRecordId);
        Map<String, Object> model = Maps.newConcurrentMap();
        String receiptId = (String) paybackRunningRecord.get("receiptId");
        String paybackApplyId = (String) paybackRunningRecord.get("paybackApplyId");
        String custName = (String) paybackRunningRecord.get("custName");
        String merchantName = (String) paybackRunningRecord.get("posCustName");
        String paybackWay = (String) paybackRunningRecord.get("paybackWay");
        TBusinessDictionary dictionary = new TBusinessDictionary();
        dictionary.setCodeNo(BusinessDictionaryConstants.AccrualType);
        dictionary.setItemNo(paybackWay);
        TBusinessDictionary record = businessDictionaryBiz.selectOne(dictionary);
        if(null == record){
            LOGGER.error("未结清还款凭证生成失败，未找到paybackWay="+paybackWay+"的还款方式，paybackRunningRecordId="+paybackRunningRecordId);
            return;
        }
        String actualPaybackDate = DateUtil.formatDate((Date)paybackRunningRecord.get("actualPaybackDate"), DateUtil.HRRB_SHORT_DATETIME_FORMAT);
        String actualTotalAmount = MoneyUtils.format((BigDecimal) paybackRunningRecord.get("actualTotalAmount"));
        String actualCapital = MoneyUtils.format((BigDecimal) paybackRunningRecord.get("actualCapital"));
        String actualInterest = MoneyUtils.format((BigDecimal) paybackRunningRecord.get("actualInterest"));
        String paybackPenalty = MoneyUtils.format((BigDecimal) paybackRunningRecord.get("paybackPenalty"));
        String veriCode = new StringBuilder(paybackApplyId.substring(paybackApplyId.length()-6)).append(paybackRunningRecordId.substring(paybackRunningRecordId.length() - 6)).toString();
        model.put("receiptId", receiptId);
        model.put("veriCode", veriCode);
        model.put("custName", custName);
        model.put("merchantName", merchantName);
        model.put("paybackWay", record.getItemName());
        model.put("actualPaybackDate", actualPaybackDate);
        model.put("actualTotalAmount", actualTotalAmount);
        model.put("actualCapital", actualCapital);
        model.put("actualInterest", actualInterest);
        model.put("paybackPenalty", paybackPenalty);
        Date endDate = (Date) paybackRunningRecord.get("actualPaybackDate");
        if (null != endDate) {
            String endDateStr = DateUtil.formatDate(endDate, DateUtil.HRRB_SHORT_DATETIME_FORMAT_BRIEF);
            String endYear = endDateStr.substring(0, 4);
            String endMonth = endDateStr.substring(4, 6);
            String endDay = endDateStr.substring(6, 8);
            model.put("endYear", endYear);
            model.put("endMonth", endMonth);
            model.put("endDay", endDay);
        }
        //组装模板
        String template = HtmlGenerator.generate("paybackCertificate.ftl", model);
        //生成pdf
        String resourcePath = PDFController.class.getClassLoader().getResource("font").toString();
        File pdf = PDFGenerator.generate(template, resourcePath, custName);
        if (!pdf.exists()) {
            LOGGER.warn("生成还款证明pdf失败");
            return;
        }
        byte[] cache = new byte[2048];
        try {
            //pdf写入response
            response.setHeader("Content-Disposition", "attachment;fileName=" + new String(custName.getBytes("utf-8"), "ISO8859-1") + "_" + paybackRunningRecordId + ".pdf");
            response.setContentType("application/octet-stream;charset=UTF-8");
            OutputStream os = response.getOutputStream();
            InputStream inputStream = new FileInputStream(pdf);
            int length = 0;
            while ((length = inputStream.read(cache)) > 0) {
                os.write(cache, 0, length);
            }
            os.flush();
            os.close();
            inputStream.close();
        } catch (IOException e) {
            LOGGER.error("还款证明下载失败", e);
        }
        //删除pdf文件
        if (null != pdf) {
            boolean deleteFlag = pdf.delete();
            if (!deleteFlag) {
                LOGGER.warn("还款证明pdf文件删除失败，请手动删除，还款证明路径为：" + pdf.getAbsolutePath());
            }
        }
    }

}
