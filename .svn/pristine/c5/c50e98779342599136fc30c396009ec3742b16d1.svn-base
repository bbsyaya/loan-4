/**
 * 
 *	哈尔滨银行
 * Copyright (c) 2007-2015 HRBB,Inc.All Rights Reserved.
 */
package com.hrbb.loan.pos.facade.abs;

import java.io.Serializable;

/**
 * 
 * @author XLY
 * @version $Id: AbsQueryRequest.java, v 0.1 2015-2-16 下午1:46:44 XLY Exp $
 */
public abstract class AbstractRequest implements Serializable{

    /**  */
    private static final long serialVersionUID = 152438228766239671L;
    
    /**调用方的子系统Id，*/
    private String clientSource;

    /**调用方服务器IP，自动生成不需要设置.*/
    private String clientIp;

    /**调用方使用的Facade版本信息.*/
    private String facadeVersion;
    
    private String oprName;
    
    private String oprId;

    public String getClientSource() {
        return clientSource;
    }

    public void setClientSource(String clientSource) {
        this.clientSource = clientSource;
    }

    public String getClientIp() {
        return clientIp;
    }

    public void setClientIp(String clientIp) {
        this.clientIp = clientIp;
    }

    public String getFacadeVersion() {
        return facadeVersion;
    }

    public void setFacadeVersion(String facadeVersion) {
        this.facadeVersion = facadeVersion;
    }

    public String getOprName() {
        return oprName;
    }

    public void setOprName(String oprName) {
        this.oprName = oprName;
    }

    public String getOprId() {
        return oprId;
    }

    public void setOprId(String oprId) {
        this.oprId = oprId;
    }

    @Override
    public String toString() {
        return "AbstractRequest [clientSource=" + clientSource + ", clientIp=" + clientIp
               + ", facadeVersion=" + facadeVersion + "]";
    }
    
    

}
