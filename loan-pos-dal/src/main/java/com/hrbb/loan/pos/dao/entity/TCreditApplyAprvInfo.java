package com.hrbb.loan.pos.dao.entity;

import java.io.Serializable;
import java.math.BigDecimal;
import java.util.Date;
import java.util.List;

public class TCreditApplyAprvInfo extends TCreditApplyAprvInfoKey implements Serializable{
	/**
	 * 
	 */
	private static final long serialVersionUID = 3523625296155205264L;

	private String custId;

	private String custName;

	private String prodId;

	private String prodName;

	private String appCredLevel;

	private BigDecimal appMaxCred;

	private String lowRiskType;

	private String currSign;

	private BigDecimal apptcApi;

	private String termUnit;

	private String apptTerm;

	private String assuKind;

	private String depositKind;

	private BigDecimal depositRate;

	private BigDecimal asDepositRate;

	private String inteType;

	private String inteAdjuKind;

	private String rateCode;

	private String rateNote;

	private BigDecimal basicInteRate;

	private BigDecimal floatInteRate;

	private BigDecimal moreInteRate;

	private BigDecimal inteRate;

	private BigDecimal retRate;

	private String retuKind;

	private String retuKind2;

	private String loanUsereMark;

	private String riskFlag;

	private String riskRemark;

	private String loanPrecond;

	private String payPrecond;

	private String riskPrecautmeas;

	private String otherCond;

	private String apprInfo;

	private String operId;

	private String bankId;

	private Date apprvDate;

	private Date apprVendDate;

	private String apprvId;

	private String apprvBankId;

	private String apprState;

	private String apprResult;

	private Date appBeginTime;

	private Date appEndTime;

	private BigDecimal apprAmount;

	private BigDecimal apprInte;

	private String apprInfoExt;

	private String backToId;

	private String apprStateToBack;

	private List<String> applyStatuses;

	private String needReason;

	private String appBeginTimeStr;

	private String appEndTimeStr;

	private String needInforCodes;
	// 审批详情画面的记录标题
	private String apprStateName;
	private String apprStateTitle;
	// 申请额度
	private String applyAmt;
	// 权限(判断状态和权限用)
	private String privileges;
	// 拒绝码
	private String refuseCode;
	// 通过码
	private String passCode;
	private String remark;
	
	/**
	 * Getter method for property <tt>remark</tt>.
	 * 
	 * @return property value of remark
	 */
	public String getRemark() {
		return remark;
	}

	/**
	 * Setter method for property <tt>remark</tt>.
	 * 
	 * @param remark value to be assigned to property remark
	 */
	public void setRemark(String remark) {
		this.remark = remark;
	}

	/**
	 * Getter method for property <tt>passCode</tt>.
	 * 
	 * @return property value of passCode
	 */
	public String getPassCode() {
		return passCode;
	}

	/**
	 * Setter method for property <tt>passCode</tt>.
	 * 
	 * @param passCode value to be assigned to property passCode
	 */
	public void setPassCode(String passCode) {
		this.passCode = passCode;
	}

	/**
	 * Getter method for property <tt>refuseCode</tt>.
	 * 
	 * @return property value of refuseCode
	 */
	public String getRefuseCode() {
		return refuseCode;
	}

	/**
	 * Setter method for property <tt>refuseCode</tt>.
	 * 
	 * @param refuseCode value to be assigned to property refuseCode
	 */
	public void setRefuseCode(String refuseCode) {
		this.refuseCode = refuseCode;
	}

	/**
	 * Getter method for property <tt>privileges</tt>.
	 * 
	 * @return property value of privileges
	 */
	public String getPrivileges() {
		return privileges;
	}

	/**
	 * Setter method for property <tt>privileges</tt>.
	 * 
	 * @param privileges
	 *            value to be assigned to property privileges
	 */
	public void setPrivileges(String privileges) {
		this.privileges = privileges;
	}

	/**
	 * Getter method for property <tt>applyAmt</tt>.
	 * 
	 * @return property value of applyAmt
	 */
	public String getApplyAmt() {
		return applyAmt;
	}

	/**
	 * Setter method for property <tt>applyAmt</tt>.
	 * 
	 * @param applyAmt
	 *            value to be assigned to property applyAmt
	 */
	public void setApplyAmt(String applyAmt) {
		this.applyAmt = applyAmt;
	}

	/**
	 * Getter method for property <tt>apprStateName</tt>.
	 * 
	 * @return property value of apprStateName
	 */
	public String getApprStateName() {
		return apprStateName;
	}

	/**
	 * Setter method for property <tt>apprStateName</tt>.
	 * 
	 * @param apprStateName
	 *            value to be assigned to property apprStateName
	 */
	public void setApprStateName(String apprStateName) {
		this.apprStateName = apprStateName;
	}

	/**
	 * Getter method for property <tt>apprStateTitle</tt>.
	 * 
	 * @return property value of apprStateTitle
	 */
	public String getApprStateTitle() {
		return apprStateTitle;
	}

	/**
	 * Setter method for property <tt>apprStateTitle</tt>.
	 * 
	 * @param apprStateTitle
	 *            value to be assigned to property apprStateTitle
	 */
	public void setApprStateTitle(String apprStateTitle) {
		this.apprStateTitle = apprStateTitle;
	}

	/**
	 * Getter method for property <tt>needInforCodes</tt>.
	 * 
	 * @return property value of needInforCodes
	 */
	public String getNeedInforCodes() {
		return needInforCodes;
	}

	/**
	 * Setter method for property <tt>needInforCodes</tt>.
	 * 
	 * @param needInforCodes
	 *            value to be assigned to property needInforCodes
	 */
	public void setNeedInforCodes(String needInforCodes) {
		this.needInforCodes = needInforCodes;
	}

	/**
	 * Getter method for property <tt>appBeginTimeStr</tt>.
	 * 
	 * @return property value of appBeginTimeStr
	 */
	public String getAppBeginTimeStr() {
		return appBeginTimeStr;
	}

	/**
	 * Setter method for property <tt>appBeginTimeStr</tt>.
	 * 
	 * @param appBeginTimeStr
	 *            value to be assigned to property appBeginTimeStr
	 */
	public void setAppBeginTimeStr(String appBeginTimeStr) {
		this.appBeginTimeStr = appBeginTimeStr;
	}

	/**
	 * Getter method for property <tt>appEndTimeStr</tt>.
	 * 
	 * @return property value of appEndTimeStr
	 */
	public String getAppEndTimeStr() {
		return appEndTimeStr;
	}

	/**
	 * Setter method for property <tt>appEndTimeStr</tt>.
	 * 
	 * @param appEndTimeStr
	 *            value to be assigned to property appEndTimeStr
	 */
	public void setAppEndTimeStr(String appEndTimeStr) {
		this.appEndTimeStr = appEndTimeStr;
	}

	/**
	 * Getter method for property <tt>needReason</tt>.
	 * 
	 * @return property value of needReason
	 */
	public String getNeedReason() {
		return needReason;
	}

	/**
	 * Setter method for property <tt>needReason</tt>.
	 * 
	 * @param needReason
	 *            value to be assigned to property needReason
	 */
	public void setNeedReason(String needReason) {
		this.needReason = needReason;
	}

	/**
	 * Getter method for property <tt>applyStatuses</tt>.
	 * 
	 * @return property value of applyStatuses
	 */
	public List<String> getApplyStatuses() {
		return applyStatuses;
	}

	/**
	 * Setter method for property <tt>applyStatuses</tt>.
	 * 
	 * @param applyStatuses
	 *            value to be assigned to property applyStatuses
	 */
	public void setApplyStatuses(List<String> applyStatuses) {
		this.applyStatuses = applyStatuses;
	}

	/**
	 * Getter method for property <tt>apprStateToBack</tt>.
	 * 
	 * @return property value of apprStateToBack
	 */
	public String getApprStateToBack() {
		return apprStateToBack;
	}

	/**
	 * Setter method for property <tt>apprStateToBack</tt>.
	 * 
	 * @param apprStateToBack
	 *            value to be assigned to property apprStateToBack
	 */
	public void setApprStateToBack(String apprStateToBack) {
		this.apprStateToBack = apprStateToBack;
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

	public String getProdId() {
		return prodId;
	}

	public void setProdId(String prodId) {
		this.prodId = prodId == null ? null : prodId.trim();
	}

	public String getProdName() {
		return prodName;
	}

	public void setProdName(String prodName) {
		this.prodName = prodName == null ? null : prodName.trim();
	}

	public String getAppCredLevel() {
		return appCredLevel;
	}

	public void setAppCredLevel(String appCredLevel) {
		this.appCredLevel = appCredLevel == null ? null : appCredLevel.trim();
	}

	public BigDecimal getAppMaxCred() {
		return appMaxCred;
	}

	public void setAppMaxCred(BigDecimal appMaxCred) {
		this.appMaxCred = appMaxCred;
	}

	public String getLowRiskType() {
		return lowRiskType;
	}

	public void setLowRiskType(String lowRiskType) {
		this.lowRiskType = lowRiskType == null ? null : lowRiskType.trim();
	}

	public String getCurrSign() {
		return currSign;
	}

	public void setCurrSign(String currSign) {
		this.currSign = currSign == null ? null : currSign.trim();
	}

	public BigDecimal getApptcApi() {
		return apptcApi;
	}

	public void setApptcApi(BigDecimal apptcApi) {
		this.apptcApi = apptcApi;
	}

	public String getTermUnit() {
		return termUnit;
	}

	public void setTermUnit(String termUnit) {
		this.termUnit = termUnit == null ? null : termUnit.trim();
	}

	public String getApptTerm() {
		return apptTerm;
	}

	public void setApptTerm(String apptTerm) {
		this.apptTerm = apptTerm == null ? null : apptTerm.trim();
	}

	public String getAssuKind() {
		return assuKind;
	}

	public void setAssuKind(String assuKind) {
		this.assuKind = assuKind == null ? null : assuKind.trim();
	}

	public String getDepositKind() {
		return depositKind;
	}

	public void setDepositKind(String depositKind) {
		this.depositKind = depositKind == null ? null : depositKind.trim();
	}

	public BigDecimal getDepositRate() {
		return depositRate;
	}

	public void setDepositRate(BigDecimal depositRate) {
		this.depositRate = depositRate;
	}

	public BigDecimal getAsDepositRate() {
		return asDepositRate;
	}

	public void setAsDepositRate(BigDecimal asDepositRate) {
		this.asDepositRate = asDepositRate;
	}

	public String getInteType() {
		return inteType;
	}

	public void setInteType(String inteType) {
		this.inteType = inteType == null ? null : inteType.trim();
	}

	public String getInteAdjuKind() {
		return inteAdjuKind;
	}

	public void setInteAdjuKind(String inteAdjuKind) {
		this.inteAdjuKind = inteAdjuKind == null ? null : inteAdjuKind.trim();
	}

	public String getRateCode() {
		return rateCode;
	}

	public void setRateCode(String rateCode) {
		this.rateCode = rateCode == null ? null : rateCode.trim();
	}

	public String getRateNote() {
		return rateNote;
	}

	public void setRateNote(String rateNote) {
		this.rateNote = rateNote == null ? null : rateNote.trim();
	}

	public BigDecimal getBasicInteRate() {
		return basicInteRate;
	}

	public void setBasicInteRate(BigDecimal basicInteRate) {
		this.basicInteRate = basicInteRate;
	}

	public BigDecimal getFloatInteRate() {
		return floatInteRate;
	}

	public void setFloatInteRate(BigDecimal floatInteRate) {
		this.floatInteRate = floatInteRate;
	}

	public BigDecimal getMoreInteRate() {
		return moreInteRate;
	}

	public void setMoreInteRate(BigDecimal moreInteRate) {
		this.moreInteRate = moreInteRate;
	}

	public BigDecimal getInteRate() {
		return inteRate;
	}

	public void setInteRate(BigDecimal inteRate) {
		this.inteRate = inteRate;
	}

	public BigDecimal getRetRate() {
		return retRate;
	}

	public void setRetRate(BigDecimal retRate) {
		this.retRate = retRate;
	}

	public String getRetuKind() {
		return retuKind;
	}

	public void setRetuKind(String retuKind) {
		this.retuKind = retuKind == null ? null : retuKind.trim();
	}

	public String getRetuKind2() {
		return retuKind2;
	}

	public void setRetuKind2(String retuKind2) {
		this.retuKind2 = retuKind2 == null ? null : retuKind2.trim();
	}

	public String getLoanUsereMark() {
		return loanUsereMark;
	}

	public void setLoanUsereMark(String loanUsereMark) {
		this.loanUsereMark = loanUsereMark == null ? null : loanUsereMark
				.trim();
	}

	public String getRiskFlag() {
		return riskFlag;
	}

	public void setRiskFlag(String riskFlag) {
		this.riskFlag = riskFlag == null ? null : riskFlag.trim();
	}

	public String getRiskRemark() {
		return riskRemark;
	}

	public void setRiskRemark(String riskRemark) {
		this.riskRemark = riskRemark == null ? null : riskRemark.trim();
	}

	public String getLoanPrecond() {
		return loanPrecond;
	}

	public void setLoanPrecond(String loanPrecond) {
		this.loanPrecond = loanPrecond == null ? null : loanPrecond.trim();
	}

	public String getPayPrecond() {
		return payPrecond;
	}

	public void setPayPrecond(String payPrecond) {
		this.payPrecond = payPrecond == null ? null : payPrecond.trim();
	}

	public String getRiskPrecautmeas() {
		return riskPrecautmeas;
	}

	public void setRiskPrecautmeas(String riskPrecautmeas) {
		this.riskPrecautmeas = riskPrecautmeas == null ? null : riskPrecautmeas
				.trim();
	}

	public String getOtherCond() {
		return otherCond;
	}

	public void setOtherCond(String otherCond) {
		this.otherCond = otherCond == null ? null : otherCond.trim();
	}

	public String getApprInfo() {
		return apprInfo;
	}

	public void setApprInfo(String apprInfo) {
		this.apprInfo = apprInfo == null ? null : apprInfo.trim();
	}

	public String getOperId() {
		return operId;
	}

	public void setOperId(String operId) {
		this.operId = operId == null ? null : operId.trim();
	}

	public String getBankId() {
		return bankId;
	}

	public void setBankId(String bankId) {
		this.bankId = bankId == null ? null : bankId.trim();
	}

	public Date getApprvDate() {
		return apprvDate;
	}

	public void setApprvDate(Date apprvDate) {
		this.apprvDate = apprvDate;
	}

	public Date getApprVendDate() {
		return apprVendDate;
	}

	public void setApprVendDate(Date apprVendDate) {
		this.apprVendDate = apprVendDate;
	}

	public String getApprvId() {
		return apprvId;
	}

	public void setApprvId(String apprvId) {
		this.apprvId = apprvId == null ? null : apprvId.trim();
	}

	public String getApprvBankId() {
		return apprvBankId;
	}

	public void setApprvBankId(String apprvBankId) {
		this.apprvBankId = apprvBankId == null ? null : apprvBankId.trim();
	}

	public String getApprState() {
		return apprState;
	}

	public void setApprState(String apprState) {
		this.apprState = apprState == null ? null : apprState.trim();
	}

	public String getApprResult() {
		return apprResult;
	}

	public void setApprResult(String apprResult) {
		this.apprResult = apprResult == null ? null : apprResult.trim();
	}

	public Date getAppBeginTime() {
		return appBeginTime;
	}

	public void setAppBeginTime(Date appBeginTime) {
		this.appBeginTime = appBeginTime;
	}

	public Date getAppEndTime() {
		return appEndTime;
	}

	public void setAppEndTime(Date appEndTime) {
		this.appEndTime = appEndTime;
	}

	public BigDecimal getApprAmount() {
		return apprAmount;
	}

	public void setApprAmount(BigDecimal apprAmount) {
		this.apprAmount = apprAmount;
	}

	public BigDecimal getApprInte() {
		return apprInte;
	}

	public void setApprInte(BigDecimal apprInte) {
		this.apprInte = apprInte;
	}

	public String getApprInfoExt() {
		return apprInfoExt;
	}

	public void setApprInfoExt(String apprInfoExt) {
		this.apprInfoExt = apprInfoExt == null ? null : apprInfoExt.trim();
	}

	public String getBackToId() {
		return backToId;
	}

	public void setBackToId(String backToId) {
		this.backToId = backToId == null ? null : backToId.trim();
	}
}