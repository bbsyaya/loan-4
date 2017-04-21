package com.hrbb.loan.pos.dao.entity;

import java.io.Serializable;
import java.math.BigDecimal;

public class TUserApprInfo implements Serializable{
	
	
    /**
	 * 
	 */
	private static final long serialVersionUID = -2575567770867264759L;

	private String userName;

    private BigDecimal quota;
    private BigDecimal refuseQuota;

    /**
	 * Getter method for property <tt>refuseQuota</tt>.
	 * 
	 * @return property value of refuseQuota
	 */
	public BigDecimal getRefuseQuota() {
		return refuseQuota;
	}

	/**
	 * Setter method for property <tt>refuseQuota</tt>.
	 * 
	 * @param refuseQuota value to be assigned to property refuseQuota
	 */
	public void setRefuseQuota(BigDecimal refuseQuota) {
		this.refuseQuota = refuseQuota;
	}

	public String getUserName() {
        return userName;
    }

    public void setUserName(String userName) {
        this.userName = userName == null ? null : userName.trim();
    }

    public BigDecimal getQuota() {
        return quota;
    }

    public void setQuota(BigDecimal quota) {
        this.quota = quota;
    }
}