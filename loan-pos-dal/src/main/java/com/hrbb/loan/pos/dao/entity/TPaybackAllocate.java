package com.hrbb.loan.pos.dao.entity;

import java.io.Serializable;
import java.math.BigDecimal;
import java.util.Date;

public class TPaybackAllocate implements Serializable{
    /**
	 * 
	 */
	private static final long serialVersionUID = 8462673329139108854L;

	private String importRunningId;

    private String matchedReceiptId;

    private BigDecimal allocateTotalAmt;

    private BigDecimal allocateCaptital;

    private BigDecimal allocateInterest;

    private Date allocateDate;

    private String allocatePerson;

    public String getImportRunningId() {
        return importRunningId;
    }

    public void setImportRunningId(String importRunningId) {
        this.importRunningId = importRunningId == null ? null : importRunningId.trim();
    }

    public String getMatchedReceiptId() {
        return matchedReceiptId;
    }

    public void setMatchedReceiptId(String matchedReceiptId) {
        this.matchedReceiptId = matchedReceiptId == null ? null : matchedReceiptId.trim();
    }

    public BigDecimal getAllocateTotalAmt() {
        return allocateTotalAmt;
    }

    public void setAllocateTotalAmt(BigDecimal allocateTotalAmt) {
        this.allocateTotalAmt = allocateTotalAmt;
    }

    public BigDecimal getAllocateCaptital() {
        return allocateCaptital;
    }

    public void setAllocateCaptital(BigDecimal allocateCaptital) {
        this.allocateCaptital = allocateCaptital;
    }

    public BigDecimal getAllocateInterest() {
        return allocateInterest;
    }

    public void setAllocateInterest(BigDecimal allocateInterest) {
        this.allocateInterest = allocateInterest;
    }

    public Date getAllocateDate() {
        return allocateDate;
    }

    public void setAllocateDate(Date allocateDate) {
        this.allocateDate = allocateDate;
    }

    public String getAllocatePerson() {
        return allocatePerson;
    }

    public void setAllocatePerson(String allocatePerson) {
        this.allocatePerson = allocatePerson == null ? null : allocatePerson.trim();
    }
}