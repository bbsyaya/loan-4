package com.hrbb.loan.pos.dao;

import com.hrbb.loan.pos.dao.entity.TLoanUser;

public interface TLoanUserDao {
    int deleteByPrimaryKey(String loanId);

    int insert(TLoanUser record);

    int insertSelective(TLoanUser record);

    TLoanUser selectByPrimaryKey(String loanId);

    int updateByPrimaryKeySelective(TLoanUser record);

    int updateByPrimaryKey(TLoanUser record);
}