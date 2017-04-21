package com.hrbb.loan.web.security.service;

import java.util.List;

import com.hrbb.loan.web.security.dao.BaseService;
import com.hrbb.loan.web.security.entity.Privilege;
import com.hrbb.loan.web.security.entity.Role;
import com.hrbb.loan.web.security.entity.User;

public interface PrivilegeService  extends BaseService<Privilege,Integer>
{
	public List<Privilege> findPrivielegeByUser(User user);
    public List<Privilege> findPrivielegeByRole(Role role);
    public List<Privilege> findPrivielegeByRoleId(Integer roleId);
	public List<Privilege> findAllPrivilege();
    public Integer findUsageCount(Integer privilegeId);
    /**
     * 
     * @param privilegeName
     * @return
     */
    public Privilege findByName(String privilegeName);
}
