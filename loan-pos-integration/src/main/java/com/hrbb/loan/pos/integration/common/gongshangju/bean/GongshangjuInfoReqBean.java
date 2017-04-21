/**
 * 
 *  哈尔滨银行
 * Copyright (c) 2007-2015 HRBB,Inc.All Rights Reserved.
 */
package com.hrbb.loan.pos.integration.common.gongshangju.bean;
/**
 * 
 * 工商局信息查询请求
 * @author XLY
 * @version $Id: GongshangjuInfoReqBean.java, v 0.1 2015-2-17 下午1:02:47 XLY Exp $
 */
public class GongshangjuInfoReqBean {

    private String uid;
    
    private String key;
    
    private String keyType;
    
    private String orderType;
    
    private String password;

    public String getUid() {
        return uid;
    }

    public void setUid(String uid) {
        this.uid = uid;
    }

    public String getKey() {
        return key;
    }

    public void setKey(String key) {
        this.key = key;
    }

    public String getKeyType() {
        return keyType;
    }

    public void setKeyType(String keyType) {
        this.keyType = keyType;
    }

    public String getOrderType() {
        return orderType;
    }

    public void setOrderType(String orderType) {
        this.orderType = orderType;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }
    
    
}
