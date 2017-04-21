package com.hrbb.loan.pos.service.impl;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Service;

import com.hrbb.loan.pos.dao.TDueDiligenceDao;
import com.hrbb.loan.pos.dao.entity.TDueDiligence;
import com.hrbb.loan.pos.service.CommDueDiligenceService;

/**
 * 尽调任务结果反馈.
 * 
 * @author xiongshaogang
 * @version $Id: CommDueDiligenceServiceImpl.java, v 0.1 2015年5月6日 下午7:49:55 xiongshaogang Exp $
 */
@Service("commDueDiligenceService")
public class CommDueDiligenceServiceImpl implements CommDueDiligenceService {

    @Autowired
    @Qualifier("tDueDiligenceDao")
    private TDueDiligenceDao tDueDiligenceDao;
    
    @Override
    public int insert(TDueDiligence record) {
        return tDueDiligenceDao.insert(record);
    }
    
    public TDueDiligence selectByLoanId(String loanId) {
        return tDueDiligenceDao.selectByPrimaryKey(loanId);
    }

}
