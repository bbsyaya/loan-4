package com.hrbb.loan.pos.integration.common.demo;

import com.hrbb.loan.pos.facade.WsDemoFacade;
import com.hrbb.loan.runtime.ws.BaseWSClient;
/**
 * 调用自身的webservice
 * 
 * @author XLY
 * @version $Id: WsDemoImpl.java, v 0.1 2015-3-2 下午4:16:49 XLY Exp $
 */
public class WsDemoImpl extends BaseWSClient<WsDemoFacade> implements WsDemo{
    
    public String getHello(String hello){
       return this.getBizRemoteBean().getHelloworld(hello);
    }
    
    
}
