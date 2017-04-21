/**
 * 
 *	哈尔滨银行
 * Copyright (c) 2007-2015 HRBB,Inc.All Rights Reserved.
 */
package com.hrbb.loan.pos.facade.bean.blacklist;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;

import com.hrbb.loan.pos.facade.abs.AbstractResponse;

/**
 * 查询黑名单结果
 * @author XLY
 * @version $Id: QueryBlacklistRes.java, v 0.1 2015-2-28 下午3:09:18 XLY Exp $
 */
public class QueryBlacklistRes  extends AbstractResponse implements Serializable{

    /**  */
    private static final long serialVersionUID = 8553612579139577286L;

    List<BlacklistInfo> resultlist = new ArrayList<BlacklistInfo>();

    /**
     * 总记录数
     */
    private String totalRecords;
    
    public List<BlacklistInfo> getResultlist() {
        return resultlist;
    }

    public void setResultlist(List<BlacklistInfo> resultlist) {
        this.resultlist = resultlist;
    }

    public String getTotalRecords() {
        return totalRecords;
    }

    public void setTotalRecords(String totalRecords) {
        this.totalRecords = totalRecords;
    }

    @Override
    public String toString() {
        return "QueryBlacklistRes [resultlist=" + resultlist + ", totalRecords=" + totalRecords
               + "]";
    }
    
    
}
