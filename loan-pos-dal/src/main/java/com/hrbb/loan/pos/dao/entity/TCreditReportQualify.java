package com.hrbb.loan.pos.dao.entity;

import java.io.Serializable;

public class TCreditReportQualify implements Serializable{
    /**
	 * 
	 */
	private static final long serialVersionUID = 5265764978181230211L;

	private String serialNo;

    private String reportNo;

    private String competency;

    private String grade;

    private String awardDate;

    private String endDate;

    private String revokeDate;

    private String authority;

    private String area;

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

    public String getCompetency() {
        return competency;
    }

    public void setCompetency(String competency) {
        this.competency = competency == null ? null : competency.trim();
    }

    public String getGrade() {
        return grade;
    }

    public void setGrade(String grade) {
        this.grade = grade == null ? null : grade.trim();
    }

    public String getAwardDate() {
        return awardDate;
    }

    public void setAwardDate(String awardDate) {
        this.awardDate = awardDate == null ? null : awardDate.trim();
    }

    public String getEndDate() {
        return endDate;
    }

    public void setEndDate(String endDate) {
        this.endDate = endDate == null ? null : endDate.trim();
    }

    public String getRevokeDate() {
        return revokeDate;
    }

    public void setRevokeDate(String revokeDate) {
        this.revokeDate = revokeDate == null ? null : revokeDate.trim();
    }

    public String getAuthority() {
        return authority;
    }

    public void setAuthority(String authority) {
        this.authority = authority == null ? null : authority.trim();
    }

    public String getArea() {
        return area;
    }

    public void setArea(String area) {
        this.area = area == null ? null : area.trim();
    }
}