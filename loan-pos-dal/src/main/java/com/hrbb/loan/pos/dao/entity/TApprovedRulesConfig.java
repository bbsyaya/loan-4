package com.hrbb.loan.pos.dao.entity;

import java.util.Date;

public class TApprovedRulesConfig {
    private Integer id;

	private String ruleNo;

	private String prodId;

	private String prodName;

	private String channel;

	private String region;

	private Double age;

	private Double amt_uplimit;

	private String deleted_flag;

	private Date valid_date;

	private Date invalid_date;

	private Date create_date;

	private Date modify_date;

	public Integer getId() {
		return id;
	}

	public void setId(Integer id) {
		this.id = id;
	}

	public String getRuleNo() {
		return ruleNo;
	}

	public void setRuleNo(String ruleNo) {
		this.ruleNo = ruleNo == null ? null : ruleNo.trim();
	}

	public String getProdId() {
		return prodId;
	}

	public void setProdId(String prodId) {
		this.prodId = prodId == null ? null : prodId.trim();
	}

	public String getProdName() {
		return prodName;
	}

	public void setProdName(String prodName) {
		this.prodName = prodName == null ? null : prodName.trim();
	}

	public String getChannel() {
		return channel;
	}

	public void setChannel(String channel) {
		this.channel = channel == null ? null : channel.trim();
	}

	public String getRegion() {
		return region;
	}

	public void setRegion(String region) {
		this.region = region == null ? null : region.trim();
	}

	public Double getAge() {
		return age;
	}

	public void setAge(Double age) {
		this.age = age;
	}

	public Double getAmt_uplimit() {
		return amt_uplimit;
	}

	public void setAmt_uplimit(Double amt_uplimit) {
		this.amt_uplimit = amt_uplimit;
	}

	public String getDeleted_flag() {
		return deleted_flag;
	}

	public void setDeleted_flag(String deleted_flag) {
		this.deleted_flag = deleted_flag == null ? null : deleted_flag.trim();
	}

	public Date getValid_date() {
		return valid_date;
	}

	public void setValid_date(Date valid_date) {
		this.valid_date = valid_date;
	}

	public Date getInvalid_date() {
		return invalid_date;
	}

	public void setInvalid_date(Date invalid_date) {
		this.invalid_date = invalid_date;
	}

	public Date getCreate_date() {
		return create_date;
	}

	public void setCreate_date(Date create_date) {
		this.create_date = create_date;
	}

	public Date getModify_date() {
		return modify_date;
	}

	public void setModify_date(Date modify_date) {
		this.modify_date = modify_date;
	}

}