package com.hrbb.loan.pos.dao.entity;

import java.io.Serializable;

public class TActivityTypeInfo implements Serializable{
	
	/**
	 * 
	 */
	private static final long serialVersionUID = 4330059013438900830L;

	private Integer id;
	
	private String activityName;
	
	private String activityType;
	
	private String activityCnName;

	public Integer getId() {
		return id;
	}

	public void setId(Integer id) {
		this.id = id;
	}

	public String getActivityName() {
		return activityName;
	}

	public void setActivityName(String activityName) {
		this.activityName = activityName;
	}

	public String getActivityType() {
		return activityType;
	}

	public void setActivityType(String activityType) {
		this.activityType = activityType;
	}

	public String getActivityCnName() {
		return activityCnName;
	}

	public void setActivityCnName(String activityCnName) {
		this.activityCnName = activityCnName;
	}
	
	

	

}
