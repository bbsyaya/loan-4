package com.hrbb.test;

import java.util.Map;

import org.junit.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;

import com.hrbb.loan.spiconstants.CreditApplyHServiceConstants;
import com.hrbb.sh.framework.HRequest;
import com.hrbb.sh.framework.HResponse;
import com.hrbb.sh.framework.HService;

public class CreditApplyTest extends UnitTest {
	
	
	@Autowired
	@Qualifier("umCreditApply")
	private HService umCreditApplyHService;
	
	@Autowired
	@Qualifier("umPosSerial")
	private HService umPosSerialHService;
	
	@Autowired
	@Qualifier("umQueryApplyInfo")
	private HService umQueryApplyInfoHService;
	
	@Test
	public void umCreditApplyHServiceTest(){
		HRequest request = new HRequest();
		Map<String, Object> props = request.getProperties();
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
		props.put(CreditApplyHServiceConstants.matepaperid, "310115198805020113");

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
		props.put(CreditApplyHServiceConstants.stdshno, "12234567");

		// 银商商户号
		props.put(CreditApplyHServiceConstants.stdmerno, "12345677");
		
		
		try{
			HResponse response = umCreditApplyHService.serve(request);
			System.out.println(response.getRespMessage());
		}catch(Exception e){
			System.out.println(e.getStackTrace());
		}
	}
	
	@Test
	public void posSerialNoUploadTest(){
		HRequest request = new HRequest();
		Map<String, Object> props = request.getProperties();
		//申请流水号
		props.put(CreditApplyHServiceConstants.loanid, "LO2015033014352477613086580900");
		//pos交易流水号
		/*String posflowid = (String)props.get(CreditApplyHServiceConstants.posflowid);*/
		//每月pos交易金额
		props.put(CreditApplyHServiceConstants.posamt, "3000");
	
		//每月pos交易笔数
		props.put(CreditApplyHServiceConstants.possum, "10");
		//每月正常时间的交易金额
		props.put(CreditApplyHServiceConstants.posamtnor, "2000");
		//每月正常时间的交易笔数
		props.put(CreditApplyHServiceConstants.possumnor, "300");
		props.put(CreditApplyHServiceConstants.posamtmax, "1000");
		//每月信用卡交易金额占比
		props.put(CreditApplyHServiceConstants.posamtcreper, "30%");
		//每月信用卡交易笔数占比
		props.put(CreditApplyHServiceConstants.possumcreper, "30%");
		//每月不重复卡号数
		props.put(CreditApplyHServiceConstants.poscardsum, "2");
		try{
			HResponse response = umPosSerialHService.serve(request);
			System.out.println(response.getRespMessage());
		}catch(Exception e){
			System.out.println(e.getStackTrace());
		}
	}
	
	@Test
	public void queryCreditApply(){
		HRequest request = new HRequest();
		Map<String, Object> props = request.getProperties();
		props.put(CreditApplyHServiceConstants.stdshno, "12234567");
		//商户ID
		props.put(CreditApplyHServiceConstants.stdmerno, "1234567");
		//起始i记录号
		props.put(CreditApplyHServiceConstants.startnum, "1");
		//返回记录数
		props.put(CreditApplyHServiceConstants.recnum, "10");
		try{
			HResponse response = umQueryApplyInfoHService.serve(request);
			System.out.println(response.getProperties());
		}catch(Exception e){
			System.out.println(e.getMessage());
		}
	}
	
}
