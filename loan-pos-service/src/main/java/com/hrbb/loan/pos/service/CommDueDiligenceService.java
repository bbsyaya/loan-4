/**
 *  哈尔滨银行
 * Copyright (c) 2007-2015 HRBB,Inc.All Rights Reserved.
 */
package com.hrbb.loan.pos.service;


import com.hrbb.loan.pos.dao.entity.TDueDiligence;

/**
 * 
 * 
 * @author xiongshaogang
 * @version $Id: CommDueDiligenceService.java, v 0.1 2015年4月29日 下午7:08:27 xiongshaogang Exp $
 */
public interface CommDueDiligenceService {

    public int insert(TDueDiligence record);
    
    public TDueDiligence selectByLoanId(String loanId);
}
