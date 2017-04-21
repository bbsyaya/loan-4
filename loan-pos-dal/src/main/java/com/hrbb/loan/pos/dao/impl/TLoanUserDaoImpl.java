package com.hrbb.loan.pos.dao.impl;

import org.mybatis.spring.support.SqlSessionDaoSupport;
import org.springframework.stereotype.Repository;

import com.hrbb.loan.pos.dao.TLoanUserDao;
import com.hrbb.loan.pos.dao.entity.TLoanUser;
/**
 * 贷款业务与用户对照表
 * @author litengfeng
 * @version $Id: TLoanUserDaoImpl.java, v 0.1 2015年5月13日 下午4:10:22 litengfeng Exp $
 */
@Repository("tLoanUserDao")
public class TLoanUserDaoImpl extends SqlSessionDaoSupport implements TLoanUserDao{

    @Override
    public int deleteByPrimaryKey(String loanId) {
        return 0;
    }

    @Override
    public int insert(TLoanUser record) {
        return this.getSqlSession().insert("TLoanUserMapper.insert", record);
    }

    @Override
    public int insertSelective(TLoanUser record) {
        return this.getSqlSession().insert("TLoanUserMapper.insertSelective", record);
    }

    @Override
    public TLoanUser selectByPrimaryKey(String loanId) {
        return null;
    }

    @Override
    public int updateByPrimaryKeySelective(TLoanUser record) {
        return 0;
    }

    @Override
    public int updateByPrimaryKey(TLoanUser record) {
        return 0;
    }

}
