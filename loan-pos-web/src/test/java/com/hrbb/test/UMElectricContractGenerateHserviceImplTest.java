package com.hrbb.test;
import java.io.StringWriter;
import java.util.Date;
import java.util.HashMap;
import java.util.Map;
import org.junit.Before;
import org.junit.Test;
import org.springframework.beans.factory.annotation.Autowired;

import com.hrbb.loan.pos.service.LoanPosContractManagementService;
import com.hrbb.loan.spi.UM.UMElectricContractGenerateHserviceImpl;
import com.hrbb.sh.framework.HRequest;
import com.hrbb.sh.framework.HResponse;

import freemarker.template.Configuration;
import freemarker.template.Template;
public class UMElectricContractGenerateHserviceImplTest extends SocketTestBase {
	@Autowired
	private UMElectricContractGenerateHserviceImpl umElectricContractGenerate;
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
//	    HRequest request = new HRequest();
//		request.setBizType("fafa");
//		request.setChannelType("aaaa");
//		request.setMessageId(9223372036854775806L);
//		request.setRequestTime(new Date());
//		Map<String, Object> properties = new HashMap<String, Object>();
//		properties.put("loanid","LO2015033014352477613086580900");
//		properties.put("stdshno", "923759");
//		request.setProperties(properties);
//		String contno = (String) umElectricContractGenerate.serve(request).getProperties().get("contno");
//		HResponse response = umElectricContractGenerate.serve(request);
//		System.out.println(response);
		
		
		Map<String, Object> properties = new HashMap<String, Object>();
		properties.put("transCode", "HB14");
//		properties.put("loanid", "LO20150317140345775886896354");
		properties.put("stdshno", "LO2015042010544449487903450600");
		Template requestTemplate = config.getTemplate("um-request_contract_generate.ftl");
		requestTemplate.setEncoding("GBK");
		StringWriter requestXml = new StringWriter();
		requestTemplate.process(properties, requestXml);
		this.sendMessage(requestXml.toString());
	}

}
