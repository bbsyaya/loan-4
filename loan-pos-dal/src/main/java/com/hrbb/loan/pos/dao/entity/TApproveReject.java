package com.hrbb.loan.pos.dao.entity;

import java.io.Serializable;
import java.util.Date;

public class TApproveReject implements Serializable{
	
	
    /**
	 * 
	 */
	private static final long serialVersionUID = -7130601831614323231L;

	private String approveId;

    private Integer approvenum;

    private String rejectreason;

    private String rejdetail;

    private Date rejdt;

    private String rejperson;

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

    public String getRejectreason() {
        return rejectreason;
    }

    public void setRejectreason(String rejectreason) {
        this.rejectreason = rejectreason == null ? null : rejectreason.trim();
    }

    public String getRejdetail() {
        return rejdetail;
    }

    public void setRejdetail(String rejdetail) {
        this.rejdetail = rejdetail == null ? null : rejdetail.trim();
    }

    public Date getRejdt() {
        return rejdt;
    }

    public void setRejdt(Date rejdt) {
        this.rejdt = rejdt;
    }

    public String getRejperson() {
        return rejperson;
    }

    public void setRejperson(String rejperson) {
        this.rejperson = rejperson == null ? null : rejperson.trim();
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