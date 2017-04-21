/**
 * 
 *	哈尔滨银行
 * Copyright (c) 2007-2015 HRBB,Inc.All Rights Reserved.
 */
package com.hrbb.loan.pos.facade.bean.blacklist;

import java.io.Serializable;
import java.util.Date;

import com.hrbb.loan.pos.facade.abs.AbstractRequest;

/**
 * 
 * @author XLY
 * @version $Id: BlacklistInfoReq.java, v 0.1 2015-2-28 下午3:04:53 XLY Exp $
 */
public class BlacklistInfo extends AbstractRequest implements Serializable{


    /**  */
    private static final long serialVersionUID = -8073882640349454422L;

    /**
     * 记录ID
     */
    private String id;

    /**
     * 记录类型
     */
    private String infoType;

    /**
     * 证件类型
     */
    private String certType;

    /**
     * 详细信息
     */
    private String infoDetail;

    /**
     * 认证人员
     */
    private String confirmUser;

    /**
     * 认证时间
     */
    private Date confirmTime;

    /**
     * 确认原因
     */
    private String confirmReason;

    /**
     * 生效开始时间
     */
    private Date effectTime;

    /**
     * 失效时间
     */
    private Date uneffTime;

    /**
     * 时间间隔类型
     */
    private String intervalType;

    private Date modifyTime;

    private Date createTime;
    
    private String confirmUserId;

    private String effectFlag;
    
    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id == null ? null : id.trim();
    }

    public String getInfoType() {
        return infoType;
    }

    public void setInfoType(String infoType) {
        this.infoType = infoType == null ? null : infoType.trim();
    }

    public String getCertType() {
        return certType;
    }

    public void setCertType(String certType) {
        this.certType = certType == null ? null : certType.trim();
    }

    public String getInfoDetail() {
        return infoDetail;
    }

    public void setInfoDetail(String infoDetail) {
        this.infoDetail = infoDetail == null ? null : infoDetail.trim();
    }

    public String getConfirmUser() {
        return confirmUser;
    }

    public void setConfirmUser(String confirmUser) {
        this.confirmUser = confirmUser == null ? null : confirmUser.trim();
    }

    public Date getConfirmTime() {
        return confirmTime;
    }

    public void setConfirmTime(Date confirmTime) {
        this.confirmTime = confirmTime;
    }

    public String getConfirmReason() {
        return confirmReason;
    }

    public void setConfirmReason(String confirmReason) {
        this.confirmReason = confirmReason == null ? null : confirmReason.trim();
    }

    public Date getEffectTime() {
        return effectTime;
    }

    public void setEffectTime(Date effectTime) {
        this.effectTime = effectTime;
    }

    public Date getUneffTime() {
        return uneffTime;
    }

    public void setUneffTime(Date uneffTime) {
        this.uneffTime = uneffTime;
    }

    public String getIntervalType() {
        return intervalType;
    }

    public void setIntervalType(String intervalType) {
        this.intervalType = intervalType == null ? null : intervalType.trim();
    }

    public Date getModifyTime() {
        return modifyTime;
    }

    public void setModifyTime(Date modifyTime) {
        this.modifyTime = modifyTime;
    }

    public Date getCreateTime() {
        return createTime;
    }

    public void setCreateTime(Date createTime) {
        this.createTime = createTime;
    }

    public String getConfirmUserId() {
        return confirmUserId;
    }

    public void setConfirmUserId(String confirmUserId) {
        this.confirmUserId = confirmUserId;
    }

    public String getEffectFlag() {
        return effectFlag;
    }

    public void setEffectFlag(String effectFlag) {
        this.effectFlag = effectFlag;
    }

    @Override
    public String toString() {
        return "BlacklistInfoReq [id=" + id + ", infoType=" + infoType + ", certType=" + certType
               + ", infoDetail=" + infoDetail + ", confirmUser=" + confirmUser + ", confirmTime="
               + confirmTime + ", confirmReason=" + confirmReason + ", effectTime=" + effectTime
               + ", uneffTime=" + uneffTime + ", intervalType=" + intervalType + ", modifyTime="
               + modifyTime + ", createTime=" + createTime + "]";
    }

}
