package com.hrbb.loan.pos.dao;

import com.hrbb.loan.pos.dao.entity.TUserApprInfo;

public interface TUserApprInfoDao {
    int deleteByPrimaryKey(String userName);

    int insert(TUserApprInfo record);

    int insertSelective(TUserApprInfo record);

    TUserApprInfo selectByPrimaryKey(String userName);

    int updateByPrimaryKeySelective(TUserApprInfo record);

    int updateByPrimaryKey(TUserApprInfo record);
}