package com.hrbb.loan.web.domain.query;

import com.hrbb.loan.web.security.entity.Privilege;

public class PrivilegeQuery extends Privilege {
	private static final long serialVersionUID = -1L;


	private String privilegeNameLike;


    public String getPrivilegeNameLike() {
        return privilegeNameLike;
    }


    public void setPrivilegeNameLike(String privilegeNameLike) {
        this.privilegeNameLike = privilegeNameLike;
    }


}
