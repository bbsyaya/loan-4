package com.hrbb.loan.pos.dao.entity;

import java.io.Serializable;
import java.math.BigDecimal;
import java.util.Date;

public class TModelResult implements Serializable {

	/**
	 * 
	 */
	private static final long serialVersionUID = 5847973167450282776L;

	private Integer id;
	private String loanId;
	private String approvedResult;
	private BigDecimal approvedAmt;
	private BigDecimal approvedRate;
	private String approvedType;
	private String approvedPeriod;
	private double pd30;
	private double pd3;
	private double scored30;
	private double scored3;
	private String version;
	private Date createDate;
	private Date modifyDate;
	public Integer getId() {
		return id;
	}
	public void setId(Integer id) {
		this.id = id;
	}
	public String getLoanId() {
		return loanId;
	}
	public void setLoanId(String loanId) {
		this.loanId = loanId;
	}
	public String getApprovedResult() {
		return approvedResult;
	}
	public void setApprovedResult(String approvedResult) {
		this.approvedResult = approvedResult;
	}
	public BigDecimal getApprovedAmt() {
		return approvedAmt;
	}
	public void setApprovedAmt(BigDecimal approvedAmt) {
		this.approvedAmt = approvedAmt;
	}
	public BigDecimal getApprovedRate() {
		return approvedRate;
	}
	public void setApprovedRate(BigDecimal approvedRate) {
		this.approvedRate = approvedRate;
	}
	public String getApprovedType() {
		return approvedType;
	}
	public void setApprovedType(String approvedType) {
		this.approvedType = approvedType;
	}
	public String getApprovedPeriod() {
		return approvedPeriod;
	}
	public void setApprovedPeriod(String approvedPeriod) {
		this.approvedPeriod = approvedPeriod;
	}
	public double getPd30() {
		return pd30;
	}
	public void setPd30(double pd30) {
		this.pd30 = pd30;
	}
	public double getPd3() {
		return pd3;
	}
	public void setPd3(double pd3) {
		this.pd3 = pd3;
	}
	public double getScored30() {
		return scored30;
	}
	public void setScored30(double scored30) {
		this.scored30 = scored30;
	}
	public double getScored3() {
		return scored3;
	}
	public void setScored3(double scored3) {
		this.scored3 = scored3;
	}
	public String getVersion() {
		return version;
	}
	public void setVersion(String version) {
		this.version = version;
	}
	public Date getCreateDate() {
		return createDate;
	}
	public void setCreateDate(Date createDate) {
		this.createDate = createDate;
	}
	public Date getModifyDate() {
		return modifyDate;
	}
	public void setModifyDate(Date modifyDate) {
		this.modifyDate = modifyDate;
	}
	
}
