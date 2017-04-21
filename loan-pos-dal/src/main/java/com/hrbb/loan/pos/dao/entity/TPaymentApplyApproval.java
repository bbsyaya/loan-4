package com.hrbb.loan.pos.dao.entity;

import java.io.Serializable;
import java.util.Date;

public class TPaymentApplyApproval implements Serializable{
    /**
	 * 
	 */
	private static final long serialVersionUID = -3630577149043569750L;

	private String payApplyId;

    private Integer payApplyNum;

    private String approvalName;

    private String approvalContent;

    private Integer approvalStatus;

    private Date approvalStartTime;

    private Date approvalEndTime;

    private String paymentStatusBefore;

    private String paymentStatusAfter;
    
    private Date apprBeginDate;
    
    private Date apprEndDate;
    
    private int graceDays;		/*宽限天数*/
    
    private int scheduleTimes;	/*计划还款期次*/

    public int getScheduleTimes() {
		return scheduleTimes;
	}

	public void setScheduleTimes(int scheduleTimes) {
		this.scheduleTimes = scheduleTimes;
	}

	public int getGraceDays() {
		return graceDays;
	}

	public void setGraceDays(int graceDays) {
		this.graceDays = graceDays;
	}

	public Date getApprBeginDate() {
		return apprBeginDate;
	}

	public void setApprBeginDate(Date apprBeginDate) {
		this.apprBeginDate = apprBeginDate;
	}

	public Date getApprEndDate() {
		return apprEndDate;
	}

	public void setApprEndDate(Date apprEndDate) {
		this.apprEndDate = apprEndDate;
	}

	public String getPayApplyId() {
        return payApplyId;
    }

    public void setPayApplyId(String payApplyId) {
        this.payApplyId = payApplyId == null ? null : payApplyId.trim();
    }

    public Integer getPayApplyNum() {
        return payApplyNum;
    }

    public void setPayApplyNum(Integer payApplyNum) {
        this.payApplyNum = payApplyNum;
    }

    public String getApprovalName() {
        return approvalName;
    }

    public void setApprovalName(String approvalName) {
        this.approvalName = approvalName == null ? null : approvalName.trim();
    }

    public String getApprovalContent() {
        return approvalContent;
    }

    public void setApprovalContent(String approvalContent) {
        this.approvalContent = approvalContent == null ? null : approvalContent.trim();
    }

    public Integer getApprovalStatus() {
        return approvalStatus;
    }

    public void setApprovalStatus(Integer approvalStatus) {
        this.approvalStatus = approvalStatus;
    }

    public Date getApprovalStartTime() {
        return approvalStartTime;
    }

    public void setApprovalStartTime(Date approvalStartTime) {
        this.approvalStartTime = approvalStartTime;
    }

    public Date getApprovalEndTime() {
        return approvalEndTime;
    }

    public void setApprovalEndTime(Date approvalEndTime) {
        this.approvalEndTime = approvalEndTime;
    }

    public String getPaymentStatusBefore() {
        return paymentStatusBefore;
    }

    public void setPaymentStatusBefore(String paymentStatusBefore) {
        this.paymentStatusBefore = paymentStatusBefore == null ? null : paymentStatusBefore.trim();
    }

    public String getPaymentStatusAfter() {
        return paymentStatusAfter;
    }

    public void setPaymentStatusAfter(String paymentStatusAfter) {
        this.paymentStatusAfter = paymentStatusAfter == null ? null : paymentStatusAfter.trim();
    }
    
    public String toString(){
    	StringBuffer sb = new StringBuffer("");
    	sb.append("PayApplyId=").append(this.getPayApplyId()).append("|");
    	sb.append("ApprovalName=").append(this.getApprovalName()).append("|");
    	sb.append("StatusBefore=").append(this.getPaymentStatusBefore()).append("|");
    	sb.append("StatusAfter=").append(this.getPaymentStatusAfter()).append("|");
    	sb.append("Content=").append(this.getApprovalContent()).append("|");
    	sb.append("BeginDate=").append(this.getApprBeginDate()).append("|");
    	sb.append("EndDate=").append(this.getApprEndDate());
    	return sb.toString();
    }
}