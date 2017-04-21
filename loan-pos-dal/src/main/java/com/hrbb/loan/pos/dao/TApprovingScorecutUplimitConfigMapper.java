package com.hrbb.loan.pos.dao;

import com.hrbb.loan.pos.dao.entity.TApprovingScorecutUplimitConfig;

public interface TApprovingScorecutUplimitConfigMapper {
    int deleteByPrimaryKey(Integer id);

    int insert(TApprovingScorecutUplimitConfig record);

    int insertSelective(TApprovingScorecutUplimitConfig record);

    TApprovingScorecutUplimitConfig selectByPrimaryKey(Integer id);

    int updateByPrimaryKeySelective(TApprovingScorecutUplimitConfig record);

    int updateByPrimaryKey(TApprovingScorecutUplimitConfig record);
}