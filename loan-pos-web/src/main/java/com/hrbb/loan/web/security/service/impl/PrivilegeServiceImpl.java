package com.hrbb.loan.web.security.service.impl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.hrbb.loan.web.security.dao.BaseDao;
import com.hrbb.loan.web.security.dao.PrivilegeDao;
import com.hrbb.loan.web.security.dao.impl.BaseServiceImpl;
import com.hrbb.loan.web.security.entity.Privilege;
import com.hrbb.loan.web.security.entity.Role;
import com.hrbb.loan.web.security.entity.User;
import com.hrbb.loan.web.security.service.PrivilegeService;


@Service("privilegeService")
public class PrivilegeServiceImpl extends BaseServiceImpl<Privilege,Integer> implements PrivilegeService
{
	@Autowired
	private PrivilegeDao privilegeDao;

	@Override
	public List<Privilege> findPrivielegeByUser(User user) {
		// TODO Auto-generated method stub
		return privilegeDao.findByUser(user);
	}

	@Override
	public List<Privilege> findAllPrivilege() {
		// TODO Auto-generated method stub
		return privilegeDao.selectAll();
	}

    /** 
     * @see com.hrbb.loan.web.security.dao.impl.BaseServiceImpl#getBaseDao()
     */
    @Override
    protected BaseDao<Privilege, Integer> getBaseDao() {
        return privilegeDao;
    }

    /** 
     * @see com.hrbb.loan.web.security.service.PrivilegeService#findPrivielegeByRoleId(java.lang.Integer)
     */
    @Override
    public List<Privilege> findPrivielegeByRole(Role role) {
        return privilegeDao.findByRole(role);
    }

    /** 
     * @see com.hrbb.loan.web.security.service.PrivilegeService#findPrivielegeByRoleId(java.lang.Integer)
     */
    @Override
    public List<Privilege> findPrivielegeByRoleId(Integer roleId) {
        return privilegeDao.findByRoleId(roleId);
    }

    /** 
     * @see com.hrbb.loan.web.security.service.PrivilegeService#findUsageCount(java.lang.Integer)
     */
    @Override
    public Integer findUsageCount(Integer privilegeId) {
        return privilegeDao.selectUsageCount(privilegeId);
    }

    /** 
     * @see com.hrbb.loan.web.security.service.PrivilegeService#findByName(java.lang.String)
     */
    @Override
    public Privilege findByName(String privilegeName) {
        return privilegeDao.findByName(privilegeName);
    }
	

}
