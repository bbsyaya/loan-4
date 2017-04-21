package com.hrbb.test;

import java.io.StringWriter;
import java.util.Map;

import org.junit.Test;

import com.google.common.collect.Maps;
import com.hrbb.loan.spiconstants.CreditApplyHServiceConstants;

import freemarker.template.Configuration;
import freemarker.template.Template;

public class PosSerialNoTest extends SocketTestBase{
	
	private static final Configuration config = new Configuration();

	static {
		// config.setLocalizedLookup(false);
		config.setClassForTemplateLoading(PosApplyTest.class, "/template");
	}
	@Test
	public void posSerialNoTest() throws Exception{
		Map<String, String> props = Maps.newHashMap();
		props.put("transCode", "HB02");
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
				
				Template requestTemplate = config.getTemplate("um-request-pos-serialno.ftl");

				StringWriter requestXml = new StringWriter();
				requestTemplate.process(props, requestXml);

				this.sendMessage(requestXml.toString());
	}

}
