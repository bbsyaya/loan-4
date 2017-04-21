package com.hrbb.loan.web.security.dao.impl;

import java.util.List;

import org.springframework.stereotype.Repository;

import com.hrbb.loan.web.security.dao.RoleDao;
import com.hrbb.loan.web.security.entity.Privilege;
import com.hrbb.loan.web.security.entity.Role;
import com.hrbb.loan.web.security.entity.RolePrivilege;
import com.hrbb.loan.web.security.entity.User;
import com.hrbb.loan.web.security.entity.UserRole;

@Repository
public class RoleDaoImpl extends BaseDaoImpl<Role,Integer> implements RoleDao{

    private static final String namespace= "com.hrbb.loan.web.security.entity.Role.";

    public List<Role> findByUser(User user){
        return this.findByUserId(user.getUserId());
    }
    
    public List<Role> findByUserId(Integer userId){
        return getSqlSession().selectList("com.hrbb.loan.web.security.entity.Role.selectByUserId",userId);
    }

    /** 
     * @see com.hrbb.loan.web.security.dao.RoleDao#findByRoleName(java.lang.String)
     */
    @Override
    public Role findByRoleName(String roleName) {
        return getSqlSession().selectOne("com.hrbb.loan.web.security.entity.Role.selectByName",roleName);
    }

    /** 
     * @see com.hrbb.loan.web.security.dao.RoleDao#lockById(java.lang.Integer)
     */
    @Override
    public int lockById(Integer id) {
        return getSqlSession().update(namespace+"lockById", id);
    }

    /** 
     * @see com.hrbb.loan.web.security.dao.RoleDao#unlockById(java.lang.Integer)
     */
    @Override
    public int unlockById(Integer id) {
        return getSqlSession().update(namespace+"unlockById", id);
    }

    /** 
     * @see com.hrbb.loan.web.security.dao.RoleDao#lockByIdInBatch(java.util.List)
     */
    @Override
    public int lockByIdInBatch(List<Integer> idList) {
        int count = 0;
        if (idList == null || idList.isEmpty())
            return count;
        for (Integer id : idList) {
            count += this.lockById(id);
        }
        return count;    }

    /** 
     * @see com.hrbb.loan.web.security.dao.RoleDao#unlockByIdInBatch(java.util.List)
     */
    @Override
    public int unlockByIdInBatch(List<Integer> idList) {
        int count = 0;
        if (idList == null || idList.isEmpty())
            return count;
        for (Integer id : idList) {
            count += this.unlockById(id);
        }
        return count;    }

    /** 
     * @see com.hrbb.loan.web.security.dao.RoleDao#deleteRolePrivilege(java.lang.Integer, java.lang.Integer)
     */
    @Override
    public int deleteRolePrivilege(Integer roleId, Integer privilegeId) {
        RolePrivilege rp = new RolePrivilege();
        rp.setRoleId(roleId);
        rp.setPrivilegeId(privilegeId);        
        return getSqlSession().delete(namespace+"deleteRolePrivilege", rp);
    }

    /** 
     * @see com.hrbb.loan.web.security.dao.RoleDao#insertRolePrivilege(java.lang.Integer, java.lang.Integer)
     */
    @Override
    public int insertRolePrivilege(Integer roleId, Integer privilegeId) {
        RolePrivilege rp = new RolePrivilege();
        rp.setRoleId(roleId);
        rp.setPrivilegeId(privilegeId);        
        return getSqlSession().insert(namespace+"insertRolePrivilege", rp);
    }


}
