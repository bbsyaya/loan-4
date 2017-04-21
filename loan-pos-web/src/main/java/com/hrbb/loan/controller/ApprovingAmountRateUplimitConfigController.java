package com.hrbb.loan.controller;

import java.io.PrintWriter;
import java.util.Date;
import java.util.List;
import java.util.Map;
import javax.annotation.PostConstruct;
import javax.servlet.http.HttpServletRequest;
import jodd.util.StringUtil;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.ModelAndView;
import com.alibaba.fastjson.JSONObject;
import com.google.common.collect.Maps;
import com.hrbb.loan.pos.biz.backstage.inter.ILoanPosBusinessCodeBiz;
import com.hrbb.loan.pos.dao.entity.TApprovingAmountRateUplimitfig;
import com.hrbb.loan.pos.service.ModelParamConfigService;
import com.hrbb.loan.pos.util.constants.BusinessDictionaryConstants;

@Controller
@RequestMapping("/approvingAmountRateUplimitConfig")
public class ApprovingAmountRateUplimitConfigController {
    private Logger logger = LoggerFactory.getLogger(ApprovingAmountRateUplimitConfigController.class);

    @Autowired
    private ModelParamConfigService ModelParamConfigService;

    @Autowired
    private ILoanPosBusinessCodeBiz loanPosBusinessCodeBiz;

    private List<Map<String, Object>> productList;

    private List<Map<String, Object>> channelrisktypeList;

    private List<Map<String, Object>> regionrisktypeList;
    
    private List<Map<String, Object>> paybackwayList;

    private List<Map<String, Object>> deleteflagList;

    //产品代码数据字典map<itemNo,itemName>
  	Map<String, String> productNoMap = Maps.newHashMap();
  	
  	//渠道风险类型数据字典map<itemNo,itemName>
  	Map<String, String> channelRiskTypeMap = Maps.newHashMap();
  	
  	//地区风险类型数据字典map<itemNo,itemName>
  	Map<String, String> regionRiskTypeMap = Maps.newHashMap();
  	
  	//还款方式数据字典map<itemNo,itemName>
  	Map<String, String> repaytypeMap = Maps.newHashMap();
  	
  	//是否生效数据字典map<itemNo,itemName>
  	Map<String, String> deleteflagMap = Maps.newHashMap();
  	
    @PostConstruct
    public void loadDictionary() {
        productList = loanPosBusinessCodeBiz.getItemNames(BusinessDictionaryConstants.ProductNo);
        channelrisktypeList = loanPosBusinessCodeBiz.getItemNames(BusinessDictionaryConstants.ChannelRiskType);
        regionrisktypeList = loanPosBusinessCodeBiz.getItemNames(BusinessDictionaryConstants.RegionRiskType);
        paybackwayList = loanPosBusinessCodeBiz.getItemNames(BusinessDictionaryConstants.AccrualType);
        deleteflagList = loanPosBusinessCodeBiz.getItemNames(BusinessDictionaryConstants.Deleteflag);
        if(productList != null && productList.size() > 0){
    		for(Map<String, Object> map: productList){
    			productNoMap.put((String) map.get("itemNo"), (String) map.get("itemName"));
    		}
    	}
        if(channelrisktypeList != null && channelrisktypeList.size() > 0){
    		for(Map<String, Object> map: channelrisktypeList){
    			channelRiskTypeMap.put((String) map.get("itemNo"), (String) map.get("itemName"));
    		}
    	}
        if(regionrisktypeList != null && regionrisktypeList.size() > 0){
    		for(Map<String, Object> map: regionrisktypeList){
    			regionRiskTypeMap.put((String) map.get("itemNo"), (String) map.get("itemName"));
    		}
    	}
        if(paybackwayList != null && paybackwayList.size() > 0){
    		for(Map<String, Object> map: paybackwayList){
    			repaytypeMap.put((String) map.get("itemNo"), (String) map.get("itemName"));
    		}
    	}
        if(deleteflagList != null && deleteflagList.size() > 0){
    		for(Map<String, Object> map: deleteflagList){
    			deleteflagMap.put((String) map.get("itemNo"), (String) map.get("itemName"));
    		}
    	}
    }

    @RequestMapping("/queryApprovingAmountRateUplimitConfig")
    public ModelAndView queryApprovingAmountRateUplimitConfig(@RequestParam(value = "rows", required = false) Integer pageSize,
            @RequestParam(value = "page", required = false) Integer pageNo, HttpServletRequest request, PrintWriter out) {
        JSONObject json = new JSONObject();
        Map<String, Object> reqMap = Maps.newHashMap();
        if (StringUtil.isNotEmpty(request.getParameter("prodId"))) {
            reqMap.put("prodId", request.getParameter("prodId"));
        }
        if (StringUtil.isNotEmpty(request.getParameter("channel_rtype_code"))) {
            reqMap.put("channel_rtype_code", request.getParameter("channel_rtype_code"));
        }
        reqMap.put("startPage", (pageNo - 1) * pageSize);
        reqMap.put("limit", pageSize);
        List<TApprovingAmountRateUplimitfig> lists = ModelParamConfigService.queryApprovingAmountRateUplimitConfig(reqMap);
        if(lists != null && lists.size() > 0){
        	for(TApprovingAmountRateUplimitfig fig: lists){
        		fig.setProdId(productNoMap.get(fig.getProdId()));
        		fig.setChannel_rtype_code(channelRiskTypeMap.get(fig.getChannel_rtype_code()));
        		fig.setRegion_rtype_code(regionRiskTypeMap.get(fig.getRegion_rtype_code()));
        		fig.setRepay_type(repaytypeMap.get(fig.getRepay_type()));
        		fig.setDeleted_flag(deleteflagMap.get(fig.getDeleted_flag()));
        	}
        }
        long total = ModelParamConfigService.countApprovingAmountRateUplimitConfig(reqMap);
        if (null != lists && lists.size() > 0) {
            json.put("total", total);
            json.put("rows", lists);
        } else {
            json.put("total", 0);
            json.put("rows", lists);
        }
        out.write(json.toJSONString());
        return null;
    }

    @RequestMapping("/openAddApprovingAmountRateUplimitConfig")
    public ModelAndView openAddApprovingAmountRateUplimitConfigWindow() {
        ModelAndView mav = new ModelAndView();
        mav.addObject("oprFlag", "0");// 0代表新增
        mav.addObject("productList", productList);
        mav.addObject("channelrisktypeList", channelrisktypeList);
        mav.addObject("regionrisktypeList", regionrisktypeList);
        mav.addObject("paybackwayList", paybackwayList);
        mav.addObject("deleteflagList", deleteflagList);
        mav.setViewName("paramconfig/detailApprovingAmountRateUplimitConfigInfo");
        return mav;
    }

    /**
     * 新增机构
     * 
     * @param request
     * @param out
     * @return
     */
    @RequestMapping(value = "/addApprovingAmountRateUplimitConfig", method = RequestMethod.POST)
    public ModelAndView addInstitutionWindow(HttpServletRequest request, PrintWriter out) {
        Map<String, Object> reqMap = Maps.newHashMap();
        if (StringUtil.isNotEmpty((String) request.getParameter("prodId"))) {
            reqMap.put("prodId", (String) request.getParameter("prodId"));
        }
        if (StringUtil.isNotEmpty((String) request.getParameter("channel_rtype_code"))) {
            reqMap.put("channel_rtype_code", (String) request.getParameter("channel_rtype_code"));
        }
        if (StringUtil.isNotEmpty((String) request.getParameter("region_rtype_code"))) {
            reqMap.put("region_rtype_code", (String) request.getParameter("region_rtype_code"));
        }
        if (StringUtil.isNotEmpty((String) request.getParameter("score1"))) {
            reqMap.put("score1", (String) request.getParameter("score1"));
        }
        if (StringUtil.isNotEmpty((String) request.getParameter("score2"))) {
            reqMap.put("score2", (String) request.getParameter("score2"));
        }
        if (StringUtil.isNotEmpty((String) request.getParameter("model1_ap_amt"))) {
            reqMap.put("model1_ap_amt", (String) request.getParameter("model1_ap_amt"));
        }
        if (StringUtil.isNotEmpty((String) request.getParameter("model2_ap_amt"))) {
            reqMap.put("model2_ap_amt", (String) request.getParameter("model2_ap_amt"));
        }
        if (StringUtil.isNotEmpty((String) request.getParameter("model1_ap_rate"))) {
            reqMap.put("model1_ap_rate", (String) request.getParameter("model1_ap_rate"));
        }
        if (StringUtil.isNotEmpty((String) request.getParameter("model2_ap_rate"))) {
            reqMap.put("model2_ap_rate", (String) request.getParameter("model2_ap_rate"));
        }
        if (StringUtil.isNotEmpty((String) request.getParameter("final_ap_amt"))) {
            reqMap.put("final_ap_amt", (String) request.getParameter("final_ap_amt"));
        }
        if (StringUtil.isNotEmpty((String) request.getParameter("final_ap_rate"))) {
            reqMap.put("final_ap_rate", (String) request.getParameter("final_ap_rate"));
        }
        if (StringUtil.isNotEmpty((String) request.getParameter("repay_type"))) {
            reqMap.put("repay_type", (String) request.getParameter("repay_type"));
        }
        if (StringUtil.isNotEmpty((String) request.getParameter("maturity"))) {
            reqMap.put("maturity", (String) request.getParameter("maturity"));
        }
        if (StringUtil.isNotEmpty((String) request.getParameter("deleted_flag"))) {
            reqMap.put("deleted_flag", (String) request.getParameter("deleted_flag"));
        }
        if (StringUtil.isNotEmpty((String) request.getParameter("valid_date"))) {
            reqMap.put("valid_date", (String) request.getParameter("valid_date"));
        }
        if (StringUtil.isNotEmpty((String) request.getParameter("invalid_date"))) {
            reqMap.put("invalid_date", (String) request.getParameter("invalid_date"));
        }
        // 插入创建时间和更新时间
        reqMap.put("create_date", new Date());
        reqMap.put("modify_date", new Date());
        try {
            if (ModelParamConfigService.selectApprovingAmountRateUplimitConfigByRegcode((String) reqMap.get("prodId")) != null) {
                out.print("该批复金额利率的记录已存在");
                return null;
            } else {
                int result = ModelParamConfigService.saveApprovingAmountRateUplimitConfig(reqMap);
                if (result > 0) {
                    logger.info("批复金额利率配置信息新增成功,参数为[{}]", reqMap);
                    out.print("新增成功");
                } else {
                    logger.info("批复金额利率配置信息新增失败,参数为[{}]", reqMap);
                    out.print("系统异常，新增批复金额利率配置信息失败");
                }
            }
            return null;
        } catch (Exception e) {
            logger.error("新增批复金额利率配置信息失败", e);
            out.print("系统异常，新增批复金额利率配置信息失败");
            return null;
        }
    }

    /**
     * 修改风险区域配置信息窗口
     * 
     * @param orgId
     * @return
     */
    @RequestMapping("/openModifyApprovingAmountRateUplimitConfigWindow")
    public ModelAndView openModifyApprovingAmountRateUplimitConfigWindow(@RequestParam(value = "id", required = false) Integer id) {
        ModelAndView mav = new ModelAndView();
        if (id == null) {
            logger.info("记录编号为空");
            mav.addObject("oprFlag", "1");// 1代表修改
            mav.addObject("productList", productList);
            mav.addObject("channelrisktypeList", channelrisktypeList);
            mav.addObject("regionrisktypeList", regionrisktypeList);
            mav.addObject("paybackwayList", paybackwayList);
            mav.addObject("deleteflagList", deleteflagList);
            mav.setViewName("paramconfig/detailApprovingAmountRateUplimitConfigInfo");
            return mav;
        }
        // 查询展业机构
        TApprovingAmountRateUplimitfig tApprovingAmountRateUplimitConfig = ModelParamConfigService.selectApprovingAmountRateUplimitConfigByID(id);
        mav.addObject("tApprovingAmountRateUplimitConfig", tApprovingAmountRateUplimitConfig);
        mav.addObject("oprFlag", "1");// 1代表修改
        mav.addObject("productList", productList);
        mav.addObject("channelrisktypeList", channelrisktypeList);
        mav.addObject("regionrisktypeList", regionrisktypeList);
        mav.addObject("paybackwayList", paybackwayList);
        mav.addObject("deleteflagList", deleteflagList);
        mav.setViewName("paramconfig/detailApprovingAmountRateUplimitConfigInfo");
        return mav;
    }

    /**
     * 查询
     * 
     * @param orgId
     * @return
     */
    @RequestMapping("/approvingAmountRateUplimitDetail")
    public ModelAndView approvingAmountRateUplimitDetail(@RequestParam Integer id) {
        ModelAndView mav = new ModelAndView();
        // 查询展业机构
        TApprovingAmountRateUplimitfig tApprovingAmountRateUplimitConfig = ModelParamConfigService.selectApprovingAmountRateUplimitConfigByID(id);
        mav.addObject("tApprovingAmountRateUplimitConfig", tApprovingAmountRateUplimitConfig);
        mav.addObject("oprFlag", "3");// 3代表查询
        mav.addObject("productList", productList);
        mav.addObject("channelrisktypeList", channelrisktypeList);
        mav.addObject("regionrisktypeList", regionrisktypeList);
        mav.addObject("paybackwayList", paybackwayList);
        mav.addObject("deleteflagList", deleteflagList);
        mav.setViewName("paramconfig/detailApprovingAmountRateUplimitConfigInfo");
        return mav;
    }

    /**
     * 修改机构
     * 
     * @param request
     * @param out
     * @return
     */
    @RequestMapping(value = "/modifyApprovingAmountRateUplimitConfigWindow", method = RequestMethod.POST)
    public ModelAndView modifyApprovingAmountRateUplimitConfigWindow(HttpServletRequest request, PrintWriter out) {
        Map<String, Object> reqMap = Maps.newHashMap();
        if (StringUtil.isNotEmpty((String) request.getParameter("id"))) {
            reqMap.put("id", (String) request.getParameter("id"));
        }
        if (StringUtil.isNotEmpty((String) request.getParameter("prodId"))) {
            reqMap.put("prodId", (String) request.getParameter("prodId"));
        }
        if (StringUtil.isNotEmpty((String) request.getParameter("channel_rtype_code"))) {
            reqMap.put("channel_rtype_code", (String) request.getParameter("channel_rtype_code"));
        }
        if (StringUtil.isNotEmpty((String) request.getParameter("region_rtype_code"))) {
            reqMap.put("region_rtype_code", (String) request.getParameter("region_rtype_code"));
        }
        if (StringUtil.isNotEmpty((String) request.getParameter("score1"))) {
            reqMap.put("score1", (String) request.getParameter("score1"));
        }
        if (StringUtil.isNotEmpty((String) request.getParameter("score2"))) {
            reqMap.put("score2", (String) request.getParameter("score2"));
        }
        if (StringUtil.isNotEmpty((String) request.getParameter("model1_ap_amt"))) {
            reqMap.put("model1_ap_amt", (String) request.getParameter("model1_ap_amt"));
        }
        if (StringUtil.isNotEmpty((String) request.getParameter("model2_ap_amt"))) {
            reqMap.put("model2_ap_amt", (String) request.getParameter("model2_ap_amt"));
        }
        if (StringUtil.isNotEmpty((String) request.getParameter("model1_ap_rate"))) {
            reqMap.put("model1_ap_rate", (String) request.getParameter("model1_ap_rate"));
        }
        if (StringUtil.isNotEmpty((String) request.getParameter("model2_ap_rate"))) {
            reqMap.put("model2_ap_rate", (String) request.getParameter("model2_ap_rate"));
        }
        if (StringUtil.isNotEmpty((String) request.getParameter("final_ap_amt"))) {
            reqMap.put("final_ap_amt", (String) request.getParameter("final_ap_amt"));
        }
        if (StringUtil.isNotEmpty((String) request.getParameter("final_ap_rate"))) {
            reqMap.put("final_ap_rate", (String) request.getParameter("final_ap_rate"));
        }
        if (StringUtil.isNotEmpty((String) request.getParameter("repay_type"))) {
            reqMap.put("repay_type", (String) request.getParameter("repay_type"));
        }
        if (StringUtil.isNotEmpty((String) request.getParameter("maturity"))) {
            reqMap.put("maturity", (String) request.getParameter("maturity"));
        }
        if (StringUtil.isNotEmpty((String) request.getParameter("deleted_flag"))) {
            reqMap.put("deleted_flag", (String) request.getParameter("deleted_flag"));
        }
        if (StringUtil.isNotEmpty((String) request.getParameter("valid_date"))) {
            reqMap.put("valid_date", (String) request.getParameter("valid_date"));
        }
        if (StringUtil.isNotEmpty((String) request.getParameter("invalid_date"))) {
            reqMap.put("invalid_date", (String) request.getParameter("invalid_date"));
        }
        if (StringUtil.isNotEmpty((String) request.getParameter("create_date"))) {
            reqMap.put("create_date", (String) request.getParameter("create_date"));
        }
        try {
            int result = ModelParamConfigService.modifyApprovingAmountRateUplimitConfig(reqMap);
            if (result > 0) {
                logger.info("修改成功,参数为[{}]", reqMap);
                out.print("修改成功");
            } else {
                logger.info("修改失败,参数为[{}]", reqMap);
                out.print("系统异常，修改失败");
            }
        } catch (Exception e) {
            logger.error("修改失败", e);
            out.print("系统异常，修改失败");
        }
        return null;
    }

    /**
     * 删除
     * 
     * @param orgId
     * @param out
     * @return
     */
    @RequestMapping(value = "/deleteApprovingAmountRateUplimitConfig", method = RequestMethod.POST)
    public ModelAndView deleteApprovingAmountRateUplimitConfig(@RequestParam(value = "id", required = false) String id, PrintWriter out) {
        Map<String, Object> reqMap = Maps.newHashMap();
        try {
            if (StringUtil.isNotEmpty(id)) {
                reqMap.put("id", Integer.parseInt(id));
            }
            int flag = ModelParamConfigService.deleteApprovingAmountRateUplimitConfig(id);
            if (flag > 0) {
                out.print("删除成功");
                return null;
            } else {
                out.print("删除失败");
                return null;
            }
        } catch (NumberFormatException e) {
            logger.error("系统异常", e);
            out.print("删除失败");
            return null;
        }
    }

}
