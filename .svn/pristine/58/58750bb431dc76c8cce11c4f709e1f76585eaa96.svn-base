package com.hrbb.loan.pos.biz.backstage.inter.impl;

import java.util.List;
import java.util.Map;

import org.apache.commons.lang.exception.ExceptionUtils;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import com.google.common.collect.Lists;
import com.hrbb.loan.pos.biz.backstage.inter.ISmsSenderBiz;
import com.hrbb.loan.pos.biz.backstage.inter.impl.reader.SmsRowReader;
import com.hrbb.loan.pos.dao.entity.TSmsMessage;
import com.hrbb.loan.pos.dao.entity.TSmsTemplate;
import com.hrbb.loan.pos.service.CommSmsTemplateService;
import com.hrbb.loan.pos.service.SendSmsMessageService;
import com.hrbb.loan.pos.util.ListUtil;
import com.hrbb.loan.pos.util.excel.ExcelReaderUtil;

/**
 * 短信下行业务处理通道.
 * 
 * @author xiongshaogang
 * @version $Id: SmsSenderBizImpl.java, v 0.1 2015年4月29日 下午7:32:40 xiongshaogang Exp $
 */
@Component("iSmsSenderBiz")
public class SmsSenderBizImpl implements ISmsSenderBiz {
    
    private static final Logger LOGGER = LoggerFactory.getLogger(SmsSenderBizImpl.class);

    @Autowired
    private CommSmsTemplateService commSmsTemplateService;
    
    @Autowired
    private SendSmsMessageService sendSmsMessageService;
    
    @Override
    public TSmsTemplate getSmsTemplate(String tempId) {
        return commSmsTemplateService.queryTSmsTemplateByTempId(tempId);
    }

	@Override
	public void insertSmsMessage(String tempId, String mobile, String sendContent) {
		sendSmsMessageService.insertSmsMessage(tempId, mobile, sendContent);
		
	}

	@Override
	public void insertSmsMessageHist(String tempId, String mobile, String sendContent) {
		sendSmsMessageService.insertSmsMessageHist(tempId, mobile, sendContent);
	}

	@Override
	public List<Map<String, Object>> getAllSmsMessage() {
		return sendSmsMessageService.selectAllMessage();
	}

	@Override
	public void deleteSmsMessage(Integer id) {
		sendSmsMessageService.deleteSmsMessage(id);
		
	}

    public void batchSmsSend(String filePath) {
        List<TSmsMessage> messages = Lists.newArrayList();
        SmsRowReader reader = new SmsRowReader();
        reader.addHandleList(messages);
        reader.addService(sendSmsMessageService);
        try {
            ExcelReaderUtil.readExcel(reader, filePath);
            if (ListUtil.isNotEmpty(messages)) {
                sendSmsMessageService.batchInsertSmsMessage(messages);
                messages.clear();
            }
        } catch (Exception e) {
            LOGGER.error(ExceptionUtils.getFullStackTrace(e));
        }
    }
    
    
    

}
