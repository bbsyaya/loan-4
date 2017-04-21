package com.hrbb.loan.web.security.service;

import java.util.List;

import com.hrbb.loan.web.security.dao.BaseService;
import com.hrbb.loan.web.security.entity.Role;
import com.hrbb.loan.web.security.entity.User;

public interface RoleService  extends BaseService<Role,Integer>
{
	List<Role> findRoleByUser(User user);
	
	List<Role> findRoleByUserId(Integer userId);

    Role findByName(String roleName);
    
    int lockById(Integer id);
    
    int unlockById(Integer id);

    int lockByIdInBatch(List<Integer> idList);
    
    int unlockByIdInBatch(List<Integer> idList);
    
    int insertRolePrivileges(int roleId, List<Integer> privilegeList);
    
    int deleteRolePrivileges(int roleId);

    int deleteRolePrivilegesInBatch(List<Integer> idList);
}
