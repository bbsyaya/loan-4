/**
 * 
 *	哈尔滨银行
 * Copyright (c) 2007-2015 HRBB,Inc.All Rights Reserved.
 */
package com.hrbb.loan.pos.facade.bean.blacklist;

import java.io.Serializable;

import com.hrbb.loan.pos.facade.abs.AbstractRequest;

/**
 * 查询黑名单请求
 * @author XLY
 * @version $Id: QueryBlacklistReq.java, v 0.1 2015-2-28 下午3:09:01 XLY Exp $
 */
public class QueryBlacklistReq extends AbstractRequest implements Serializable{

    /**  */
    private static final long serialVersionUID = -7239345156464649079L;

    private BlacklistInfo blacklistInfo;
    
    /**
     * 每页记录数
     */
    private String pageSize;
    /**
     * 当前页码
     */
    private String pageNum;
    
    public String getPageSize() {
        return pageSize;
    }

    public void setPageSize(String pageSize) {
        this.pageSize = pageSize;
    }

    public BlacklistInfo getBlacklistInfo() {
        return blacklistInfo;
    }

    public void setBlacklistInfo(BlacklistInfo blacklistInfo) {
        this.blacklistInfo = blacklistInfo;
    }

    public String getPageNum() {
        return pageNum;
    }

    public void setPageNum(String pageNum) {
        this.pageNum = pageNum;
    }


    
    
}
