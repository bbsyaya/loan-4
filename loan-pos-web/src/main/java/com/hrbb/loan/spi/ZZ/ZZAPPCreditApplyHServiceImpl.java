package com.hrbb.loan.spi.ZZ;

import java.util.Date;
import java.util.Map;

import javax.annotation.Resource;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.google.common.collect.Maps;
import com.hrbb.loan.constants.CreditApplyConstants;
import com.hrbb.loan.pos.biz.backstage.inter.ILoanPosCreditApplyBackStageBiz;
import com.hrbb.loan.pos.biz.backstage.inter.ILoanPosCreditApplyCheckRegBiz;
import com.hrbb.loan.pos.dao.TCreditApplyDao;
import com.hrbb.loan.pos.factory.SysConfigFactory;
import com.hrbb.loan.pos.service.LoanPosBusinessCodeService;
import com.hrbb.loan.pos.service.LoanPosContractManagementService;
import com.hrbb.loan.pos.service.LoanPosCreditApplyService;
import com.hrbb.loan.pos.util.DateUtil;
import com.hrbb.loan.pos.util.MapUtils;
import com.hrbb.loan.pos.util.StringUtil;
import com.hrbb.loan.pos.util.ValidateUtil;
import com.hrbb.loan.spiconstants.CreditApplyHServiceConstants;
import com.hrbb.loan.spiconstants.HServiceReturnCode;
import com.hrbb.loan.work.PosLoanDataSynGetWork;
import com.hrbb.loan.work.WorkManagerGroup;
import com.hrbb.loan.work.bean.AicReqBean;
import com.hrbb.loan.work.bean.FtpReqBean;
import com.hrbb.loan.work.bean.NciicReqBean;
import com.hrbb.loan.work.bean.PosLoanHeaderBean;
import com.hrbb.loan.work.bean.YijifuVerifiedReqBean;
import com.hrbb.sh.framework.HResponse;
import com.hrbb.sh.framework.HServiceException;

/**
 * TransType:AP0001 -> 自助APP 业务申请通道.
 * 
 * @author xiongshaogang
 * @version $Id: ZZAPPCreditApplyHServiceImpl.java, v 0.1 2015年4月14日 下午1:56:49 xiongshaogang Exp $
 */
@Service("zzAppCreditApply")
public class ZZAPPCreditApplyHServiceImpl extends ZZAPPFoundationServiceImpl {

	Logger logger = LoggerFactory.getLogger(ZZAPPCreditApplyHServiceImpl.class);

	@Autowired
	private ILoanPosCreditApplyBackStageBiz loanPosCreditApplyBackStageBiz;
	
    private String URL;
    
    private String cityLimit;/*支持城市限制*/
    
    private String dailyApplyLimit;/*每日申请数量上限*/
	
	@Resource(name="WorkManagerGroup")
    private WorkManagerGroup WorkManagerGroup;
    
    @Resource(name="PosLoanDataSynGetWork")
    private PosLoanDataSynGetWork PosLoanDataSynGetWork;
    
    @Autowired
    private TCreditApplyDao tCreditApplyDao;
    
    @Autowired
    private LoanPosContractManagementService loanPosContractManagementService;
    
    @Autowired
    private ILoanPosCreditApplyCheckRegBiz iLoanPosCreditApplyCheckRegBiz;
    
    @Autowired
    private LoanPosCreditApplyService loanPosCreditApplyService;
    
    @Autowired
    private LoanPosBusinessCodeService loanPosBusinessCodeService;

	@Override
	protected HResponse doProcesser(HResponse resp, Map<String, String> headerMap,
                                    Map<String, String> bodyMap) throws HServiceException {
		logger.debug("in zzAppCreditApplyHServiceImpl...");
		
		/*加载系统参数配置*/
		URL = SysConfigFactory.getInstance().getService("basicService").getPropertyValue("webUrl");
        // 0. 判断用户是否可以再次申请
      /*  Map<String, Object> queryMap = Maps.newHashMap();
        queryMap.put("paperIdLike", bodyMap.get(CreditApplyHServiceConstants.paperid));
        List<Map<String, Object>> tmpQueryList = tCreditApplyDao.selectSelectiveMap(queryMap);
        if (tmpQueryList != null && tmpQueryList.size() > 0) {
            Map<String, Object> tmpQueryMap = tmpQueryList.get(0);
            
            if ("93".equals(tmpQueryMap.get("applyStatus"))) {
                Calendar calendar = Calendar.getInstance();
                calendar.setTime((Date)tmpQueryMap.get("beginDate"));
                calendar.add(Calendar.MONTH, 3);
                if (System.currentTimeMillis() < calendar.getTimeInMillis()) {
                    logger.error("当前用户3个月内已有一笔申请主动拒绝.");
                    bodyMap.put("respcode", HServiceReturnCode.LOAN_HASING_ERROR.getReturnCode());
                    bodyMap.put("respmsg", HServiceReturnCode.LOAN_HASING_ERROR.getReturnMessage());
                    resp.setRespCode(HServiceReturnCode.LOAN_HASING_ERROR.getReturnCode());
                    resp.setRespMessage(HServiceReturnCode.LOAN_HASING_ERROR.getReturnMessage());
                    return getBlankHResponse(resp, headerMap, bodyMap);
                }
            }
            
            Calendar calendar = Calendar.getInstance();
            calendar.setTime((Date)tmpQueryMap.get("beginDate"));
            calendar.add(Calendar.DAY_OF_YEAR, 7);
            if ("90".equals(tmpQueryMap.get("applyStatus")) && System.currentTimeMillis() <= calendar.getTimeInMillis()) {
                TContractManagement tContractManagement = loanPosContractManagementService.getContractInfoByLoanId((String)tmpQueryMap.get("loanId"));
                if (tContractManagement != null && "09".equals(tContractManagement.getAgreementStatus())) {
                    logger.error("当前用户3个月内已有一笔申请被批复‘已失效’.");
                    bodyMap.put("respcode", HServiceReturnCode.LOAN_HASING_ERROR.getReturnCode());
                    bodyMap.put("respmsg", HServiceReturnCode.LOAN_HASING_ERROR.getReturnMessage());
                    resp.setRespCode(HServiceReturnCode.LOAN_HASING_ERROR.getReturnCode());
                    resp.setRespMessage(HServiceReturnCode.LOAN_HASING_ERROR.getReturnMessage());
                    return getBlankHResponse(resp, headerMap, bodyMap);
                }
            }
        }*/
        
		// 1. 业务数据交换
		// 1.1 申请信息
		Map<String, Object> creMap = Maps.newHashMap();
//		creMap.put(CreditApplyConstants.posOrg, bodyMap.get(CreditApplyHServiceConstants.posorg));    // 收单机构
		creMap.put(CreditApplyConstants.posOrg, "88");    // 收单机构
		// 影像资料文件包名
		if (!StringUtil.isEmpty(bodyMap.get(CreditApplyHServiceConstants.imagefilepackagename))) {
		    creMap.put(CreditApplyHServiceConstants.imagefilepackagename, bodyMap.get(CreditApplyHServiceConstants.imagefilepackagename));
		}
        creMap.put(CreditApplyConstants.applyAmt, bodyMap.get(CreditApplyHServiceConstants.apptcapi));    // 申请额度
        if (StringUtil.isEmpty(bodyMap.get(CreditApplyHServiceConstants.appterm))) {
            creMap.put(CreditApplyConstants.applyTerm, "36");  // 申请期限
        } else {
            creMap.put(CreditApplyConstants.applyTerm, bodyMap.get(CreditApplyHServiceConstants.appterm));  // 申请期限
        }
        creMap.put(CreditApplyConstants.prodId, "1001020306");  // 产品ID
        creMap.put(CreditApplyConstants.prodName,
            loanPosBusinessCodeService.getItemNameByNo("ProductNo", "1001020306") == null ? "POS贷"
                : loanPosBusinessCodeService.getItemNameByNo("ProductNo", "1001020306"));   //产品名称
        //creMap.put(CreditApplyConstants.BIZ_LOAN_ID, IdUtil.getBizLoanId(CreditApplyConstants.CHANNEL_ZZ, "01"));  // 产品ID
        // 还款方式1
        if (!StringUtil.isEmpty(bodyMap.get(CreditApplyHServiceConstants.retukind))) {
            creMap.put(CreditApplyConstants.returnKind, bodyMap.get(CreditApplyHServiceConstants.retukind));
        }
        // 还款方式2
        if (!StringUtil.isEmpty(bodyMap.get(CreditApplyHServiceConstants.retukind2))) {
            creMap.put(CreditApplyConstants.repayMethod, bodyMap.get(CreditApplyHServiceConstants.retukind2));
        }
        // 发生方式
//        creMap.put(CreditApplyConstants.occurType, CreditApplyConstants.occurTypeAdd);
        creMap.put(CreditApplyConstants.occurType, bodyMap.get(CreditApplyHServiceConstants.accepttpye));    // 发生方式
        // 银行卡号
        creMap.put(CreditApplyConstants.bankAccno, bodyMap.get(CreditApplyHServiceConstants.bankaccno));
        // 进件方式
        if ("9".equals(headerMap.get("AppSource"))) {
            creMap.put(CreditApplyConstants.inChannelKind, "05");  // 申请来源:进件方式：iPad
        } else {
            creMap.put(CreditApplyConstants.inChannelKind, CreditApplyConstants.inChannelApp);  // 申请来源:进件方式：app默认：01
        }
        
        // 机构号/推荐机构
        creMap.put(CreditApplyConstants.recOrg, bodyMap.get(CreditApplyHServiceConstants.bankid));
        // 营销经理/推荐人
        creMap.put(CreditApplyConstants.recPerson, bodyMap.get(CreditApplyHServiceConstants.operid));
        creMap.put(CreditApplyConstants.beginDate, new Date());
        creMap.put(CreditApplyConstants.APPLY_STATUS, CreditApplyConstants.STATUS_PENDING);
        creMap.put(CreditApplyConstants.POS_CUST_NAME, bodyMap.get(CreditApplyHServiceConstants.poscustname));
        creMap.put(CreditApplyConstants.channel, CreditApplyConstants.CHANNEL_ZZ);  // 机构代码
        creMap.put(CreditApplyConstants.operName, "系统自动处理");
        creMap.put(CreditApplyConstants.operId, "system");
        creMap.put(CreditApplyConstants.region, bodyMap.get(CreditApplyHServiceConstants.operaddrRegion));
        //申请期限单位默认为月M
      	creMap.put(CreditApplyConstants.termUnit, CreditApplyConstants.MONTH);
      	// 客户姓名
      	creMap.put(CreditApplyConstants.custName, bodyMap.get(CreditApplyHServiceConstants.custname));
      	
      	creMap.put(CreditApplyConstants.loanType, "01");
      	// 币种 默认为人民币
      	creMap.put(CreditApplyConstants.currSign, "CNY");
      		
        logger.info("申请信息 creMap : " + MapUtils.toString(creMap));
		
		// 1.2 客户信息
		Map<String, Object> custMap = Maps.newHashMap();
		custMap.put(CreditApplyConstants.CUST_NAME, bodyMap.get(CreditApplyHServiceConstants.custname));    // 客户姓名
		custMap.put(CreditApplyConstants.paperKind, bodyMap.get(CreditApplyHServiceConstants.paperkind));   // 证件类型
		custMap.put(CreditApplyConstants.PAPER_ID, bodyMap.get(CreditApplyHServiceConstants.paperid));  // 证件号码
		//根据身份证号获取出生日期
		custMap.put(CreditApplyConstants.birtDate, DateUtil.getDatePattern1(bodyMap.get(CreditApplyHServiceConstants.paperid).substring(6, 14)));
//		custMap.put(CreditApplyConstants.sexSign, bodyMap.get(CreditApplyHServiceConstants.sexsign));   // 性别
		custMap.put(CreditApplyConstants.sexSign, "9");   // 性别
//		custMap.put(CreditApplyConstants.busiYear, bodyMap.get(CreditApplyHServiceConstants.busiyear)); // 从业年限
		custMap.put(CreditApplyConstants.busiYear, "9"); // 从业年限
		custMap.put(CreditApplyConstants.marrSign, bodyMap.get(CreditApplyHServiceConstants.marrsign)); // 婚姻状况
//		custMap.put(CreditApplyConstants.educSign, bodyMap.get(CreditApplyHServiceConstants.edusign)); // 受教育程度
		custMap.put(CreditApplyConstants.educSign, "40"); // 受教育程度
		custMap.put(CreditApplyConstants.childNum, bodyMap.get(CreditApplyHServiceConstants.childnum)); // 子女人数
//		custMap.put(CreditApplyConstants.localHouseNum, bodyMap.get(CreditApplyHServiceConstants.localhousenum));   // 拥有经营地房产数量
//		custMap.put(CreditApplyConstants.otherHouseNum, bodyMap.get(CreditApplyHServiceConstants.otherhousenum));   // 拥有非经营地房产数量
		custMap.put(CreditApplyConstants.localHouseNum, "0");   // 拥有经营地房产数量
        custMap.put(CreditApplyConstants.otherHouseNum, "0");   // 拥有非经营地房产数量
		custMap.put(CreditApplyConstants.mobilePhone, bodyMap.get(CreditApplyHServiceConstants.mobilephone));   // 手机
		custMap.put(CreditApplyConstants.tel, bodyMap.get(CreditApplyHServiceConstants.tel));   // 办公电话
		if ("20".equals(bodyMap.get(CreditApplyHServiceConstants.marrsign))) {
		    custMap.put(CreditApplyConstants.familyCustName, bodyMap.get(CreditApplyHServiceConstants.familycustname));    // 配偶姓名
		    custMap.put(CreditApplyConstants.matePaperKind, bodyMap.get(CreditApplyHServiceConstants.matepaperkind));  // 配偶证件类型
		    custMap.put(CreditApplyConstants.matePaperId, bodyMap.get(CreditApplyHServiceConstants.matepaperid));  // 配偶证件号码
		    custMap.put(CreditApplyConstants.mateBirtDate, DateUtil.getDatePattern1(bodyMap.get(CreditApplyHServiceConstants.matepaperid).substring(6, 14)));
		    custMap.put(CreditApplyConstants.mateMobilePhone, bodyMap.get(CreditApplyHServiceConstants.matemobilephone));  // 配偶手机
        }
		// 居住地-行政区划
		custMap.put(CreditApplyConstants.residentProv, bodyMap.get(CreditApplyHServiceConstants.residentRegion).substring(0, 2) + "0000");
		custMap.put(CreditApplyConstants.residentCity, bodyMap.get(CreditApplyHServiceConstants.residentRegion).substring(0, 4) + "00");
		custMap.put(CreditApplyConstants.residentDivision, bodyMap.get(CreditApplyHServiceConstants.residentRegion));
		// 居住地址-具体
		custMap.put(CreditApplyConstants.residentDetail, bodyMap.get(CreditApplyHServiceConstants.residentdetail));
		custMap.put(CreditApplyConstants.contactAddrFlag, bodyMap.get(CreditApplyHServiceConstants.contactaddrflag));   // 联系地址
		if (!StringUtil.isEmpty(bodyMap.get(CreditApplyHServiceConstants.weixinno))) {
		    custMap.put(CreditApplyConstants.weixinNo, bodyMap.get(CreditApplyHServiceConstants.weixinno));   // 微信号
		}
		if (!StringUtil.isEmpty(bodyMap.get(CreditApplyHServiceConstants.qqno))) {
		    custMap.put(CreditApplyConstants.qqNo, bodyMap.get(CreditApplyHServiceConstants.qqno));     // QQ号
		}
		if (!StringUtil.isEmpty(bodyMap.get(CreditApplyHServiceConstants.email))) {
		    custMap.put(CreditApplyConstants.email, bodyMap.get(CreditApplyHServiceConstants.email));   // 电子邮箱
		}
		
		logger.info("客户信息 custMap : " + MapUtils.toString(custMap));
		// 1.3 商户信息
		Map<String, Object> posCustMap = Maps.newHashMap();
		posCustMap.put(CreditApplyConstants.POS_CUST_NAME, bodyMap.get(CreditApplyHServiceConstants.poscustname));    // 商户名称
//		posCustMap.put(CreditApplyConstants.REG_CODE, bodyMap.get(CreditApplyHServiceConstants.regicode));            // 营业执照号
//		posCustMap.put(CreditApplyConstants.posCustBusiScope, bodyMap.get(CreditApplyHServiceConstants.dealscope));   // 主营业务
		posCustMap.put(CreditApplyConstants.REG_CODE, "");            // 营业执照号
        posCustMap.put(CreditApplyConstants.posCustBusiScope, "");   // 主营业务
		posCustMap.put(CreditApplyConstants.operAddrCode, bodyMap.get(CreditApplyHServiceConstants.operaddrRegion));  // 实际经营地址-行政区划
		posCustMap.put(CreditApplyConstants.posCustAddress, bodyMap.get(CreditApplyHServiceConstants.operaddrdetail));    // 实际经营地址-具体
//		posCustMap.put(CreditApplyConstants.industryTypeId, bodyMap.get(CreditApplyHServiceConstants.industrytypeid));    // 所属行业
		posCustMap.put(CreditApplyConstants.industryTypeId, "99");    // 所属行业
//		posCustMap.put(CreditApplyConstants.industryTypeId2, CreditApplyFactory.getIndustryType(bodyMap.get(CreditApplyHServiceConstants.dealscope)));    // 所属行业
		posCustMap.put(CreditApplyConstants.industryTypeId2, "99");    // 所属行业
		if (StringUtil.isNotEmpty(bodyMap.get("haspos"))) {
		    posCustMap.put("isPosInstall", bodyMap.get("haspos"));  // 是否安装POS机标志 2：未安装 1：安装
        }
		
		logger.info("商户信息 posCustMap : " + MapUtils.toString(posCustMap));
		
		// 1.4 亲属信息
		Map<String, Object> relaMap = Maps.newHashMap();
		if (!"20".equals(bodyMap.get(CreditApplyHServiceConstants.marrsign))) {
		    relaMap.put(CreditApplyConstants.relaCustName, bodyMap.get(CreditApplyHServiceConstants.relacustname));   // 亲属姓名
		    relaMap.put(CreditApplyConstants.relaKind, bodyMap.get(CreditApplyHServiceConstants.relakind));   // 亲属类型
		    relaMap.put(CreditApplyConstants.relaMobilePhone, bodyMap.get(CreditApplyHServiceConstants.relamobilephone)); // 亲属手机
		    relaMap.put(CreditApplyConstants.relaTel, bodyMap.get(CreditApplyHServiceConstants.relatel));     // 亲属固话
        }
		
		logger.info("亲属信息 relaMap : " + MapUtils.toString(relaMap));
		
		// 1.5 银行账号信息
		Map<String, Object> bankMap = Maps.newHashMap();
		// 银行账号/卡号
		bankMap.put(CreditApplyConstants.bankAccno, bodyMap.get(CreditApplyHServiceConstants.bankaccno));
		// 账户开户行
		bankMap.put(CreditApplyConstants.bankName, bodyMap.get(CreditApplyHServiceConstants.bankName));
		// 账户分行
		bankMap.put(CreditApplyConstants.bankBranName, bodyMap.get(CreditApplyHServiceConstants.bankBrandName));
		// 账户支行
		bankMap.put(CreditApplyConstants.bankSubName, bodyMap.get(CreditApplyHServiceConstants.bankSubName));
		
		logger.info("银行账户信息 bankMap : " + MapUtils.toString(bankMap));
		
		// 2. 业务受理入库
		Map<String, Object> resMap = loanPosCreditApplyBackStageBiz
				.creditApplyReg(creMap, custMap, posCustMap, bankMap, relaMap,
						null);
		if(resMap.isEmpty()){
		    bodyMap.put("respcode", HServiceReturnCode.DB_ERROR_ERROR.getReturnCode());
            bodyMap.put("respmsg", HServiceReturnCode.DB_ERROR_ERROR.getReturnMessage());
			resp.setRespCode(HServiceReturnCode.DB_ERROR_ERROR.getReturnCode());
			resp.setRespMessage(HServiceReturnCode.DB_ERROR_ERROR.getReturnMessage());
			resp.setRespTime(new Date());
			return getBlankHResponse(resp, headerMap, bodyMap);
		}
		
		if(!resMap.isEmpty() && resMap.get("hasPaperId") != null){
			bodyMap.put("respcode", HServiceReturnCode.HAS_PAPER_ID.getReturnCode());
            bodyMap.put("respmsg", HServiceReturnCode.HAS_PAPER_ID.getReturnMessage());
			resp.setRespCode(HServiceReturnCode.HAS_PAPER_ID.getReturnCode());
			resp.setRespMessage(HServiceReturnCode.HAS_PAPER_ID.getReturnMessage());
			resp.setRespTime(new Date());
			return getBlankHResponse(resp, headerMap, bodyMap);
		}
		
		// 3 准入校验
		/*logger.info("loanid为："+resMap.get("loanid") + "开始准入校验...");
		boolean checkFlag = false;
		try {
            Map<String, Object> checkMap = iLoanPosCreditApplyCheckRegBiz.creditApplyCheck((String)resMap.get("loanid"));
            if (checkMap == null || !"000".equals(checkMap.get("checkCode"))) {
            	logger.debug("返回结果为：" + checkMap.toString());
                logger.info("准入校验失败,直接返回成功!");
                
                // 更改申请状态为： 10 （受理）
                Map<String, Object> updateMap = Maps.newHashMap();
                updateMap.put("loanId", bodyMap.get("loanid"));
                updateMap.put("applyStatus", CreditApplyConstants.STATUS_ACCPT);
                updateMap.put("lastOperTime", new Date());
                updateMap.put("lastOperId", "system");
                loanPosCreditApplyService.updateApplyStatus(updateMap);
            } else {
                checkFlag = true;
                logger.info("准入校验通过!");
            }
		} catch (Exception e1) {
		    logger.error("准入校验异常,更改申请状态，直接返回成功!", e1);
		    
		    // 更改申请状态为： 10 （受理）
		    Map<String, Object> updateMap = Maps.newHashMap();
            updateMap.put("loanId", bodyMap.get("loanid"));
	        updateMap.put("applyStatus", CreditApplyConstants.STATUS_ACCPT);
	        updateMap.put("lastOperTime", new Date());
	        updateMap.put("lastOperId", "system");
		    loanPosCreditApplyService.updateApplyStatus(updateMap);
        }*/
		
		// 4. 1 站内消息推送
		/*try {
            userProcesser.createMessage(1, 1, "业务申请签约通知", "尊敬的持卡人，你好，您有一笔业务申请已审批。请在7天内发起签约，请知悉！", 1, 2, Integer.parseInt((String)headerMap.get("UserId")), "通知");
        } catch (Exception e) {
            logger.error("向用户系统发送站内消息失败");
        }*/
		
		    // 5. 调用第三方数据接口
		    // 5.0 报文头
		    PosLoanHeaderBean posLoanHeaderBean = new PosLoanHeaderBean();
		    posLoanHeaderBean.setAppSource(headerMap.get("AppSource"));
		    posLoanHeaderBean.setMac(headerMap.get("Mac"));
		    posLoanHeaderBean.setSessionId(headerMap.get("SessionId"));
		    posLoanHeaderBean.setUserId(headerMap.get("UserId"));
		    posLoanHeaderBean.setVersion(headerMap.get("Version"));
		    
		    // 5.1 公安部
		    NciicReqBean nciicReqBean = new NciicReqBean();
		    nciicReqBean.setCertType(bodyMap.get(CreditApplyHServiceConstants.paperkind));
		    nciicReqBean.setCertId(bodyMap.get(CreditApplyHServiceConstants.paperid));
		    nciicReqBean.setCertName(bodyMap.get(CreditApplyHServiceConstants.custname));
		    nciicReqBean.setSessionId(headerMap.get("SessionId"));
		    nciicReqBean.setUserId(headerMap.get("UserId"));
		    nciicReqBean.setCustId((String)resMap.get("custid"));
		    
		    // 5.2 易极付卡验证
		    YijifuVerifiedReqBean yijifuVerifiedReqBean = new YijifuVerifiedReqBean();
		    yijifuVerifiedReqBean.setBankCode(bodyMap.get(CreditApplyHServiceConstants.bankName));
		    yijifuVerifiedReqBean.setBankBranchName(bodyMap.get(CreditApplyHServiceConstants.bankBrandName));
		    yijifuVerifiedReqBean.setBankSubbranchName(bodyMap.get(CreditApplyHServiceConstants.bankSubName));
		    yijifuVerifiedReqBean.setBankCardNo(bodyMap.get(CreditApplyHServiceConstants.bankaccno));
		    yijifuVerifiedReqBean.setCertType(bodyMap.get(CreditApplyHServiceConstants.paperkind));
		    yijifuVerifiedReqBean.setCertId(bodyMap.get(CreditApplyHServiceConstants.paperid));
		    yijifuVerifiedReqBean.setCertName(bodyMap.get(CreditApplyHServiceConstants.custname));
		    
		    // 5.3 工商信息
		    AicReqBean aicReqBean = new AicReqBean();
		    aicReqBean.setPosCustId(bodyMap.get(CreditApplyHServiceConstants.regicode));
		    aicReqBean.setPosCustName(bodyMap.get(CreditApplyHServiceConstants.poscustname));
		    
		    // 5.4 影像资料解包
		    FtpReqBean ftpReqBean = new FtpReqBean();
		    ftpReqBean.setLoanId((String)resMap.get("loanid"));
		    ftpReqBean.setCustId((String)resMap.get("custid"));
		    ftpReqBean.setInstNo("BD");
		    ftpReqBean.setPrefix(CreditApplyHServiceConstants.ftp_prefix_app);
		    ftpReqBean.setLocalSubFolderNameDef((String)resMap.get("loanid"));
		    ftpReqBean.setRemotefilename(bodyMap.get(CreditApplyHServiceConstants.imagefilepackagename));
		    ftpReqBean.setUrl(URL + "creditApplyUpdate/updateApplyStatusForDownloadImages.do");
		    
		    PosLoanDataSynGetWork.setPosLoanHeaderBean(posLoanHeaderBean);
		    PosLoanDataSynGetWork.setNciicReqBean(nciicReqBean);
		    PosLoanDataSynGetWork.setYijifuVerifiedReqBean(yijifuVerifiedReqBean);
		    PosLoanDataSynGetWork.setAicReqBean(aicReqBean);
		    PosLoanDataSynGetWork.setFtpReqBean(ftpReqBean);
		    WorkManagerGroup.addThread("prePosLoanDataSyn", PosLoanDataSynGetWork);

		
		// 6. 如果都成功, 回写数据
		Map<String, Object> respMap = Maps.newHashMap();
		resMap.put("respcode", HServiceReturnCode.SUCCESS.getReturnCode());
		resMap.put("respmsg", HServiceReturnCode.SUCCESS.getReturnMessage());
		respMap.put("HrbbBody", resMap);
		respMap.put("HrbbHeader", headerMap);
		
		// 6.1 签名处理
        headerMap.put("Mac", sign(resMap, null));
		
		resp.setProperties(respMap);
		resp.setRespCode(HServiceReturnCode.SUCCESS.getReturnCode());
		resp.setRespMessage(HServiceReturnCode.SUCCESS.getReturnMessage());
		resp.setRespTime(new Date());
		logger.info("回写数据: " + resp.toString());
		logger.debug("out zzAppCreditApplyHServiceImpl...");
		return resp;
	}
	
	/**
	 * 请求包校验处理.
	 * 
	 * @param headerMap
	 * @param bodyMap
	 * @return
	 */
	protected boolean validate(Map<String, String> headerMap, Map<String, String> bodyMap, HResponse resp) {
	    
	    if (!validateHeader(headerMap, bodyMap, resp)) {
            return false;
        }
	    // 加载系统配置参数
	    cityLimit = SysConfigFactory.getInstance().getService("ZZ").getPropertyValue("cityLimit");
        dailyApplyLimit = SysConfigFactory.getInstance().getService("ZZ").getPropertyValue("dailyApplyLimit");
        
        // 当日业务申请数量限制
        Map<String,Object> reqMap = Maps.newHashMap();
        reqMap.put("channel", "ZZ");
        reqMap.put("inChannelKind", "01");
        Long count = loanPosCreditApplyService.countDailyApply(reqMap);
        if(count>=Long.parseLong(dailyApplyLimit)){
            logger.info("今日申请名额已用完,当前名次 为[{}]",dailyApplyLimit);
            bodyMap.put("respcode", HServiceReturnCode.DAILY_APPLY_LIMIT_RRROR.getReturnCode());
            bodyMap.put("respmsg", HServiceReturnCode.DAILY_APPLY_LIMIT_RRROR.getReturnMessage());
            resp.setRespCode(HServiceReturnCode.DAILY_APPLY_LIMIT_RRROR.getReturnCode());
            resp.setRespMessage(HServiceReturnCode.DAILY_APPLY_LIMIT_RRROR.getReturnMessage());
            return false;
        }
        
	    // 收单机构
    /*    String posorg = (String) bodyMap.get(CreditApplyHServiceConstants.posorg);
        if (StringUtil.isEmpty(posorg)) {
            logger.error("收单机构为空或不合法:[]", posorg);
            bodyMap.put("respcode", HServiceReturnCode.POS_ORG_ERROR.getReturnCode());
            bodyMap.put("respmsg", HServiceReturnCode.POS_ORG_ERROR.getReturnMessage());
            resp.setRespCode(HServiceReturnCode.POS_ORG_ERROR.getReturnCode());
            resp.setRespMessage(HServiceReturnCode.POS_ORG_ERROR.getReturnMessage());
            return false;
        }*/
	    
        // 商户名称
        String poscustname = (String) bodyMap.get(CreditApplyHServiceConstants.poscustname);
        if (StringUtil.isEmpty(poscustname)) {
            logger.error("商户名称为空或不合法:[]", poscustname);
            bodyMap.put("respcode", HServiceReturnCode.POSCUSTNAME_ERROR.getReturnCode());
            bodyMap.put("respmsg", HServiceReturnCode.POSCUSTNAME_ERROR.getReturnMessage());
            resp.setRespCode(HServiceReturnCode.POSCUSTNAME_ERROR.getReturnCode());
            resp.setRespMessage(HServiceReturnCode.POSCUSTNAME_ERROR.getReturnMessage());
            return false;
        }
        logger.info("poscustname validate success !");
        // 营业执照号
     /*   String regicode = (String) bodyMap
                .get(CreditApplyHServiceConstants.regicode);
        if (StringUtil.isEmpty(regicode)) {
            logger.error("营业执照号为空或不合法:[]", regicode);
            bodyMap.put("respcode", HServiceReturnCode.REGICODE_ERROR.getReturnCode());
            bodyMap.put("respmsg", HServiceReturnCode.REGICODE_ERROR.getReturnMessage());
            resp.setRespCode(HServiceReturnCode.REGICODE_ERROR.getReturnCode());
            resp.setRespMessage(HServiceReturnCode.REGICODE_ERROR
                    .getReturnMessage());
            return false;
        }*/
        logger.info("regicode validate success !");
        // 主营业务
       /* String dealscope = (String) bodyMap
                .get(CreditApplyHServiceConstants.dealscope);
        if (StringUtil.isEmpty(dealscope)) {
            logger.error("主营业务为空或不合法:[]", dealscope);
            bodyMap.put("respcode", HServiceReturnCode.DEALSCOPE_ERROR.getReturnCode());
            bodyMap.put("respmsg", HServiceReturnCode.DEALSCOPE_ERROR.getReturnMessage());
            resp.setRespCode(HServiceReturnCode.DEALSCOPE_ERROR.getReturnCode());
            resp.setRespMessage(HServiceReturnCode.DEALSCOPE_ERROR
                    .getReturnMessage());
            return false;
        }*/
        logger.info("dealscope validate success !");
        // 实际经营地址-行政区划
        String operaddrRegion = (String) bodyMap
                .get(CreditApplyHServiceConstants.operaddrRegion);
        if (StringUtil.isEmpty(operaddrRegion)) {
            logger.error("行政区划为空或有误:[]", operaddrRegion);
            bodyMap.put("respcode", HServiceReturnCode.OPERADDRREGION_ERROR.getReturnCode());
            bodyMap.put("respmsg", HServiceReturnCode.OPERADDRREGION_ERROR.getReturnMessage());
            resp.setRespCode(HServiceReturnCode.OPERADDRREGION_ERROR
                    .getReturnCode());
            resp.setRespMessage(HServiceReturnCode.OPERADDRREGION_ERROR
                    .getReturnMessage());
            return false;
        }else{
            // 经营地-是否支持
            String city = operaddrRegion.substring(0, 4);
            city = city.concat("00");
            if(!cityLimit.contains(city)){
                logger.error("行政区划为空或有误:[]", operaddrRegion);
                bodyMap.put("respcode", HServiceReturnCode.NOT_REGION.getReturnCode());
                bodyMap.put("respmsg", HServiceReturnCode.NOT_REGION.getReturnMessage());
                resp.setRespCode(HServiceReturnCode.NOT_REGION
                        .getReturnCode());
                resp.setRespMessage(HServiceReturnCode.NOT_REGION
                        .getReturnMessage());
                return false;   
            }
        }
        
        logger.info("operaddrRegion validate success !");
        // 实际经营地址-具体
        String operaddrdetail = (String) bodyMap
                .get(CreditApplyHServiceConstants.operaddrdetail);
        if (StringUtil.isEmpty(operaddrdetail)) {
            logger.error("具体经营地址为空或有误:[]", operaddrdetail);
            bodyMap.put("respcode", HServiceReturnCode.OPERADDRDETAIL_ERROR.getReturnCode());
            bodyMap.put("respmsg", HServiceReturnCode.OPERADDRDETAIL_ERROR.getReturnMessage());
            resp.setRespCode(HServiceReturnCode.OPERADDRDETAIL_ERROR
                    .getReturnCode());
            resp.setRespMessage(HServiceReturnCode.OPERADDRDETAIL_ERROR
                    .getReturnMessage());
            return false;
        }
        logger.info("operaddrdetail validate success !");

        // 所属行业
      /*  String industrytypeid = (String) bodyMap
                .get(CreditApplyHServiceConstants.industrytypeid);
        if (StringUtil.isEmpty(industrytypeid)) {
            logger.error("所属行业为空:[]", industrytypeid);
            bodyMap.put("respcode", HServiceReturnCode.INDUSTRYTYPEID_ERROR.getReturnCode());
            bodyMap.put("respmsg", HServiceReturnCode.INDUSTRYTYPEID_ERROR.getReturnMessage());
            resp.setRespCode(HServiceReturnCode.INDUSTRYTYPEID_ERROR.getReturnCode());
            resp.setRespMessage(HServiceReturnCode.INDUSTRYTYPEID_ERROR
                    .getReturnMessage());
            return false;
        }*/
        logger.info("industrytypeid validate success !");
        // 客户姓名
        String custname = (String) bodyMap
                .get(CreditApplyHServiceConstants.custname);
        if (StringUtil.isEmpty(custname)
                || !ValidateUtil.checkChinese(custname)) {
            logger.error("客户姓名为空或有误:[]", custname);
            bodyMap.put("respcode", HServiceReturnCode.CUSTNAME_ERROR.getReturnCode());
            bodyMap.put("respmsg", HServiceReturnCode.CUSTNAME_ERROR.getReturnMessage());
            resp.setRespCode(HServiceReturnCode.CUSTNAME_ERROR.getReturnCode());
            resp.setRespMessage(HServiceReturnCode.CUSTNAME_ERROR
                    .getReturnMessage());
            return false;
        }
        logger.info("custname validate success !");

        // 证件类型
        String paperkind = (String) bodyMap
                .get(CreditApplyHServiceConstants.paperkind);
        if (StringUtil.isEmpty(paperkind) || !paperkind.equals("01")) {
            logger.error("证件类型为空或有误:[]", paperkind);
            bodyMap.put("respcode", HServiceReturnCode.PAPERKIND_ERROR.getReturnCode());
            bodyMap.put("respmsg", HServiceReturnCode.PAPERKIND_ERROR.getReturnMessage());
            resp.setRespCode(HServiceReturnCode.PAPERKIND_ERROR.getReturnCode());
            resp.setRespMessage(HServiceReturnCode.PAPERKIND_ERROR
                    .getReturnMessage());
            return false;
        }
        logger.info("paperkind validate success !");
        // 证件号码
        String paperid = (String) bodyMap
                .get(CreditApplyHServiceConstants.paperid);
        if (StringUtil.isEmpty(paperid) || !ValidateUtil.checkIdNumber2(paperid)) {
            logger.error("证件号码为空或有误:[]", paperid);
            bodyMap.put("respcode", HServiceReturnCode.PAPERID_ERROR.getReturnCode());
            bodyMap.put("respmsg", HServiceReturnCode.PAPERID_ERROR.getReturnMessage());
            resp.setRespCode(HServiceReturnCode.PAPERID_ERROR.getReturnCode());
            resp.setRespMessage(HServiceReturnCode.PAPERID_ERROR
                    .getReturnMessage());
            return false;
        }
        logger.info("paperid validate success !");
        // 性别
       /* String sexsign = (String) bodyMap
                .get(CreditApplyHServiceConstants.sexsign);
        if (StringUtil.isEmpty(sexsign)
                || "1|2".indexOf(sexsign) < 0) {
            logger.error("性别为空或有误:[]", sexsign);
            bodyMap.put("respcode", HServiceReturnCode.SEXSIGN_ERROR.getReturnCode());
            bodyMap.put("respmsg", HServiceReturnCode.SEXSIGN_ERROR.getReturnMessage());
            resp.setRespCode(HServiceReturnCode.SEXSIGN_ERROR.getReturnCode());
            resp.setRespMessage(HServiceReturnCode.SEXSIGN_ERROR
                    .getReturnMessage());
            return false;
        }*/
        logger.info("sexsign validate success !");

        // 从业年限
     /*   String busiyear = (String) bodyMap
                .get(CreditApplyHServiceConstants.busiyear);
        if (StringUtil.isEmpty(busiyear)
                || !ValidateUtil.checkInteger(busiyear)) {
            logger.error("从业年限为空或有误:[]", busiyear);
            bodyMap.put("respcode", HServiceReturnCode.BUSIYEAR_ERROR.getReturnCode());
            bodyMap.put("respmsg", HServiceReturnCode.BUSIYEAR_ERROR.getReturnMessage());
            resp.setRespCode(HServiceReturnCode.BUSIYEAR_ERROR.getReturnCode());
            resp.setRespMessage(HServiceReturnCode.BUSIYEAR_ERROR
                    .getReturnMessage());
            return false;
        }*/
        logger.info("busiyear validate success !");
        // 婚姻状况
        String marrsign = (String) bodyMap
                .get(CreditApplyHServiceConstants.marrsign);
        if (StringUtil.isEmpty(marrsign)
                || "10|20|30|40".indexOf(marrsign) < 0) {
            logger.error("婚姻状况为空或有误:[]",marrsign);
            bodyMap.put("respcode", HServiceReturnCode.MARRSIGN_ERROR.getReturnCode());
            bodyMap.put("respmsg", HServiceReturnCode.MARRSIGN_ERROR.getReturnMessage());
            resp.setRespCode(HServiceReturnCode.MARRSIGN_ERROR.getReturnCode());
            resp.setRespMessage(HServiceReturnCode.MARRSIGN_ERROR
                    .getReturnMessage());
            return false;
        }
        logger.info("marrsign validate success !");
        
        // 配偶及亲属校验
        if ("20".equals(marrsign)) {
            if (StringUtil.isEmpty(bodyMap.get(CreditApplyHServiceConstants.familycustname)) 
                    || !ValidateUtil.checkChinese(bodyMap.get(CreditApplyHServiceConstants.familycustname))) {// 配偶姓名
                logger.error("配偶姓名为空或有误:[]",bodyMap.get(CreditApplyHServiceConstants.familycustname));
                bodyMap.put("respcode", HServiceReturnCode.FAMILYCUSTNAME_ERROR.getReturnCode());
                bodyMap.put("respmsg", HServiceReturnCode.FAMILYCUSTNAME_ERROR.getReturnMessage());
                resp.setRespCode(HServiceReturnCode.FAMILYCUSTNAME_ERROR.getReturnCode());
                resp.setRespMessage(HServiceReturnCode.FAMILYCUSTNAME_ERROR
                        .getReturnMessage());
                return false;
            }
            
            if (StringUtil.isEmpty(bodyMap.get(CreditApplyHServiceConstants.matepaperkind)) 
                    || "01".indexOf(bodyMap.get(CreditApplyHServiceConstants.matepaperkind)) < 0) {// 配偶证件类型
                logger.error("配偶证件类型为空或有误:[]",bodyMap.get(CreditApplyHServiceConstants.matepaperkind));
                bodyMap.put("respcode", HServiceReturnCode.MATEPAPERKIND_ERROR.getReturnCode());
                bodyMap.put("respmsg", HServiceReturnCode.MATEPAPERKIND_ERROR.getReturnMessage());
                resp.setRespCode(HServiceReturnCode.MATEPAPERKIND_ERROR.getReturnCode());
                resp.setRespMessage(HServiceReturnCode.MATEPAPERKIND_ERROR
                        .getReturnMessage());
                return false;
            }
            
            if (StringUtil.isEmpty(bodyMap.get(CreditApplyHServiceConstants.matepaperid))
                    || !ValidateUtil.checkIdNumber2(bodyMap.get(CreditApplyHServiceConstants.matepaperid))) {// 配偶证件号码
                logger.error("配偶证件号码为空或有误:[]",bodyMap.get(CreditApplyHServiceConstants.matepaperid));
                bodyMap.put("respcode", HServiceReturnCode.MATEPAPERID_ERROR.getReturnCode());
                bodyMap.put("respmsg", HServiceReturnCode.MATEPAPERID_ERROR.getReturnMessage());
                resp.setRespCode(HServiceReturnCode.MATEPAPERID_ERROR.getReturnCode());
                resp.setRespMessage(HServiceReturnCode.MATEPAPERID_ERROR
                        .getReturnMessage());
                return false;
            }
            
            if (StringUtil.isEmpty(bodyMap.get(CreditApplyHServiceConstants.matemobilephone))
                    || !ValidateUtil.checkMobile(bodyMap.get(CreditApplyHServiceConstants.matemobilephone))) {// 配偶手机 
                logger.error("配偶手机 为空或有误:[]",bodyMap.get(CreditApplyHServiceConstants.matemobilephone));
                bodyMap.put("respcode", HServiceReturnCode.MATEMOBILEPHONE_ERROR.getReturnCode());
                bodyMap.put("respmsg", HServiceReturnCode.MATEMOBILEPHONE_ERROR.getReturnMessage());
                resp.setRespCode(HServiceReturnCode.MATEMOBILEPHONE_ERROR.getReturnCode());
                resp.setRespMessage(HServiceReturnCode.MATEMOBILEPHONE_ERROR
                        .getReturnMessage());
                return false;
            }
        } else {
            if (StringUtil.isEmpty(bodyMap.get(CreditApplyHServiceConstants.relacustname))
                    || !ValidateUtil.checkChinese(bodyMap.get(CreditApplyHServiceConstants.relacustname))) {// 亲属姓名
                logger.error("亲属姓名为空或有误:[]",bodyMap.get(CreditApplyHServiceConstants.relacustname));
                bodyMap.put("respcode", HServiceReturnCode.RELACUSTNAME_ERROR.getReturnCode());
                bodyMap.put("respmsg", HServiceReturnCode.RELACUSTNAME_ERROR.getReturnMessage());
                resp.setRespCode(HServiceReturnCode.RELACUSTNAME_ERROR.getReturnCode());
                resp.setRespMessage(HServiceReturnCode.RELACUSTNAME_ERROR
                        .getReturnMessage());
                return false;
            }
            
            if (StringUtil.isEmpty(bodyMap.get(CreditApplyHServiceConstants.relakind))
                    || "1|2|3".indexOf(bodyMap.get(CreditApplyHServiceConstants.relakind)) < 0) {// 亲属类型
                logger.error("亲属类型为空或有误:[]",bodyMap.get(CreditApplyHServiceConstants.relakind));
                bodyMap.put("respcode", HServiceReturnCode.RELAKIND_ERROR.getReturnCode());
                bodyMap.put("respmsg", HServiceReturnCode.RELAKIND_ERROR.getReturnMessage());
                resp.setRespCode(HServiceReturnCode.RELAKIND_ERROR.getReturnCode());
                resp.setRespMessage(HServiceReturnCode.RELAKIND_ERROR
                        .getReturnMessage());
                return false;
            }
            
            if (StringUtil.isEmpty(bodyMap.get(CreditApplyHServiceConstants.relamobilephone))
                    || !ValidateUtil.checkMobile(bodyMap.get(CreditApplyHServiceConstants.relamobilephone))) {// 亲属手机
                logger.error("亲属手机为空或有误:[]",bodyMap.get(CreditApplyHServiceConstants.relamobilephone));
                bodyMap.put("respcode", HServiceReturnCode.RELAMOBILEPHONE_ERROR.getReturnCode());
                bodyMap.put("respmsg", HServiceReturnCode.RELAMOBILEPHONE_ERROR.getReturnMessage());
                resp.setRespCode(HServiceReturnCode.RELAMOBILEPHONE_ERROR.getReturnCode());
                resp.setRespMessage(HServiceReturnCode.RELAMOBILEPHONE_ERROR
                        .getReturnMessage());
                return false;
            }
            
            if (StringUtil.isEmpty(bodyMap.get(CreditApplyHServiceConstants.relatel))
                    || !ValidateUtil.checkTelephone(bodyMap.get(CreditApplyHServiceConstants.relatel))) {// 亲属固话
                logger.error("亲属固话为空或有误:[]",bodyMap.get(CreditApplyHServiceConstants.relatel));
                bodyMap.put("respcode", HServiceReturnCode.TEL_ERROR.getReturnCode());
                bodyMap.put("respmsg", "亲属固定电话为空或有误");
                resp.setRespCode(HServiceReturnCode.TEL_ERROR.getReturnCode());
                resp.setRespMessage(HServiceReturnCode.TEL_ERROR
                        .getReturnMessage());
                return false;
            }
        }
        
        // 受教育程度
   /*     String educsign = (String) bodyMap
                .get(CreditApplyHServiceConstants.edusign);
        if (StringUtil.isEmpty(educsign)
                || "10|20|30|40|50|60".indexOf(educsign) < 0) {
            logger.error("受教育程度为空或有误:[]", educsign);
            bodyMap.put("respcode", HServiceReturnCode.EDUSIGN_ERROR.getReturnCode());
            bodyMap.put("respmsg", HServiceReturnCode.EDUSIGN_ERROR.getReturnMessage());
            resp.setRespCode(HServiceReturnCode.EDUSIGN_ERROR.getReturnCode());
            resp.setRespMessage(HServiceReturnCode.EDUSIGN_ERROR
                    .getReturnMessage());
            return false;
        }*/
        logger.info("educsign validate success !");
        // 子女人数
    /*    String childnum = (String) bodyMap
                .get(CreditApplyHServiceConstants.childnum);
        if (StringUtil.isEmpty(childnum)
                || !ValidateUtil.checkInteger(childnum)) {
            logger.error("子女人数为空或有误:[]", childnum);
            bodyMap.put("respcode", HServiceReturnCode.CHILDNUM_ERROR.getReturnCode());
            bodyMap.put("respmsg", HServiceReturnCode.CHILDNUM_ERROR.getReturnMessage());
            resp.setRespCode(HServiceReturnCode.CHILDNUM_ERROR.getReturnCode());
            resp.setRespMessage(HServiceReturnCode.CHILDNUM_ERROR
                    .getReturnMessage());
            return false;
        }*/
        logger.info("childnum validate success !");

        // 拥有经营地房产数量
       /* String localhousenum = (String) bodyMap
                .get(CreditApplyHServiceConstants.localhousenum);
        if (StringUtil.isEmpty(localhousenum)
                || !ValidateUtil.checkInteger(localhousenum)) {
            logger.error("拥有经营地房产数为空或有误:[]", localhousenum);
            bodyMap.put("respcode", HServiceReturnCode.LOCALHOUSENUM_ERROR.getReturnCode());
            bodyMap.put("respmsg", HServiceReturnCode.LOCALHOUSENUM_ERROR.getReturnMessage());
            resp.setRespCode(HServiceReturnCode.LOCALHOUSENUM_ERROR
                    .getReturnCode());
            resp.setRespMessage(HServiceReturnCode.LOCALHOUSENUM_ERROR
                    .getReturnMessage());
            return false;
        }*/
        logger.info("localhousenum validate success !");

        // 拥有非经营地房产数量
       /* String otherhousenum = (String) bodyMap
                .get(CreditApplyHServiceConstants.otherhousenum);
        if (StringUtil.isEmpty(otherhousenum)
                || !ValidateUtil.checkInteger(otherhousenum)) {
            logger.error("拥有非经营地房产数量为空:[]", otherhousenum);
            bodyMap.put("respcode", HServiceReturnCode.OTHERHOUSENUM_ERROR.getReturnCode());
            bodyMap.put("respmsg", HServiceReturnCode.OTHERHOUSENUM_ERROR.getReturnMessage());
            resp.setRespCode(HServiceReturnCode.OTHERHOUSENUM_ERROR
                    .getReturnCode());
            resp.setRespMessage(HServiceReturnCode.OTHERHOUSENUM_ERROR
                    .getReturnMessage());
            return false;
        }*/
        logger.info("otherhousenum validate success !");

        // 手机
        String mobilephone = (String) bodyMap
                .get(CreditApplyHServiceConstants.mobilephone);
        if (StringUtil.isEmpty(mobilephone)
                || !ValidateUtil.checkMobile(mobilephone)) {
            logger.error("手机号为空或有误:[]", mobilephone);
            bodyMap.put("respcode", HServiceReturnCode.MOBILEPHONE_ERROR.getReturnCode());
            bodyMap.put("respmsg", HServiceReturnCode.MOBILEPHONE_ERROR.getReturnMessage());
            resp.setRespCode(HServiceReturnCode.MOBILEPHONE_ERROR
                    .getReturnCode());
            resp.setRespMessage(HServiceReturnCode.MOBILEPHONE_ERROR
                    .getReturnMessage());
            return false;
        }
        logger.info("mobilephone validate success !");

        // 办公电话
        String tel = (String) bodyMap.get(CreditApplyHServiceConstants.tel);
        if (StringUtil.isEmpty(tel) || !ValidateUtil.checkTelephone(tel)) {
            logger.error("办公电话为空或有误:[]", tel);
            bodyMap.put("respcode", HServiceReturnCode.TEL_ERROR.getReturnCode());
            bodyMap.put("respmsg", HServiceReturnCode.TEL_ERROR.getReturnMessage());
            resp.setRespCode(HServiceReturnCode.TEL_ERROR.getReturnCode());
            resp.setRespMessage(HServiceReturnCode.TEL_ERROR.getReturnMessage());
            return false;
        }
        logger.info("tel validate success !");
        // 居住地-行政区划
        String residentRegion = (String) bodyMap
                .get(CreditApplyHServiceConstants.residentRegion);
        if (StringUtil.isEmpty(residentRegion)) {
            logger.error("居住地行政区划为空或有误:[]", residentRegion);
            bodyMap.put("respcode", HServiceReturnCode.RESIDENTREGION_ERROR.getReturnCode());
            bodyMap.put("respmsg", HServiceReturnCode.RESIDENTREGION_ERROR.getReturnMessage());
            resp.setRespCode(HServiceReturnCode.RESIDENTREGION_ERROR
                    .getReturnCode());
            resp.setRespMessage(HServiceReturnCode.RESIDENTREGION_ERROR
                    .getReturnMessage());
            return false;
        }
        logger.info("residentRegion validate success !");

        // 居住地址-具体
        String residentdetail = (String) bodyMap
                .get(CreditApplyHServiceConstants.residentdetail);
        if (StringUtil.isEmpty(residentdetail)) {
            logger.error("具体居住地址为空或有误:[]", residentdetail);
            bodyMap.put("respcode", HServiceReturnCode.RESIDENTDETAIL_ERROR.getReturnCode());
            bodyMap.put("respmsg", HServiceReturnCode.RESIDENTDETAIL_ERROR.getReturnMessage());
            resp.setRespCode(HServiceReturnCode.RESIDENTDETAIL_ERROR
                    .getReturnCode());
            resp.setRespMessage(HServiceReturnCode.RESIDENTDETAIL_ERROR
                    .getReturnMessage());
            return false;
        }
        logger.info("residentdetail validate success !");
        // 联系地址
        String contactaddrflag = (String) bodyMap
                .get(CreditApplyHServiceConstants.contactaddrflag);
        if (StringUtil.isEmpty(contactaddrflag)) {
            logger.error("联系地址为空或有误:[]", contactaddrflag);
            bodyMap.put("respcode", HServiceReturnCode.CONTACTADDRFALG_ERROR.getReturnCode());
            bodyMap.put("respmsg", HServiceReturnCode.CONTACTADDRFALG_ERROR.getReturnMessage());
            resp.setRespCode(HServiceReturnCode.CONTACTADDRFALG_ERROR
                    .getReturnCode());
            resp.setRespMessage(HServiceReturnCode.CONTACTADDRFALG_ERROR
                    .getReturnMessage());
            return false;
        }
        logger.info("contactaddrflag validate success !");

        // 影像资料文件包名
        String imagefilepackagename = (String) bodyMap
                .get(CreditApplyHServiceConstants.imagefilepackagename);
        if (StringUtil.isEmpty(imagefilepackagename)) {
            logger.error("影像资料文件包名为空或有误:[]", imagefilepackagename);
            bodyMap.put("respcode", HServiceReturnCode.IMAGEFILEPACKAGENAME_ERROR.getReturnCode());
            bodyMap.put("respmsg", HServiceReturnCode.IMAGEFILEPACKAGENAME_ERROR.getReturnMessage());
            resp.setRespCode(HServiceReturnCode.IMAGEFILEPACKAGENAME_ERROR
                    .getReturnCode());
            resp.setRespMessage(HServiceReturnCode.IMAGEFILEPACKAGENAME_ERROR
                    .getReturnMessage());
            return false;
        }
        logger.info("imagefilepackagename validate success !");
        // 申请额度
        String apptcapi = (String) bodyMap
                .get(CreditApplyHServiceConstants.apptcapi);
        if (StringUtil.isEmpty(apptcapi) || !ValidateUtil.checkDouble(apptcapi)) {
            logger.error("申请额度为空或有误:[]", apptcapi);
            bodyMap.put("respcode", HServiceReturnCode.APPTCAPI_ERROR.getReturnCode());
            bodyMap.put("respmsg", HServiceReturnCode.APPTCAPI_ERROR.getReturnMessage());
            resp.setRespCode(HServiceReturnCode.APPTCAPI_ERROR.getReturnCode());
            resp.setRespMessage(HServiceReturnCode.APPTCAPI_ERROR
                    .getReturnMessage());
            return false;
        }
        logger.info("apptcapi validate success !");
        // 申请期限
       /* String appterm = (String) bodyMap
                .get(CreditApplyHServiceConstants.appterm);
        if (StringUtil.isEmpty(appterm)) {
            logger.error("申请期限为空或有误:[]", appterm);
            bodyMap.put("respcode", HServiceReturnCode.APPTERM_ERROR.getReturnCode());
            bodyMap.put("respmsg", HServiceReturnCode.APPTERM_ERROR.getReturnMessage());
            resp.setRespCode(HServiceReturnCode.APPTERM_ERROR.getReturnCode());
            resp.setRespMessage(HServiceReturnCode.APPTERM_ERROR
                    .getReturnMessage());
            return false;
        }*/
        // 还款方式1
        String retukind1 = (String) bodyMap
                .get(CreditApplyHServiceConstants.retukind);
        // 还款方式2
        String retukind2 = (String) bodyMap
                .get(CreditApplyHServiceConstants.retukind2);
        if (StringUtil.isEmpty(retukind1) || StringUtil.isEmpty(retukind2)) {
            bodyMap.put("respcode", HServiceReturnCode.RETURNKIND_ERROR.getReturnCode());
            bodyMap.put("respmsg", HServiceReturnCode.RETURNKIND_ERROR.getReturnMessage());
            resp.setRespCode(HServiceReturnCode.RETURNKIND_ERROR
                    .getReturnCode());
            resp.setRespMessage(HServiceReturnCode.RETURNKIND_ERROR
                    .getReturnMessage());
            return false;
        } else if ("01|90".indexOf(retukind1) < 0 || "01|02".indexOf(retukind2) < 0) {
            bodyMap.put("respcode", HServiceReturnCode.RETURNKIND_ERROR.getReturnCode());
            bodyMap.put("respmsg", HServiceReturnCode.RETURNKIND_ERROR.getReturnMessage());
            resp.setRespCode(HServiceReturnCode.RETURNKIND_ERROR
                    .getReturnCode());
            resp.setRespMessage(HServiceReturnCode.RETURNKIND_ERROR
                    .getReturnMessage());
            return false;
        }
        logger.info("retukind1 validate success !");

        // 银行账号/卡号
        String bankaccno = (String) bodyMap
                .get(CreditApplyHServiceConstants.bankaccno);
        if (StringUtil.isEmpty(bankaccno)
                || !ValidateUtil.checkInteger(bankaccno)) {
            bodyMap.put("respcode", HServiceReturnCode.BANKACCNO_ERROR.getReturnCode());
            bodyMap.put("respmsg", HServiceReturnCode.BANKACCNO_ERROR.getReturnMessage());
            resp.setRespCode(HServiceReturnCode.BANKACCNO_ERROR.getReturnCode());
            resp.setRespMessage(HServiceReturnCode.BANKACCNO_ERROR
                    .getReturnMessage());
            return false;
        }
        logger.info("bankaccno validate success !");
        // 账户开户行
        String bankName = (String) bodyMap
                .get("bankName");
        logger.debug("不等贷bankName=" + bankName);
        if (StringUtil.isEmpty(bankName)
                || !ValidateUtil.checkInteger(bankName)
                || bankName.length() != 4) {
            bodyMap.put("respcode", HServiceReturnCode.BANKNAME_ERROR.getReturnCode());
            bodyMap.put("respmsg", HServiceReturnCode.BANKNAME_ERROR.getReturnMessage());
            resp.setRespCode(HServiceReturnCode.BANKNAME_ERROR.getReturnCode());
            resp.setRespMessage(HServiceReturnCode.BANKBRANNAME_ERROR
                    .getReturnMessage());
            return false;
        }
        logger.info("bankName validate success !");

        // 账户分行
        String bankBrandName = (String) bodyMap
                .get(CreditApplyHServiceConstants.bankBrandName);
        if (StringUtil.isEmpty(bankaccno)
                || !ValidateUtil.checkChinese(bankBrandName)) {
            bodyMap.put("respcode", HServiceReturnCode.BANKBRANNAME_ERROR.getReturnCode());
            bodyMap.put("respmsg", HServiceReturnCode.BANKBRANNAME_ERROR.getReturnMessage());
            resp.setRespCode(HServiceReturnCode.BANKBRANNAME_ERROR
                    .getReturnCode());
            resp.setRespMessage(HServiceReturnCode.BANKBRANNAME_ERROR
                    .getReturnMessage());
            return false;
        }
        logger.info("bankBrandName validate success !");

        // 账户支行
        String bankSubName = (String) bodyMap
                .get(CreditApplyHServiceConstants.bankSubName);
        if (StringUtil.isEmpty(bankSubName)
                || !ValidateUtil.checkChinese(bankSubName)) {
            bodyMap.put("respcode", HServiceReturnCode.BANKSUBNAME_ERROR.getReturnCode());
            bodyMap.put("respmsg", HServiceReturnCode.BANKSUBNAME_ERROR.getReturnMessage());
            resp.setRespCode(HServiceReturnCode.BANKSUBNAME_ERROR
                    .getReturnCode());
            resp.setRespMessage(HServiceReturnCode.BANKSUBNAME_ERROR
                    .getReturnMessage());
            return false;
        }
        logger.info("bankSubName validate success !");

        // 机构号/推荐机构
//        String bankid = (String) bodyMap.get(CreditApplyHServiceConstants.bankid);
//        if (StringUtil.isEmpty(bankid)) {
//            bodyMap.put("respcode", HServiceReturnCode.BANKID_ERROR.getReturnCode());
//            bodyMap.put("respmsg", HServiceReturnCode.BANKID_ERROR.getReturnMessage());
//            resp.setRespCode(HServiceReturnCode.BANKID_ERROR.getReturnCode());
//            resp.setRespMessage(HServiceReturnCode.BANKID_ERROR
//                    .getReturnMessage());
//            return false;
//        }

        // 营销经理/推荐人
//        String operid = (String) bodyMap.get(CreditApplyHServiceConstants.operid);
//        if (StringUtil.isEmpty(operid)) {
//            bodyMap.put("respcode", HServiceReturnCode.OTHER_ERROR.getReturnCode());
//            bodyMap.put("respmsg", HServiceReturnCode.OTHER_ERROR.getReturnMessage());
//            resp.setRespCode(HServiceReturnCode.OPERID_ERROR.getReturnCode());
//            resp.setRespCode(HServiceReturnCode.OPERID_ERROR.getReturnMessage());
//            return false;
//        }
        
        // 发生方式
        String accepttpye = bodyMap.get(CreditApplyHServiceConstants.accepttpye);
        if (StringUtil.isEmpty(accepttpye) || "01|02".indexOf(accepttpye) < 0) {
            bodyMap.put("respcode", HServiceReturnCode.OTHER_ERROR.getReturnCode());
            bodyMap.put("respmsg", HServiceReturnCode.OTHER_ERROR.getReturnMessage());
            resp.setRespCode(HServiceReturnCode.OTHER_ERROR.getReturnCode());
            resp.setRespCode(HServiceReturnCode.OTHER_ERROR.getReturnMessage());
            return false;
        }
        logger.info("accepttpye validate success !");
        // 申请来源
        String appsource = bodyMap.get(CreditApplyHServiceConstants.appsource);
        if (StringUtil.isEmpty(appsource) || "1".indexOf(appsource) < 0) {
            bodyMap.put("respcode", HServiceReturnCode.OTHER_ERROR.getReturnCode());
            bodyMap.put("respmsg", HServiceReturnCode.OTHER_ERROR.getReturnMessage());
            resp.setRespCode(HServiceReturnCode.OTHER_ERROR.getReturnCode());
            resp.setRespCode(HServiceReturnCode.OTHER_ERROR.getReturnMessage());
            return false;
        }
        logger.info("appsource validate success !");
        
        logger.info("validate success !");
	    return true;
	}
}