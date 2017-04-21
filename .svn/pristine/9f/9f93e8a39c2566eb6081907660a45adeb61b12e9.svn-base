package com.hrbb.loan.controller;

import java.io.PrintWriter;
import java.util.Map;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.ModelAndView;

import com.alibaba.fastjson.JSONObject;
import com.google.common.collect.Maps;
import com.hrbb.loan.hessian.inter.IUpsDataApiHessionService;
import com.hrbb.loan.pos.service.UpsDataApiService;
import com.hrbb.loan.pos.util.StringUtil;

/**
 * 银行流水
 * 
 * @author cjq
 * @version $Id: CreditBankSerialInfoController.java, v 0.1 2015年7月29日 下午1:14:11 cjq Exp $
 */
@Controller
@RequestMapping("/bankSerialInfo")
public class CreditBankSerialInfoController {
    
    Logger logger = LoggerFactory.getLogger(CreditBankSerialInfoController.class);
    
    @Autowired
    private IUpsDataApiHessionService upsDataApiHessionService;
    
    @Autowired
    private UpsDataApiService upsDataApiService;
    
    /**
     * 获取银行汇总信息
     * 
     * @param card
     * @param name
     * @param beginDateStr
     * @param endDateStr
     * @return
     */
    @RequestMapping("/summary")
    public ModelAndView getBankcardInfoSummary(@RequestParam(value = "card", required = false) String card,
                                        @RequestParam(value = "name", required = false) String name,
                                        @RequestParam(value = "beginDateStr", required = false) String beginDateStr,
                                        @RequestParam(value = "endDateStr", required = false) String endDateStr,
                                        PrintWriter out) {
        String checkResult = paramCheck(card, name, beginDateStr, endDateStr);
        Map<String, Object> reqMap = Maps.newHashMap();
        JSONObject json = new JSONObject();
        if (!StringUtil.isEmpty(checkResult)) {
            reqMap.put("card", card);
            reqMap.put("name", name);
            reqMap.put("beginDateStr", beginDateStr);
            reqMap.put("endDateStr", endDateStr);
            Map<String, Object> respMap = upsDataApiHessionService.getPosSerialByBankCardIds(reqMap);
            json.putAll(respMap);
        }else{
            json.put("respCode", "999");
            json.put("respMsg", "校验失败");
        }
        json.put("searchBank", card);
        json.put("searchName", name);
        out.print(json.toJSONString());
        return null;
    }

    /**
     * 检查是否查询过银联智慧接口
     * 
     * @param card
     * @param out
     * @return
     */
    @RequestMapping("/checkIsQueried")
    public ModelAndView checkIsQueried(@RequestParam(value="card",required=false)String card,
                                       PrintWriter out){
        JSONObject json = new JSONObject();
        String fileUuid = upsDataApiService.getFileUuid(card);
        if(!StringUtil.isEmpty(fileUuid)){
            json.put("flag","1");//查询过
        }else{
            json.put("flag", "0");//没有查询过
        }
        out.print(json.toJSONString());
        return null;
    }
    
    /**
     * 
     * 参数为空校验
     * 
     * @param card
     * @param name
     * @param beginDateStr
     * @param endDateStr
     */
    private String paramCheck(String card, String name, String beginDateStr, String endDateStr) {
        if(StringUtil.isEmpty(card)){
            logger.info("银行卡号为空");
            return null;
        }
        if(StringUtil.isEmpty(name)){
            logger.info("持卡人姓名为空");
            return null;
        }
        if(StringUtil.isEmpty(beginDateStr)){
            logger.info("查询开始时间为空");
            return null;
        }
        if(StringUtil.isEmpty(endDateStr)){
            logger.info("查询结束时间为空");
            return null;
        }
        return "pass";
    }
}
