package com.hrbb.loan.pos.dao.entity;

import java.io.Serializable;
import java.util.Date;

public class TCreditApplyReturnInfo extends TCreditApplyReturnInfoKey implements Serializable{
    /**
	 * 
	 */
	private static final long serialVersionUID = 262968984596090706L;

	private String applyStatus;

    private String claimUserId;

    private Date claimTime;

    private Date returnTime;

    private String returnReason;

    public String getApplyStatus() {
        return applyStatus;
    }

    public void setApplyStatus(String applyStatus) {
        this.applyStatus = applyStatus == null ? null : applyStatus.trim();
    }

    public String getClaimUserId() {
        return claimUserId;
    }

    public void setClaimUserId(String claimUserId) {
        this.claimUserId = claimUserId == null ? null : claimUserId.trim();
    }

    public Date getClaimTime() {
        return claimTime;
    }

    public void setClaimTime(Date claimTime) {
        this.claimTime = claimTime;
    }

    public Date getReturnTime() {
        return returnTime;
    }

    public void setReturnTime(Date returnTime) {
        this.returnTime = returnTime;
    }

    public String getReturnReason() {
        return returnReason;
    }

    public void setReturnReason(String returnReason) {
        this.returnReason = returnReason == null ? null : returnReason.trim();
    }
}