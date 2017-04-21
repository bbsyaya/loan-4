package com.hrbb.loan.pos.dao.entity;

import java.io.Serializable;

public class TAICSharesFrostInfo implements Serializable{
    /**
	 * 
	 */
	private static final long serialVersionUID = -279589460760201804L;

	private Integer id;

    private String posCustId;

    private String orderNo;

    private String froDocNo;

    private String froAuth;

    private String froFrom;

    private String froTo;

    private String froAm;

    private String thawAuth;

    private String thawDocNo;

    private String thawDate;

    private String thawComment;

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

    public String getFroDocNo() {
        return froDocNo;
    }

    public void setFroDocNo(String froDocNo) {
        this.froDocNo = froDocNo == null ? null : froDocNo.trim();
    }

    public String getFroAuth() {
        return froAuth;
    }

    public void setFroAuth(String froAuth) {
        this.froAuth = froAuth == null ? null : froAuth.trim();
    }

    public String getFroFrom() {
        return froFrom;
    }

    public void setFroFrom(String froFrom) {
        this.froFrom = froFrom == null ? null : froFrom.trim();
    }

    public String getFroTo() {
        return froTo;
    }

    public void setFroTo(String froTo) {
        this.froTo = froTo == null ? null : froTo.trim();
    }

    public String getFroAm() {
        return froAm;
    }

    public void setFroAm(String froAm) {
        this.froAm = froAm == null ? null : froAm.trim();
    }

    public String getThawAuth() {
        return thawAuth;
    }

    public void setThawAuth(String thawAuth) {
        this.thawAuth = thawAuth == null ? null : thawAuth.trim();
    }

    public String getThawDocNo() {
        return thawDocNo;
    }

    public void setThawDocNo(String thawDocNo) {
        this.thawDocNo = thawDocNo == null ? null : thawDocNo.trim();
    }

    public String getThawDate() {
        return thawDate;
    }

    public void setThawDate(String thawDate) {
        this.thawDate = thawDate == null ? null : thawDate.trim();
    }

    public String getThawComment() {
        return thawComment;
    }

    public void setThawComment(String thawComment) {
        this.thawComment = thawComment == null ? null : thawComment.trim();
    }
}