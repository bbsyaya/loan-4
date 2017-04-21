/**
 * 
 *	哈尔滨银行
 * Copyright (c) 2007-2015 HRBB,Inc.All Rights Reserved.
 */
package com.hrbb.loan.pos.biz.expressions.index;

import com.hrbb.loan.pos.dao.entity.TCreditApply;
import com.hrbb.loan.pos.dao.entity.TCreditReportIndicator;
import com.hrbb.loan.pos.dao.entity.TPosCustInfo;
import com.hrbb.loan.pos.dao.entity.TRiskCheckCalcIndex;
import com.hrbb.loan.pos.dao.entity.TRiskCheckModelIndex;

/**
 * 
 * @author XLY
 * @version $Id: InitCalcIndexComputer.java, v 0.1 2015-3-10 下午5:05:30 XLY Exp $
 */
public class InitCalcIndexComputer {

	/**
	 * 
	 * 
	 * @param modelIndexBean
	 * @param posChannel
	 * @param crWorkOrg1
	 * @param crWorkOrg2
	 * @param crWorkOrg3
	 * @return
	 */
	public static TRiskCheckCalcIndex initCalcIndexBean(
			TRiskCheckModelIndex modelIndexBean, TCreditApply tCreditApply,
			TCreditReportIndicator crBean, TPosCustInfo tPosCustInfo) {
		TRiskCheckCalcIndex c = new TRiskCheckCalcIndex();
		IndexFormula1_10.computer(modelIndexBean, c);
		IndexFormula11_20
				.computer(modelIndexBean, c, tCreditApply.getChannel());
		IndexFormula21_30.computer(modelIndexBean, c,
				tCreditApply.getChannel(), crBean, tPosCustInfo);
		IndexFormula31_36.computer(modelIndexBean, c, crBean,
				tCreditApply.getRegion());
		return c;
	}
}
