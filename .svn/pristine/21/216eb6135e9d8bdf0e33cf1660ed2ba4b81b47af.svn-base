package com.hrbb.loan.pos.service.impl;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Service;

import com.hrbb.loan.pos.dao.TSmsTemplateDao;
import com.hrbb.loan.pos.dao.entity.TSmsTemplate;
import com.hrbb.loan.pos.service.CommSmsTemplateService;

/**
 * 短信模板服务实现.
 * 
 * @author xiongshaogang
 * @version $Id: CommSmsTemplateServiceImpl.java, v 0.1 2015年4月29日 下午7:10:10 xiongshaogang Exp $
 */
@Service("commSmsTemplateService")
public class CommSmsTemplateServiceImpl implements CommSmsTemplateService {

    @Autowired
    @Qualifier("tSmsTemplateDao")
    private TSmsTemplateDao tSmsTemplateDao;
    
    @Override
    public TSmsTemplate queryTSmsTemplateByTempId(String tempId) {
        return tSmsTemplateDao.selectByPrimaryKey(tempId);
    }
}
