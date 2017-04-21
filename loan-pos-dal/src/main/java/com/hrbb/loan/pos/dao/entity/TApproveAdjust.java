package com.hrbb.loan.pos.dao.entity;

import java.io.Serializable;
import java.util.Date;

public class TApproveAdjust implements Serializable{
	
	
    /**
	 * 
	 */
	private static final long serialVersionUID = -8671991879183294024L;

	private String approveId;

    private Integer approvenum;

    private String adjustreason;

    private Date adjustdt;

    private String adjustpersonId;

    public String getApproveId() {
        return approveId;
    }

    public void setApproveId(String approveId) {
        this.approveId = approveId == null ? null : approveId.trim();
    }

    public Integer getApprovenum() {
        return approvenum;
    }

    public void setApprovenum(Integer approvenum) {
        this.approvenum = approvenum;
    }

    public String getAdjustreason() {
        return adjustreason;
    }

    public void setAdjustreason(String adjustreason) {
        this.adjustreason = adjustreason == null ? null : adjustreason.trim();
    }

    public Date getAdjustdt() {
        return adjustdt;
    }

    public void setAdjustdt(Date adjustdt) {
        this.adjustdt = adjustdt;
    }

    public String getAdjustpersonId() {
        return adjustpersonId;
    }

    public void setAdjustpersonId(String adjustpersonId) {
        this.adjustpersonId = adjustpersonId == null ? null : adjustpersonId.trim();
    }
}