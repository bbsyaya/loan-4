package com.hrbb.test;

import java.util.Map;

import org.junit.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;

import com.hrbb.loan.spiconstants.CreditApplyHServiceConstants;
import com.hrbb.sh.framework.HRequest;
import com.hrbb.sh.framework.HResponse;
import com.hrbb.sh.framework.HService;

public class TC2ApproveResultFeedbackHServiceImplTest extends UnitTest {

	@Autowired
	@Qualifier("tc2ApproveResultFeedback")
	private HService tc2ApproveResultFeedback;

	@Test
	public void umCreditApplyHServiceTest() {
		HRequest request = new HRequest();
		Map<String, Object> props = request.getProperties();

		props.put(CreditApplyHServiceConstants.loanid,
				"LO2015081721070556945880461700");
		props.put(CreditApplyHServiceConstants.custid, "C2015062919015523945");
		props.put(CreditApplyHServiceConstants.apprtime, "20150819 190701");
		props.put(CreditApplyHServiceConstants.apprresult, "90");
		props.put(CreditApplyHServiceConstants.apprlimit, "100000.00");
		props.put(CreditApplyHServiceConstants.apprprice, "12.121212");
		props.put(CreditApplyHServiceConstants.apprterm, "12");
		props.put(CreditApplyHServiceConstants.expireddate, "20150919");
		props.put(CreditApplyHServiceConstants.refusereason, null);
		props.put(CreditApplyHServiceConstants.stdshno,
				"hrbbsx20150629183503000006");

		try {
			HResponse response = tc2ApproveResultFeedback.serve(request);
			System.out.println(response.getRespMessage());
		} catch (Exception e) {
			System.out.println(e.getStackTrace());
		}
	}
}
