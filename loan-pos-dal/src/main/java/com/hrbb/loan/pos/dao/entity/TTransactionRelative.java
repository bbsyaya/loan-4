package com.hrbb.loan.pos.dao.entity;

import java.util.Date;

public class TTransactionRelative {
    private Integer id;

    private String transactionType;

    private String transactionOpponent;

    private String businessId;

    private String relativeId;

    private String transactionStatus;

    private Date createTime;

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getTransactionType() {
        return transactionType;
    }

    public void setTransactionType(String transactionType) {
        this.transactionType = transactionType == null ? null : transactionType.trim();
    }

    public String getTransactionOpponent() {
        return transactionOpponent;
    }

    public void setTransactionOpponent(String transactionOpponent) {
        this.transactionOpponent = transactionOpponent == null ? null : transactionOpponent.trim();
    }

    public String getBusinessId() {
        return businessId;
    }

    public void setBusinessId(String businessId) {
        this.businessId = businessId == null ? null : businessId.trim();
    }

    public String getRelativeId() {
        return relativeId;
    }

    public void setRelativeId(String relativeId) {
        this.relativeId = relativeId == null ? null : relativeId.trim();
    }

    public String getTransactionStatus() {
        return transactionStatus;
    }

    public void setTransactionStatus(String transactionStatus) {
        this.transactionStatus = transactionStatus == null ? null : transactionStatus.trim();
    }

    public Date getCreateTime() {
        return createTime;
    }

    public void setCreateTime(Date createTime) {
        this.createTime = createTime;
    }
}