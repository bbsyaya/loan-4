package com.hrbb.loan.pos.dao.entity;

import java.io.Serializable;

public class TCreditApplyAprvInfoKey implements Serializable{
    /**
	 * 
	 */
	private static final long serialVersionUID = 9064498254802548285L;

	private Integer appNum;

    private String loanId;

    public Integer getAppNum() {
        return appNum;
    }

    public void setAppNum(Integer appNum) {
        this.appNum = appNum;
    }

    public String getLoanId() {
        return loanId;
    }

    public void setLoanId(String loanId) {
        this.loanId = loanId == null ? null : loanId.trim();
    }

}