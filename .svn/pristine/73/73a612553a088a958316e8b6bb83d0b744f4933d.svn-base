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

import com.hrbb.loan.spi.UM.UMElectricContractGenerateHserviceImpl;
import com.hrbb.loan.spi.UM.UMPaybackTryCalculateImpl;
import com.hrbb.sh.framework.HRequest;
import com.hrbb.sh.framework.HResponse;
import com.hrbb.sh.framework.HServiceException;

import freemarker.template.Configuration;
import freemarker.template.Template;

public class UMPaybackTryCalculateImplTest extends UnitTest {
	@Autowired
	private UMPaybackTryCalculateImpl umPaybackTryCalculate;
	private static final Configuration config = new Configuration();
	static {
		 config.setClassForTemplateLoading(UMContractQueryHserviceImplTest.class, "/template");
	}
	@Before
	public void setUp() throws Exception {
	}

	@Test
	public void testServe() throws Exception {
		HRequest request = new HRequest();
		request.setBizType("fafa");
		request.setChannelType("aaaa");
		request.setMessageId(9223372036854775806L);
		request.setRequestTime(new Date());
		Map<String, Object> properties = new HashMap<String, Object>();
		properties.put("transCode", "HB10");
		properties.put("listid","386832869");
		properties.put("aheakind","1");
		properties.put("rcapi","200000");
		properties.put("sumamt","220000");
		properties.put("expectretudate","20150525");
		properties.put("stdmerno","12343567");
		request.setProperties(properties);
		String listid = (String) umPaybackTryCalculate.serve(request).getProperties().get("listid");
		HResponse response = umPaybackTryCalculate.serve(request);
		System.out.println(response);
		
		
		
//		Map<String, Object> properties = new HashMap<String, Object>();
//		properties.put("transCode", "HB10");
//		properties.put("listid","386832869");
//		properties.put("aheakind","01");
//		properties.put("rcapi","200000");
//		properties.put("sumamt","220000");
//		properties.put("stdmerno","12343567");
//		Template requestTemplate = config.getTemplate("um-request_payback_try_calculate.ftl");
//		requestTemplate.setEncoding("GBK");
//		StringWriter requestXml = new StringWriter();
//		requestTemplate.process(properties, requestXml);
//		this.sendMessage(requestXml.toString());
		
		
	}

}
