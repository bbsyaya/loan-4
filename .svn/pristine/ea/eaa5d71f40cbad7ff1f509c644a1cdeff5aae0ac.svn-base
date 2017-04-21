package com.hrbb.test;

import java.util.Map;

import org.junit.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;

import com.hrbb.sh.framework.HRequest;
import com.hrbb.sh.framework.HResponse;
import com.hrbb.sh.framework.HService;

public class TC2RepaymentApplyServiceImplTest extends UnitTest {

	@Autowired
	@Qualifier("tc2RepaymentApply")
	private HService tc2RepaymentApply;

	@Test
	public void umCreditApplyHServiceTest() {
		HRequest request = new HRequest();
		Map<String, Object> props = request.getProperties();

		props.put("stdrpno", "123456789012345678901234567890");
		props.put("issueid", "PY2015042015483590587871816300");
		props.put("sumamt", "10000");
		props.put("aheakind", "01");
		props.put("subsaccno", "55555555");
		props.put("retudate", "20150904");

		try {
			HResponse response = tc2RepaymentApply.serve(request);
			System.out.println(response.getRespMessage());
		} catch (Exception e) {
			System.out.println(e.getStackTrace());
		}
	}
}
