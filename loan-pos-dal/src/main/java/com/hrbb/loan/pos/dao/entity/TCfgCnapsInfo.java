package com.hrbb.loan.pos.dao.entity;

import java.io.Serializable;
import java.util.Date;

public class TCfgCnapsInfo implements Serializable {
    /**  */
    private static final long serialVersionUID = 4899367325262344759L;

    private Integer           id;

    private String            bankNo;

    private String            cnaps;

    private String            cnapsName;

    private String            province;

    private String            city;
    
    private String            division;

    private String            address;

    private Date              createTime;

    private Date              updateTime;

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getBankNo() {
        return bankNo;
    }

    public void setBankNo(String bankNo) {
        this.bankNo = bankNo == null ? null : bankNo.trim();
    }

    public String getCnaps() {
        return cnaps;
    }

    public void setCnaps(String cnaps) {
        this.cnaps = cnaps == null ? null : cnaps.trim();
    }

    public String getCnapsName() {
        return cnapsName;
    }

    public void setCnapsName(String cnapsName) {
        this.cnapsName = cnapsName == null ? null : cnapsName.trim();
    }

    public String getProvince() {
        return province;
    }

    public void setProvince(String province) {
        this.province = province == null ? null : province.trim();
    }

    public String getCity() {
        return city;
    }

    public void setCity(String city) {
        this.city = city == null ? null : city.trim();
    }

    public String getAddress() {
        return address;
    }

    public void setAddress(String address) {
        this.address = address == null ? null : address.trim();
    }

    public Date getCreateTime() {
        return createTime;
    }

    public void setCreateTime(Date createTime) {
        this.createTime = createTime;
    }

    public Date getUpdateTime() {
        return updateTime;
    }

    public void setUpdateTime(Date updateTime) {
        this.updateTime = updateTime;
    }

    public String getDivision() {
        return division;
    }

    public void setDivision(String division) {
        this.division = division;
    }
}