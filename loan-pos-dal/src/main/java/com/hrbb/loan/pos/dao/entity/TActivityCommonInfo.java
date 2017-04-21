package com.hrbb.loan.pos.dao.entity;

import java.io.Serializable;

public class TActivityCommonInfo implements Serializable{

/**
	 * 
	 */
	private static final long serialVersionUID = -6735044150628277648L;

private Integer id;
	
	private String commonSql;
	
	private String activityType;

	public Integer getId() {
		return id;
	}

	public void setId(Integer id) {
		this.id = id;
	}

	public String getCommonSql() {
		return commonSql;
	}

	public void setCommonSql(String commonSql) {
		this.commonSql = commonSql;
	}

	public String getActivityType() {
		return activityType;
	}

	public void setActivityType(String activityType) {
		this.activityType = activityType;
	}
}
