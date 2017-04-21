package com.hrbb.loan.spi.UM;

import java.util.Date;
import java.util.List;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.google.common.collect.Lists;
import com.google.common.collect.Maps;
import com.hrbb.loan.constants.CreditApplyConstants;
import com.hrbb.loan.factory.CreditApplyFactory;
import com.hrbb.loan.pos.biz.backstage.inter.ILoanPosCreditApplyBackStageBiz;
import com.hrbb.loan.pos.util.ListUtil;
import com.hrbb.loan.pos.util.StringUtil;
import com.hrbb.loan.pos.util.ValidateUtil;
import com.hrbb.loan.spiconstants.CreditApplyHServiceConstants;
import com.hrbb.loan.spiconstants.HServiceReturnCode;
import com.hrbb.sh.framework.HRequest;
import com.hrbb.sh.framework.HResponse;
import com.hrbb.sh.framework.HService;
import com.hrbb.sh.framework.HServiceException;

@Service("umQueryApplyInfo")
public class UMQueryApplyInfoHServiceImpl implements HService{
	
	@Autowired
	private ILoanPosCreditApplyBackStageBiz loanPosCreditApplyBackStageBiz;

	@Override
	public HResponse serve(HRequest request) throws HServiceException {
		Map<String, Object> props = request.getProperties();
		HResponse resp = new HResponse();
		//申请流水号
		String loanid = (String)props.get(CreditApplyHServiceConstants.loanid);
		//客户编号
		String custid = (String)props.get(CreditApplyHServiceConstants.custid);
		//客户姓名
		String custname = (String)props.get(CreditApplyHServiceConstants.custname);
		//证件类型
		String paperkind = (String)props.get(CreditApplyHServiceConstants.paperkind);
		//证件号码
		String paperid = (String)props.get(CreditApplyHServiceConstants.paperid);
		//查询开始日期
		String begindate = (String)props.get(CreditApplyHServiceConstants.begindate);
		//查询截止日期
		String enddate = (String)props.get(CreditApplyHServiceConstants.enddate);
		//申请流水号(银联商务)
		String stdshno = (String)props.get(CreditApplyHServiceConstants.stdshno);
		/*if(StringUtil.isEmpty(stdshno)){
			resp.setRespCode(HServiceReturnCode.STDSHNO_ERROR.getReturnCode());
			resp.setRespMessage(HServiceReturnCode.STDSHNO_ERROR.getReturnMessage());
			resp.setRespTime(new Date());
			return resp;
		}*/
		//商户ID
		String stdmerno = (String)props.get(CreditApplyHServiceConstants.stdmerno);
		if(StringUtil.isEmpty(stdmerno)){
			resp.setRespCode(HServiceReturnCode.STDMERNO_ERROR.getReturnCode());
			resp.setRespMessage(HServiceReturnCode.STDMERNO_ERROR.getReturnMessage());
			resp.setRespTime(new Date());
			return getBlankResponse(resp);
		}
		//起始记录号
		String startnum = (String)props.get(CreditApplyHServiceConstants.startnum);
		if(StringUtil.isEmpty(startnum) || !ValidateUtil.checkInteger(startnum)){
			resp.setRespCode(HServiceReturnCode.STARTNUM_ERROR.getReturnCode());
			resp.setRespMessage(HServiceReturnCode.STARTNUM_ERROR.getReturnMessage());
			resp.setRespTime(new Date());
			return getBlankResponse(resp);
		}
		//查询记录数
		String recnum = (String)props.get(CreditApplyHServiceConstants.recnum);
		if(StringUtil.isEmpty(recnum) || !ValidateUtil.checkInteger(recnum)){
			resp.setRespCode(HServiceReturnCode.RECNUM_ERROR.getReturnCode());
			resp.setRespMessage(HServiceReturnCode.RECNUM_ERROR.getReturnMessage());
			resp.setRespTime(new Date());
			return getBlankResponse(resp);
		}
		//List<Map<String, Object>> resList = loanPosCreditApplyBackStageBiz.getCreditApplyDetailByStdshno(stdshno, CreditApplyConstants.CHANNEL_UM);
		Map<String, Object> resMap = loanPosCreditApplyBackStageBiz.getCreditApplyDetailByShmerno(stdshno, stdmerno, startnum, recnum, CreditApplyConstants.CHANNEL_UM);
		if(resMap.isEmpty()){
			resp.setRespCode(HServiceReturnCode.OTHER_ERROR.getReturnCode());
			resp.setRespMessage(HServiceReturnCode.OTHER_ERROR.getReturnMessage());
			resp.setRespTime(new Date());
			return getBlankResponse(resp);
		}
		//银商大白痴！！！
		if(!ListUtil.isNotEmpty((List<Map<String, Object>>)resMap.get("rows"))){
			resp = getBlankResponse(resp);
			resp.setRespCode(HServiceReturnCode.OTHER_ERROR.getReturnCode());
			resp.setRespMessage(HServiceReturnCode.OTHER_ERROR.getReturnMessage());
			resp.setRespTime(new Date());
			return resp;
		}
		resp.setRespCode(HServiceReturnCode.SUCCESS.getReturnCode());
		resp.setRespMessage(HServiceReturnCode.SUCCESS.getReturnMessage());
		resp.setRespTime(new Date());
		resp.setProperties(resMap);
		//总记录数
		//resMap.put(CreditApplyHServiceConstants.totalnum, "1");
		//返回记录数
		/*resMap.put(CreditApplyHServiceConstants.retnum, "1");
		Map<String, Object> creMap = resList.get(0);
		Map<String, Object> custMap = resList.get(1);
		Map<String, Object> relaMap = resList.get(2);
		Map<String, Object> posCustMap = resList.get(3);
		Map<String, Object> bankCardMap = resList.get(4);
		//申请流水号
		resMap.put(CreditApplyHServiceConstants.loanid, creMap.get(CreditApplyConstants.LOAN_ID));
		//客户姓名
		resMap.put(CreditApplyHServiceConstants.custname, custMap.get(CreditApplyConstants.CUST_NAME));
		//申请日期
		resMap.put(CreditApplyHServiceConstants.begindate, creMap.get(CreditApplyConstants.beginDate));
		//申请额度
		resMap.put(CreditApplyHServiceConstants.apptcapi, creMap.get(CreditApplyConstants.APPLY_AMT));
		//还款方式1
		resMap.put(CreditApplyHServiceConstants.retukind1, creMap.get(CreditApplyConstants.returnKind));
		//还款方式2
		resMap.put(CreditApplyHServiceConstants.retukind2, creMap.get(CreditApplyConstants.returnKind2));
		//银行账号/卡号
		resMap.put(CreditApplyHServiceConstants.bankaccno, creMap.get(CreditApplyConstants.bankAccno));
		//账户开户行
		resMap.put(CreditApplyHServiceConstants.bankName, bankCardMap.get(CreditApplyConstants.bankName));
		//账户分行
		resMap.put(CreditApplyHServiceConstants.bankBrandName, bankCardMap.get(CreditApplyConstants.bankBranName));
		//账户支行
		resMap.put(CreditApplyHServiceConstants.bankSubName, bankCardMap.get(CreditApplyConstants.bankSubName));
		//申请状态
		resMap.put(CreditApplyHServiceConstants.apprstate, creMap.get(CreditApplyConstants.APPLY_STATUS));
		
		//收单机构
		resMap.put(CreditApplyHServiceConstants.posorg, creMap.get(CreditApplyConstants.posOrg));
		
		//商户名称
		resMap.put(CreditApplyHServiceConstants.poscustname, posCustMap.get(CreditApplyConstants.POS_CUST_NAME));
		
		//营业执照号
		resMap.put(CreditApplyHServiceConstants.regicode, posCustMap.get(CreditApplyConstants.REG_CODE));
		//主营业务
		resMap.put(CreditApplyHServiceConstants.dealscope, posCustMap.get(CreditApplyConstants.posCustBusiScope));
		//实际经营地址-行政区划
		resMap.put(CreditApplyHServiceConstants.operaddrRegion, posCustMap.get(CreditApplyConstants.operAddrCode));
		//实际经营地址-具体
		resMap.put(CreditApplyHServiceConstants.operaddrdetail, posCustMap.get(CreditApplyConstants.posCustAddress));
		//证件类型
		resMap.put(CreditApplyHServiceConstants.paperkind, custMap.get(CreditApplyConstants.paperKind));
		//证件号码
		resMap.put(CreditApplyHServiceConstants.paperid, custMap.get(CreditApplyConstants.PAPER_ID));
		//性别
		resMap.put(CreditApplyHServiceConstants.sexsign, custMap.get(CreditApplyConstants.sexSign));
		//从业年限
		resMap.put(CreditApplyHServiceConstants.busiyear, custMap.get(CreditApplyConstants.busiYear));
		if(((String)custMap.get(CreditApplyConstants.marrSign)).equals("20")){
			//婚姻状况
			resMap.put(CreditApplyHServiceConstants.marrsign, custMap.get(CreditApplyConstants.marrSign));
			//配偶姓名
			resMap.put(CreditApplyHServiceConstants.familycustname, custMap.get(CreditApplyConstants.familyCustName));
			//配偶证件类型
			resMap.put(CreditApplyHServiceConstants.matepaperkind, custMap.get(CreditApplyConstants.matePaperKind));
			//配偶证件号码
			resMap.put(CreditApplyHServiceConstants.matepaperid, custMap.get(CreditApplyConstants.matePaperId));
			//配偶手机
			resMap.put(CreditApplyHServiceConstants.matemobilephone, custMap.get(CreditApplyConstants.mateMobilePhone));
		}
		//受教育程度
		resMap.put(CreditApplyHServiceConstants.edusign, custMap.get(CreditApplyConstants.educSign));
		//子女人数
		resMap.put(CreditApplyHServiceConstants.childnum, custMap.get(CreditApplyConstants.childNum));
		//拥有经营地房产数量
		resMap.put(CreditApplyHServiceConstants.localhousenum, custMap.get(CreditApplyConstants.localHouseNum));
		//拥有非经营地房产数量
		resMap.put(CreditApplyHServiceConstants.otherhousenum, custMap.get(CreditApplyConstants.otherHouseNum));
		//手机
		resMap.put(CreditApplyHServiceConstants.mobilephone, custMap.get(CreditApplyConstants.mobilePhone));
		//办公电话
		resMap.put(CreditApplyHServiceConstants.tel, custMap.get(CreditApplyConstants.tel));
		//居住地址-行政区划
		resMap.put(CreditApplyHServiceConstants.residentRegion, custMap.get(CreditApplyConstants.residentDivision));
		//居住地址-具体
		resMap.put(CreditApplyHServiceConstants.residentdetail, custMap.get(CreditApplyConstants.residentDetail));
		//联系地址
		resMap.put(CreditApplyHServiceConstants.contactaddrflag, custMap.get(CreditApplyConstants.contactAddrFlag));
		
		if(!relaMap.isEmpty()){
			//亲属姓名
			resMap.put(CreditApplyHServiceConstants.relacustname, relaMap.get(CreditApplyConstants.relaCustName));
			//亲属类型
			resMap.put(CreditApplyHServiceConstants.relakind, relaMap.get(CreditApplyConstants.relaKind));
			//亲属手机
			resMap.put(CreditApplyHServiceConstants.relamobilephone, relaMap.get(CreditApplyConstants.relaMobilePhone));
		}
		
		//亲属固定电话
		
		//影像资料文件包名
		resMap.put(CreditApplyHServiceConstants.imagefilepackagename, creMap.get(CreditApplyHServiceConstants.imagefilepackagename));
		//申请流水号(商户)
		resMap.put(CreditApplyHServiceConstants.stdshno, stdshno);
		//商户id
		resMap.put(CreditApplyHServiceConstants.stdmerno, stdmerno);
		resp.setRespCode(HServiceReturnCode.SUCCESS.getReturnCode());
		resp.setRespMessage(HServiceReturnCode.SUCCESS.getReturnMessage());
		resp.setRespTime(new Date());
		return resp;*/
		return resp;
	}
	
	private HResponse getBlankResponse(HResponse response){
		Map<String, Object> respMap = Maps.newHashMap();
		Map<String, Object> respMap1 = Maps.newHashMap();
		List<Map<String, Object>> aaMaps = Lists.newArrayList();
		respMap1.put(CreditApplyHServiceConstants.totalnum, "0");
		respMap1.put(CreditApplyHServiceConstants.retnum, "0");
		
		respMap.put(CreditApplyHServiceConstants.loanid, "");
		respMap.put(CreditApplyHServiceConstants.custname, "");
		respMap.put(CreditApplyHServiceConstants.begindate, "");
		respMap.put(CreditApplyHServiceConstants.apptcapi, "");
		respMap.put(CreditApplyHServiceConstants.retukind1, "");
		respMap.put(CreditApplyHServiceConstants.retukind2, "");
		respMap.put(CreditApplyHServiceConstants.bankaccno, "");
		respMap.put(CreditApplyHServiceConstants.bankName, "");
		respMap.put(CreditApplyHServiceConstants.bankBrandName, "");
		respMap.put(CreditApplyHServiceConstants.bankSubName, "");
		respMap.put(CreditApplyHServiceConstants.apprstate, "");
		respMap.put(CreditApplyHServiceConstants.addittype, "");
		respMap.put(CreditApplyHServiceConstants.additspec, "");
		respMap.put(CreditApplyHServiceConstants.imgadditdetail, "");
		respMap.put(CreditApplyHServiceConstants.refusereason, "");
		respMap.put(CreditApplyHServiceConstants.appmaxcred, "");
		respMap.put(CreditApplyHServiceConstants.apptterm, "");
		respMap.put(CreditApplyHServiceConstants.interate, "");
		respMap.put(CreditApplyHServiceConstants.appenddate, "");
		respMap.put(CreditApplyHServiceConstants.posorg, "");
		respMap.put(CreditApplyHServiceConstants.poscustname, "");
		respMap.put(CreditApplyHServiceConstants.regicode, "");
		respMap.put(CreditApplyHServiceConstants.dealscope, "");
		respMap.put(CreditApplyHServiceConstants.operaddrRegion, "");
		respMap.put(CreditApplyHServiceConstants.operaddrdetail, "");
		respMap.put(CreditApplyHServiceConstants.industrytypeid, "");
		respMap.put(CreditApplyHServiceConstants.paperkind, "");
		respMap.put(CreditApplyHServiceConstants.paperid, "");
		respMap.put(CreditApplyHServiceConstants.sexsign, "");
		respMap.put(CreditApplyHServiceConstants.busiyear, "");
		respMap.put(CreditApplyHServiceConstants.marrsign, "");
		respMap.put(CreditApplyHServiceConstants.edusign, "");
		respMap.put(CreditApplyHServiceConstants.childnum, "");
		respMap.put(CreditApplyHServiceConstants.localhousenum, "");
		respMap.put(CreditApplyHServiceConstants.otherhousenum, "");
		respMap.put(CreditApplyHServiceConstants.mobilephone, "");
		respMap.put(CreditApplyHServiceConstants.tel, "");
		respMap.put(CreditApplyHServiceConstants.residentRegion, "");
		respMap.put(CreditApplyHServiceConstants.residentdetail, "");
		respMap.put(CreditApplyHServiceConstants.contactaddrflag, "");
		respMap.put(CreditApplyHServiceConstants.weixinno, "");
		respMap.put(CreditApplyHServiceConstants.qqno, "");
		respMap.put(CreditApplyHServiceConstants.email, "");
		respMap.put(CreditApplyHServiceConstants.familycustname, "");
		respMap.put(CreditApplyHServiceConstants.matepaperkind, "");
		respMap.put(CreditApplyHServiceConstants.matepaperid, "");
		respMap.put(CreditApplyHServiceConstants.matemobilephone, "");
		respMap.put(CreditApplyHServiceConstants.relacustname, "");
		respMap.put(CreditApplyHServiceConstants.relakind, "");
		respMap.put(CreditApplyHServiceConstants.relamobilephone, "");
		respMap.put(CreditApplyHServiceConstants.relatel, "");
		respMap.put(CreditApplyHServiceConstants.imagefilepackagename, "");
		respMap.put(CreditApplyHServiceConstants.stdshno, "");
		respMap.put(CreditApplyHServiceConstants.stdmerno, "");
		aaMaps.add(respMap);
		respMap1.put("rows", aaMaps);
		response.setProperties(respMap1);
		return response;

	}

}
