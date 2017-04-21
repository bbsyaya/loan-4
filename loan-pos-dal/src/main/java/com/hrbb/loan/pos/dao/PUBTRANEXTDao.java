package com.hrbb.loan.pos.dao;

import com.hrbb.loan.pos.dao.entity.payin_batch_pubtranext;

public interface PUBTRANEXTDao {
    int insert(payin_batch_pubtranext record);

    int insertSelective(payin_batch_pubtranext record);
}