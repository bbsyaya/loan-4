package com.hrbb.loan.pos.dao;

import com.hrbb.loan.pos.dao.entity.TApprovingAmountRateUplimitfig;

public interface TApprovingAmountRateUplimitfigMapper {
    int deleteByPrimaryKey(Integer id);

    int insert(TApprovingAmountRateUplimitfig record);

    int insertSelective(TApprovingAmountRateUplimitfig record);

    TApprovingAmountRateUplimitfig selectByPrimaryKey(Integer id);

    int updateByPrimaryKeySelective(TApprovingAmountRateUplimitfig record);

    int updateByPrimaryKey(TApprovingAmountRateUplimitfig record);
}