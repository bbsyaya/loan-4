package com.hrbb.loan.web.security.service;


import java.util.List;
import java.util.Map;

import com.hrbb.loan.web.security.dao.BaseService;
import com.hrbb.loan.web.security.entity.User;

public interface UserService  extends BaseService<User,Integer>
{

	User findByName(String username);
	
	int lockById(Integer id);
	
	int unlockById(Integer id);

    int lockByIdInBatch(List<Integer> idList);
    
    int unlockByIdInBatch(List<Integer> idList);
    
    int insertUserRoles(int userId, List<Integer> roleList);
    
    int deleteUserRoles(int userId);

    int deleteUserRolesInBatch(List<Integer> idList);

    User findByCellphone(String cellphone);
    
    /**
     * 根据申请状态称查询具有该状态复审权限的用户
     * 
     * @param privilegeName
     * @return
     */
    public List<Map<String, Object>> selectUsersByApplyStatus(String applyStatus);
}
