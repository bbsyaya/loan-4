package com.hrbb.loan.web.security.entity;


public class Privilege implements Identifiable<Integer> {

    private Integer   privilegeId;
    private String privilegeName;
    private String displayName;
    private String remark;

    public Integer getPrivilegeId() {
        return privilegeId;
    }

    public void setPrivilegeId(Integer privilegeId) {
        this.privilegeId = privilegeId;
    }

    public String getPrivilegeName() {
        return privilegeName;
    }

    public void setPrivilegeName(String privilegeName) {
        this.privilegeName = privilegeName;
    }

    public String getRemark() {
        return remark;
    }

    public void setRemark(String remark) {
        this.remark = remark;
    }

    @Override
    public Integer getId() {
        return privilegeId;
    }

    @Override
    public void setId(Integer id) {
        privilegeId = id;
    }

    public String getDisplayName() {
        return displayName;
    }

    public void setDisplayName(String displayName) {
        this.displayName = displayName;
    }

    @Override
    public int hashCode() {
        final int prime = 31;
        int result = 1;
        result = prime * result + privilegeId;
        return result;
    }

    @Override
    public boolean equals(Object obj) {
        if (this == obj)
            return true;
        if (obj == null)
            return false;
        if (!(obj instanceof Privilege))
            return false;
        Privilege other = (Privilege) obj;
        if (privilegeId != other.privilegeId)
            return false;
        return true;
    }
}
