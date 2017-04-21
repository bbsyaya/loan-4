/**
 * 
 */
package com.hrbb.loan.controller;

import java.io.PrintWriter;
import java.math.BigDecimal;
import java.text.ParseException;
import java.util.List;
import java.util.Map;

import javax.servlet.http.HttpServletRequest;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.ModelAndView;

import com.alibaba.fastjson.JSONObject;
import com.google.common.collect.Maps;
import com.hrbb.loan.pos.biz.backstage.inter.IStatisticsExecuteBiz;
import com.hrbb.loan.pos.util.DateUtil;
import com.hrbb.loan.web.security.entity.User;

/**
* <p>Title: StatisticsController.java </p>
* <p>Description:  </p>
* <p>Copyright: Copyright (C) 2015 Hrbb Ltd. Co.</p> 
*     
* @author linzhaolin@hrbb.com.cn
* @version 
* @date 2015-4-16
*
* logs: 1. 
*/
@Controller
@RequestMapping("/statistics")
public class StatisticsController {
	private Logger log = LoggerFactory.getLogger(StatisticsController.class);
	
	@Autowired
	@Qualifier("statisticsExecuteBiz")
	private IStatisticsExecuteBiz seBiz;
	
	/**
	 * 统计待处理外呼任务
	 * @param request
	 * @param out
	 * @return
	 */
	@RequestMapping("/todoCallingTasks")
	public ModelAndView todoCallingTasks(HttpServletRequest request, PrintWriter out){
		
//		log.info("*********************************************************************************************************");
		/*query parameters */
		Map<String, Object> reqMap = Maps.newHashMap();
		
		/*execute db query*/
		List<List<Object>> lists = seBiz.selectTodoCallingTasks(reqMap);
//		log.debug("******************lists*************:"+lists);
		
//        JSONObject objJson =  new JSONObject();
//        objJson.put("name", "xxxx");
//        objJson.put("data", lists);
        //log.debug("******************lists*************:"+objJson);
        
//        out.write(objJson.toJSONString());
        out.print(JSONObject.toJSON(lists));
		
//		out.write("['Firefox',   45.0],['IE',       26.8],{    name: 'Chrome',    y: 12.8,    sliced: true,    selected: true},['Safari',    8.5],['Opera',     6.2],['Others',   0.7]");
        
		return null;
	}
	
	/**
	 * 统计待处理任务池情况
	 * @param request
	 * @param out
	 * @return
	 */
	@RequestMapping("/todoReivewTasks")
	public ModelAndView todoReivewTasks(HttpServletRequest request, PrintWriter out){
		/*query parameters */
		Map<String, Object> reqMap = Maps.newHashMap();
		
		/*execute db query*/
		List<List<Object>> lists = seBiz.selectTodoReviews(reqMap);
		
		out.print(JSONObject.toJSON(lists));
		
		return null;
	}
	
	/**
	 * 统计每日进件处理情况
	 * @param request
	 * @param out
	 * @return
	 */
	@RequestMapping("/dailyEntries")
	public ModelAndView dailyEntries(HttpServletRequest request, PrintWriter out){
		
		return null;
	}
	
	/**
	 * 
	 * @param request
	 * @param out
	 * @return
	 * @throws ParseException 
	 */
	@RequestMapping("/dailyStatistic")
	public ModelAndView dailyStatistic(HttpServletRequest request, PrintWriter out) throws ParseException{
		/*query parameters */
		Map<String, Object> reqMap = Maps.newHashMap();
		reqMap.put("queryBeginDate", DateUtil.getToday().subSequence(0, 7)+"-01");
		reqMap.put("queryEndDate", DateUtil.getMonthEnd(DateUtil.getToday()));
		
		/*execute db query*/
		Map<String, Object> lists = seBiz.selectDailyStatistic(reqMap);
		out.print(JSONObject.toJSON(lists));
		
		return null;
	}
	
	
	@RequestMapping("/channelEntries")
	public ModelAndView channelEntries(HttpServletRequest request, PrintWriter out){
		/*query parameters */
		Map<String, Object> reqMap = Maps.newHashMap();
		
		/*execute db query*/
		Map<String, Object> lists = seBiz.selectChannelEntries(reqMap);
		
		out.print(JSONObject.toJSON(lists));
		
		return null;
	}
	
	@RequestMapping("/queryTaskTips1")
	public ModelAndView queryTaskTips1(HttpServletRequest request, PrintWriter out){
		String privileges = (String)request.getSession().getAttribute("assignedPrivileges");
		int count = 0;
		
		/*query parameters */
		Map<String, Object> reqMap = Maps.newHashMap();
		
		/*execute db query*/
		List<Map<String, Object>> resultSet = seBiz.queryTaskTips1(reqMap);
		for(Map<String, Object> row:resultSet){
			String status = (String)row.get("applyStatus");
			if(privileges.indexOf("ROLE_INFO_APPR;")>=0){	//资料审核
				if(status.matches("(20|21)")) count += (long)row.get("cnt");
			}
			if(privileges.indexOf("ROLE_APPR_LV1;")>=0){		//风险复审1
				if(status.matches("(31|32)")) count += (long)row.get("cnt");
			}
			if(privileges.indexOf("ROLE_APPR_LV2;")>=0){		//风险复审2
				if(status.matches("(31|32|33)")) count += (long)row.get("cnt");
			}
			if(privileges.indexOf("ROLE_APPR_LV3;")>=0){		//风险复审3
				if(status.equals("34")) count += (long)row.get("cnt");
			}
			if(privileges.indexOf("ROLE_APPR_LV4;")>=0){		//风险复审4
				if(status.equals("35")) count += (long)row.get("cnt");
			}
		}
		
		out.print(String.valueOf(count));
		
		return null;
	}
	
	@RequestMapping("/queryTaskTips2")
	public ModelAndView queryTaskTips2(HttpServletRequest request, PrintWriter out){
		
		/*query parameters */
		Map<String, Object> reqMap = Maps.newHashMap();
		
		/*execute db query*/
		int count = seBiz.queryTaskTips2(reqMap);
		
		out.print(String.valueOf(count));
		
		return null;
	}
	
	@RequestMapping("/queryTaskTips3")
	public ModelAndView queryTaskTips3(HttpServletRequest request, PrintWriter out){
		User user = (User)request.getSession().getAttribute("USER");
		long total =  0;		//总数
		BigDecimal claimed = new BigDecimal(0);		//认领数
		
		/*query parameters */
		Map<String, Object> reqMap = Maps.newHashMap();
		reqMap.put("claimerId", user.getUserName());
		
		/*execute db query*/
		List<Map<String, Object>> resultSet = seBiz.queryTaskTips3(reqMap);
		for(Map<String, Object> row:resultSet){
			total = (long)row.get("cnt");
			claimed = (BigDecimal)row.get("claimed");
		}
		StringBuffer html = new StringBuffer("");
		html.append("   <table width=\"100%\" height=\"64\"  border=\"0\" cellpadding=\"0\" cellspacing=\"1\">")
		.append("      <tr>")
		.append("        <td width=\"10%\" valign=\"top\"><div align=\"center\">共有</div></td>")
		.append("        <td width=\"10%\">")
		.append("        	<div id=\"cntCall\" align=\"center\" class=\"taskNum\">")
		.append(total)
		.append("        	</div>")
		.append("        </td>")
		.append("        <td width=\"30%\" valign=\"bottom\">件待处理外呼任务</td>")
		.append("<td><div style=\"height:32px; width:1px; border-left:1px #000 solid\"></div></td>")
		.append("        <td width=\"15%\" valign=\"middle\"><div align=\"center\">您共认领了</div></td>")
		.append("        <td width=\"10%\">")
		.append("        	<div id=\"cntCall\" align=\"center\" class=\"taskNum\">")
		.append(claimed.intValue())
		.append("        	</div>")
		.append("        </td>")
		.append("        <td width=\"25%\" valign=\"bottom\">件任务尚未处理</td>")
		.append("      </tr>")
		.append("    </table>");
		
		out.print(html.toString());
		
		return null;
	}
	
	@RequestMapping("/queryTaskTips4")
	public ModelAndView queryTaskTips4(HttpServletRequest request, PrintWriter out){
//		User user = (User)request.getSession().getAttribute("USER");
		long total =  0;		//总数
		String minDate = "";
		
		/*query parameters */
		Map<String, Object> reqMap = Maps.newHashMap();
//		reqMap.put("claimerId", user.getUserName());
		
		/*execute db query*/
		List<Map<String, Object>> resultSet = seBiz.queryTaskTips4(reqMap);
		for(Map<String, Object> row:resultSet){
			total = (long)row.get("cnt");
			minDate = (String)row.get("minDate");
		}
		minDate = minDate==null ? "":minDate;
		
		StringBuffer html = new StringBuffer("");
		html.append("   <table width=\"100%\" height=\"64\"  border=\"0\" cellpadding=\"0\" cellspacing=\"1\">")
		.append("      <tr>")
		.append("        <td width=\"10%\" valign=\"top\"><div align=\"center\">共有</div></td>")
		.append("        <td width=\"10%\">")
		.append("        	<div id=\"cntCall\" align=\"center\" class=\"taskNum\">")
		.append(total)
		.append("        	</div>")
		.append("        </td>")
		.append("        <td width=\"30%\" valign=\"bottom\">笔贷款在1周内到期</td>")
		.append("<td><div style=\"height:32px; width:1px; border-left:1px #000 solid\"></div></td>")
		.append("        <td width=\"25%\" valign=\"middle\"><div align=\"center\">").append("其中最近贷款到期日为</div></td>")
		.append("        <td width=\"20%\">")
		.append("        	<div id=\"cntCall\" align=\"center\" class=\"taskNum\">")
		.append(minDate.trim().length()==0?" -- ":minDate)
		.append("        	</div>")
		.append("        </td>")
		.append("      </tr>")
		.append("    </table>");
		
		out.print(html.toString());
		
		return null;
	}
	
	@RequestMapping("/queryTaskTips5")
	public ModelAndView queryTaskTips5(HttpServletRequest request, PrintWriter out){
		User user = (User)request.getSession().getAttribute("USER");
		long total =  0;		//总数
		String minDate = "";
		
		/*query parameters */
		Map<String, Object> reqMap = Maps.newHashMap();
		reqMap.put("approver", user.getUserName());
		
		/*execute db query*/
		List<Map<String, Object>> resultSet = seBiz.queryTaskTips5(reqMap);
		for(Map<String, Object> row:resultSet){
			long cnt = (long)row.get("cnt");
			String tmp = (String)row.get("minDate");
			
			if(tmp!=null && tmp.trim().length()>0){
				if(minDate.trim().length()==0){
					minDate = tmp;
				}else{
					if(tmp.compareTo(minDate) < 0){
						minDate = tmp;
					}
				}
			}
			total += cnt;
		}
		
		StringBuffer html = new StringBuffer("");
		html.append("   <table width=\"100%\" height=\"64\"  border=\"0\" cellpadding=\"0\" cellspacing=\"1\">")
		.append("      <tr>")
		.append("        <td width=\"10%\" valign=\"top\"><div align=\"center\">共有</div></td>")
		.append("        <td width=\"10%\">")
		.append("        	<div id=\"cntCall\" align=\"center\" class=\"taskNum\">")
		.append(total)
		.append("        	</div>")
		.append("        </td>")
		.append("        <td width=\"30%\" valign=\"bottom\">已认领未处理的业务申请</td>")
		.append("<td><div style=\"height:32px; width:1px; border-left:1px #000 solid\"></div></td>")
		.append("        <td width=\"25%\" valign=\"middle\"><div align=\"center\">").append("其中距今最长认领日期为</div></td>")
		.append("        <td width=\"20%\">")
		.append("        	<div id=\"cntCall\" align=\"center\" class=\"taskNum\">")
		.append(minDate.trim().length()==0?" -- ":minDate)
		.append("        	</div>")
		.append("        </td>")
		.append("      </tr>")
		.append("    </table>");
		
		out.print(html.toString());
		
		return null;
	}
	
	@RequestMapping("/queryTaskTips6")
	public ModelAndView queryTaskTips6(HttpServletRequest request, PrintWriter out){
//		User user = (User)request.getSession().getAttribute("USER");
		long total =  0;		//总数
		String signDate = "";
		
		/*query parameters */
		Map<String, Object> reqMap = Maps.newHashMap();
//		reqMap.put("claimerId", user.getUserName());
		
		/*execute db query*/
		List<Map<String, Object>> resultSet = seBiz.queryTaskTips6(reqMap);
		for(Map<String, Object> row:resultSet){
			total = (long)row.get("cnt");
//			minDate = (String)row.get("minDate");
		}
//		minDate = minDate==null ? "":minDate;
		
		StringBuffer html = new StringBuffer("");
		html.append("   <table width=\"100%\" height=\"64\"  border=\"0\" cellpadding=\"0\" cellspacing=\"1\">")
		.append("      <tr>")
		.append("        <td width=\"10%\" valign=\"top\"><div align=\"center\">共有</div></td>")
		.append("        <td width=\"10%\">")
		.append("        	<div id=\"cntCall\" align=\"center\" class=\"taskNum\">")
		.append(total)
		.append("        	</div>")
		.append("        </td>")
		.append("        <td width=\"30%\" valign=\"bottom\">笔已签约未生效协议</td>")
		.append("<td><div style=\"height:32px; width:1px; border-left:1px #000 solid\"></div></td>")
		.append("        <td width=\"25%\" valign=\"middle\"><div align=\"center\">").append("其中距今最长签约日期为</div></td>")
		.append("        <td width=\"20%\">")
		.append("        	<div id=\"cntCall\" align=\"center\" class=\"taskNum\">")
		.append(signDate.trim().length()==0?" -- ":signDate)
		.append("        	</div>")
		.append("        </td>")
		.append("      </tr>")
		.append("    </table>");
		
		out.print(html.toString());
		
		return null;
	}
	
	@RequestMapping("/queryTaskTips7")
	public ModelAndView queryTaskTips7(HttpServletRequest request, PrintWriter out){
//		User user = (User)request.getSession().getAttribute("USER");
		long total =  0;		//总数
		String minDate = "";
		
		/*query parameters */
		Map<String, Object> reqMap = Maps.newHashMap();
//		reqMap.put("claimerId", user.getUserName());
		
		/*execute db query*/
		List<Map<String, Object>> resultSet = seBiz.queryTaskTips7(reqMap);
		for(Map<String, Object> row:resultSet){
			total = (long)row.get("cnt");
//			minDate = (String)row.get("minDate");
		}
//		minDate = minDate==null ? "":minDate;
		
		StringBuffer html = new StringBuffer("");
		html.append("   <table width=\"100%\" height=\"64\"  border=\"0\" cellpadding=\"0\" cellspacing=\"1\">")
		.append("      <tr>")
		.append("        <td width=\"10%\" valign=\"top\"><div align=\"center\">共有</div></td>")
		.append("        <td width=\"10%\">")
		.append("        	<div id=\"cntCall\" align=\"center\" class=\"taskNum\">")
		.append(total)
		.append("        	</div>")
		.append("        </td>")
		.append("        <td width=\"30%\" valign=\"bottom\">笔待审核用款申请</td>")
		.append("<td><div style=\"height:32px; width:1px; border-left:1px #000 solid\"></div></td>")
		.append("        <td width=\"25%\" valign=\"middle\"><div align=\"center\">").append("其中最早申请日期为</div></td>")
		.append("        <td width=\"20%\">")
		.append("        	<div id=\"cntCall\" align=\"center\" class=\"taskNum\">")
		.append(minDate.trim().length()==0?" -- ":minDate)
		.append("        	</div>")
		.append("        </td>")
		.append("      </tr>")
		.append("    </table>");
		
		out.print(html.toString());
		
		return null;
	}
	
	@RequestMapping("/queryTaskTips8")
	public ModelAndView queryTaskTips8(HttpServletRequest request, PrintWriter out){
//		User user = (User)request.getSession().getAttribute("USER");
		long total =  0;		//总数
		String minDate = "";
		
		/*query parameters */
		Map<String, Object> reqMap = Maps.newHashMap();
//		reqMap.put("claimerId", user.getUserName());
		
		/*execute db query*/
		List<Map<String, Object>> resultSet = seBiz.queryTaskTips8(reqMap);
		for(Map<String, Object> row:resultSet){
			total = (long)row.get("cnt");
//			minDate = (String)row.get("minDate");
		}
//		minDate = minDate==null ? "":minDate;
		
		StringBuffer html = new StringBuffer("");
		html.append("   <table width=\"100%\" height=\"64\"  border=\"0\" cellpadding=\"0\" cellspacing=\"1\">")
		.append("      <tr>")
		.append("        <td width=\"10%\" valign=\"top\"><div align=\"center\">共有</div></td>")
		.append("        <td width=\"10%\">")
		.append("        	<div id=\"cntCall\" align=\"center\" class=\"taskNum\">")
		.append(total)
		.append("        	</div>")
		.append("        </td>")
		.append("        <td width=\"30%\" valign=\"bottom\">笔业务受理未处理</td>")
		.append("<td><div style=\"height:32px; width:1px; border-left:1px #000 solid\"></div></td>")
		.append("        <td width=\"25%\" valign=\"middle\"><div align=\"center\">").append("其中最早申请日期为</div></td>")
		.append("        <td width=\"20%\">")
		.append("        	<div id=\"cntCall\" align=\"center\" class=\"taskNum\">")
		.append(minDate.trim().length()==0?" -- ":minDate)
		.append("        	</div>")
		.append("        </td>")
		.append("      </tr>")
		.append("    </table>");
		
		out.print(html.toString());
		
		return null;
	}
	
	@RequestMapping("/queryTaskTips9")
	public ModelAndView queryTaskTips9(HttpServletRequest request, PrintWriter out){
//		User user = (User)request.getSession().getAttribute("USER");
		long total =  0;		//总数
		String minDate = "";
		
		/*query parameters */
		Map<String, Object> reqMap = Maps.newHashMap();
//		reqMap.put("claimerId", user.getUserName());
		
		/*execute db query*/
		List<Map<String, Object>> resultSet = seBiz.queryTaskTips9(reqMap);
		for(Map<String, Object> row:resultSet){
			total = (long)row.get("cnt");
			minDate = (String)row.get("minDate");
		}
		minDate = minDate==null ? "":minDate;
		
		StringBuffer html = new StringBuffer("");
		html.append("   <table width=\"100%\" height=\"64\"  border=\"0\" cellpadding=\"0\" cellspacing=\"1\">")
		.append("      <tr>")
		.append("        <td width=\"10%\" valign=\"top\"><div align=\"center\">共有</div></td>")
		.append("        <td width=\"10%\">")
		.append("        	<div id=\"cntCall\" align=\"center\" class=\"taskNum\">")
		.append(total)
		.append("        	</div>")
		.append("        </td>")
		.append("        <td width=\"30%\" valign=\"bottom\">笔待放款用款</td>")
		.append("<td><div style=\"height:32px; width:1px; border-left:1px #000 solid\"></div></td>")
		.append("        <td width=\"25%\" valign=\"middle\"><div align=\"center\">").append("其中最早申请日期为</div></td>")
		.append("        <td width=\"20%\">")
		.append("        	<div id=\"cntCall\" align=\"center\" class=\"taskNum\">")
		.append(minDate.trim().length()==0?" -- ":minDate)
		.append("        	</div>")
		.append("        </td>")
		.append("      </tr>")
		.append("    </table>");
		
		out.print(html.toString());
		
		return null;
	}
}
