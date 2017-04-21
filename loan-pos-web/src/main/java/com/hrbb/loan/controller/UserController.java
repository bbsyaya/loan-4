package com.hrbb.loan.controller;

import java.io.PrintWriter;
import java.security.NoSuchAlgorithmException;
import java.util.List;
import java.util.Map;

import javax.servlet.http.HttpServletRequest;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.ModelAndView;

import com.alibaba.fastjson.JSON;
import com.alibaba.fastjson.JSONObject;
import com.amarsoft.are.security.MessageDigest;
import com.google.common.collect.Maps;
import com.hrbb.loan.web.security.entity.User;
import com.hrbb.loan.web.security.service.UserService;

/**
 *<h1>注销</h1>
 *@author Johnson Song
 *@version Id: LogoutController.java, v 1.0 2015-2-5 下午4:20:13 Johnson Song Exp
 */
@Controller
@RequestMapping("/user")
public class UserController {
    
    @Autowired
    private UserService userService;

    @RequestMapping("/userRegister")
    public ModelAndView userRegister(HttpServletRequest request, PrintWriter out,
                                     @RequestParam(value = "username", required = true)String username,
                                     @RequestParam(value = "password", required = true)String password) {
        String result = null;
        User user = userService.findByName(username);
        if (user == null){
            user = userService.findByCellphone(username);
        }
        if(user == null) {
            result = "NO_SUCH_USER";
        } else if (!user.getPassword().equals(password)) {
            result = "WRONG_PASSWORD";
        } else {
            result = "SUCCESS";
        }
        out.print(result);        
        return null;
    }

    @RequestMapping("/modPassword")
    public ModelAndView modifyPassword(HttpServletRequest request, PrintWriter out,
                                       @RequestParam(value = "newpass", required = false)String newpass,
                                       @RequestParam(value = "oldpass", required = false)String oldpass) {
    	Map<String,Object> result = Maps.newHashMap();
    	result.put("status", false);
    	
    	String oldPwd = "";
    	String password = "";
		try {
			oldPwd = MessageDigest.getDigestAsLowerHexString("MD5", oldpass);
			password = MessageDigest.getDigestAsLowerHexString("MD5", newpass);
		} catch (NoSuchAlgorithmException e) {
			e.printStackTrace();
		}
    	
        User user = (User)request.getSession().getAttribute("USER");
        
        if(!user.getPassword().equals(oldPwd)){
        	result.put("msg", "原密码错误，请重新输入.");
        }else{
        	user.setPassword(password);
            userService.updateByIdSelective(user);
            
            result.put("status", true);
            result.put("msg", "密码修改成功.");
        }
        
        
        out.print(JSONObject.toJSON(result));
        return null;
    }
    
    /**
     * 根据申请状态称查询具有该状态复审权限的用户
     * 
     * @param applyStatus 
     * @param out
     * @return
     */
    @RequestMapping("/queryUsersByApplyStatus")
    public ModelAndView queryUsersByApplyStatus(@RequestParam(value="applyStatus", required=true) String applyStatus,
                        PrintWriter out){
        List<Map<String, Object>> userList = userService.selectUsersByApplyStatus(applyStatus);
        out.write(JSON.toJSONString(userList));
        return null;
    }
}