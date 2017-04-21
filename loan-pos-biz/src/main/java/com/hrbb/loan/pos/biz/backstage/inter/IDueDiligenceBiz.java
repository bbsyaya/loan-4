/**
 * 
 *	哈尔滨银行
 * Copyright (c) 2007-2015 HRBB,Inc.All Rights Reserved.
 */
package com.hrbb.loan.pos.biz.backstage.inter;

import com.hrbb.loan.pos.dao.entity.TDueDiligence;

/**
 * 尽职调查接口.
 * 
 * @author xiongshaogang
 * @version $Id: IDueDiligenceBiz.java, v 0.1 2015年4月29日 下午7:29:10 xiongshaogang Exp $
 */
public interface IDueDiligenceBiz {
    
    public boolean insertDueDiligence(TDueDiligence tDueDiligence);
    
    public void setRespmsg(String respmsg);
    
    public String getRespmsg();
}
