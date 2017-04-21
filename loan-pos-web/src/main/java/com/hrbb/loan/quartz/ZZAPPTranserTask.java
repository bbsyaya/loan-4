/**
 * 
 *	哈尔滨银行
 * Copyright (c) 2007-2015 HRBB,Inc.All Rights Reserved.
 */
package com.hrbb.loan.quartz;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import com.hrbb.loan.pos.biz.backstage.inter.ZZAppTranserTaskBiz;

/**
 * 
 * @author maosheng
 * @version $Id: TranserTask.java, v 0.1 2015-5-15 下午2:34:27 maosheng Exp $
 */
@Component("transerTask")
public class ZZAPPTranserTask {
    
    @Autowired
    private ZZAppTranserTaskBiz zzAppTranserTaskBiz;
    
    public void execute() {
        zzAppTranserTaskBiz.transer();
    }
    

}
