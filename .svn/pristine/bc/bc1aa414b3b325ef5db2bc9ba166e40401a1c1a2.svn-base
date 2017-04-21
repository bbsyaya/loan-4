package com.hrbb.loan.controller;

import java.io.PrintWriter;
import java.util.List;
import java.util.Map;

import jodd.util.StringUtil;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.ModelAndView;

import com.alibaba.fastjson.JSONObject;
import com.google.common.collect.Maps;
import com.hrbb.loan.pos.biz.backstage.inter.BusinessDictionaryBiz;
import com.hrbb.loan.pos.dao.entity.TCfgCnapsInfo;
import com.hrbb.loan.pos.service.BankInfoService;

/**
 * 
 * @author cjq
 * @version $Id: BankController.java, v 0.1 2015年8月27日 上午11:27:28 cjq Exp $
 */
@Controller
@RequestMapping("/bank")
public class BankController {

    Logger                        logger = LoggerFactory.getLogger(BankController.class);
    @Autowired
    private BusinessDictionaryBiz businessDictionaryBiz;

    @Autowired
    private BankInfoService       bankInfoService;

    /**
     * 查询银行列表
     * 
     * @param bankNo
     * @param province
     * @param city
     * @param division
     * @param bankName
     * @param out
     * @return
     */
    @RequestMapping("/queryBankNo")
    public ModelAndView queryBackNoList(@RequestParam(value = "bankNo", required = false) String bankNo,
                                        @RequestParam(value = "province", required = false) String province,
                                        @RequestParam(value = "city", required = false) String city,
                                        @RequestParam(value = "bankName", required = false) String bankName,
                                        PrintWriter out) {
        JSONObject json = new JSONObject();
        if(checkIsNotNull(bankNo,province,city)){
            Map<String,Object> reqMap= Maps.newHashMap();
            reqMap.put("bankNo", bankNo);
            reqMap.put("cnapsName", "%"+bankName+"%");
            reqMap.put("province", province);
            if("110000".equals(province) || "120000".equals(province) || "500000".equals(province) || "310000".equals(province)){
                reqMap.put("city", province);
            }else{
                reqMap.put("city", city);
            }
            List<TCfgCnapsInfo> cfgCnapsInfos = bankInfoService.getBankInfoBySelective(reqMap);
            if(cfgCnapsInfos!=null){
                json.put("rows", cfgCnapsInfos);
                json.put("count", cfgCnapsInfos.size());
            }else{
                json.put("rows", cfgCnapsInfos);
                json.put("count", 0);
            }
            out.print(json.toJSONString());
        }else{
            json.put("count", 0);
            out.print(json.toJSONString());
        }
        return null;
    }

    /**
     * 
     * @param strMap
     * @return
     */
    public boolean checkIsNotNull(Map<String, String> strMap) {
        for (String key : strMap.keySet()) {
            if (StringUtil.isEmpty(strMap.get(key))) {
                logger.info(key + "值为空");
                return false;
            }
        }
        return true;
    }
    
    /**
     * 
     * @param strs
     * @return
     */
    public boolean checkIsNotNull(String... strs) {
        for (String str : strs) {
            if(StringUtil.isEmpty(str)){
                return false;
            }
        }
        return true;
    }
}
