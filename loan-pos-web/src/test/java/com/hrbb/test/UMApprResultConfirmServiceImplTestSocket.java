/**
 * 
 *	哈尔滨银行
 * Copyright (c) 2007-2015 HRBB,Inc.All Rights Reserved.
 */
package com.hrbb.test;

import java.io.StringWriter;
import java.util.HashMap;
import java.util.Map;

import freemarker.template.Configuration;
import freemarker.template.Template;

import org.junit.Test;

import com.hrbb.loan.spiconstants.PaymentApplyHServiceConstants;

/**
 * 
 * @author marco
 * @version $Id: UMApprResultConfirmServiceImplTestSocket.java, v 0.1 2015-4-3
 *          下午5:44:10 marco Exp $
 */
public class UMApprResultConfirmServiceImplTestSocket extends SocketTestBase {
	private static final Configuration config = new Configuration();

	static {
		config.setClassForTemplateLoading(
				UMApprResultConfirmServiceImplTestSocket.class, "/template");
	}

	@Test
	public void testApply() throws Exception {
		Map<String, String> m = new HashMap<>();

		m.put("transCode", "HB05");
		m.put(PaymentApplyHServiceConstants.loanid,
				"LO2015060317421932264695504900");
		m.put(PaymentApplyHServiceConstants.isaccept, "1");
		m.put(PaymentApplyHServiceConstants.refusereason, "就是不同意");

		Template requestTemplate = config
				.getTemplate("um-request_appr_result_confirm.ftl");
		requestTemplate.setEncoding("GBK");

		StringWriter requestXml = new StringWriter();
		requestTemplate.process(m, requestXml);

		this.sendMessage(requestXml.toString());
	}
}
