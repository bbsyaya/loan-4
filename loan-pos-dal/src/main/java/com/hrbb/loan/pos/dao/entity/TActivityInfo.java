package com.hrbb.loan.pos.dao.entity;

import java.io.Serializable;

public class TActivityInfo implements Serializable{
    /**
	 * 
	 */
	private static final long serialVersionUID = -6799648407532502060L;

	private String actId;

    private String actName;

    private String actAccessSql;

    private String actContentSql;
    
    private String actParam;
    
    private String actFlag;
    
    private String activityType;
    
    private String actionName;
    
    
    
    

    public String getActivityType() {
		return activityType;
	}

	public void setActivityType(String activityType) {
		this.activityType = activityType;
	}

	public String getActionName() {
		return actionName;
	}

	public void setActionName(String actionName) {
		this.actionName = actionName;
	}

	public String getActParam() {
		return actParam;
	}

	public void setActParam(String actParam) {
		this.actParam = actParam;
	}

	public String getActFlag() {
		return actFlag;
	}

	public void setActFlag(String actFlag) {
		this.actFlag = actFlag;
	}

	public String getActId() {
        return actId;
    }

    public void setActId(String actId) {
        this.actId = actId == null ? null : actId.trim();
    }

    public String getActName() {
        return actName;
    }

    public void setActName(String actName) {
        this.actName = actName == null ? null : actName.trim();
    }

    public String getActAccessSql() {
        return actAccessSql;
    }

    public void setActAccessSql(String actAccessSql) {
        this.actAccessSql = actAccessSql == null ? null : actAccessSql.trim();
    }

    public String getActContentSql() {
        return actContentSql;
    }

    public void setActContentSql(String actContentSql) {
        this.actContentSql = actContentSql == null ? null : actContentSql.trim();
    }
}