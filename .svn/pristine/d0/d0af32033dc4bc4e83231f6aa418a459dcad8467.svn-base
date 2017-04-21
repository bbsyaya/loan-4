/**
 * 
 *	哈尔滨银行
 * Copyright (c) 2007-2015 HRBB,Inc.All Rights Reserved.
 */
package com.hrbb.loan.pos.service;

import java.util.List;
import java.util.Map;

import com.hrbb.loan.pos.dao.entity.TCreditApply;

/**
 * 
 * @author marco
 * @version $Id: CreditApplyForReviewService.java, v 0.1 2015-3-2 下午1:53:36
 *          marco Exp $
 */
public interface CreditApplyForReviewService {

	public TCreditApply selectOne(String loanid);

	public Map<String, Object> selectForRiskDetectionByOne(String loanid);

	public List<TCreditApply> selectSelective(TCreditApply ca);

	public long selectSelectiveCount(TCreditApply ca);

	public Map<String, Object> claim(TCreditApply ca);

	public Map<String, Object> doNotClaim(TCreditApply ca);

	public int updateByPrimaryKeySelective(TCreditApply ca);

	int updateApplyStatusForDownloadImages(TCreditApply ca);

	public Map<String, Object> reconsider(TCreditApply ca);

	public List<Map<String, String>> selectNewCustCountForUM(
			Map<String, String> p);

	public List<Map<String, Object>> selectSummary1(Map<String, String> p);

	public List<Map<String, Object>> selectSummary2(Map<String, String> p);

	public List<Map<String, Object>> selectSummary3(Map<String, String> p);

	public List<Map<String, Object>> selectSummary4(Map<String, String> p);

	public List<Map<String, Object>> selectSummary5(Map<String, String> p);

	public List<Map<String, Object>> selectSummary0(Map<String, String> p);

	public List<Map<String, Object>> selectSummaryBase(Map<String, String> p);
}
