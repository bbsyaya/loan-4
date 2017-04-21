package com.hrbb.loan.pos.dao.entity;

import java.io.Serializable;

public class TAICFrpositionInfo implements Serializable{
    /**
	 * 
	 */
	private static final long serialVersionUID = -8530206982204697074L;

	private Integer id;

    private String posCustId;

    private String orderNo;

    private String entName;

    private String regNo;

    private String entType;

    private String regCap;

    private String entStatus;

    private String regOrg;

    private String position;

    private String lerepSign;

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getPosCustId() {
        return posCustId;
    }

    public void setPosCustId(String posCustId) {
        this.posCustId = posCustId == null ? null : posCustId.trim();
    }

    public String getOrderNo() {
        return orderNo;
    }

    public void setOrderNo(String orderNo) {
        this.orderNo = orderNo == null ? null : orderNo.trim();
    }

    public String getEntName() {
        return entName;
    }

    public void setEntName(String entName) {
        this.entName = entName == null ? null : entName.trim();
    }

    public String getRegNo() {
        return regNo;
    }

    public void setRegNo(String regNo) {
        this.regNo = regNo == null ? null : regNo.trim();
    }

    public String getEntType() {
        return entType;
    }

    public void setEntType(String entType) {
        this.entType = entType == null ? null : entType.trim();
    }

    public String getRegCap() {
        return regCap;
    }

    public void setRegCap(String regCap) {
        this.regCap = regCap == null ? null : regCap.trim();
    }

    public String getEntStatus() {
        return entStatus;
    }

    public void setEntStatus(String entStatus) {
        this.entStatus = entStatus == null ? null : entStatus.trim();
    }

    public String getRegOrg() {
        return regOrg;
    }

    public void setRegOrg(String regOrg) {
        this.regOrg = regOrg == null ? null : regOrg.trim();
    }

    public String getPosition() {
        return position;
    }

    public void setPosition(String position) {
        this.position = position == null ? null : position.trim();
    }

    public String getLerepSign() {
        return lerepSign;
    }

    public void setLerepSign(String lerepSign) {
        this.lerepSign = lerepSign == null ? null : lerepSign.trim();
    }
}