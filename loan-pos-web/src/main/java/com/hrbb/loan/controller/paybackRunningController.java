package com.hrbb.loan.controller;

import java.io.PrintWriter;
import java.util.List;
import java.util.Map;

import javax.servlet.http.HttpServletRequest;

import org.apache.commons.lang.StringUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.ModelAndView;

import com.alibaba.fastjson.JSONObject;
import com.google.common.collect.Maps;
import com.hrbb.loan.controller.helper.ControllerHelper;
import com.hrbb.loan.pos.biz.backstage.inter.LoanPosPaybackRunningBiz;
/**
 * 还款流水管理
 * 
 * @author cjq
 * @version $Id: paybackRunningController.java, v 0.1 2015年9月7日 下午3:13:48 cjq Exp $
 */
@Controller
@RequestMapping("/paybackRunning")
public class paybackRunningController {
	@Autowired
    private LoanPosPaybackRunningBiz loanPosPaybackRunningBiz ;
	@RequestMapping("/queryPaybackRunningInfo")
	public ModelAndView queryPaybackRunningInfo(@RequestParam(value="rows", required = false)Integer pageSize, @RequestParam(value="page", required = false)Integer pageNo,HttpServletRequest request, PrintWriter out){
		Map<String, Object> reqMap = Maps.newHashMap();
	
		String a = request.getParameter("custNameLike");
		if(!StringUtils.isEmpty(a)){
			reqMap.put("custNameLike", ControllerHelper.getLikeString(a));
		}
		if(!StringUtils.isEmpty(request.getParameter("merchantNameLike"))){
			reqMap.put("merchantNameLike", ControllerHelper.getLikeString(request.getParameter("merchantNameLike")));
		}
		
	    String runningStatus = request.getParameter("runningStatus");
		if(!StringUtils.isEmpty(runningStatus)){
			reqMap.put("runningStatus", runningStatus);
		}
	    reqMap.put("startPage", (pageNo - 1)*pageSize);
		reqMap.put("limit", pageSize);
		List<Map<String, Object>> lists = loanPosPaybackRunningBiz.queryPaybackRunningInfo(reqMap);
		long number = loanPosPaybackRunningBiz.countNumber(reqMap);
	    JSONObject aaJson =  new JSONObject();
		aaJson.put("rows", lists);	
		aaJson.put("total", number);
		String aa = aaJson.toJSONString();
		out.write(aa);
		return null;
	}
}
