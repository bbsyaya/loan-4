package com.hrbb.loan.pos.dao.entity;

public class TCreditReportCardGuarantee {
    private Integer id;

    private String reportNo;

    private String serialNo;

    private String organName;

    private String creditLimit;

    private String beginDate;

    private String guaranteeAmt;

    private String usedLimit;

    private String billingDate;

    private String queryId;

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getReportNo() {
        return reportNo;
    }

    public void setReportNo(String reportNo) {
        this.reportNo = reportNo == null ? null : reportNo.trim();
    }

    public String getSerialNo() {
        return serialNo;
    }

    public void setSerialNo(String serialNo) {
        this.serialNo = serialNo == null ? null : serialNo.trim();
    }

    public String getOrganName() {
        return organName;
    }

    public void setOrganName(String organName) {
        this.organName = organName == null ? null : organName.trim();
    }

    public String getCreditLimit() {
        return creditLimit;
    }

    public void setCreditLimit(String creditLimit) {
        this.creditLimit = creditLimit == null ? null : creditLimit.trim();
    }

    public String getBeginDate() {
        return beginDate;
    }

    public void setBeginDate(String beginDate) {
        this.beginDate = beginDate == null ? null : beginDate.trim();
    }

    public String getGuaranteeAmt() {
        return guaranteeAmt;
    }

    public void setGuaranteeAmt(String guaranteeAmt) {
        this.guaranteeAmt = guaranteeAmt == null ? null : guaranteeAmt.trim();
    }

    public String getUsedLimit() {
        return usedLimit;
    }

    public void setUsedLimit(String usedLimit) {
        this.usedLimit = usedLimit == null ? null : usedLimit.trim();
    }

    public String getBillingDate() {
        return billingDate;
    }

    public void setBillingDate(String billingDate) {
        this.billingDate = billingDate == null ? null : billingDate.trim();
    }

    public String getQueryId() {
        return queryId;
    }

    public void setQueryId(String queryId) {
        this.queryId = queryId == null ? null : queryId.trim();
    }
}