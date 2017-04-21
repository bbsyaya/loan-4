package com.hrbb.loan.pos.dao;

import com.hrbb.loan.pos.dao.entity.TRiskCheckCalcIndex;

public interface TRiskCheckCalcIndexDao {
    int deleteByPrimaryKey(String loanId);

    int insert(TRiskCheckCalcIndex record);

    int insertSelective(TRiskCheckCalcIndex record);

    TRiskCheckCalcIndex selectByPrimaryKey(String loanId);

    int updateByPrimaryKeySelective(TRiskCheckCalcIndex record);

    int updateByPrimaryKey(TRiskCheckCalcIndex record);
}