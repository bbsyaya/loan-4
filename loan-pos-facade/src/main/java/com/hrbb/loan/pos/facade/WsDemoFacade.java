/**
 * 
 *	哈尔滨银行
 * Copyright (c) 2007-2015 HRBB,Inc.All Rights Reserved.
 */
package com.hrbb.loan.pos.facade;

import javax.jws.WebService;

/**
 * 
 * @author XLY
 * @version $Id: WsDemoFacade.java, v 0.1 2015-3-2 下午3:50:15 XLY Exp $
 */
@WebService
public interface WsDemoFacade {

    String getHelloworld(String hello);
}
