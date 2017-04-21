package com.hrbb.loan.web.security.dao;

import java.util.List;
import java.util.Map;

import com.hrbb.loan.web.security.entity.User;

public interface UserDao extends BaseDao<User,Integer> {
	
	public User selectByName(String name);

    public int lockById(Integer id);
    
    public int unlockById(Integer id);

    public int lockByIdInBatch(List<Integer> idList);
    
    public int unlockByIdInBatch(List<Integer> idList);
    
    public int deleteUserRole(Integer userId, Integer roleId);
    
    public int insertUserRole(Integer userId, Integer roleId);

    public User selectByCellphone(String cellphone);
    
    /**
     * 根据权限名称查询具有该权限的用户
     * 
     * @param privilegeName
     * @return
     */
    public List<Map<String, Object>> selectUsersByPrivilegeName(String privilegeName);  
}
