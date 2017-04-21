package com.hrbb.loan.work;

import java.util.Map;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Scope;
import org.springframework.stereotype.Service;

import com.google.common.collect.Maps;
import com.hrbb.loan.hessian.inter.IAICHessianService;
import com.hrbb.loan.hessian.inter.IBankCardCheckHessianService;
import com.hrbb.loan.hessian.inter.IPoliceHessianService;
import com.hrbb.loan.pos.biz.backstage.inter.ILoanPosCreditApplyCheckRegBiz;
import com.hrbb.loan.pos.util.IdUtil;
import com.hrbb.loan.pos.util.StringUtil;
import com.hrbb.loan.spiconstants.CreditApplyHServiceConstants;
import com.hrbb.loan.work.bean.AicReqBean;
import com.hrbb.loan.work.bean.FtpReqBean;
import com.hrbb.loan.work.bean.NciicReqBean;
import com.hrbb.loan.work.bean.PosLoanHeaderBean;
import com.hrbb.loan.work.bean.YijifuVerifiedReqBean;
import com.hrbb.sh.framework.HResponse;
import com.hrbb.sh.framework.ftp.HttpClient;
import com.hrbb.sh.framework.ftp.ParamReqBean;
import com.hrbb.sh.framework.ftp.ParamResBean;
import com.hrbb.sh.frontier.biz.route.facade.RouteFacade;
import com.hrbb.ump.facade.bean.requests.user.UserSensitiveInformationUpdateRequest;
import com.hrbb.ump.facade.bean.responses.user.UserSensitiveInformationUpdateResponse;
import com.hrbb.ump.facade.general.user.UserFacade;

/**
 * 不等贷 第三方数据服务接口对接.
 * 
 * @author xiongshaogang
 * @version $Id: PosLoanDataSynGetWork.java, v 0.1 2015年5月15日 下午4:30:45 xiongshaogang Exp $
 */
@Scope("prototype")
@Service("PosLoanDataSynGetWork")
public class PosLoanDataSynGetWork implements Runnable {
    
    private final Logger logger = LoggerFactory.getLogger(PosLoanDataSynGetWork.class);
    
    private PosLoanHeaderBean posLoanHeaderBean;
    
    private NciicReqBean nciicReqBean;
    
    private YijifuVerifiedReqBean yijifuVerifiedReqBean;
    
    private AicReqBean aicReqBean;
    
    private FtpReqBean ftpReqBean;
    
    @Autowired
    private UserFacade umpUserService;
    
    @Autowired
    private RouteFacade routeFacade;
    
    @Autowired
    private IPoliceHessianService policeHessianService;
    
    @Autowired
    private IBankCardCheckHessianService bankCardCheckHessianService;
    
    @Autowired
    private IAICHessianService aicHessianService;
    
    @Autowired
	private ILoanPosCreditApplyCheckRegBiz loanPosCreditApplyCheckRegBiz;
    
    @Override
    public void run() {
        logger.info("不等贷 第三方数据服务接口对接线程启动.....");
        
        // 0. 影像资料解包
        logger.info("影像资料解包处理开始...");
        noticeFtp(ftpReqBean);
        logger.info("影像资料解包结束!");
        
        // 1. 公安部
        logger.info("公安部请求处理...");
        
        // 1.1 公安部请求
        String paperId = nciicReqBean.getCertId();
        String paperName = nciicReqBean.getCertName();
        
        Map<String, String> tmpMap = Maps.newHashMap();
        tmpMap.put("idNo", paperId);
        tmpMap.put("custName", paperName);
        //Map<String, String> tmpRetMap = policeHessianService.getCustPoliceInfo(tmpMap);
        /*if (tmpRetMap == null || tmpRetMap.size() < 1)(flag) {
            logger.error("公安部请求异常");
        } else if (!"00".equals(tmpRetMap.get("returnCode"))) else if(flag){
            logger.error("公安部验证失败");
        } else {*/
            // 1.2 录入用户系统
            // 只有C端手机用户才与用户系统挂钩
        String loanId = ftpReqBean.getLoanId();
        try{
			Map<String, Object> result = loanPosCreditApplyCheckRegBiz.creditApplyCheck(loanId);
			logger.debug("准入性校验结果为:" + result.get("checkMessage"));
			if("999".equals(result.get("checkCode"))){
				//不做后续处理
				return;
			}
		}catch(Exception e){
			logger.error("准入性校验异常:", e);
		}

        
            if (!"9".equals(posLoanHeaderBean.getAppSource())) {
                try {
                   Map<String, Object> bodyMap = Maps.newHashMap();
                   bodyMap.put("userid", (StringUtil.isEmpty(nciicReqBean.getUserId()) ? "0" : nciicReqBean.getUserId()));
                   bodyMap.put("operation_type", "2");
                   bodyMap.put("appsource", "1");
                   bodyMap.put("id_type", "1");
                   bodyMap.put("id_no", nciicReqBean.getCertId());
                   bodyMap.put("name", nciicReqBean.getCertName());
                   bodyMap.put("id_checked", "1");
                   bodyMap.put("sessionid", nciicReqBean.getSessionId());
                   Map<String, Object> headerMap = Maps.newHashMap();
                    logger.info("用户系统请求 : " +bodyMap);
                
                    HResponse response = routeFacade.routeService("UMP0016", headerMap, bodyMap);
                    Map<String, Object> header = (Map<String, Object>)response.getProperties().get("header");
                    String respCode = (String) header.get("responseCode");
                    logger.debug("respCode" + respCode);
                    if("UMP000000".equals(respCode)){
                    	logger.info("更新用户实名信息成功");
                    }else{
                    	logger.error(response.getRespMessage());
                    	logger.info("更新用户实名信息失败");
                    	
                    	
                    	
                    }
                    
                   /* bodyMap = Maps.newHashMap();
                    bodyMap.put("userid", (StringUtil.isEmpty(nciicReqBean.getUserId()) ? "0" : nciicReqBean.getUserId()));
                    bodyMap.put("operation_type", "1");
                    bodyMap.put("appsource", "1");
                    bodyMap.put("cust_id", nciicReqBean.getCustId());
                     logger.info("用户系统请求 : " +bodyMap);
                 
                     response = routeFacade.routeService("UMP0016", headerMap, bodyMap);
                     header = (Map<String, Object>)response.getProperties().get("header");
                    respCode = (String) header.get("responseCode");
                     if("UMP000000".equals(respCode)){
                     	logger.info("更新cust_id成功");
                     }else{
                     	logger.error(response.getRespMessage());
                     	logger.info("更新cust_id失败");
                     }*/
                } catch (Exception e) {
                    logger.error("发送用户系统异常", e);
                }
   /*         }
        }
        */
//        if (!"9".equals(posLoanHeaderBean.getAppSource())) {
//            try {
//                UserSensitiveInformationUpdateRequest userSensitiveInformationUpdateRequest = new UserSensitiveInformationUpdateRequest();
//                userSensitiveInformationUpdateRequest.setUserId(StringUtil.isEmpty(nciicReqBean.getUserId()) ? "0" : nciicReqBean.getUserId());
//                userSensitiveInformationUpdateRequest.setOperationType("2");
//                userSensitiveInformationUpdateRequest.setAppSource("1");
//                userSensitiveInformationUpdateRequest.setIdType("1");
//                userSensitiveInformationUpdateRequest.setIdNo(nciicReqBean.getCertId());
//                userSensitiveInformationUpdateRequest.setIdCheckedStatus("2");
//                logger.info("用户系统请求 : " + userSensitiveInformationUpdateRequest);
//                UserSensitiveInformationUpdateResponse userSensitiveInformationUpdateResponse = umpUserService.updateUserSensitiveInformation(userSensitiveInformationUpdateRequest);
//                logger.info("用户系统应答 : " + userSensitiveInformationUpdateResponse);
//                if (userSensitiveInformationUpdateResponse == null || !"UMP000000".equals(userSensitiveInformationUpdateResponse.getResponseCode())) {
//                    logger.error("公安部实名数据录入失败");
//                } else {
//                    logger.info("公安部实名数据录入成功");
//                }
//                
//                userSensitiveInformationUpdateRequest = new UserSensitiveInformationUpdateRequest();
//                userSensitiveInformationUpdateRequest.setUserId(StringUtil.isEmpty(nciicReqBean.getUserId()) ? "0" : nciicReqBean.getUserId());
//                userSensitiveInformationUpdateRequest.setOperationType("1");
//                userSensitiveInformationUpdateRequest.setAppSource("1");
//                userSensitiveInformationUpdateRequest.setCustId(nciicReqBean.getCustId());
//                logger.info("用户系统请求 : " + userSensitiveInformationUpdateRequest);
//                userSensitiveInformationUpdateResponse = null;
//                userSensitiveInformationUpdateResponse = umpUserService.updateUserSensitiveInformation(userSensitiveInformationUpdateRequest);
//                logger.info("用户系统应答 : " + userSensitiveInformationUpdateResponse);
//                if (userSensitiveInformationUpdateResponse == null || !"UMP000000".equals(userSensitiveInformationUpdateResponse.getResponseCode())) {
//                    logger.error("客户编号数据录入失败");
//                } else {
//                    logger.info("客户编号数据录入成功");
//                }
//            } catch (Exception e) {
//                logger.error("发送用户系统异常", e);
//            }
//        }
        
        logger.info("公安部结束!");
        
        // 2. 卡验证
        logger.info("易极付卡验证请求处理...");
        
        // 2.1 卡验证请求
        String cardNo = yijifuVerifiedReqBean.getBankCardNo();
        
        tmpMap = Maps.newHashMap();
        tmpMap.put("cardNo", cardNo);
        tmpMap.put("cardName", paperName);
        tmpMap.put("orderNo", IdUtil.getBankCheckSeqNo());
        tmpMap.put("certNo", paperId);
        Map<String, String> tmpRetMap = null;
        tmpRetMap = bankCardCheckHessianService.bankCardCheck(tmpMap);
        if (tmpRetMap == null || tmpRetMap.size() < 1 || !"00".equals(tmpRetMap.get("respCode"))) {
            logger.error("卡验证数据异常");
        } else {
            // 2.3 录入用户系统
            // 只有C端手机用户才与用户系统挂钩
            if (!"9".equals(posLoanHeaderBean.getAppSource())) {
                try {
                   /* UserSensitiveInformationUpdateRequest userSensitiveInformationUpdateRequest = new UserSensitiveInformationUpdateRequest();
                    userSensitiveInformationUpdateRequest.setUserId(StringUtil.isEmpty(nciicReqBean.getUserId()) ? "0" : nciicReqBean.getUserId());
                    userSensitiveInformationUpdateRequest.setOperationType("3");
                    userSensitiveInformationUpdateRequest.setAppSource("1");
                    userSensitiveInformationUpdateRequest.setBankBranchName(yijifuVerifiedReqBean.getBankBranchName());
                    userSensitiveInformationUpdateRequest.setBankCardCheckedStatus("2");
                    userSensitiveInformationUpdateRequest.setBankCardNo(yijifuVerifiedReqBean.getBankCardNo());
                    userSensitiveInformationUpdateRequest.setBankCode(yijifuVerifiedReqBean.getBankCode());
                    userSensitiveInformationUpdateRequest.setBankSubbranchName(yijifuVerifiedReqBean.getBankSubbranchName());
                    logger.info("用户系统请求 : " + userSensitiveInformationUpdateRequest);
                    UserSensitiveInformationUpdateResponse userSensitiveInformationUpdateResponse = umpUserService.updateUserSensitiveInformation(userSensitiveInformationUpdateRequest);
                    logger.info("用户系统应答 : " + userSensitiveInformationUpdateResponse);
                    if (userSensitiveInformationUpdateResponse == null || !"UMP000000".equals(userSensitiveInformationUpdateResponse.getResponseCode())) {
                        logger.error("易极付卡验证实名数据录入失败");
                    } else {
                        logger.info("易极付卡验证实名数据录入成功");
                    }*/
                } catch (Exception e) {
                    logger.error("发送用户系统异常", e);
                }
            }
        }
        
//        if (!"9".equals(posLoanHeaderBean.getAppSource())) {
//            try {
//                UserSensitiveInformationUpdateRequest userSensitiveInformationUpdateRequest = new UserSensitiveInformationUpdateRequest();
//                userSensitiveInformationUpdateRequest.setUserId(StringUtil.isEmpty(nciicReqBean.getUserId()) ? "0" : nciicReqBean.getUserId());
//                userSensitiveInformationUpdateRequest.setOperationType("3");
//                userSensitiveInformationUpdateRequest.setAppSource("1");
//                userSensitiveInformationUpdateRequest.setBankBranchName(yijifuVerifiedReqBean.getBankBranchName());
//                userSensitiveInformationUpdateRequest.setBankCardCheckedStatus("2");
//                userSensitiveInformationUpdateRequest.setBankCardNo(yijifuVerifiedReqBean.getBankCardNo());
//                userSensitiveInformationUpdateRequest.setBankCode(yijifuVerifiedReqBean.getBankCode());
//                userSensitiveInformationUpdateRequest.setBankSubbranchName(yijifuVerifiedReqBean.getBankSubbranchName());
//                logger.info("用户系统请求 : " + userSensitiveInformationUpdateRequest);
//                UserSensitiveInformationUpdateResponse userSensitiveInformationUpdateResponse = umpUserService.updateUserSensitiveInformation(userSensitiveInformationUpdateRequest);
//                logger.info("用户系统应答 : " + userSensitiveInformationUpdateResponse);
//                if (userSensitiveInformationUpdateResponse == null || !"UMP000000".equals(userSensitiveInformationUpdateResponse.getResponseCode())) {
//                    logger.error("易极付卡验证实名数据录入失败");
//                } else {
//                    logger.info("易极付卡验证实名数据录入成功");
//                }
//            } catch (Exception e) {
//                logger.error("发送用户系统异常", e);
//            }
        }
        
        logger.info("易极付卡验证结束!");
        
       /* // 3. 工商
        logger.info("工商信息查询请求处理...");
        
        // 3.1 工商请求
        try {
            tmpMap = Maps.newHashMap();
            tmpMap.put("posCustId", aicReqBean.getPosCustId());
            tmpMap.put("posCustName", aicReqBean.getPosCustName());
            tmpRetMap = null;
            tmpRetMap = aicHessianService.getCustAICInfo(tmpMap);
            if ("00".equals(tmpRetMap.get("respCode"))) {
                logger.info("工商信息查询成功");
            } else {
                logger.error("工商信息查询失败");
            }
        } catch (Exception e) {
            logger.error("工商请求异常", e);
        }
        
        logger.info("工商信息查询结束!");*/
        
        logger.info("不等贷 第三方数据服务接口对接线程结束!");
        
    }
    
    /**
     * 通知FTP 拆包.
     * 
     * @param ftpReqBean
     */
    private void noticeFtp(FtpReqBean ftpReqBean) {
        ParamReqBean paramReqBean = new ParamReqBean();
        paramReqBean.setApplyNo(ftpReqBean.getLoanId());
        paramReqBean.setKeyValue(CreditApplyHServiceConstants.ftp_map_key_instno, ftpReqBean.getInstNo());
        paramReqBean.setCustId(ftpReqBean.getCustId());
        paramReqBean.setVersion(CreditApplyHServiceConstants.ftp_version);
        paramReqBean.setBizType(CreditApplyHServiceConstants.ftp_biztype);
        paramReqBean.setTransType(CreditApplyHServiceConstants.ftp_transtype);
        paramReqBean.setKeyValue(CreditApplyHServiceConstants.ftp_map_key_prefix, CreditApplyHServiceConstants.ftp_prefix_app);
        paramReqBean.setKeyValue(CreditApplyHServiceConstants.ftp_map_key_remotefilename, ftpReqBean.getRemotefilename());
        paramReqBean.setKeyValue(CreditApplyHServiceConstants.ftp_map_key_LocalSubFolderNameDef, ftpReqBean.getLocalSubFolderNameDef());
        paramReqBean.setKeyValue(CreditApplyHServiceConstants.ftp_map_key_url, ftpReqBean.getUrl());
        logger.debug("影像资料 请求报文 paramReqBean = " + paramReqBean.toURLParam());
        ParamResBean paramResBean = HttpClient.send(paramReqBean);
        if (paramResBean == null) {
            return;
        }
        logger.debug("影像资料 应答报文 paramResBean = " + paramResBean.toURLParam());
    }

    public NciicReqBean getNciicReqBean() {
        return nciicReqBean;
    }

    public void setNciicReqBean(NciicReqBean nciicReqBean) {
        this.nciicReqBean = nciicReqBean;
    }

    public YijifuVerifiedReqBean getYijifuVerifiedReqBean() {
        return yijifuVerifiedReqBean;
    }

    public void setYijifuVerifiedReqBean(YijifuVerifiedReqBean yijifuVerifiedReqBean) {
        this.yijifuVerifiedReqBean = yijifuVerifiedReqBean;
    }

    public PosLoanHeaderBean getPosLoanHeaderBean() {
        return posLoanHeaderBean;
    }

    public void setPosLoanHeaderBean(PosLoanHeaderBean posLoanHeaderBean) {
        this.posLoanHeaderBean = posLoanHeaderBean;
    }

    public AicReqBean getAicReqBean() {
        return aicReqBean;
    }

    public void setAicReqBean(AicReqBean aicReqBean) {
        this.aicReqBean = aicReqBean;
    }

    public FtpReqBean getFtpReqBean() {
        return ftpReqBean;
    }

    public void setFtpReqBean(FtpReqBean ftpReqBean) {
        this.ftpReqBean = ftpReqBean;
    }
}
