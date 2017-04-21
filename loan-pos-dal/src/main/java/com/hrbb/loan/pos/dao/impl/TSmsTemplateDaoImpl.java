package com.hrbb.loan.pos.dao.impl;

import org.mybatis.spring.support.SqlSessionDaoSupport;
import org.springframework.stereotype.Repository;

import com.hrbb.loan.pos.dao.TSmsTemplateDao;
import com.hrbb.loan.pos.dao.entity.TSmsTemplate;

/**
 * 短信模板实现.
 * 
 * @author xiongshaogang
 * @version $Id: TSmsTemplateDaoImpl.java, v 0.1 2015年4月29日 下午6:59:41 xiongshaogang Exp $
 */
@Repository("tSmsTemplateDao")
public class TSmsTemplateDaoImpl extends SqlSessionDaoSupport implements TSmsTemplateDao {

    @Override
    public int deleteByPrimaryKey(String tempId) {
        return 0;
    }

    @Override
    public int insert(TSmsTemplate record) {
        return 0;
    }

    @Override
    public int insertSelective(TSmsTemplate record) {
        return 0;
    }

    @Override
    public TSmsTemplate selectByPrimaryKey(String tempId) {
        return getSqlSession().selectOne("TSmsTemplateMapper.selectByPrimaryKey", tempId);
    }

    @Override
    public int updateByPrimaryKeySelective(TSmsTemplate record) {
        return 0;
    }

    @Override
    public int updateByPrimaryKey(TSmsTemplate record) {
        return 0;
    }

}
