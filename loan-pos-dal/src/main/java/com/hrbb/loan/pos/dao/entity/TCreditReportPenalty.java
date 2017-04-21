package com.hrbb.loan.pos.dao.entity;

import java.io.Serializable;
import java.math.BigDecimal;

public class TCreditReportPenalty implements Serializable{
    private String serialNo;

    private String reportNo;

    private String penaltyOrg;

    private String content;

    private BigDecimal amount;

    private String beginDate;

    private String endDate;

    private String result;

    public String getSerialNo() {
        return serialNo;
    }

    public void setSerialNo(String serialNo) {
        this.serialNo = serialNo == null ? null : serialNo.trim();
    }

    public String getReportNo() {
        return reportNo;
    }

    public void setReportNo(String reportNo) {
        this.reportNo = reportNo == null ? null : reportNo.trim();
    }

    public String getPenaltyOrg() {
        return penaltyOrg;
    }

    public void setPenaltyOrg(String penaltyOrg) {
        this.penaltyOrg = penaltyOrg == null ? null : penaltyOrg.trim();
    }

    public String getContent() {
        return content;
    }

    public void setContent(String content) {
        this.content = content == null ? null : content.trim();
    }

    public BigDecimal getAmount() {
        return amount;
    }

    public void setAmount(BigDecimal amount) {
        this.amount = amount;
    }

    public String getBeginDate() {
        return beginDate;
    }

    public void setBeginDate(String beginDate) {
        this.beginDate = beginDate == null ? null : beginDate.trim();
    }

    public String getEndDate() {
        return endDate;
    }

    public void setEndDate(String endDate) {
        this.endDate = endDate == null ? null : endDate.trim();
    }

    public String getResult() {
        return result;
    }

    public void setResult(String result) {
        this.result = result == null ? null : result.trim();
    }
}