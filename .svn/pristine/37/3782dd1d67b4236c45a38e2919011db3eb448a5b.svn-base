//package com.hrbb.test;
//
//import java.text.SimpleDateFormat;
//import java.util.Date;
//
//import org.junit.FixMethodOrder;
//import org.junit.Test;
//import org.junit.runner.RunWith;
//import org.junit.runners.MethodSorters;
//import org.slf4j.Logger;
//import org.slf4j.LoggerFactory;
//import org.springframework.beans.factory.annotation.Autowired;
//import org.springframework.test.context.ContextConfiguration;
//import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;
//
//import com.fasterxml.jackson.annotation.JsonInclude.Include;
//import com.fasterxml.jackson.databind.ObjectMapper;
//import com.hrbb.loan.yjrpay.api.PayCollectQueryFacade;
//import com.hrbb.loan.yjrpay.constants.AccountType;
//import com.hrbb.loan.yjrpay.constants.BankCode;
//import com.hrbb.loan.yjrpay.constants.CertType;
//import com.hrbb.loan.yjrpay.constants.ProductCode;
//import com.hrbb.loan.yjrpay.request.BillPCRequest;
//import com.hrbb.loan.yjrpay.request.QueryRequest;
//import com.hrbb.loan.yjrpay.response.GenericResponse;
//
//@RunWith(SpringJUnit4ClassRunner.class)
//@ContextConfiguration(locations = {"classpath:yjrpay-context.xml"})
//@FixMethodOrder(MethodSorters.NAME_ASCENDING)
//public class PayCollectQueryFacadeTest {
//
//	private static final Logger logger = LoggerFactory.getLogger(PayCollectQueryFacadeTest.class);
//	
//	@Autowired
//	private PayCollectQueryFacade payCollectQueryFacade;
//	
//	private SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
//	
//	private static ObjectMapper objectMapper = new ObjectMapper();
//	
//	static {
//		objectMapper.setSerializationInclusion(Include.NON_NULL);
//	}
//	
//	@Test
//	public void testPay() throws Exception {		
//        BillPCRequest request = new BillPCRequest();
//        request.setProductCode(ProductCode.SALES.getValue());
//        request.setAccName("蒋丹枫");
//        request.setAccNum("6222021001081166222");
//        request.setAccType(AccountType.DEBIT.getValue());
//        request.setCertType(CertType.CIVI_ID_CARD.getValue());
//        request.setCertNo("123343234324234");
//        request.setTransAmt("43.21");
//        request.setTransDate(sdf.format(new Date()));
//        request.setBankCode(BankCode.ICBC.getValue());
//
//		GenericResponse response = payCollectQueryFacade.pay(request);
//		logger.info("{}", objectMapper.writeValueAsString(response));
//	}
//	
//	@Test
//	public void testCollect() throws Exception {
//		BillPCRequest request = new BillPCRequest();
//		request.setProductCode(ProductCode.SALES.getValue());
//        request.setAccName("蒋丹枫");
//        request.setAccNum("6222021001081166222");
//        request.setAccType(AccountType.DEBIT.getValue());
//        request.setCertType(CertType.CIVI_ID_CARD.getValue());
//        request.setCertNo("123343234324234");
//        request.setTransAmt("78.99");
//        request.setTransDate(sdf.format(new Date()));
//        request.setBankCode(BankCode.ICBC.getValue());
//        
//		GenericResponse response = payCollectQueryFacade.collect(request);
//		logger.info("{}", objectMapper.writeValueAsString(response));
//	}
//	
//	@Test
//	public void testQuery() throws Exception {
//		QueryRequest request = new QueryRequest();
//		request.setProductCode(ProductCode.SALES.getValue());
//		request.setOutBizNo("20150715104642925064");
//		GenericResponse response = payCollectQueryFacade.query(request);
//		logger.info("{}", objectMapper.writeValueAsString(response));
//	}
//}
