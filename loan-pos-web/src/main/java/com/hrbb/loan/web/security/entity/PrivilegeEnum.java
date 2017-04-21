package com.hrbb.loan.web.security.entity;

public enum PrivilegeEnum {

	/** This role is for a user with admin privileges */
    ADMIN_ROLE("ROLE_ADMIN"),
    APPLY_APPROVER_ROLE("ROLE_APPLY_APPROVER"),
    OURSOURCE_ROLE("ROLE_OUTSOURE");

    private String privilege;
    
    private PrivilegeEnum(String privilege) {
        this.privilege = privilege;
    }

    public String getPrivilege() {
        return privilege;
    }

    public static PrivilegeEnum getPrivielgeByName(String privilege) {
        for (PrivilegeEnum privielege : PrivilegeEnum.values()) {
            if (privielege.getPrivilege().equals(privilege)) {
                return privielege;
            }
        }
        return null;
    }
}
