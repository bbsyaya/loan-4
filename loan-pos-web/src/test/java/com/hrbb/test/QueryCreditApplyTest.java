package com.hrbb.test;

import java.io.BufferedReader;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.io.OutputStream;
import java.io.StringWriter;
import java.net.Socket;
import java.util.Map;

import org.junit.Test;

import com.google.common.collect.Maps;

import freemarker.template.Configuration;
import freemarker.template.Template;

public class QueryCreditApplyTest extends SocketTestBase{
	
	private static final Configuration config = new Configuration();

	static {
		// config.setLocalizedLookup(false);
		config.setClassForTemplateLoading(PosApplyTest.class, "/template");
	}
	
	@Test
	public void queryTest() throws Exception{
		Map<String, String> queryCredit = Maps.newHashMap();
		queryCredit.put("transCode", "HB03");
		
		// 银商流水号
		queryCredit.put("stdshno", "1234567");

				// 银商商户号
		queryCredit.put("stdmerno", "1234567");
		queryCredit.put("startnum", "1");
		queryCredit.put("recnum", "10");

		Template requestTemplate = config.getTemplate("um-request-query-apply.ftl");

		StringWriter requestXml = new StringWriter();
		requestTemplate.process(queryCredit, requestXml);
		logger.info(requestXml.toString());
//		this.sendMessage(requestXml.toString());
		Socket socket = new Socket("10.1.5.224",12121);
		OutputStream outputStream = socket.getOutputStream();
		byte[] bt = requestXml.toString().getBytes();
		outputStream.write(bt);
		outputStream.flush();
		System.out.println(socket);
		BufferedReader bufferedReader = new BufferedReader(
                new InputStreamReader(socket.getInputStream()));
		StringBuilder response = new StringBuilder();
        String line = "";
        while ((line = bufferedReader.readLine()) != null) {
            response.append(line);
        }
        logger.info(response.toString());
	    socket.close();
		
	}
}
