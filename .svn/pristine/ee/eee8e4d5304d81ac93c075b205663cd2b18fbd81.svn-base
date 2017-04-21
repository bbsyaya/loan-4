package com.hrbb.loan.sale.service.impl;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.hrbb.loan.pos.dao.TLoanUserDao;
import com.hrbb.loan.pos.dao.entity.TLoanUser;
import com.hrbb.loan.sale.service.LoanUserService;

@Service("loanUserService")
public class LoanUserServiceImpl implements LoanUserService {

    @Autowired
    private TLoanUserDao tLoanUserDao;
    
    @Override
    public int insertTLoanUser(TLoanUser loanUser) {
        return tLoanUserDao.insert(loanUser);
    }

}
