/**
 * 
 *	哈尔滨银行
 * Copyright (c) 2007-2015 HRBB,Inc.All Rights Reserved.
 */
package com.hrbb.loan.pos.biz.backstage.inter;

import java.util.List;
import java.util.Map;

import com.hrbb.loan.pos.dao.entity.TSmsTemplate;

/**
 * 短信下行接口.
 * 
 * @author xiongshaogang
 * @version $Id: ISmsSenderBiz.java, v 0.1 2015年4月29日 下午7:29:10 xiongshaogang Exp $
 */
public interface ISmsSenderBiz {

    public TSmsTemplate getSmsTemplate(String tempId);
    
    public void insertSmsMessage(String tempId, String mobile, String sendContent);
    
    public void insertSmsMessageHist(String tempId, String mobile, String sendContent);
    
    public List<Map<String, Object>> getAllSmsMessage();
    
    public void deleteSmsMessage(Integer id);
    
    /**
     * @param filePath 上传的文件绝对路径
     */
    void batchSmsSend(String filePath);
}
