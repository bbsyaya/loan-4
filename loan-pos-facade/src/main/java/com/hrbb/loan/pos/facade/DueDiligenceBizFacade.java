/**
 * 
 *	哈尔滨银行
 * Copyright (c) 2007-2015 HRBB,Inc.All Rights Reserved.
 */
package com.hrbb.loan.pos.facade;

import com.hrbb.loan.pos.dao.entity.TDueDiligence;
import com.hrbb.loan.pos.facade.bean.DueDiligenceReq;

/**
 * 
 * @author marco
 * @version $Id: DueDiligenceBizFacade.java, v 0.1 2015-3-2 下午7:42:24 marco Exp $
 */
public interface DueDiligenceBizFacade {
	  int insertSelective(DueDiligenceReq record);
	  

	  public TDueDiligence selectByPrimaryKey(String loanid);
}
