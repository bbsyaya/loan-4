package com.hrbb.test;

import java.io.StringWriter;
import java.net.Socket;
import java.nio.charset.Charset;
import java.util.Date;
import java.util.HashMap;
import java.util.Map;

import org.junit.Before;
import org.junit.Test;
import org.springframework.beans.factory.annotation.Autowired;

import com.gnete.net.socket.SocketHelper;
import com.hrbb.loan.spi.UM.UMContractQueryHserviceImpl;
import com.hrbb.loan.spi.UM.UMElectricContractGenerateHserviceImpl;
import com.hrbb.sh.framework.HRequest;
import com.hrbb.sh.framework.HResponse;
import com.hrbb.test.SocketTestBase;
import freemarker.template.Configuration;
import freemarker.template.Template;
public class UMContractQueryHserviceImplTest  extends UnitTest {
	@Autowired
	private UMContractQueryHserviceImpl umContractQuery;
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
	    HRequest request = new HRequest();
		request.setBizType("fafa");
		request.setChannelType("aaaa");
		request.setMessageId(9223372036854775806L);
		request.setRequestTime(new Date());
		Map<String, Object> properties = new HashMap<String, Object>();
		properties.put("contno","cn2015050713413123279991591900");
		properties.put("stdshno","bd26a5db6eb244bca884e5a048bd2973");
		properties.put("stdmerno","12343567");
		request.setProperties(properties);
		String contno = (String) umContractQuery.serve(request).getProperties().get("contno");
		HResponse response = umContractQuery.serve(request);
		System.out.println(response);
	
		
//		Map<String, Object> properties = new HashMap<String, Object>();
//		properties.put("transCode", "HB07");
//		properties.put("contno","cn2015040812590947674952247888");
//		properties.put("stdshno","bd26a5db6eb244bca884e5a048bd2973");
//		properties.put("stdmerno","12343567");
//		Template requestTemplate = config.getTemplate("um-request_contract_query.ftl");
//		requestTemplate.setEncoding("GBK");
//		StringWriter requestXml = new StringWriter();
//		requestTemplate.process(properties, requestXml);
//		this.sendMessage(requestXml.toString());
		
		
		

		

	}

}
