/**
 * 
 *	哈尔滨银行
 * Copyright (c) 2007-2015 HRBB,Inc.All Rights Reserved.
 */
package com.hrbb.loan.pos.service.bean;

import java.io.Serializable;

/**
 * 
 * @author byp
 * @version $Id: OverDueMessage.java, v 0.1 2015年3月16日 下午7:01:45 byp Exp $
 */
public class OverDueMessage implements Serializable{

    /**
	 * 
	 */
	private static final long serialVersionUID = -4005084791824919226L;

	private String listId;

    private String bankAcNo;

    private String crExpDate;

    private String repayExpDate;

    private String repayTotalAmt;

    private String repayPrincipal;

    private String repayInt;

    private String repayFineInt;

    /**
     * 
     */
    public OverDueMessage() {
    }

    public String getListId() {
        return listId;
    }

    public OverDueMessage setListId(String listId) {
        this.listId = listId;
        return this;
    }

    public String getBankAcNo() {
        return bankAcNo;
    }

    public OverDueMessage setBankAcNo(String bankAcNo) {
        this.bankAcNo = bankAcNo;
        return this;
    }

    public String getCrExpDate() {
        return crExpDate;
    }

    public OverDueMessage setCrExpDate(String crExpDate) {
        this.crExpDate = crExpDate;
        return this;
   }

    public String getRepayExpDate() {
        return repayExpDate;
    }

    public OverDueMessage setRepayExpDate(String repayExpDate) {
        this.repayExpDate = repayExpDate;
        return this;
   }

    public String getRepayTotalAmt() {
        return repayTotalAmt;
    }

    public OverDueMessage setRepayTotalAmt(String repayTotalAmt) {
        this.repayTotalAmt = repayTotalAmt;
        return this;
    }

    public String getRepayPrincipal() {
        return repayPrincipal;
    }

    public OverDueMessage setRepayPrincipal(String repayPrincipal) {
        this.repayPrincipal = repayPrincipal;
        return this;
    }

    public String getRepayInt() {
        return repayInt;
    }

    public OverDueMessage setRepayInt(String repayInt) {
        this.repayInt = repayInt;
        return this;
    }

    public String getRepayFineInt() {
        return repayFineInt;
    }

    public OverDueMessage setRepayFineInt(String repayFineInt) {
        this.repayFineInt = repayFineInt;
        return this;
    }
    
    public String toString(){
        return new String("\"listid\":\""+listId + "\","
                + "\"bankacno\":\"" + bankAcNo + "\","
                + "\"crexpdate\":\"" + crExpDate + "\","
                + "\"repaytotalamt\":\"" + repayTotalAmt + "\","
                + "\"repayprincipal\":\"" + repayPrincipal + "\","
                + "\"repayint\":\"" + repayInt + "\","
                + "\"repayfineint\":\"" + repayFineInt+"\"").replaceAll("[\\t\\n\\r]", "");
    }

}
