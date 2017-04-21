/**
 *  哈尔滨银行
 * Copyright (c) 2007-2015 HRBB,Inc.All Rights Reserved.
 */
package com.hrbb.loan.pos.service;


import com.hrbb.loan.pos.dao.entity.TFtpManage;

/**
 * ftp服务接口.
 * 
 * @author xiongshaogang
 * @version $Id: LoanPosFtpManageService.java, v 0.1 2015年3月16日 下午4:22:03 xiongshaogang Exp $
 */
public interface LoanPosFtpManageService {

    public TFtpManage getFtpManageByNo(String instno);
}
