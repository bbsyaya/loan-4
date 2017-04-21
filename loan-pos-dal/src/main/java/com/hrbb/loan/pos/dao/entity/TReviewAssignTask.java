package com.hrbb.loan.pos.dao.entity;

import java.util.Date;

public class TReviewAssignTask {
    private Integer id;

    private String ruletype;

    private String rulecontent;

    private String approvePerson;

    private Date valid_date;

    private Date invalid_date;

    private Date modify_date;

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getRuletype() {
        return ruletype;
    }

    public void setRuletype(String ruletype) {
        this.ruletype = ruletype == null ? null : ruletype.trim();
    }

    public String getRulecontent() {
        return rulecontent;
    }

    public void setRulecontent(String rulecontent) {
        this.rulecontent = rulecontent == null ? null : rulecontent.trim();
    }

    public String getApprovePerson() {
        return approvePerson;
    }

    public void setApprovePerson(String approvePerson) {
        this.approvePerson = approvePerson == null ? null : approvePerson.trim();
    }

    public Date getValid_date() {
        return valid_date;
    }

    public void setValid_date(Date valid_date) {
        this.valid_date = valid_date;
    }

    public Date getInvalid_date() {
        return invalid_date;
    }

    public void setInvalid_date(Date invalid_date) {
        this.invalid_date = invalid_date;
    }

    public Date getModify_date() {
        return modify_date;
    }

    public void setModify_date(Date modify_date) {
        this.modify_date = modify_date;
    }
}