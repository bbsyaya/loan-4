package com.hrbb.loan.web.security.controller;

import java.util.Iterator;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.context.request.RequestContextHolder;
import org.springframework.web.context.request.ServletRequestAttributes;

import com.hrbb.loan.constants.CreditApplyConstants;
import com.hrbb.loan.web.security.entity.AccessPrivilege;
import com.hrbb.loan.web.security.entity.User;

@Controller
public class WelcomeController {
  
    @Autowired
    private UserDetailsService userDetailService;
    /**
     * Saves the static list of users in model and renders it 
     * via freemarker template.
     * 
     * @param model 
     * @return The index view (FTL)
     */
    @RequestMapping(value = "/index", method = RequestMethod.GET)
    public String index(@ModelAttribute("model") ModelMap model) {
    	AccessPrivilege privileges = new AccessPrivilege();
        User user = (User)getSession().getAttribute("USER");
        StringBuffer buffer = new StringBuffer();
        Iterator<? extends GrantedAuthority> it = userDetailService.loadUserByUsername(user.getUserName()).getAuthorities().iterator();
        while (it.hasNext()){
        	String auth = it.next().getAuthority();
            buffer.append(auth).append(";");
            
            privileges.addPrivilege(auth);		//add by Lin,Zhaolin
        }
        getSession().setAttribute("assignedPrivileges", buffer.toString());
        System.out.println(buffer.toString());
        getSession().setAttribute("accessPrivilege", privileges);		//add by Lin,Zhaolin
        
        return CreditApplyConstants.NAVIGATION;
    }

    public static HttpSession getSession() {
        HttpSession session = null;
        try {
            session = getRequest().getSession();
        } catch (Exception e) {
        }
        return session;
    }

    public static HttpServletRequest getRequest() {
        ServletRequestAttributes attrs = (ServletRequestAttributes) RequestContextHolder
            .getRequestAttributes();
        return attrs.getRequest();
    }
    
    @RequestMapping(value = "/login", method = RequestMethod.GET)
    public String login(@ModelAttribute("model") ModelMap model) {
        return "login";
    }
    
    @RequestMapping(value = "/", method = RequestMethod.GET)
    public String welcome(@ModelAttribute("model") ModelMap model) {
        return "login";
    }

}
