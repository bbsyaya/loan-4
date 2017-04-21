package com.hrbb.test;

import java.io.StringWriter;
import java.util.HashMap;
import java.util.Map;

import org.junit.Test;

import freemarker.template.Configuration;
import freemarker.template.Template;

public class PosApplyTest extends SocketTestBase {
	private static final Configuration config = new Configuration();

	static {
		// config.setLocalizedLookup(false);
		config.setClassForTemplateLoading(PosApplyTest.class, "/template");
	}

	private Map<String, String> getCreditApply() {
		Map<String, String> props = new HashMap<String, String>();
		props.put("transCode", "HB01");

		// 收单机构
		props.put(CreditApplyHServiceConstants.posorg, "01");

		// 商户名称
		props.put(CreditApplyHServiceConstants.poscustname, "上海露酒");
		// 营业执照号
		props.put(CreditApplyHServiceConstants.regicode, "1231342131233123");
		// 主营业务
		props.put(CreditApplyHServiceConstants.dealscope, "酒类");
		// 实际经营地址-行政区划
		props.put(CreditApplyHServiceConstants.operaddrRegion, "311012");
		// 实际经营地址-具体
		props.put(CreditApplyHServiceConstants.operaddrdetail, "上海市浦东新区噜噜噜");

		// 所属行业
		props.put(CreditApplyHServiceConstants.industrytypeid, "31231");
		// 客户姓名
		props.put(CreditApplyHServiceConstants.custname, "斯拉的");
		// 证件类型
		props.put(CreditApplyHServiceConstants.paperkind, "01");
		// 证件号码
		props.put(CreditApplyHServiceConstants.paperid, "310115198805020113");
		// 性别
		props.put(CreditApplyHServiceConstants.sexsign, "01");

		// 从业年限
		props.put(CreditApplyHServiceConstants.busiyear, "12");
		// 婚姻状况
		props.put(CreditApplyHServiceConstants.marrsign, "10");
		// 受教育程度
		props.put(CreditApplyHServiceConstants.edusign, "20");
		// 子女人数
		props.put(CreditApplyHServiceConstants.childnum, "1");

		// 拥有经营地房产数量
		props.put(CreditApplyHServiceConstants.localhousenum, "1");

		// 拥有非经营地房产数量
		props.put(CreditApplyHServiceConstants.otherhousenum, "1");

		// 手机
		props.put(CreditApplyHServiceConstants.mobilephone, "15001929875");

		// 办公电话
		props.put(CreditApplyHServiceConstants.tel, "68682162");
		// 居住地-行政区划
		props.put(CreditApplyHServiceConstants.residentRegion, "3101112");

		// 居住地址-具体
		props.put(CreditApplyHServiceConstants.residentdetail, "上海市浦东新区呼呼呼");

		// 联系地址
		props.put(CreditApplyHServiceConstants.contactaddrflag, "上海浦东新区呼呼呼");

		// 微信号
		props.put(CreditApplyHServiceConstants.weixinno, "syslsy");

		// QQ号
		props.put(CreditApplyHServiceConstants.qqno, "435432218");

		// 电子邮箱
		props.put(CreditApplyHServiceConstants.email, "songyilinking@sina.com");

		// 配偶姓名
		props.put(CreditApplyHServiceConstants.familycustname, "哭哭哦哦");

		// 配偶证件类型
		props.put(CreditApplyHServiceConstants.matepaperkind, "01");

		// 配偶证件号码
		props.put(CreditApplyHServiceConstants.matepaperid,
				"310115198805020113");

		// 配偶手机
		props.put(CreditApplyHServiceConstants.matemobilephone, "15001929875");

		// 亲属姓名
		props.put(CreditApplyHServiceConstants.relacustname, "肃然");

		// 亲属类型
		props.put(CreditApplyHServiceConstants.relakind, "1");

		// 亲属手机
		props.put(CreditApplyHServiceConstants.relamobilephone, "15001929875");

		// 亲属固定电话
		props.put(CreditApplyHServiceConstants.relatel, "50219592");

		// 影像资料文件包名
		props.put(CreditApplyHServiceConstants.imagefilepackagename, "123123");
		// 申请额度
		props.put(CreditApplyHServiceConstants.apptcapi, "5000");
		// 申请期限
		props.put(CreditApplyHServiceConstants.appterm, "12");
		// 还款方式1
		props.put(CreditApplyHServiceConstants.retukind1, "01");

		// 还款方式2
		props.put(CreditApplyHServiceConstants.retukind2, "01");

		// 银行账号/卡号
		props.put(CreditApplyHServiceConstants.bankaccno, "6212304213043123");
		// 账户开户行
		props.put(CreditApplyHServiceConstants.bankName, "工商银行");

		// 账户分行
		props.put(CreditApplyHServiceConstants.bankBrandName, "上海分行");

		// 账户支行
		props.put(CreditApplyHServiceConstants.bankSubName, "虹口支行");

		// 机构号/推荐机构
		props.put(CreditApplyHServiceConstants.bankid, "010101");

		// 营销经理/推荐人
		props.put(CreditApplyHServiceConstants.operid, "10202130");

		// 银商流水号
		props.put(CreditApplyHServiceConstants.stdshno, "1223483567");

		// 银商商户号
		props.put(CreditApplyHServiceConstants.stdmerno, "123403567");

		return props;
	}

	@Test
	public void testApply() throws Exception {
		Map<String, String> creditApply = getCreditApply();

		Template requestTemplate = config.getTemplate("um-request-credit-apply.ftl");

		StringWriter requestXml = new StringWriter();
		requestTemplate.process(creditApply, requestXml);
		logger.info(requestXml.toString());
		logger.info(requestXml.toString().length());

		this.sendMessage(requestXml.toString());
	}

	private class CreditApplyHServiceConstants {

		// 收单机构
		public static final String posorg = "posorg";

		// 商户名称
		public static final String poscustname = "poscustname";

		// 营业执照号
		public static final String regicode = "regicode";

		// 主营业务
		public static final String dealscope = "dealscope";

		// 实际经营地址-行政区划
		public static final String operaddrRegion = "operaddrRegion";

		// 实际经营地址-具体
		public static final String operaddrdetail = "operaddrdetail";

		// 所属行业
		public static final String industrytypeid = "industrytypeid";

		// 客户姓名
		public static final String custname = "custname";

		// 证件类型
		public static final String paperkind = "paperkind";

		// 证件号码
		public static final String paperid = "paperid";

		// 性别
		public static final String sexsign = "sexsign";

		// 从业年限
		public static final String busiyear = "busiyear";

		// 婚姻状况
		public static final String marrsign = "marrsign";

		// 受教育程度
		public static final String edusign = "educsign";

		// 子女人数
		public static final String childnum = "childnum";

		// 拥有经营地房产数量
		public static final String localhousenum = "localhousenum";

		// 拥有非经营地房产数量
		public static final String otherhousenum = "otherhousenum";

		// 手机
		public static final String mobilephone = "mobilephone";

		// 办公电话
		public static final String tel = "tel";

		// 居住地-行政区划
		public static final String residentRegion = "residentRegion";

		// 居住地址-具体
		public static final String residentdetail = "residentdetail";

		// 联系地址
		public static final String contactaddrflag = "contactaddrflag";

		// 微信号
		public static final String weixinno = "weixinno";

		// QQ号
		public static final String qqno = "qqno";

		// 电子邮箱
		public static final String email = "email";

		// 配偶姓名
		public static final String familycustname = "familycustname";

		// 配偶证件类型
		public static final String matepaperkind = "matepaperkind";

		// 配偶证件号码
		public static final String matepaperid = "matepaperid";

		// 配偶手机
		public static final String matemobilephone = "matemobilephone";

		// 亲属姓名
		public static final String relacustname = "relacustname";

		// 亲属类型
		public static final String relakind = "relakind";

		// 亲属手机
		public static final String relamobilephone = "relamobilephone";

		// 亲属固定电话
		public static final String relatel = "relatel";

		// 影像资料文件包名
		public static final String imagefilepackagename = "imagefilepackagename";

		// 申请额度
		public static final String apptcapi = "apptcapi";

		// 申请期限
		public static final String appterm = "appterm";

		// 还款方式1
		public static final String retukind1 = "retukind1";

		// 还款方式2
		public static final String retukind2 = "retukind2";

		// 银行账号/卡号
		public static final String bankaccno = "bankaccno";

		// 账户开户行
		public static final String bankName = "bankName";

		// 账户分行
		public static final String bankBrandName = "bankBrandName";

		// 账户支行
		public static final String bankSubName = "bankSubName";

		// 机构号/推荐机构
		public static final String bankid = "bankid";

		// 营销经理/推荐人
		public static final String operid = "operid";

		// 银商流水号
		public static final String stdshno = "stdshno";

		// 银商商户号
		public static final String stdmerno = "stdmerno";
	}

}
