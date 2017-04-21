package com.hrbb.loan.pos.dao;

import com.hrbb.loan.pos.dao.entity.TDrivinglicenseInfo;

public interface TDrivinglicenseInfoDao {
    int deleteByPrimaryKey(String cphm);

    int insert(TDrivinglicenseInfo record);

    int insertSelective(TDrivinglicenseInfo record);

    TDrivinglicenseInfo selectByPrimaryKey(String cphm);

    int updateByPrimaryKeySelective(TDrivinglicenseInfo record);

    int updateByPrimaryKey(TDrivinglicenseInfo record);
}