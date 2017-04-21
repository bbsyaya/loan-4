package com.hrbb.test;

import java.math.BigDecimal;
import java.util.Map;

import org.junit.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;

import com.hrbb.loan.spiconstants.PaymentApplyHServiceConstants;
import com.hrbb.sh.framework.HRequest;
import com.hrbb.sh.framework.HResponse;
import com.hrbb.sh.framework.HService;

public class TC2PaymentApplyServiceImplTest extends UnitTest {

	@Autowired
	@Qualifier("tc2PaymentApply")
	private HService tc2PaymentApply;

	@Test
	public void umCreditApplyHServiceTest() {
		HRequest request = new HRequest();
		Map<String, Object> props = request.getProperties();

		props.put(PaymentApplyHServiceConstants.stdisno,
				"123456789012345678901234567890");
		props.put(PaymentApplyHServiceConstants.contno,
				"CNT201508251557467605050760670");
		props.put(PaymentApplyHServiceConstants.tcapi, "40000");
		props.put(PaymentApplyHServiceConstants.tterm, "3");
		props.put(PaymentApplyHServiceConstants.interate, new BigDecimal(0.14));
		props.put(PaymentApplyHServiceConstants.retukind, "90");
		// props.put(PaymentApplyHServiceConstants.repaymethod, "02");
		props.put(PaymentApplyHServiceConstants.loanbankacno, "55555555");
		// props.put(PaymentApplyHServiceConstants.loanbankname, "18600496885");
		// props.put(PaymentApplyHServiceConstants.loanbankBranch,
		// "18600496885");
		// props.put(PaymentApplyHServiceConstants.loanbankSub, "18600496885");
		props.put(PaymentApplyHServiceConstants.desireddate, "20150904");
		props.put(PaymentApplyHServiceConstants.loanuse, "02");
		props.put(PaymentApplyHServiceConstants.begindate, "20150825");

		try {
			HResponse response = tc2PaymentApply.serve(request);
			System.out.println(response.getRespMessage());
		} catch (Exception e) {
			System.out.println(e.getStackTrace());
		}
	}
}
