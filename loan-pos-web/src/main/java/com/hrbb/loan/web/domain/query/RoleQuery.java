package com.hrbb.loan.web.domain.query;

import com.hrbb.loan.web.security.entity.Role;

public class RoleQuery extends Role {
	private static final long serialVersionUID = -1L;


	private String roleNameLike;

	public String getRoleNameLike() {
		return roleNameLike;
	}

	public void setRoleNameLike(String roleNameLike) {
		this.roleNameLike = roleNameLike;
	}

}
