/**
 * 
 */
package com.hrbb.loan.pos.entity.track;

/**
 * <p>Title: TrackField.java </p>
 * <p>Description:  </p>
 * <p>Copyright: Copyright (C) 2015 Hrbb Ltd. Co.</p> 
 *     
 * @author linzhaolin@hrbb.com.cn
 * @version 
 * @date 2015年8月18日
 *
 * logs: 1. 
 */
public class TrackField {
	private Object valBeforeUpdate;
	
	private Object valAfterUpdate;
	
	private Class<?> claz;
	
	private String fieldId;
	
	public TrackField(String id, Object from, Object to){
		this.fieldId = id;
		this.valBeforeUpdate = from;
		this.valAfterUpdate = to;
		this.claz = from.getClass();
	}
	
	public String getChangedDescribe(){
		return getId()+" : "+this.valBeforeUpdate+" -> "+this.valAfterUpdate;
	}
	
	public Object getValue(){
		return this.valAfterUpdate;
	}
	
	public String getId(){
		return this.fieldId;
	}

	public Class<?> getClaz() {
		return claz;
	}
	
	public String toString(){
		return "id:"+getId()+" |before:"+valBeforeUpdate+" |after:"+valAfterUpdate+" |class="+getClaz();
	}
}
