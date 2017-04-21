package com.hrbb.loan.pos.dao.impl;

import java.util.List;
import java.util.Map;

import org.mybatis.spring.support.SqlSessionDaoSupport;
import org.springframework.stereotype.Repository;

import com.hrbb.loan.pos.dao.TCfgCnapsInfoDao;
import com.hrbb.loan.pos.dao.entity.TCfgCnapsInfo;

@Repository("tCfgCnapsInfoDao")
public class TCfgCnapsInfoDaoImpl extends SqlSessionDaoSupport implements TCfgCnapsInfoDao {

    @Override
    public int deleteByPrimaryKey(Integer id) {
        return 0;
    }

    @Override
    public int insert(TCfgCnapsInfo record) {
        return 0;
    }

    @Override
    public int insertSelective(TCfgCnapsInfo record) {
        return 0;
    }

    @Override
    public TCfgCnapsInfo selectByPrimaryKey(Integer id) {
        return null;
    }

    @Override
    public int updateByPrimaryKeySelective(TCfgCnapsInfo record) {
        return 0;
    }

    @Override
    public int updateByPrimaryKey(TCfgCnapsInfo record) {
        return 0;
    }

    @Override
    public List<TCfgCnapsInfo> getBankInfoBySelective(Map<String, Object> reqMap) {
        return getSqlSession().selectList("TCfgCnapsInfoMapper.getBankInfoBySelective", reqMap);
    }

}
