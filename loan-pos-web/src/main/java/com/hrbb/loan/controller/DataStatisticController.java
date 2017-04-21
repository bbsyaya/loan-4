/**
 * 
 */
package com.hrbb.loan.controller;

import java.util.List;
import java.util.Map;

import javax.annotation.PostConstruct;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.ModelAndView;

import com.google.common.collect.Maps;
import com.hrbb.loan.pos.biz.backstage.inter.ILoanPosBusinessCodeBiz;
import com.hrbb.loan.pos.factory.SysConfigFactory;
import com.hrbb.loan.pos.util.constants.BusinessDictionaryConstants;

/**
 * <p>Title: DataStatisticController.java </p>
 * <p>Description:  </p>
 * <p>Copyright: Copyright (C) 2015 Hrbb Ltd. Co.</p> 
 *     
 * @author linzhaolin@hrbb.com.cn
 * @version 
 * @date Sep 21, 2015
 *
 * logs: 1. 
 */
@Controller
@RequestMapping("/statistic")
public class DataStatisticController {
	
	private Logger logger = LoggerFactory.getLogger(this.getClass());

	private List<Map<String, Object>> channelDictionary;
	
	@Autowired
	private ILoanPosBusinessCodeBiz loanPosBusinessCodeBiz;
	
	@PostConstruct
	public void loadDictionary() {
		Map<String, Object> reqChannel = Maps.newHashMap();
		reqChannel.put("codeNo", BusinessDictionaryConstants.BizChannel);
		reqChannel.put("extAttr", "Y");
		channelDictionary = loanPosBusinessCodeBiz.getItemNamesWithExtOrder(reqChannel);
	}
	
	@RequestMapping("/dataStatisticNav")
	public ModelAndView dataStatisticNav(@RequestParam(value = "qid", required = true) String qid) {
		if(!SysConfigFactory.getInstance().hasService("basicService")) return null;
		
		String birtUrl = SysConfigFactory.getInstance().getService("basicService").getPropertyValue("birtUrl");
		ModelAndView mav = new ModelAndView();
		mav.addObject("bizChannel", channelDictionary);
		mav.addObject("qid", qid);
		mav.addObject("baseUrl", birtUrl+"frameset?__report=pos/"+qid+".rptdesign");
		mav.setViewName("statistic/DataStatisticNav");
		return mav;
	}
	
}
