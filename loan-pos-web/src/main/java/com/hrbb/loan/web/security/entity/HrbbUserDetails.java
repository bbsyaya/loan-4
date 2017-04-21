package com.hrbb.loan.web.security.entity;

import java.util.Collection;

import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.userdetails.UserDetails;


public class HrbbUserDetails implements UserDetails {

    private static final long serialVersionUID = 2L;

    private String username;
    private String password;
    private boolean enabled=true;
    private boolean accountNonExpired=true;;
    private boolean credentialsNonExpired=true;
    private boolean accountNonLocked=true;
    private Collection<GrantedAuthority> authorities;

    public HrbbUserDetails(){    	
    }
    
    public HrbbUserDetails(User user, boolean enabled, boolean accountNonExpired,
    		boolean credentialsNonExpired, boolean accountNonLocked, Collection<GrantedAuthority> authorities){   
    	this.setUsername(user.getUserName());
    	this.setPassword(user.getPassword());
    	this.authorities = authorities;
    }

    
    public boolean isAccountNonExpired() {
        return accountNonExpired;
    }

    public void setAccountNonExpired(boolean accountNonExpired) {
        this.accountNonExpired = accountNonExpired;
    }

    public boolean isAccountNonLocked() {
        return accountNonLocked;
    }

    public void setAccountNonLocked(boolean accountNonLocked) {
        this.accountNonLocked = accountNonLocked;
    }

    public Collection<? extends GrantedAuthority> getAuthorities() {
        return authorities;
    }

    public void setAuthorities(Collection<GrantedAuthority> authorities) {
        this.authorities = authorities;
    }

    public boolean isCredentialsNonExpired() {
        return credentialsNonExpired;
    }

    public void setCredentialsNonExpired(boolean credentialsNonExpired) {
        this.credentialsNonExpired = credentialsNonExpired;
    }

    public boolean isEnabled() {
        return enabled;
    }

    public void setEnabled(boolean enabled) {
        this.enabled = enabled;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public String getUsername() {
        return username;
    }

    public void setUsername(String username) {
        this.username = username;
    }

}
