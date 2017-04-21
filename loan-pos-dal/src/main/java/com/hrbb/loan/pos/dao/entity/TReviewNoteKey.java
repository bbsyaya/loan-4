package com.hrbb.loan.pos.dao.entity;

import java.io.Serializable;

public class TReviewNoteKey implements Serializable{
	
	
    /**
	 * 
	 */
	private static final long serialVersionUID = -4160598843527530209L;

	private String loanid;

    private Integer reviewid;

    public String getloanid() {
        return loanid;
    }

    public void setloanid(String loanid) {
        this.loanid = loanid == null ? null : loanid.trim();
    }

    public Integer getReviewid() {
        return reviewid;
    }

    public void setReviewid(Integer reviewid) {
        this.reviewid = reviewid;
    }
}