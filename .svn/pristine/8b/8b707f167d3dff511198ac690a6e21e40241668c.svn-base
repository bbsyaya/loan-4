package com.hrbb.test;



import java.io.StringWriter;
import java.util.HashMap;
import java.util.Map;

import org.junit.Before;
import org.junit.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import com.hrbb.loan.spi.UM.UMContractBackHserviceImpl;
import com.hrbb.loan.spiconstants.CreditApplyHServiceConstants;
import com.hrbb.sh.framework.HRequest;
import com.hrbb.sh.framework.HResponse;
import freemarker.template.Configuration;
import freemarker.template.Template;

public class UMContractBackHserviceImplTest extends SocketTestBase{
	private static final Configuration config = new Configuration();

	static {
		// config.setLocalizedLookup(false);
		 config.setClassForTemplateLoading(UMContractQueryHserviceImplTest.class, "/template");
	}
	
	@Autowired
	@Qualifier("umContractBack")
    private UMContractBackHserviceImpl umContractBack;
	@Before
	public void setUp() throws Exception {
	}

	@Test
	public void testServe() throws Exception  {
/*		HRequest request = new HRequest();
		request.getProperties().put(CreditApplyHServiceConstants.loanid, "LO20150316194125007233686512");
		request.getProperties().put(CreditApplyHServiceConstants.imagefilepackagename, "UMS_7dac37b8188a42ab868085f9cbba05c1_410923898410956910174.gz");
		request.getProperties().put("signdate", "2015-04-08");
		request.getProperties().put("enddate", "2015-04-08");
		HResponse response = umContractBack.serve(request);
		System.out.println(response.getRespCode());
		System.out.println(response.getRespMessage());*/
		
		

		Map<String, Object> properties = new HashMap<String, Object>();
		properties.put("stdshno","38902");
		properties.put("loanid","LO20150316194125007233686512");
		properties.put("imagefilepackagename", "UMS_7dac37b8188a42ab868085f9cbba05c1_410923898410956910174.gz");
		Template requestTemplate = config.getTemplate("um-request-contract-back.ftl");
		requestTemplate.setEncoding("GBK");

		StringWriter requestXml = new StringWriter();
		requestTemplate.process(properties, requestXml);

		this.sendMessage(requestXml.toString());
		
	}

}
