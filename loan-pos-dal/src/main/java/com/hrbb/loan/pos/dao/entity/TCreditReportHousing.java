package com.hrbb.loan.pos.dao.entity;

import java.io.Serializable;
import java.math.BigDecimal;

public class TCreditReportHousing implements Serializable{
    /**
	 * 
	 */
	private static final long serialVersionUID = -9101253132447647492L;

	private String serialNo;

    private String reportNo;

    private String area;

    private String registerDate;

    private String firstMonth;

    private String toMonth;

    private String state;

    private BigDecimal depositAmt;

    private BigDecimal ownPCT;

    private BigDecimal corpPCT;

    private String depositUnit;

    private String updateDate;

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

    public String getArea() {
        return area;
    }

    public void setArea(String area) {
        this.area = area == null ? null : area.trim();
    }

    public String getRegisterDate() {
        return registerDate;
    }

    public void setRegisterDate(String registerDate) {
        this.registerDate = registerDate == null ? null : registerDate.trim();
    }

    public String getFirstMonth() {
        return firstMonth;
    }

    public void setFirstMonth(String firstMonth) {
        this.firstMonth = firstMonth == null ? null : firstMonth.trim();
    }

    public String getToMonth() {
        return toMonth;
    }

    public void setToMonth(String toMonth) {
        this.toMonth = toMonth == null ? null : toMonth.trim();
    }

    public String getState() {
        return state;
    }

    public void setState(String state) {
        this.state = state == null ? null : state.trim();
    }

    public BigDecimal getDepositAmt() {
        return depositAmt;
    }

    public void setDepositAmt(BigDecimal depositAmt) {
        this.depositAmt = depositAmt;
    }

    public BigDecimal getOwnPCT() {
        return ownPCT;
    }

    public void setOwnPCT(BigDecimal ownPCT) {
        this.ownPCT = ownPCT;
    }

    public BigDecimal getCorpPCT() {
        return corpPCT;
    }

    public void setCorpPCT(BigDecimal corpPCT) {
        this.corpPCT = corpPCT;
    }

    public String getDepositUnit() {
        return depositUnit;
    }

    public void setDepositUnit(String depositUnit) {
        this.depositUnit = depositUnit == null ? null : depositUnit.trim();
    }

    public String getUpdateDate() {
        return updateDate;
    }

    public void setUpdateDate(String updateDate) {
        this.updateDate = updateDate == null ? null : updateDate.trim();
    }
}