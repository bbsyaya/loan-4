package com.hrbb.loan.channel.gboss.obj;

import org.dom4j.Element;

import com.hrbb.loan.pos.util.XmlUtil;

/**
 * 国政通 ： 行驶证抽象.
 * 
 * @author xiongshaogang
 * @version $Id: VehicleInfo.java, v 0.1 2015年4月27日 下午6:19:00 xiongshaogang Exp $
 */
public class VehicleInfo {
    
    private String messageStatus;
    private String messageValue;
    private String code;
    private String message;
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
    
    public String getMessageStatus() {
        return messageStatus;
    }
    public void setMessageStatus(String messageStatus) {
        this.messageStatus = messageStatus;
    }
    public String getMessageValue() {
        return messageValue;
    }
    public void setMessageValue(String messageValue) {
        this.messageValue = messageValue;
    }
    public String getCode() {
        return code;
    }
    public void setCode(String code) {
        this.code = code;
    }
    public String getMessage() {
        return message;
    }
    public void setMessage(String message) {
        this.message = message;
    }
    public String getCphm() {
        return cphm;
    }
    public void setCphm(String cphm) {
        this.cphm = cphm;
    }
    public String getCllx() {
        return cllx;
    }
    public void setCllx(String cllx) {
        this.cllx = cllx;
    }
    public String getSyr() {
        return syr;
    }
    public void setSyr(String syr) {
        this.syr = syr;
    }
    public String getCpxh() {
        return cpxh;
    }
    public void setCpxh(String cpxh) {
        this.cpxh = cpxh;
    }
    public String getZt() {
        return zt;
    }
    public void setZt(String zt) {
        this.zt = zt;
    }
    public String getSyxz() {
        return syxz;
    }
    public void setSyxz(String syxz) {
        this.syxz = syxz;
    }
    public String getCcdjrq() {
        return ccdjrq;
    }
    public void setCcdjrq(String ccdjrq) {
        this.ccdjrq = ccdjrq;
    }
    public String getFzrq() {
        return fzrq;
    }
    public void setFzrq(String fzrq) {
        this.fzrq = fzrq;
    }
    public String getJyyxqz() {
        return jyyxqz;
    }
    public void setJyyxqz(String jyyxqz) {
        this.jyyxqz = jyyxqz;
    }
    public String getDyqk() {
        return dyqk;
    }
    public void setDyqk(String dyqk) {
        this.dyqk = dyqk;
    }
    
    public void parseElement(Element element) {
        Element messageElement = (Element) element.selectSingleNode("message");
        this.setMessageStatus(XmlUtil.getSingleNodeText(messageElement, "status"));
        this.setMessageValue(XmlUtil.getSingleNodeText(messageElement, "value"));
        if ("1".equals(this.getMessageStatus())) {
            return;
        }
        this.setCode(XmlUtil.getSingleNodeText(messageElement, "code"));
        this.setCphm(XmlUtil.getSingleNodeText(element, "cphm"));
        this.setCllx(XmlUtil.getSingleNodeText(element, "cllx"));
        this.setSyr(XmlUtil.getSingleNodeText(element, "syr"));
        this.setCpxh(XmlUtil.getSingleNodeText(element, "cpxh"));
        this.setZt(XmlUtil.getSingleNodeText(element, "zt"));
        this.setSyxz(XmlUtil.getSingleNodeText(element, "syxz"));
        this.setCcdjrq(XmlUtil.getSingleNodeText(element, "ccdjrq"));
        this.setFzrq(XmlUtil.getSingleNodeText(element, "fzrq"));
        this.setJyyxqz(XmlUtil.getSingleNodeText(element, "jyyxqz"));
        this.setDyqk(XmlUtil.getSingleNodeText(element, "dyqk"));
    }
}
