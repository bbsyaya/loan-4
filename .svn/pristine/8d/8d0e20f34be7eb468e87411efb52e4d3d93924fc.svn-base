package com.hrbb.loan.pos.dao;

import java.util.List;
import java.util.Map;

import com.hrbb.loan.pos.dao.entity.TPaymentApplyTmp;

public interface TPaymentApplyTmpDao {
    int deleteByPrimaryKey(String payApplyId);

    int insert(TPaymentApplyTmp record);

    int insertSelective(TPaymentApplyTmp record);

    TPaymentApplyTmp selectByPrimaryKey(String payApplyId);

    int updateByPrimaryKeySelective(TPaymentApplyTmp record);

    int updateByPrimaryKey(TPaymentApplyTmp record);
    
    List<TPaymentApplyTmp> selectByObj(Map<String, Object> objMap);
    
    public int insertSelectiveMap(Map<String, Object> reqMap);
}