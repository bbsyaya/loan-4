package com.hrbb.loan.pos.service.impl;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Service;

import com.hrbb.loan.pos.dao.TFtpManageDao;
import com.hrbb.loan.pos.dao.entity.TFtpManage;
import com.hrbb.loan.pos.service.LoanPosFtpManageService;

/**
 * ftp管理实现.
 * 
 * @author xiongshaogang
 * @version $Id: LoanPosFtpManageServiceImpl.java, v 0.1 2015年3月16日 下午4:24:22 xiongshaogang Exp $
 */
@Service("loanPosFtpManageService")
public class LoanPosFtpManageServiceImpl implements LoanPosFtpManageService {

    @Autowired
    @Qualifier("tFtpManageDao")
    private TFtpManageDao tFtpManageDao;
    
    @Override
    public TFtpManage getFtpManageByNo(String instno) {
        TFtpManage tFtpManage = tFtpManageDao.selectByPrimaryKey(instno);
        if (tFtpManage != null && tFtpManage.getStat() == 1) {
            return tFtpManage;
        }
        return null;
    }
}
