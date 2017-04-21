package com.hrbb.loan.pos.dao.entity;

import java.io.Serializable;
import java.math.BigDecimal;

public class TCreditReportLoanInfo implements Serializable{
    /**
	 * 
	 */
	private static final long serialVersionUID = -9101849125051466560L;

	private String serialNo;

    private String class5State;

    private BigDecimal balance;

    private Integer remainCycles;

    private BigDecimal scheduledAmt;

    private String scheduledDate;

    private BigDecimal actualAmt;

    private String recentPayDate;

    private Integer overdueCycle;

    private BigDecimal overdueAmt;

    private BigDecimal overdue31to60Amt;

    private BigDecimal overdue61to90Amt;

    private BigDecimal overdue91to180Amt;

    private BigDecimal overdueOver180Amt;

    private String reportNo;

    private String bizType;

    private String note;

    private String financeOrg;

    private String account;

    private String type;

    private String currency;

    private String openDate;

    private String endDate;

    private BigDecimal limitAmt;

    private String guarantyType;

    private String paymentFreq;

    private String paymentCycle;

    private String state;
    private String state1;

    private BigDecimal badBalance;

    private String stateEndDate;

    private String stateEndMonth;

    private String beginMonth;

    private String endMonth;

    private String latest24State;
    
    private int countSerialNo;
    
    private Integer days;
    private Integer days2;
    private Integer flag;
    
    private String queryId;
    
    /**
	 * Getter method for property <tt>queryId</tt>.
	 * 
	 * @return property value of queryId
	 */
	public String getQueryId() {
		return queryId;
	}

	/**
	 * Setter method for property <tt>queryId</tt>.
	 * 
	 * @param queryId value to be assigned to property queryId
	 */
	public void setQueryId(String queryId) {
		this.queryId = queryId;
	}

	/**
	 * Getter method for property <tt>days2</tt>.
	 * 
	 * @return property value of days2
	 */
	public Integer getDays2() {
		return days2;
	}

	/**
	 * Setter method for property <tt>days2</tt>.
	 * 
	 * @param days2 value to be assigned to property days2
	 */
	public void setDays2(Integer days2) {
		this.days2 = days2;
	}

	/**
	 * Getter method for property <tt>flag</tt>.
	 * 
	 * @return property value of flag
	 */
	public Integer getFlag() {
		return flag;
	}

	/**
	 * Setter method for property <tt>flag</tt>.
	 * 
	 * @param flag value to be assigned to property flag
	 */
	public void setFlag(Integer flag) {
		this.flag = flag;
	}

	/**
	 * Getter method for property <tt>days</tt>.
	 * 
	 * @return property value of days
	 */
	public Integer getDays() {
		return days;
	}

	/**
	 * Setter method for property <tt>days</tt>.
	 * 
	 * @param days value to be assigned to property days
	 */
	public void setDays(Integer days) {
		this.days = days;
	}

	/**
	 * Getter method for property <tt>state1</tt>.
	 * 
	 * @return property value of state1
	 */
	public String getState1() {
		return state1;
	}

	/**
	 * Setter method for property <tt>state1</tt>.
	 * 
	 * @param state1 value to be assigned to property state1
	 */
	public void setState1(String state1) {
		this.state1 = state1;
	}

	/**
	 * Getter method for property <tt>countSerialNo</tt>.
	 * 
	 * @return property value of countSerialNo
	 */
	public int getCountSerialNo() {
		return countSerialNo;
	}

	/**
	 * Setter method for property <tt>countSerialNo</tt>.
	 * 
	 * @param countSerialNo value to be assigned to property countSerialNo
	 */
	public void setCountSerialNo(int countSerialNo) {
		this.countSerialNo = countSerialNo;
	}

	public String getSerialNo() {
        return serialNo;
    }

    public void setSerialNo(String serialNo) {
        this.serialNo = serialNo == null ? null : serialNo.trim();
    }

    public String getClass5State() {
        return class5State;
    }

    public void setClass5State(String class5State) {
        this.class5State = class5State == null ? null : class5State.trim();
    }

    public BigDecimal getBalance() {
        return balance;
    }

    public void setBalance(BigDecimal balance) {
        this.balance = balance;
    }

    public Integer getRemainCycles() {
        return remainCycles;
    }

    public void setRemainCycles(Integer remainCycles) {
        this.remainCycles = remainCycles;
    }

    public BigDecimal getScheduledAmt() {
        return scheduledAmt;
    }

    public void setScheduledAmt(BigDecimal scheduledAmt) {
        this.scheduledAmt = scheduledAmt;
    }

    public String getScheduledDate() {
        return scheduledDate;
    }

    public void setScheduledDate(String scheduledDate) {
        this.scheduledDate = scheduledDate == null ? null : scheduledDate.trim();
    }

    public BigDecimal getActualAmt() {
        return actualAmt;
    }

    public void setActualAmt(BigDecimal actualAmt) {
        this.actualAmt = actualAmt;
    }

    public String getRecentPayDate() {
        return recentPayDate;
    }

    public void setRecentPayDate(String recentPayDate) {
        this.recentPayDate = recentPayDate == null ? null : recentPayDate.trim();
    }

    public Integer getOverdueCycle() {
        return overdueCycle;
    }

    public void setOverdueCycle(Integer overdueCycle) {
        this.overdueCycle = overdueCycle;
    }

    public BigDecimal getOverdueAmt() {
        return overdueAmt;
    }

    public void setOverdueAmt(BigDecimal overdueAmt) {
        this.overdueAmt = overdueAmt;
    }

    public BigDecimal getOverdue31to60Amt() {
        return overdue31to60Amt;
    }

    public void setOverdue31to60Amt(BigDecimal overdue31to60Amt) {
        this.overdue31to60Amt = overdue31to60Amt;
    }

    public BigDecimal getOverdue61to90Amt() {
        return overdue61to90Amt;
    }

    public void setOverdue61to90Amt(BigDecimal overdue61to90Amt) {
        this.overdue61to90Amt = overdue61to90Amt;
    }

    public BigDecimal getOverdue91to180Amt() {
        return overdue91to180Amt;
    }

    public void setOverdue91to180Amt(BigDecimal overdue91to180Amt) {
        this.overdue91to180Amt = overdue91to180Amt;
    }

    public BigDecimal getOverdueOver180Amt() {
        return overdueOver180Amt;
    }

    public void setOverdueOver180Amt(BigDecimal overdueOver180Amt) {
        this.overdueOver180Amt = overdueOver180Amt;
    }

    public String getReportNo() {
        return reportNo;
    }

    public void setReportNo(String reportNo) {
        this.reportNo = reportNo == null ? null : reportNo.trim();
    }

    public String getBizType() {
        return bizType;
    }

    public void setBizType(String bizType) {
        this.bizType = bizType == null ? null : bizType.trim();
    }

    public String getNote() {
        return note;
    }

    public void setNote(String note) {
        this.note = note == null ? null : note.trim();
    }

    public String getFinanceOrg() {
        return financeOrg;
    }

    public void setFinanceOrg(String financeOrg) {
        this.financeOrg = financeOrg == null ? null : financeOrg.trim();
    }

    public String getAccount() {
        return account;
    }

    public void setAccount(String account) {
        this.account = account == null ? null : account.trim();
    }

    public String getType() {
        return type;
    }

    public void setType(String type) {
        this.type = type == null ? null : type.trim();
    }

    public String getCurrency() {
        return currency;
    }

    public void setCurrency(String currency) {
        this.currency = currency == null ? null : currency.trim();
    }

    public String getOpenDate() {
        return openDate;
    }

    public void setOpenDate(String openDate) {
        this.openDate = openDate == null ? null : openDate.trim();
    }

    public String getEndDate() {
        return endDate;
    }

    public void setEndDate(String endDate) {
        this.endDate = endDate == null ? null : endDate.trim();
    }

    public BigDecimal getLimitAmt() {
        return limitAmt;
    }

    public void setLimitAmt(BigDecimal limitAmt) {
        this.limitAmt = limitAmt;
    }

    public String getGuarantyType() {
        return guarantyType;
    }

    public void setGuarantyType(String guarantyType) {
        this.guarantyType = guarantyType == null ? null : guarantyType.trim();
    }

    public String getPaymentFreq() {
        return paymentFreq;
    }

    public void setPaymentFreq(String paymentFreq) {
        this.paymentFreq = paymentFreq == null ? null : paymentFreq.trim();
    }

    public String getPaymentCycle() {
        return paymentCycle;
    }

    public void setPaymentCycle(String paymentCycle) {
        this.paymentCycle = paymentCycle == null ? null : paymentCycle.trim();
    }

    public String getState() {
        return state;
    }

    public void setState(String state) {
        this.state = state == null ? null : state.trim();
    }

    public BigDecimal getBadBalance() {
        return badBalance;
    }

    public void setBadBalance(BigDecimal badBalance) {
        this.badBalance = badBalance;
    }

    public String getStateEndDate() {
        return stateEndDate;
    }

    public void setStateEndDate(String stateEndDate) {
        this.stateEndDate = stateEndDate == null ? null : stateEndDate.trim();
    }

    public String getStateEndMonth() {
        return stateEndMonth;
    }

    public void setStateEndMonth(String stateEndMonth) {
        this.stateEndMonth = stateEndMonth == null ? null : stateEndMonth.trim();
    }

    public String getBeginMonth() {
        return beginMonth;
    }

    public void setBeginMonth(String beginMonth) {
        this.beginMonth = beginMonth == null ? null : beginMonth.trim();
    }

    public String getEndMonth() {
        return endMonth;
    }

    public void setEndMonth(String endMonth) {
        this.endMonth = endMonth == null ? null : endMonth.trim();
    }

    public String getLatest24State() {
        return latest24State;
    }

    public void setLatest24State(String latest24State) {
        this.latest24State = latest24State == null ? null : latest24State.trim();
    }
}