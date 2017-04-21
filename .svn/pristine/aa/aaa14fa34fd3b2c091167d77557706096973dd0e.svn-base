package com.hrbb.loan.pos.dao.impl;

import org.mybatis.spring.support.SqlSessionDaoSupport;
import org.springframework.stereotype.Repository;

import com.hrbb.loan.pos.dao.TFtpManageDao;
import com.hrbb.loan.pos.dao.entity.TFtpManage;

/**
 * FTP管理表DAO实现.
 * 
 * @author xiongshaogang
 * @version $Id: TFtpManageDaoImpl.java, v 0.1 2015年3月16日 下午4:02:45 xiongshaogang Exp $
 */
@Repository("tFtpManageDao")
public class TFtpManageDaoImpl extends SqlSessionDaoSupport implements TFtpManageDao {

    @Override
    public int deleteByPrimaryKey(String instno) {
        return 0;
    }

    @Override
    public int insert(TFtpManage record) {
        return 0;
    }

    @Override
    public int insertSelective(TFtpManage record) {
        return 0;
    }

    @Override
    public TFtpManage selectByPrimaryKey(String instno) {
        Object obj=null;
        try {
            obj = getSqlSession().selectOne("TFtpManageMapper.selectByPrimaryKey", instno);
        } catch (Exception e) {
            e.printStackTrace();
        }
        return (TFtpManage)obj;
    }

    @Override
    public int updateByPrimaryKeySelective(TFtpManage record) {
        return 0;
    }

    @Override
    public int updateByPrimaryKey(TFtpManage record) {
        return 0;
    }
}
