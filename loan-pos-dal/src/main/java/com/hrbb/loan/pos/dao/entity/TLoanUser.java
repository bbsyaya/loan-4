package com.hrbb.loan.pos.dao.entity;

import java.io.Serializable;

public class TLoanUser implements Serializable{
    /**
	 * 
	 */
	private static final long serialVersionUID = -1297317039177679224L;

	private String loanId;

    private String userId;

    private String appSource;
    
    private String payapplyid;

    public String getLoanId() {
        return loanId;
    }

    public void setLoanId(String loanId) {
        this.loanId = loanId == null ? null : loanId.trim();
    }

    public String getUserId() {
        return userId;
    }

    public void setUserId(String userId) {
        this.userId = userId == null ? null : userId.trim();
    }

    public String getAppSource() {
        return appSource;
    }

    public void setAppSource(String appSource) {
        this.appSource = appSource == null ? null : appSource.trim();
    }

    public String getPayapplyid() {
        return payapplyid;
    }

    public void setPayapplyid(String payapplyid) {
        this.payapplyid = payapplyid;
    }
}