package com.hrbb.loan.controller;

import java.io.PrintWriter;
import java.util.Map;

import javax.servlet.http.HttpServletRequest;
//import javax.servlet.http.HttpSession;

import org.springframework.beans.factory.annotation.Autowired;
//import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

import com.google.common.collect.Maps;
//import com.hrbb.loan.pos.biz.backstage.inter.ICallingTaskBiz;
import com.hrbb.loan.web.security.entity.User;
import com.hrbb.loan.web.security.service.UserService;

/**
 *<h1>注销</h1>
 *@author Johnson Song
 *@version Id: LogoutController.java, v 1.0 2015-2-5 下午4:20:13 Johnson Song Exp
 */
@Controller
@RequestMapping("/workbench")
public class WorkBenchController {
    
    @Autowired
    private UserService userService;

//    @Autowired
//   	@Qualifier("iCallingTaskBiz")
//   	private ICallingTaskBiz biz;
    
    @RequestMapping("/myTasks")
    public String myTasks(HttpServletRequest request, PrintWriter out) {
    	Map<String, Object> reqMap = Maps.newHashMap();
    	User user = (User) request.getSession().getAttribute("USER");
		if (user!=null) {
			reqMap.put("claimerId", user.getUserName());
		}else {
			reqMap.put("claimerId", null);
		}
		reqMap.put("opflag", "1");
		//request.getSession().setAttribute("numClaimCalingTask", biz.selectSelective(reqMap).size());
        return "workbench/MyTasks";
    }
    
    @RequestMapping("/unassignedTasks")
    public String modifyPassword(HttpServletRequest request, PrintWriter out) {
        
        return "workbench/UnassignedTasks";
    }
}