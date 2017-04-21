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

import com.hrbb.loan.spiconstants.CreditApplyHServiceConstants;

/**
 * 
 * @author marco
 * @version $Id: AddTest.java, v 0.1 2015-4-3 下午5:44:10 marco Exp $
 */
public class UMAddInforServiceImplTestSocket extends SocketTestBase {
	private static final Configuration config = new Configuration();

	static {
		// config.setLocalizedLookup(false);
		config.setClassForTemplateLoading(UMAddInforServiceImplTestSocket.class, "/template");
	}

	@Test
	public void testApply() throws Exception {
		Map<String, String> m = new HashMap<>();
		
		m.put("transCode", "HB04");
		m.put(CreditApplyHServiceConstants.loanid, "LO2015041411273652771629029600");
		m.put(CreditApplyHServiceConstants.imagefilepackagename, "APP_LO2015041519060145328268535100_CU2015041415492916532041119750107023215.gz");
		
		Template requestTemplate = config.getTemplate("um-request-add-info.ftl");
		requestTemplate.setEncoding("GBK");

		StringWriter requestXml = new StringWriter();
		requestTemplate.process(m, requestXml);

		this.sendMessage(requestXml.toString());
	}
}
