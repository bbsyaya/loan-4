package com.hrbb.loan.web.security.service.impl;

import java.util.HashSet;
import java.util.List;
import java.util.Set;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.authority.SimpleGrantedAuthority;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;

import com.hrbb.loan.web.security.entity.HrbbUserDetails;
import com.hrbb.loan.web.security.entity.Privilege;
import com.hrbb.loan.web.security.entity.User;
import com.hrbb.loan.web.security.service.PrivilegeService;
import com.hrbb.loan.web.security.service.UserService;

@Service("userDetailService")
public class HrbbUserDetailServiceImpl implements UserDetailsService {
	
    @Autowired
	private UserService userService;
    @Autowired
	private PrivilegeService privilegeService;
	
	public UserService getUserService() {
		return userService;
	}

	public void setUserService(UserService userService) {		
		this.userService = userService;
	}
	
	public PrivilegeService getPrivilegeService() {
		return privilegeService;
	}

	public void setPrivilegeService(PrivilegeService privilegeService) {
		this.privilegeService = privilegeService;
	}

	public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException {
		User users = this.userService.findByName(username);
		if(users == null) {
			throw new UsernameNotFoundException(username);
		}
		Set<GrantedAuthority> authSet = new HashSet<GrantedAuthority>();
		List<Privilege> roles = privilegeService.findPrivielegeByUser(users);
		
		for(Privilege role : roles) {
				authSet.add(new SimpleGrantedAuthority(role.getPrivilegeName()));
		}
		boolean enables = true;
		boolean accountNonExpired = true;
		boolean credentialsNonExpired = true;
		boolean accountNonLocked = true;
		
		UserDetails userDetail = new HrbbUserDetails(users,enables,accountNonExpired,credentialsNonExpired,accountNonLocked,authSet);
		return userDetail;
	}
}
