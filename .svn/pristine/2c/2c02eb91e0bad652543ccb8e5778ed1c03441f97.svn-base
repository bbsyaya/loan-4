/**
 * 
 *	哈尔滨银行
 * Copyright (c) 2007-2015 HRBB,Inc.All Rights Reserved.
 */
package com.hrbb.loan.pos.service;

import java.util.List;
import java.util.Map;

import com.hrbb.loan.pos.dao.entity.TCreditReportBrief;
import com.hrbb.loan.pos.dao.entity.TCreditReportPool;

/**
 * 
 * @author marco
 * @version $Id: CreditReportService.java, v 0.1 2015-3-2 下午1:53:36 marco Exp $
 */
public interface CreditReportService {

	public int checkCreditReport(String paperId);
	
	public TCreditReportBrief getBrief(String paperId);
	
	public List<TCreditReportPool> getCreditReportPool(Map<String, Object> reqMap);
	
	public int updateCreditReportPool(TCreditReportPool record);
	
	public int insertCreditReportPool(TCreditReportPool record);

}
