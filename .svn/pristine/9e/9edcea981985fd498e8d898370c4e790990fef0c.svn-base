/**
 * 
 *	哈尔滨银行
 * Copyright (c) 2007-2015 HRBB,Inc.All Rights Reserved.
 */
package com.hrbb.loan.pos.dao.impl;

import java.util.Map;

import org.mybatis.spring.support.SqlSessionDaoSupport;
import org.springframework.stereotype.Service;

import com.hrbb.loan.pos.dao.TPdfSignatureDao;
import com.hrbb.loan.pos.dao.entity.TPdfSignature;

/**
 * @author yida
 * @date 2015年11月12日 下午6:24:23
 */
@Service("tPdfSignatureDao")
public class TPdfSignatureDaoImpl extends SqlSessionDaoSupport implements TPdfSignatureDao {

    public int deleteByPrimaryKey(String contNo) {
        return 0;
    }

    public int insert(TPdfSignature record) {
        return 0;
    }

    public int insertSelective(TPdfSignature record) {
        return getSqlSession().insert("TPdfSignatureMapper.insertSelective", record);
    }

    public TPdfSignature selectByPrimaryKey(String contNo) {
        return getSqlSession().selectOne("TPdfSignatureMapper.selectByPrimaryKey", contNo);
    }

    public int updateByPrimaryKeySelective(TPdfSignature record) {
        return 0;
    }

    public int updateByPrimaryKeyWithBLOBs(TPdfSignature record) {
        return 0;
    }

    public Map<String, Object> selectSinatureByContNo(String contNo) {
        return getSqlSession().selectOne("TPdfSignatureMapper.selectSinatureByContNo", contNo);
    }

}
