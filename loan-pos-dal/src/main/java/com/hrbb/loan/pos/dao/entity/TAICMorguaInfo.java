package com.hrbb.loan.pos.dao.entity;

import java.io.Serializable;

public class TAICMorguaInfo implements Serializable{
    /**
	 * 
	 */
	private static final long serialVersionUID = -9169768101506317166L;

	private Integer id;

    private String posCustId;

    private String orderNo;

    private String morRegId;

    private String guaName;

    private String quan;

    private String value;

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

    public String getMorRegId() {
        return morRegId;
    }

    public void setMorRegId(String morRegId) {
        this.morRegId = morRegId == null ? null : morRegId.trim();
    }

    public String getGuaName() {
        return guaName;
    }

    public void setGuaName(String guaName) {
        this.guaName = guaName == null ? null : guaName.trim();
    }

    public String getQuan() {
        return quan;
    }

    public void setQuan(String quan) {
        this.quan = quan == null ? null : quan.trim();
    }

    public String getValue() {
        return value;
    }

    public void setValue(String value) {
        this.value = value == null ? null : value.trim();
    }
}