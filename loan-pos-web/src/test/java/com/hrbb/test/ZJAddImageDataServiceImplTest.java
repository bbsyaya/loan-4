package com.hrbb.test;

import org.junit.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;

import com.hrbb.loan.spi.ZJ.ZJAddImageDataServiceImpl;
import com.hrbb.loan.spiconstants.CreditApplyHServiceConstants;
import com.hrbb.sh.framework.HRequest;
import com.hrbb.sh.framework.HResponse;
import com.hrbb.sh.framework.HServiceException;

public class ZJAddImageDataServiceImplTest extends UnitTest {

    @Autowired
    @Qualifier("zjAddImageDataService")
    private ZJAddImageDataServiceImpl zJAddImageDataServiceImpl;

    @Test
    public void testServe() throws HServiceException {
        HRequest request = new HRequest();
        request.getProperties().put(CreditApplyHServiceConstants.loanid, "LO2015041510464572295339130000");
        request.getProperties().put(CreditApplyHServiceConstants.imagefilepackagename, "loan-post-webLO2015041510464572295339130000.zip");
        HResponse response = zJAddImageDataServiceImpl.serve(request);
        System.out.println(response.getRespCode());
        System.out.println(response.getRespMessage());
    }
}
