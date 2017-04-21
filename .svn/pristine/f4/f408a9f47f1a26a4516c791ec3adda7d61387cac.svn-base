/**
 * 
 *	哈尔滨银行
 * Copyright (c) 2007-2015 HRBB,Inc.All Rights Reserved.
 */
package com.hrbb.loan.pos.dao.entity;

import java.io.Serializable;
import java.util.Date;

/**
 * 
 * @author byp
 * @version $Id: Message.java, v 0.1 2015年3月16日 下午4:56:48 byp Exp $
 */
public class TMessageHist implements Serializable{
	
	

    
    /**
	 * 
	 */
	private static final long serialVersionUID = 4999371355271848071L;
	/*
     *  1、审核结果通知（通过）
     *   2、审批结果通知（拒绝）
     *   3、补件通知
     *   4、协议签订通知
     *   5、放款结果通知
     *   6、协议状态调整通知
     *   7、还款结果通知
     *   8、到期还款提醒
     *   9、逾期催收通知 
     *   10、促销活动通知
     */
    private String messageType;
    /*
     * 根据messageType的不同，由不同的 Message的 toString 返回的JSON值 
     */
    private String messageInfo;
    private String messageAddi;
    private String custId;
    private String loanId;
    private String contNo;
    private String listId;
    private String loanAcNo;
    private String stdshNo;
    private String stdMerNo;
    private String channel;
    private String inChannelKind;
    
    private int id;

    private Date createTime;
    private Date timerDate;
    private Date sendTime;
    
    /**
	 * Getter method for property <tt>createTime</tt>.
	 * 
	 * @return property value of createTime
	 */
	public Date getCreateTime() {
		return createTime;
	}

	/**
	 * Setter method for property <tt>createTime</tt>.
	 * 
	 * @param createTime value to be assigned to property createTime
	 */
	public void setCreateTime(Date createTime) {
		this.createTime = createTime;
	}

	/**
	 * Getter method for property <tt>timerDate</tt>.
	 * 
	 * @return property value of timerDate
	 */
	public Date getTimerDate() {
		return timerDate;
	}

	/**
	 * Setter method for property <tt>timerDate</tt>.
	 * 
	 * @param timerDate value to be assigned to property timerDate
	 */
	public void setTimerDate(Date timerDate) {
		this.timerDate = timerDate;
	}

	/**
	 * Getter method for property <tt>sendTime</tt>.
	 * 
	 * @return property value of sendTime
	 */
	public Date getSendTime() {
		return sendTime;
	}

	/**
	 * Setter method for property <tt>sendTime</tt>.
	 * 
	 * @param sendTime value to be assigned to property sendTime
	 */
	public void setSendTime(Date sendTime) {
		this.sendTime = sendTime;
	}

	public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getMessageType() {
        return messageType;
    }

    public void setMessageType(String messageType) {
        this.messageType = messageType;
    }

    public String getMessageInfo() {
        return messageInfo;
    }

    public void setMessageInfo(String messageInfo) {
        this.messageInfo = messageInfo;
    }

    public String getMessageAddi() {
        return messageAddi;
    }

    public void setMessageAddi(String messageAddi) {
        this.messageAddi = messageAddi;
    }

    public String getCustId() {
        return custId;
    }

    public void setCustId(String custId) {
        this.custId = custId;
    }

    public String getLoanId() {
        return loanId;
    }

    public void setLoanId(String loanId) {
        this.loanId = loanId;
    }

    public String getContNo() {
        return contNo;
    }

    public void setContNo(String contNo) {
        this.contNo = contNo;
    }

    public String getListId() {
        return listId;
    }

    public void setListId(String listId) {
        this.listId = listId;
    }

    public String getLoanAcNo() {
        return loanAcNo;
    }

    public void setLoanAcNo(String loanacNo) {
        this.loanAcNo = loanacNo;
    }

    public String getStdshNo() {
        return stdshNo;
    }

    public void setStdshNo(String stdshNo) {
        this.stdshNo = stdshNo;
    }

    public String getStdMerNo() {
        return stdMerNo;
    }

    public void setStdMerNo(String stdMerNo) {
        this.stdMerNo = stdMerNo;
    }

    public String getChannel() {
        return channel;
    }

    public void setChannel(String channel) {
        this.channel = channel;
    }

    public String getInChannelKind() {
        return inChannelKind;
    }

    public void setInChannelKind(String inChannelKind) {
        this.inChannelKind = inChannelKind;
    }

}
