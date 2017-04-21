package com.hrbb.loan.pos.dao.entity;

import java.io.Serializable;

public class TAICCaseInfo implements Serializable{
    /**
	 * 
	 */
	private static final long serialVersionUID = 7903754224530174560L;

	private Integer id;

    private String posCustId;

    private String orderNo;

    private String caseTime;

    private String caseReason;

    private String caseVal;

    private String caseType;

    private String exeSort;

    private String caseResult;

    private String pendecNo;

    private String pendecissDate;

    private String penAuth;

    private String illegFact;

    private String penBasis;

    private String penType;

    private String penResult;

    private String penAm;

    private String penExest;

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getPosCustId() {
        return posCustId;
    }

    public void setPosCustId(String posCustId) {
        this.posCustId = posCustId == null ? null : posCustId.trim();
    }

    public String getOrderNo() {
        return orderNo;
    }

    public void setOrderNo(String orderNo) {
        this.orderNo = orderNo == null ? null : orderNo.trim();
    }

    public String getCaseTime() {
        return caseTime;
    }

    public void setCaseTime(String caseTime) {
        this.caseTime = caseTime == null ? null : caseTime.trim();
    }

    public String getCaseReason() {
        return caseReason;
    }

    public void setCaseReason(String caseReason) {
        this.caseReason = caseReason == null ? null : caseReason.trim();
    }

    public String getCaseVal() {
        return caseVal;
    }

    public void setCaseVal(String caseVal) {
        this.caseVal = caseVal == null ? null : caseVal.trim();
    }

    public String getCaseType() {
        return caseType;
    }

    public void setCaseType(String caseType) {
        this.caseType = caseType == null ? null : caseType.trim();
    }

    public String getExeSort() {
        return exeSort;
    }

    public void setExeSort(String exeSort) {
        this.exeSort = exeSort == null ? null : exeSort.trim();
    }

    public String getCaseResult() {
        return caseResult;
    }

    public void setCaseResult(String caseResult) {
        this.caseResult = caseResult == null ? null : caseResult.trim();
    }

    public String getPendecNo() {
        return pendecNo;
    }

    public void setPendecNo(String pendecNo) {
        this.pendecNo = pendecNo == null ? null : pendecNo.trim();
    }

    public String getPendecissDate() {
        return pendecissDate;
    }

    public void setPendecissDate(String pendecissDate) {
        this.pendecissDate = pendecissDate == null ? null : pendecissDate.trim();
    }

    public String getPenAuth() {
        return penAuth;
    }

    public void setPenAuth(String penAuth) {
        this.penAuth = penAuth == null ? null : penAuth.trim();
    }

    public String getIllegFact() {
        return illegFact;
    }

    public void setIllegFact(String illegFact) {
        this.illegFact = illegFact == null ? null : illegFact.trim();
    }

    public String getPenBasis() {
        return penBasis;
    }

    public void setPenBasis(String penBasis) {
        this.penBasis = penBasis == null ? null : penBasis.trim();
    }

    public String getPenType() {
        return penType;
    }

    public void setPenType(String penType) {
        this.penType = penType == null ? null : penType.trim();
    }

    public String getPenResult() {
        return penResult;
    }

    public void setPenResult(String penResult) {
        this.penResult = penResult == null ? null : penResult.trim();
    }

    public String getPenAm() {
        return penAm;
    }

    public void setPenAm(String penAm) {
        this.penAm = penAm == null ? null : penAm.trim();
    }

    public String getPenExest() {
        return penExest;
    }

    public void setPenExest(String penExest) {
        this.penExest = penExest == null ? null : penExest.trim();
    }
}