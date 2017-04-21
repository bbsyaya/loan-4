package com.hrbb.loan.web.security.dao;

import java.util.List;

import com.hrbb.loan.web.security.entity.Privilege;
import com.hrbb.loan.web.security.entity.Role;
import com.hrbb.loan.web.security.entity.User;

public interface PrivilegeDao extends BaseDao<Privilege,Integer> {

	public List<Privilege> findByUser(User user);
	
	public List<Privilege> findByRole(Role role);

    public List<Privilege> findByRoleId(Integer roleId);

    public int selectUsageCount(Integer privilegeId);

    /**
     * 
     * @param privilegeName
     * @return
     */
    public Privilege findByName(String privilegeName);
}

