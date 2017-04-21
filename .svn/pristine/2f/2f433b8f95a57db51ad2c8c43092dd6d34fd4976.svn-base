package com.hrbb.test;

import static org.junit.Assert.*;

import java.io.IOException;
import java.io.StringWriter;
import java.util.Date;
import java.util.HashMap;
import java.util.Map;

import org.junit.Before;
import org.junit.Test;
import org.springframework.beans.factory.annotation.Autowired;

import com.hrbb.loan.spi.UM.UMPaybackTryCalculateImpl;
import com.hrbb.loan.spi.UM.UMRepaymentApplyServiceImpl;
import com.hrbb.sh.framework.HRequest;
import com.hrbb.sh.framework.HResponse;
import com.hrbb.test.SocketTestBase;
import com.hrbb.test.UMContractQueryHserviceImplTest;

import freemarker.template.Configuration;
import freemarker.template.Template;

public class UMRepaymentApplyServiceImplTest extends SocketTestBase {
	@Autowired
	private UMRepaymentApplyServiceImpl umRepaymentApply;
	private static final Configuration config = new Configuration();
	static {
		// config.setLocalizedLookup(false);
		 config.setClassForTemplateLoading(UMContractQueryHserviceImplTest.class, "/template");
	}
	@Before
	public void setUp() throws Exception {
	}

	@Test
	public void testServe() throws Exception {
		
		Map<String, Object> properties = new HashMap<String, Object>();
		Template requestTemplate = config.getTemplate("um-request_repayment_apply.ftl");
		requestTemplate.setEncoding("GBK");
		StringWriter requestXml = new StringWriter();
		requestTemplate.process(properties, requestXml);
		this.sendMessage(requestXml.toString());
		
		
		
		
//		HRequest request = new HRequest();
//		request.setBizType("fafa");
//		request.setChannelType("aaaa");
//		request.setMessageId(9223372036854775806L);
//		request.setRequestTime(new Date());
//		Map<String, Object> properties = new HashMap<String, Object>();
//		properties.put("transCode", "HB11");
//		properties.put("listid","PY2015042121054901930373624600");
//		properties.put("retutype","02");
//		properties.put("sumamt","15000");
//		properties.put("aheakind","01");
//		properties.put("subsaccno","5782981829186519827");
//		properties.put("retudate","20150423");
//		properties.put("stdmerno","32898320450390494");
//		request.setProperties(properties);
//		HResponse response = umRepaymentApply.serve(request);
//		System.out.println(response);
	}

}
