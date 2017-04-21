package com.hrbb.loan.spi.WX;

import java.util.Date;
import java.util.List;
import java.util.Map;
import java.util.Vector;
import java.util.concurrent.Executor;

import org.apache.commons.lang3.StringUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Service;

import com.google.common.collect.Maps;
import com.hrbb.loan.constants.CreditApplyConstants;
import com.hrbb.loan.pos.biz.backstage.inter.ILoanPosCreditApplyBackStageBiz;
import com.hrbb.loan.pos.dao.TCfgFundingPoolDao;
import com.hrbb.loan.pos.dao.entity.TCfgFundingPool;
import com.hrbb.loan.pos.util.DateUtil;
import com.hrbb.loan.pos.util.ExecutorUtil;
import com.hrbb.loan.pos.util.IdUtil;
import com.hrbb.loan.pos.util.StringUtil;
import com.hrbb.loan.pos.util.ValidateUtil;
import com.hrbb.loan.spi.POSHService;
import com.hrbb.loan.spiconstants.CreditApplyHServiceConstants;
import com.hrbb.loan.spiconstants.HServiceReturnCode;
import com.hrbb.loan.thread.RNCreditApplyThread;
import com.hrbb.sh.framework.HRequest;
import com.hrbb.sh.framework.HResponse;
import com.hrbb.sh.framework.HServiceException;

@Service("wxCreditApplyHService")
public class WXCreditApplyHServiceImpl extends WXHService{
	
	@Autowired
	private ILoanPosCreditApplyBackStageBiz loanPosCreditApplyBackStageBiz;
	
	@Autowired
	@Qualifier("rnCreditApplyThread")
	private RNCreditApplyThread runnable;
	
	@Autowired
	private TCfgFundingPoolDao tCfgFundingPoolDao;
	
	private Executor executor = ExecutorUtil.getScheduledThreadExecutor(5);
	
	private Vector<String> vector = new Vector<String>();

	@Override
	public HResponse serve(HRequest request) throws HServiceException {
		logger.debug("executing "+this.getClass().getName()+"...");
		String posCustId = IdUtil.getId("MH");
		try{
			
		// 申请信息map
		Map<String, Object> creMap = Maps.newHashMap();
		// 客户信息map
		Map<String, Object> custMap = Maps.newHashMap();
		HResponse resp = new HResponse();
		Map<String, Object> props = request.getProperties();
//		String channel = (String) props.get("channel");
		String loanId = IdUtil.getId("LO");
//		if (channel == null) {
//			// 默认银商
//			channel = "58";
//		}
		logger.debug("渠道为:" + this.getChannel());
		// 收单机构(同城没有收单机构)
		String posorg = (String) props.get(CreditApplyHServiceConstants.posorg);
		/*
		 * if (StringUtil.isEmpty(posorg)) { logger.error("收单机构为空或不合法:[]",
		 * posorg);
		 * resp.setRespCode(HServiceReturnCode.POS_ORG_ERROR.getReturnCode());
		 * resp.setRespMessage(HServiceReturnCode.POS_ORG_ERROR
		 * .getReturnMessage()); resp.setRespTime(new Date()); return
		 * getBlankHResponse(resp); }
		 */
		// 营业执照号
		/*
		 * String regicode = (String) props
		 * .get(CreditApplyHServiceConstants.regicode); if
		 * (StringUtil.isEmpty(regicode)) { logger.error("营业执照号为空或不合法:[]",
		 * regicode);
		 * resp.setRespCode(HServiceReturnCode.REGICODE_ERROR.getReturnCode());
		 * resp.setRespMessage(HServiceReturnCode.REGICODE_ERROR
		 * .getReturnMessage()); resp.setRespTime(new Date()); return
		 * getBlankHResponse(resp); }
		 */
		/*String regicode = (String) props
				.get(CreditApplyHServiceConstants.regicode);
		logger.info("营业执照号为" + regicode);
		// 主营业务
		String dealscope = (String) props
				.get(CreditApplyHServiceConstants.dealscope);
		logger.info("主营业务为" + dealscope);
		if (StringUtil.isEmpty(dealscope)
				|| !ValidateUtil.checkChinese(dealscope)) {
			logger.error("主营业务为空或不合法:[]", dealscope);
			resp.setRespCode(HServiceReturnCode.DEALSCOPE_ERROR.getReturnCode());
			resp.setRespMessage(HServiceReturnCode.DEALSCOPE_ERROR
					.getReturnMessage());
			resp.setRespTime(new Date());
			return getBlankHResponse(resp);
		}
		// 实际经营地址-行政区划
		String operaddrRegion = (String) props
				.get(CreditApplyHServiceConstants.operaddrRegion);
		if (StringUtil.isEmpty(operaddrRegion)) {
			logger.error("行政区划为空或有误:[]", operaddrRegion);
			resp.setRespCode(HServiceReturnCode.OPERADDRREGION_ERROR
					.getReturnCode());
			resp.setRespMessage(HServiceReturnCode.OPERADDRREGION_ERROR
					.getReturnMessage());
			resp.setRespTime(new Date());
			return getBlankHResponse(resp);
		}
		// 实际经营地址-具体
		String operaddrdetail = (String) props
				.get(CreditApplyHServiceConstants.operaddrdetail);
		if (StringUtil.isEmpty(operaddrdetail)) {
			logger.error("具体经营地址为空或有误:[]", operaddrdetail);
			resp.setRespCode(HServiceReturnCode.OPERADDRDETAIL_ERROR
					.getReturnCode());
			resp.setRespMessage(HServiceReturnCode.OPERADDRDETAIL_ERROR
					.getReturnMessage());
			resp.setRespTime(new Date());
			return getBlankHResponse(resp);
		}

		// 所属行业（同城没有）
		String industrytypeid = (String) props
				.get(CreditApplyHServiceConstants.industrytypeid);*/
		// 客户姓名
		String custname = (String) props
				.get(CreditApplyHServiceConstants.custname);
		if (StringUtil.isEmpty(custname)
				|| !ValidateUtil.checkChinese(custname)) {
			logger.error("客户姓名为空或有误:[]", custname);
			resp.setRespCode(HServiceReturnCode.CUSTNAME_ERROR.getReturnCode());
			resp.setRespMessage(HServiceReturnCode.CUSTNAME_ERROR
					.getReturnMessage());
			resp.setRespTime(new Date());
			return getBlankHResponse(resp);
		}

		// 证件类型
		String paperkind = (String) props
				.get(CreditApplyHServiceConstants.paperkind);
		if (StringUtil.isEmpty(paperkind) || !paperkind.equals("01")) {
			logger.error("证件类型为空或有误:[]", paperkind);
			resp.setRespCode(HServiceReturnCode.PAPERKIND_ERROR.getReturnCode());
			resp.setRespMessage(HServiceReturnCode.PAPERKIND_ERROR
					.getReturnMessage());
			resp.setRespTime(new Date());
			return getBlankHResponse(resp);
		}
		// 证件号码
		String paperid = (String) props
				.get(CreditApplyHServiceConstants.paperid);
		if (StringUtil.isEmpty(paperid) || !ValidateUtil.checkIdNumber(paperid)) {
			logger.error("证件号码为空或有误:[]", paperid);
			resp.setRespCode(HServiceReturnCode.PAPERID_ERROR.getReturnCode());
			resp.setRespMessage(HServiceReturnCode.PAPERID_ERROR
					.getReturnMessage());
			resp.setRespTime(new Date());
			return getBlankHResponse(resp);
		}
		// 性别（非必填）
		String sexsign = (String) props
				.get(CreditApplyHServiceConstants.sexsign);
		/*
		 * if (StringUtil.isEmpty(sexsign)) { logger.error("性别为空或有误:[]",
		 * sexsign);
		 * resp.setRespCode(HServiceReturnCode.SEXSIGN_ERROR.getReturnCode());
		 * resp.setRespMessage(HServiceReturnCode.SEXSIGN_ERROR
		 * .getReturnMessage()); resp.setRespTime(new Date()); return
		 * getBlankHResponse(resp); }
		 */

		/*// 从业年限
		String busiyear = (String) props
				.get(CreditApplyHServiceConstants.busiyear);
		if (StringUtil.isEmpty(busiyear)
				|| !ValidateUtil.checkInteger(busiyear)) {
			logger.error("从业年限为空或有误:[]", busiyear);
			resp.setRespCode(HServiceReturnCode.BUSIYEAR_ERROR.getReturnCode());
			resp.setRespMessage(HServiceReturnCode.BUSIYEAR_ERROR
					.getReturnMessage());
			resp.setRespTime(new Date());
			return getBlankHResponse(resp);
		}*/
		// 婚姻状况
		String marrsign = (String) props
				.get(CreditApplyHServiceConstants.marrsign);
		if (StringUtil.isEmpty(marrsign)) {
			logger.error("婚姻状况为空或有误:[]", marrsign);
			resp.setRespCode(HServiceReturnCode.MARRSIGN_ERROR.getReturnCode());
			resp.setRespMessage(HServiceReturnCode.MARRSIGN_ERROR
					.getReturnMessage());
			resp.setRespTime(new Date());
			return getBlankHResponse(resp);
		}
		// 受教育程度
		String educsign = (String) props
				.get(CreditApplyHServiceConstants.edusign);
		
		 if (StringUtil.isEmpty(educsign)) { logger.error("受教育程度为空或有误:{}",
		 educsign);
		 resp.setRespCode(HServiceReturnCode.EDUSIGN_ERROR.getReturnCode());
		 resp.setRespMessage(HServiceReturnCode.EDUSIGN_ERROR
		 .getReturnMessage()); resp.setRespTime(new Date()); return
		 getBlankHResponse(resp); }
		 
		/*// 子女人数
		String childnum = (String) props
				.get(CreditApplyHServiceConstants.childnum);
		
		 if (StringUtil.isEmpty(childnum) ||
		  !ValidateUtil.checkInteger(childnum)) { logger.error("子女人数为空或有误:{}",
		  childnum);
		  resp.setRespCode(HServiceReturnCode.CHILDNUM_ERROR.getReturnCode());
		  resp.setRespMessage(HServiceReturnCode.CHILDNUM_ERROR
		  .getReturnMessage()); resp.setRespTime(new Date()); return
		  getBlankHResponse(resp); }
		 

		// 拥有经营地房产数量
		String localhousenum = (String) props
				.get(CreditApplyHServiceConstants.localhousenum);
		
		 if (StringUtil.isEmpty(localhousenum) ||
		  !ValidateUtil.checkInteger(localhousenum)) {
		  logger.error("拥有经营地房产数为空或有误:{}", localhousenum);
		  resp.setRespCode(HServiceReturnCode.LOCALHOUSENUM_ERROR
		  .getReturnCode());
		  resp.setRespMessage(HServiceReturnCode.LOCALHOUSENUM_ERROR
		  .getReturnMessage()); resp.setRespTime(new Date()); return
		  getBlankHResponse(resp); }
		 

		// 拥有非经营地房产数量
		String otherhousenum = (String) props
				.get(CreditApplyHServiceConstants.otherhousenum);
		
		  if (StringUtil.isEmpty(otherhousenum) ||
		  !ValidateUtil.checkInteger(otherhousenum)) {
		  logger.error("拥有非经营地房产数量为空:{}", otherhousenum);
		  resp.setRespCode(HServiceReturnCode.OTHERHOUSENUM_ERROR
		  .getReturnCode());
		  resp.setRespMessage(HServiceReturnCode.OTHERHOUSENUM_ERROR
		  .getReturnMessage()); resp.setRespTime(new Date()); return
		  getBlankHResponse(resp); }
		 

		// 手机
		String mobilephone = (String) props
				.get(CreditApplyHServiceConstants.mobilephone);
		if (StringUtil.isEmpty(mobilephone)
				|| !ValidateUtil.checkMobile(mobilephone)) {
			logger.error("手机号为空或有误:[]", mobilephone);
			resp.setRespCode(HServiceReturnCode.MOBILEPHONE_ERROR
					.getReturnCode());
			resp.setRespMessage(HServiceReturnCode.MOBILEPHONE_ERROR
					.getReturnMessage());
			resp.setRespTime(new Date());
			return getBlankHResponse(resp);
		}

		// 办公电话
		String tel = (String) props.get(CreditApplyHServiceConstants.tel);
		if (StringUtil.isEmpty(tel) || !ValidateUtil.checkTelephone(tel)) {
			logger.error("办公电话为空或有误:[]", tel);
			resp.setRespCode(HServiceReturnCode.TEL_ERROR.getReturnCode());
			resp.setRespMessage(HServiceReturnCode.TEL_ERROR.getReturnMessage());
			resp.setRespTime(new Date());
			return getBlankHResponse(resp);
		}*/
		 //手机号
		 String mobilephone = (String) props
					.get(CreditApplyHServiceConstants.mobilephone);
		// 居住地-行政区划
		String residentRegion = (String) props
				.get(CreditApplyHServiceConstants.residentRegion);
		if (StringUtil.isEmpty(residentRegion)) {
			logger.error("居住地行政区划为空或有误:[]", residentRegion);
			resp.setRespCode(HServiceReturnCode.RESIDENTREGION_ERROR
					.getReturnCode());
			resp.setRespMessage(HServiceReturnCode.RESIDENTREGION_ERROR
					.getReturnMessage());
			resp.setRespTime(new Date());
			return getBlankHResponse(resp);
		}

		// 居住地址-具体
		String residentdetail = (String) props
				.get(CreditApplyHServiceConstants.residentdetail);
		if (StringUtil.isEmpty(residentdetail)) {
			logger.error("具体居住地址为空或有误:[]", residentdetail);
			resp.setRespCode(HServiceReturnCode.RESIDENTDETAIL_ERROR
					.getReturnCode());
			resp.setRespMessage(HServiceReturnCode.RESIDENTDETAIL_ERROR
					.getReturnMessage());
			resp.setRespTime(new Date());
			return getBlankHResponse(resp);
		}

		/*// 联系地址
		String contactaddrflag = (String) props
				.get(CreditApplyHServiceConstants.contactaddrflag);
		if (StringUtil.isEmpty(contactaddrflag)) {
			logger.error("联系地址为空或有误:[]", contactaddrflag);
			resp.setRespCode(HServiceReturnCode.CONTACTADDRFALG_ERROR
					.getReturnCode());
			resp.setRespMessage(HServiceReturnCode.CONTACTADDRFALG_ERROR
					.getReturnMessage());
			resp.setRespTime(new Date());
			return getBlankHResponse(resp);
		}

		// 微信号（非必填）
		String weixinno = (String) props
				.get(CreditApplyHServiceConstants.weixinno);

		// QQ号（非必填）
		String qqno = (String) props.get(CreditApplyHServiceConstants.qqno);

		// 电子邮箱（非必填）
		String email = (String) props.get(CreditApplyHServiceConstants.email);*/
		// 如果为已婚
		/*if (marrsign.equals("20")) {
			// 配偶姓名
			String familycustname = (String) props
					.get(CreditApplyHServiceConstants.familycustname);
			
			  if (StringUtil.isEmpty(familycustname) ||
			  !ValidateUtil.checkChinese(familycustname)) {
			  logger.error("配偶姓名为空或有误:[]",familycustname);
			  resp.setRespCode(HServiceReturnCode.FAMILYCUSTNAME_ERROR
			  .getReturnCode());
			  resp.setRespMessage(HServiceReturnCode.FAMILYCUSTNAME_ERROR
			  .getReturnMessage()); resp.setRespTime(new Date()); return
			  getBlankHResponse(resp); }
			 

			// 配偶证件类型
			String matepaperkind = (String) props
					.get(CreditApplyHServiceConstants.matepaperkind);
			
			  if (StringUtil.isEmpty(matepaperkind)) {
			  logger.error("配偶证件类型为空或有误:[]", matepaperkind);
			  resp.setRespCode(HServiceReturnCode.MATEPAPERKIND_ERROR
			  .getReturnCode());
			  resp.setRespMessage(HServiceReturnCode.MATEPAPERKIND_ERROR
			  .getReturnMessage()); resp.setRespTime(new Date()); return
			  getBlankHResponse(resp); }
			 

			// 配偶证件号码
			String matepaperid = (String) props
					.get(CreditApplyHServiceConstants.matepaperid);
			
			  if (StringUtil.isEmpty(matepaperid) ||
			  !ValidateUtil.checkIdNumber(matepaperid)) {
			  logger.error("配偶证件号码为空或有误:[]", matepaperid);
			  resp.setRespCode(HServiceReturnCode.MATEPAPERID_ERROR
			  .getReturnCode());
			  resp.setRespMessage(HServiceReturnCode.MATEPAPERID_ERROR
			  .getReturnMessage()); resp.setRespTime(new Date()); return
			  getBlankHResponse(resp); }
			 
			// 配偶手机
			String matemobilephone = (String) props
					.get(CreditApplyHServiceConstants.matemobilephone);
			
			  if (StringUtil.isEmpty(matemobilephone) ||
			  !ValidateUtil.checkMobile(matemobilephone)) {
			  logger.error("配偶手机号码为空或有误:[]");
			  resp.setRespCode(HServiceReturnCode.MATEMOBILEPHONE_ERROR
			  .getReturnCode());
			  resp.setRespMessage(HServiceReturnCode.MATEMOBILEPHONE_ERROR
			  .getReturnMessage()); resp.setRespTime(new Date()); return
			  getBlankHResponse(resp); }
			 
			// 配偶姓名
			custMap.put(CreditApplyConstants.familyCustName, familycustname);
			// 配偶证件类型
			custMap.put(CreditApplyConstants.matePaperKind, matepaperkind);
			// 配偶证件号码
			custMap.put(CreditApplyConstants.matePaperId, matepaperid);
			// 配偶手机
			custMap.put(CreditApplyConstants.mateMobilePhone, matemobilephone);
			// 配偶生日
			custMap.put(CreditApplyConstants.mateBirtDate,
					DateUtil.getDatePattern1(matepaperid.substring(6, 14)));
			// 配偶性别
			if (matepaperid != null) {
				if (Integer.valueOf(String.valueOf(matepaperid.charAt(16))) % 2 != 0) {
					// 奇数为男性
					custMap.put(CreditApplyConstants.mateSexSign, "1");
				} else {
					// 偶数为女性
					custMap.put(CreditApplyConstants.mateSexSign, "2");
				}
			}
		}*/


		// 影像资料文件包名
		String imagefilepackagename = (String) props
				.get(CreditApplyHServiceConstants.imagefilepackagename);
		if (StringUtil.isEmpty(imagefilepackagename)) {
			logger.error("影像资料文件包名为空或有误:[]", imagefilepackagename);
			resp.setRespCode(HServiceReturnCode.IMAGEFILEPACKAGENAME_ERROR
					.getReturnCode());
			resp.setRespMessage(HServiceReturnCode.IMAGEFILEPACKAGENAME_ERROR
					.getReturnMessage());
			resp.setRespTime(new Date());
			return getBlankHResponse(resp);
		}
		// 申请额度
		String apptcapi = (String) props
				.get(CreditApplyHServiceConstants.apptcapi);
		
		if (StringUtil.isEmpty(apptcapi) || !ValidateUtil.checkDouble(apptcapi)) {
			logger.error("申请额度为空或有误:[]", apptcapi);
			resp.setRespCode(HServiceReturnCode.APPTCAPI_ERROR.getReturnCode());
			resp.setRespMessage(HServiceReturnCode.APPTCAPI_ERROR
					.getReturnMessage());
			resp.setRespTime(new Date());
			return getBlankHResponse(resp);
		}
		// 申请期限
		String appterm = (String) props
				.get(CreditApplyHServiceConstants.appterm);
		if (StringUtil.isEmpty(appterm)) {
			logger.error("申请期限为空或有误:[]", appterm);
			resp.setRespCode(HServiceReturnCode.APPTERM_ERROR.getReturnCode());
			resp.setRespMessage(HServiceReturnCode.APPTERM_ERROR
					.getReturnMessage());
			resp.setRespTime(new Date());
			return getBlankHResponse(resp);
		}

		String retuKind = (String) props.get("retukind");
        logger.info("还款方式为"+retuKind);
		if (StringUtils.isEmpty(retuKind)) {
			logger.error("还款方式为空或有误:[]", retuKind);
			resp.setRespCode(HServiceReturnCode.RETURNKIND_ERROR
					.getReturnCode());
			resp.setRespMessage(HServiceReturnCode.RETURNKIND_ERROR
					.getReturnMessage());
			resp.setRespTime(new Date());
			return getBlankHResponse(resp);
		}

		// 还款方式1
		String retukind1 = retuKind;
		// 还款方式2		
		String repayMethod = (String) props.get("repaymethod");
		if (StringUtils.isEmpty(repayMethod)) {
			logger.error("还款方式2为空或有误:[]", repayMethod);
			resp.setRespCode(HServiceReturnCode.RETURNKIND_ERROR
					.getReturnCode());
			resp.setRespMessage(HServiceReturnCode.RETURNKIND_ERROR
					.getReturnMessage());
			resp.setRespTime(new Date());
			return getBlankHResponse(resp);
		}
		
//		logger.debug("bankMapperMap:" + bankMapperMap);	
//		if ("UM".equals(channel)) {
//			bankName = bankMapperMap.get(bankName);
//		}


		// 机构号/推荐机构
		String bankid = (String) props.get(CreditApplyHServiceConstants.bankid);
		if (StringUtil.isEmpty(bankid)) {
			resp.setRespCode(HServiceReturnCode.BANKID_ERROR.getReturnCode());
			resp.setRespMessage(HServiceReturnCode.BANKID_ERROR
					.getReturnMessage());
			resp.setRespTime(new Date());
			return getBlankHResponse(resp);
		}

		// 营销经理/推荐人
		String operid = (String) props.get(CreditApplyHServiceConstants.operid);
		if (StringUtil.isEmpty(operid)) {
			resp.setRespCode(HServiceReturnCode.OPERID_ERROR.getReturnCode());
			resp.setRespCode(HServiceReturnCode.OPERID_ERROR.getReturnMessage());
			resp.setRespTime(new Date());
			return getBlankHResponse(resp);
		}

		// 360流水号
		String stdshno = (String) props
				.get(CreditApplyHServiceConstants.stdshno);
		if (StringUtil.isEmpty(stdshno)) {
			resp.setRespCode(HServiceReturnCode.STDSHNO_ERROR.getReturnCode());
			resp.setRespMessage(HServiceReturnCode.STDSHNO_ERROR
					.getReturnMessage());
			resp.setRespTime(new Date());
			return getBlankHResponse(resp);
		}

		/*// 360商户号
		String stdmerno = (String) props
				.get(CreditApplyHServiceConstants.stdmerno);
		creMap.put("stdmerno", stdmerno);*/
		
		//为了58
		creMap.put(CreditApplyConstants.LOAN_ID, loanId);
		creMap.put("loanid", loanId);
		// 收单机构
		creMap.put(CreditApplyHServiceConstants.posorg, posorg);
		// 产品（同城写死pos贷）
		creMap.put(CreditApplyConstants.prodId, getProdId());
		creMap.put(CreditApplyConstants.prodName, getProdName());
		// 用户名
		creMap.put(CreditApplyConstants.CUST_NAME, custname);
		// 客户姓名
		custMap.put(CreditApplyConstants.CUST_NAME, custname);
		// 证件类型
		custMap.put(CreditApplyConstants.paperKind, paperkind);
		// 证件号码
		custMap.put(CreditApplyConstants.PAPER_ID, paperid);
		// 根据身份证号获取出生日期
		custMap.put(CreditApplyConstants.birtDate,
				DateUtil.getDatePattern1(paperid.substring(6, 14)));
		// 性别
		custMap.put(CreditApplyConstants.sexSign, sexsign);
	/*	// 从业年限
		custMap.put(CreditApplyConstants.busiYear, busiyear);*/
		// 婚姻状况
		custMap.put(CreditApplyConstants.marrSign, marrsign);
		// 受教育程度
		custMap.put(CreditApplyConstants.educSign, educsign);
/*		// 子女人数
		custMap.put(CreditApplyConstants.childNum, childnum);
		// 拥有经营地房产数量
		custMap.put(CreditApplyConstants.localHouseNum, localhousenum);
		// 拥有非经营地房产数量
		custMap.put(CreditApplyConstants.otherHouseNum, otherhousenum);*/
		// 手机
		custMap.put(CreditApplyConstants.mobilePhone, mobilephone);
		// 办公电话
		/*custMap.put(CreditApplyConstants.tel, tel);*/
		// 居住地-行政区划
		custMap.put(CreditApplyConstants.residentProv,
				residentRegion.substring(0, 2) + "0000");
		custMap.put(CreditApplyConstants.residentCity,
				residentRegion.substring(0, 4) + "00");
		custMap.put(CreditApplyConstants.residentDivision, residentRegion);
		// 居住地址-具体
		custMap.put(CreditApplyConstants.residentDetail, residentdetail);
		// 联系地址
		custMap.put(CreditApplyConstants.contactAddrFlag, POSHService.联系类型_住宅地址);
		// 微信号
/*		if (!StringUtil.isEmpty(weixinno)) {
			custMap.put(CreditApplyConstants.weixinNo, weixinno);
		}*/
		// QQ号
/*		if (!StringUtil.isEmpty(qqno)) {
			custMap.put(CreditApplyConstants.qqNo, qqno);
		}
		// 电子邮箱
		if (!StringUtil.isEmpty(email)) {
			custMap.put(CreditApplyConstants.email, email);
		}*/

		// 影像资料文件包名
		if (!StringUtil.isEmpty(imagefilepackagename)) {
			creMap.put(CreditApplyHServiceConstants.imagefilepackagename,
					imagefilepackagename);
		}
		// 进件方式
		creMap.put(CreditApplyConstants.inChannelKind, getInChannelKind());

		//
		// 申请额度
		creMap.put(CreditApplyConstants.applyAmt, apptcapi);
		// 申请期限
		creMap.put(CreditApplyConstants.applyTerm, appterm);

		// 还款方式1
		creMap.put("returnKind", retukind1);
		// 还款方式2
		creMap.put("repayMethod", repayMethod);
		// 发生方式
		creMap.put(CreditApplyConstants.occurType,
				CreditApplyConstants.occurTypeAdd);
		// 机构号/推荐机构
		creMap.put(CreditApplyConstants.recOrg, bankid);
		// 营销经理/推荐人
		creMap.put(CreditApplyConstants.recPerson, operid);
		creMap.put(CreditApplyConstants.beginDate, new Date());
		// 银商傻**
		creMap.put(CreditApplyConstants.APPLY_STATUS,
				CreditApplyConstants.STATUS_PENDING);
		creMap.put(CreditApplyConstants.loanType, getLoanType());
		// 银商流水号
		creMap.put(CreditApplyHServiceConstants.stdshno, stdshno);
		creMap.put(CreditApplyConstants.channel, this.getChannel());

		// 申请期限单位默认为月M
		creMap.put(CreditApplyConstants.termUnit, CreditApplyConstants.MONTH);
		creMap.put(CreditApplyConstants.operName, "系统自动处理");
		creMap.put(CreditApplyConstants.operId, "system");
		// 默认币种为人民币
		creMap.put(CreditApplyConstants.currSign, "CNY");
		//贷款模式 add at 20150814
		creMap.put(CreditApplyConstants.loanType, getLoanType());
		
		if(!executeExtensionAction(creMap, custMap, null, null, null)){
			resp.setRespCode(HServiceReturnCode.FUNDINGPOOL_EXIST_ERROR
					.getReturnCode());
			resp.setRespMessage(HServiceReturnCode.FUNDINGPOOL_EXIST_ERROR
					.getReturnMessage());
			resp.setRespTime(new Date());
			return getBlankHResponse(resp);
		}
		
		/*if(!addVectEle(getChannel() + "|" + stdshno, vector)){
			resp.setRespCode(HServiceReturnCode.REPEAT_APPLY_ERROR
					.getReturnCode());
			resp.setRespMessage(HServiceReturnCode.REPEAT_APPLY_ERROR
					.getReturnMessage());
			resp.setRespTime(new Date());
			return getBlankHResponse(resp);
		}*/
		Map<String, Object> resMap = loanPosCreditApplyBackStageBiz
				.creditApplyReg(creMap, custMap, null, null, null,
						null);
		/*removeEle(getChannel() + "|" + stdshno, vector);*/
		if (resMap.isEmpty()) {
			resp.setRespCode(HServiceReturnCode.OTHER_ERROR.getReturnCode());
			resp.setRespMessage(HServiceReturnCode.OTHER_ERROR
					.getReturnMessage());
			resp.setRespTime(new Date());
			return getBlankHResponse(resp);
		}
		
		if(!resMap.isEmpty() && resMap.get("hasPaperId") != null){
			resp.setRespCode(HServiceReturnCode.HAS_PAPER_ID.getReturnCode());
			resp.setRespMessage(HServiceReturnCode.HAS_PAPER_ID
					.getReturnMessage());
			resp.setRespTime(new Date());
			return getBlankHResponse(resp);
		}
		//起线程下载影像资料
		runnable.setReqMap(creMap);
/*		Map<String, String> aicCheckMap = Maps.newHashMap();
		aicCheckMap.put(CreditApplyConstants.POS_CUST_ID, posCustId);
		aicCheckMap.put(CreditApplyConstants.POS_CUST_NAME, poscustname);*/
		/*runnable.setAicCheckMap(aicCheckMap);*/
		executor.execute(runnable);
		resp.setProperties(resMap);
		resp.setRespCode(HServiceReturnCode.SUCCESS.getReturnCode());
		resp.setRespMessage(HServiceReturnCode.SUCCESS.getReturnMessage());
		resp.setRespTime(new Date());
		logger.debug("申请借款结束。。。。");
		return resp;
}catch(Exception e){
			logger.error("发生异常:", e);
			HResponse resp = new HResponse();
			resp.setRespCode(HServiceReturnCode.OTHER_ERROR.getReturnCode());
			resp.setRespMessage(HServiceReturnCode.OTHER_ERROR.getReturnMessage());
			resp.setRespTime(new Date());
			return resp;
		}
	}

	/**
	 * 返回渠道信息
	 * 
	 * @param response
	 * @return
	 */
	private HResponse getBlankHResponse(HResponse response) {
		Map<String, Object> respMap = Maps.newHashMap();
		respMap.put(CreditApplyHServiceConstants.loanid, "");
		respMap.put(CreditApplyHServiceConstants.custid, "");
		response.setProperties(respMap);
		return response;
	}
	
	private boolean executeExtensionAction(Map<String, Object> creMap,
			Map<String, Object> custMap, Map<String, Object> posCustMap,
			Map<String, Object> bankMap, Map<String, Object> relaMap) {

		// 资金池编号
		Map<String, Object> p = Maps.newHashMap();
		p.put(CreditApplyConstants.channel, getChannel());
		p.put(CreditApplyConstants.beginDate, DateUtil.getToday());
		List<TCfgFundingPool> poolInfos = tCfgFundingPoolDao.selectSelective(p);
		if (poolInfos.size() == 0) {
			return false;
		}
		creMap.put(CreditApplyConstants.poolNo, poolInfos.get(0).getPoolNo());
		return true;
	}


}