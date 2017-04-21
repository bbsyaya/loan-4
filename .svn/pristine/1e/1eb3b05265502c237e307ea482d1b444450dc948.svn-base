package com.hrbb.loan.web.security.entity;


public class Role implements Identifiable<Integer>{

    private Integer roleId;
	private String roleName;
	private String remark;
	private String locked;
	private String assignedPrivilegeList;
	public Integer getRoleId() {
		return roleId;
	}
	public void setRoleId(Integer roleId) {
		this.roleId = roleId;
	}
	public String getRoleName() {
		return roleName;
	}
	public void setRoleName(String roleName) {
		this.roleName = roleName;
	}
	public String getRemark() {
		return remark;
	}
	public void setRemark(String remark) {
		this.remark = remark;
	}
	@Override
	public Integer getId() {
		return roleId;
	}
	@Override
	public void setId(Integer id) {
		roleId=id;		
	}
    public String getLocked() {
        return locked;
    }
    public void setLocked(String locked) {
        this.locked = locked;
    }
    public String getAssignedPrivilegeList() {
        return assignedPrivilegeList;
    }
    public void setAssignedPrivilegeList(String assignedPrivilegeList) {
        this.assignedPrivilegeList = assignedPrivilegeList;
    }
    @Override
    public int hashCode() {
        final int prime = 31;
        int result = 1;
        result = prime * result + roleId;
        return result;
    }
    @Override
    public boolean equals(Object obj) {
        if (this == obj)
            return true;
        if (obj == null)
            return false;
        if (!(obj instanceof Role))
            return false;
        Role other = (Role) obj;
        if (roleId != other.roleId)
            return false;
        return true;
    }

}
