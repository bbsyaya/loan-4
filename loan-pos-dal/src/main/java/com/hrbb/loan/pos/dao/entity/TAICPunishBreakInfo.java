package com.hrbb.loan.pos.dao.entity;

import java.io.Serializable;

public class TAICPunishBreakInfo implements Serializable{
    /**
	 * 
	 */
	private static final long serialVersionUID = -6662166739648501466L;

	private Integer id;

    private String posCustId;

    private String orderNo;

    private String caseCode;

    private String iNameClean;

    private String type;

    private String sexyClean;

    private String ageClean;

    private String cardNum;

    private String ysFzd;

    private String businessEntity;

    private String regDateClean;

    private String publishDateClean;

    private String courtName;

    private String areaNameClean;

    private String gistId;

    private String gistUnit;

    private String duty;

    private String disruptTypeName;

    private String performance;

    private String performedPart;

    private String unperformPart;

    private String focusNumber;

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

    public String getCaseCode() {
        return caseCode;
    }

    public void setCaseCode(String caseCode) {
        this.caseCode = caseCode == null ? null : caseCode.trim();
    }

    public String getiNameClean() {
        return iNameClean;
    }

    public void setiNameClean(String iNameClean) {
        this.iNameClean = iNameClean == null ? null : iNameClean.trim();
    }

    public String getType() {
        return type;
    }

    public void setType(String type) {
        this.type = type == null ? null : type.trim();
    }

    public String getSexyClean() {
        return sexyClean;
    }

    public void setSexyClean(String sexyClean) {
        this.sexyClean = sexyClean == null ? null : sexyClean.trim();
    }

    public String getAgeClean() {
        return ageClean;
    }

    public void setAgeClean(String ageClean) {
        this.ageClean = ageClean == null ? null : ageClean.trim();
    }

    public String getCardNum() {
        return cardNum;
    }

    public void setCardNum(String cardNum) {
        this.cardNum = cardNum == null ? null : cardNum.trim();
    }

    public String getYsFzd() {
        return ysFzd;
    }

    public void setYsFzd(String ysFzd) {
        this.ysFzd = ysFzd == null ? null : ysFzd.trim();
    }

    public String getBusinessEntity() {
        return businessEntity;
    }

    public void setBusinessEntity(String businessEntity) {
        this.businessEntity = businessEntity == null ? null : businessEntity.trim();
    }

    public String getRegDateClean() {
        return regDateClean;
    }

    public void setRegDateClean(String regDateClean) {
        this.regDateClean = regDateClean == null ? null : regDateClean.trim();
    }

    public String getPublishDateClean() {
        return publishDateClean;
    }

    public void setPublishDateClean(String publishDateClean) {
        this.publishDateClean = publishDateClean == null ? null : publishDateClean.trim();
    }

    public String getCourtName() {
        return courtName;
    }

    public void setCourtName(String courtName) {
        this.courtName = courtName == null ? null : courtName.trim();
    }

    public String getAreaNameClean() {
        return areaNameClean;
    }

    public void setAreaNameClean(String areaNameClean) {
        this.areaNameClean = areaNameClean == null ? null : areaNameClean.trim();
    }

    public String getGistId() {
        return gistId;
    }

    public void setGistId(String gistId) {
        this.gistId = gistId == null ? null : gistId.trim();
    }

    public String getGistUnit() {
        return gistUnit;
    }

    public void setGistUnit(String gistUnit) {
        this.gistUnit = gistUnit == null ? null : gistUnit.trim();
    }

    public String getDuty() {
        return duty;
    }

    public void setDuty(String duty) {
        this.duty = duty == null ? null : duty.trim();
    }

    public String getDisruptTypeName() {
        return disruptTypeName;
    }

    public void setDisruptTypeName(String disruptTypeName) {
        this.disruptTypeName = disruptTypeName == null ? null : disruptTypeName.trim();
    }

    public String getPerformance() {
        return performance;
    }

    public void setPerformance(String performance) {
        this.performance = performance == null ? null : performance.trim();
    }

    public String getPerformedPart() {
        return performedPart;
    }

    public void setPerformedPart(String performedPart) {
        this.performedPart = performedPart == null ? null : performedPart.trim();
    }

    public String getUnperformPart() {
        return unperformPart;
    }

    public void setUnperformPart(String unperformPart) {
        this.unperformPart = unperformPart == null ? null : unperformPart.trim();
    }

    public String getFocusNumber() {
        return focusNumber;
    }

    public void setFocusNumber(String focusNumber) {
        this.focusNumber = focusNumber == null ? null : focusNumber.trim();
    }
}