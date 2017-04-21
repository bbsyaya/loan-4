package com.hrbb.loan.pos.dao;

import com.hrbb.loan.pos.dao.entity.payin_batch_pubtrandef;

public interface PubtrandefDao {
    int insert(payin_batch_pubtrandef record);

    int insertSelective(payin_batch_pubtrandef record);
}