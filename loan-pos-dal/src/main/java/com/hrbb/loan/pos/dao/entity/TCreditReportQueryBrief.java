package com.hrbb.loan.pos.dao.entity;

import java.io.Serializable;

public class TCreditReportQueryBrief implements Serializable{
    /**
	 * 
	 */
	private static final long serialVersionUID = 4770792096510790800L;

	private String reportNo;

    private Integer qryOrgs1;

    private Integer qryOrgs2;

    private Integer qryTimes1;

    private Integer qryTimes2;

    private Integer qryTimes2y1;

    private Integer qryTimes2y2;

    private Integer qryTimes2y3;

    public String getReportNo() {
        return reportNo;
    }

    public void setReportNo(String reportNo) {
        this.reportNo = reportNo == null ? null : reportNo.trim();
    }

    public Integer getQryOrgs1() {
        return qryOrgs1;
    }

    public void setQryOrgs1(Integer qryOrgs1) {
        this.qryOrgs1 = qryOrgs1;
    }

    public Integer getQryOrgs2() {
        return qryOrgs2;
    }

    public void setQryOrgs2(Integer qryOrgs2) {
        this.qryOrgs2 = qryOrgs2;
    }

    public Integer getQryTimes1() {
        return qryTimes1;
    }

    public void setQryTimes1(Integer qryTimes1) {
        this.qryTimes1 = qryTimes1;
    }

    public Integer getQryTimes2() {
        return qryTimes2;
    }

    public void setQryTimes2(Integer qryTimes2) {
        this.qryTimes2 = qryTimes2;
    }

    public Integer getQryTimes2y1() {
        return qryTimes2y1;
    }

    public void setQryTimes2y1(Integer qryTimes2y1) {
        this.qryTimes2y1 = qryTimes2y1;
    }

    public Integer getQryTimes2y2() {
        return qryTimes2y2;
    }

    public void setQryTimes2y2(Integer qryTimes2y2) {
        this.qryTimes2y2 = qryTimes2y2;
    }

    public Integer getQryTimes2y3() {
        return qryTimes2y3;
    }

    public void setQryTimes2y3(Integer qryTimes2y3) {
        this.qryTimes2y3 = qryTimes2y3;
    }
}