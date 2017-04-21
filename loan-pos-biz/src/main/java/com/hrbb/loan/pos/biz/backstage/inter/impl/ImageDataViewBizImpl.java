/**
 *  哈尔滨银行
 * Copyright (c) 2007-2015 HRBB,Inc.All Rights Reserved.
 */
package com.hrbb.loan.pos.biz.backstage.inter.impl;

import java.util.ArrayList;
import java.util.Collections;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import com.google.common.collect.Maps;
import com.hrbb.loan.pos.biz.backstage.inter.ImageDataViewBiz;
import com.hrbb.loan.pos.service.LoanPosBusinessCodeService;
import com.hrbb.loan.pos.util.StringUtil;
import com.hrbb.loan.pos.util.constants.BusinessDictionaryConstants;
import com.hrbb.sh.framework.ftp.HttpClient;
import com.hrbb.sh.framework.ftp.ParamReqBean;
import com.hrbb.sh.framework.ftp.ParamResBean;

/**
 * 影像资料实现.
 * 
 * @author xiongshaogang
 * @version $Id: ImageDataViewBizImpl.java, v 0.1 2015年3月18日 下午3:17:43 xiongshaogang Exp $
 */
@Component("imageDataViewBiz")
public class ImageDataViewBizImpl implements ImageDataViewBiz {

    private Logger logger = LoggerFactory.getLogger(ImageDataViewBizImpl.class);    
    
    @Autowired
    private LoanPosBusinessCodeService loanPosBusinessCodeService;
    
    private List<Map<String, Object>> dictionaryWithBizFileTypeList = null;
    
    /**
     * 计算影像资料名称及描述.
     * 
     * @see com.hrbb.loan.pos.biz.backstage.inter.ImageDataViewBiz#getImageDataNames(java.lang.String, java.lang.String)
     */
    @Override
    public List<Map<String, Object>> getImageDataNames(String loanId, String custId) {
        
        // 加载影像资料定义
        if (dictionaryWithBizFileTypeList == null || dictionaryWithBizFileTypeList.size() < 1) {
            loadBizFileDictionayDef(BusinessDictionaryConstants.BIZ_FILE_TYPE);
        }
        
        // 确认预加载项已完成
        if (dictionaryWithBizFileTypeList == null || dictionaryWithBizFileTypeList.size() < 1) {
            return null;
        }
        
        // 影像资料列表
        ParamReqBean paramReqBean = new ParamReqBean();
        paramReqBean.setVersion("1.0.0");
        paramReqBean.setBizType("0001");
        paramReqBean.setTransType("0002");
        paramReqBean.setCustId(custId);
        paramReqBean.setApplyNo(loanId);
        
        ParamResBean paramResBean = HttpClient.send(paramReqBean);
        if (paramResBean == null || !"000".equals(paramResBean.getRespCode())) {
            return null;
        }
        
        // 当前贷款申请影像文件处理
        List<Map<String, Object>> retBizFileList = new ArrayList<Map<String,Object>>();
        String[] fileNames = paramResBean.getFileNames();
        if (fileNames == null || fileNames.length < 1) {
            return null;
        } else {
            logger.info("fileNames长度"+fileNames.length);
            String token = null;
            Map<String, Object> retBizFileMap = null;
            int fileNo = 0;
            for (int i = 0; i < fileNames.length; i++) {
                logger.info("fileName:"+fileNames[i]);
                if(!fileNames[i].endsWith(".pdf")){
                    try {
                        token = fileNames[i].substring(fileNames[i].lastIndexOf("_") - 4, fileNames[i].lastIndexOf("_"));
                        retBizFileMap = new HashMap<String, Object>();
                        
                        String desc = getTokenDesc(token);
                        
                        if (StringUtil.isEmpty(desc)) {
                            retBizFileMap.put("fileName", fileNames[i]);
                            retBizFileMap.put("fileDesc", "非正常文件 [" + fileNames[i] + "]");
                        } else {
                            retBizFileMap.put("fileName", fileNames[i]);
                            retBizFileMap.put("fileDesc", desc + "_" + fileNames[i].substring(fileNames[i].lastIndexOf("_")));
                        }
                        
                        retBizFileMap.put("fileNo", ++fileNo);
                        
                        retBizFileList.add(retBizFileMap);
                    } catch (Exception e) {
                        logger.error("查看影像件失败", e);
                    }
                }
            }
        }
    	
        return retBizFileList;
    }
    
    /**
     * 筛选描述.
     * 
     * @param token
     * @return
     */
    private String getTokenDesc(String token) {
        for (int i = 0; i < this.dictionaryWithBizFileTypeList.size(); i++) {
            Map<String, Object> tmpMap = this.dictionaryWithBizFileTypeList.get(i);
            if (tmpMap.containsValue(token)) {
                return (String) tmpMap.get("itemName");
            }
        }
        return "";
    }
    
    /**
     * 加载影像资料 数据字典定义.
     * 
     * @param codeNo
     */
    public void loadBizFileDictionayDef(String codeNo) {
        // 查询数据字典定义
        this.dictionaryWithBizFileTypeList = loanPosBusinessCodeService.getItemNames(codeNo);
    }
    
    /**
     * 获取协议文件名
     * 
     * @param loanId
     */
    public String getProtocolName(String loanId){
        
        ParamReqBean paramReqBean = new ParamReqBean();
        paramReqBean.setVersion("1.0.0");
        paramReqBean.setBizType("0001");
        paramReqBean.setTransType("0002");
        paramReqBean.setKeyValue("fileType", "pdf");
        paramReqBean.setApplyNo(loanId);
        
        ParamResBean paramResBean = HttpClient.send(paramReqBean);
        if (paramResBean == null || !"000".equals(paramResBean.getRespCode())) {
            return null;
        }
        
        String protocolName = "";
        String[] fileNames = paramResBean.getFileNames();
        List<String> list = new ArrayList<String>();
        if (fileNames == null || fileNames.length < 1) {
            return null;
        } else {
            logger.info("fileNames长度"+fileNames.length);
            String fileNo = "";
            for (int i = 0; i < fileNames.length; i++) {
                logger.info("fileName:"+fileNames[i]);
                fileNo = fileNames[i].substring(fileNames[i].lastIndexOf("_")-4, fileNames[i].lastIndexOf("_"));
                if(fileNames[i].endsWith(".pdf") && "0501".equals(fileNo)){
                                       
                    protocolName = fileNames[i];
                    logger.info("得到协议文件名为:"+protocolName);
                    list.add(protocolName);
                    
                }
            }
        }
        if(list.size()>0){
            Collections.sort(list);
            protocolName = list.get(list.size()-1);
        }
        return protocolName;
    }
}
