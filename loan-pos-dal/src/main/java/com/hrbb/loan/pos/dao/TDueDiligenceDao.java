package com.hrbb.loan.pos.dao;

import com.hrbb.loan.pos.dao.entity.TDueDiligence;

public interface TDueDiligenceDao {

    int deleteByPrimaryKey(String loanid);

    int insert(TDueDiligence record);

    int insertSelective(TDueDiligence record);

    TDueDiligence selectByPrimaryKey(String loanid);

    int updateByPrimaryKeySelective(TDueDiligence record);

    int updateByPrimaryKey(TDueDiligence record);
}