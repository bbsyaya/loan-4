package com.hrbb.loan.pos.dao.impl;

import org.mybatis.spring.support.SqlSessionDaoSupport;
import org.springframework.stereotype.Repository;

import com.hrbb.loan.pos.dao.TUpsBillcardstatQueryInfoDao;
import com.hrbb.loan.pos.dao.entity.TUpsBillcardstatQueryInfo;

@Repository("upsBillcardstatQueryInfoDaoImpl")
public class TUpsBillcardstatQueryInfoDaoImpl extends SqlSessionDaoSupport implements TUpsBillcardstatQueryInfoDao {

    @Override
    public int insert(TUpsBillcardstatQueryInfo tUpsBillcardstatQueryInfo) {
        return getSqlSession().insert("TUpsBillcardstatQueryInfoMapper.insertSelective", tUpsBillcardstatQueryInfo);
    }

    @Override
    public TUpsBillcardstatQueryInfo getRecentlyQueryInfo(String bankAccno) {
        return getSqlSession().selectOne("TUpsBillcardstatQueryInfoMapper.getRecentlyQueryInfo",bankAccno);
    }

}
