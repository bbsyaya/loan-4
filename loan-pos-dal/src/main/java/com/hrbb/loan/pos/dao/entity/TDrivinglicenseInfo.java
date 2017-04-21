package com.hrbb.loan.pos.dao.entity;

import java.io.Serializable;
import java.util.Date;

public class TDrivinglicenseInfo implements Serializable{
	
	
    /**
	 * 
	 */
	private static final long serialVersionUID = -7049612441060233131L;

	private String cphm;

    private String cllx;

    private String syr;

    private String cpxh;

    private String zt;

    private String syxz;

    private String ccdjrq;

    private String fzrq;

    private String jyyxqz;

    private String dyqk;

    private Date createtime;

    private Date lstupdtime;

    private String resv1;

    private String resv2;

    private String resv3;

    public String getCphm() {
        return cphm;
    }

    public void setCphm(String cphm) {
        this.cphm = cphm == null ? null : cphm.trim();
    }

    public String getCllx() {
        return cllx;
    }

    public void setCllx(String cllx) {
        this.cllx = cllx == null ? null : cllx.trim();
    }

    public String getSyr() {
        return syr;
    }

    public void setSyr(String syr) {
        this.syr = syr == null ? null : syr.trim();
    }

    public String getCpxh() {
        return cpxh;
    }

    public void setCpxh(String cpxh) {
        this.cpxh = cpxh == null ? null : cpxh.trim();
    }

    public String getZt() {
        return zt;
    }

    public void setZt(String zt) {
        this.zt = zt == null ? null : zt.trim();
    }

    public String getSyxz() {
        return syxz;
    }

    public void setSyxz(String syxz) {
        this.syxz = syxz == null ? null : syxz.trim();
    }

    public String getCcdjrq() {
        return ccdjrq;
    }

    public void setCcdjrq(String ccdjrq) {
        this.ccdjrq = ccdjrq == null ? null : ccdjrq.trim();
    }

    public String getFzrq() {
        return fzrq;
    }

    public void setFzrq(String fzrq) {
        this.fzrq = fzrq == null ? null : fzrq.trim();
    }

    public String getJyyxqz() {
        return jyyxqz;
    }

    public void setJyyxqz(String jyyxqz) {
        this.jyyxqz = jyyxqz == null ? null : jyyxqz.trim();
    }

    public String getDyqk() {
        return dyqk;
    }

    public void setDyqk(String dyqk) {
        this.dyqk = dyqk == null ? null : dyqk.trim();
    }

    public Date getCreatetime() {
        return createtime;
    }

    public void setCreatetime(Date createtime) {
        this.createtime = createtime;
    }

    public Date getLstupdtime() {
        return lstupdtime;
    }

    public void setLstupdtime(Date lstupdtime) {
        this.lstupdtime = lstupdtime;
    }

    public String getResv1() {
        return resv1;
    }

    public void setResv1(String resv1) {
        this.resv1 = resv1 == null ? null : resv1.trim();
    }

    public String getResv2() {
        return resv2;
    }

    public void setResv2(String resv2) {
        this.resv2 = resv2 == null ? null : resv2.trim();
    }

    public String getResv3() {
        return resv3;
    }

    public void setResv3(String resv3) {
        this.resv3 = resv3 == null ? null : resv3.trim();
    }
}