package com.hrbb.loan.pos.dao.entity;

import java.io.Serializable;

public class TCreditReportInstitution implements Serializable{
    /**
	 * 
	 */
	private static final long serialVersionUID = 2275971039539672594L;

	private String serialNo;

    private String reportNo;

    private String account;

    private String content;

    private String occurDate;

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

    public String getAccount() {
        return account;
    }

    public void setAccount(String account) {
        this.account = account == null ? null : account.trim();
    }

    public String getContent() {
        return content;
    }

    public void setContent(String content) {
        this.content = content == null ? null : content.trim();
    }

    public String getOccurDate() {
        return occurDate;
    }

    public void setOccurDate(String occurDate) {
        this.occurDate = occurDate == null ? null : occurDate.trim();
    }
}