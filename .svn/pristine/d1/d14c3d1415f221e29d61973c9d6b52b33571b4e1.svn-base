/**
 * 
 */
package com.hrbb.loan.pos.dao.entity;

import java.io.Serializable;
import java.util.Date;

import org.apache.commons.lang3.StringUtils;

import com.hrbb.loan.pos.util.IdUtil;

/**
 * <p>Title: TransactionLog.java </p>
 * <p>Description:  </p>
 * <p>Copyright: Copyright (C) 2015 Hrbb Ltd. Co.</p> 
 *     
 * @author linzhaolin@hrbb.com.cn
 * @version 
 * @date 2015年7月9日
 *
 * logs: 1. 
 */
public class TransactionLog implements Serializable{
	
	/**
	 * 
	 */
	private static final long serialVersionUID = 7354591941545668473L;
	public static final String 核心交易状态_成功 = "SUCCESS";
	public static final String 核心交易状态_失败 = "FAILED";
	
	private final static int REQUEST_LEN = 1000; 
	/**/
	private String seq;
	/**/
	private Date transTime;
	/**/
	private String bizId;
	/**/
	private String status = TransactionLog.核心交易状态_成功;
	/**/
	private String request;
	/**/
	private String response;
	/**/
	private Date reqTime;
	/**/
	private Date rspTime;
	
	public TransactionLog(String bizId){
		this.seq = IdUtil.getId("OTS");
		this.bizId = bizId;
		this.transTime = new Date();
		this.reqTime = new Date();
	}
	
	public String getSeq() {
		return seq;
	}
	
	public Date getTransTime() {
		return transTime;
	}

	public String getBizId() {
		return bizId;
	}

	public String getRequest() {
		if(request!=null && request.getBytes().length>REQUEST_LEN){
			return StringUtils.substring(request, 0, REQUEST_LEN);
		}else{
			return this.request;
		}
	}
	
	public void setTransObject(Object req, Object rsp) {
		/*request*/
		this.request = req.toString();
		/*response*/
		this.response=rsp.toString();
	}
	
	public String getResponse() {
		if(response!=null && response.getBytes().length>500){
			return StringUtils.substring(response, 0, 500);
		}else{
			return this.response;
		}
	}

	public Date getReqTime() {
		return reqTime;
	}

	public Date getRspTime() {
		return rspTime;
	}

	public void setRspTime() {
		this.rspTime = new Date();
	}

	public String getStatus() {
		return status;
	}

	public void setStatus(String status) {
		this.status = status;
	}
	
	
	
}
