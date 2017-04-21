package com.hrbb.loan.web.security.service.impl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.hrbb.loan.web.security.dao.BaseDao;
import com.hrbb.loan.web.security.dao.PrivilegeDao;
import com.hrbb.loan.web.security.dao.RoleDao;
import com.hrbb.loan.web.security.dao.impl.BaseServiceImpl;
import com.hrbb.loan.web.security.entity.Privilege;
import com.hrbb.loan.web.security.entity.Role;
import com.hrbb.loan.web.security.entity.User;
import com.hrbb.loan.web.security.service.PrivilegeService;
import com.hrbb.loan.web.security.service.RoleService;


@Service("roleService")
public class RoleServiceImpl extends BaseServiceImpl<Role,Integer> implements RoleService
{
	@Autowired
	private RoleDao roleDao;

	@Override
	public List<Role> findRoleByUser(User user) {
		// TODO Auto-generated method stub
		return roleDao.findByUser(user);
	}

    /** 
     * @see com.hrbb.loan.web.security.dao.impl.BaseServiceImpl#getBaseDao()
     */
    @Override
    protected BaseDao<Role, Integer> getBaseDao() {
        return roleDao;
    }

    /** 
     * @see com.hrbb.loan.web.security.service.RoleService#findRoleByUserId(java.lang.Integer)
     */
    @Override
    public List<Role> findRoleByUserId(Integer userId) {
        return roleDao.findByUserId(userId);
    }

    /** 
     * @see com.hrbb.loan.web.security.service.RoleService#findByName(java.lang.String)
     */
    @Override
    public Role findByName(String roleName) {
        return roleDao.findByRoleName(roleName);
    }

    /** 
     * @see com.hrbb.loan.web.security.service.RoleService#lockById(java.lang.Integer)
     */
    @Override
    public int lockById(Integer id) {
        return roleDao.lockById(id);
    }

    /** 
     * @see com.hrbb.loan.web.security.service.RoleService#unlockById(java.lang.Integer)
     */
    @Override
    public int unlockById(Integer id) {
        return roleDao.unlockById(id);
    }

    /** 
     * @see com.hrbb.loan.web.security.service.RoleService#lockByIdInBatch(java.util.List)
     */
    @Override
    public int lockByIdInBatch(List<Integer> idList) {
        return roleDao.lockByIdInBatch(idList);
    }

    /** 
     * @see com.hrbb.loan.web.security.service.RoleService#unlockByIdInBatch(java.util.List)
     */
    @Override
    public int unlockByIdInBatch(List<Integer> idList) {
        return roleDao.unlockByIdInBatch(idList);
    }

    /** 
     * @see com.hrbb.loan.web.security.service.RoleService#insertRolePrivileges(int, java.util.List)
     */
    @Override
    public int insertRolePrivileges(int roleId, List<Integer> privilegeList) {
        int count = 0;
        if (privilegeList.size()>0) {
            for (Integer privilegeId:privilegeList){
                count += roleDao.insertRolePrivilege(roleId, privilegeId);
            }
        }
        return count;   
    }

    /** 
     * @see com.hrbb.loan.web.security.service.RoleService#deleteRolePrivileges(int)
     */
    @Override
    public int deleteRolePrivileges(int roleId) {
        return roleDao.deleteRolePrivilege(roleId, 0);
    }

    /** 
     * @see com.hrbb.loan.web.security.service.RoleService#deleteRolePrivilegesInBatch(java.util.List)
     */
    @Override
    public int deleteRolePrivilegesInBatch(List<Integer> idList) {
        int count = 0;
        if (idList.size()>0) {
            for (Integer roleId:idList){
                count += deleteRolePrivileges(roleId);
            }
        }
        return count;       
    }

}
