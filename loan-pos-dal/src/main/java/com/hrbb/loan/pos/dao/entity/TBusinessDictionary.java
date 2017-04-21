package com.hrbb.loan.pos.dao.entity;

import java.io.Serializable;

public class TBusinessDictionary implements Serializable{
	
	
	/**
	 * 
	 */
	private static final long serialVersionUID = 8855856889600926208L;

	private Integer id;

	private String codeNo;

	private String codeName;

	private String itemNo;

	private String itemName;

	private String status;

	private String extAttr;

	/**
	 * Getter method for property <tt>extAttr</tt>.
	 * 
	 * @return property value of extAttr
	 */
	public String getExtAttr() {
		return extAttr;
	}

	/**
	 * Setter method for property <tt>extAttr</tt>.
	 * 
	 * @param extAttr
	 *            value to be assigned to property extAttr
	 */
	public void setExtAttr(String extAttr) {
		this.extAttr = extAttr;
	}

	public Integer getId() {
		return id;
	}

	public void setId(Integer id) {
		this.id = id;
	}

	public String getCodeNo() {
		return codeNo;
	}

	public void setCodeNo(String codeNo) {
		this.codeNo = codeNo == null ? null : codeNo.trim();
	}

	public String getCodeName() {
		return codeName;
	}

	public void setCodeName(String codeName) {
		this.codeName = codeName == null ? null : codeName.trim();
	}

	public String getItemNo() {
		return itemNo;
	}

	public void setItemNo(String itemNo) {
		this.itemNo = itemNo == null ? null : itemNo.trim();
	}

	public String getItemName() {
		return itemName;
	}

	public void setItemName(String itemName) {
		this.itemName = itemName == null ? null : itemName.trim();
	}

	public String getStatus() {
		return status;
	}

	public void setStatus(String status) {
		this.status = status == null ? null : status.trim();
	}
}