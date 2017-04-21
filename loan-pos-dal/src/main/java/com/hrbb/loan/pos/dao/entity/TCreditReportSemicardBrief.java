package com.hrbb.loan.pos.dao.entity;

import java.io.Serializable;
import java.math.BigDecimal;

public class TCreditReportSemicardBrief implements Serializable{
    /**
	 * 
	 */
	private static final long serialVersionUID = 8154921182125392049L;

	private String reportNo;

    private Integer financeCorps;

    private Integer financeOrgs;

    private Integer accounts;

    private BigDecimal creditLimit;

    private BigDecimal creditMax;

    private BigDecimal creditMin;

    private BigDecimal usedCredit;

    private BigDecimal avgAmt6m;

    public String getReportNo() {
        return reportNo;
    }

    public void setReportNo(String reportNo) {
        this.reportNo = reportNo == null ? null : reportNo.trim();
    }

    public Integer getFinanceCorps() {
        return financeCorps;
    }

    public void setFinanceCorps(Integer financeCorps) {
        this.financeCorps = financeCorps;
    }

    public Integer getFinanceOrgs() {
        return financeOrgs;
    }

    public void setFinanceOrgs(Integer financeOrgs) {
        this.financeOrgs = financeOrgs;
    }

    public Integer getAccounts() {
        return accounts;
    }

    public void setAccounts(Integer accounts) {
        this.accounts = accounts;
    }

    public BigDecimal getCreditLimit() {
        return creditLimit;
    }

    public void setCreditLimit(BigDecimal creditLimit) {
        this.creditLimit = creditLimit;
    }

    public BigDecimal getCreditMax() {
        return creditMax;
    }

    public void setCreditMax(BigDecimal creditMax) {
        this.creditMax = creditMax;
    }

    public BigDecimal getCreditMin() {
        return creditMin;
    }

    public void setCreditMin(BigDecimal creditMin) {
        this.creditMin = creditMin;
    }

    public BigDecimal getUsedCredit() {
        return usedCredit;
    }

    public void setUsedCredit(BigDecimal usedCredit) {
        this.usedCredit = usedCredit;
    }

    public BigDecimal getAvgAmt6m() {
        return avgAmt6m;
    }

    public void setAvgAmt6m(BigDecimal avgAmt6m) {
        this.avgAmt6m = avgAmt6m;
    }
}