package com.hrbb.loan.pos.dao.impl;

import org.mybatis.spring.support.SqlSessionDaoSupport;
import org.springframework.stereotype.Repository;

import com.hrbb.loan.pos.dao.TCallbackRecordDao;
import com.hrbb.loan.pos.dao.entity.TCallbackRecord;

/**
 * @author zhangwei5@hrbb.com.cn
 * @date 2015年9月17日下午5:14:59 
 */
@Repository("tCallbackRecordDao")
public class TCallbackRecordDaoImpl extends SqlSessionDaoSupport implements TCallbackRecordDao {

    /* (non-Javadoc)
     * @see com.hrbb.loan.pos.dao.TCallbackRecordDao#deleteByPrimaryKey(java.lang.Integer)
     */
    @Override
    public int deleteByPrimaryKey(Integer id) {
        return getSqlSession().delete("TCallbackRecordMapper.deleteByPrimaryKey",id);
    }

    /* (non-Javadoc)
     * @see com.hrbb.loan.pos.dao.TCallbackRecordDao#insert(com.hrbb.loan.pos.dao.entity.TCallbackRecord)
     */
    @Override
    public int insert(TCallbackRecord record) {
        return getSqlSession().insert("TCallbackRecordMapper.insert",record);
    }

    /* save record for selective option
     * @param TCallbackRecord record
     */
    @Override
    public int insertSelective(TCallbackRecord record) {
        return getSqlSession().insert("TCallbackRecordMapper.insertSelective", record);
    }

    /* (non-Javadoc)
     * @see com.hrbb.loan.pos.dao.TCallbackRecordDao#selectByPrimaryKey(java.lang.Integer)
     */
    @Override
    public TCallbackRecord selectByPrimaryKey(Integer id) {
        return getSqlSession().selectOne("TCallbackRecordMapper.selectByPrimaryKey", id);
    }

    /* (non-Javadoc)
     * @see com.hrbb.loan.pos.dao.TCallbackRecordDao#updateByPrimaryKeySelective(com.hrbb.loan.pos.dao.entity.TCallbackRecord)
     */
    @Override
    public int updateByPrimaryKeySelective(TCallbackRecord record) {
        return getSqlSession().update("TCallbackRecordMapper.updateByPrimaryKeySelective", record);
    }

    /* (non-Javadoc)
     * @see com.hrbb.loan.pos.dao.TCallbackRecordDao#updateByPrimaryKey(com.hrbb.loan.pos.dao.entity.TCallbackRecord)
     */
    @Override
    public int updateByPrimaryKey(TCallbackRecord record) {
        return getSqlSession().update("TCallbackRecordMapper.updateByPrimaryKey",record);
    }

}
