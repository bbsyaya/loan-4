package com.hrbb.loan.pos.dao.impl;

import org.mybatis.spring.support.SqlSessionDaoSupport;
import org.springframework.stereotype.Repository;

import com.hrbb.loan.pos.dao.TDrivinglicenseInfoDao;
import com.hrbb.loan.pos.dao.entity.TDrivinglicenseInfo;

/**
 * 
 * 
 * @author xiongshaogang
 * @version $Id: TDrivinglicenseInfoDaoImpl.java, v 0.1 2015年4月28日 下午1:28:40 xiongshaogang Exp $
 */
@Repository("tDrivinglicenseInfoDao")
public class TDrivinglicenseInfoDaoImpl extends SqlSessionDaoSupport implements TDrivinglicenseInfoDao {

    @Override
    public int deleteByPrimaryKey(String cphm) {
        return 0;
    }

    @Override
    public int insert(TDrivinglicenseInfo record) {
        return getSqlSession().insert("TDrivinglicenseInfoMapper.insert", record);
    }

    @Override
    public int insertSelective(TDrivinglicenseInfo record) {
        return 0;
    }

    @Override
    public TDrivinglicenseInfo selectByPrimaryKey(String cphm) {
        return getSqlSession().selectOne("TDrivinglicenseInfoMapper.selectByPrimaryKey", cphm);
    }

    @Override
    public int updateByPrimaryKeySelective(TDrivinglicenseInfo record) {
        return 0;
    }

    @Override
    public int updateByPrimaryKey(TDrivinglicenseInfo record) {
        return 0;
    }

}
