package com.hrbb.loan.web.security.dao.impl;

import java.util.List;

import org.springframework.stereotype.Repository;

import com.hrbb.loan.web.security.dao.PrivilegeDao;
import com.hrbb.loan.web.security.entity.Privilege;
import com.hrbb.loan.web.security.entity.Role;
import com.hrbb.loan.web.security.entity.User;

@Repository
public class PrivilegeDaoImpl extends BaseDaoImpl<Privilege,Integer> implements PrivilegeDao{

	public List<Privilege> findByUser(User user){
		return getSqlSession().selectList("com.hrbb.loan.web.security.entity.Privilege.selectByUserId",user.getUserId());
	}

    /** 
     * @see com.hrbb.loan.web.security.dao.PrivilegeDao#findByRole(com.hrbb.loan.web.security.entity.Role)
     */
    @Override
    public List<Privilege> findByRole(Role role) {
        return getSqlSession().selectList("selectByRoleId",role.getRoleId());
    }

    /** 
     * @see com.hrbb.loan.web.security.dao.PrivilegeDao#findByRoleId(java.lang.Integer)
     */
    @Override
    public List<Privilege> findByRoleId(Integer roleId) {
        return getSqlSession().selectList("selectByRoleId", roleId);
    }

    /** 
     * @see com.hrbb.loan.web.security.dao.PrivilegeDao#selectUsageCount(java.lang.Integer)
     */
    @Override
    public int selectUsageCount(Integer privilegeId) {
        return getSqlSession().selectOne("com.hrbb.loan.web.security.entity.Privilege.selectUsageCount",privilegeId);
    }

    /** 
     * @see com.hrbb.loan.web.security.dao.PrivilegeDao#findByName(java.lang.String)
     */
    @Override
    public Privilege findByName(String privilegeName) {
        return getSqlSession().selectOne("com.hrbb.loan.web.security.entity.Privilege.selectByName",privilegeName);
    }
}
