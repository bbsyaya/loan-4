package com.hrbb.test;

import org.junit.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;

import com.hrbb.loan.spi.UM.UMApprResultConfirmServiceImpl;
import com.hrbb.loan.spiconstants.PaymentApplyHServiceConstants;
import com.hrbb.sh.framework.HRequest;
import com.hrbb.sh.framework.HResponse;
import com.hrbb.sh.framework.HServiceException;
import com.hrbb.test.UnitTest;

public class UMApprResultConfirmServiceImplTest extends UnitTest {

	@Autowired
	@Qualifier("umApprResultConfirm")
	private UMApprResultConfirmServiceImpl service;

	@Test
	public void testServe() throws HServiceException {
		HRequest request = new HRequest();
		request.getProperties().put(PaymentApplyHServiceConstants.loanid,
				"LO2015060317421932264695504900");
		request.getProperties()
				.put(PaymentApplyHServiceConstants.isaccept, "1");
		request.getProperties().put(PaymentApplyHServiceConstants.refusereason,
				"就是不同意");
		HResponse response = service.serve(request);
		System.out.println(response.getRespCode());
		System.out.println(response.getRespMessage());
	}
}
