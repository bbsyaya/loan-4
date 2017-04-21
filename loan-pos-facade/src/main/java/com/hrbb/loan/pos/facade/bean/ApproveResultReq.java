package com.hrbb.loan.pos.facade.bean;

import java.math.BigDecimal;
import java.util.Date;

public class ApproveResultReq {
  
	private String approveId;

    private String businessSource;

    private String loanId;

    private String custId;

    private String custName;

    private Date applyCommitDate;

    private BigDecimal applyAmt;

    private String applyMoneyKind;

    private String termUnit;

    private Long applyTerm;

    private Date approveDate;

    private BigDecimal approveAmount;

    private String approveMoneyKind;

    private BigDecimal approveInterest;

    private Long approveTerm;

    private String paybackMethod;

    private String acceptAccount;

    private String accountOpenBank;

    private String accountBranchBank;

    private String accountSubBranchBank;

    private Integer productId;

    private String approveStatus;

    public String getApproveId() {
        return approveId;
    }

    public void setApproveId(String approveId) {
        this.approveId = approveId == null ? null : approveId.trim();
    }

    public String getBusinessSource() {
        return businessSource;
    }

    public void setBusinessSource(String businessSource) {
        this.businessSource = businessSource == null ? null : businessSource.trim();
    }

    public String getLoanId() {
        return loanId;
    }

    public void setLoanId(String loanId) {
        this.loanId = loanId == null ? null : loanId.trim();
    }

    public String getCustId() {
        return custId;
    }

    public void setCustId(String custId) {
        this.custId = custId == null ? null : custId.trim();
    }

    public String getCustName() {
        return custName;
    }

    public void setCustName(String custName) {
        this.custName = custName == null ? null : custName.trim();
    }

    public Date getApplyCommitDate() {
        return applyCommitDate;
    }

    public void setApplyCommitDate(Date applyCommitDate) {
        this.applyCommitDate = applyCommitDate;
    }

    public BigDecimal getApplyAmt() {
        return applyAmt;
    }

    public void setApplyAmt(BigDecimal applyAmt) {
        this.applyAmt = applyAmt;
    }

    public String getApplyMoneyKind() {
        return applyMoneyKind;
    }

    public void setApplyMoneyKind(String applyMoneyKind) {
        this.applyMoneyKind = applyMoneyKind == null ? null : applyMoneyKind.trim();
    }

    public String getTermUnit() {
        return termUnit;
    }

    public void setTermUnit(String termUnit) {
        this.termUnit = termUnit == null ? null : termUnit.trim();
    }

    public Long getApplyTerm() {
        return applyTerm;
    }

    public void setApplyTerm(Long applyTerm) {
        this.applyTerm = applyTerm;
    }

    public Date getApproveDate() {
        return approveDate;
    }

    public void setApproveDate(Date approveDate) {
        this.approveDate = approveDate;
    }

    public BigDecimal getApproveAmount() {
        return approveAmount;
    }

    public void setApproveAmount(BigDecimal approveAmount) {
        this.approveAmount = approveAmount;
    }

    public String getApproveMoneyKind() {
        return approveMoneyKind;
    }

    public void setApproveMoneyKind(String approveMoneyKind) {
        this.approveMoneyKind = approveMoneyKind == null ? null : approveMoneyKind.trim();
    }

    public BigDecimal getApproveInterest() {
        return approveInterest;
    }

    public void setApproveInterest(BigDecimal approveInterest) {
        this.approveInterest = approveInterest;
    }

    public Long getApproveTerm() {
        return approveTerm;
    }

    public void setApproveTerm(Long approveTerm) {
        this.approveTerm = approveTerm;
    }

    public String getPaybackMethod() {
        return paybackMethod;
    }

    public void setPaybackMethod(String paybackMethod) {
        this.paybackMethod = paybackMethod == null ? null : paybackMethod.trim();
    }

    public String getAcceptAccount() {
        return acceptAccount;
    }

    public void setAcceptAccount(String acceptAccount) {
        this.acceptAccount = acceptAccount == null ? null : acceptAccount.trim();
    }

    public String getAccountOpenBank() {
        return accountOpenBank;
    }

    public void setAccountOpenBank(String accountOpenBank) {
        this.accountOpenBank = accountOpenBank == null ? null : accountOpenBank.trim();
    }

    public String getAccountBranchBank() {
        return accountBranchBank;
    }

    public void setAccountBranchBank(String accountBranchBank) {
        this.accountBranchBank = accountBranchBank == null ? null : accountBranchBank.trim();
    }

    public String getAccountSubBranchBank() {
        return accountSubBranchBank;
    }

    public void setAccountSubBranchBank(String accountSubBranchBank) {
        this.accountSubBranchBank = accountSubBranchBank == null ? null : accountSubBranchBank.trim();
    }

    public Integer getProductId() {
        return productId;
    }

    public void setProductId(Integer productId) {
        this.productId = productId;
    }

    public String getApproveStatus() {
        return approveStatus;
    }

    public void setApproveStatus(String approveStatus) {
        this.approveStatus = approveStatus == null ? null : approveStatus.trim();
    }
}