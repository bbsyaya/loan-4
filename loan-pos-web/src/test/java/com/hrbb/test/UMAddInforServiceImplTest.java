package com.hrbb.test;

import org.junit.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;

import com.hrbb.loan.spi.UM.UMAddInforServiceImpl;
import com.hrbb.loan.spiconstants.CreditApplyHServiceConstants;
import com.hrbb.sh.framework.HRequest;
import com.hrbb.sh.framework.HResponse;
import com.hrbb.sh.framework.HServiceException;
import com.hrbb.test.UnitTest;

public class UMAddInforServiceImplTest extends UnitTest {
	
	@Autowired
	@Qualifier("umAddInfo")
    private UMAddInforServiceImpl uMAddInforServiceImpl;

	@Test
	public void testServe() throws HServiceException {
		HRequest request = new HRequest();
		request.getProperties().put(CreditApplyHServiceConstants.loanid, "LO2015033010204885089724278000");
		request.getProperties().put(CreditApplyHServiceConstants.imagefilepackagename, "UMS_75778efc7d81469c836df82dfcc17d61_610101898610159981238.gz");
		HResponse response = uMAddInforServiceImpl.serve(request);
		System.out.println(response.getRespCode());
		System.out.println(response.getRespMessage());
	}
}
