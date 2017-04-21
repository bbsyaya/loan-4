/**
 * 
 *	哈尔滨银行
 * Copyright (c) 2007-2015 HRBB,Inc.All Rights Reserved.
 */
package com.hrbb.loan.pos.service.bean;

import java.io.Serializable;

/**
 * 征信下载通知：业务申请编号,征信文件包名,解密密钥
 * 
 * @author guoyu
 * @version $Id: CreditReportDownloadMessage.java, v 0.1 2015年3月16日 下午6:28:39
 *          guoyu Exp $
 */
public class CreditReportDownloadMessage implements Serializable {

	/**  */
	private static final long serialVersionUID = -6603548154298934796L;

	private String loanid;

	private String filepackagename;

	private String key;

	/**
	 * Getter method for property <tt>loanid</tt>.
	 * 
	 * @return property value of loanid
	 */
	public String getLoanid() {
		return loanid;
	}

	/**
	 * Setter method for property <tt>loanid</tt>.
	 * 
	 * @param loanid
	 *            value to be assigned to property loanid
	 */
	public void setLoanid(String loanid) {
		this.loanid = loanid;
	}

	/**
	 * Getter method for property <tt>filepackagename</tt>.
	 * 
	 * @return property value of filepackagename
	 */
	public String getFilepackagename() {
		return filepackagename;
	}

	/**
	 * Setter method for property <tt>filepackagename</tt>.
	 * 
	 * @param filepackagename
	 *            value to be assigned to property filepackagename
	 */
	public void setFilepackagename(String filepackagename) {
		this.filepackagename = filepackagename;
	}

	/**
	 * Getter method for property <tt>key</tt>.
	 * 
	 * @return property value of key
	 */
	public String getKey() {
		return key;
	}

	/**
	 * Setter method for property <tt>key</tt>.
	 * 
	 * @param key
	 *            value to be assigned to property key
	 */
	public void setKey(String key) {
		this.key = key;
	}

	public String toString() {
		return new String("\"loanid\":\"" + loanid + "\"," + "\"filepackagename\":\""
				+ filepackagename + "\"," + "\"key\":\"" + key + "\"").replaceAll("[\\t\\n\\r]", "");
	}
}
