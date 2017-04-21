package com.hrbb.loan.pos.dao.entity;

import java.io.Serializable;
import java.util.Date;

public class TReviewNote extends TReviewNoteKey implements Serializable{
	
	/**
	 * 
	 */
	private static final long serialVersionUID = -6468162373140198606L;

	private String[] reviewids;
	
	private String teltype;
	
    private String tel;

	private String relationtype;

	private String result;

	private Date reviewday;
	
	private String reviewdayStr;

	private String registrarname;

	private Date registrationday;

	private String note;
	
	/**
	 * Getter method for property <tt>note</tt>.
	 * 
	 * @return property value of note
	 */
	public String getNote() {
		return note;
	}

	/**
	 * Setter method for property <tt>note</tt>.
	 * 
	 * @param note value to be assigned to property note
	 */
	public void setNote(String note) {
		this.note = note;
	}

	/**
	 * Getter method for property <tt>teltype</tt>.
	 * 
	 * @return property value of teltype
	 */
	public String getTeltype() {
		return teltype;
	}

	/**
	 * Setter method for property <tt>teltype</tt>.
	 * 
	 * @param teltype value to be assigned to property teltype
	 */
	public void setTeltype(String teltype) {
		this.teltype = teltype;
	}

	/**
	 * Getter method for property <tt>reviewdayStr</tt>.
	 * 
	 * @return property value of reviewdayStr
	 */
	public String getReviewdayStr() {
		return reviewdayStr;
	}

	/**
	 * Setter method for property <tt>reviewdayStr</tt>.
	 * 
	 * @param reviewdayStr value to be assigned to property reviewdayStr
	 */
	public void setReviewdayStr(String reviewdayStr) {
		this.reviewdayStr = reviewdayStr;
	}

	/**
	 * Getter method for property <tt>reviewids</tt>.
	 * 
	 * @return property value of reviewids
	 */
	public String[] getReviewids() {
		return reviewids;
	}

	/**
	 * Setter method for property <tt>reviewids</tt>.
	 * 
	 * @param reviewids value to be assigned to property reviewids
	 */
	public void setReviewids(String[] reviewids) {
		this.reviewids = reviewids;
	}

	public String getTel() {
		return tel;
	}

	public void setTel(String tel) {
		this.tel = tel == null ? null : tel.trim();
	}

	public String getRelationtype() {
		return relationtype;
	}

	public void setRelationtype(String relationtype) {
		this.relationtype = relationtype == null ? null : relationtype.trim();
	}

	public String getResult() {
		return result;
	}

	public void setResult(String result) {
		this.result = result == null ? null : result.trim();
	}

	public Date getReviewday() {
		return reviewday;
	}

	public void setReviewday(Date reviewday) {
		this.reviewday = reviewday;
	}

	public String getRegistrarname() {
		return registrarname;
	}

	public void setRegistrarname(String registrarname) {
		this.registrarname = registrarname == null ? null : registrarname
				.trim();
	}

	public Date getRegistrationday() {
		return registrationday;
	}

	public void setRegistrationday(Date registrationday) {
		this.registrationday = registrationday;
	}

}