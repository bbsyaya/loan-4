/**
 * 
 *	哈尔滨银行
 * Copyright (c) 2007-2015 HRBB,Inc.All Rights Reserved.
 */
package com.hrbb.loan.pos.biz.backstage.inter;

import java.util.List;
import java.util.Map;

import com.hrbb.loan.pos.dao.entity.TCreditApply;

/**
 * 
 * @author marco
 * @version $Id: TReviewNoteBiz.java, v 0.1 2015-3-2 下午3:26:50 marco Exp $
 */
public interface CreditApplyForReviewBiz {

	public TCreditApply selectOne(String loanid);

	public Map<String, Object> selectForRiskDetectionByOne(String loanid);

	public List<TCreditApply> selectSelective(TCreditApply ca);

	public long selectSelectiveCount(TCreditApply ca);

	public Map<String, Object> claim(TCreditApply ca);

	public Map<String, Object> doNotClaim(TCreditApply ca);

	public int updateApplyStatus(TCreditApply ca);

	public Map<String, Object> reconsider(TCreditApply ca);
}
