package com.hrbb.loan.pos.dao.entity;

import java.io.Serializable;
import java.math.BigDecimal;

public class TCreditReportTelpayment implements Serializable{
    /**
	 * 
	 */
	private static final long serialVersionUID = 7666193560192511254L;

	private String serialNo;

    private String reportNo;

    private String carrier;

    private String type;

    private String registerDate;

    private String state;

    private BigDecimal arrearMoney;

    private String arrearMonths;

    private String accountMonth;

    private String status24m;

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

    public String getCarrier() {
        return carrier;
    }

    public void setCarrier(String carrier) {
        this.carrier = carrier == null ? null : carrier.trim();
    }

    public String getType() {
        return type;
    }

    public void setType(String type) {
        this.type = type == null ? null : type.trim();
    }

    public String getRegisterDate() {
        return registerDate;
    }

    public void setRegisterDate(String registerDate) {
        this.registerDate = registerDate == null ? null : registerDate.trim();
    }

    public String getState() {
        return state;
    }

    public void setState(String state) {
        this.state = state == null ? null : state.trim();
    }

    public BigDecimal getArrearMoney() {
        return arrearMoney;
    }

    public void setArrearMoney(BigDecimal arrearMoney) {
        this.arrearMoney = arrearMoney;
    }

    public String getArrearMonths() {
        return arrearMonths;
    }

    public void setArrearMonths(String arrearMonths) {
        this.arrearMonths = arrearMonths == null ? null : arrearMonths.trim();
    }

    public String getAccountMonth() {
        return accountMonth;
    }

    public void setAccountMonth(String accountMonth) {
        this.accountMonth = accountMonth == null ? null : accountMonth.trim();
    }

    public String getStatus24m() {
        return status24m;
    }

    public void setStatus24m(String status24m) {
        this.status24m = status24m == null ? null : status24m.trim();
    }
}