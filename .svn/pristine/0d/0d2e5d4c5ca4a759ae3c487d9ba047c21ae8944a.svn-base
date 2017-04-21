package com.hrbb.test;

import java.util.Map;

import org.junit.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;

import com.hrbb.sh.framework.HRequest;
import com.hrbb.sh.framework.HResponse;
import com.hrbb.sh.framework.HService;

public class TC2AddCautionMoneyHServiceTest extends UnitTest {

	@Autowired
	@Qualifier("TC2AddCautionMoney")
	private HService service;

	@Test
	public void umCreditApplyHServiceTest() {
		HRequest request = new HRequest();
		Map<String, Object> props = request.getProperties();

		props.put("issusid", "PY2015082520411372848753961000");
		props.put("accountno", "585858");
		props.put("schedamt", "1292.70");
		props.put("actulamt", "5000.00");
		props.put("deposittime", "20150825 184001");

		try {
			HResponse response = service.serve(request);
			System.out.println(response.getRespMessage());
		} catch (Exception e) {
			System.out.println(e.getStackTrace());
		}
	}
}
