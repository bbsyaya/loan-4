/**
 * 
 *	哈尔滨银行
 * Copyright (c) 2007-2015 HRBB,Inc.All Rights Reserved.
 */
package com.hrbb.loan.pos.service.bean;

import java.io.Serializable;
import java.math.BigDecimal;

/**
 * 保证金补充通知：用款申请编号,保证金账号,账户余额,应追加金额
 * 
 * @author guoyu
 * @version $Id: BondSupplementMessage.java, v 0.1 2015年3月16日 下午6:28:39 guoyu
 *          Exp $
 */
public class BondSupplementMessage implements Serializable {

	/**  */
	private static final long serialVersionUID = 5736488025745054625L;

	private String issueid;
	private String accno;
	private BigDecimal balance;
	private BigDecimal margin;

	/**
	 * Getter method for property <tt>issueid</tt>.
	 * 
	 * @return property value of issueid
	 */
	public String getIssueid() {
		return issueid;
	}

	/**
	 * Setter method for property <tt>issueid</tt>.
	 * 
	 * @param issueid
	 *            value to be assigned to property issueid
	 */
	public void setIssueid(String issueid) {
		this.issueid = issueid;
	}

	/**
	 * Getter method for property <tt>accno</tt>.
	 * 
	 * @return property value of accno
	 */
	public String getAccno() {
		return accno;
	}

	/**
	 * Setter method for property <tt>accno</tt>.
	 * 
	 * @param accno
	 *            value to be assigned to property accno
	 */
	public void setAccno(String accno) {
		this.accno = accno;
	}

	/**
	 * Getter method for property <tt>balance</tt>.
	 * 
	 * @return property value of balance
	 */
	public BigDecimal getBalance() {
		return balance;
	}

	/**
	 * Setter method for property <tt>balance</tt>.
	 * 
	 * @param balance
	 *            value to be assigned to property balance
	 */
	public void setBalance(BigDecimal balance) {
		this.balance = balance;
	}

	/**
	 * Getter method for property <tt>margin</tt>.
	 * 
	 * @return property value of margin
	 */
	public BigDecimal getMargin() {
		return margin;
	}

	/**
	 * Setter method for property <tt>margin</tt>.
	 * 
	 * @param margin
	 *            value to be assigned to property margin
	 */
	public void setMargin(BigDecimal margin) {
		this.margin = margin;
	}

	public String toString() {
		return new String("\"issueid\":\"" + issueid + "\"," + "\"accno\":\"" + accno
				+ "\"," + "\"balance\":\"" + balance + "\"," + "\"margin\":\""
				+ margin + "\"").replaceAll("[\\t\\n\\r]", "");
	}
}
