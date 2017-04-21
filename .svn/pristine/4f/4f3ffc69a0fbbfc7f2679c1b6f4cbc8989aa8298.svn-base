package com.hrbb.test;

import java.util.Map;

import org.junit.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;

import com.hrbb.loan.spiconstants.CreditApplyHServiceConstants;
import com.hrbb.sh.framework.HRequest;
import com.hrbb.sh.framework.HResponse;
import com.hrbb.sh.framework.HService;

public class TC2BankCardCheckServiceImplTest extends UnitTest {

	@Autowired
	@Qualifier("tc2BankCardCheck")
	private HService tc2BankCardCheck;

	@Test
	public void umCreditApplyHServiceTest() {
		HRequest request = new HRequest();
		Map<String, Object> props = request.getProperties();

		props.put(CreditApplyHServiceConstants.custid, "C201507181730282136D");
		props.put(CreditApplyHServiceConstants.custname, "马驰骋a");
		props.put(CreditApplyHServiceConstants.paperid, "500103198705172136");
		props.put(CreditApplyHServiceConstants.bankaccno, "9558800200160866253aaaaaaaa");
		props.put(CreditApplyHServiceConstants.bankName, "0102");
		props.put(CreditApplyHServiceConstants.bankBrandName, "北京分行");
		props.put(CreditApplyHServiceConstants.bankSubName, "北大支行");
		props.put(CreditApplyHServiceConstants.reservedno, "18600496885");

		try {
			HResponse response = tc2BankCardCheck.serve(request);
			System.out.println(response.getRespMessage());
		} catch (Exception e) {
			System.out.println(e.getStackTrace());
		}
	}
}
