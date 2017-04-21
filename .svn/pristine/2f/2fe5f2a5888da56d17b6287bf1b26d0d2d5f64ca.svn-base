/**
 * 
 *	哈尔滨银行
 * Copyright (c) 2007-2015 HRBB,Inc.All Rights Reserved.
 */
package com.hrbb.loan.pos.biz.backstage.inter.impl;

import java.util.List;
import java.util.Map;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Component;

import com.hrbb.loan.pos.biz.backstage.inter.CreditApplyForReviewBiz;
import com.hrbb.loan.pos.dao.entity.TCreditApply;
import com.hrbb.loan.pos.service.CreditApplyForReviewService;

/**
 * 
 * @author marco
 * @version $Id: TReviewNoteBiz.java, v 0.1 2015-3-2 下午3:26:50 marco Exp $
 */
@Component("creditApplyForReviewBiz")
public class CreditApplyForReviewBizImpl implements CreditApplyForReviewBiz {

	private Logger LOG = LoggerFactory
			.getLogger(CreditApplyForReviewBizImpl.class);

	@Autowired
	@Qualifier("creditApplyForReviewService")
	private CreditApplyForReviewService service;

	/**
	 * @see com.hrbb.loan.pos.biz.backstage.inter.CreditApplyForReviewBiz#getReviewNoteInfoSelective(com.hrbb.loan.pos.dao.entity.TCreditApply)
	 */
	@Override
	public TCreditApply selectOne(String loanid) {
		return service.selectOne(loanid);
	}
	
	/**
	 * @see com.hrbb.loan.pos.biz.backstage.inter.CreditApplyForReviewBiz#selectForRiskDetectionByOne(com.hrbb.loan.pos.dao.entity.TCreditApply)
	 */
	@Override
	public Map<String, Object> selectForRiskDetectionByOne(String loanid) {
		return service.selectForRiskDetectionByOne(loanid);
	}

	/**
	 * @see com.hrbb.loan.pos.biz.backstage.inter.CreditApplyForReviewBiz#getReviewNoteInfoSelective(com.hrbb.loan.pos.dao.entity.TCreditApply)
	 */
	@Override
	public List<TCreditApply> selectSelective(TCreditApply ca) {
		return service.selectSelective(ca);
	}
	
	/**
	 * @see com.hrbb.loan.pos.biz.backstage.inter.CreditApplyForReviewBiz#getReviewNoteInfoSelective(com.hrbb.loan.pos.dao.entity.TCreditApply)
	 */
	@Override
	public long selectSelectiveCount(TCreditApply ca) {
		return service.selectSelectiveCount(ca);
	}

	/**
	 * @see com.hrbb.loan.pos.biz.backstage.inter.CreditApplyForReviewBiz#claim(com.hrbb.loan.pos.dao.entity.TCreditApply)
	 */
	@Override
	public Map<String, Object> claim(TCreditApply ca) {
		return service.claim(ca);
	}

	/**
	 * @see com.hrbb.loan.pos.biz.backstage.inter.CreditApplyForReviewBiz#doNotclaim(com.hrbb.loan.pos.dao.entity.TCreditApply)
	 */
	@Override
	public Map<String, Object> doNotClaim(TCreditApply ca) {
		return service.doNotClaim(ca);
	}

	@Override
	public int updateApplyStatus(TCreditApply ca) {
		// TODO Auto-generated method stub
		return service.updateApplyStatusForDownloadImages(ca);
	}
	
	/**
	 * @see com.hrbb.loan.pos.biz.backstage.inter.CreditApplyForReviewBiz#reconsider(com.hrbb.loan.pos.dao.entity.TCreditApply)
	 */
	@Override
	public Map<String, Object> reconsider(TCreditApply ca)  {
		return service.reconsider(ca);
	}
}
