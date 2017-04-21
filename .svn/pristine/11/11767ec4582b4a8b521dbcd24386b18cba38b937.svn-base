/**
 * 
 *	哈尔滨银行
 * Copyright (c) 2007-2015 HRBB,Inc.All Rights Reserved.
 */
package com.hrbb.test;

import org.junit.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;

import com.hrbb.loan.pos.dao.entity.TCreditApplyAprvInfo;
import com.hrbb.loan.pos.service.CreditApplyAprvInfoService;

/**
 * 
 * @author marco
 * @version $Id: CreditApplyAprvInfoServiceImplTest.java, v 0.1 2015-4-29
 *          下午1:32:01 marco Exp $
 */
public class CreditApplyAprvInfoServiceImplTest extends UnitTest {

	@Autowired
	@Qualifier("creditApplyAprvInfoService")
	private CreditApplyAprvInfoService creditApplyAprvInfoService;

	@Test
	public void testServe() {
		TCreditApplyAprvInfo record = new TCreditApplyAprvInfo();
		record.setLoanId("LO2015041611171343865342032000");
		record.setApprvId("guoyu0");
		record.setApprInfo("郭宇测试审批拒绝");
		int flag = creditApplyAprvInfoService.updateCreditApplyRefuse(record);
		if (flag == 1) {
			// 操作成功
		} else {
			// 操作失败
		}
	}
}
