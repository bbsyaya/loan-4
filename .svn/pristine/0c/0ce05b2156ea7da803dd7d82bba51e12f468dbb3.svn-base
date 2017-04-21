/**
 * 
 */
package com.hrbb.loan.pos.entity.track;

import java.lang.reflect.InvocationTargetException;
import java.lang.reflect.Method;
import java.util.Date;
import java.util.List;
import java.util.Map;
import java.util.Set;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import com.google.common.collect.Lists;
import com.google.common.collect.Maps;
import com.google.common.collect.Sets;
import com.hrbb.loan.pos.entity.SpringBeans;
import com.hrbb.loan.pos.service.BizOperationRecordService;

/**
 * <p>Title: AbsBizObjectTracker.java </p>
 * <p>Description:  </p>
 * <p>Copyright: Copyright (C) 2015 Hrbb Ltd. Co.</p> 
 *     
 * @author linzhaolin@hrbb.com.cn
 * @version 
 * @date 2015年8月17日
 *
 * logs: 1. 
 */
public abstract class AbsBizObjectTracker implements BizObjectTracker {
	
	protected final Logger logger = LoggerFactory.getLogger(this.getClass());
	
	private Map<String,TrackField> trackIssues = Maps.newHashMap();
	
	private Set<String> excludeFields = Sets.newHashSet();
	
	protected Map<String, Object> applyChanges(Object object,Map<String, Object> updateVars){
		
		Class<?> clazz = object.getClass();
		for(Map.Entry<String, Object> en : updateVars.entrySet()){
			if(excludeFields.contains(en.getKey())) {
				continue;		//排除项
			}
			try{
				Object obj = updateVars.get(en.getKey());
				/*getXXX*/
				String getMthdName = "get"+en.getKey().substring(0,1).toUpperCase()+en.getKey().substring(1);
				Method getMethod = clazz.getDeclaredMethod(getMthdName);
				Object getVal = getMethod.invoke(object);		//getXXX
				this.addTrack(en.getKey(), getVal, obj);
				
//				/*setXXX*/
//				String setMthdName = "set"+columnId.substring(0,1).toUpperCase()+columnId.substring(1);
//				Method setMethod = clazz.getDeclaredMethod(setMthdName,obj.getClass());		//setXXX
//				setMethod.invoke(this, obj);
			}catch(NoSuchMethodException | IllegalAccessException | IllegalArgumentException | InvocationTargetException e1){
				logger.error("记录业务信息变更失败!err="+en.getKey(),e1);
			}
		}
		
		Map<String,Object> changedFileds = Maps.newHashMap();
		for(TrackField tf:getTrakeIssues().values()){
			changedFileds.put(tf.getId(), tf.getValue());
		}
		return changedFileds;
		
	}
	
	/* (non-Javadoc)
	 * @see com.hrbb.loan.pos.dao.entity.common.BizObjectTracker#getTrakeIssues()
	 */
	@Override
	public Map<String, TrackField> getTrakeIssues() {
		return trackIssues;
	}
	
	/**
	 * 比较2个字符串是否相等
	 * @param a
	 * @param b
	 */
	private boolean compare(String strA,String strB){
		String baseA = strA==null?"":strA;
		String baseB = strB==null?"":strB;
		return baseA.equals(baseB);
	}

	/* (non-Javadoc)
	 * @see com.hrbb.loan.pos.dao.entity.common.BizObjectTracker#addTrack(java.lang.String, java.lang.String, java.lang.String)
	 */
	@Override
	public void addTrack(String id, String from, String to) {
		if(!compare(from, to)){
			TrackField tf = new TrackField(id, from, to);
			trackIssues.put(id, tf);
		}
	}

	/* (non-Javadoc)
	 * @see com.hrbb.loan.pos.dao.entity.common.BizObjectTracker#addTrack(java.lang.String, java.lang.Object, java.lang.Object)
	 */
	@Override
	public void addTrack(String id, Object from, Object to) {
		addTrack(id, String.valueOf(from), String.valueOf(to));

	}
	
	public boolean updateWithTrack(Map<String,Object> vars, String userName){
		BizOperationRecordService bizOperationRecordService = (BizOperationRecordService)SpringBeans.getBean("bizOperationRecordService");
		/*更新主业务对象*/
		executeUpdate(vars, userName);
		
		/*记录更新日志*/
		List<Map<String, Object>> changeLog = Lists.newArrayList();
		for(TrackField tf:this.getTrakeIssues().values()){
			Map<String, Object> varLog = Maps.newHashMap();
			varLog.put("bizPhase", getBizPhase());
			varLog.put("bizNo", getBizNo());
			varLog.put("operationType", "Modify");
			varLog.put("operationContent", tf.getChangedDescribe());
			varLog.put("operationId", userName);
			varLog.put("operationTime", new Date());
			changeLog.add(varLog);
		}
		/*批量执行*/
		if(changeLog.size()>0){
			bizOperationRecordService.insertSelectiveMapBatch(changeLog);
		}
		
		return true;
	}
	
	abstract protected boolean executeUpdate(Map<String,Object> vars, String userName);
	
	public boolean updateWithTrack(Map<String,Object> vars){
		return updateWithTrack(vars, "system");
	}
	
	public void excludeFields(String fields){
		String[] cols= fields.split(",");
		for(int i=0;i<cols.length;i++){
			excludeFields.add(cols[i]);
		}
	}

}
