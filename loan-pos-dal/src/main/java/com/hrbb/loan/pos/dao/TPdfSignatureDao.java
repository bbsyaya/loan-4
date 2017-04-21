package com.hrbb.loan.pos.dao;

import java.util.Map;

import com.hrbb.loan.pos.dao.entity.TPdfSignature;

public interface TPdfSignatureDao {
    int deleteByPrimaryKey(String contNo);

    int insert(TPdfSignature record);

    int insertSelective(TPdfSignature record);

    TPdfSignature selectByPrimaryKey(String contNo);

    int updateByPrimaryKeySelective(TPdfSignature record);

    int updateByPrimaryKeyWithBLOBs(TPdfSignature record);
    
    Map<String, Object> selectSinatureByContNo(String contNo);
}