package com.hrbb.test;

import javax.annotation.Resource;

import org.junit.FixMethodOrder;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.junit.runners.MethodSorters;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

import com.fasterxml.jackson.annotation.JsonInclude.Include;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.hrbb.loan.pay.api.PayCollectQueryService;
import com.hrbb.loan.pay.api.request.AccountCheckRequest;
import com.hrbb.loan.pay.api.request.SingleCollectRequest;
import com.hrbb.loan.pay.api.request.SinglePayRequest;
import com.hrbb.loan.pay.api.request.SingleQueryRequest;
import com.hrbb.loan.pay.api.response.AccountCheckResponse;
import com.hrbb.loan.pay.api.response.SingleCollectResponse;
import com.hrbb.loan.pay.api.response.SinglePayResponse;
import com.hrbb.loan.pay.api.response.SingleQueryResponse;
import com.hrbb.loan.pay.constants.AccountType;
import com.hrbb.loan.pay.constants.BankCode;
import com.hrbb.loan.pay.constants.CertType;
import com.hrbb.loan.pay.constants.PayChannel;
import com.hrbb.loan.pay.constants.ProductCode;

@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration(locations = {"classpath:config/context/payclient-context.xml"})
@FixMethodOrder(MethodSorters.NAME_ASCENDING)
public class YJRPayClientTest {

	private static final Logger logger = LoggerFactory.getLogger(YJRPayClientTest.class);
	
	@Resource(name="payCollectQueryHessian")
	private PayCollectQueryService payCollectQueryHessian;
	
	@Resource(name="payCollectQueryHttpInvoker")
	private PayCollectQueryService payCollectQueryHttpInvoker;
	
	private static ObjectMapper objectMapper = new ObjectMapper();
	
	static {
		objectMapper.setSerializationInclusion(Include.NON_NULL);
	}
	
	@Test
	public void testSinglePay() throws Exception {
        SinglePayRequest request = new SinglePayRequest();
        request.setProductCode(ProductCode.COLLEGE.getValue());
        request.setChannelNo(PayChannel.YJRPAY.getValue());

        request.setAccName("张三");
        request.setAccNum("6222021001081166222");
        request.setAccType(AccountType.DEBIT.getValue());
        request.setCertType(CertType.CIVI_ID_CARD.getValue());
        request.setCertNo("123343234324234");
        request.setTransAmt("32");
        request.setTransDate("2015-08-15 00:00:00");
        request.setBankCode(BankCode.ABC.getValue());
        
        SinglePayResponse response = payCollectQueryHessian.singlePay(request);
		logger.info("status = {}", response.getStatus());
		logger.info("{}", objectMapper.writeValueAsString(response));
	}
	
	@Test
	public void testSingleCollect() throws Exception {
		SingleCollectRequest request = new SingleCollectRequest();
        request.setProductCode(ProductCode.COLLEGE.getValue());
        request.setChannelNo(PayChannel.YJRPAY.getValue());
        request.setAccName("陈建清");
        request.setAccNum("6215590200008811796");
        request.setAccType(AccountType.DEBIT.getValue());
        request.setCertType(CertType.CIVI_ID_CARD.getValue());
        request.setCertNo("130725198908020011");
        request.setTransAmt("10");
        request.setTransDate("2015-08-18 00:00:00");
        request.setBankCode(BankCode.ICBC.getValue());
        
        SingleCollectResponse response = payCollectQueryHessian.singleCollect(request);
		logger.info("status = {}", response.getStatus());
		logger.info("{}", objectMapper.writeValueAsString(response));
	}
	
	@Test
	public void testSingleQuery() throws Exception {
		SingleQueryRequest request = new SingleQueryRequest();
        request.setChannelNo(PayChannel.YJRPAY.getValue());
        request.setProductCode(ProductCode.COLLEGE.getValue());
        request.setOrderNo("100102039820150816112307008856");

        SingleQueryResponse response = payCollectQueryHessian.singleQuery(request);
		logger.info("status = {}", response.getStatus());
		logger.info("{}", objectMapper.writeValueAsString(response));
	}
	
//	@Test
//	public void testRecon() throws Exception {
//		ReconRequest request = new ReconRequest();
//		request.setProductCode(ProductCode.SALES.getValue());
//		request.setAccountDate("2015-08-06");
//		ReconResponse response = payCollectQueryHessian.recon(request);
//		logger.info("status = {}", response.getStatus());
//		logger.info("{}", objectMapper.writeValueAsString(response));
//		
//	}
	
	@Test
	public void testAccountCheck() throws Exception {
		AccountCheckRequest request = new AccountCheckRequest();
        request.setChannelNo(PayChannel.YJRPAY.getValue());
        request.setProductCode(ProductCode.COLLEGE.getValue());
        request.setAccName("李四");
        request.setAccNum("622201232133213213");
        request.setCertNo("1232132131");
        request.setCertType(CertType.CIVI_ID_CARD.getValue());
        
        AccountCheckResponse response = payCollectQueryHessian.checkAccount(request);
		logger.info("status = {}", response.getStatus());
		logger.info("{}", objectMapper.writeValueAsString(response));
	}
}
