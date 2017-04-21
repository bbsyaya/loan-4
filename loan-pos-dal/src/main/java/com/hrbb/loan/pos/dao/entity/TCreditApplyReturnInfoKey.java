package com.hrbb.loan.pos.dao.entity;

import java.io.Serializable;

public class TCreditApplyReturnInfoKey implements Serializable{
    /**
	 * 
	 */
	private static final long serialVersionUID = 2568969654645507657L;

	private String loanId;

    private Integer serialNum;

    public String getLoanId() {
        return loanId;
    }

    public void setLoanId(String loanId) {
        this.loanId = loanId == null ? null : loanId.trim();
    }

    public Integer getSerialNum() {
        return serialNum;
    }

    public void setSerialNum(Integer serialNum) {
        this.serialNum = serialNum;
    }
}