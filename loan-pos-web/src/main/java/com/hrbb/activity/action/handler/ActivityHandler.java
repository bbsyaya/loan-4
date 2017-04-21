package com.hrbb.activity.action.handler;

import java.util.Map;

public abstract class ActivityHandler {

	public ActivityHandler successor;
	
	public Map<String, Object> reqMap;
	
	

	public Map<String, Object> getReqMap() {
		return reqMap;
	}

	public void setReqMap(Map<String, Object> reqMap) {
		this.reqMap = reqMap;
	}

	public ActivityHandler getSuccessor() {
		return successor;
	}

	public void setSuccessor(ActivityHandler successor) {
		this.successor = successor;
	}
	
	
	
	public  abstract Map<String, Object> doSuccessor();
	
	public abstract Map<String, Object> doRequest();
}
