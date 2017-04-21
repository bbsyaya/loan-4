/**
 * 
 */
package com.hrbb.loan.pos.service.bean;

import java.io.Serializable;
import java.util.Map;

import com.google.common.collect.Maps;

/**
 * <p>Title: OTSResult.java </p>
 * <p>Description: 定义了在线交易服务接口的返回结果 </p>
 * <p>Copyright: Copyright (C) 2015 Hrbb Ltd. Co.</p> 
 *     
 * @author linzhaolin@hrbb.com.cn
 * @version 
 * @date 2015年7月17日
 *
 * logs: 1. 
 */
public class OTRespResult implements Serializable{
	
	/**
	 * 
	 */
	private static final long serialVersionUID = 5784502939573773203L;

	public static final boolean 在线交易反馈状态_成功 = true;
	
	public static final boolean 在线交易反馈状态_失败 = false;
	
//	private volatile static OTRespResult result = null;
//	private OTRespResult result = null;
	
	/**
	 * 响应码
	 */
	private boolean respSuccess = 在线交易反馈状态_成功;
	/**
	 * 响应消息
	 */
	private String respMessage;
	
	private Map<String,Object> attribute = Maps.newHashMap();
	
	private OTRespResult(){}
	
	public static OTRespResult newResult(){
//		if(result == null){
//			synchronized (OTRespResult.class){
//				if(result == null){
//					result = new OTRespResult();
//				}
//			}
//		}
//		return result;
		return new OTRespResult();
	}
	
	public boolean isRespSuccess() {
		return respSuccess;
	}

	public void setRespSuccess(boolean respSuccess) {
		this.respSuccess = respSuccess;
	}

	public String getRespMessage() {
		return respMessage;
	}

	public void setRespMessage(String respMessage) {
		this.respMessage = respMessage;
	}
	
	public Object getAttribute(String key){
		return attribute.get(key);
	}
	
	public void setAttribute(String key, Object value){
		attribute.put(key, value);
	}
}
