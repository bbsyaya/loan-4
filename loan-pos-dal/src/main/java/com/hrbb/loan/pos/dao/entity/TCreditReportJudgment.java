package com.hrbb.loan.pos.dao.entity;

import java.io.Serializable;
import java.math.BigDecimal;

public class TCreditReportJudgment implements Serializable{
    /**
	 * 
	 */
	private static final long serialVersionUID = 7148286825179506103L;

	private String serialNo;

    private String reportNo;

    private String court;

    private String caseReason;

    private String registerDate;

    private String closedType;

    private String caseResult;

    private String effectiveDate;

    private String suitObj;

    private BigDecimal suitAmt;

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

    public String getCourt() {
        return court;
    }

    public void setCourt(String court) {
        this.court = court == null ? null : court.trim();
    }

    public String getCaseReason() {
        return caseReason;
    }

    public void setCaseReason(String caseReason) {
        this.caseReason = caseReason == null ? null : caseReason.trim();
    }

    public String getRegisterDate() {
        return registerDate;
    }

    public void setRegisterDate(String registerDate) {
        this.registerDate = registerDate == null ? null : registerDate.trim();
    }

    public String getClosedType() {
        return closedType;
    }

    public void setClosedType(String closedType) {
        this.closedType = closedType == null ? null : closedType.trim();
    }

    public String getCaseResult() {
        return caseResult;
    }

    public void setCaseResult(String caseResult) {
        this.caseResult = caseResult == null ? null : caseResult.trim();
    }

    public String getEffectiveDate() {
        return effectiveDate;
    }

    public void setEffectiveDate(String effectiveDate) {
        this.effectiveDate = effectiveDate == null ? null : effectiveDate.trim();
    }

    public String getSuitObj() {
        return suitObj;
    }

    public void setSuitObj(String suitObj) {
        this.suitObj = suitObj == null ? null : suitObj.trim();
    }

    public BigDecimal getSuitAmt() {
        return suitAmt;
    }

    public void setSuitAmt(BigDecimal suitAmt) {
        this.suitAmt = suitAmt;
    }
}