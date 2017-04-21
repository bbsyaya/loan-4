/**
 * 
 *	哈尔滨银行
 * Copyright (c) 2007-2015 HRBB,Inc.All Rights Reserved.
 */
package com.hrbb.loan.pos.service.impl;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Service;

import com.hrbb.loan.pos.dao.TDueDiligenceDao;
import com.hrbb.loan.pos.dao.entity.TDueDiligence;
import com.hrbb.loan.pos.service.DueDiligenceService;
import com.hrbb.loan.pos.util.constants.DueDiligenceConstants;

/**
 * 
 * @author marco
 * @version $Id: DueDiligenceServiceImpl.java, v 0.1 2015-3-2 下午7:38:30 marco
 *          Exp $
 */
@Service("dueDiligenceService")
public class DueDiligenceServiceImpl implements DueDiligenceService {

	@Autowired
	@Qualifier("tDueDiligenceDao")
	private TDueDiligenceDao tDueDiligenceDao;

	/**
	 * @see com.hrbb.loan.pos.service.DueDiligenceService#selectByPrimaryKey(java.lang.String)
	 */
	@Override
	public TDueDiligence selectByPrimaryKey(String loanid) {
		
		TDueDiligence dd = tDueDiligenceDao.selectByPrimaryKey(loanid);
		if (dd == null) {
			return new TDueDiligence();
		} else {
			if (DueDiligenceConstants.CHECK_OK_CODE.equals(dd.getSeasonal())) {
				dd.setSeasonal(DueDiligenceConstants.CHECK_OK_MSG);
			} else {
				dd.setSeasonal(DueDiligenceConstants.CHECK_NG_MSG);
			}
			if (DueDiligenceConstants.CHECK_OK_CODE.equals(dd.getChecklicense())) {
				dd.setChecklicense(DueDiligenceConstants.CHECK_OK_MSG);
			} else {
				dd.setChecklicense(DueDiligenceConstants.CHECK_NG_MSG);
			}
			if (DueDiligenceConstants.CHECK_OK_CODE.equals(dd.getCheckpos())) {
				dd.setCheckpos(DueDiligenceConstants.CHECK_OK_MSG);
			} else {
				dd.setCheckpos(DueDiligenceConstants.CHECK_NG_MSG);
			}
			if (DueDiligenceConstants.CHECK_OK_CODE.equals(dd.getCheckid())) {
				dd.setCheckid(DueDiligenceConstants.CHECK_OK_MSG);
			} else {
				dd.setCheckid(DueDiligenceConstants.CHECK_NG_MSG);
			}
			if (DueDiligenceConstants.CHECK_OK_CODE.equals(dd.getCheckpremises())) {
				dd.setCheckpremises(DueDiligenceConstants.CHECK_OK_MSG);
			} else {
				dd.setCheckpremises(DueDiligenceConstants.CHECK_NG_MSG);
			}
			if (DueDiligenceConstants.CHECK_OK_CODE.equals(dd.getCheckhouse())) {
				dd.setCheckhouse(DueDiligenceConstants.CHECK_OK_MSG);
			} else {
				dd.setCheckhouse(DueDiligenceConstants.CHECK_NG_MSG);
			}
			if (DueDiligenceConstants.CHECK_OK_CODE.equals(dd.getCheckphotoatdoor())) {
				dd.setCheckphotoatdoor(DueDiligenceConstants.CHECK_OK_MSG);
			} else {
				dd.setCheckphotoatdoor(DueDiligenceConstants.CHECK_NG_MSG);
			}
			if (DueDiligenceConstants.CHECK_OK_CODE.equals(dd.getCheckagreement())) {
				dd.setCheckagreement(DueDiligenceConstants.CHECK_OK_MSG);
			} else {
				dd.setCheckagreement(DueDiligenceConstants.CHECK_NG_MSG);
			}
			if (DueDiligenceConstants.CHECK_OK_CODE.equals(dd.getCheckphotoinpremises())) {
				dd.setCheckphotoinpremises(DueDiligenceConstants.CHECK_OK_MSG);
			} else {
				dd.setCheckphotoinpremises(DueDiligenceConstants.CHECK_NG_MSG);
			}
			if (DueDiligenceConstants.CHECK_OK_CODE.equals(dd.getCheckform())) {
				dd.setCheckform(DueDiligenceConstants.CHECK_OK_MSG);
			} else {
				dd.setCheckform(DueDiligenceConstants.CHECK_NG_MSG);
			}
			if (DueDiligenceConstants.CHECK_OK_CODE.equals(dd.getCheckphotosign())) {
				dd.setCheckphotosign(DueDiligenceConstants.CHECK_OK_MSG);
			} else {
				dd.setCheckphotosign(DueDiligenceConstants.CHECK_NG_MSG);
			}
		}
		return dd;
	}

	/**
	 * @see com.hrbb.loan.pos.service.DueDiligenceService#insertSelective(com.hrbb.loan.pos.dao.entity.TDueDiligence)
	 */
	@Override
	public int insertSelective(TDueDiligence record) {
		return tDueDiligenceDao.insertSelective(record);
	}

}
