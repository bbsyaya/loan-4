package com.hrbb.test;

import static org.junit.Assert.*;

import java.io.StringWriter;
import java.util.Date;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.junit.Before;
import org.junit.Test;
import org.springframework.beans.factory.annotation.Autowired;

import com.hrbb.loan.spi.UM.UMPaybackRunningQueryImpl;
import com.hrbb.loan.spi.UM.UMPaybackTryCalculateImpl;
import com.hrbb.sh.framework.HRequest;
import com.hrbb.sh.framework.HResponse;

import freemarker.template.Configuration;
import freemarker.template.Template;

public class UMPaybackRunningQueryImplTest extends SocketTestBase  {
	@Autowired
	private UMPaybackRunningQueryImpl umPaybackRunningQuery;
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
//		HRequest request = new HRequest();
//		request.setBizType("fafa");
//		request.setChannelType("aaaa");
//		request.setMessageId(9223372036854775806L);
//		request.setRequestTime(new Date());
//		Map<String, Object> properties = new HashMap<String, Object>();
//		properties.put("transCode", "HB12");
//		properties.put("listid","PY2015042121054901930373624600");
//		properties.put("stdshno","bd26a5db6eb244bca884e5a048bd2973");
//		properties.put("stdmerno","1234567");
//		properties.put("startnum","0");
//		properties.put("recnum","2");
//		request.setProperties(properties);
//		List<Map<String, Object>> paybackRunninglist =  (List<Map<String, Object>>) umPaybackRunningQuery.serve(request).getProperties().get("rows");
//		String paybackRunningRecordId = (String) paybackRunninglist.get(0).get("paybackRunningRecordId");
//		HResponse response = umPaybackRunningQuery.serve(request);
//		System.out.println(response);
		
		
		
		Map<String, Object> properties = new HashMap<String, Object>();
		properties.put("transCode", "HB12");
		properties.put("listid","PY2015042121054901930373624600");
		properties.put("stdshno","bd26a5db6eb244bca884e5a048bd2973");
		properties.put("stdmerno","1234567");
		properties.put("startnum","50");
		properties.put("recnum","8");
		Template requestTemplate = config.getTemplate("um-request_payback_running_record_query.ftl");
		requestTemplate.setEncoding("GBK");
		StringWriter requestXml = new StringWriter();
		requestTemplate.process(properties, requestXml);
		this.sendMessage(requestXml.toString());
	}

}
