package com.hrbb.loan.web.security.dao;

import java.util.List;

import com.hrbb.loan.web.security.entity.Role;
import com.hrbb.loan.web.security.entity.User;

public interface RoleDao extends BaseDao<Role,Integer> {

    public List<Role> findByUser(User user);
    
    public List<Role> findByUserId(Integer userId);

    public Role findByRoleName(String roleName);

    public int lockById(Integer id);
    
    public int unlockById(Integer id);

    public int lockByIdInBatch(List<Integer> idList);
    
    public int unlockByIdInBatch(List<Integer> idList);
    
    public int deleteRolePrivilege(Integer roleId, Integer privilegeId);
    
    public int insertRolePrivilege(Integer roleId, Integer privilegeId);
}

