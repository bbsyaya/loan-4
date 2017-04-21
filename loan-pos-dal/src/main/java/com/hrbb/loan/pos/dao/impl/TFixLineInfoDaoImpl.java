package com.hrbb.loan.pos.dao.impl;

import org.mybatis.spring.support.SqlSessionDaoSupport;
import org.springframework.stereotype.Repository;

import com.hrbb.loan.pos.dao.TFixLineInfoDao;
import com.hrbb.loan.pos.dao.entity.TFixLineInfo;

/**
 * @author zhangwei5@hrbb.com.cn
 * @date 2015年10月8日下午6:59:27 
 */
@Repository
public class TFixLineInfoDaoImpl extends SqlSessionDaoSupport implements TFixLineInfoDao {

    public int deleteByPrimaryKey(Integer id) {
        return 0;
    }

    public int insert(TFixLineInfo record) {
        return 0;
    }

    public int insertSelective(TFixLineInfo record) {
        return getSqlSession().insert("TFixLineInfoMapper.insertSelective", record);
    }

    public TFixLineInfo selectByPrimaryKey(Integer id) {
        return null;
    }

    public int updateByPrimaryKeySelective(TFixLineInfo record) {
        return 0;
    }

    public int updateByPrimaryKey(TFixLineInfo record) {
        return 0;
    }

    public TFixLineInfo selectByTelNum(String telNum) {
        return getSqlSession().selectOne("TFixLineInfoMapper.selectByTelNum", telNum);
    }

    public void updateByTelNumSelective(TFixLineInfo record) {
        getSqlSession().update("TFixLineInfoMapper.updateByTelNumSelective", record);
    }

}
