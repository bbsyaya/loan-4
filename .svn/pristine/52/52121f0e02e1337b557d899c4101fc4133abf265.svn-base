/**
 * 
 *	哈尔滨银行
 * Copyright (c) 2007-2015 HRBB,Inc.All Rights Reserved.
 */
package com.hrbb.loan.controller;

import java.io.PrintWriter;
import java.util.Date;
import java.util.List;
import java.util.Map;

import javax.servlet.http.HttpServletRequest;

import org.apache.commons.lang.StringUtils;
import org.apache.commons.lang.time.DateUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.ModelAndView;

import com.alibaba.fastjson.JSONObject;
import com.google.common.collect.Maps;
import com.hrbb.loan.constants.black.BlacklistConstants;
import com.hrbb.loan.controller.converts.BlacklistConverter;
import com.hrbb.loan.controller.helper.ControllerHelper;
import com.hrbb.loan.pos.biz.backstage.inter.ILoanPosBlacklistBackStageBiz;
import com.hrbb.loan.pos.util.DateUtil;
import com.hrbb.loan.pos.util.RandomUtil;
import com.hrbb.loan.web.security.entity.User;

/**
 * 
 * @author XLY
 * @version $Id: BlacklistController.java, v 0.1 2015-3-3 下午5:05:22 XLY Exp $
 */
@Controller
@RequestMapping("/blacklist")
public class BlacklistController {

    @Autowired
    private ILoanPosBlacklistBackStageBiz loanPosBlacklistBizFacade;
    
    /**
     * <h2>获取dbapp记录</h2>
     * @param pageNo, pageSize
     * @return modelAndView
     */
    @RequestMapping("/queryblacklist")
    public ModelAndView queryCreditApply(@RequestParam(value="rows", required = false)Integer pageSize, @RequestParam(value="page", required = false)Integer pageNo,HttpServletRequest request, PrintWriter out){
        
        Map<String, Object> reqMap = Maps.newHashMap();
        if(!StringUtils.isEmpty(request.getParameter(BlacklistConstants.CERT_TYPE))){
            reqMap.put(BlacklistConstants.CERT_TYPE,  request.getParameter(BlacklistConstants.CERT_TYPE) );
        }
        if(!StringUtils.isEmpty(request.getParameter(BlacklistConstants.INFO_TYPE))){
            reqMap.put(BlacklistConstants.INFO_TYPE, request.getParameter(BlacklistConstants.INFO_TYPE));
        }
        if(!StringUtils.isEmpty(request.getParameter(BlacklistConstants.INFO_DETAIL))){
            reqMap.put(BlacklistConstants.INFO_DETAIL, ControllerHelper.getLikeString(request.getParameter(BlacklistConstants.INFO_DETAIL)));
        }
        if(!StringUtils.isEmpty(request.getParameter(BlacklistConstants.CONFIRM_USER))){
            reqMap.put(BlacklistConstants.CONFIRM_USER, ControllerHelper.getLikeString(request.getParameter(BlacklistConstants.CONFIRM_USER)));
        }
        if(null!=(request.getParameter(BlacklistConstants.EFFECT_TIME))&& !"".equals(request.getParameter(BlacklistConstants.EFFECT_TIME))){
            reqMap.put(BlacklistConstants.EFFECT_TIME,request.getParameter(BlacklistConstants.EFFECT_TIME));
        }
        if(null!=(request.getParameter(BlacklistConstants.UNEFF_TIME)) && !"".equals(request.getParameter(BlacklistConstants.UNEFF_TIME))){
            reqMap.put(BlacklistConstants.UNEFF_TIME,request.getParameter(BlacklistConstants.UNEFF_TIME));
        }
        reqMap.put("startPage", (pageNo - 1)*pageSize);
        reqMap.put("limit", pageSize);
        List<Map<String, Object>> lists = loanPosBlacklistBizFacade.queryBlacklist(reqMap);
        lists = BlacklistConverter.blacklistConvert(lists);
        Map<String, Object> map = lists.get(lists.size() - 1);
        lists.remove(lists.size() -1);
        JSONObject aaJson =  new JSONObject();
        aaJson.put("total", map.get("total"));
        aaJson.put("rows", lists);      
        out.write(aaJson.toJSONString());
        return null;
    }
    
    /**
     * <h2>获取dbapp记录</h2>
     * @param pageNo, pageSize
     * @return modelAndView
     */
    @RequestMapping("/insertblacklist")
    public ModelAndView insertBlacklist(HttpServletRequest request, PrintWriter out){
        User user = (User)request.getSession().getAttribute("USER");
        //获取参数值
        String infoType = request.getParameter(BlacklistConstants.INFO_TYPE);
        String certType = request.getParameter(BlacklistConstants.CERT_TYPE);
        String infoDetail = request.getParameter(BlacklistConstants.INFO_DETAIL);
        String confirmReason = request.getParameter(BlacklistConstants.CONFIRM_REASON);
        String intervalType = request.getParameter(BlacklistConstants.INTERVAL_TYPE);

        Map<String, Object> reqMap = Maps.newHashMap();
        reqMap.put(BlacklistConstants.ID, DateUtil.getCurrentTimePattern5() + RandomUtil.getRandom(4));
        reqMap.put(BlacklistConstants.INFO_TYPE, infoType);
        reqMap.put(BlacklistConstants.CERT_TYPE, certType);
        reqMap.put(BlacklistConstants.INFO_DETAIL, infoDetail);
        reqMap.put(BlacklistConstants.CONFIRM_USER, user.getUserName());
        reqMap.put(BlacklistConstants.CONFIRM_REASON, confirmReason);
        reqMap.put(BlacklistConstants.INTERVAL_TYPE, intervalType);
        reqMap.put(BlacklistConstants.DEL_FLAG, BlacklistConstants.DEL_FLAG_NUDEL);
        reqMap.put(BlacklistConstants.CONFIRM_USER_ID,  user.getUserId());
        reqMap.put(BlacklistConstants.EFFECT_FLAG, BlacklistConstants.EFFECT_FLAG_N);
        reqMap.put(BlacklistConstants.CONFIRM_TIME, new Date());
        if(null!=(request.getParameter(BlacklistConstants.EFFECT_TIME))&& !"".equals(request.getParameter(BlacklistConstants.EFFECT_TIME))){
            reqMap.put(BlacklistConstants.EFFECT_TIME,request.getParameter(BlacklistConstants.EFFECT_TIME));
        }
        if(null!=(request.getParameter(BlacklistConstants.UNEFF_TIME)) && !"".equals(request.getParameter(BlacklistConstants.UNEFF_TIME))){
            reqMap.put(BlacklistConstants.UNEFF_TIME,request.getParameter(BlacklistConstants.UNEFF_TIME));
        }       
        reqMap.put("modifyTime", new Date());
        reqMap.put("createTime", new Date());
        loanPosBlacklistBizFacade.insertBlacklist(reqMap);
        out.print("success");
        return null;
    }
    /**
     * <h2>获取dbapp记录</h2>
     * @param pageNo, pageSize
     * @return modelAndView
     */
    @RequestMapping("/updateblacklist")
    public ModelAndView updateBlacklist(HttpServletRequest request, PrintWriter out){
        User user = (User)request.getSession().getAttribute("USER");

        //获取参数值
        String blacklistId =  request.getParameter("blacklistId");
        String infoDetail = request.getParameter(BlacklistConstants.INFO_DETAIL);
        String comfirmReason = request.getParameter(BlacklistConstants.CONFIRM_REASON);
        String effectTime = request.getParameter(BlacklistConstants.EFFECT_TIME);
        String uneffTime = request.getParameter(BlacklistConstants.UNEFF_TIME);
        String intervalType = request.getParameter(BlacklistConstants.INTERVAL_TYPE);
        String effectFlag = request.getParameter(BlacklistConstants.EFFECT_FLAG);

        Map<String, Object> reqMap = Maps.newHashMap();
        if(!StringUtils.isEmpty(blacklistId)){
            reqMap.put(BlacklistConstants.ID, blacklistId);
        }else{
            out.print("error");
            return null;
        }
        if(null!=infoDetail)reqMap.put(BlacklistConstants.INFO_DETAIL, infoDetail);
        reqMap.put(BlacklistConstants.CONFIRM_USER, request.getSession().getAttribute("userName"));
        if(null!=comfirmReason)reqMap.put(BlacklistConstants.CONFIRM_REASON, comfirmReason);
        if(null!=intervalType) reqMap.put(BlacklistConstants.INTERVAL_TYPE, intervalType);
        reqMap.put(BlacklistConstants.CONFIRM_USER_ID, user.getUserId());
        if(null!=effectFlag) reqMap.put(BlacklistConstants.EFFECT_FLAG, effectFlag);
        reqMap.put(BlacklistConstants.CONFIRM_TIME, new Date());
        if(null!=effectTime)reqMap.put(BlacklistConstants.EFFECT_TIME, new Date());
        if(null!=uneffTime)reqMap.put(BlacklistConstants.UNEFF_TIME, DateUtils.addMonths(new Date(), 2));
        reqMap.put("modifyTime", new Date());
        reqMap.put(BlacklistConstants.CONFIRM_USER_ID,  user.getUserId());
        reqMap.put(BlacklistConstants.CONFIRM_USER, user.getUserName());

        loanPosBlacklistBizFacade.updateBlacklist(reqMap);
        out.print("success");
        return null;
    }
    
    
    /**
     * 逻辑删除
     * @param request
     * @param out
     * @param deleteItems
     * @return
     */
    @RequestMapping("/deleteblacklist")
    public ModelAndView deleteblacklist(HttpServletRequest request,
            PrintWriter out, @RequestParam(value = "deleteItem", required = false)String deleteItems){
        User user = (User)request.getSession().getAttribute("USER");
        String[] blacklistIds = deleteItems.split("[|]");
        if(blacklistIds == null || blacklistIds.length == 0){
            out.print("0");
            return null;
        }
        for(String blacklistId : blacklistIds){
            Map<String, Object> reqMap = Maps.newHashMap();
            reqMap.put(BlacklistConstants.ID, blacklistId);
            reqMap.put("modifyTime", new Date());
            reqMap.put(BlacklistConstants.CONFIRM_USER_ID,  user.getUserId());
            reqMap.put(BlacklistConstants.CONFIRM_USER, user.getUserName());
            reqMap.put(BlacklistConstants.DEL_FLAG, BlacklistConstants.DEL_FLAG_DODEL);
            loanPosBlacklistBizFacade.updateBlacklist(reqMap);
        }
        
        out.print("delete success");
        //逻辑删除
        return null;
    }
}
