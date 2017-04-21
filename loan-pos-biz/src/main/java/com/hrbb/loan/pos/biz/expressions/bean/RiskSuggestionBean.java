/**
 * 
 *	哈尔滨银行
 * Copyright (c) 2007-2015 HRBB,Inc.All Rights Reserved.
 */
package com.hrbb.loan.pos.biz.expressions.bean;

/**
 * 
 * @author XLY
 * @version $Id: RiskSuggestionBean.java, v 0.1 2015-3-10 下午4:55:55 XLY Exp $
 */
public class RiskSuggestionBean {

	private String suggestDecision;
	private String declineReason;
	private String suggestDiligence;

	public String getDeclineReason() {
		return declineReason;
	}

	public void setDeclineReason(String declineReason) {
		this.declineReason = declineReason;
	}

	/**
	 * Getter method for property <tt>suggestDecision</tt>.
	 * 
	 * @return property value of suggestDecision
	 */
	public String getSuggestDecision() {
		return suggestDecision;
	}

	/**
	 * Setter method for property <tt>suggestDecision</tt>.
	 * 
	 * @param suggestDecision
	 *            value to be assigned to property suggestDecision
	 */
	public void setSuggestDecision(String suggestDecision) {
		this.suggestDecision = suggestDecision;
	}

	/**
	 * Getter method for property <tt>suggestDiligence</tt>.
	 * 
	 * @return property value of suggestDiligence
	 */
	public String getSuggestDiligence() {
		return suggestDiligence;
	}

	/**
	 * Setter method for property <tt>suggestDiligence</tt>.
	 * 
	 * @param suggestDiligence
	 *            value to be assigned to property suggestDiligence
	 */
	public void setSuggestDiligence(String suggestDiligence) {
		this.suggestDiligence = suggestDiligence;
	}

}
