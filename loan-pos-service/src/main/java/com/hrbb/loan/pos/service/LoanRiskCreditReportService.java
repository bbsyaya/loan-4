/**
 * 
 *	哈尔滨银行
 * Copyright (c) 2007-2015 HRBB,Inc.All Rights Reserved.
 */
package com.hrbb.loan.pos.service;

import com.hrbb.loan.pos.dao.entity.TCreditReportIndicator;

/**
 * 查询征信报告信息，转换为需要的格式
 * 
 * @author XLY
 * @version $Id: TCreditReportService.java, v 0.1 2015-3-11 上午9:42:31 XLY Exp $
 */
public interface LoanRiskCreditReportService {

	/**
	 * 根据客户或者商户查询对应的征信报告
	 * 
	 * @param customerId
	 * @param merchantId
	 * @return
	 */
	TCreditReportIndicator queryAndInsertCreditReport(String paperId);

	int insert(TCreditReportIndicator record);

	int delete(String reportNo);
}
