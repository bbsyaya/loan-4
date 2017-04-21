/**
 * 
 *哈尔滨银行
 * Copyright (c) 2007-2015 HRBB,Inc.All Rights Reserved.
 */
package com.hrbb.loan.pos.biz.convert;

import com.hrbb.loan.pos.dao.entity.TDueDiligence;
import com.hrbb.loan.pos.facade.bean.DueDiligenceReq;

/**
 * 
 * @author marco
 * @version $Id: DueDiligenceAddConvert.java, v 0.1 2015-3-2 下午7:53:05 marco Exp
 *          $
 */
public class DueDiligenceAddConvert {

	public static TDueDiligence DueDiligenceReq2TDueDiligence(
			DueDiligenceReq req) {
		TDueDiligence dd = new TDueDiligence();
		dd.setLoanid(req.getLoanid());
		dd.setWorkcorp(req.getWorkcorp());
		dd.setApplydate(req.getApplydate());
		dd.setSurveydate(req.getSurveydate());
		dd.setInvestigatorname(req.getInvestigatorname());
		dd.setInvestigatorid(req.getInvestigatorid());
		dd.setEnterprisename(req.getEnterprisename());
		dd.setApplicantname(req.getApplicantname());
		dd.setApplicantid(req.getApplicantid());
		dd.setAnnualturnover(req.getAnnualturnover());
		dd.setSeasonal(req.getSeasonal());
		dd.setPeakseason(req.getPeakseason());
		dd.setOffseason(req.getOffseason());
		dd.setChecklicense(req.getChecklicense());
		dd.setCheckpos(req.getCheckpos());
		dd.setCheckid(req.getCheckid());
		dd.setCheckpremises(req.getCheckpremises());
		dd.setCheckhouse(req.getCheckhouse());
		dd.setCheckphotoatdoor(req.getCheckphotoatdoor());
		dd.setCheckagreement(req.getCheckagreement());
		dd.setCheckphotoinpremises(req.getCheckphotoinpremises());
		dd.setCheckform(req.getCheckform());
		dd.setCheckphotosign(req.getCheckphotosign());
		dd.setNote(req.getNote());
		dd.setOpinion(req.getOpinion());
		return dd;
	}
}
