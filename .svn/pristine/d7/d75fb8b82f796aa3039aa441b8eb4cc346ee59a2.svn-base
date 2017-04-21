package com.hrbb.loan.web.security.entity;

import java.util.Date;
import java.util.List;

public class User implements Identifiable<Integer> {
    private Integer userId;
    private String userName = null;
    private String password = null;
    private String loginName = null;
    private String cellphone = null;
    private String email = null;
    private String tel = null;
    private String loginType;
    private Date loginDate = null;
    private String locked = null;
    private String assignedRoleList = null;


    public Integer getUserId() {
		return userId;
	}


	public void setUserId(Integer userId) {
		this.userId = userId;
	}


	public String getUserName() {
		return userName;
	}


	public void setUserName(String userName) {
		this.userName = userName;
	}


	public String getPassword() {
		return password;
	}


	public void setPassword(String password) {
		this.password = password;
	}


	@Override
    public String toString() {
        return this.userName;
    }


	@Override
	public Integer getId() {
		// TODO Auto-generated method stub
		return userId;
	}


	@Override
	public void setId(Integer id) {
		// TODO Auto-generated method stub
		userId=id;
		
	}


	public String getLoginName() {
		return loginName;
	}


	public void setLoginName(String loginName) {
		this.loginName = loginName;
	}


	public String getCellphone() {
		return cellphone;
	}


	public void setCellphone(String cellphone) {
		this.cellphone = cellphone;
	}


	public String getEmail() {
		return email;
	}


	public void setEmail(String email) {
		this.email = email;
	}


	public String getTel() {
		return tel;
	}


	public void setTel(String tel) {
		this.tel = tel;
	}

	public String getLoginType() {
        return loginType;
    }


    public void setLoginType(String loginType) {
        this.loginType = loginType;
    }


    public Date getLoginDate() {
		return loginDate;
	}


	public void setLoginDate(Date loginDate) {
		this.loginDate = loginDate;
	}


    public String getLocked() {
        return locked;
    }


    public void setLocked(String locked) {
        this.locked = locked;
    }


    public String getAssignedRoleList() {
        return assignedRoleList;
    }


    public void setAssignedRoleList(String assignedRoleList) {
        this.assignedRoleList = assignedRoleList;
    }


    @Override
    public int hashCode() {
        final int prime = 31;
        int result = 1;
        result = prime * result + userId;
        return result;
    }


    @Override
    public boolean equals(Object obj) {
        if (this == obj)
            return true;
        if (obj == null)
            return false;
        if (! (obj instanceof User))
            return false;
        User other = (User) obj;
        if (userId != other.userId)
            return false;
        return true;
    }

}