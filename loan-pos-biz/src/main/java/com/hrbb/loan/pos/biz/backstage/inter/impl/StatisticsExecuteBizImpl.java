/**
 * 
 */
package com.hrbb.loan.pos.biz.backstage.inter.impl;

import java.text.DateFormat;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Component;

import com.hrbb.loan.pos.biz.backstage.inter.IStatisticsExecuteBiz;
import com.hrbb.loan.pos.service.StatisticsExecuteService;
import com.hrbb.loan.pos.util.DateUtil;

/**
* <p>Title: StatisticsExecuteBizImpl.java </p>
* <p>Description:  </p>
* <p>Copyright: Copyright (C) 2015 Hrbb Ltd. Co.</p> 
*     
* @author linzhaolin@hrbb.com.cn
* @version 
* @date 2015-4-16
*
* logs: 1. 
*/
@Component("statisticsExecuteBiz")
public class StatisticsExecuteBizImpl implements IStatisticsExecuteBiz {
	
	private Logger log = LoggerFactory.getLogger(StatisticsExecuteBizImpl.class);
	
	@Autowired
	@Qualifier("statisticsExecuteService")
	private StatisticsExecuteService service;


	@Override
	public Map<String, Object> getSeletiveOne(Map<String, Object> reqMap) {
		
		return service.getSeletiveOne(reqMap);
	}


	@Override
	public List<List<Object>> selectTodoCallingTasks(
			Map<String, Object> reqMap) {
		log.debug("executing selectTodoCallingTasks....");
		
		List<Map<String, Object>> list = service.selectTodoCallingTasks(reqMap);
		String[] vars = {"TypeName","cnt"};
		List<List<Object>> result = parsePieData(list, vars);
		
		return result;
	}

	private List<List<Object>> parsePieData(List<Map<String, Object>> list,String[] vars){
		List<List<Object>> result = new ArrayList<List<Object>>();
		for(Map<String, Object> r: list){
			List<Object> obj = new ArrayList<Object>();
			obj.add(r.get(vars[0]));
			obj.add(r.get(vars[1]));
			result.add(obj);
		}
		return result;
	}

	@Override
	public List<List<Object>> selectTodoReviews(
			Map<String, Object> reqMap) {
		log.debug("executing selectTodoReviews....");
		
		List<Map<String, Object>> list = service.selectTodoReviews(reqMap);
		String[] vars = {"ApplyStatusName","cnt"};
		List<List<Object>> result = parsePieData(list, vars);
		
		return result;
	}


	@Override
	public List<Map<String, Object>> selectTodoIssues(Map<String, Object> reqMap) {
		log.debug("executing selectTodoIssues....");
		
		List<Map<String, Object>> list = service.selectTodoIssues(reqMap);
		
		return list;
	}


	@Override
	public Map<String, Object> selectDailyStatistic(
			Map<String, Object> reqMap) throws ParseException {
		log.debug("executing selectDailyStatistic....");
		
		Map<String, List<Map<String, Object>>> list = service.selectDailyStatistic(reqMap);		//{"entries":[],"executes":[]}
		
		/*每日进件数*/
		List<Map<String, Object>> entries = list.get("entries");
		/*每日处理情况*/
		List<Map<String, Object>> executes = list.get("executes");
		
		
		String monthBegin = DateUtil.getToday().substring(0, 7)+"-01";		//当月1号
		String monthEnd = DateUtil.getMonthEnd(DateUtil.getToday());		//当月月末
		List<String> days = new ArrayList<String>();
		while(monthBegin.compareTo(monthEnd) <= 0){
			days.add(monthBegin);
			monthBegin = DateUtil.getRelativeDate(monthBegin, 0, 0, 1);		//后延一天
		}
		
		//[{name:xxx,data[]}]
		List<Object> itEntries = initList(days.size(), 0);		//当日进件数
		List<Object> itPass = initList(days.size(), 0);			//当日审批通过数
		List<Object> itDoing = initList(days.size(), 0);			//当日处理数
		List<Object> itRej = initList(days.size(), 0);			//当日拒绝数
		
		for(Map<String, Object> r:entries){
			String entryDate = (String)r.get("beginDate");
//			long dailyCnt = (long)r.get("total");
			long dailyCnt = Long.valueOf(String.valueOf(r.get("total"))).longValue();
			itEntries.set(getIndexInDate(entryDate)-1, dailyCnt);
		}
//		log.debug("itEntries="+itEntries);
		
		for(Map<String, Object> e:executes){
			String beginDate = (String)e.get("beginDate");		
			String endDate = (String)e.get("endDate");
			//int dailyTotal = (int)e.get("total");
//			long dailyIng = (double)e.get("ing");
//			long dailyRej = (long)e.get("rej");
//			long dailyPass = (long)e.get("pass");
			
			
			if(beginDate!=null && beginDate.trim().length()>0 
					&& endDate!=null && endDate.trim().length()>0){
				//只有通过/拒绝才会日期同时不为空,已EndDate作为审批结束日期
				itPass.set(getIndexInDate(endDate)-1, e.get("pass"));
				itRej.set(getIndexInDate(endDate)-1, e.get("rej"));
			}else{
				itDoing.set(getIndexInDate(beginDate)-1, e.get("doing"));
			}
		}
//		log.debug("itPass="+itPass);
//		log.debug("itDone="+itDoing);
//		log.debug("itRej="+itRej);
		
//		Map<String, Object> result
		List<Map<String, Object>> series = new ArrayList<Map<String, Object>>();
		Map<String,Object> obj1 = new HashMap<String,Object>();
		obj1.put("name", "审批通过数");
		obj1.put("data", itPass);
		series.add(obj1);
		
		Map<String,Object> obj3 = new HashMap<String,Object>();
		obj3.put("name", "审批拒绝数");
		obj3.put("data", itRej);
		series.add(obj3);
		
		Map<String,Object> obj2 = new HashMap<String,Object>();
		obj2.put("name", "业务审批中");
		obj2.put("data", itDoing);
		series.add(obj2);
		
		Map<String,Object> obj4 = new HashMap<String,Object>();
		obj4.put("name", "业务进件数");
		obj4.put("data", itEntries);
		series.add(obj4);
		
		//result.add("cat",days);
		Map<String, Object> result = new HashMap<String, Object>();
		result.put("cat", days);
		result.put("series", series);
		
//		log.debug("******888result="+result);
		
		return result;
	}
	
	/**
	 * 取日期的末位作为指标索引
	 * @param date
	 * @return
	 */
	private int getIndexInDate(String date){
		if(date==null || date.trim().length()==0) return -1;
		String[] tmp = date.split("\\-");
		return Integer.valueOf(tmp[2]);
	}
	
	private List<Object> initList(int size, Object args){
		List<Object> o = new ArrayList<Object>(size);
		for(int i=0;i<size;i++){
			o.add(args);
		}
		return o;
	}
	
//	private String[] getMonthlyDays(){
//		//String today = DateUtil.getDateToString3(new Date());
//	}


	@Override
	public Map<String, Object> selectChannelEntries(Map<String, Object> reqMap) {
		//{cat:xxx, data:[{name:xxx, data:[dd,dd,dd]},{}]}
		log.debug("executing channelEntries....");
		
//		String[] names = {"待处理","审批中","拒绝","审批通过"};
		List<Object> channels= new ArrayList<Object>();
		List<Object> todo = new ArrayList<Object>();
		List<Object> review = new ArrayList<Object>();
		List<Object> reject = new ArrayList<Object>();
		List<Object> pass = new ArrayList<Object>();
		
		List<Map<String, Object>> list = service.selectChannelEntries(reqMap);
		for(Map<String, Object> r:list){
			channels.add(r.get("channelName"));
			todo.add(r.get("todos"));
			review.add(r.get("reviews"));
			reject.add(r.get("rejects"));
			pass.add(r.get("pass"));
		}
		
		List<Map<String,Object>> dataFinal = new ArrayList<Map<String, Object>>();
		Map<String, Object> mtodos = new HashMap<String,Object>();
		mtodos.put("name", "待处理申请");
		mtodos.put("data",todo);
		dataFinal.add(mtodos);
		
		Map<String, Object> mreviews = new HashMap<String,Object>();
		mreviews.put("name", "审批中申请");
		mreviews.put("data",review);
		dataFinal.add(mreviews);
		
		Map<String, Object> mrejects = new HashMap<String,Object>();
		mrejects.put("name", "审批拒绝");
		mrejects.put("data",reject);
		dataFinal.add(mrejects);
		
		Map<String, Object> mpass = new HashMap<String,Object>();
		mpass.put("name", "审批通过");
		mpass.put("data",pass);
		dataFinal.add(mpass);
		
		Map<String, Object> result = new HashMap<String, Object>();
		result.put("cat",channels);
		result.put("series", dataFinal);
		//log.debug("************************result:"+result);
		
		return result;
	}
	
	@Override
	public List<Map<String, Object>> queryTaskTips1(Map<String, Object> reqMap) {
		return service.queryTaskTips1(reqMap);
	}


	@Override
	public int queryTaskTips2(Map<String, Object> reqMap) {
		return service.queryTaskTips2(reqMap);
	}


	@Override
	public List<Map<String, Object>> queryTaskTips3(Map<String, Object> reqMap) {
		return service.queryTaskTips3(reqMap);
	}


	@Override
	public List<Map<String, Object>> queryTaskTips4(Map<String, Object> reqMap) {
		return service.queryTaskTips4(reqMap);
	}


	@Override
	public List<Map<String, Object>> queryTaskTips5(Map<String, Object> reqMap) {
		return service.queryTaskTips5(reqMap);
	}


	@Override
	public List<Map<String, Object>> queryTaskTips6(Map<String, Object> reqMap) {
		return service.queryTaskTips6(reqMap);
	}


	@Override
	public List<Map<String, Object>> queryTaskTips7(Map<String, Object> reqMap) {
		return service.queryTaskTips7(reqMap);
	}


	@Override
	public List<Map<String, Object>> queryTaskTips8(Map<String, Object> reqMap) {
		// TODO Auto-generated method stub
		return service.queryTaskTips8(reqMap);
	}


	@Override
	public List<Map<String, Object>> queryTaskTips9(Map<String, Object> reqMap) {
		// TODO Auto-generated method stub
		return service.queryTaskTips9(reqMap);
	}
	
}
